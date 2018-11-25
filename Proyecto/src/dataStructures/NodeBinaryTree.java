package dataStructures;

public class NodeBinaryTree<T, K extends Comparable<K>> implements Comparable<NodeBinaryTree<T, K>> {

	private T data;
	private K key;
	private NodeBinaryTree<T, K> leftSon;
	private NodeBinaryTree<T, K> rightSon;
	
	public NodeBinaryTree(T data, K key) {
		this.data = data;
		this.key = key;
		leftSon = null;
		rightSon = null;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}



	public boolean isSheet() {
		if(leftSon == null && rightSon == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public NodeBinaryTree<T, K> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(NodeBinaryTree<T, K> leftSon) {
		this.leftSon = leftSon;
	}

	public NodeBinaryTree<T, K> getRightSon() {
		return rightSon;
	}

	public void setRightSon(NodeBinaryTree<T, K> rightSon) {
		this.rightSon = rightSon;
	}

	@Override
	public int compareTo(NodeBinaryTree<T, K> o) {
		return key.compareTo(o.getKey());
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
			if(this.sonNull() == -1) {
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
	
	
	
}
