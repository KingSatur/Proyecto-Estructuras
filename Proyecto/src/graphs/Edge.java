package graphs;

public class Edge<T,K extends Comparable<K>> {

	private Node<T,K> source;
	private Node<T,K> end;
	private String name;
	
//	private E weight;
	
	public Edge(String name, Node<T,K> source, Node<T,K> end) {
		this.source = source;
		this.name = name;
		this.end = end;
	}

	public Node<T, K> getSource() {
		return source;
	}

	public void setSource(Node<T, K> source) {
		this.source = source;
	}

	public Node<T, K> getEnd() {
		return end;
	}

	public void setEnd(Node<T, K> end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
