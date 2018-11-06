package graphs;

public class AdjacencyMatrix{

	private int[][] adjacencys;
	
	public AdjacencyMatrix() {
		
	}

	public void refactorMatrix() {
		
		int[][] aux = null;
		if(adjacencys != null) {
			aux = new int[adjacencys.length][adjacencys.length];
			for (int i = 0; i < adjacencys.length; i++) {
				for (int j = 0; j < adjacencys.length; j++) {
					aux[i][j] = adjacencys[i][j];
				}
			}
			
			this.adjacencys = new int[adjacencys.length+1][adjacencys.length+1];
			for (int i = 0; i < aux.length; i++) {
				for (int j = 0; j < aux.length; j++) {
					adjacencys[i][j] = aux[i][j];
				}
			}
			
		}else {
			adjacencys = new int[1][1];
		}
		
	}
	
	
	public void fillMatrix(int i, int j) {
		adjacencys[j][i] = 1;
	}
	

	public int[][] getAdjacencys() {
		return adjacencys;
	}

	public void setAdjacencys(int[][] adjacencys) {
		this.adjacencys = adjacencys;
	}
	
}
