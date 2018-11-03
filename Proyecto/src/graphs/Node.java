package graphs;

import java.util.HashMap;

public class Node<T, K extends Comparable<K>> {

	private T value;
	private K key;
	private HashMap<String, Edge<T,K>> adjacencys;  
	
	public Node(T value, K key) {
		this.value = value;
		this.key = key;
		adjacencys = new HashMap<String, Edge<T,K>>();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public HashMap<String, Edge<T,K>> getAdjacencys() {
		return adjacencys;
	}

	public void setAdjacencys(HashMap<String, Edge<T,K>> adjacencys) {
		this.adjacencys = adjacencys;
	}

	
}
