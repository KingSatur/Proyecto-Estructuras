package dataStructures;
import tda.InterfaceCampiList;

public class NodeEnari<T extends Comparable<T>> implements Comparable<NodeEnari<T>>{

	private T data;
	private InterfaceCampiList<NodeEnari<T>> sons;

	public NodeEnari(T data) {
		this.data = data;
		sons = new Abstract<NodeEnari<T>>();
	}

	public InterfaceCampiList<NodeEnari<T>> getSons() {
		return sons;
	}

	public void setSons(InterfaceCampiList<NodeEnari<T>> sons) {
		this.sons = sons;
	}
		
	public void addSon(NodeEnari<T> node) {
		sons.addElement(node);
	}

	public T getInfo() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

	@Override
	public int compareTo(NodeEnari<T> o) {
		return this.getInfo().compareTo(o.getInfo());
	}

}
