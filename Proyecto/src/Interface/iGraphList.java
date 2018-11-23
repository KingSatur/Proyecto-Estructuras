package Interface;

import java.util.ArrayList;

import graph.Directed.Node;

public interface iGraphList<V,K extends Comparable<K>> {

	public void addEdge(K keySource, K keyDestiny, K keyEdge, double weight);
	public void removeEdge(K keyNode, K keyEdge);
	public void addNode(Node<V,K> newNode);
	public void removeNode(K keyNode);
	public ArrayList<Node<V,K>> dfs(Node<V,K> source);
	public ArrayList<Node<V,K>> bfs(Node<V,K> source);
	public void dijsktra(Node<V,K> s);
	public ArrayList<Node<V,K>> kruscal();
	public ArrayList<Node<V,K>> prim(Node<V,K> source);
}
