package graph.Directed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Node<V, K extends Comparable<K>> implements Comparable<Node> {

	private V value;
	private K key;
	private PriorityQueue<Node<V, K>> neighbors; //Si son letras se organizan lexicografica
	private HashMap<K, Edge> edges;
	
	public Node(V value, K key) {
		super();
		this.value = value;
		this.key = key;
		edges = new HashMap<>();
		neighbors = new PriorityQueue<>();
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public PriorityQueue<Node<V, K>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(PriorityQueue<Node<V, K>> neighbors) {
		this.neighbors = neighbors;
	}
	
	

	
	public HashMap<K, Edge> getEdges() {
		return edges;
	}

	public void setEdges(HashMap<K, Edge> edges) {
		this.edges = edges;
	}

	
	public <W extends Comparable<W>> void addEdge(Node end, K keyEdge, W weight) {
		
		Edge e = new Edge(end, weight, keyEdge);
		edges.put(keyEdge, new Edge<>(end, weight, keyEdge));
		neighbors.add(end);
		
	}
	
	public void removeEdge(K keyEdge) {
		
		Node end = edges.get(keyEdge).getEnd();
		edges.remove(keyEdge);
		Iterator i = neighbors.iterator();
		while(i.hasNext()) {
			if(i.next().equals(end)) {
				i.remove();
			}	
		}
	
	}

	@Override
	public int compareTo(Node o) {
		
		return this.key.compareTo(getKey());
	}
	

}
