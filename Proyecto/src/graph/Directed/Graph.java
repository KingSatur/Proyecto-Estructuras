package graph.Directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<V, K extends Comparable<K>> {

	private HashMap<K, Node<V,K>> nodes;
	private AdjacencyMatrix adjacencyMatrix;
	private AdjacencyList<K> adjacencyList;
	
	private HashMap parent;
	private HashMap<K, Boolean> visited; 
	private HashMap distance;
	
	public Graph() {
		super();
		nodes = new HashMap<>();
		visited = new HashMap<>();
	}
	
	public HashMap<K, Node<V, K>> getNodes() {
		return nodes;
	}
	public void setNodes(HashMap<K, Node<V, K>> nodes) {
		this.nodes = nodes;
	}
	public AdjacencyMatrix getAdjacencyMatrix() {
		return adjacencyMatrix;
	}
	public void setAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
	public AdjacencyList<K> getAdjacencyList() {
		return adjacencyList;
	}
	public void setAdjacencyList(AdjacencyList<K> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public void addNode(Node newNode) {
		nodes.put((K) newNode.getKey(), newNode);
		visited.put((K) newNode.getKey(), false);
	}
	
	public void removeNode(K keyNode) {
		nodes.remove(keyNode);	
		visited.remove(keyNode);
	}
	
	public <W extends Comparable<W>> void addEdge(K keyNodeStart, K keyNodeEnd, K keyEdge, W weight) {
		Node nodeEnd = nodes.get(keyNodeEnd);
		nodes.get(keyNodeStart).addEdge(nodeEnd, keyEdge, weight);
	}
	
	public void removeEdge(K keyNode, K keyEdge) {
		nodes.get(keyNode).removeEdge(keyEdge);
	}
	
	
	
	
	
	
	
	public ArrayList<Node> dfs(Node s){
		
		for (K key : visited.keySet()) {
			visited.put(key, false);
		}
		
		ArrayList nodesVisited = new ArrayList<>();
		visited.put((K) s.getKey(), true);
//		nodesVisited.add(s);
		Stack<Node<V, K>> stack = new Stack<Node<V,K>>();
		stack.add(s);
				
		while (!stack.isEmpty()) {
			Node<V, K> u = stack.pop();
//			System.out.println(u.getValue());
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				Node<V, K> v = nodeAdjacenty;
				if ((boolean)!visited.get(v.getKey())) {
//					v.setColor(Node.GRAY);
//					v.setDistance(u.getDistance() + 1);
					stack.add(v);
				}
			}
			visited.put(u.getKey(),true );
			nodesVisited.add(u);
		}
		
		
		
		return nodesVisited;
	}
	
	public ArrayList<Node> bfs(Node s){
//		for (Node<T, K> value : vertices.values()) {
//			if (!(value.equals(s))) {
//				value.setColor(Node.WHITE);
//			}
//			value.setDistance(0);
//		}
		ArrayList nodesVisited = new ArrayList<>();
		
		
		for (K key : visited.keySet()) {
			visited.put(key, false);
		}
		
		visited.put((K) s.getKey(), true);
		Queue<Node<V, K>> queue = new LinkedList<Node<V, K>>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Node<V, K> u = queue.poll();
//			System.out.println(u.getValue());
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				Node<V, K> v = nodeAdjacenty;
				if ((boolean)!visited.get(v.getKey())) {
//					v.setColor(Node.GRAY);
//					v.setDistance(u.getDistance() + 1);
					queue.add(v);
				}
			}
			visited.put(u.getKey(),true );
			nodesVisited.add(u);
		}
		
		return nodesVisited;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Graph g = new Graph<>();
		
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);
		Node<Integer, Integer> n7 = new Node<>(7, 7);
		Node<Integer, Integer> n8 = new Node<>(8, 8);
		Node<Integer, Integer> n9 = new Node<>(9, 9);
		Node<Integer, Integer> n10 = new Node<>(10, 10);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);
		g.addNode(n9);
		g.addNode(n10);
		
		g.addEdge(1, 2, 1, 0);
		g.addEdge(1, 3, 2, 0);
		g.addEdge(1, 4, 3, 0);
		g.addEdge(1, 5, 4, 0);
		g.addEdge(1, 6, 5, 0);
		g.addEdge(1, 7, 6, 0);
		g.addEdge(1, 8, 7, 0);
		g.addEdge(1, 9, 8, 0);
		g.addEdge(1, 10, 9, 0);
		
//		ArrayList<Node> dfs = g.dfs(n1);
//		
//		for (int i = 0; i < dfs.size(); i++) {
//			System.out.println("KEY : " +  dfs.get(i).getKey() + " "+ "VALUES :" + dfs.get(i).getValue() );
//		}
		
		
		ArrayList<Node> bfs = g.bfs(n1);
		for (int i = 0; i < bfs.size(); i++) {
			System.out.println("KEY : " +  bfs.get(i).getKey() + " "+ "VALUES :" + bfs.get(i).getValue() );
		}
		
		
		
		
		
		
	}

	
	

}
