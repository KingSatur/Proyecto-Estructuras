package model;

import graph.Directed.AdjacencyMatrix;
import graph.Undirected.AdjacencyListUndirected;
import graph.Undirected.AdjacencyMatrixUndirected;

public class Graphs {
	
	private AdjacencyMatrix<Point, Integer> simpleDirectedGraph;
	private AdjacencyMatrixUndirected<Point, Integer> simpleUndirectedGraph;
	private AdjacencyListUndirected<Point, Integer> undirectedMultigraph;
	private AdjacencyListUndirected<Point, Integer> undirectedPseudoGraph;
	
	
	
	public Graphs() {
		simpleDirectedGraph = new AdjacencyMatrix<Point, Integer>();
		simpleUndirectedGraph = new AdjacencyMatrixUndirected<Point, Integer>();
		undirectedMultigraph = new AdjacencyListUndirected<Point, Integer>();
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
	
}
