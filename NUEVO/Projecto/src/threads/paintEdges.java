package threads;

import java.util.ArrayList;
import java.util.HashMap;

import graphicInterface.PanelCanvasMatrix;

public class paintEdges extends Thread{

	private PanelCanvasMatrix panelCanvas;
	private HashMap<Integer, Integer> fathers;
	private ArrayList<Integer> path;
	private boolean isDirected;
	boolean isKruskal = false;
	
	
	public paintEdges(PanelCanvasMatrix panelCanvas,HashMap<Integer, Integer> fathers , ArrayList<Integer> path, boolean isDirected, boolean isKruskal) {
		this.panelCanvas = panelCanvas;
		this.fathers = fathers;
		this.path = path;
		this.isDirected = isDirected;
		this.isKruskal = isKruskal;
	}


	@Override
	public void run() {
		super.run();
		
	
		
		if(!isKruskal) {
			for (int i = 0; i < path.size(); i++) {
				Integer node = path.get(i);
				Integer father = fathers.get(path.get(i));
				if(node != father) {
					
					if(!isDirected) {
						panelCanvas.getMatrix()[node-1][father-1] = 1;
						panelCanvas.getMatrix()[father-1][node-1] = 1;			
						System.out.println("no entrar");
					}else {
						panelCanvas.getMatrix()[node-1][father-1] = 1;
					}
					panelCanvas.repaint();
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else {
			
			for (int i = 1; i <= fathers.size(); i++) {
				Integer node = i;
				Integer father = fathers.get(i);
				if(node != father) {
					if(!isDirected) {
						panelCanvas.getMatrix()[node-1][father-1] = 1;
						panelCanvas.getMatrix()[father-1][node-1] = 1;					
					}else {
						panelCanvas.getMatrix()[node-1][father-1] = 1;
					}
					panelCanvas.repaint();
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			
		}

	}
	
	
}
