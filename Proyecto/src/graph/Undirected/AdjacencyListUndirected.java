package graph.Undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import Interface.iGraphList;
import graph.Directed.AdjacencyList;
import graph.Directed.Graph;
import graph.Directed.Node;

public class AdjacencyListUndirected<V,K extends Comparable<K>> extends AdjacencyList<V,K> implements iGraphList<V,K> {

	public AdjacencyListUndirected() {
		super();
	}
	
}
