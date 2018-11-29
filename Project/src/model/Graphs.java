package model;

import graph.Directed.AdjacencyMatrix;
import graph.Directed.Node;
import graph.Undirected.AdjacencyListUndirected;
import graph.Undirected.AdjacencyMatrixUndirected;

public class Graphs {
	
	private AdjacencyMatrix<Point, Integer> simpleDirectedGraph;
	private AdjacencyMatrixUndirected<Point, Integer> simpleUndirectedGraph;
	private AdjacencyListUndirected<Point, Integer> undirectedMultigraph;
	private AdjacencyListUndirected<Point, Integer> undirectedPseudoGraph;
	
	public Graphs() {
		createSimpleUndirectedGraph();
		createSimpleGraph();
		createMultiGraph();
		createPseudo();
	}
	
	public void createMultiGraph() {
		undirectedMultigraph = new AdjacencyListUndirected<Point, Integer>();
		Point one = new Point(40, 30, 40);
		Point two = new Point(40, 190, 40);
		Point three = new Point(240, 95, 40);
		Point four = new Point(450, 30, 40);
		Point five = new Point(450, 190, 40);
		Node<Point, Integer> nodeOne = new Node<Point, Integer>(one, 1);
		Node<Point, Integer> nodeTwo = new Node<Point, Integer>(two, 2);
		Node<Point, Integer> nodeThree = new Node<Point, Integer>(three, 3);
		Node<Point, Integer> nodeFour = new Node<Point, Integer>(four, 4);
		Node<Point, Integer> nodeFive = new Node<Point, Integer>(five, 5);
		undirectedMultigraph.addNode(nodeOne);
		undirectedMultigraph.addNode(nodeTwo);
		undirectedMultigraph.addNode(nodeThree);
		undirectedMultigraph.addNode(nodeFour);
		undirectedMultigraph.addNode(nodeFive);
		undirectedMultigraph.addEdge(1, 2, 20, 20);
		undirectedMultigraph.addEdge(1, 2, 10, 7);
		undirectedMultigraph.addEdge(1, 3, 9, 6);
		undirectedMultigraph.addEdge(3, 2, 25, 4);
		undirectedMultigraph.addEdge(1, 4, 17, 1);
		undirectedMultigraph.addEdge(1, 4, 23, 8);
		undirectedMultigraph.addEdge(2, 5, 79, 6);
		undirectedMultigraph.addEdge(4, 5, 13, 3);
		undirectedMultigraph.dfs(nodeOne);
	}
	
	public void createSimpleUndirectedGraph() {
		
		simpleUndirectedGraph = new AdjacencyMatrixUndirected<Point, Integer>();
		
		Point p1 = new Point(160, 190, 15);
		Point p2 = new Point(460, 190, 15);
		Point p3 = new Point(310, 400, 15);
		
		simpleUndirectedGraph.addNode(new Node<Point, Integer>(p1, 1));
		simpleUndirectedGraph.addNode(new Node<Point, Integer>(p2, 2));
		simpleUndirectedGraph.addNode(new Node<Point, Integer>(p3, 3));
		
		simpleUndirectedGraph.addEdge(1, 2, 6, 1);
		simpleUndirectedGraph.addEdge(1, 3, 2, 2);
		simpleUndirectedGraph.addEdge(3, 2, 3, 3);
		
	}
	
	public void createSimpleGraph() {
		simpleDirectedGraph = new AdjacencyMatrix<Point, Integer>();
		
		Point p1 = new Point(160, 190, 15);
		Point p2 = new Point(460, 190, 15);
	
		
		simpleDirectedGraph.addNode(new Node<Point, Integer>(p1, 1));
		simpleDirectedGraph.addNode(new Node<Point, Integer>(p2, 2));
		
		simpleDirectedGraph.addEdge(1, 2, 7, 1);
		
	}
	
	
	public void createPseudo() {
		
		undirectedPseudoGraph = new AdjacencyListUndirected<Point, Integer>();
		Point one = new Point(40, 30, 40);
		Point two = new Point(40, 190, 40);
		Point three = new Point(240, 95, 40);
		Point four = new Point(450, 30, 40);
		Point five = new Point(450, 190, 40);
		Node<Point, Integer> nodeOne = new Node<Point, Integer>(one, 11);
		Node<Point, Integer> nodeTwo = new Node<Point, Integer>(two, 22);
		Node<Point, Integer> nodeThree = new Node<Point, Integer>(three, 33);
		Node<Point, Integer> nodeFour = new Node<Point, Integer>(four, 44);
		Node<Point, Integer> nodeFive = new Node<Point, Integer>(five, 55);
		undirectedPseudoGraph.addNode(nodeOne);
		undirectedPseudoGraph.addNode(nodeTwo);
		undirectedPseudoGraph.addNode(nodeThree);
		undirectedPseudoGraph.addNode(nodeFour);
		undirectedPseudoGraph.addNode(nodeFive);
		undirectedPseudoGraph.addEdge(11, 22, 20, 20);
		undirectedPseudoGraph.addEdge(11, 22, 10, 7);
		undirectedPseudoGraph.addEdge(11, 33, 9, 6);
		undirectedPseudoGraph.addEdge(33, 22, 25, 4);
		undirectedPseudoGraph.addEdge(11, 44, 17, 1);
		undirectedPseudoGraph.addEdge(11, 44, 23, 8);
		undirectedPseudoGraph.addEdge(22, 55, 79, 6);
		undirectedPseudoGraph.addEdge(44, 55, 13, 3);		
				
		
	}
	
	
	public void createMultigraphUndirected() {
		undirectedMultigraph = new AdjacencyListUndirected<Point, Integer>();
	}
	
	public void createPseudoGraph() {
		undirectedPseudoGraph = new AdjacencyListUndirected<Point, Integer>();		
	}
	

	public AdjacencyMatrix<Point, Integer> getSimpleDirectedGraph() {
		return simpleDirectedGraph;
	}


	public void setSimpleDirectedGraph(AdjacencyMatrix<Point, Integer> simpleDirectedGraph) {
		this.simpleDirectedGraph = simpleDirectedGraph;
	}


	public AdjacencyMatrixUndirected<Point, Integer> getSimpleUndirectedGraph() {
		return simpleUndirectedGraph;
	}


	public void setSimpleUndirectedGraph(AdjacencyMatrixUndirected<Point, Integer> simpleUndirectedGraph) {
		this.simpleUndirectedGraph = simpleUndirectedGraph;
	}


	public AdjacencyListUndirected<Point, Integer> getUndirectedMultigraph() {
		return undirectedMultigraph;
	}


	public void setUndirectedMultigraph(AdjacencyListUndirected<Point, Integer> undirectedMultigraph) {
		this.undirectedMultigraph = undirectedMultigraph;
	}


	public AdjacencyListUndirected<Point, Integer> getUndirectedPseudoGraph() {
		return undirectedPseudoGraph;
	}


	public void setUndirectedPseudoGraph(AdjacencyListUndirected<Point, Integer> undirectedPseudoGraph) {
		this.undirectedPseudoGraph = undirectedPseudoGraph;
	}
	
	public static void main(String[] args) {
		
		Graphs g = new Graphs();
		int x = 100;
		
		int c = x +10;
	
		
	}
	
}
