package graph.Directed;

import java.util.Hashtable;

public class AdjacencyMatrix {

	private int[][] matrix;
	
	public AdjacencyMatrix(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}
	
	public void updateMatrix(int rows, int columns) {
		
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
}
