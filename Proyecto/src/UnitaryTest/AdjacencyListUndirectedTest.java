package UnitaryTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import graph.Directed.AdjacencyList;
import graph.Directed.Node;
import graph.Undirected.AdjacencyListUndirected;

class AdjacencyListUndirectedTest {

	private AdjacencyListUndirected<String, Integer> graph;
	
	private Node<String, Integer> generalScenary() {
		
		graph = new AdjacencyListUndirected<String,Integer>();
		Node<String,Integer> n1 = new Node<String,Integer>("1", 10);
		Node<String,Integer> n2 = new Node<String,Integer>("2", 60);
		Node<String,Integer> n3 = new Node<String,Integer>("3", 100);
		Node<String,Integer> n4 = new Node<String,Integer>("4", 67);
		Node<String,Integer> n7 = new Node<String,Integer>("7", 7);
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n7);
		graph.addEdge(10, 60, 4, 3);
		graph.addEdge(10, 100, 6, 2);
		graph.addEdge(10, 67, 8, 1);
		graph.addEdge(60, 100, 7, 4);
		graph.addEdge(60, 67, 2, 1);
		graph.addEdge(67, 100, 6, 6);
		graph.addEdge(10, 7, 100, 0.5);
		graph.addEdge(7, 60, 45, 0.5);
		graph.addEdge(7, 67, 54, 0.2);
	
		return n1;
	}
		
	
	@Test
	void testBfs() {
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.bfs(n1);
		HashMap<Integer, Integer> trueRoute = new HashMap<Integer, Integer>();
		trueRoute.put(60, 10);
		trueRoute.put(100, 60);
		trueRoute.put(67, 100);
		trueRoute.put(7, 67);
		

		for(Integer key: trueRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueRoute.get(key)));
		}
		
	}
	
	@Test
	void testDfs() {
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.dfs(n1);
		HashMap<Integer, Integer> trueRoute = new HashMap<Integer, Integer>();
		trueRoute.put(60, 100);
		trueRoute.put(100, 67);
		trueRoute.put(67, 7);
		trueRoute.put(7, 10);
			
		for(Integer key: trueRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueRoute.get(key)));
		}
	
	}
	
	@Test
	void testDjkistra(){
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Double> distances = graph.dijsktra(n1);
		HashMap<Integer, Double> trueDistances = new HashMap<Integer, Double>();
		trueDistances.put(67, 0.7);
		trueDistances.put(100, 2.0);
		trueDistances.put(7, 0.5);
		trueDistances.put(10, 0.0);
		trueDistances.put(60, 1.0);
		
		for(Integer key: trueDistances.keySet()) {
			assertTrue(distances.get(key).equals(trueDistances.get(key)));
		}
	
	}
	
	
	@Test
	void testKruskal() {
		
		Node<String, Integer> n1 = generalScenary();
		HashMap<Integer, Integer> fathersRoute = graph.kruscal();
		HashMap<Integer, Integer> trueFathersRoute = new HashMap<Integer, Integer>();
		trueFathersRoute.put(100, 10);
		trueFathersRoute.put(10, 7);
		trueFathersRoute.put(7, 67);
		trueFathersRoute.put(60,  7);
		
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
		trueFathersRoute.put(67, 7);
		trueFathersRoute.put(7, 10);
		trueFathersRoute.put(100, 10);
		trueFathersRoute.put(60,  7);
		
		for(Integer key: trueFathersRoute.keySet()) {
			assertTrue(fathersRoute.get(key).equals(trueFathersRoute.get(key)));
		}
		
		assertTrue(graph.getMinimumRouteSume() == 3.2);
		
	}

	
	
	
}
