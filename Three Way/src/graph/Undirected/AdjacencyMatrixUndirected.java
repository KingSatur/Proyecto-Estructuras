package graph.Undirected;

import java.util.ArrayList;

import graph.Directed.AdjacencyMatrix;
import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;

public class AdjacencyMatrixUndirected<V, K extends Comparable<K>> extends AdjacencyMatrix<V, K> {

	private double[][] matrixWEIGHT;

	public AdjacencyMatrixUndirected(int numberNodes) {
		super(numberNodes);
		matrixWEIGHT = new double[numberNodes][numberNodes];

	}

	@Override
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight, K keyEdge) {
		int i = indexNodes.get(keyNodeStart);
		int j = indexNodes.get(keyNodeEnd);
		EdgeSrcEnd e = new EdgeSrcEnd<K>(super.getNodes().get(keyNodeStart),super.getNodes().get(keyNodeEnd), keyEdge, weight);
		matrix[i][j] = e;
		EdgeSrcEnd e1 = new EdgeSrcEnd<K>(super.getNodes().get(keyNodeEnd),super.getNodes().get(keyNodeStart), keyEdge, weight);
		matrix[j][i] = e1;
		super.getGeneralEdges().put(keyEdge, e);
	}

	@Override
	public void removeEdge(K keyEdge) {
		super.getGeneralEdges().remove(keyEdge);
		int i = indexNodes.get(super.getGeneralEdges().get(keyEdge).getSrc().getKey());
		int j = indexNodes.get(super.getGeneralEdges().get(keyEdge).getEnd().getKey());
		matrix[i][j].setWeightKey(Double.MAX_VALUE);
		matrix[j][i].setWeightKey(Double.MAX_VALUE);
	}

	public static void main(String[] args) {
		AdjacencyMatrixUndirected<Integer, Integer> adjM = new AdjacencyMatrixUndirected<Integer, Integer>(0);

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
		

		adjM.addEdge(1, 3, 1, 1);
		adjM.addEdge(1, 2, 2, 2);
		adjM.addEdge(3, 4, 3, 3);
		adjM.addEdge(2, 4, 6, 4);
		adjM.addEdge(4, 6, 2, 5);
		adjM.addEdge(3, 5, 4, 6);
		adjM.addEdge(5, 6, 2, 7);

//		adjM.addEdge(1, 2, 7, 1);
//		adjM.addEdge(2, 3, 3, 2);
//		adjM.addEdge(3, 4, 2, 3);
//		adjM.addEdge(4, 1, 1, 4);
//		adjM.addEdge(3, 5, 4, 5);
//		adjM.addEdge(5, 1, 6, 7);
//		adjM.addEdge(5, 2, 5, 8);

//		adjM.imprimir();

//		ArrayList<Node> n = adjM.dfs(3);
//		for (int i = 0; i < n.size(); i++) {
//			System.out.print(n.get(i).getValue()+" ");
//		}
//		

		// Prueba para Dijsktra
//		double[] array = adjM.dijsktra(3);
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + "  ");
//		}


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
