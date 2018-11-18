package Interface;

public interface iGraphMatrix<V,K extends Comparable<K>> {

	public void dfs();
	public void bfs();
	public void dijsktra();
	public void floydWarshall();
	public void kruscal();
	public void prim();
	
}
