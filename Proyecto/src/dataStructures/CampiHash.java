//package dataStructures;
//
//import java.lang.reflect.Array;
//
//import tda.InterfaceCampiHash;
//import tda.InterfaceCampiQueue;
//
//public class CampiHash<K,T> implements InterfaceCampiHash<K, T> {
//	
//	private NodeHash<K, T>[] array;
//	private int size;
//	
//	@SuppressWarnings("unchecked")
//	public CampiHash(int length) {
//		size = length;
//		array = new NodeHash[length];
//	}
//	
//	
//	@Override
//	public boolean isEmpty() {
//		return false;
//	}
//
//	@Override
//	public int tableLength() {
//		return 0;
//	}
//
//	@Override
//	public void tableInsert(T data) {
//		
//	}
//
//	@Override
//	public void tableDelete(K key) {		
//		
//	}
//
//	@Override
//	public T tableRetrieve(K key) {
//		
//		return null;
//	}
//	
//	public int hashFunction(K key) {
//		
//		return 0;
//		
//	}
//	
//	
//	
//	public NodeHash<K, T>[] getArray() {
//		return array;
//	}
//
//
//	public void setArray(NodeHash<K, T>[] array) {
//		this.array = array;
//	}
//
//
//	public int getSize() {
//		return size;
//	}
//
//
//	public void setSize(int size) {
//		this.size = size;
//	}
//
//	public void crear() {
//			
//	}
//	
//
////	public static void main(String[] args) {
////		CampiHash<String, InterfaceCampiQueue<Integer>> m = new CampiHash<String, InterfaceCampiQueue<Integer>>(40);
////		m.crear(30);
////		
////		System.out.println(m.size);
////		
////	}
//	
//}
