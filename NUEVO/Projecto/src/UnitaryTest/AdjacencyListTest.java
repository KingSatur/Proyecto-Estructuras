package UnitaryTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
	void testBfs() {
		
		Node<String, Integer> n1 = generalScenary();
		ArrayList<Node<String,Integer>> generalRoute = graph.getGeneralRoute();
		ArrayList<Integer> trueRoute = new ArrayList();
		trueRoute.add(10);
		trueRoute.add(20);
		trueRoute.add(50);
		trueRoute.add(40);
		trueRoute.add(30);
		
		for(int i = 0; i < generalRoute.size() ; i ++) {
			Integer one = generalRoute.get(i).getKey();
			Integer two = trueRoute.get(i);
			assertTrue(one.equals(two));
		}

			
		
	}
	
		
	@Test
	void testDfs() {
		
		Node<String, Integer> n1 = generalScenary();
		ArrayList<Node<String,Integer>> generalRoute = graph.getGeneralRoute();
		ArrayList<Integer> trueRoute = new ArrayList();
		trueRoute.add(10);
		trueRoute.add(50);
		trueRoute.add(30);
		trueRoute.add(20);
		trueRoute.add(40);
		
		for(int i = 0; i < generalRoute.size() ; i ++) {
			Integer one = generalRoute.get(i).getKey();
			Integer two = trueRoute.get(i);
			assertTrue(one.equals(two));
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
