package graph.Directed;

public class Pair<V,K extends Comparable<K>> {

	private Node<V,K> nodeMain;
	private double acumulatedDistance;
	
	public Pair(Node<V,K> main) {
		this.nodeMain = main;
	}

	public Node<V, K> getNodeMain() {
		return nodeMain;
	}

	public void setNodeMain(Node<V, K> nodeMain) {
		this.nodeMain = nodeMain;
	}

	public double getAcumulatedDistance() {
		return acumulatedDistance;
	}

	public void setAcumulatedDistance(double acumulatedDistance) {
		this.acumulatedDistance = acumulatedDistance;
	}
	
}
