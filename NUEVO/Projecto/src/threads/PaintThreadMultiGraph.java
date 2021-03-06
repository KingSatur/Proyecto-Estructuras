package threads;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import graph.Directed.Node;
import graphicInterface.PanelStructures;
import model.Graphs;
import model.Point;

public class PaintThreadMultiGraph extends Thread {

	private PanelStructures panelToPaint;
	private Graphs graph;
	private String kindGraph;
	
	public PaintThreadMultiGraph(Graphs graph, PanelStructures panelToPaint, String type) {
		this.graph = graph;
		this.panelToPaint = panelToPaint;
		this.kindGraph = type;
	}
	
	public void run() {
		if(kindGraph.equals("P")) {
			ArrayList<Node<Point, Integer>> route = graph.getUndirectedPseudoGraph().getGeneralRoute();
			HashMap<Integer, Integer> fatherRoute = graph.getUndirectedPseudoGraph().getFathers();
			ArrayList<Node<Point, Integer>> paint = new ArrayList<Node<Point, Integer>>();			
			for(int i = 0; i < route.size(); i ++) {
				Node<Point, Integer> nodeToVisit = route.get(i);
				paint.add(nodeToVisit);
				panelToPaint.setRoute(paint);
				panelToPaint.repaint();
				try {
					sleep(1000);	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			ArrayList<Node<Point, Integer>> route = graph.getUndirectedMultigraph().getGeneralRoute();
			HashMap<Integer, Integer> fatherRoute = graph.getUndirectedMultigraph().getFathers();			
			ArrayList<Node<Point, Integer>> paint = new ArrayList<Node<Point, Integer>>();			
			for(int i = 0; i < route.size(); i ++) {
				Node<Point, Integer> nodeToVisit = route.get(i);
//				Integer keyNodeFather = fatherRoute.get(nodeToVisit.getKey());
//				if(keyNodeFather == null) {
//					paint.add(nodeToVisit);
//					panelToPaint.setRoute(paint);
//					panelToPaint.repaint();
//					try {
//						sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				else {
//					paint.add(graph.getUndirectedMultigraph().getNodes().get(keyNodeFather));
//					panelToPaint.setRoute(paint);
//					panelToPaint.repaint();
//					try {
//						sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					paint.add(nodeToVisit);
//					panelToPaint.setRoute(paint);
//					panelToPaint.repaint();
//					try {
//						sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				paint.add(nodeToVisit);
				panelToPaint.setRoute(paint);
				panelToPaint.repaint();
				try {
					sleep(1000);	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
