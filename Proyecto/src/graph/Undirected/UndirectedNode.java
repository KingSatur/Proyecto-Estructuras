package graph.Undirected;

import graph.Directed.Node;
import interfaces.iUndirectedNode;

public class UndirectedNode<K extends Comparable<K>,V> extends Node<V, K> implements iUndirectedNode{

	public UndirectedNode(V value, K key) {
		super(value, key);
	}

}
