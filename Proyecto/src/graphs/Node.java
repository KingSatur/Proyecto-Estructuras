package graphs;

public class Node<T, K extends Comparable<K>> {

	private T value;
	private K key;
	
	
	public Node(T value, K key) {
		this.value = value;
		this.key = key;
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
	
	
	
	
	
	
	
	
	
	
}
