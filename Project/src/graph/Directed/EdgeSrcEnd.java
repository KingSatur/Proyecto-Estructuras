package graph.Directed;

public class EdgeSrcEnd<K extends Comparable<K>> extends Edge<K> implements Comparable<EdgeSrcEnd<K>> {

	private Node src;
	
	public EdgeSrcEnd(Node src, Node end, K key, double weightKey) {
		super(end, key, weightKey);
		this.src = src;
	}

	public Node getSrc() {
		return src;
	}

	public void setSrc(Node src) {
		this.src = src;
	}

	@Override
	public int compareTo(EdgeSrcEnd<K> otro) {
		if(this.getWeightKey()<otro.getWeightKey()) {
			return -1;
		}
		else if(this.getWeightKey()>otro.getWeightKey()) {
			return 1;
		}
		else {return 0;}
	}
	
	
	

}
