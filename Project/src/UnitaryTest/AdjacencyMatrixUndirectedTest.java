package UnitaryTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import graph.Undirected.AdjacencyMatrixUndirected;

class AdjacencyMatrixUndirectedTest {

	private AdjacencyMatrixUndirected<Integer, Integer> graphUnidrectedMatrix;
	
	private void setup1() {
		graphUnidrectedMatrix = new AdjacencyMatrixUndirected<>();
	}
	
	private void setup2() {
		graphUnidrectedMatrix = new AdjacencyMatrixUndirected<Integer, Integer>();
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);
		
		graphUnidrectedMatrix.addNode(n1);
		graphUnidrectedMatrix.addNode(n2);
		graphUnidrectedMatrix.addNode(n3);
		graphUnidrectedMatrix.addNode(n4);
		graphUnidrectedMatrix.addNode(n5);
		graphUnidrectedMatrix.addNode(n6);
		
		graphUnidrectedMatrix.addEdge(1, 3, 1, 1);
		graphUnidrectedMatrix.addEdge(1, 2, 2, 2);
		graphUnidrectedMatrix.addEdge(3, 4, 3, 3);
		graphUnidrectedMatrix.addEdge(2, 4, 6, 4);
		graphUnidrectedMatrix.addEdge(4, 6, 2, 5);
		graphUnidrectedMatrix.addEdge(3, 5, 4, 6);
		graphUnidrectedMatrix.addEdge(5, 6, 2, 7);
		
		
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
		
		graphUnidrectedMatrix.addNode(n1);
		graphUnidrectedMatrix.addNode(n2);
		graphUnidrectedMatrix.addNode(n3);
		graphUnidrectedMatrix.addNode(n4);
		graphUnidrectedMatrix.addNode(n5);
		graphUnidrectedMatrix.addNode(n6);
		
		boolean test = false;
		int i = -1;
		int j = -1;
		
		graphUnidrectedMatrix.addEdge(1, 3, 1, 1);
		i = graphUnidrectedMatrix.getIndexNodes().get(1);
		j = graphUnidrectedMatrix.getIndexNodes().get(3);
		EdgeSrcEnd e = new EdgeSrcEnd(n1, n3, 1, 1);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
	
