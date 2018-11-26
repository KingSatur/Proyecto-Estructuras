package Interface;

import java.util.ArrayList;
import java.util.HashMap;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;

public interface iGraphMatrix<V,K extends Comparable<K>> {

	public HashMap<K, K> dfs(K keyNode);
	public HashMap<K, K> bfs(K keyNode);
	public HashMap<K, K> dijsktra(K keyNode);
	public EdgeSrcEnd[][] floydWarshall();
	public HashMap<K, K> kruscal();
	public HashMap<K, K> prim();
	
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight, K keyEdge);
	public void removeEdge(K keyEdge);
	public void addNode(Node<V, K> newNode);
	public void removeNode(K keyNode);
	
}
