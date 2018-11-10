package graph.Directed;

//WEIGHT "W" PARA EL PESO
//KEY "K" PARA ALGUNAS OPERACIONES 
public class Edge<W extends Comparable<W>,K extends Comparable<K>> {

	private Node end;
	private W weight;
	private K key;
	

	public Edge(Node end, W weight, K key) {
		super();
		this.end = end;
		this.weight = weight;
		this.key = key;
	}
	
	
	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}
	public W getWeight() {
		return weight;
	}
	public void setWeight(W weight) {
		this.weight = weight;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	
	
	
	
	
	
	
}
