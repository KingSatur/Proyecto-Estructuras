package tda;

import dataStructures.NodeRedBlackTree;

public interface InterfaceRedBlackTree<T, K extends Comparable<K>> {

	public void leftRotation(NodeRedBlackTree<T, K> node);
	
	public void rightRotation(NodeRedBlackTree<T, K> node);
	
	public void addNode(T data, K key, NodeRedBlackTree<T,K> node);
	
	public void deleteNode(K key);
	
	public NodeRedBlackTree<T,K>  searchUncle(K key);
	
	public NodeRedBlackTree<T,K>  searchGrandFather(K key);
	
	public void addFixUp(NodeRedBlackTree<T,K> nodeAdded);
	
	
	
}
