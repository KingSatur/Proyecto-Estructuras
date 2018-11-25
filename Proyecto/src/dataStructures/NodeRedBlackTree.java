package dataStructures;

public class NodeRedBlackTree<T, K extends Comparable<K>> implements Comparable<NodeRedBlackTree<T, K>>{

	public static final String RED = "Red";
	public static final String BLACK = "Black";
	private String color;
	private T data;
	private K key;
	private NodeRedBlackTree<T,K> leftSon;
	private NodeRedBlackTree<T,K> rightSon;
	private boolean nullNegro;
	
	public NodeRedBlackTree(T data, K key) {
		this.data = data;
		this.key = key;
	}
	
	public boolean isNullNegro() {
		return nullNegro;
	}
	
	public void setNullNegro(boolean nullNegro) {
		this.nullNegro = nullNegro;
	}


	public void changeColor() {
		
		if(color.equals(NodeRedBlackTree.BLACK)) {
			color = NodeRedBlackTree.RED;
		}
		else {
			color = NodeRedBlackTree.BLACK;			
		}		
	}

	public String getColor() {
		return color;
	}
	
	public boolean isSheet() {
		if(leftSon == null && rightSon == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setColor(String color) {
		this.color = color;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public NodeRedBlackTree<T, K> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(NodeRedBlackTree<T, K> leftNode) {
		this.leftSon = leftNode;
	}

	public NodeRedBlackTree<T, K> getRightSon() {
		return rightSon;
	}

	public void setRightSon(NodeRedBlackTree<T, K> rightNode) {
		this.rightSon = rightNode;
	}
	
	public int under(K key) {
		
		if(this.sonNull() == 0) {
			if(leftSon.getKey().equals(key)) {
				return 1;
			}
			if(rightSon.getKey().equals(key)) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else {
			if(sonNull() == -1) {
				if(leftSon.getKey().equals(key)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else {
				if(rightSon.getKey().equals(key)) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
		

	}
	
	public int sonNull() {
		
		if(leftSon == null) {
			return 1;
		}
		if(rightSon == null) {
			return -1;
		}
		else {
			return 0;
		}
		
		
	}

	@Override
	public int compareTo(NodeRedBlackTree<T, K> o) {
		return key.compareTo(o.getKey());
	}
	
	
}
