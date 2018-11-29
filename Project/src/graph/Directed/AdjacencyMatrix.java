package graph.Directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JEditorPane;

import Interface.iGraphMatrix;
import dataStructures.Abstract;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;


public class AdjacencyMatrix<V, K extends Comparable<K>> extends Graph<V, K> implements iGraphMatrix<V, K> {

	protected EdgeSrcEnd<K>[][] matrix;
	protected HashMap<K, Integer> indexNodes; // guardo el indice de cada llave de cada nodo
	protected HashMap<Integer, K> keysNodes; // guardo la llave del nodo con cada indice
	
	//GENERAL
	protected boolean[] visited;
	protected ArrayList<K> path;
	protected HashMap<K, K> fathers;
	
	//dfs y bfs
	protected InterfaceCampiStack<K> stack;
	protected InterfaceCampiQueue<pathFathers<K>> queue;
	
	
	//Dijkstra
	protected double[] distance;
	protected PriorityQueue<EdgeSrcEnd<K>> pq;
	
	//Kruskal
	protected UnionStructure<V, K> union;
	
	//Floyd
	protected  EdgeSrcEnd[][] aux;
	
	protected double weightPath;
	
	protected HashMap<K, Integer> pathEdges;
	

	public AdjacencyMatrix() {
		super();
		this.matrix = new EdgeSrcEnd[0][0];
		indexNodes = new HashMap<>();
		keysNodes = new HashMap<>();
		path = new ArrayList<K>();
		initializeMatrix();
		weightPath = 0;
	}
	

	public EdgeSrcEnd<K>[][] getMatrix() {
		return matrix;
	}

	public HashMap<K, Integer> getIndexNodes() {
		return indexNodes;
	}


