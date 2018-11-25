package tda;

public interface InterfaceCampiHash<K, T> {

	public boolean isEmpty();
	
	public int tableLength();
	
	public void tableInsert(T data);
	
	public void tableDelete(K key);
	
	public T tableRetrieve(K key);
	
}
