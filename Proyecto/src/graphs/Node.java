 package graphs;

import java.util.HashMap;

public class Node<T, K extends Comparable<K>>{
	
	public static final String WHITE = "WHITE";
	public static final String BLACK = "BLACK";
	public static final String GRAY = "GRAY";
	private T value;
	private K key;
	private String color;
	private int distance;
	private HashMap<String, Node<T,K>> adjacencys;  
	
	public Node(T value, K key, String color) {
		this.value = value;
		this.key = key;
		this.color = color;
		adjacencys = new HashMap<String, Node<T,K>>();
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

	public HashMap<String, Node<T,K>> getAdjacencys() {
		return adjacencys;
	}

	public void setAdjacencys(HashMap<String, Node<T,K>> adjacencys) {
		this.adjacencys = adjacencys;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	

	
}
