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
import dataStructures.Abstract;
import graph.Undirected.AdjacencyListUndirected;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class AdjacencyList<V,K extends Comparable<K>> extends Graph<V,K>  implements iGraphList<V,K>{

	protected HashMap<K, PriorityQueue<Node<V,K>>> adj;
	private double minimumRouteSume;
	
	public AdjacencyList() {
		super();
		minimumRouteSume = 0;
		adj = new HashMap<K, PriorityQueue<Node<V,K>>>();
	}
	
	

	public double getMinimumRouteSume() {
		return minimumRouteSume;
	}



	public void setMinimumRouteSume(double minimumRouteSume) {
		this.minimumRouteSume = minimumRouteSume;
	}



	@Override
	public HashMap<K,K> dfs(Node<V,K> source) {
		
		HashMap<K, Boolean> visited = new HashMap<K, Boolean>();
		ArrayList<Node<V,K>> nodesVisited = new ArrayList<>();
		HashMap<K,K> fathers = new HashMap<K,K>();
		InterfaceCampiStack<Node<V, K>> stack = new Abstract<Node<V,K>>();
		
		for (K key : super.getNodes().keySet()) {
			visited.put(key, false);
		}
		
		//VISITO EL NODO DE ORIGEN
		visited.put((K) source.getKey(), true);
		//LO AGREGO A LA PILA
		stack.push(source);
		
		//MIENTRAS LA PILA NO ESTE VACIA Y LA RUTA TENGA UNA CANTIDAD DE NODOS DISTINTA A LA DE LOS NODOS DEL GRAFO
		while (!stack.isEmpty() && fathers.size() != super.getNodes().size() - 1) {
			Node<V, K> u = stack.pop();
//			System.out.println(u.getValue());
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				if (!visited.get(nodeAdjacenty.getKey())) {
//					v.setColor(Node.GRAY);
//					v.setDistance(u.getDistance() + 1);
					stack.push((nodeAdjacenty));
				}
			}
//			if(fathers.size() == 0) {
//				fathers.put(u.getKey(), u.getKey());
//				visited.put(u.getKey(),true );
//			}
//			else {
				fathers.put(stack.top().getData().getKey(), u.getKey());
				visited.put(u.getKey(),true );
//			}
		}
		
		return fathers;
	}
	
	
	@Override
	public HashMap<K,K> bfs(Node<V,K> source) {
		
		ArrayList<Node<V,K>> nodesVisited = new ArrayList<>();
		HashMap<K, Boolean> visited = new HashMap<K, Boolean>();
		HashMap<K, K> fathers = new HashMap<K, K>();
		
	
		for (K key : super.getNodes().keySet()) {
			visited.put(key, false);
		}
	
		visited.put((K) source.getKey(), true);
		InterfaceCampiQueue<Node<V, K>> queue = new Abstract<Node<V, K>>();
		queue.enqueue(source);
		while (!queue.isEmpty() && fathers.size() != super.getNodes().size() - 1) {
			Node<V, K> u = queue.dequeue();
//			System.out.println(u.getValue());
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				Node<V, K> v = nodeAdjacenty;
				if (!visited.get(v.getKey())) {
//					v.setColor(Node.GRAY);
//					v.setDistance(u.getDistance() + 1);
					queue.enqueue(v);
					if(queue.front().getData().equals(u)) {
						queue.dequeue();
					}
				}
			}
			fathers.put(queue.front().getData().getKey(), u.getKey());
			visited.put(u.getKey(),true );
//			visited.put(u.getKey(),true );
//			nodesVisited.add(u);
		}
		
		//LLENO EL HASH DE PADRES, DE ACUERDO A LA RUTA
		return fathers;
	}
	
	public void fillDistances(HashMap<K, Double> distances) {
				
		for(Node<V,K> node: super.getNodes().values()) {
			K m = node.getKey();
			distances.put(m, Double.POSITIVE_INFINITY);
		}				
	}
	
	public void fillVisitedFalse(HashMap<K, Boolean> visited) {
	
		for(K key : super.getNodes().keySet()) {
			visited.put(key, false);
		}	
	}
	
	public void fillFathers(HashMap<K,K> fathers) {
		
		for(K key: super.getNodes().keySet()) {
			fathers.put(key, key);
		}
		
	}

	@Override
	public HashMap<K, Double> dijsktra(Node<V,K> source) {
		
		//INICIO LAS DISTANCIAS EN INFINITO Y LOS VISITADOS
		HashMap<K, Double> distances = new HashMap<K, Double>();
		fillDistances(distances);
		HashMap<K, Boolean> visited = new HashMap<K, Boolean>();
		fillVisitedFalse(visited);
				
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
		
		return distances;
	}
	
	public void relaxEdges(Queue<Edge> m,  Queue<Node<V,K>> j, Node<V,K> node, HashMap<K, Double> distances) {
		
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
	public HashMap<K,K> kruscal() {
		
		Comparator<Edge> m = new EdgeCompare();
		PriorityQueue<Edge<K>> edgesQueue = new PriorityQueue<Edge<K>>(m);
		HashMap<Edge<K>, K> sourceEdgeUbication = new HashMap<Edge<K>, K>();
		HashMap<K, Boolean> visited = new HashMap<K, Boolean>();
		HashMap<K,K> fathers = new HashMap<K,K>();
		
		//OBTENGO LAS ARISTAS DE TODO EL GRAFO Y LAS ORDENO
		for(Node<V,K> node: super.getNodes().values()) {
			for(Edge<K> e : node.getEdges().values()) {
				edgesQueue.add(e);
				sourceEdgeUbication.put(e, node.getKey());
			}
		}
		
		//INICIALIZO LA RUTA DE PADRES Y LA ESTRUCTURA DE UNION
		UnionStructure<V,K> union = new UnionStructure<V,K>();
		
		for(K key: super.getNodes().keySet()) {
			union.getNodesUbication().put(key, key);
			union.getNodesHash().put(key, new Hashtable<K, Node<V,K>>());
		}
		
		while(visited.size() != super.getNodes().size()) {
			K keySource = sourceEdgeUbication.get(edgesQueue.peek());
			if(visited.get(keySource) != null && visited.get(edgesQueue.peek().getEnd().getKey()) != null) {
				if(visited.get(keySource) && visited.get(edgesQueue.peek().getEnd().getKey())){
					edgesQueue.poll();
				}						
			}
			else {
				if(! union.find(edgesQueue.peek().getEnd()).equals(keySource)) {
					minimumRouteSume += edgesQueue.peek().getWeightKey();
					union.union(super.getNodes().get(keySource), edgesQueue.peek().getEnd());
					visited.put(keySource, true);
					visited.put((K) edgesQueue.peek().getEnd().getKey(), true);
					if(fathers.containsKey((edgesQueue.peek().getEnd().getKey())) && fathers.containsKey(keySource)) {
						fathers.put(keySource, (K)edgesQueue.peek().getEnd().getKey());
						edgesQueue.poll();
					}
					else {
						fathers.put((K)edgesQueue.peek().getEnd().getKey(), keySource);
						edgesQueue.poll();						
					}
				}
			}
		}
		
		return fathers;
		
	}

	@Override
	public HashMap<K,K> prim(Node<V,K> source) {
		
		//CREO LA RUTA DE PADRES
		HashMap<K,K> fathers = new HashMap<K,K>();
		HashMap<Edge<K>, K> sourceUbication = new HashMap<Edge<K>, K>();
		
		//INICIALIZO LA SUMA DE LA RUTA EN CERO
		minimumRouteSume = 0;
		Comparator<Edge> m = new EdgeCompare();
		
		//CREO EL HASH DE VISITADOS, Y LOS LLENO
		Hashtable<K, Boolean> visited = new Hashtable<K, Boolean>();
		fillVisited(visited);
		
		//CREO LA COLA DE ARISTAS
		PriorityQueue<Edge<K>> edgesQueue = new PriorityQueue<Edge<K>>(m);
		
		//VISITO EL NODO SOURCE
		visited.put(source.getKey(), true);
		
		//ENCOLO LA COLA POR LAS ARISTAS DEL NODO SOURCE
		fillQueue(edgesQueue, source, sourceUbication);
		
		while(fathers.size() != super.getNodes().size() - 1) {
			Node<V,K> node = edgesQueue.peek().getEnd();
			if(visited.get(node.getKey())) {
				edgesQueue.poll();
			}
			else {
				visited.put(node.getKey(), true);
				minimumRouteSume += edgesQueue.peek().getWeightKey();
				if(fathers.size() == 0) {
					fathers.put(node.getKey(), sourceUbication.get(edgesQueue.peek()));
					edgesQueue.poll();
					fillQueue(edgesQueue, node, sourceUbication);
				}
				else {
					fathers.put(node.getKey(), sourceUbication.get(edgesQueue.peek()));
					edgesQueue.poll();
					fillQueue(edgesQueue, node, sourceUbication);
				}

			}
		}
		
		return fathers;
	}

	
	public void fillVisited(Hashtable<K, Boolean> visited) {
		
		for(K key : super.getNodes().keySet()) {
			visited.put(key, false);
		}
		
	}
	
	
	public void fillQueue(PriorityQueue<Edge<K>> queue, Node<V,K> node, HashMap<Edge<K>, K> sourceUbication) {
		
		for(Edge e : node.getEdges().values()) {
			queue.add(e);
			sourceUbication.put(e, node.getKey());
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
		Node<String,Integer> n1 = new Node<String,Integer>("V1", 10);
		Node<String,Integer> n2 = new Node<String,Integer>("V2", 20);
		Node<String,Integer> n3 = new Node<String,Integer>("V3", 30);
		Node<String,Integer> n4 = new Node<String,Integer>("V4", 40);
		Node<String,Integer> n5 = new Node<String,Integer>("V5", 50);
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		graph.addEdge(10, 20, 10, 10);
		graph.addEdge(10, 50, 20, 21);
		graph.addEdge(20, 50, 3, 80);
		graph.addEdge(20, 40, 5, 5);
		graph.addEdge(30, 20, 7, 40);
		graph.addEdge(30, 10, 37, 60);
		graph.addEdge(40, 10, 2, 30);
		graph.addEdge(40, 30, 19, 70);
		graph.addEdge(50, 40, 13, 4);
		graph.addEdge(50, 30, 6, 3);
		HashMap<Integer, Integer> distances = graph.bfs(n1);
		int j = 100;
		
		
		
		

		
		
		
		
	}
	
}