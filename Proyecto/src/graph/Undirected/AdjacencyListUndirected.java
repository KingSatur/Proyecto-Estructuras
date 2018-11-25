package graph.Undirected;

import graph.Directed.AdjacencyList;
import graph.Directed.Node;

public class AdjacencyListUndirected<V,K extends Comparable<K>> extends AdjacencyList<V,K>{

	public AdjacencyListUndirected() {
		super();
	}
	
	public void addEdge(K keySource, K keyDestiny, K keyEdge, double weight) {

		if(!super.getNodes().get(keySource).getEdges().containsKey(keyEdge)) {
			super.getNodes().get(keySource).addEdge(super.getNodes().get(keyDestiny), keyEdge, weight);
			super.getNodes().get(keyDestiny).addEdge(super.getNodes().get(keySource), keyEdge, weight);
			adj.put(keySource, super.getNodes().get(keySource).getNeighbors());
			adj.put(keyDestiny, super.getNodes().get(keyDestiny).getNeighbors());
		}
	}
	
	public void removeEdge(K keyNode, K keyEdge) {
		
		Node<V,K> second = super.getNodes().get(keyNode).getEdges().get(keyEdge).getEnd();
		second.removeEdge(keyEdge);
		super.getNodes().get(keyNode).removeEdge(keyEdge);	
	}
	
}
