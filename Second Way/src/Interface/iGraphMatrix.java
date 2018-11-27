package Interface;

import java.util.ArrayList;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;

public interface iGraphMatrix<V,K extends Comparable<K>> {

	public ArrayList<Node> dfs(K keyNode);
	public ArrayList<Node> bfs(K keyNode);
	public double[] dijsktra(K keyNode);
	public EdgeSrcEnd[][] floydWarshall();
	public EdgeSrcEnd[] kruscal();
	public double[] prim();
	
	public void addEdge(K keyNodeStart, K keyNodeEnd, double weight, K keyEdge);
	public void removeEdge(K keyEdge);
	public void addNode(Node<V, K> newNode);
	public void removeNode(K keyNode);
	
}
