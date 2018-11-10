package graph.Directed;

import java.util.HashMap;
import java.util.PriorityQueue;

public class AdjacencyList<K> {

	private HashMap<K, PriorityQueue<Node>> adj;
	
	public AdjacencyList(HashMap<K, PriorityQueue<Node>> adj) {
		super();
		this.adj = adj;
	}

	public HashMap<K, PriorityQueue<Node>> getAdj() {
		return adj;
	}

	public void setAdj(HashMap<K, PriorityQueue<Node>> adj) {
		this.adj = adj;
	}
	
	
	
}
