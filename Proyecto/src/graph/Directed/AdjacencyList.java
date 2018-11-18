package graph.Directed;

import java.util.HashMap;
import java.util.PriorityQueue;

import Interface.iGraphList;

public class AdjacencyList<V,K extends Comparable<K>> extends Graph<V,K>  implements iGraphList<V,K>{

	private HashMap<K, PriorityQueue<Node>> adj;
	
	public AdjacencyList() {
		super();
//		this.adj = adj;
	}

	

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dijsktra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kruscal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNode(Node<V,K> newNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNode() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
