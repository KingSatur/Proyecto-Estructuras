package dataStructures;

import tda.InterfaceRedBlackTree;

public class RedBlackTree<T, K extends Comparable<K>> implements InterfaceRedBlackTree<T, K>{

	private NodeRedBlackTree<T,K> root;
	private int BHeight;

	public RedBlackTree() {
		root = null;
		BHeight = 0;
	}
	
	public NodeRedBlackTree<T, K> getRoot() {
		return root;
	}

	public void setRoot(NodeRedBlackTree<T, K> root) {
		this.root = root;
	}

	public int getBHeight() {
		return BHeight;
	}

	public void setBHeight(int bHeight) {
		BHeight = bHeight;
	}

	@Override
	public void leftRotation(NodeRedBlackTree<T,K> node) {
		
		NodeRedBlackTree<T,K> nodeBefore = searchElementBefore(node.getKey(), root);
		NodeRedBlackTree<T,K> nodeBeforeBefore = searchElementBefore(nodeBefore.getKey(), root);
		if(nodeBeforeBefore == null) {
			nodeBefore.setRightSon(node.getLeftSon());
			node.setLeftSon(nodeBefore);
			root = node;
		}
		else {
			if(nodeBefore.under(node.getKey()) == -1) {
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == -1) {
					nodeBefore.setRightSon(node.getLeftSon());
					node.setLeftSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == 1) {
					nodeBefore.setRightSon(node.getLeftSon());
					node.setLeftSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}	
			}
		}
		
	}

	@Override
	public void rightRotation(NodeRedBlackTree<T, K> node) {
		
		NodeRedBlackTree<T,K> nodeBefore = searchElementBefore(node.getKey(), root);
		NodeRedBlackTree<T,K> nodeBeforeBefore = searchElementBefore(nodeBefore.getKey(), root);
		if(nodeBeforeBefore == null) {
			nodeBefore.setLeftSon(node.getRightSon());
			node.setRightSon(nodeBefore);
			root = node;
		}
		else {
			if(nodeBefore.under(node.getKey()) == 1) {
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == -1) {
					nodeBefore.setLeftSon(node.getRightSon());
					node.setRightSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == 1) {
					nodeBefore.setLeftSon(node.getRightSon());
					node.setRightSon(nodeBefore);
					nodeBeforeBefore.setLeftSon(node);
				}			
			}
		}
	}

	@Override
	public void addNode(T data, K key, NodeRedBlackTree<T,K> node) {
		
		NodeRedBlackTree<T, K> nod = new NodeRedBlackTree<T, K>(data, key);
		nod.setColor(NodeRedBlackTree.RED);
		
		if(node == null) {
			if(root == null) {
				root = nod;	
				root.setColor(NodeRedBlackTree.RED);
				
			}
		}
		else {
			if(node.isSheet()) {
				if(node.compareTo(nod) < 0) {
					node.setRightSon(nod);
				}
				if(node.compareTo(nod) > 0) {
					node.setLeftSon(nod);
				}
			}
			else {
				if(node.compareTo(nod) < 0) {
					if(node.getRightSon() == null) {
						node.setRightSon(nod);
					}
					else {
						addNode(data, key, node.getRightSon());						
					}
				}
				if(node.compareTo(nod) > 0) {
					if(node.getLeftSon() == null) {
						node.setLeftSon(nod);
					}
					else {
						addNode(data, key, node.getLeftSon());
					}
				}
			}
		}
		
	}
	
	public void addComplete(T data, K key, NodeRedBlackTree<T,K> node) {
		addNode(data, key, node);
		NodeRedBlackTree<T,K> nod = searchElement(key, root);
		addFixUp(nod);
	}

	@Override
	public void deleteNode(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodeRedBlackTree<T,K> searchUncle(K key) {
		
		NodeRedBlackTree<T,K> father = searchElementBefore(key, root);
		NodeRedBlackTree<T,K> grandFather = searchElementBefore(father.getKey(), root);
		if(grandFather.under(father.getKey()) == -1) {
			return grandFather.getLeftSon();
		}
		else {
			return grandFather.getRightSon();
		}
		
		
	}

	@Override
	public NodeRedBlackTree<T,K>  searchGrandFather(K key) {
		return null;		
	}
	
	public NodeRedBlackTree<T, K> searchNode(K key, NodeRedBlackTree<T, K> node){
		
		if(node.getKey().equals(key)) {
			return node;
		}
		else {
			if(node.getKey().compareTo(key) > 0) {
				if(node.getLeftSon() != null) {
					return searchNode(key, node.getLeftSon());
				}
				else {
					return null;
				}
			}
			if(node.getKey().compareTo(key) < 0) {
				if(node.getRightSon() != null) {
					return searchNode(key, node.getRightSon());
				}
				else {
					return null;
				}
			}			
		}
		
		return null;
		
	}
	
	public NodeRedBlackTree<T,K> searchElementBefore(K key, NodeRedBlackTree<T,K> node){
		
		if(node.under(key) != 0) {
			return node;
		}
		else {
			if(node.isSheet()) {
				return null;
			}
			else {
				if(node.getKey().compareTo(key) > 0) {
					if(node.getLeftSon() != null) {
						return searchElementBefore(key, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getKey().compareTo(key) < 0) {
					if(node.getRightSon() != null) {
						return searchElementBefore(key, node.getRightSon());
					}
					else {
						return null;
					}
				}
			}
		}
		
		return null;
		
	}
 	
	public NodeRedBlackTree<T, K> searchElement(K key, NodeRedBlackTree<T, K> node) {
		
		if(node.getKey().equals(key)) {
			return node;
		}
		else {
			if(node.isSheet()) {
				return null;
			}
			else {
				if(node.getKey().compareTo(key) > 0) {
					if(node.getLeftSon() != null) {
						return searchElement(key, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getKey().compareTo(key) < 0) {
					if(node.getRightSon() != null) {
						return searchElement(key, node.getRightSon());
					}
					else {
						return null;
					}
				}
			}
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		RedBlackTree<Player, Integer> jugadores = new RedBlackTree<Player, Integer>();
//		for(int i = 0; i < 10000000; i ++) {
//			jugadores.addComplete(new Player("Player" + (i + 1), (i + 1)*2) ,(i + 1)*2, jugadores.root);
//		}
//		jugadores.addComplete(new Player("Juan david", 20), 20, jugadores.root);
//		jugadores.addComplete(new Player("Cristiano", 10), 10, jugadores.root);
//		jugadores.addComplete(new Player("Rodolfo", 50), 50, jugadores.root);
//		jugadores.addComplete(new Player("Adolf", 30), 30, jugadores.root);
//		jugadores.addComplete(new Player("J", 80), 80, jugadores.root);
//		jugadores.addComplete(new Player("Juan", 90), 90, jugadores.root);
//		jugadores.addComplete(new Player("David", 100), 100, jugadores.root);
//		jugadores.addComplete(new Player("Michael", 6), 6, jugadores.root);
//		jugadores.addComplete(new Player("Clone", 300), 300, jugadores.root);
//		jugadores.addComplete(new Player("Adolf5", 21), 21, jugadores.root);
//		jugadores.addComplete(new Player("J4", 4), 4, jugadores.root);
//		jugadores.addComplete(new Player("Juan13", 13), 13, jugadores.root);
//		jugadores.addComplete(new Player("David17", 17), 17, jugadores.root);
//		jugadores.addComplete(new Player("Michael51", 51), 51, jugadores.root);
//		jugadores.addComplete(new Player("Clone87", 87), 87, jugadores.root);
		
//		NodeRedBlackTree<Player,Integer> mhj = jugadores.searchElement(10, jugadores.root);
//		NodeRedBlackTree<Player,Integer> mhj1 = jugadores.searchUncle(100);
//		jugadores.rightRotation(mhj);
		System.out.println((2*19) / 5);
		int m = 100;
		int x = 40;
		int c = m + x;
		
		
}
	

	@Override
	public void addFixUp(NodeRedBlackTree<T,K> nodeAdded) {
		
		NodeRedBlackTree<T,K> z = nodeAdded;
		
		if(z.equals(root)) {
			if(z.getColor().equals(NodeRedBlackTree.RED)) {
				root.changeColor();
			}
		}
		else {
			boolean salir = false;
			while(searchElementBefore(z.getKey(), root) != null && (searchElementBefore(z.getKey(), root).getColor().equals(NodeRedBlackTree.RED)) && salir == false) {
					//CASO EN EL PADRE SEA ROJO Y QUE EL TIO SEA NEGRO O NULL, SI ES NULO TAMBIEN SERA NEGRO
					if(searchUncle(z.getKey()) == null || searchUncle(z.getKey()).getColor().equals(NodeRedBlackTree.BLACK)) {
						NodeRedBlackTree<T,K> father = searchElementBefore(z.getKey(), root);
						NodeRedBlackTree<T,K> grandFather = searchElementBefore(father.getKey(), root);
						NodeRedBlackTree<T,K> uncle = searchUncle(z.getKey());
						//SI MI TIO NEGRO NULO ES HIJO IZQUIERDO
						if(grandFather.sonNull() == 1) {
							if(father.under(z.getKey()) == -1) {
								//CASO 4, MI TIO ES NULO NEGRO IZQUIERDO, YO SOY HIJO DERECHO, SE FORMA LINEA
								z = caseFour(z);
							}
							else {
								z = caseThree(z);
							}
						}
						//MI TIO NEGRO NULO ES HIJO DERECHO
						else if(grandFather.sonNull() == -1){
							//SI MI TIO DERECHO NULO Y YO SOY HIJO IZQUIERDO
							if(father.under(z.getKey()) == 1) {
								z = caseFour(z);
							}
							//SI MI TIO DERECHO NEGRO NULO Y YO SOY HIJO DERECHO
							else {
								//CASO 3, TRIANGULO
								z = caseThree(z);
							}
						}
						else {
							//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO
							if(grandFather.under(uncle.getKey()) == -1) {
								//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO, SOY HIJO DERECHO DE MI PAPA.
								if(father.under(z.getKey()) == -1) {
									z = caseThree(z);
								}
								//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO, SOY HIJO IZQUIERDO DE MI PAPA.
								else {
									z = caseFour(z);
								}
							}
							//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO
							else {
								//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO, SOY HIJO DERECHO DE MI PAPA.
								if(father.under(z.getKey()) == -1) {
									z = caseFour(z);
								}
								//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO, SOY HIJO IZQUIERDO DE MI PAPA.
								else {
									z = caseThree(z);
								}
							}
						}
					}
					if(searchElementBefore(searchElementBefore(z.getKey(), root).getKey(), root) != null) {
						if(searchUncle(z.getKey()).getColor().equals(NodeRedBlackTree.RED)) {
							z = caseTwo(z);							
						}
					}
					if(z.equals(root)) {
						if(z.getColor().equals(NodeRedBlackTree.RED)) {
							z.changeColor();
							salir = true;
						}
					
					}
				}
			}	
	
	}
	
	public NodeRedBlackTree<T,K> caseTwo(NodeRedBlackTree<T,K> pointer) {
		
		NodeRedBlackTree<T,K> uncle = searchUncle(pointer.getKey());
		NodeRedBlackTree<T,K> father = searchElementBefore(pointer.getKey(), root);
		NodeRedBlackTree<T,K> grandFather = searchElementBefore(father.getKey(), root);
		uncle.setColor(NodeRedBlackTree.BLACK);
		father.setColor(NodeRedBlackTree.BLACK);
		grandFather.setColor(NodeRedBlackTree.RED);
		
		return grandFather;
		
	}
	
	public NodeRedBlackTree<T,K> caseThree(NodeRedBlackTree<T,K> pointer){
		
		NodeRedBlackTree<T,K> father = searchElementBefore(pointer.getKey(), root);
		if(father.under(pointer.getKey()) == -1) {
			leftRotation(pointer);
		}
		else {
			rightRotation(pointer);
		}
			
		return father;
	}
	
	public NodeRedBlackTree<T,K> caseFour(NodeRedBlackTree<T,K> pointer){
		
		NodeRedBlackTree<T,K> father = searchElementBefore(pointer.getKey(), root);
		NodeRedBlackTree<T,K> grandFather = searchElementBefore(father.getKey(), root);
		if(grandFather.under(father.getKey()) == 1) {
			rightRotation(father);
			father.changeColor();
			grandFather.changeColor();
			
		}
		else {
			leftRotation(father);
			father.changeColor();
			grandFather.changeColor();
		}
		
		return pointer;
		
	}
	
	public String inOrderDer(NodeRedBlackTree<T,K> node) {
	
		String h = "";
		
		if(root.getRightSon() != null) {
			h += root.getRightSon().getData() + ", " + root.getRightSon().getColor();
			return h;
		}
		else {
			return h;
		}		
	}

	public String inOrderLadoIzq(NodeRedBlackTree<T,K> node) {
		
		if(root.getLeftSon() == null) {
			return root.getLeftSon().getData() + ", " + root.getLeftSon().getColor();
		}
		else {
			return inOrderDer(node.getLeftSon());
		}		
	}
		
		
	public void imprimir(NodeRedBlackTree<T, K> node) {
		
		System.out.println(node);
		
	}
	
	
}
