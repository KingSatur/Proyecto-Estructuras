package graph.Directed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import Interface.iGraphList;

public class AdjacencyList<V,K extends Comparable<K>> extends Graph<V,K>  implements iGraphList<V,K>{

	private HashMap<K, PriorityQueue<Node<V,K>>> adj;
	private double routSume;
	
	public AdjacencyList() {
		super();
		routSume = 0;
		adj = new HashMap<K, PriorityQueue<Node<V,K>>>();
	}

	
	@Override
	public ArrayList<Node<V,K>> dfs(Node<V,K> source) {
		
		Hashtable<K, Boolean> visited = new Hashtable<K, Boolean>();
		
		for (K key : visited.keySet()) {
			visited.put(key, false);
		}
		
		ArrayList nodesVisited = new ArrayList<>();
		visited.put((K) source.getKey(), true);
//		nodesVisited.add(s);
		Stack<Node<V, K>> stack = new Stack<Node<V,K>>();
		stack.add(source);
				
		while (!stack.isEmpty()) {
			Node<V, K> u = stack.pop();
//			System.out.println(u.getValue());
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				Node<V, K> v = nodeAdjacenty;
				if ((boolean)!visited.get(v.getKey())) {
//					v.setColor(Node.GRAY);
//					v.setDistance(u.getDistance() + 1);
					stack.add(v);
				}
			}
			visited.put(u.getKey(),true );
			nodesVisited.add(u);
		}
		
		
		
