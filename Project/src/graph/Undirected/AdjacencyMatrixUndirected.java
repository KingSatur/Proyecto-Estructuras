package graph.Undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Stack;

import graph.Directed.AdjacencyMatrix;
import graph.Directed.EdgeCompare;
import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import graph.Directed.UnionStructure;

public class AdjacencyMatrixUndirected<V, K extends Comparable<K>> extends AdjacencyMatrix<V, K> {


	

	public AdjacencyMatrixUndirected() {
		super();
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

	@Override
	public void initializeMatrixNode() {
		int x = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++) {

			EdgeSrcEnd e = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(i)),
					super.getNodes().get(keysNodes.get(x)), null, Double.MAX_VALUE);
			matrix[i][x] = e;
			matrix[x][i] = e;

		}
		for (int j = 0; j < matrix.length; j++) {

			EdgeSrcEnd e = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(j)),
					super.getNodes().get(keysNodes.get(x)), null, Double.MAX_VALUE);
			matrix[x][j] = e;
			matrix[j][x] = e;
		}
		matrix[x][x] = new EdgeSrcEnd<K>(super.getNodes().get(keysNodes.get(x)), super.getNodes().get(keysNodes.get(x)),
				null, 0);
	}

	@Override
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight, K keyEdge) {
		int i = indexNodes.get(keyNodeStart);
		int j = indexNodes.get(keyNodeEnd);

		EdgeSrcEnd e = new EdgeSrcEnd<K>(super.getNodes().get(keyNodeStart), super.getNodes().get(keyNodeEnd), keyEdge,
				weight);
		matrix[i][j] = e;
		matrix[j][i] = e;

		super.getGeneralEdges().put(keyEdge, e);
	}

	@Override
	public void removeEdge(K keyEdge) {
		int i = indexNodes.get(super.getGeneralEdges().get(keyEdge).getSrc().getKey());
		int j = indexNodes.get(super.getGeneralEdges().get(keyEdge).getEnd().getKey());
		matrix[i][j].setWeightKey(Double.MAX_VALUE);
		matrix[j][i].setWeightKey(Double.MAX_VALUE);
		super.getGeneralEdges().remove(keyEdge);
	}

	@Override
	public HashMap<K, K> dijsktra(K keyNode) {
		visited = new boolean[matrix.length];
		distance = new double[matrix.length];
//		Node prev[] = new Node[matrix.length];
		fathers = new HashMap<K, K>();
		pathEdges = new HashMap<>();
		pq = new PriorityQueue<EdgeSrcEnd<K>>(new EdgeCompare());

		for (int i = 0; i < matrix.length; i++) {
			distance[i] = matrix[indexNodes.get(keyNode)][i].getWeightKey();
			if (matrix[indexNodes.get(keyNode)][i].getWeightKey() < Double.MAX_VALUE
					&& matrix[indexNodes.get(keyNode)][i].getWeightKey() != 0) {
				pq.add(matrix[indexNodes.get(keyNode)][i]);
				pathEdges.put(matrix[indexNodes.get(keyNode)][i].getKey(), i);
				fathers.put(keysNodes.get(i), keyNode);
			}
		}

		visited[indexNodes.get(keyNode)] = true;
		fathers.put(keyNode, keyNode);
		path.add(keyNode);

		while (pq.size() > 0) {
			EdgeSrcEnd edge = pq.poll();

			int i = pathEdges.get(edge.getKey());
			if (!visited[i]) {
				visited[i] = true;

				path.add(keysNodes.get(i));
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() < Double.MAX_VALUE && !visited[j]) {
						if (distance[j] >= distance[i] + matrix[i][j].getWeightKey()) {
							distance[j] = distance[i] + matrix[i][j].getWeightKey();
							fathers.put(keysNodes.get(j), keysNodes.get(i));
//							prev[j] = super.getNodes().get(keysNodes.get(i));
						}
						pq.add(matrix[i][j]);
						pathEdges.put(matrix[i][j].getKey(), j);
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
		fathers = new HashMap<K, K>();

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

				if (fathers.containsKey((K) e.getEnd().getKey())) {
					fathers.put((K) e.getSrc().getKey(), (K) e.getEnd().getKey());
				} else {
					fathers.put((K) e.getEnd().getKey(), (K) e.getSrc().getKey());
				}
			
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
		fathers = new HashMap<K, K>();
		pathEdges = new HashMap<>();
		pq = new PriorityQueue<EdgeSrcEnd<K>>(new EdgeCompare());

		for (int i = 0; i < matrix.length; i++) {
			distance[i] = matrix[0][i].getWeightKey();
			if (matrix[0][i].getWeightKey() < Double.MAX_VALUE && matrix[0][i].getWeightKey() != 0) {
				pq.add(matrix[0][i]);
				pathEdges.put(matrix[0][i].getKey(), i);
				fathers.put(keysNodes.get(i), keysNodes.get(0));
			}
		}

		visited[0] = true;
		fathers.put(keysNodes.get(0), keysNodes.get(0));
		path.add(keysNodes.get(0));

		while (pq.size() > 0) {
			EdgeSrcEnd edge = pq.poll();

			int i = pathEdges.get(edge.getKey());
			if (!visited[i]) {
				weightPath += edge.getWeightKey();
				visited[i] = true;

				path.add(keysNodes.get(i));
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() < Double.MAX_VALUE && !visited[j]) {
						if (matrix[i][j].getWeightKey() < distance[j]) {
							distance[j] = matrix[i][j].getWeightKey();
							fathers.put(keysNodes.get(j), keysNodes.get(i));
//							prev[j] = super.getNodes().get(keysNodes.get(i));
						}
						pq.add(matrix[i][j]);
						pathEdges.put(matrix[i][j].getKey(), j);
					}
				}

			}
		}

		return fathers;

	}

	public static void main(String[] args) {
		AdjacencyMatrixUndirected<Integer, Integer> adjM = new AdjacencyMatrixUndirected<Integer, Integer>();
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
//		Node<Integer, Integer> n4 = new Node<>(4, 4);
//		Node<Integer, Integer> n5 = new Node<>(5, 5);
//		Node<Integer, Integer> n6 = new Node<>(6, 6);
		adjM.addNode(n1);
		adjM.addNode(n2);
		adjM.addNode(n3);
//		adjM.addNode(n4);
//		adjM.addNode(n5);
//		adjM.addNode(n6);
		
		
//		simpleUndirectedGraph.addEdge(1, 2, 6, 1);
//		simpleUndirectedGraph.addEdge(1, 3, 2, 2);
//		simpleUndirectedGraph.addEdge(3, 2, 3, 3);
		
		adjM.addEdge(1, 2, 6, 1);
		adjM.addEdge(1, 3, 2, 2);
		adjM.addEdge(3, 2, 3, 3);
//		adjM.addEdge(2, 4, 6, 4);
//		adjM.addEdge(4, 6, 2, 5);
//		adjM.addEdge(3, 5, 4, 6);
//		adjM.addEdge(5, 6, 2, 7);
//		adjM.addEdge(1, 2, 7, 1);
//		adjM.addEdge(2, 3, 3, 2);
//		adjM.addEdge(3, 4, 2, 3);
//		adjM.addEdge(4, 1, 1, 4);
//		adjM.addEdge(3, 5, 4, 5);
//		adjM.addEdge(5, 1, 6, 7);
//		adjM.addEdge(5, 2, 5, 8);

		adjM.imprimir();

//		HashMap<Integer, Integer> n = adjM.bfs(6);
//		for (Integer k : n.keySet()) {
//			System.out.print(k + "," + n.get(k)+ " | ");
//		}

		// Prueba para Dijsktra
		HashMap<Integer, Integer> n = adjM.dijsktra(1);
		for (Integer k : n.keySet()) {
			System.out.print(k + "," + n.get(k) + " | ");
		}
		System.out.println();
		for (int j = 0; j < adjM.path.size(); j++) {
			System.out.print(adjM.path.get(j) + " | ");
		}
		
//		

		// Prueba para Floyd Warshall
//		EdgeSrcEnd[][] matrixClone = adjM.floydWarshall();
//		System.out.println();
//		for (int i = 0; i < matrixClone.length; i++) {
//			for (int j = 0; j < matrixClone.length; j++) {
//				if (matrixClone[i][j].getWeightKey() != Double.MAX_VALUE) {
//					System.out.print("|" + matrixClone[i][j].getWeightKey() + "|");
//				} else {
//					System.out.print("|" + " - " + "|");
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
//		for (int j = 0; j < adjM.path.size(); j++) {
//		System.out.print(adjM.path.get(j) + " | ");
//	}

//		Prueba Kruskal
//		HashMap<Integer, Integer> answer = adjM.kruscal();
//		for (Integer k : answer.keySet()) {
//			System.out.print(k + "," + answer.get(k) + " | ");
//		}
//		for (int j = 0; j < adjM.path.size(); j++) {
//			System.out.print(adjM.path.get(j) + " | ");
//		}
		

	}

}
