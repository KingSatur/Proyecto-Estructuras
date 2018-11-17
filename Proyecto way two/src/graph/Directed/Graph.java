package graph.Directed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import graph.Undirected.UndirectedGraph;

public class Graph<V, K extends Comparable<K>> {
	
	private static final double BIG_CONSTANT = Double.POSITIVE_INFINITY;
	private HashMap<K, Node<V,K>> nodes;
	private int[][] adjacencyMatrix;
	private HashMap parent;
	private HashMap<K, Boolean> visited; 
	private HashMap<K, Double> distances;
	private ArrayList<Node<V,K>> route;
	private ArrayList<K> keys;
	private double routSume;
	
	public Graph() {
		super();
		routSume = 0;
		nodes = new HashMap<>();
		visited = new HashMap<>();
		distances = new HashMap<K, Double>();
		keys = new ArrayList<K>();
		route = new ArrayList<Node<V,K>>();
	}
	
	public ArrayList<K> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<K> keys) {
		this.keys = keys;
	}

	public void updateMatrix() {
		
		keys = new ArrayList<K>();
		for(K key: nodes.keySet()) {
			keys.add(key);
		}
		
		if(adjacencyMatrix != null) {
			if(nodes.size() == adjacencyMatrix.length && nodes.size() == adjacencyMatrix[0].length) {
				for(int i = 0; i < adjacencyMatrix.length ; i ++) {
					for(int j = 0; j < adjacencyMatrix.length ; j ++) {
						if(nodes.get(keys.get(i)).getNeighbors().contains(nodes.get(keys.get(j)))) {
							adjacencyMatrix[i][j] = 1;
						}
						else {
							adjacencyMatrix[i][j] = 0;
						}
					}
				}
			}
			else {
				adjacencyMatrix = new int[nodes.size()][nodes.size()];
				for(int i = 0; i < adjacencyMatrix.length ; i ++) {
					for(int j = 0; j < adjacencyMatrix.length ; j ++) {
						if(nodes.get(keys.get(i)).getNeighbors().contains(nodes.get(keys.get(j)))) {
							adjacencyMatrix[i][j] = 1;
						}
						else {
							adjacencyMatrix[i][j] = 0;
						}
					}
				}
			}
			
		}
		else {
			adjacencyMatrix = new int[nodes.size()][nodes.size()];
			for(int i = 0; i < adjacencyMatrix.length ; i ++) {
				for(int j = 0; j < adjacencyMatrix.length ; j ++) {
					if(nodes.get(keys.get(i)).getNeighbors().contains(nodes.get(keys.get(j)))) {
						adjacencyMatrix[i][j] = 1;
					}
					else {
						adjacencyMatrix[i][j] = 0;
					}
				}
			}
		}
	}
	
	public HashMap<K, Node<V, K>> getNodes() {
		return nodes;
	}
	
	public void setNodes(HashMap<K, Node<V, K>> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node newNode) {
		nodes.put((K) newNode.getKey(), newNode);
		visited.put((K) newNode.getKey(), false);
	}
	
	public void removeNode(K keyNode) {
		nodes.remove(keyNode);	
		visited.remove(keyNode);
	}
	
	public void addEdge(K keyNodeStart, K keyNodeEnd, K keyEdge, double weight) {
		Node<V,K> nodeEnd = nodes.get(keyNodeEnd);
		nodes.get(keyNodeStart).addEdge(nodeEnd, keyEdge,  weight);
	}
	
	public void removeEdge(K keyNode, K keyEdge) {
		nodes.get(keyNode).removeEdge(keyEdge);
	}
	
	public void fillDistances() {
		
		for(Node<V,K> node: nodes.values()) {
			K m = node.getKey();
			distances.put(m, BIG_CONSTANT);
		}		
		
	}
	
	public ArrayList<Node> dfs(Node s){
		
		for (K key : visited.keySet()) {
			visited.put(key, false);
		}
		
		ArrayList nodesVisited = new ArrayList<>();
		visited.put((K) s.getKey(), true);
//		nodesVisited.add(s);
		Stack<Node<V, K>> stack = new Stack<Node<V,K>>();
		stack.add(s);
				
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
	
	public ArrayList<Node> bfs(Node s){
//		for (Node<T, K> value : vertices.values()) {
//			if (!(value.equals(s))) {
//				value.setColor(Node.WHITE);
//			}
//			value.setDistance(0);
//		}
		ArrayList nodesVisited = new ArrayList<>();
		
		
		for (K key : visited.keySet()) {
			visited.put(key, false);
		}
		
		visited.put((K) s.getKey(), true);
		Queue<Node<V, K>> queue = new LinkedList<Node<V, K>>();
		queue.add(s);
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
	
	public void djikstra(Node<V,K> s) {
		
		fillDistances();
		distances.put(s.getKey(), (double) 0);
		Comparator<Edge> m = new EdgeCompare();
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(m);		
		PriorityQueue<Node<V,K>> queueNodes = new PriorityQueue<Node<V,K>>();
		
		for(Edge e: s.getEdges().values()) {
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
				relaxEdges(queue, queueNodes, nodeVisit);
			}
		}				
	}
	
	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public void relaxEdges(Queue<Edge> m,  Queue<Node<V,K>> j, Node<V,K> node) {
		
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
	
	public double[][] floydWarshall() {
		
		double[][] distanceMatrix = initializateDistanceMatrix();
		
		for(int k = 0; k < distanceMatrix.length ; k ++) {
			for(int i = 0; i < distanceMatrix.length; i ++) {
				for(int j = 0; j < distanceMatrix[0].length ; j ++) {
					distanceMatrix[i][j] = Math.min(distanceMatrix[i][j] ,distanceMatrix[i][k] + distanceMatrix[k][j]);
				}
			}
		}
			
		return distanceMatrix;
	}
	
	public void kruskal() {
		
		Comparator<Edge> m = new EdgeCompare();
		PriorityQueue<Edge> edgesQueue = new PriorityQueue<Edge>(m);
		
		//OBTENGO LAS ARISTAS DE TODO EL GRAFO Y LAS ORDENO
		for(Node<V,K> node: nodes.values()) {
			for(Edge e : node.getEdges().values()) {
				edgesQueue.add(e);
			}
		}
	
		
		
		
		
	}
	
	public void prim(Node<V,K> source) {

		routSume = 0;
		Comparator<Edge> m = new EdgeCompare();
		PriorityQueue<Edge<K>> edgesQueue = new PriorityQueue<Edge<K>>(m);
		visited.put(source.getKey(), true);
		fillQueue(edgesQueue, source);
		route.add(source);
		
		
		while(route.size() != nodes.size()) {
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
	}
	
	public void fillQueue(PriorityQueue<Edge<K>> queue, Node<V,K> node) {
		
		for(Edge e : node.getEdges().values()) {
			queue.add(e);
		}
		
	}
	
	public double[][] initializateDistanceMatrix() {
		
		double[][] distanceMatrix = new double[nodes.size()][nodes.size()];
		
		for(int i = 0; i < distanceMatrix.length ; i ++) {
			for(int j  = 0; j < distanceMatrix[0].length; j ++) {
				Node<V,K> nodeIn = nodes.get(keys.get(i));
				ArrayList<Node<V,K>> nodesFinalEdges = nodeIn.nodesFinalEdges();
				if(nodesFinalEdges.contains(nodes.get(keys.get(j)))) {
					distanceMatrix[i][j] = nodeIn.getWeightEdge(nodes.get(keys.get(j)));
				}
				else {
					distanceMatrix[i][j] = BIG_CONSTANT;
				}
			}
		}	
		
		return distanceMatrix;
	}
	
	public static void main(String[] args) {
//		Graph<String, Integer> g = new Graph<>();
//		Node<String, Integer> a = new Node<>("A", 10);
//		Node<String, Integer> b = new Node<>("B", 30);
//		Node<String, Integer> c = new Node<>("C", 23);
//		Node<String, Integer> e = new Node<>("E", 5);
//		Node<String, Integer> f = new Node<>("F", 8);
//		Node<String, Integer> x = new Node<>("X", 34);
//		Node<String, Integer> w = new Node<>("W", 13);
//		Node<String, Integer> h = new Node<>("H", 87);
//		g.addNode(a);
//		g.addNode(b);
//		g.addNode(c);
//		g.addNode(e);
//		g.addNode(f);
//		g.addNode(x);
//		g.addNode(w);
//		g.addNode(h);
//		g.addEdge(a.getKey(), b.getKey(), 1, 70);
//		g.addEdge(a.getKey(), c.getKey(), 2, 9);
//		g.addEdge(b.getKey(), e.getKey(), 0, 1);
//		g.addEdge(b.getKey(), c.getKey(), 3, 10);
//		g.addEdge(c.getKey(), f.getKey(), 4, 4);
//		g.addEdge(e.getKey(), f.getKey(), 5, 60);
//		g.addEdge(e.getKey(), x.getKey(), 6, 23);
//		g.addEdge(f.getKey(), w.getKey(), 7, 90);
//		g.addEdge(w.getKey(), x.getKey(), 8, 87);
//		g.addEdge(h.getKey(), e.getKey(), 17, 21);
		
		
//		UndirectedGraph<String, Integer> graph = new UndirectedGraph<String, Integer>();
//		Node<String, Integer> n1 = new Node<String, Integer>("X", 8);
//		Node<String, Integer> n2 = new Node<String, Integer>("B", 1);
//		Node<String, Integer> n3 = new Node<String, Integer>("A", 4);
//		Node<String, Integer> n4 = new Node<String, Integer>("D", 5);
//		Node<String, Integer> n5 = new Node<String, Integer>("C", 6);
//		Node<String, Integer> n6 = new Node<String, Integer>("E", 7);
//		graph.addNode(n1);
//		graph.addNode(n2);
//		graph.addNode(n3);
//		graph.addNode(n4);
//		graph.addNode(n5);
//		graph.addNode(n6);
//		graph.addEdge(8, 4, 3, 3);
//		graph.addEdge(1, 4, 5, 7);
//		graph.addEdge(8, 1, 21, 100);
//		graph.addEdge(4, 5, 13, 25);
//		graph.addEdge(1, 5, 21, 4);
//		graph.addEdge(4, 7, 231, 75);
//		graph.addEdge(5, 6, 12, 200);
//		graph.addEdge(6, 7, 6, 57);
//		graph.addEdge(5, 7, 132, 300);
//		graph.prim(n3);
		
		UndirectedGraph<String, Integer> graph = new UndirectedGraph<String, Integer>();
		Node<String, Integer> A = new Node<String, Integer>("A", 1);
		Node<String, Integer> B = new Node<String, Integer>("B", 2);
		Node<String, Integer> C = new Node<String, Integer>("C", 3);
		Node<String, Integer> D = new Node<String, Integer>("D", 4);
		Node<String, Integer> E = new Node<String, Integer>("E", 5);
		Node<String, Integer> F = new Node<String, Integer>("F", 6);
		Node<String, Integer> G = new Node<String, Integer>("G", 7);
		Node<String, Integer> H = new Node<String, Integer>("H", 8);
		Node<String, Integer> I = new Node<String, Integer>("I", 9);
		Node<String, Integer> J = new Node<String, Integer>("J", 10);
		graph.addNode(A);
		graph.addNode(B);
		graph.addNode(C);
		graph.addNode(D);
		graph.addNode(E);
		graph.addNode(F);
		graph.addNode(G);
		graph.addNode(H);
		graph.addNode(I);
		graph.addNode(J);
		graph.addEdge(1 , 2, 2, 8);
		graph.addEdge(2 , 5, 4, 4);
		graph.addEdge(2 , 3, 5, 10);
		graph.addEdge(3 , 4, 6, 5);
		graph.addEdge(4 , 5, 7, 7);
		graph.addEdge(4 , 7, 10, 11);
		graph.addEdge(5 , 6, 88, 2);
		graph.addEdge(6 , 7, 65, 12);
		graph.addEdge(6 , 10, 23, 9);
		graph.addEdge(6 , 9, 21, 6);
		graph.addEdge(6 , 8, 124, 14);
		graph.addEdge(7 , 8, 214, 20);
		graph.addEdge(9 , 8, 124, 17);
		graph.addEdge(10 , 9, 19, 3);
		graph.prim(A);
		
		
		
		
		
				
//		g.djikstra(e);
//		g.updateMatrix();
//		g.floydWarshall();
//		g.prim(b);
//		
//		for(int i = 0; i < g.getAdjacencyMatrix().length ; i ++) {
//			System.out.println("\n");
//			System.out.print(g.getNodes().get(g.getKeys().get(i)).getValue() + "      ");
//			for(int j = 0; j < g.getAdjacencyMatrix()[0].length ; j ++) {
//				System.out.print(g.getAdjacencyMatrix()[i][j] + "," + g.getNodes().get(g.getKeys().get(j)).getValue() + "   ");
//			}
//		}
		
		
		
		
		
//		for(int i = 0; i < g.getDistanceMatrix().length ; i ++) {
//			System.out.println("\n");
//			System.out.print(g.getNodes().get(g.getKeys().get(i)).getValue() + "      ");
//			for(int j = 0; j < g.getDistanceMatrix()[0].length ; j ++) {
//				System.out.print(g.getDistanceMatrix()[i][j] + "," + g.getNodes().get(g.getKeys().get(j)).getValue() + "   ");
//			}
//		}
			
		
//		for(int i = 0; i < g.bfs(n3).size() ; i ++) {
//			System.out.println("Valor " + g.bfs(n3).get(i).getValue() + " LLave " + g.bfs(n3).get(i).getKey());
//		}
//		
		
		
		
	}

	
	

}














