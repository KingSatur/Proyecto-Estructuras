package dataStructures;
import exceptions.IndexOutOfRangeException;
import tda.InterfaceCampiTreeEnari;

public class CampiTreeEnari<T extends Comparable<T>> implements InterfaceCampiTreeEnari<T>{
	
	private NodeEnari<T> root;
	private int levels;
	
	public CampiTreeEnari() {
		root = new NodeEnari<T>(null);
		levels = 0;
	}	
	
	public NodeEnari<T> getRoot() {
		return root;
	}

	public void setRoot(NodeEnari<T> root) {
		this.root = root;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	@Override
	public NodeEnari<T> search(T data, NodeEnari<T> node) {

		return null;
	}

	@Override
	public void delete(T data) {
		
	}

	@Override
	public void add(T data, T dataPadre, NodeEnari<T> node) throws IndexOutOfRangeException {
		
		if(dataPadre == null) {
			node.addSon(new NodeEnari<T>(data));
		}
		else {
			if(dataPadre.equals(node)) {
				node.addSon(node);
			}
			else {
				boolean back = false;
				for(int i = 0; i < node.getSons().getSize() && !back; i ++) {
					NodeEnari<T> nod = node.getSons().searchElement(i).getData();
					if(nod.getInfo().equals(dataPadre)) {
						nod.addSon(new NodeEnari<T>(data));
						back = true;
					}
					else {
						if(nod.getSons().getSize() > 0) {
							add(data, dataPadre, nod);
						}
					}
				}
			}
		}
	
	}
	
	
	
	public static void main(String[] args) throws IndexOutOfRangeException {
		

		NodeEnari<Player> m = new NodeEnari<Player>(new Player("Barcelona",20));
		NodeEnari<Player> m1 = new NodeEnari<Player>(new Player("Real madrid",15));
		NodeEnari<Player> m2 = new NodeEnari<Player>(new Player("Atletico de madrid",15));
		NodeEnari<Player> m3 = new NodeEnari<Player>(new Player("Real sociedad",15));
		NodeEnari<Player> m4 = new NodeEnari<Player>(new Player("Sevilla",15));
		NodeEnari<Player> m5 = new NodeEnari<Player>(new Player("Getafe",15));
		CampiTreeEnari<Player> juan = new CampiTreeEnari<Player>();
		juan.add(m.getInfo(), null, juan.getRoot());
		juan.add(m1.getInfo(), null, juan.getRoot());
		juan.add(m2.getInfo(), m1.getInfo(), juan.getRoot());
		juan.add(m3.getInfo(), m.getInfo(), juan.getRoot());
		juan.add(m4.getInfo(), m3.getInfo(), juan.getRoot());
		juan.add(m5.getInfo(), m4.getInfo(), juan.getRoot());
		int hp = 0;
		
		
		
			
	}
	








	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
