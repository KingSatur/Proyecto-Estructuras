package Interface;

import java.util.ArrayList;
import java.util.HashMap;

import graph.Directed.Node;

public interface iGraphList<V,K extends Comparable<K>> {

	public void addEdge(K keySource, K keyDestiny, K keyEdge, double weight);
	public void removeEdge(K keyNode, K keyEdge);
	public void addNode(Node<V,K> newNode);
	public void removeNode(K keyNode);
	public HashMap<K,K> dfs(Node<V,K> source);
	public HashMap<K,K> bfs(Node<V,K> source);
	public HashMap<K, Double> dijsktra(Node<V,K> s);
	public HashMap<K,K> kruscal();
	public HashMap<K,K> prim(Node<V,K> source);
}
