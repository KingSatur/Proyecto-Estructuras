package tda;

import dataStructures.NodeAbstract;
import exceptions.IndexOutOfRangeException;

public interface InterfaceCampiList<T> {

	public void addElement(T element);
	
	public void deleteElement(int position) throws IndexOutOfRangeException;
	
	public NodeAbstract<T> searchElement(int position)throws IndexOutOfRangeException;
	
	public int getSize();
	
	public boolean isEmpty();
	
	public NodeAbstract<T> searchElementBefore(T element);
	
	public NodeAbstract<T> searchElementAfter(T element);

	
	
	
	
}
