package tda;

import dataStructures.NodeAbstract;

public interface InterfaceCampiQueue<T> {

	public NodeAbstract<T> front();
	
	public void enqueue(T data);
	
	public T dequeue();
	
	public boolean isEmpty();
	
	public int getSize();
	
	
}
