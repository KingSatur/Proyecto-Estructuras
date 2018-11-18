package graph.Directed;

import Interface.iGraphMatrix;

public class AdjacencyMatrix<V,K extends Comparable<K>> extends Graph<V,K>implements iGraphMatrix<V,K> {

	private int[][] matrix;
	
	public AdjacencyMatrix(int numberNodes) {
		super();
		this.matrix = new int[numberNodes][numberNodes];
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dijsktra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kruscal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void floydWarshall() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addEdge() {
		
		
	}




	@Override
	public void removeEdge() {
		
		
	}

	@Override
	public void addNode(Node<V,K> newNode) {
		super.getNodes().put(newNode.getKey(), newNode);
		int[][] aux = new int[matrix.length+1][matrix.length+1];
		
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				aux[i][j] =  matrix[i][j];
			}
		}
		
		matrix = aux;
	}




	@Override
	public void removeNode() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
