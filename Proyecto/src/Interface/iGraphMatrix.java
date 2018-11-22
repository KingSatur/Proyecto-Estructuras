package Interface;

import java.util.ArrayList;

import graph.Directed.Node;

public interface iGraphMatrix<V,K extends Comparable<K>> {

	public void dfs(K keyNode);
	public void bfs(K keyNode);
	public int[] dijsktra(K keyNode);
	public int[][] floydWarshall();
	public ArrayList kruscal();
	public void prim();
	
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight);
	public void removeEdge(K keyNodeStart, K keyNodeEnd);
	public void addNode(Node<V, K> newNode);
	public void removeNode(K keyNode);
	
}
