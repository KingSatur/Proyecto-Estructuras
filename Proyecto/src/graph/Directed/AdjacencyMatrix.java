package graph.Directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import Interface.iGraphMatrix;

public class AdjacencyMatrix<V, K extends Comparable<K>> extends Graph<V, K> implements iGraphMatrix<V, K> {

	private int[][] matrix;
	private HashMap<K, Integer> index; // guardo el indice de cada llave de cada nodo
	private HashMap<Integer, K> keys; // guardo la llave del nodo con cada indice

	public AdjacencyMatrix(int numberNodes) {
		super();
		this.matrix = new int[numberNodes][numberNodes];

		index = new HashMap<>();
		keys = new HashMap<>();

		initializeMatrix();

	}

	private void initializeMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {

				if (matrix[i][j] == 0)
					matrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private void initializeMatrixNode() {

		int x = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][x] = Integer.MAX_VALUE;
		}

		for (int j = 0; j < matrix.length; j++) {
			matrix[x][j] = Integer.MAX_VALUE;
		}

		matrix[x][x] = 0;

	}

	@Override
	public void dfs(K keyNode) {

		boolean visited[] = new boolean[matrix.length];

		visited[index.get(keyNode)] = true;
		Stack<K> stack = new Stack<K>();
		stack.add(keyNode);

		while (!stack.isEmpty()) {
			K key = stack.pop();

			for (int j = 0; j < matrix.length; j++) {
				if (matrix[index.get(key)][j] != Integer.MAX_VALUE) {
					K keyNeighbor = keys.get(j);
					if (!visited[j]) {
						stack.add(keyNeighbor);
					}
				}
			}
			visited[index.get(key)] = true;
		}

	}

	@Override
	public void bfs(K keyNode) {
		boolean visited[] = new boolean[matrix.length];

		visited[index.get(keyNode)] = true;
		Queue<K> queue = new LinkedList<K>();
		queue.add(keyNode);
		while (!queue.isEmpty()) {
			K key = queue.remove();

			for (int j = 0; j < matrix.length; j++) {
				if (matrix[index.get(key)][j] != Integer.MAX_VALUE) {
					K keyNeighbor = keys.get(j);
					if (!visited[j]) {
						queue.add(keyNeighbor);
					}
				}
			}
			visited[index.get(key)] = true;
		}

	}

	@Override
	public int[] dijsktra(K keyNode) {
		boolean visited[] = new boolean[matrix.length]; // Estructura auxiliar para marcar los nodos visitados
		int[] distance = new int[matrix.length]; // Estructura auxiliar para llevar las distancias a cada nodo
		Node prev[] = new Node[matrix.length]; // Estructura auxiliar para almacenar las rutas

		PriorityQueue<K> pq = new PriorityQueue<K>();

		pq.add(keyNode);// se inserta a la cola el nodo Inicial.

		distance = matrix[index.get(keyNode)].clone();

		prev[index.get(keyNode)] = super.getNodes().get(keyNode);

		while (pq.size() > 0) {
			K keyNodeActual = pq.poll();
			int i = index.get(keyNodeActual);
			if (!visited[i]) {
				visited[i] = true;
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] != Integer.MAX_VALUE && !visited[j]) {
						if(distance[j] >= distance[i]+matrix[i][j]) {
							distance[j] = distance[i]+matrix[i][j];
							prev[j] = super.getNodes().get(keys.get(i));
						}
						pq.add(keys.get(j));							
					}
				}

			}
		}

		return distance;
	}

	@Override
	public void kruscal() {

	}

	@Override
	public void prim() {

	}

	@Override
	public int[][] floydWarshall() {

		int[][] aux = matrix.clone();
		for (int k = 0; k < matrix.length; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					
					if(aux[i][k]!= Integer.MAX_VALUE && aux[k][j] != Integer.MAX_VALUE) {
						aux[i][j] = Math.min(aux[i][j], (aux[i][k] + aux[k][j]));						
					}
				}
			}
		}

		return aux;

	}

	@Override
	public void addNode(Node<V, K> newNode) {
		super.getNodes().put(newNode.getKey(), newNode);

		int[][] aux = new int[matrix.length + 1][matrix.length + 1];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				aux[i][j] = matrix[i][j];
			}
		}

		this.index.put(newNode.getKey(), super.getNodes().size() - 1);
		this.keys.put(super.getNodes().size() - 1, newNode.getKey());
		matrix = aux;


		initializeMatrixNode();
	}

	@Override
	public void removeNode(K keyNode) {
		super.getNodes().remove(keyNode);

		int index = this.index.get(keyNode);
		int[][] aux = new int[matrix.length - 1][matrix.length - 1];

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

		this.index.remove(keyNode);
		this.keys.remove(index);

	}

	@Override
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight) {
		int i = index.get(keyNodeStart);
		int j = index.get(keyNodeEnd);
		matrix[i][j] = (int) weight;
	}

	@Override
	public void removeEdge(K keyNodeStart, K keyNodeEnd) {
		int i = index.get(keyNodeStart);
		int j = index.get(keyNodeEnd);
		matrix[i][j] = Integer.MAX_VALUE;
	}

	public void imprimir() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				
				
				if (matrix[i][j] != Integer.MAX_VALUE) {
					
					System.out.print("|" + matrix[i][j] + "|");
				} else {
					System.out.print("|" + "-" + "|");
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
		Node<Integer, Integer> n6 = new Node<>(6, 6);

		adjM.addNode(n1);
		adjM.addNode(n2);
		adjM.addNode(n3);
		adjM.addNode(n4);
		adjM.addNode(n5);
		adjM.addNode(n6);

		adjM.addEdge(1, 3, 1);
		adjM.addEdge(1, 2, 2);
		adjM.addEdge(3, 4, 3);
		adjM.addEdge(2, 4, 6);
		adjM.addEdge(4, 6, 2);
		adjM.addEdge(3, 5, 4);
		adjM.addEdge(5, 6, 2);
		
		//Prueba para Dijsktra
//		int[] array = adjM.dijsktra(1);			
//		for(int i=0; i<array.length ; i++) {
//			System.out.print(array[i]+ "  ");
//		}

		
		//Prueba para Floyd Warshall
//		int[][] matrixClone = adjM.floydWarshall();
//		for (int i = 0; i < matrixClone.length; i++) {
//			for (int j = 0; j < matrixClone.length; j++) {
//				
//				
//				if (matrixClone[i][j] != Integer.MAX_VALUE) {
//					System.out.print("|" + matrixClone[i][j] + "|");
//				} else {
//					System.out.print("|" + "-" + "|");
//				}
//			}
//			System.out.println();
//		}

	}

}
