package tda;
import dataStructures.NodeBinaryTree;

public interface InterfaceBinaryTreeSearch<T, K extends Comparable<K>> {

	public void addElement(T data, K key, NodeBinaryTree<T, K> node);
	
	public void delete(K key, NodeBinaryTree<T, K> node);
	
	public NodeBinaryTree<T, K> searchElement(K key,  NodeBinaryTree<T, K> node);
	
	public NodeBinaryTree<T, K> minimum(NodeBinaryTree<T, K> node);
	
	public NodeBinaryTree<T, K> maximum(NodeBinaryTree<T, K> node);
	
	public NodeBinaryTree<T, K> searchElementBefore(K key,  NodeBinaryTree<T, K> node);

}
