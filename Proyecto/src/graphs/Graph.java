package graphs;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T,K extends Comparable<K>> {

	private AdjacencyMatrix adjacencyMatrix;
	private HashMap<K, Node<T,K>> vertices;
	private boolean isDirected;
	
	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
		vertices = new HashMap<K,Node<T,K>>();	
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



	public void setVertices(HashMap<K, Node<T,K>> vertices) {
		this.vertices = vertices;
	}
	
	public void modifiedAdjacencyMatrix() {
		
	}
	
	public void initializeAdjacencyList() {
		
	}
	
	//AGREGA EL VERTICE
	public void addVertex(Node<T,K> vertex) {
		vertices.put(vertex.getKey(), vertex);
	}
	
//	COLOQUE ESTE METODO AQUI PORQUE ES RESPONSABILIDAD DEL GRAFO CREAR LA ARISTA
	public void createEdge(K key, Node<T,K> nodeVecino, String name) {
		vertices.get(key).createEdge(isDirected, nodeVecino, name);
	}
	
	
	public void breadthFirstSearch(Node<T,K> s) {
		
		for(Node<T,K> value: vertices.values()) {
			if(!(value.equals(s))) {
				value.setColor(Node.WHITE);				
			}
			value.setDistance(0);
		}
		s.setColor(Node.BLACK);
		Queue<Node<T,K>> queue = new LinkedList<Node<T,K>>();
		queue.add(s);
		while(!queue.isEmpty()) {
			Node<T,K> u = queue.poll();
			System.out.println(u.getValue());
			for (Node<T, K> nodeAdjacenty : u.getAdjacencys().values()) {
				Node<T,K> v = nodeAdjacenty;
				if(v.getColor().equals(Node.WHITE)) {
					v.setColor(Node.GRAY);
					v.setDistance(u.getDistance() + 1);
					queue.add(v);
				}
			}
			u.setColor(Node.BLACK);
		}
		
		
	}
	
	public void deepFirstSearch() {
		
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
				
		Graph<Integer,Integer> g = new Graph<>(true);
		Node<Integer, Integer> n1 = new Node<>(1, 1, Node.WHITE);
		Node<Integer, Integer> n2 = new Node<>(2, 2, Node.WHITE);
		Node<Integer, Integer> n3 = new Node<>(3, 3, Node.WHITE);
		Node<Integer, Integer> n4 = new Node<>(4, 4, Node.WHITE);
		Node<Integer, Integer> n5 = new Node<>(5, 5, Node.WHITE);
		Node<Integer, Integer> n6 = new Node<>(6, 6, Node.WHITE);
		Node<Integer, Integer> n7 = new Node<>(7, 7, Node.WHITE);
		Node<Integer, Integer> n8 = new Node<>(8, 8, Node.WHITE);
		Node<Integer, Integer> n9 = new Node<>(9, 9, Node.WHITE);
		Node<Integer, Integer> n10 = new Node<>(10, 10, Node.WHITE);
		g.addVertex(n1);
		g.addVertex(n2);
		g.addVertex(n3);
		g.addVertex(n4);
		g.addVertex(n5);
		g.addVertex(n6);
		g.addVertex(n7);
		g.addVertex(n8);
		g.addVertex(n9);
		g.addVertex(n10);
		g.createEdge(n1.getKey(), n6, "1");
		g.createEdge(n1.getKey(), n2, "2");
		g.createEdge(n2.getKey(), n5, "3");
		g.createEdge(n2.getKey(), n3, "4");
		g.createEdge(n2.getKey(), n4, "5");
		g.createEdge(n3.getKey(), n7, "6");
		g.createEdge(n3.getKey(), n8, "7");
		g.createEdge(n5.getKey(), n9, "8");
		g.createEdge(n5.getKey(), n10, "9");
//		n1.createEdge(false, n6, "1");
//		n1.createEdge(false, n2, "2");
//		n2.createEdge(false, n5, "3");
//		n2.createEdge(false, n3, "4");
//		n2.createEdge(false, n4, "5");
//		n3.createEdge(false, n7, "6");
//		n3.createEdge(false, n8, "7");
//		n5.createEdge(false, n9, "8");
//		n5.createEdge(false, n10, "9");
		
		g.breadthFirstSearch(n2);
	
	}
	
	
	
}
