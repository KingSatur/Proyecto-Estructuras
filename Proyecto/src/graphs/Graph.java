package graphs;

import java.util.HashMap;

public class Graph<T,K extends Comparable<K>> {

	private AdjacencyMatrix adjacencyMatrix;
	private HashMap<K, Node<T,K>> vertices;
 
	public Graph() {
		vertices = new HashMap<K,Node<T,K>>();
	}
	
	public void modifiedAdjacencyMatrix() {
		
	}
	
	public void initializeAdjacencyList() {
		
	}
	
	
	
	
}
