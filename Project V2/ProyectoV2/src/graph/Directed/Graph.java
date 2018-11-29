package graph.Directed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public  abstract class Graph<V, K extends Comparable<K>> {
	

	private HashMap<K, Node<V,K>> nodes;

	private HashMap<K, EdgeSrcEnd<K>> generalEdges;

	
	public Graph() {
		super();
		nodes = new HashMap<K, Node<V,K> >();

		generalEdges = new HashMap<K, EdgeSrcEnd<K>>();

	}
	
	public HashMap<K, Node<V, K>> getNodes() {
		return nodes;
	}
	public void setNodes(HashMap<K, Node<V, K>> nodes) {
		this.nodes = nodes;
	}

	public HashMap<K, EdgeSrcEnd<K>> getGeneralEdges() {
		return generalEdges;
	}

	public void setGeneralEdges(HashMap<K, EdgeSrcEnd<K>> generalEdges) {
		this.generalEdges = generalEdges;
	}
	
	
	
}
	

