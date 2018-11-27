package graph.Directed;


public class Edge<K extends Comparable<K>>  {

	private Node end;
	private K key;
	private double weightKey;
	
	public Edge(Node end, K key, double weightKey) {
		super();
		this.end = end;
		this.key = key;
		this.weightKey = weightKey;
	}
	
	
	public double getWeightKey() {
		return weightKey;
	}

	public void setWeightKey(double weightKey) {
		this.weightKey = weightKey;
	}

	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}

	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	
	
}
