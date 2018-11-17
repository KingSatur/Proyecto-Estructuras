package graph.Directed;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class UnionStructure<V,K extends Comparable<K>> {

	private HashMap<K, Hashtable<K ,Node<V,K>>> nodesHash;
	
	public UnionStructure() {
		nodesHash = new HashMap<K, Hashtable<K, Node<V,K>>>();
	}
	
	public K find(Node<V,K> nodeToSearch, Node<V,K> source) {

		if(nodesHash.get(source.getKey()).containsKey(nodeToSearch.getKey())) {
			return source.getKey();
		}
		else {
			return null;
		}
	}
	
	public void union(Node<V,K> a, Node<V,K> b ) {
		
		if(!nodesHash.get(a).containsKey(b.getKey())) {
			nodesHash.get(a).values().addAll(nodesHash.get(b).values());
			nodesHash.remove(b);
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
