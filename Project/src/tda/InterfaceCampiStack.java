package tda;

import dataStructures.NodeAbstract;

public interface InterfaceCampiStack<T> {

	public void push(T data);
	
	public boolean isEmpty();
	
	public NodeAbstract<T> top();
	
	public T pop();
	
	public boolean isArmonic(char a, char b);

	public int getSize();
	
	
}
