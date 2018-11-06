package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<T, K extends Comparable<K>> {

	private AdjacencyMatrix adjacencyMatrix;
	private HashMap<K, Node<T, K>> vertices;
	private boolean isDirected;

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
		vertices = new HashMap<K, Node<T, K>>();
		adjacencyMatrix = new AdjacencyMatrix();
	}

	public AdjacencyMatrix getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public HashMap<K, Node<T, K>> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<K, Node<T, K>> vertices) {
		this.vertices = vertices;
	}

	public void modifiedAdjacencyMatrix() {

	}

	public void initializeAdjacencyList() {

	}

	// AGREGA EL VERTICE
	public void addVertex(Node<T, K> vertex) {
		vertices.put(vertex.getKey(), vertex);
		adjacencyMatrix.refactorMatrix();
	}

//	COLOQUE ESTE METODO AQUI PORQUE ES RESPONSABILIDAD DEL GRAFO CREAR LA ARISTA
	public void createEdge(String name, Node<T, K> node1, Node<T, K> node2) {
		Edge newEdge = new Edge<>(name, node1, node2, this.isDirected);
		if(isDirected) {
			adjacencyMatrix.fillMatrix(node1.getNumber()-1, node2.getNumber()-1);			
		}else {
			adjacencyMatrix.fillMatrix(node1.getNumber()-1, node2.getNumber()-1);
			adjacencyMatrix.fillMatrix(node2.getNumber()-1, node1.getNumber()-1);
		}
	}

	public void breadthFirstSearch2(Node<T, K> s) {

		for (Node<T, K> value : vertices.values()) {
			if (value.getKey().compareTo(s.getKey()) != 0) {
				value.setColor(Node.WHITE);
			}
			value.setDistance(0);
		}
		s.setColor(Node.BLACK);
		Queue<Node<T, K>> queue = new LinkedList<Node<T, K>>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Node<T, K> u = queue.poll();
			System.out.println(u.getValue());
			for (Edge<T, K> edge : u.getEdgesAdjacencys().values()) {
				Node<T, K> v = null;
				if (isDirected) {
					v = edge.getNode2();
				} else {
					if (u.getKey().compareTo(edge.getNode1().getKey()) == 0) {
						v = edge.getNode2();
					} else {
						v = edge.getNode1();
					}
				}
				if (v.getColor().equals(Node.WHITE)) {
					v.setColor(Node.GRAY);
					v.setDistance(u.getDistance() + 1);
					queue.add(v);
				}
			}
			u.setColor(Node.BLACK);
		}

	}

	public void breadthFirstSearch(Node<T, K> s) {

		for (Node<T, K> value : vertices.values()) {
			if (!(value.equals(s))) {
				value.setColor(Node.WHITE);
			}
			value.setDistance(0);
		}
		s.setColor(Node.BLACK);
		Queue<Node<T, K>> queue = new LinkedList<Node<T, K>>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Node<T, K> u = queue.poll();
			System.out.println(u.getValue());
			for (Node<T, K> nodeAdjacenty : u.getAdjacencys().values()) {
				Node<T, K> v = nodeAdjacenty;
				if (v.getColor().equals(Node.WHITE)) {
					v.setColor(Node.GRAY);
					v.setDistance(u.getDistance() + 1);
					queue.add(v);
				}
			}
			u.setColor(Node.BLACK);
		}

	}

	public void deepFirstSearch() {
		for (Node<T, K> node : vertices.values()) {
			node.setColor(Node.WHITE);
		}
		for (Node<T, K> node : vertices.values()) {
			if(node.getColor().equalsIgnoreCase(Node.WHITE)) {
				dfs_visit(node);
//				dfs_visit2(node);
			}
		}
	}

	public void dfs_visit(Node<T,K> s) {
		
		s.setColor(Node.BLACK);
		Stack<Node<T, K>> stack = new Stack<Node<T,K>>();
		stack.add(s);
				
		while (!stack.isEmpty()) {
			Node<T, K> u = stack.pop();
			System.out.println(u.getValue());
			for (Node<T, K> nodeAdjacenty : u.getAdjacencys().values()) {
				Node<T, K> v = nodeAdjacenty;
				if (v.getColor().equals(Node.WHITE)) {
					v.setColor(Node.GRAY);
					v.setDistance(u.getDistance() + 1);
					stack.add(v);
				}
			}
			u.setColor(Node.BLACK);
		}

	}
	public void dfs_visit2(Node<T, K> s) {

		s.setColor(Node.BLACK);
		Stack<Node<T, K>> stack = new Stack<Node<T,K>>();
		stack.add(s);
		while (!stack.isEmpty()) {
			Node<T, K> u = stack.pop();
			System.out.println(u.getValue());
			for (Edge<T, K> edge : u.getEdgesAdjacencys().values()) {
				Node<T, K> v = null;
				if (isDirected) {
					v = edge.getNode2();
				} else {
					if (u.getKey().compareTo(edge.getNode1().getKey()) == 0) {
						v = edge.getNode2();
					} else {
						v = edge.getNode1();
					}
				}
				if (v.getColor().equals(Node.WHITE)) {
					v.setColor(Node.GRAY);
					v.setDistance(u.getDistance() + 1);
					stack.add(v);
				}
			}
			u.setColor(Node.BLACK);
		}

	}

//	public static void main(String[] args) {
//
//		Graph<Integer, Integer> g = new Graph<>(true);
//		Node<Integer, Integer> n1 = new Node<>(1, 1, Node.WHITE,1);
//		Node<Integer, Integer> n2 = new Node<>(2, 2, Node.WHITE,2);
//		Node<Integer, Integer> n3 = new Node<>(3, 3, Node.WHITE,3);
//		Node<Integer, Integer> n4 = new Node<>(4, 4, Node.WHITE,4);
//		Node<Integer, Integer> n5 = new Node<>(5, 5, Node.WHITE,5);
//		Node<Integer, Integer> n6 = new Node<>(6, 6, Node.WHITE,6);
//		Node<Integer, Integer> n7 = new Node<>(7, 7, Node.WHITE,7);
//		Node<Integer, Integer> n8 = new Node<>(8, 8, Node.WHITE,8);
//		Node<Integer, Integer> n9 = new Node<>(9, 9, Node.WHITE,9);
//		Node<Integer, Integer> n10 = new Node<>(10, 10, Node.WHITE,10);
//		g.addVertex(n1);
//		g.addVertex(n2);
//		g.addVertex(n3);
//		g.addVertex(n4);
//		g.addVertex(n5);
//		g.addVertex(n6);
//		g.addVertex(n7);
//		g.addVertex(n8);
//		g.addVertex(n9);
//		g.addVertex(n10);
//
//		g.createEdge("a1", n1, n2);
//		g.createEdge("a2", n1, n3);
//		g.createEdge("a3", n3, n4);
//		g.createEdge("a4", n3, n5);
//		g.createEdge("a5", n5, n6);
//		g.createEdge("a6", n6, n7);
//
////		g.breadthFirstSearch2(n3);
////		g.deepFirstSearch();
//		
//		for (int i = 0; i < g.getAdjacencyMatrix().getAdjacencys().length; i++) {
//			for (int j = 0; j < g.getAdjacencyMatrix().getAdjacencys().length; j++) {
//				System.out.print(g.getAdjacencyMatrix().getAdjacencys()[i][j]);
//			}
//			System.out.println();
//		}
//
//	}

}
