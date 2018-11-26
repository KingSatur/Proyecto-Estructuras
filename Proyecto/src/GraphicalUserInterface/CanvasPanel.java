package GraphicalUserInterface;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CanvasPanel extends JPanel {

	public static final int BFS = 0;
	public static final int DFS = 1;
	public static final int DIJSKTRA = 2;
	public static final int FLOYD = 3;
	public static final int KRUSKAL = 4;
	public static final int PRIM = 5;

	BfsPanel bfs;
	DfsPanel dfs;
	DijkstraPanel dijkstra;
	FloydPanel floyd;
	KruskalPanel kruskal;
	PrimPanel prim;
	

	public CanvasPanel() {
		super();

		setLayout(new BorderLayout(0, 0));
		JLabel lblGrafo = new JLabel("GRAFO");
		lblGrafo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGrafo, BorderLayout.NORTH);
		
		
		
	}

	public void cambiarVentana(int tipoAlgoritmo, int tipoGrafo) {

		switch (tipoAlgoritmo) {
		case BFS:
			this.bfs = new BfsPanel();
			this.add(bfs, BorderLayout.CENTER);
			break;
		case DFS:
			this.dfs = new DfsPanel();
			this.add(dfs, BorderLayout.CENTER);
			break;
		case DIJSKTRA:
			this.dijkstra = new DijkstraPanel();
			this.add(dijkstra, BorderLayout.CENTER);
			break;
		case FLOYD:
			this.floyd = new FloydPanel();
			this.add(floyd, BorderLayout.CENTER);
			break;
		case KRUSKAL:
			this.kruskal = new KruskalPanel();
			this.add(kruskal, BorderLayout.CENTER);
			break;
		case PRIM:
			this.prim = new PrimPanel();
			this.add(prim, BorderLayout.CENTER);
			break;

		}

		
	}

}