		graphUnidrectedMatrix.addEdge(1, 2, 2, 2);
		i = graphUnidrectedMatrix.getIndexNodes().get(1);
		j = graphUnidrectedMatrix.getIndexNodes().get(2);
		e = new EdgeSrcEnd(n1, n2, 2, 2);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.addEdge(3, 4, 3, 3);
		i = graphUnidrectedMatrix.getIndexNodes().get(3);
		j = graphUnidrectedMatrix.getIndexNodes().get(4);
		e = new EdgeSrcEnd(n3, n4, 3, 3);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.addEdge(2, 4, 6, 4);
		i = graphUnidrectedMatrix.getIndexNodes().get(2);
		j = graphUnidrectedMatrix.getIndexNodes().get(4);
		e = new EdgeSrcEnd(n2, n4, 6, 4);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.addEdge(4, 6, 2, 5);
		i = graphUnidrectedMatrix.getIndexNodes().get(4);
		j = graphUnidrectedMatrix.getIndexNodes().get(6);
		e = new EdgeSrcEnd(n4, n6, 2, 5);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.addEdge(3, 5, 4, 6);
		i = graphUnidrectedMatrix.getIndexNodes().get(3);
		j = graphUnidrectedMatrix.getIndexNodes().get(5);
		e = new EdgeSrcEnd(n3, n5, 4, 6);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.addEdge(5, 6, 2, 7);
		i = graphUnidrectedMatrix.getIndexNodes().get(5);
		j = graphUnidrectedMatrix.getIndexNodes().get(6);
		e = new EdgeSrcEnd(n5, n6, 2, 7);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
	}
	
	@Test
	void addRemoveEdge() {
		setup1();
		Node<Integer, Integer> n1 = new Node<>(1, 1);
		Node<Integer, Integer> n2 = new Node<>(2, 2);
		Node<Integer, Integer> n3 = new Node<>(3, 3);
		Node<Integer, Integer> n4 = new Node<>(4, 4);
		Node<Integer, Integer> n5 = new Node<>(5, 5);
		Node<Integer, Integer> n6 = new Node<>(6, 6);
		
		graphUnidrectedMatrix.addNode(n1);
		graphUnidrectedMatrix.addNode(n2);
		graphUnidrectedMatrix.addNode(n3);
		graphUnidrectedMatrix.addNode(n4);
		graphUnidrectedMatrix.addNode(n5);
		graphUnidrectedMatrix.addNode(n6);
		
		graphUnidrectedMatrix.addEdge(1, 3, 1, 1);
		graphUnidrectedMatrix.addEdge(1, 2, 2, 2);
		graphUnidrectedMatrix.addEdge(3, 4, 3, 3);
		graphUnidrectedMatrix.addEdge(2, 4, 6, 4);
		graphUnidrectedMatrix.addEdge(4, 6, 2, 5);
		graphUnidrectedMatrix.addEdge(3, 5, 4, 6);
		graphUnidrectedMatrix.addEdge(5, 6, 2, 7);
		
		boolean test = false;
		int i = -1;
		int j = -1;
		
		graphUnidrectedMatrix.removeEdge(1);
		i = graphUnidrectedMatrix.getIndexNodes().get(1);
		j = graphUnidrectedMatrix.getIndexNodes().get(3);
		EdgeSrcEnd e = new EdgeSrcEnd(n1, n3, 1, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.removeEdge(2);
		i = graphUnidrectedMatrix.getIndexNodes().get(1);
		j = graphUnidrectedMatrix.getIndexNodes().get(2);
		e = new EdgeSrcEnd(n1, n2, 2, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.removeEdge(3);
		i = graphUnidrectedMatrix.getIndexNodes().get(3);
		j = graphUnidrectedMatrix.getIndexNodes().get(4);
		e = new EdgeSrcEnd(n3, n4, 3, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.removeEdge(4);
		i = graphUnidrectedMatrix.getIndexNodes().get(2);
		j = graphUnidrectedMatrix.getIndexNodes().get(4);
		e = new EdgeSrcEnd(n2, n4, 4, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.removeEdge(5);
		i = graphUnidrectedMatrix.getIndexNodes().get(4);
		j = graphUnidrectedMatrix.getIndexNodes().get(6);
		e = new EdgeSrcEnd(n4, n6, 5, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.removeEdge(6);
		i = graphUnidrectedMatrix.getIndexNodes().get(3);
		j = graphUnidrectedMatrix.getIndexNodes().get(5);
		e = new EdgeSrcEnd(n3, n5, 6, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
		graphUnidrectedMatrix.removeEdge(7);
		i = graphUnidrectedMatrix.getIndexNodes().get(5);
		j = graphUnidrectedMatrix.getIndexNodes().get(6);
		e = new EdgeSrcEnd(n5, n6, 7, Double.MAX_VALUE);
		test = graphUnidrectedMatrix.getMatrix()[i][j].equals(e) && graphUnidrectedMatrix.getMatrix()[j][i].equals(e) ;
		
	}
	
	@Test
	void testDijsktra() {
		setup2();
		graphUnidrectedMatrix.dijsktra(1);
		
		HashMap<Integer, Integer> trueAnswer = new HashMap<>();
		trueAnswer.put(1, 1);
		trueAnswer.put(2, 1);
		trueAnswer.put(3, 1);
		trueAnswer.put(4, 3);
		trueAnswer.put(5, 3);
		trueAnswer.put(6, 4);
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(1);
		path.add(3);
		path.add(2);
		path.add(4);
		path.add(6);
		path.add(5);
		
		for (Integer key : trueAnswer.keySet()) {
			assertTrue(graphUnidrectedMatrix.getFathers().get(key).intValue() == trueAnswer.get(key).intValue());
		}
		for (int i = 0; i < path.size(); i++) {
			assertTrue(graphUnidrectedMatrix.getPath().get(i).intValue() ==  path.get(i).intValue());
		}
		
	}
	
	@Test
	void testKruskal() {
		setup2();
		graphUnidrectedMatrix.kruscal();
		
		HashMap<Integer, Integer> trueAnswer = new HashMap<>();
		trueAnswer.put(2, 1);
		trueAnswer.put(3, 1);
		trueAnswer.put(4, 3);
		trueAnswer.put(5, 6);
		trueAnswer.put(6, 4);
		
		for (Integer key : trueAnswer.keySet()) {
			assertTrue(graphUnidrectedMatrix.getFathers().get(key).intValue() == trueAnswer.get(key).intValue());
		}
		
		
	}
	
	@Test
	void testPrim() {
		setup2();

		graphUnidrectedMatrix.prim();
		HashMap<Integer, Integer> trueAnswer = new HashMap<>();
		trueAnswer.put(1, 1);
		trueAnswer.put(2, 1);
		trueAnswer.put(3, 1);
		trueAnswer.put(4, 3);
		trueAnswer.put(5, 6);
		trueAnswer.put(6, 4);
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(1);
		path.add(3);
		path.add(2);
		path.add(4);
		path.add(6);
		path.add(5);
		
		double w = 10.0;
		
		for (Integer key : trueAnswer.keySet()) {
			assertTrue(graphUnidrectedMatrix.getFathers().get(key).intValue() == trueAnswer.get(key).intValue());
		}
		for (int i = 0; i < path.size(); i++) {
			assertTrue(graphUnidrectedMatrix.getPath().get(i).intValue() ==  path.get(i).intValue());
		}
		
		assertTrue(graphUnidrectedMatrix.getWeightPath() == w);
		
	}
	
}
