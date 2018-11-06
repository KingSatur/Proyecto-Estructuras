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
	private int number;
	
	private HashMap<K, Node<T,K>> vertexAdjacencys;  
	private HashMap<String, Edge<T,K>> edgesAdjacencys;
	
	
	public Node(T value, K key, String color, int number) {
		this.value = value;
		this.key = key;
		this.color = color;
		vertexAdjacencys = new HashMap<K, Node<T,K>>();
		edgesAdjacencys = new HashMap<String, Edge<T,K>>();
		this.number = number;
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

	public HashMap<K, Node<T,K>> getAdjacencys() {
		return vertexAdjacencys;
	}

	public void setAdjacencys(HashMap<K, Node<T,K>> adjacencys) {
		this.vertexAdjacencys = adjacencys;
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
	
	public HashMap<String, Edge<T, K>> getEdgesAdjacencys() {
		return edgesAdjacencys;
	}

	public void setEdgesAdjacencys(HashMap<String, Edge<T, K>> edgesAdjacencys) {
		this.edgesAdjacencys = edgesAdjacencys;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	

//	public void createEdge(boolean isDirected, Node<T,K> nodeVecino, String name) {
//		
//		if(isDirected) {
//			Edge<T,K> edge = new Edge<T,K>(name, this, nodeVecino, true);
//			this.edgesAdjacencys.put(edge.getName(), edge);
//			this.vertexAdjacencys.put(edge.getEnd().getKey(), edge.getEnd());
//		}
//		else {
//			Edge<T,K> edge = new Edge<T,K>(name, this, nodeVecino, true);
//			this.edgesAdjacencys.put(edge.getName(), edge);
//			this.vertexAdjacencys.put(edge.getEnd().getKey(), edge.getEnd());
//			edge.setEnd(this);
//			edge.setSource(nodeVecino);
//			edge.getSource().edgesAdjacencys.put(edge.getName(), edge);
//			edge.getSource().vertexAdjacencys.put(this.key, this);	
//		}
//	}
	

	
}
