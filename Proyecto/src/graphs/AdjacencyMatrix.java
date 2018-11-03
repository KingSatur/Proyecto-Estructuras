package graphs;

public class AdjacencyMatrix{

	private int[][] adjacencys;
	
	public AdjacencyMatrix(int quantityVertex) {
		adjacencys = new int[quantityVertex][quantityVertex];
	}

	public int[][] getAdjacencys() {
		return adjacencys;
	}

	public void setAdjacencys(int[][] adjacencys) {
		this.adjacencys = adjacencys;
	}
	
}
