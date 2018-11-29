package threads;

import java.util.ArrayList;
import java.util.HashMap;

import graph.Directed.Node;
import graphicInterface.PanelCanvasMatrix;
import model.Point;

public class paint extends Thread {

	private PanelCanvasMatrix panelCanvas;
	private ArrayList<Integer> path;
	private HashMap<Integer, Node<Point, Integer>> nodes;
	private HashMap<Integer, Integer> fathers;
	
	public paint(PanelCanvasMatrix panelCanvas, ArrayList<Integer> path,HashMap<Integer, Node<Point, Integer>> nodes , HashMap<Integer, Integer> fathers ) {
		this.panelCanvas = panelCanvas;
		this.path = path;
		this.nodes = nodes;
		this.fathers = fathers;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < path.size(); i++) {
			Integer key = path.get(i);			
			nodes.get(key).getValue().getColor().setColor(Point.RED);
			panelCanvas.repaint();
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}

	}
	
}
