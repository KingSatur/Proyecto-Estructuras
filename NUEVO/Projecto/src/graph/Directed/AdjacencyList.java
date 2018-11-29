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
	private ArrayList<Node<V,K>> generalRoute;
	private HashMap<K,K> fathers;
	private HashMap<K, Boolean> nodesVisited;
	private InterfaceCampiStack<Node<V,K>> stack;
	private InterfaceCampiQueue<Node<V,K>> queue;
	private HashMap<K, Double> distances;
	private PriorityQueue<Node<V,K>> nodesQueue;
	private PriorityQueue<Edge<K>> edgesQueue;
	
	
	
	public AdjacencyList() {
		super();
		minimumRouteSume = 0;
		stack = new Abstract<Node<V,K>>();
		queue = new Abstract<Node<V,K>>();
		distances = new HashMap<K, Double>();
		fathers = new HashMap<K,K>();
		generalRoute = new ArrayList<Node<V,K>>();
		nodesVisited = new HashMap<K, Boolean>();
		adj = new HashMap<K, PriorityQueue<Node<V,K>>>();
		nodesQueue = new PriorityQueue<Node<V,K>>();
		edgesQueue = new PriorityQueue<Edge<K>>();
	}
	
	
	public HashMap<K, K> getFathers() {
		return fathers;
	}

	public void setFathers(HashMap<K, K> fathers) {
		this.fathers = fathers;
	}

	public ArrayList<Node<V, K>> getGeneralRoute() {
		return generalRoute;
	}

	public void setGeneralRoute(ArrayList<Node<V, K>> generalRoute) {
		this.generalRoute = generalRoute;
	}

	public double getMinimumRouteSume() {
		return minimumRouteSume;
	}

	public void setMinimumRouteSume(double minimumRouteSume) {
		this.minimumRouteSume = minimumRouteSume;
	}

	@Override
	public HashMap<K,K> dfs(Node<V,K> source) {
		
		//VACIO LAS ESTRUCTURAS
		generalRoute.clear();
		nodesVisited.clear();
		nodesQueue.clear();
		edgesQueue.clear();
		
		//VACIO LA RUTA GENERAL PARA APLICAR EL ALGORITMO
		generalRoute.clear();
		nodesVisited = new HashMap<K, Boolean>();
		fillVisitedFalse(nodesVisited);
		fathers = new HashMap<K,K>();
		stack = new Abstract<Node<V,K>>();
		
		for (K key : super.getNodes().keySet()) {
			nodesVisited.put(key, false);
		}
		
		//VISITO EL NODO DE ORIGEN
		nodesVisited.put((K) source.getKey(), true);
		stack.push(source);
		
		while (!stack.isEmpty() && fathers.size() != super.getNodes().size() && generalRoute.size() != super.getNodes().size()) {
			Node<V, K> u = stack.pop();
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				if (!nodesVisited.get(nodeAdjacenty.getKey())) {
					stack.push((nodeAdjacenty));
				}
			}
			fathers.put(stack.top().getData().getKey(), u.getKey());
			if(!generalRoute.contains(u)) {
				generalRoute.add(u);				
			}
			nodesVisited.put(u.getKey(),true );
		}
		
		return fathers;
	}
	
	
	
	
	@Override
	public HashMap<K,K> bfs(Node<V,K> source) {
		
		//VACIO LAS ESTRUCTURAS
		generalRoute.clear();
		nodesVisited.clear();
		nodesQueue.clear();
		edgesQueue.clear();
		
		//VACIO LA RUTA GENERAL PARA APLICAR EL ALGORITMO
		generalRoute.clear();
		nodesVisited = new HashMap<K, Boolean>();
		fillVisitedFalse(nodesVisited);
		fathers = new HashMap<K, K>();
		
		for (K key : super.getNodes().keySet()) {
			nodesVisited.put(key, false);
		}
	
		nodesVisited.put((K) source.getKey(), true);
		queue = new Abstract<Node<V, K>>();
		queue.enqueue(source);
		while (!queue.isEmpty() && fathers.size() != super.getNodes().size()  && generalRoute.size() != super.getNodes().size()) {
			Node<V, K> u = queue.dequeue();
			for (Node<V, K> nodeAdjacenty : u.getNeighbors()) {
				Node<V, K> v = nodeAdjacenty;
				if (!nodesVisited.get(v.getKey())) {
					queue.enqueue(v);
					if(queue.front().getData().equals(u)) {
						queue.dequeue();
					}
				}
			}
			fathers.put(queue.front().getData().getKey(), u.getKey());
			if(!generalRoute.contains(u)) {
				generalRoute.add(u);				
			}
			nodesVisited.put(u.getKey(),true );								
		}
		
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
		
		//VACIO LAS ESTRUCTURAS
		generalRoute.clear();
		nodesVisited.clear();
		nodesQueue.clear();
		edgesQueue.clear();
		distances.clear();
		
		//INICIO LAS DISTANCIAS EN INFINITO Y LOS VISITADOS
		fillDistances(distances);
		fillVisitedFalse(nodesVisited);
				
		//COLOCO LA DISTANCE A EL MISMO EN 0
		distances.put(source.getKey(), 0.0);
		
		Comparator<Edge> m = new EdgeCompare();
		edgesQueue = new PriorityQueue<Edge<K>>(m);		
		nodesQueue = new PriorityQueue<Node<V,K>>();
		
		for(Edge e: source.getEdges().values()) {
			edgesQueue.add(e);
		}
		while(!edgesQueue.isEmpty()) {
			double distance = edgesQueue.peek().getWeightKey();
			Node<V,K> node = edgesQueue.peek().getEnd();
			distances.put(node.getKey(), distance);
			nodesQueue.add(node);
			edgesQueue.poll();
		}
		while(!nodesQueue.isEmpty()) {
			Node<V,K> nodeVisit = nodesQueue.poll();
			if(!(nodesVisited.get(nodeVisit.getKey()))){
				nodesVisited.put(nodeVisit.getKey(), true);
				relaxEdges(edgesQueue, nodesQueue, nodeVisit, distances);
			}
		}				
		
		return distances;
	}
	
	public void relaxEdges(PriorityQueue<Edge<K>> m,  Queue<Node<V,K>> j, Node<V,K> node, HashMap<K, Double> distances) {
		
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
		
		//VACIO LAS ESTRUCTURAS
		generalRoute.clear();
		nodesVisited.clear();
		nodesQueue.clear();
		edgesQueue.clear();
		
		
		Comparator<Edge> m = new EdgeCompare();
		edgesQueue = new PriorityQueue<Edge<K>>(m);
		HashMap<Edge<K>, K> sourceEdgeUbication = new HashMap<Edge<K>, K>();
		
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
		
		while(nodesVisited.size() != super.getNodes().size()) {
			K keySource = sourceEdgeUbication.get(edgesQueue.peek());
			if(nodesVisited.get(keySource) != null && nodesVisited.get(edgesQueue.peek().getEnd().getKey()) != null) {
				if(nodesVisited.get(keySource) && nodesVisited.get(edgesQueue.peek().getEnd().getKey())){
					edgesQueue.poll();
				}						
			}
			else {
				if(! union.find(edgesQueue.peek().getEnd()).equals(keySource)) {
					minimumRouteSume += edgesQueue.peek().getWeightKey();
					union.union(super.getNodes().get(keySource), edgesQueue.peek().getEnd());
					nodesVisited.put(keySource, true);
					nodesVisited.put((K) edgesQueue.peek().getEnd().getKey(), true);
					if(fathers.containsKey((edgesQueue.peek().getEnd().getKey())) && fathers.containsKey(keySource)) {
						fathers.put(keySource, (K)edgesQueue.peek().getEnd().getKey());
						generalRoute.add(edgesQueue.peek().getEnd());
						edgesQueue.poll();
					}
					else {
						fathers.put((K)edgesQueue.peek().getEnd().getKey(), keySource);
						generalRoute.add(edgesQueue.peek().getEnd());
						edgesQueue.poll();						
					}
				}
			}
		}
		
		return fathers;
		
	}

	@Override
	public HashMap<K,K> prim(Node<V,K> source) {
		
		
		//VACIO LAS ESTRUCTURAS
		generalRoute.clear();
		nodesVisited.clear();
		nodesQueue.clear();
		edgesQueue.clear();
		
		//CREO HASH DE UBICACION
		HashMap<Edge<K>, K> sourceUbication = new HashMap<Edge<K>, K>();
		minimumRouteSume = 0;
		Comparator<Edge> m = new EdgeCompare();
		edgesQueue = new PriorityQueue<Edge<K>>(m);
		fillVisited(nodesVisited);

		//VISITO EL NODO SOURCE
		nodesVisited.put(source.getKey(), true);
		
		//ENCOLO LA COLA POR LAS ARISTAS DEL NODO SOURCE
		fillQueue(edgesQueue, source, sourceUbication);
		
		while(fathers.size() != super.getNodes().size() - 1) {
			Node<V,K> node = edgesQueue.peek().getEnd();
			if(nodesVisited.get(node.getKey())) {
				edgesQueue.poll();
			}
			else {
				nodesVisited.put(node.getKey(), true);
				minimumRouteSume += edgesQueue.peek().getWeightKey();
				if(fathers.size() == 0) {
					fathers.put(node.getKey(), sourceUbication.get(edgesQueue.peek()));
					generalRoute.add(node);
					edgesQueue.poll();
					fillQueue(edgesQueue, node, sourceUbication);
				}
				else {
					fathers.put(node.getKey(), sourceUbication.get(edgesQueue.peek()));
					generalRoute.add(node);
					edgesQueue.poll();
					fillQueue(edgesQueue, node, sourceUbication);
				}

			}
		}
		
		return fathers;
	}

	
	public void fillVisited(HashMap<K, Boolean> visited) {
		
		for(K key : super.getNodes().keySet()) {
			visited.put(key, false);
		}
		
	}
	
	
	public void fillQueue(Queue<Edge<K>> queue, Node<V,K> node, HashMap<Edge<K>, K> sourceUbication) {
		
		for(Edge<K> e : node.getEdges().values()) {
			queue.add(e);
			sourceUbication.put(e, node.getKey());
		}
		
	}
	
	
	
	@Override
	public void addEdge(K keySource, K keyDestiny, K keyEdge, double weight) {
		super.getNodes().get(keySource).addEdge(super.getNodes().get(keyDestiny), keyEdge, weight);		
		adj.put(keySource, super.getNodes().get(keySource).getNeighbors());
		EdgeSrcEnd<K> edge = new EdgeSrcEnd<K>(super.getNodes().get(keySource), super.getNodes().get(keyDestiny), keyEdge, weight);
		super.getGeneralEdges().put(edge.getKey(), edge);
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
	
	
	
	
	
	
	
	
}