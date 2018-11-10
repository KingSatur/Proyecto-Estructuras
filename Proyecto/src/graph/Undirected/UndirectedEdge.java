package graph.Undirected;

import graph.Directed.Edge;
import graph.Directed.Node;
import interfaces.iUndirectedEdge;

public class UndirectedEdge<W extends Comparable<W>, K extends Comparable<K>> extends Edge<W, K> implements iUndirectedEdge<W, K>{

	public UndirectedEdge(Node end, W weight, K key) {
		super(end, weight, key);
		// TODO Auto-generated constructor stub
	}

}
