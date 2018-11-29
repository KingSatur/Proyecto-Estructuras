package threads;

import java.util.ArrayList;
import java.util.HashMap;

import graph.Directed.Node;
import graphicInterface.PanelCanvasMatrix;
import model.Point;

public class paintNodes extends Thread {

	private PanelCanvasMatrix panelCanvas;
	private ArrayList<Integer> path;

	public paintNodes(PanelCanvasMatrix panelCanvas, ArrayList<Integer> path,HashMap<Integer, Node<Point, Integer>> nodes , HashMap<Integer, Integer> fathers) {
		this.panelCanvas = panelCanvas;
		this.path = path;
	

	}
	
	@Override
	public void run() {
		
		
			for (int i = 0; i < path.size(); i++) {
				Integer key = path.get(i);			
				panelCanvas.getNodes().get(key).getValue().getColor().setColor(Point.RED);
				panelCanvas.repaint();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}			
		
			
	}
}
