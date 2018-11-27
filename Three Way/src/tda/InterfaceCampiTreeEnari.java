package tda;
import dataStructures.NodeEnari;
import exceptions.IndexOutOfRangeException;

public interface InterfaceCampiTreeEnari<T extends Comparable<T>> {

	public NodeEnari<T> search(T data, NodeEnari<T> node);

	public void delete(T data);

	public void add(T data, T dataPadre, NodeEnari<T> node) throws IndexOutOfRangeException;

	
}
