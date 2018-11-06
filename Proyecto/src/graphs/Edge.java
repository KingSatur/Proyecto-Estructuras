package graphs;

public class Edge<T,K extends Comparable<K>> {

	private Node<T,K> Node1;
	private Node<T,K> Node2;	                     
	private String name;
	private boolean isDirected;
	
//	private E weight;
	
	public Edge(String name, Node<T,K> node1, Node<T,K> node2, boolean isDirected) {
		this.name = name;
		this.Node1 = node1;
		this.Node2 = node2;
		this.isDirected = isDirected;
		createEdge();
	}
	
	public void createEdge() {
		if(isDirected) { 
			Node1.getEdgesAdjacencys().put(this.name, this);			
			Node1.getAdjacencys().put(Node2.getKey(), Node2);
		}else {
			Node1.getEdgesAdjacencys().put(this.name, this);	
			Node1.getAdjacencys().put(Node2.getKey(), Node2);
			Node2.getEdgesAdjacencys().put(this.name, this);
			Node2.getAdjacencys().put(Node1.getKey(), Node1);
		}
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Node<T, K> getNode1() {
		return Node1;
	}

	public void setNode1(Node<T, K> source) {
		this.Node1 = source;
	}

	public Node<T, K> getNode2() {
		return Node2;
	}

	public void setNode2(Node<T, K> end) {
		this.Node2 = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
