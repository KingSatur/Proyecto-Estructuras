package dataStructures;

import tda.InterfaceCampiList;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class Abstract<T> implements InterfaceCampiList<T>, InterfaceCampiQueue<T>, InterfaceCampiStack<T> {

	private NodeAbstract<T> firstNode;
	private int size;
	
	public Abstract() {
		firstNode = null;
		size = 0;
	}
	
	public boolean isArmonic(char a, char b) {
		
		if(a == '{' && b == '}') {
			return true;
		}
		else if(a == '(' && b == ')') {
			return true;
		}
		else if(a == '[' && b == ']') {
			return true;
		}
		else {
			return false;
		}
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////	
	//Metodos de lista
	public NodeAbstract<T> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(NodeAbstract<T> firstNode) {
		this.firstNode = firstNode;
	}

	@Override
	public void addElement(T element) {
		
		if(firstNode == null) {
			NodeAbstract<T> newNode = new NodeAbstract<T>(element);
			size++;
			newNode.setPosition(size - 1);
			firstNode = newNode;
			
		}
		else {
			if(firstNode.getNextElement() == null) {
				NodeAbstract<T> newNode = new NodeAbstract<T>(element);
				size++;
				newNode.setPosition(size - 1);
				firstNode.setNextElement(newNode);
			}
			else {
				NodeAbstract<T> temporallyNode = firstNode;
				while(temporallyNode.getNextElement() != null) {
					temporallyNode = temporallyNode.getNextElement();
				}
				NodeAbstract<T> newNode = new NodeAbstract<T>(element);
				size++;
				newNode.setPosition(size - 1);
				temporallyNode.setNextElement(newNode);
			}
		}
	}

	@Override
	public void deleteElement(int position){
		
		if(position >= 0 && position < size) {
			NodeAbstract<T> temporally = firstNode;
			if(temporally.getPosition() == position) {
				if(searchElementAfter(temporally.getData()) != null) {
					substractPosition(temporally);
					firstNode = searchElementAfter(temporally.getData());
				}
				else {
					firstNode = null;
				}
				size--;
			}
			else {
				boolean back = false;
				while(temporally.getNextElement() != null && !back) {
					temporally = temporally.getNextElement();
					if(temporally.getPosition() == position) {
						if(searchElementAfter(temporally.getData()) != null) {
							substractPosition(temporally);
							NodeAbstract<T> before = searchElementBefore(temporally.getData());
							before.setNextElement(searchElementAfter(temporally.getData()));
							back = true;
						}
						else {
							NodeAbstract<T> before = searchElementBefore(temporally.getData());
							before.setNextElement(null);
							back = true;
						}
					}
				}
				size--;
			}
		}
				
	}

	@Override
	public NodeAbstract<T> searchElement(int position){
	
		NodeAbstract<T> toReturn = null;
 		
		if(position >= 0 && position < size) {
			NodeAbstract<T> temporally = firstNode;
			if(temporally.getPosition() == position) {
				toReturn = temporally;
			}
			else {
				boolean back = false;
				while(temporally.getNextElement() != null && !back)  {
					temporally = temporally.getNextElement();
					if(temporally.getPosition() == position) {
						toReturn = temporally;
						back = true;
					}
				}
			}
		}
		else {
			return null;
		}
		
		

		return toReturn;
	}
	
	public NodeAbstract<T> searchElementBefore(T element) {
		
		NodeAbstract<T> temporally = firstNode;
		NodeAbstract<T> before = null;

		boolean back = false;
		while(temporally.getNextElement() != null && !back) {
			if(temporally.getNextElement().getData().equals(element)) {
				before = temporally;
				back = true;
			}
			else {
				temporally = temporally.getNextElement();
			}
		}
		
		
		
		return before;
	}
	
	public NodeAbstract<T> searchLastElement(){
		
		NodeAbstract<T> actually = firstNode;
		
		while(actually.getNextElement() != null) {
			actually = actually.getNextElement();
		}
		
		return actually;
	}
	
	public NodeAbstract<T> searchElementAfter(T element){
		
		NodeAbstract<T> temporally = firstNode;
		NodeAbstract<T> after = null;
		
		boolean back = false;
		while(temporally.getNextElement() != null && !back) {
			if(temporally.getData().equals(element)) {
				after = temporally.getNextElement();
				back = true;
			}
			else {
				temporally = temporally.getNextElement();
			}
			
		}
		return after;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void substractPosition(NodeAbstract<T> a) {
		
		NodeAbstract<T> temporally = a;
		
		if(temporally != null) {
			if(temporally.getNextElement() != null) {
				while(temporally.getNextElement() != null) {
					temporally = temporally.getNextElement();
					temporally.setPosition(temporally.getPosition() - 1);
				}
			}
		}
		
	}

///////////////////////////////////////////////////////////////////////////	
	//Metodos de pila
	@Override
	public void push(T data) {
		
		if(this.getFirstNode() == null) {
			NodeAbstract<T> node = new NodeAbstract<T>(data);
			firstNode = node;
			size++;
		}
		else {
			NodeAbstract<T> node = new NodeAbstract<T>(data);
			node.setNextElement(firstNode);
			firstNode = node;
			size++;
		}
	}

	@Override
	public NodeAbstract<T> top() {
		return firstNode;
	}

	@Override
	public T pop() {
		
		T dataDeleted = null;
		
		if(isEmpty()) {
			dataDeleted = null;
		}
		else {
			if(top().getNextElement() == null) {
				dataDeleted = top().getData();
				firstNode = null;
				size--;
			}
			else {
				dataDeleted = firstNode.getData();
				firstNode = firstNode.getNextElement();
				size--;
			}
		}
		
		return dataDeleted;
	}

///////////////////////////////////////////////////////////////////////////
	//Metodos de cola
	@Override
	public NodeAbstract<T> front() {
		return firstNode;
	}

	@Override
	public void enqueue(T data) {
		
		NodeAbstract<T> nodeToEnqueue = new NodeAbstract<T>(data);
		
		if(firstNode == null) {
			firstNode = nodeToEnqueue;
			size ++;
		}
		else {
			if(firstNode.getNextElement() == null) {
				nodeToEnqueue.setPosition(size - 1);
				firstNode.setNextElement(nodeToEnqueue);
				size++;
			}
			else {
				NodeAbstract<T> temporallyNode = firstNode;
				while(temporallyNode.getNextElement() != null) {
					temporallyNode = temporallyNode.getNextElement();
				}
				nodeToEnqueue.setPosition(size - 1);
				temporallyNode.setNextElement(nodeToEnqueue);
				size++;
			}
		}
	}

	@Override
	public T dequeue() {
		
		T dataDeleted = null;

		if(isEmpty()) {
			dataDeleted = null;
		}
		else {
			if(front().getNextElement() == null) {
				dataDeleted = front().getData();
				firstNode = null;
				size --;
			}
			else {
				dataDeleted = front().getData();
				firstNode = firstNode.getNextElement();
				size--;
			}
		}
						
		return dataDeleted;
		
	}	

}
