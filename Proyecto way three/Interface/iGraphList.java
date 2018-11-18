package Interface;

public interface iGraphList<V,K extends Comparable<K>> {

	public void dfs();
	public void bfs();
	public void dijsktra();
	public void kruscal();
	public void prim();
}
