package pruebas;

import graphs.Graph;
import graphs.Node;

public class Main {

	public  Graph<Integer, Integer> directedGraph;
	public  Graph<Integer, Integer> undirectedGraph;
	
	
	public static void main(String[] args) {
		Main m = new Main();
		m.directedGraph = new Graph<>(true);
		m.undirectedGraph = new Graph<>(false);
		
		for (int i = 1; i < 11; i++) {
			m.directedGraph.addVertex(new Node<Integer, Integer>(i, i, Node.WHITE, i));
			m.undirectedGraph.addVertex(new Node<Integer, Integer>(i, i, Node.WHITE, i));
		}
		

		for (int i = 1; i < m.directedGraph.getVertices().size(); i++) {
			m.directedGraph.createEdge(""+(i+1),m.directedGraph.getVertices().get(i), m.directedGraph.getVertices().get(i+1));
		}
		m.directedGraph.createEdge(""+10,m.directedGraph.getVertices().get(10), m.directedGraph.getVertices().get(1));
		
		
		
		for (int i = 1; i < m.undirectedGraph.getVertices().size(); i++) {
			m.undirectedGraph.createEdge(""+(i+1),m.undirectedGraph.getVertices().get(i), m.undirectedGraph.getVertices().get(i+1));
		}
		m.undirectedGraph.createEdge(""+10,m.undirectedGraph.getVertices().get(10), m.undirectedGraph.getVertices().get(1));
		
		
		m.directedGraph.breadthFirstSearch(m.directedGraph.getVertices().get(1));
		System.out.println("------------");
		m.undirectedGraph.breadthFirstSearch( m.undirectedGraph.getVertices().get(1));
		
		System.out.println("\n\n");
		
		m.directedGraph.deepFirstSearch();
		System.out.println("------------");
		m.undirectedGraph.deepFirstSearch();
		
		
		
		
		
		
	}
	
}
