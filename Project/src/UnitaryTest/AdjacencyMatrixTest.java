package UnitaryTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import graph.Directed.AdjacencyList;
import graph.Directed.AdjacencyMatrix;
import graph.Directed.EdgeSrcEnd;
import graph.Directed.Graph;
import graph.Directed.Node;

class AdjacencyMatrixTest {

	private AdjacencyMatrix<Integer, Integer> graphMatrix;
	
	private void setup1() {
		
		graphMatrix = new AdjacencyMatrix<Integer, Integer>();
	}
	
	private void setup2() {
		
		graphMatrix = new AdjacencyMatrix<Integer, Integer>();
		Node<Integer,Integer> n1 = new Node<Integer,Integer>(1,1);
		Node<Integer,Integer> n2 = new Node<Integer,Integer>(2,2);
		Node<Integer,Integer> n3 = new Node<Integer,Integer>(3,3);
		Node<Integer,Integer> n4 = new Node<Integer,Integer>(4,4);
		Node<Integer,Integer> n5 = new Node<Integer, Integer>(5,5);
		graphMatrix.addNode(n1);
		graphMatrix.addNode(n2);
		graphMatrix.addNode(n3);
		graphMatrix.addNode(n4);
		graphMatrix.addNode(n5);
		
		graphMatrix.addEdge(1, 2, 1, 1);
		graphMatrix.addEdge(1, 5, 2, 21);
		graphMatrix.addEdge(2, 5, 3, 80);
		graphMatrix.addEdge(2, 4, 5, 5);
		graphMatrix.addEdge(3, 2, 7, 40);
		graphMatrix.addEdge(3, 1, 37, 60);
		graphMatrix.addEdge(4, 1, 2, 30);
		graphMatrix.addEdge(4, 3, 19, 70);
		graphMatrix.addEdge(5, 4, 13, 4);
		graphMatrix.addEdge(5, 3, 6, 3);	
		
		
	}
	
	@Test
	void testAddNode() {
		setup1();
		
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);

		boolean test = graphMatrix.getMatrix().length == 0;
		assertTrue(test);
		
		graphMatrix.addNode(n1);
		test = graphMatrix.getMatrix().length == 1;
		assertTrue(test);
		
		graphMatrix.addNode(n2);
		test = graphMatrix.getMatrix().length == 2;
		assertTrue(test);
		
		graphMatrix.addNode(n3);
		test = graphMatrix.getMatrix().length == 3;
		assertTrue(test);
		
		graphMatrix.addNode(n4);
		test = graphMatrix.getMatrix().length == 4;
		assertTrue(test);
		
		graphMatrix.addNode(n5);
		test = graphMatrix.getMatrix().length == 5;
		assertTrue(test);
		
		graphMatrix.addNode(n6);
		test = graphMatrix.getMatrix().length == 6;
		assertTrue(test);
		
