package graph.Directed;

import java.util.Collection;
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

	public K find(Node<V,K> nodeToSearch) {
		
		return nodesUbication.get(nodeToSearch.getKey());

	}
	
	public void union(Node<V,K> a, Node<V,K> b ) {
		
		
		if(!nodesHash.get(nodesUbication.get(a.getKey())).containsKey(nodesUbication.get(b.getKey()))) {
			if(nodesHash.get(nodesUbication.get(a.getKey())).values() == null) {
				nodesHash.put(nodesUbication.get(a.getKey()), nodesHash.get(nodesUbication.get(b.getKey())));
				nodesUbication.put(nodesUbication.get(b.getKey()), nodesUbication.get(a.getKey()));
				nodesHash.remove(b.getKey());	
			}
			else {
				if(nodesHash.get(nodesUbication.get(b.getKey())).size() == 0) {
					nodesHash.get(nodesUbication.get(a.getKey())).put(nodesUbication.get(b.getKey()), b);
					nodesUbication.put(nodesUbication.get(b.getKey()), nodesUbication.get(a.getKey()));
					nodesHash.remove(b.getKey());
				}
				else {
					for(Node<V,K> m : nodesHash.get(nodesUbication.get(b.getKey())).values()) {
						nodesHash.get(nodesUbication.get(a.getKey())).put(m.getKey(), m);
					}
					nodesUbication.put(nodesUbication.get(b.getKey()), nodesUbication.get(a.getKey()));
					nodesHash.remove(b.getKey());
				}

			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
