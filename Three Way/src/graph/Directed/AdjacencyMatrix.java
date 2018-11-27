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

public class AdjacencyMatrix<V, K extends Comparable<K>> extends Graph<V, K> implements iGraphMatrix<V, K> {

	protected EdgeSrcEnd<K>[][] matrix;
	protected HashMap<K, Integer> indexNodes; // guardo el indice de cada llave de cada nodo
	protected HashMap<Integer, K> keysNodes; // guardo la llave del nodo con cada indice
	
	
	public AdjacencyMatrix(int numberNodes) {
		super();
		this.matrix = new EdgeSrcEnd[numberNodes][numberNodes];
		indexNodes = new HashMap<>();
		keysNodes = new HashMap<>();
		initializeMatrix();

	}

	public EdgeSrcEnd[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(EdgeSrcEnd[][] matrix) {
		this.matrix = matrix;
	}

	private void initializeMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == null) {
					matrix[i][j] = new EdgeSrcEnd<K>(null, null, null, Double.MAX_VALUE);
				}
			}
		}
	}

	protected void initializeMatrixNode() {
		int x = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][x] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(i)),
					super.getNodes().get(keysNodes.get(x)), null, Double.MAX_VALUE);
		}
		for (int j = 0; j < matrix.length; j++) {
			matrix[x][j] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(j)),
					super.getNodes().get(keysNodes.get(x)), null, Double.MAX_VALUE);
			;
		}
		matrix[x][x] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(x)), super.getNodes().get(keysNodes.get(x)),null, 0);
		
	}

	@Override
	public ArrayList<Node> dfs(K keyNode) {

		
		boolean visited[] = new boolean[matrix.length];
		ArrayList<Node> path = new ArrayList<Node>(matrix.length);
		Stack<K> stack = new Stack<K>();
		stack.add(keyNode);

		while (!stack.isEmpty()) {
			K key = stack.pop();
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[indexNodes.get(key)][j].getWeightKey() != Double.MAX_VALUE && matrix[indexNodes.get(key)][j].getWeightKey() != 0.0) {
					K keyNeighbor = keysNodes.get(j);
					if (!visited[j]) {
						stack.add(keyNeighbor);
					}
				}
			}
			if(!visited[indexNodes.get(key)]) {
				path.add(super.getNodes().get(key));				
				visited[indexNodes.get(key)] = true;
			}
		}
		
		return path;

	}

	@Override
	public ArrayList<Node> bfs(K keyNode) {
		boolean visited[] = new boolean[matrix.length];
		ArrayList<Node> path = new ArrayList<Node>(matrix.length);
		Queue<K> queue = new LinkedList<K>();
		queue.add(keyNode);
		while (!queue.isEmpty()) {
			K key = queue.remove();

			for (int j = 0; j < matrix.length; j++) {
				if (matrix[indexNodes.get(key)][j].getWeightKey() < Double.MAX_VALUE && matrix[indexNodes.get(key)][j].getWeightKey() != 0.0) {
					K keyNeighbor = keysNodes.get(j);
					if (!visited[j]) {
						queue.add(keyNeighbor);
					}
				}
			}
			if(!visited[indexNodes.get(key)]) {
				path.add(super.getNodes().get(key));				
				visited[indexNodes.get(key)] = true;
			}
		}

		return path;
	}

	
	@Override
	public double[] dijsktra(K keyNode) {
		boolean visited[] = new boolean[matrix.length];
		double[] distance = new double[matrix.length];
		Node prev[] = new Node[matrix.length];
		
		PriorityQueue< EdgeSrcEnd<K> > pq= new PriorityQueue<EdgeSrcEnd<K>>(new EdgeCompare());
		
		for (int i = 0; i < matrix.length; i++) {
			distance[i] = matrix[indexNodes.get(keyNode)][i].getWeightKey();
			if(matrix[indexNodes.get(keyNode)][i].getWeightKey() < Double.MAX_VALUE && matrix[indexNodes.get(keyNode)][i].getWeightKey() != 0) {
				pq.add(matrix[indexNodes.get(keyNode)][i]);
			}
		}
		
		visited[indexNodes.get(keyNode)] = true;
		
		while(pq.size()>0) {
			EdgeSrcEnd edge = pq.poll();
			int i = indexNodes.get(edge.getEnd().getKey());
			if (!visited[i]) {
				visited[i] = true;
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() < Double.MAX_VALUE   && !visited[j]) {
						if (distance[j] >= distance[i] + matrix[i][j].getWeightKey()) {
							distance[j] = distance[i] + matrix[i][j].getWeightKey();
							prev[j] = super.getNodes().get(keysNodes.get(i));
						}
						pq.add(matrix[i][j]);
					}
				}

			}
		}	
		
		return distance;
	}

	@Override
	public EdgeSrcEnd[] kruscal() {


		double[] distance = new double[matrix.length];
		UnionStructure<V,K> union = new UnionStructure<V,K>();
		EdgeSrcEnd [] answer = new EdgeSrcEnd[matrix.length-1];
		
		PriorityQueue<EdgeSrcEnd<K>> pq = new PriorityQueue<>();
		pq.addAll(super.getGeneralEdges().values());
		
		for(K key: super.getNodes().keySet()) {
			union.getNodesUbication().put(key, key);
			union.getNodesHash().put(key, new Hashtable<K, Node<V,K>>());
		}
		

		int aux = 0;
		int i = 0;

		while(  aux<(matrix.length-1) && i < super.getGeneralEdges().size()   ) {
			
			EdgeSrcEnd<K> e = pq.poll();
			K x = (K) union.find(e.getSrc());
			K y = (K) union.find(e.getEnd());
			
			int z = x.compareTo(y);
			
			if( z != 0 ){
	            answer[aux] = e;
	            aux++;
	            union.union(e.getSrc(), e.getEnd());
			}
		}
		
		return answer;
	
	}

	@Override
	public double[] prim() {

		boolean visited[] = new boolean[matrix.length];
		double[] distance = new double[matrix.length];
		Node prev[] = new Node[matrix.length];
		PriorityQueue< EdgeSrcEnd<K> > pq= new PriorityQueue<EdgeSrcEnd<K>>(new EdgeCompare());
		
		for (int i = 0; i < matrix.length; i++) {
			distance[i] = matrix[0][i].getWeightKey();
			if(matrix[0][i].getWeightKey() < Double.MAX_VALUE && matrix[0][i].getWeightKey() != 0) {
				pq.add(matrix[0][i]);
				prev[i] = super.getNodes().get(keysNodes.get(0));
			}
		}
		
		visited[0] = true;
		prev[0] = super.getNodes().get(keysNodes.get(0));
		
		while(pq.size()>0) {
			EdgeSrcEnd edge = pq.poll();
			int i = indexNodes.get(edge.getEnd().getKey());
			if (!visited[i]) {
				visited[i] = true;
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() < Double.MAX_VALUE   && !visited[j]) {
						if (matrix[i][j].getWeightKey() < distance[j]) {
							distance[j] =  matrix[i][j].getWeightKey();
							prev[j] = super.getNodes().get(keysNodes.get(i));
						}
						pq.add(matrix[i][j]);
					}
				}

			}
			
		}	
		
		return distance;
	}
	


	@Override
	public EdgeSrcEnd[][] floydWarshall() {

		EdgeSrcEnd<K>[][] aux = matrix.clone();
		for (int k = 0; k < matrix.length; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (aux[i][k].getWeightKey() < Double.MAX_VALUE && aux[k][j].getWeightKey() < Double.MAX_VALUE) {
						aux[i][j].setWeightKey(Math.min(aux[i][j].getWeightKey(), (aux[i][k].getWeightKey() + aux[k][j].getWeightKey())));
					}
				}
			}
		}

		return aux;

	}

	@Override
	public void addNode(Node<V, K> newNode) {
		super.getNodes().put(newNode.getKey(), newNode);

		EdgeSrcEnd[][] aux = new  EdgeSrcEnd[matrix.length + 1][matrix.length + 1];

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

	@Override
	public void removeNode(K keyNode) {
		super.getNodes().remove(keyNode);

		int index = this.indexNodes.get(keyNode);
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

	}

	@Override
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight, K keyEdge) {
		int i = indexNodes.get(keyNodeStart);
		int j = indexNodes.get(keyNodeEnd);
		
		EdgeSrcEnd e = new EdgeSrcEnd<K>(super.getNodes().get(keyNodeStart),super.getNodes().get(keyNodeEnd), keyEdge, weight);
		matrix[i][j] = e;

		super.getGeneralEdges().put(keyEdge, e);
	}

	@Override
	public void removeEdge(K keyEdge) {
		super.getGeneralEdges().remove(keyEdge);

		int i = indexNodes.get(super.getGeneralEdges().get(keyEdge).getSrc().getKey());
		int j = indexNodes.get(super.getGeneralEdges().get(keyEdge).getEnd().getKey());
		matrix[i][j].setWeightKey(Double.MAX_VALUE);
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

	public static void main(String[] args) {
		AdjacencyMatrix<Integer, Integer> adjM = new AdjacencyMatrix<>(0);

		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
//		Node<Integer, Integer> n6 = new Node<>(6, 6);

		adjM.addNode(n1);
		adjM.addNode(n2);
		adjM.addNode(n3);
		adjM.addNode(n4);
		adjM.addNode(n5);
//		adjM.addNode(n6);

//		adjM.addEdge(1, 3, 1, 1);
//		adjM.addEdge(1, 2, 2, 2);
//		adjM.addEdge(3, 4, 3, 3);
//		adjM.addEdge(2, 4, 6, 4);
//		adjM.addEdge(4, 6, 2, 5);
//		adjM.addEdge(3, 5, 4, 6);
//		adjM.addEdge(5, 6, 2, 7);
		
		adjM.addEdge(1, 2, 7, 1);
		adjM.addEdge(2, 3, 3, 2);
		adjM.addEdge(3, 4, 2, 3);
		adjM.addEdge(4, 1, 1, 4);
		adjM.addEdge(3, 5, 4, 5);
		adjM.addEdge(5, 1, 6, 7);
		adjM.addEdge(5, 2, 5, 8);
		
		
		adjM.imprimir();
		
		
		ArrayList<Node> n = adjM.dfs(5);
		for (int i = 0; i < n.size(); i++) {
			System.out.print(n.get(i).getValue()+" ");
		}
		
		
		// Prueba para Dijsktra
//		double[] array = adjM.dijsktra(6);			
//		for(int i=0; i<array.length ; i++) {
//			System.out.print(array[i]+ "  ");
//		}
//
//		System.out.println();
		

		// Prueba para Floyd Warshall
//		EdgeSrcEnd[][] matrixClone = adjM.floydWarshall();
//		for (int i = 0; i < matrixClone.length; i++) {
//			for (int j = 0; j < matrixClone.length; j++) {
//				if (matrixClone[i][j].getWeightKey() != Double.MAX_VALUE  ) {
//					System.out.print("|" + matrixClone[i][j].getWeightKey() + "|");
//				} else {
//					System.out.print("|" + " - " + "|");
//				}
//			}
//			System.out.println();
//		}

		// Prueba para prim	
//		double[] n = adjM.prim();
//		double suma = 0;
//		for (int i = 0; i < n.length; i++) {
//			suma+=n[i];	
//			System.out.print(n[i]+ " ");
//		}
//		System.out.println(" ");
//		System.out.println(suma);
		
//		Prueba Kruskal
//		EdgeSrcEnd[] answer= adjM.kruscal();
//		for (int i = 0; i < answer.length; i++) {
//			System.out.print(answer[i].getWeightKey()+" ");
//		}

	}

}