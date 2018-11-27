package dataStructures;

public class NodeAbstract<K> {

	private K data;
	private NodeAbstract<K> nextElement;
	private int position;
	
	public NodeAbstract(K data) {
		this.data = data;
	}
	
	public K getData() {
		return data;
	}
	
	public void setData(K data) {
		this.data = data;
	}
	
	public NodeAbstract<K> getNextElement() {
		return nextElement;
	}
	
	public void setNextElement(NodeAbstract<K> nextElement) {
		this.nextElement = nextElement;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	} 
	
	
	
}
