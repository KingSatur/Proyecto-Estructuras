package tda;

import dataStructures.NodeAbstract;

public interface InterfaceCampiList<T> {

	public void addElement(T element);
	
	public void deleteElement(int position);
	
	public NodeAbstract<T> searchElement(int position);
	
	public int getSize();
	
	public boolean isEmpty();
	
	public NodeAbstract<T> searchElementBefore(T element);
	
	public NodeAbstract<T> searchElementAfter(T element);

	
	
	
	
}