		HashMap<Integer, Node<Integer,Integer>>  nodes = graphMatrix.getNodes();
		int i = 1;
		for (Integer k : nodes.keySet()) {
			test = k.compareTo(i) == 0;
			assertTrue(test);
			i++;
			
		}
			
	}
	
	@Test
	void testRemoveNode() {
		setup1();
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);

		graphMatrix.addNode(n1);
		graphMatrix.addNode(n2);
		graphMatrix.addNode(n3);
		graphMatrix.addNode(n4);
		graphMatrix.addNode(n5);
		graphMatrix.addNode(n6);
			
		boolean test = graphMatrix.getMatrix().length == 6 && graphMatrix.getNodes().size() == 6;
		assertTrue(test);
		
		graphMatrix.removeNode(1);
		test = graphMatrix.getMatrix().length == 5 && graphMatrix.getNodes().size() == 5;
		assertTrue(test);
		
		graphMatrix.removeNode(2);
		test = graphMatrix.getMatrix().length == 4 && graphMatrix.getNodes().size() == 4;
		assertTrue(test);
		
		graphMatrix.removeNode(3);
		test = graphMatrix.getMatrix().length == 3 && graphMatrix.getNodes().size() == 3;
		assertTrue(test);
		
		graphMatrix.removeNode(4);
		test = graphMatrix.getMatrix().length == 2 && graphMatrix.getNodes().size() == 2;
		assertTrue(test);
		
		graphMatrix.removeNode(5);
		test = graphMatrix.getMatrix().length == 1 && graphMatrix.getNodes().size() == 1;
		assertTrue(test);
		
		graphMatrix.removeNode(6);
		test = graphMatrix.getMatrix().length == 0 && graphMatrix.getNodes().size() == 0;
		assertTrue(test);
		
		
		
	}
	
	@Test
	void testAddEdge() {
		setup1();
		
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);

		graphMatrix.addNode(n1);
		graphMatrix.addNode(n2);
		graphMatrix.addNode(n3);
		graphMatrix.addNode(n4);
		graphMatrix.addNode(n5);
		graphMatrix.addNode(n6);
		
		boolean test = false;
		int i = -1;
		int j = -1;
		
		graphMatrix.addEdge(1, 3, 1, 1);
		i = graphMatrix.getIndexNodes().get(1);
		j = graphMatrix.getIndexNodes().get(3);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n1, n3, 1, 1));
		

		graphMatrix.addEdge(1, 2, 2, 2);
		i = graphMatrix.getIndexNodes().get(1);
		j = graphMatrix.getIndexNodes().get(2);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n1, n2, 2, 2));
		
		graphMatrix.addEdge(3, 4, 3, 3);
		i = graphMatrix.getIndexNodes().get(3);
		j = graphMatrix.getIndexNodes().get(4);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n3, n4, 3, 3));
		
		graphMatrix.addEdge(2, 4, 6, 4);
		i = graphMatrix.getIndexNodes().get(2);
		j = graphMatrix.getIndexNodes().get(4);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n2, n4, 6, 4));
		
		graphMatrix.addEdge(4, 6, 2, 5);
		i = graphMatrix.getIndexNodes().get(4);
		j = graphMatrix.getIndexNodes().get(6);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n4, n6, 2, 5));
		
		graphMatrix.addEdge(3, 5, 4, 6);
		i = graphMatrix.getIndexNodes().get(3);
		j = graphMatrix.getIndexNodes().get(5);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n3, n5, 4, 6));
		
		graphMatrix.addEdge(5, 6, 2, 7);
		i = graphMatrix.getIndexNodes().get(5);
		j = graphMatrix.getIndexNodes().get(6);
		test = graphMatrix.getMatrix()[i][j].equals(new EdgeSrcEnd<Integer>(n5, n6, 2, 7));
		
	}
	
	@Test
	void testRemoveEdge() {
		setup1();
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);

		graphMatrix.addNode(n1);
		graphMatrix.addNode(n2);
		graphMatrix.addNode(n3);
		graphMatrix.addNode(n4);
		graphMatrix.addNode(n5);
		graphMatrix.addNode(n6);
		
		graphMatrix.addEdge(1, 3, 1, 1);
		graphMatrix.addEdge(1, 2, 2, 2);
		graphMatrix.addEdge(3, 4, 3, 3);
		graphMatrix.addEdge(2, 4, 6, 4);
		graphMatrix.addEdge(4, 6, 2, 5);
		graphMatrix.addEdge(3, 5, 4, 6);
		graphMatrix.addEdge(5, 6, 2, 7);
		
		
		boolean test = false;
		int i = -1;
		int j = -1;
		
		graphMatrix.removeEdge(1);
		i = graphMatrix.getIndexNodes().get(1);
		j = graphMatrix.getIndexNodes().get(3);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n1, n3, 1, Double.MAX_VALUE)) == 0;
		assertTrue(test);
		
		graphMatrix.removeEdge(2);
		i = graphMatrix.getIndexNodes().get(1);
		j = graphMatrix.getIndexNodes().get(2);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n1, n2, 2, Double.MAX_VALUE)) == 0;
		assertTrue(test);
		
		graphMatrix.removeEdge(3);
		i = graphMatrix.getIndexNodes().get(3);
		j = graphMatrix.getIndexNodes().get(4);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n3, n4, 3, Double.MAX_VALUE)) == 0;
		assertTrue(test);
		
		graphMatrix.removeEdge(4);
		i = graphMatrix.getIndexNodes().get(2);
		j = graphMatrix.getIndexNodes().get(4);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n2, n4, 4, Double.MAX_VALUE)) == 0;
		assertTrue(test);
		
		graphMatrix.removeEdge(5);
		i = graphMatrix.getIndexNodes().get(4);
		j = graphMatrix.getIndexNodes().get(6);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n4, n6, 5, Double.MAX_VALUE)) == 0;
		assertTrue(test);
		
		graphMatrix.removeEdge(6);
		i = graphMatrix.getIndexNodes().get(3);
		j = graphMatrix.getIndexNodes().get(5);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n3, n5, 6, Double.MAX_VALUE)) == 0;
		assertTrue(test);
		
		graphMatrix.removeEdge(7);
		i = graphMatrix.getIndexNodes().get(5);
		j = graphMatrix.getIndexNodes().get(6);
		test = graphMatrix.getMatrix()[i][j].compareTo(new EdgeSrcEnd<Integer>(n5, n6, 7, Double.MAX_VALUE)) == 0;
	}
	
	@Test
	void testDfs() {
		setup2();
		graphMatrix.dfs(1);
		
		HashMap<Integer, Integer> trueAnswer = new HashMap<Integer, Integer>();
		trueAnswer.put(1, 1);
		trueAnswer.put(2, 3);
		trueAnswer.put(3, 4);
		trueAnswer.put(4, 5);
		trueAnswer.put(5, 1);
		
		ArrayList<Integer> path = new ArrayList<>();
		path.add(1);
		path.add(5);
		path.add(4);
		path.add(3);
		path.add(2);
		
		for (Integer key : trueAnswer.keySet()) {
			assertTrue(graphMatrix.getFathers().get(key).intValue() == trueAnswer.get(key).intValue());
		}
		for (int i = 0; i < path.size(); i++) {
			assertTrue(graphMatrix.getPath().get(i).intValue() == path.get(i).intValue());
		}
		
	}
	
	@Test
	void testBfs() {
		setup2();
		graphMatrix.bfs(1);
		
		HashMap<Integer, Integer> trueAnswer = new HashMap<Integer, Integer>();
		trueAnswer.put(1, 1);
		trueAnswer.put(2, 1);
		trueAnswer.put(3, 4);
		trueAnswer.put(4, 5);
		trueAnswer.put(5, 2);
		
		ArrayList<Integer> path = new ArrayList<>();
		path.add(1);
		path.add(2);
		path.add(5);
		path.add(4);
		path.add(3);
		
		for (Integer key : trueAnswer.keySet()) {
			assertTrue(graphMatrix.getFathers().get(key).intValue() == trueAnswer.get(key).intValue());
		}
		for (int i = 0; i < path.size(); i++) {
			assertTrue(graphMatrix.getPath().get(i).intValue() == path.get(i).intValue());
		}
			
	}
	
	@Test
	void testDijsktra() {
		setup2();
 
		graphMatrix.dijsktra(1);
		
		HashMap<Integer, Integer> trueAnswer = new HashMap<Integer, Integer>();
		trueAnswer.put(1, 1);
		trueAnswer.put(2, 1);
		trueAnswer.put(3, 5);
		trueAnswer.put(4, 2);
		trueAnswer.put(5, 1);
		
		ArrayList<Integer> path = new ArrayList<>();
		path.add(1);
		path.add(2);
		path.add(5);
		path.add(4);
		path.add(3);
		
		for (Integer key : trueAnswer.keySet()) {
			assertTrue(graphMatrix.getFathers().get(key).intValue() == trueAnswer.get(key).intValue());
		}
		for (int i = 0; i < path.size(); i++) {
			assertTrue(graphMatrix.getPath().get(i).intValue() == path.get(i).intValue());
		}
		
	}
	

	@Test
	void testFloydWarshall() {
		setup2();
		graphMatrix.floydWarshall();
		
		double[] i1 = {0,1,8,6,2};
		double[] i2 = {7,0,9,5,3};
		double[] i3 = {14,7,0,12,10};
		double[] i4 = {2,3,10,0,4};
		double[] i5 = {15,13,6,13,0};
		double[][] trueAnswer = new double[5][5];
		trueAnswer[0] = i1;
		trueAnswer[1] = i2;
		trueAnswer[2] = i3;
		trueAnswer[3] = i4;
		trueAnswer[4] = i5;
		
		for (int i = 0; i < trueAnswer.length; i++) {
			for (int j = 0; j < trueAnswer.length; j++) {
				assertTrue(graphMatrix.getAux()[i][j].getWeightKey() == trueAnswer[i][j]);
			}
		}
		
	}
	


}
