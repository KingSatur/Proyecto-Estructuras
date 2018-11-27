package UnitaryTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import graph.Directed.AdjacencyList;
import graph.Directed.Node;
import graph.Undirected.AdjacencyListUndirected;

class AdjacencyListTest {

	private AdjacencyList<String, Integer> graph;
	
	private Node<String, Integer> generalScenary() {
		
		graph = new AdjacencyList<String,Integer>();
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
		return n1;
	}
	
	@Test
	void testAddNode() {
		
		generalScenary();
		Node<String, Integer> n = new Node<String, Integer>("V6", 60);
		graph.addNode(n);
		
		assertTrue(graph.getNodes().containsKey(n.getKey()));
	}
	
	@Test
	void testAddEdge() {
		
		generalScenary();
		Node<String, Integer> m = new Node<String, Integer>("V6", 60);
		Node<String, Integer> m2 = new Node<String, Integer>("V7", 70);
		graph.addNode(m);
		graph.addNode(m2);
		graph.addEdge(m.getKey(), m2.getKey(), 20, 100);
		
		assertTrue(graph.getNodes().get(m.getKey()).getNeighbors().contains(m2));
		
	}
	
	
	@Test
	void testBfs() {
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.bfs(n1);
		HashMap<Integer, Integer> trueRoute = new HashMap<Integer, Integer>();
		trueRoute.put(50, 20);
		trueRoute.put(20, 10);
		trueRoute.put(40, 50);
		trueRoute.put(30, 40);	
		
		
		for(Integer key: trueRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueRoute.get(key)));
		}
		
		
	}
	
		
	@Test
	void testDfs() {
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.dfs(n1);
		HashMap<Integer, Integer> trueRoute = new HashMap<Integer, Integer>();
		trueRoute.put(50, 10);
		trueRoute.put(20, 30);
		trueRoute.put(40, 20);
		trueRoute.put(30, 50);		
	
		
		for(Integer key: trueRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueRoute.get(key)));
		}
	}
	
	@Test
	void testDjkistra(){

		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Double> distances = graph.dijsktra(n1);
		HashMap<Integer, Double> trueDistances = new HashMap<Integer, Double>();
		trueDistances.put(10, 0.0);
		trueDistances.put(30, 24.0);
		trueDistances.put(40, 15.0);
		trueDistances.put(20, 10.0);
		trueDistances.put(50, 21.0);
		
		for(Integer key: trueDistances.keySet()) {
			assertTrue(distances.get(key).equals(trueDistances.get(key)));
		}
		
				
	}
			

	/**
	@Test
	void testKruskal() {
				
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.kruscal();
		HashMap<Integer, Integer> trueFathersRoute = new HashMap<Integer, Integer>();
		
		
		
		for(Integer key: trueFathersRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueFathersRoute.get(key)));
		}
		
		assertTrue(graph.getMinimumRouteSume() == 3.2);
		
	}
			
			
	@Test
	void testPrime() {
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.prim(n1);
		HashMap<Integer, Integer> trueFathersRoute = new HashMap<Integer, Integer>();
		
		
		for(Integer key: trueFathersRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueFathersRoute.get(key)));
		}
		
		assertTrue(graph.getMinimumRouteSume() == 39.0);
		
		
		
		
	}
	
	*/
	
	
	
}
