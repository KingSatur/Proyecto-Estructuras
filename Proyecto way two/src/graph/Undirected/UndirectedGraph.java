package graph.Undirected;

import java.util.ArrayList;

import graph.Directed.Graph;
import graph.Directed.Node;


public class UndirectedGraph<V, K extends Comparable<K>> extends Graph<V,K> {

	public UndirectedGraph() {
		super();
	}
	
	@Override
	public void addEdge(K keyNodeStart, K keyNodeEnd, K keyEdge, double weight) {
		Node<V, K> nodeEnd = getNodes().get(keyNodeEnd);
		Node<V, K> nodeStart = getNodes().get(keyNodeStart);
		getNodes().get(keyNodeStart).addEdge(nodeEnd, keyEdge, weight);
		getNodes().get(keyNodeEnd).addEdge(nodeStart, keyEdge, weight);	
	}
	
	@Override
	public void removeEdge(K keyNode, K keyEdge){
		K key = (K) getNodes().get(keyNode).getEdges().get(keyEdge).getEnd().getKey();
		getNodes().get(keyNode).removeEdge(keyEdge);
		getNodes().get(key).removeEdge(keyEdge);
	}
	
	
	public static void main (String[] args) {
		
		UndirectedGraph<Integer, Integer> g = new UndirectedGraph<>();
		
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);
		Node<Integer, Integer> n7 = new Node<>(7, 7);
		Node<Integer, Integer> n8 = new Node<>(8, 8);
		Node<Integer, Integer> n9 = new Node<>(9, 9);
		Node<Integer, Integer> n10 = new Node<>(10, 10);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);
		g.addNode(n9);
		g.addNode(n10);
		
		g.addEdge(1, 2, 1, 0);
		g.addEdge(1, 3, 2, 0);
		g.addEdge(1, 4, 3, 0);
		g.addEdge(1, 5, 4, 0);
		g.addEdge(1, 6, 5, 0);
		g.addEdge(1, 7, 6, 0);
		g.addEdge(1, 8, 7, 0);
		g.addEdge(1, 9, 8, 0);
		g.addEdge(1, 10, 9, 0);
		
		ArrayList<Node> bfs = g.bfs(n1);
		for (int i = 0; i < bfs.size(); i++) {
			System.out.println("KEY : " +  bfs.get(i).getKey() + " "+ "VALUES :" + bfs.get(i).getValue() );
		}
		
	}
}