	public HashMap<Integer, K> getKeysNodes() {
		return keysNodes;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public ArrayList<K> getPath() {
		return path;
	}

	public HashMap<K, K> getFathers() {
		return fathers;
	}




	public double[] getDistance() {
		return distance;
	}

	public PriorityQueue<EdgeSrcEnd<K>> getPq() {
		return pq;
	}

	public UnionStructure<V, K> getUnion() {
		return union;
	}

	public EdgeSrcEnd[][] getAux() {
		return aux;
	}

	public double getWeightPath() {
		return weightPath;
	}
	

	public HashMap<K, Integer> getPathEdges() {
		return pathEdges;
	}

	private void initializeMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == null) {
					matrix[i][j] = new EdgeSrcEnd<K>(null, null, null,Double.MAX_VALUE);
				}
			}
		}
	}

	@Override
	public void addNode(Node<V, K> newNode) {
		super.getNodes().put(newNode.getKey(), newNode);
		EdgeSrcEnd[][] aux = new EdgeSrcEnd[matrix.length + 1][matrix.length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				aux[i][j] = matrix[i][j];
			}
		}
		this.indexNodes.put(newNode.getKey(), super.getNodes().size() - 1);
		this.keysNodes.put(super.getNodes().size() - 1, newNode.getKey());
		matrix = aux;
		initializeMatrixNode();
	}
	public void initializeMatrixNode() {
		int x = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][x] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(i)),
					super.getNodes().get(keysNodes.get(x)), null, Double.MAX_VALUE);
		}
		for (int j = 0; j < matrix.length; j++) {
			matrix[x][j] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(j)),
					super.getNodes().get(keysNodes.get(x)), null, Double.MAX_VALUE);
		}
		matrix[x][x] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(x)), super.getNodes().get(keysNodes.get(x)),
				null, 0);
	}

	@Override
	public void removeNode(K keyNode) {
		super.getNodes().remove(keyNode);
		
		int index = this.indexNodes.get(keyNode);
		for (int i = 0; i < matrix.length; i++) {
			super.getGeneralEdges().remove(matrix[index][i].getKey());
		}
		for (int i = 0; i < matrix.length; i++) {
			super.getGeneralEdges().remove(matrix[i][index].getKey());
		}

		EdgeSrcEnd[][] aux = new EdgeSrcEnd[matrix.length - 1][matrix.length - 1];
		int x = 0;
		int z = 0;
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				if (index != matrix.length - 1) {
					if (i >= index) {
						x = i + 1;
					} else {
						x = i;
					}
					if (j >= index) {
						z = j + 1;
					} else {
						z = j;
					}
					aux[i][j] = matrix[x][z];
				} else {
					if (i != index || j != index) {
						aux[i][j] = matrix[i][j];
					}
				}
			}
		}
		matrix = aux;
		this.indexNodes.remove(keyNode);
		this.keysNodes.remove(index);	
		
		int i = 0;
		for(K key : super.getNodes().keySet()) {
			indexNodes.put(key, i);
			keysNodes.put(i, key);
			i++;
		}
	}

	@Override
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight, K keyEdge) {
		int i = indexNodes.get(keyNodeStart);
		int j = indexNodes.get(keyNodeEnd);

		EdgeSrcEnd e = new EdgeSrcEnd<K>(super.getNodes().get(keyNodeStart), super.getNodes().get(keyNodeEnd), keyEdge,weight);
		matrix[i][j] = e;

		super.getGeneralEdges().put(keyEdge, e);
	}

	@Override
	public void removeEdge(K keyEdge) {

		int i = indexNodes.get(super.getGeneralEdges().get(keyEdge).getSrc().getKey());
		int j = indexNodes.get(super.getGeneralEdges().get(keyEdge).getEnd().getKey());
		matrix[i][j].setWeightKey(Double.MAX_VALUE);
		super.getGeneralEdges().remove(keyEdge);
	}

	@Override
	public HashMap<K, K> dfs(K keyNode) {

		path = new ArrayList<>();
		visited = new boolean[matrix.length];
		fathers = new HashMap<K, K>(matrix.length);
		stack = new Abstract<K>();
		stack.push(keyNode);
		fathers.put(keyNode, keyNode);

		while (!stack.isEmpty()) {
			K key = stack.pop();
			if (!visited[indexNodes.get(key)]) {
				path.add(key);
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[indexNodes.get(key)][j].getWeightKey() != Double.MAX_VALUE && matrix[indexNodes.get(key)][j].getWeightKey() != 0.0) {
						K keyNeighbor = keysNodes.get(j);
						if (!visited[j]) {
							stack.push(keyNeighbor);
							fathers.put(keyNeighbor, key);
						}
					}
				}
				visited[indexNodes.get(key)] = true;
			}
		}
		return fathers;
	}

	@Override
	public HashMap<K, K> bfs(K keyNode) {
		path.clear();
		visited = new boolean[matrix.length];
		fathers = new HashMap<K, K>(matrix.length);
		queue = new Abstract<pathFathers<K>>();
		
		
		queue.enqueue(new pathFathers<K>(keyNode, keyNode));
		fathers.put(keyNode, keyNode);
		while (!queue.isEmpty()) {
			pathFathers key = queue.dequeue();
			if(!visited[indexNodes.get(key.getKeyNode())]) {
				path.add((K) key.getKeyNode());
				fathers.put((K)key.getKeyNode(), (K)key.getKeyFather());
				
				visited[indexNodes.get(key.getKeyNode())] = true;
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[indexNodes.get(key.getKeyNode())][j].getWeightKey() < Double.MAX_VALUE
							&& matrix[indexNodes.get(key.getKeyNode())][j].getWeightKey() != 0.0) {
						K keyNeighbor = keysNodes.get(j);
						if (!visited[j]) {
							queue.enqueue(new pathFathers<K>((K)keyNeighbor,(K) key.getKeyNode()));
//							fathers.put(keyNeighbor, key);
						}
					}
				}
//				visited[indexNodes.get(key)] = true;
			}
		}
		return fathers;
	}

	@Override
	public HashMap<K, K> dijsktra(K keyNode) {
		
		visited = new boolean[matrix.length];
		distance = new double[matrix.length];
//		Node prev[] = new Node[matrix.length];
		fathers = new HashMap<K,K>();
		pq = new PriorityQueue<EdgeSrcEnd<K>>(new EdgeCompare());

		for (int i = 0; i < matrix.length; i++) {
			distance[i] = matrix[indexNodes.get(keyNode)][i].getWeightKey();
			if (matrix[indexNodes.get(keyNode)][i].getWeightKey() < Double.MAX_VALUE && matrix[indexNodes.get(keyNode)][i].getWeightKey() != 0) {
				pq.add(matrix[indexNodes.get(keyNode)][i]);
			}
		}
		
		visited[indexNodes.get(keyNode)] = true;
		fathers.put(keyNode, keyNode);
		path.add(keyNode);
		while (pq.size() > 0) {
			EdgeSrcEnd edge = pq.poll();
			int i = indexNodes.get(edge.getEnd().getKey());
			if (!visited[i]) {
				visited[i] = true;
				fathers.put((K) edge.getEnd().getKey() ,  (K) edge.getSrc().getKey() );
				path.add((K) edge.getEnd().getKey());
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() < Double.MAX_VALUE && !visited[j]) {
						if (distance[j] >= distance[i] + matrix[i][j].getWeightKey()) {
							distance[j] = distance[i] + matrix[i][j].getWeightKey();
//							prev[j] = super.getNodes().get(keysNodes.get(i));
						}
						pq.add(matrix[i][j]);
					}
				}

			}
		}

		return fathers;
	}

	@Override
	public HashMap<K, K> kruscal() {

		distance = new double[matrix.length];
		union = new UnionStructure<V, K>();
		pq = new PriorityQueue<>();
		pq.addAll(super.getGeneralEdges().values());
		fathers = new HashMap<K,K>();
		
		for (K key : super.getNodes().keySet()) {
			union.getNodesUbication().put(key, key);
			union.getNodesHash().put(key, new Hashtable<K, Node<V, K>>());
		}
		int aux = 0;
		int i = 0;
		while (aux < (matrix.length - 1) && i < super.getGeneralEdges().size()) {
			EdgeSrcEnd<K> e = pq.poll();
			K x = (K) union.find(e.getSrc());
			K y = (K) union.find(e.getEnd());
			int z = x.compareTo(y);
			if (z != 0) {
				fathers.put((K)e.getEnd().getKey(), (K) e.getSrc().getKey());
				aux++;
				union.union(e.getSrc(), e.getEnd());
			}
		}
		return fathers;
	}

	@Override
	public HashMap<K, K> prim() {

		weightPath = 0;
		visited = new boolean[matrix.length];
		distance = new double[matrix.length];
//		Node prev[] = new Node[matrix.length];
		pq = new PriorityQueue<EdgeSrcEnd<K>>(new EdgeCompare());
		fathers = new HashMap<K,K>();

		for (int i = 0; i < matrix.length; i++) {
			distance[i] = matrix[0][i].getWeightKey();
			if (matrix[0][i].getWeightKey() < Double.MAX_VALUE && matrix[0][i].getWeightKey() != 0) {
				pq.add(matrix[0][i]);
//				prev[i] = super.getNodes().get(keysNodes.get(0));
			}
		}

		visited[0] = true;
//		prev[0] = super.getNodes().get(keysNodes.get(0));
		fathers.put(keysNodes.get(0), keysNodes.get(0));

		while (pq.size() > 0) {
			EdgeSrcEnd edge = pq.poll();
			int i = indexNodes.get(edge.getEnd().getKey());
			if (!visited[i]) {
				weightPath +=  edge.getWeightKey();	
				visited[i] = true;
				fathers.put((K) edge.getEnd().getKey() ,  (K) edge.getSrc().getKey() );
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() < Double.MAX_VALUE && !visited[j]) {
						if (matrix[i][j].getWeightKey() < distance[j]) {
							distance[j] = matrix[i][j].getWeightKey();
//							prev[j] = super.getNodes().get(keysNodes.get(i));
						}
						pq.add(matrix[i][j]);
					}
				}
			}
		}
		
		return fathers;
	}

	@Override
	public EdgeSrcEnd[][] floydWarshall() {

		aux = matrix.clone();
		for (int k = 0; k < matrix.length; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (aux[i][k].getWeightKey() < Double.MAX_VALUE && aux[k][j].getWeightKey() < Double.MAX_VALUE) {
						aux[i][j].setWeightKey(Math.min(aux[i][j].getWeightKey(),
								(aux[i][k].getWeightKey() + aux[k][j].getWeightKey())));
					}
				}
			}
		}

		return aux;

	}

	public void imprimir() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j].getWeightKey() != Double.MAX_VALUE) {
					System.out.print("|" + matrix[i][j].getWeightKey() + "|");
				} else {
					System.out.print("|" + " - " + "|");
				}
			}
			System.out.println();
		}
	}
	
	
	static class pathFathers<K>{
		
		private K keyNode;
		private K keyFather;
		
		public pathFathers(K keyNode, K keyFather) {
			this.keyNode = keyNode;
			this.keyFather = keyFather;
		}

		public K getKeyNode() {
			return keyNode;
		}

		public void setKeyNode(K keyNode) {
			this.keyNode = keyNode;
		}

		public K getKeyFather() {
			return keyFather;
		}

		public void setKeyFather(K keyFather) {
			this.keyFather = keyFather;
		}
		
	}

	public static void main(String[] args) {
//		AdjacencyMatrix<Integer, Integer> adjM = new AdjacencyMatrix<>();
//
//		Node<Integer, Integer> n1 = new Node<>(1, 1);
//		Node<Integer, Integer> n2 = new Node<>(2, 2);
//		Node<Integer, Integer> n3 = new Node<>(3, 3);
//		Node<Integer, Integer> n4 = new Node<>(4, 4);
//		Node<Integer, Integer> n5 = new Node<>(5, 5);
//		Node<Integer, Integer> n6 = new Node<>(6, 6);
//
//		adjM.addNode(n1);
//		adjM.addNode(n2);
//		adjM.addNode(n3);
//		adjM.addNode(n4);
//		adjM.addNode(n5);
//		adjM.addNode(n6);
//
//		adjM.addEdge(1, 3, 1, 1);
//		adjM.addEdge(1, 2, 2, 2);
//		adjM.addEdge(3, 4, 3, 3);
//		adjM.addEdge(2, 4, 6, 4);
//		adjM.addEdge(4, 6, 2, 5);
//		adjM.addEdge(3, 5, 4, 6);
//		adjM.addEdge(5, 6, 2, 7);
		
		AdjacencyMatrix<Integer, Integer>  graphMatrix = new AdjacencyMatrix<Integer, Integer>();
		Node<Integer,Integer> n1 = new Node<Integer,Integer>(1,1);
		Node<Integer,Integer> n2 = new Node<Integer,Integer>(2,2);
		Node<Integer,Integer> n3 = new Node<Integer,Integer>(3,3);
//		Node<Integer,Integer> n4 = new Node<Integer,Integer>(4,4);
//		Node<Integer,Integer> n5 = new Node<Integer, Integer>(5,5);
		graphMatrix.addNode(n1);
		graphMatrix.addNode(n2);
		graphMatrix.addNode(n3);
//		graphMatrix.addNode(n4);
//		graphMatrix.addNode(n5);
		
//		graphMatrix.addEdge(1, 2, 1, 1);
//		graphMatrix.addEdge(1, 5, 2, 21);
//		graphMatrix.addEdge(2, 5, 3, 80);
//		graphMatrix.addEdge(2, 4, 5, 5);
//		graphMatrix.addEdge(3, 2, 7, 40);
//		graphMatrix.addEdge(3, 1, 37, 60);
//		graphMatrix.addEdge(4, 1, 2, 30);
//		graphMatrix.addEdge(4, 3, 19, 70);
//		graphMatrix.addEdge(5, 4, 13, 4);
//		graphMatrix.addEdge(5, 3, 6, 3);	

		graphMatrix.addEdge(1, 2, 7, 1);
		graphMatrix.addEdge(2, 3, 3, 2);
		graphMatrix.addEdge(3, 1, 2, 3);
//		adjM.addEdge(4, 1, 1, 4);
//		adjM.addEdge(3, 5, 4, 5);
//		adjM.addEdge(5, 1, 6, 7);
//		adjM.addEdge(5, 2, 5, 8);
//		

		graphMatrix.imprimir();

//		Prueba para dfs y bfs
//		HashMap<Integer, Integer> n = graphMatrix.bfs(1);
//		for (Integer k : n.keySet()) {
//			System.out.print(k + "," + n.get(k)+ " | ");
//		}
//		System.out.println();
//		for (int j = 0; j < graphMatrix.path.size(); j++) {
//			System.out.print(graphMatrix.path.get(j) + " | ");
//		}

		// Prueba para Dijsktra
//		HashMap<Integer, Integer> hash = graphMatrix.dijsktra(1);			
//		for (Integer k :  hash.keySet()) {
//			System.out.print(k + "," + hash.get(k)+ " | ");
//		}
//		System.out.println();
//		for (int j = 0; j < graphMatrix.path.size(); j++) {
//			System.out.print(graphMatrix.path.get(j) + " | ");
//		}
		
		
		// Prueba para Floyd Warshall
//		EdgeSrcEnd[][] matrixClone = graphMatrix.floydWarshall();
//		for (int i = 0; i < matrixClone.length; i++) {
//			for (int j = 0; j < matrixClone.length; j++) {
//				if (matrixClone[i][j].getWeightKey() != Double.MAX_VALUE  ) {
//					System.out.print("|   " + matrixClone[i][j].getWeightKey() +  "   |");
//				} else {
//					System.out.print("|" + "   -   " + "|");
//				}
//			}
//			System.out.println();
//		}

		// Prueba para prim
//		HashMap<Integer, Integer> hash = adjM.prim();
//		for (Integer k : hash.keySet()) {	
//			System.out.print(k + "," + hash.get(k)+ " | ");;
//		}
//		System.out.println(" ");
//		System.out.println(adjM.weightPath);

//		Prueba Kruskal
		HashMap<Integer, Integer> answer= graphMatrix.kruscal();
		for (Integer k : answer.keySet()) {
			System.out.print(k + "," + answer.get(k)+ " | ");
		}
		
		
		
		
		
		
		
		

	}

}