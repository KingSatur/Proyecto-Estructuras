package graphicInterface;

import javax.swing.JPanel;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import model.Point;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelSimpleUndirected extends JPanel {
	
	
	private PanelCanvasMatrix panelCanvas;
	
	private Main main;
	
	
	public PanelSimpleUndirected(Main main, HashMap<Integer, Node<Point, Integer>> nodes, EdgeSrcEnd<Integer>[][] matrix , ArrayList<Integer> path) {
		this.main =  main;
		setLayout(new BorderLayout());
		this.panelCanvas = new PanelCanvasMatrix(main, nodes, matrix, path);
		

		add(panelCanvas, BorderLayout.CENTER);
	}


	public PanelCanvasMatrix getPanelCanvas() {
		return panelCanvas;
	}


	public void setPanelCanvas(PanelCanvasMatrix panelCanvas) {
		this.panelCanvas = panelCanvas;
	}
	
	

}
