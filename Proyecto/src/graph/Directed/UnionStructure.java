package graph.Directed;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Set;

public class UnionStructure<V,K extends Comparable<K>> {

	private HashMap<K,K> nodesUbication;
	private HashMap<K, Hashtable<K ,Node<V,K>>> nodesHash;
	
	public UnionStructure() {
		nodesUbication = new HashMap<K,K>();
		nodesHash = new HashMap<K, Hashtable<K, Node<V,K>>>();
	}
	
	public HashMap<K, K> getNodesUbication() {
		return nodesUbication;
	}

	public void setNodesUbication(HashMap<K, K> nodesUbication) {
		this.nodesUbication = nodesUbication;
	}

	public HashMap<K, Hashtable<K, Node<V, K>>> getNodesHash() {
		return nodesHash;
	}

	public void setNodesHash(HashMap<K, Hashtable<K, Node<V, K>>> nodesHash) {
		this.nodesHash = nodesHash;
	}

	public void fillHashes(Set<K> keys) {

		
	}
	
	public K find(K keyNode) {
		
		return nodesUbication.get(keyNode);

	}
	
	public void union(Node<V,K> a, Node<V,K> b ) {
		
		if(!nodesHash.get(a).containsKey(b.getKey())) {
			nodesHash.get(a).values().addAll(nodesHash.get(b).values());
			nodesUbication.put(b.getKey(), a.getKey());
			nodesHash.remove(b);		
		}
				
	}
	
	
	
	
	
	
	
	
	
	
	
}
