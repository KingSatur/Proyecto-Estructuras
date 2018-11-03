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
	
	public void setVertices(HashMap<K, Node<T,K>> vertices) {
		this.vertices = vertices;
	}
	
	public void modifiedAdjacencyMatrix() {
		
	}
	
	public void initializeAdjacencyList() {
		
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
			for (Edge<T, K> edgeAdjacenty : u.getAdjacencys().values()) {
				Node<T,K> v = edgeAdjacenty.getEnd();
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
		
//		Player m1 = new Player("Juan david" , 20);
//		Player m2 = new Player("Camilo" , 100);
//		Player m3 = new Player("Juan david dos" , 50);
//		Player m4 = new Player("Camilo dos" , 130);
//		Player m5 = new Player("Ju1234an david dos" , 10);
//		Player m6 = new Player("Ca1234milo dos" , 30);
//		Player m7 = new Player("Ju1234an david dos" , 80);
//		Player m8 = new Player("Cam1234ilo dos" , 07);
//		HashMap<Integer, Node<Player, Integer>> vertices = new HashMap<Integer, Node<Player, Integer>>();
//		Graph<Player, Integer> m = new Graph<Player,Integer>();
//		m.setVertices(vertices);
//		m.breadthFirstSearch();
//		Enumeration<Node<Player, Integer>> e = (Enumeration<Node<Player, Integer>>) vertices.keySet();
//		Node<Player, Integer> valor;
//		while(e.hasMoreElements()) {
//			valor = (Node<Player, Integer>) e.nextElement();
//		}
//		int a = 100;
		
		
//		Graph<Integer,Integer> g = new Graph<>();
//		
//		
//		Node<Integer, Integer> n1 = new Node<>(1, 1, Node.WHITE);
//		Node<Integer, Integer> n2 = new Node<>(2, 2, Node.WHITE);
//		Node<Integer, Integer> n3 = new Node<>(3, 3, Node.WHITE);
//		Node<Integer, Integer> n4 = new Node<>(4, 4, Node.WHITE);
//		Node<Integer, Integer> n5 = new Node<>(5, 5, Node.WHITE);
//		Node<Integer, Integer> n6 = new Node<>(6, 6, Node.WHITE);
//		Node<Integer, Integer> n7 = new Node<>(7, 7, Node.WHITE);
//		Node<Integer, Integer> n8 = new Node<>(8, 8, Node.WHITE);
//		Node<Integer, Integer> n9 = new Node<>(9, 9, Node.WHITE);
//		Node<Integer, Integer> n10 = new Node<>(10, 10, Node.WHITE);
//		
//		Edge<Integer, Integer> e1 = new Edge<>("1", n1, n6);
//		Edge<Integer, Integer> e1_1 = new Edge<>("1", n6, n1);
//		Edge<Integer, Integer> e2 = new Edge<>("2", n1, n2);
//		Edge<Integer, Integer> e3 = new Edge<>("3", n2, n5);
//		Edge<Integer, Integer> e4 = new Edge<>("4", n2, n3);
//		Edge<Integer, Integer> e5 = new Edge<>("5", n2, n4);
//		Edge<Integer, Integer> e6 = new Edge<>("6", n3, n7);
//		Edge<Integer, Integer> e7 = new Edge<>("7", n3, n8);
//		Edge<Integer, Integer> e8 = new Edge<>("8", n5, n9);
//		Edge<Integer, Integer> e9 = new Edge<>("9", n5, n10);
////		Edge<Integer, Integer> e10 = new Edge<>("10", n10, n1);
//		
//		n1.getAdjacencys().put(e1.getName(), e1);
//		n1.getAdjacencys().put(e2.getName(), e2);
//		
//		
//		n2.getAdjacencys().put(e4.getName(), e4);
//		n2.getAdjacencys().put(e3.getName(), e3);
//		n2.getAdjacencys().put(e5.getName(), e5);
//		
//		n3.getAdjacencys().put(e6.getName(), e6);
//		n3.getAdjacencys().put(e7.getName(), e7);
//		
//		n5.getAdjacencys().put(e8.getName(), e8);
//		n5.getAdjacencys().put(e9.getName(), e9);
//		
//		
//		g.vertices.put(1, n1);
//		g.vertices.put(2, n2);
//		g.vertices.put(3, n3);
//		g.vertices.put(4, n4);
//		g.vertices.put(5, n5);
//		g.vertices.put(6, n6);
//		g.vertices.put(7, n7);
//		g.vertices.put(8, n8);
//		g.vertices.put(9, n9);
//		g.vertices.put(10, n10);
//		
//		
//		g.breadthFirstSearch(n9);
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