		return nodesVisited;
	}

	@Override
	public ArrayList<Node<V,K>> bfs(Node<V,K> source) {
		
//		for (Node<T, K> value : vertices.values()) {
//		if (!(value.equals(s))) {
//			value.setColor(Node.WHITE);
//		}
//		value.setDistance(0);
//	}
		ArrayList nodesVisited = new ArrayList<>();
		Hashtable<K, Boolean> visited = new Hashtable<K, Boolean>();
	
	
		for (K key : visited.keySet()) {
			visited.put(key, false);
		}
	
		visited.put((K) source.getKey(), true);
		Queue<Node<V, K>> queue = new LinkedList<Node<V, K>>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Node<V, K> u = queue.poll();
//			System.out.println(u.getValue());
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				Node<V, K> v = nodeAdjacenty;
				if ((boolean)!visited.get(v.getKey())) {
//					v.setColor(Node.GRAY);
//					v.setDistance(u.getDistance() + 1);
					queue.add(v);
				}
			}
			visited.put(u.getKey(),true );
			nodesVisited.add(u);
		}
	
		return nodesVisited;	
	}
	
	public Hashtable<K, Double> fillDistances() {
		
		Hashtable<K, Double> distances = new Hashtable<K, Double>();
		
		for(Node<V,K> node: super.getNodes().values()) {
			K m = node.getKey();
			distances.put(m, Double.POSITIVE_INFINITY);
		}		
		
		return distances;
		
	}

	@Override
	public void dijsktra(Node<V,K> source) {
		
		//INICIO LAS DISTANCIAS EN INFINITO Y LOS VISITADOS
		Hashtable<K, Double> distances = fillDistances();
		Hashtable<K, Boolean> visited = new Hashtable<K, Boolean>();
		//COLOCO LA DISTANCE A EL MISMO EN 0
		distances.put(source.getKey(), 0.0);
		
		Comparator<Edge> m = new EdgeCompare();
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(m);		
		PriorityQueue<Node<V,K>> queueNodes = new PriorityQueue<Node<V,K>>();
		
		for(Edge e: source.getEdges().values()) {
			queue.add(e);
		}
		while(!queue.isEmpty()) {
			double distance = queue.peek().getWeightKey();
			Node<V,K> node = queue.peek().getEnd();
			distances.put(node.getKey(), distance);
			queueNodes.add(node);
			queue.poll();
		}
		while(!queueNodes.isEmpty()) {
			Node<V,K> nodeVisit = queueNodes.poll();
			if(!(visited.get(nodeVisit.getKey()))){
				visited.put(nodeVisit.getKey(), true);
				relaxEdges(queue, queueNodes, nodeVisit, distances);
			}
		}				
		
	}
	
	public void relaxEdges(Queue<Edge> m,  Queue<Node<V,K>> j, Node<V,K> node, Hashtable<K, Double> distances) {
		
		for(Edge e : node.getEdges().values()) {
			m.add(e);
		}
		while(!m.isEmpty()) {
			double distance = m.peek().getWeightKey() + distances.get(node.getKey());
			if(distance < distances.get(m.peek().getEnd().getKey())) {
				distances.put((K) m.peek().getEnd().getKey(), distance);
			}
			j.add(m.poll().getEnd());
		}
	}

	
	@Override
	public void kruscal() {
		
		Comparator<Edge> m = new EdgeCompare();
		PriorityQueue<Edge> edgesQueue = new PriorityQueue<Edge>(m);
		
		//OBTENGO LAS ARISTAS DE TODO EL GRAFO Y LAS ORDENO
		for(Node<V,K> node: super.getNodes().values()) {
			for(Edge e : node.getEdges().values()) {
				edgesQueue.add(e);
			}
		}
	
		//INICIALIZO LA RUTA DE PADRES Y LA ESTRUCTURA DE UNION
		ArrayList<Node<V,K>> route = new ArrayList<Node<V,K>>();
		UnionStructure<V,K> union = new UnionStructure<V,K>();
		
		for(K key: super.getNodes().keySet()) {
			union.getNodesUbication().put(key, key);
			union.getNodesHash().put(key, null);
		}
		
		while(route.size() != super.getNodes().size()) {
			
		}
		
		
		
	}

	@Override
	public ArrayList<Node<V,K>> prim(Node<V,K> source) {
		
		//CREO LA RUTA DE PADRES
		ArrayList<Node<V,K>> route = new ArrayList<Node<V,K>>();
		
		//INICIALIZO LA SUMA DE LA RUTA EN CERO
		routSume = 0;
		Comparator<Edge> m = new EdgeCompare();
		
		//CREO EL HASH DE VISITADOS
		Hashtable<K, Boolean> visited = new Hashtable<K, Boolean>();
		
		//CREO LA COLA DE ARISTAS
		PriorityQueue<Edge<K>> edgesQueue = new PriorityQueue<Edge<K>>(m);
		
		//VISITO EL NODO SOURCE
		visited.put(source.getKey(), true);
		
		//ENCOLO LA COLA POR LAS ARISTAS DEL NODO SOURCE
		fillQueue(edgesQueue, source);
		
		//AGREGO EL SOURCE A LA RUTA
		route.add(source);

		
		while(route.size() != super.getNodes().size()) {
			Node<V,K> node = edgesQueue.peek().getEnd();
			if(visited.get(node.getKey())) {
				edgesQueue.poll();
			}
			else {
				visited.put(node.getKey(), true);
				routSume += edgesQueue.peek().getWeightKey();
				route.add(node);
				edgesQueue.poll();
				fillQueue(edgesQueue, node);
			}
		}
		
		return route;
	}

	public void fillQueue(PriorityQueue<Edge<K>> queue, Node<V,K> node) {
		
		for(Edge e : node.getEdges().values()) {
			queue.add(e);
		}
		
	}
	
	
	@Override
	public void addEdge(K keySource, K keyDestiny, K keyEdge, double weight) {
		super.getNodes().get(keySource).addEdge(super.getNodes().get(keyDestiny), keyEdge, weight);		
		adj.put(keySource, super.getNodes().get(keySource).getNeighbors());
	}

	@Override
	public void removeEdge(K keyNode, K keyEdge) {
		super.getNodes().get(keyNode).removeEdge(keyEdge);		
	}

	
	@Override
	public void removeNode(K nodeKey) {
		super.getNodes().remove(nodeKey);
		adj.remove(nodeKey);
	}



	@Override
	public void addNode(Node<V, K> newNode) {
		super.getNodes().put(newNode.getKey(), newNode);
	}
	
	
	public static void main(String[] args) {
		
		AdjacencyList<String,Integer> graph = new AdjacencyList<String,Integer>();
		Node<String,Integer> n1 = new Node<String,Integer>("A", 10);
		Node<String,Integer> n2 = new Node<String,Integer>("B", 60);
		Node<String,Integer> n3 = new Node<String,Integer>("C", 100);
		Node<String,Integer> n4 = new Node<String,Integer>("D", 67);
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addEdge(n1.getKey(), n2.getKey(), 3, 40);
		graph.addEdge(n1.getKey(), n3.getKey(), 6, 100);
		graph.addEdge(n2.getKey(), n3.getKey(), 2, 1);
		graph.addEdge(n3.getKey(), n4.getKey(), 6, 4);
		
		int j = 100;
		
		
		
	}
	
}
