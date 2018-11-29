package graphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import graph.Directed.Edge;
import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import javafx.scene.shape.LineTo;
import model.Point;

public class PanelStructures extends JPanel{

	private JLabel labelStructures;
	private ArrayList<Node<Point, Integer>> route;
	private Node<Point, Integer> nodeToPaint2;
	private HashMap<Integer, Node<Point, Integer>> nodesToPaint;
	private HashMap<Integer, EdgeSrcEnd<Integer>> linesToPaint;
	private HashMap<Integer, Boolean> nodesPainted;
	private String algoritm;
	private Color color;
	
	public PanelStructures(String algoritm, Color color) {
		this.setVisible(true);
		this.algoritm = algoritm;
		this.color = color;
		this.setBackground(Color.GRAY);
		this.setBounds(160, 11, 502, 415);
		this.nodeToPaint2 = null;
		route = new ArrayList<Node<Point, Integer>>();
		nodesToPaint = new HashMap<Integer, Node<Point, Integer>>();
		linesToPaint = new HashMap<Integer, EdgeSrcEnd<Integer>>();
		nodesPainted = new HashMap<Integer, Boolean>();
		labelStructures = new JLabel("Graph");
		labelStructures.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		this.add(labelStructures);	
	}
	
	public Node<Point, Integer> getNodeToPaint() {
		return nodeToPaint2;
	}

	public void setNodeToPaint(Node<Point, Integer> nodeToPaint) {
		this.nodeToPaint2 = nodeToPaint;
	}

	public HashMap<Integer, EdgeSrcEnd<Integer>> getLinesToPaint() {
		return linesToPaint;
	}

	public void setLinesToPaint(HashMap<Integer, EdgeSrcEnd<Integer>> linesToPaint) {
		this.linesToPaint = linesToPaint;
	}
	
	public void fill() {
		if(nodesToPaint != null && linesToPaint != null) {
			for(Node<Point, Integer> node : nodesToPaint.values()) {
				nodesPainted.put(node.getKey(), false);
			}			
		}
		
	}
	

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public void paintComponent(Graphics g) {
		
		fill();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(Node<Point, Integer> nodeToPaint: nodesToPaint.values()) {
			if(algoritm.equals("BFS")) {
					g.setColor(color);
					g.fillOval(nodeToPaint.getValue().getxPosition(), nodeToPaint.getValue().getyPosition(), nodeToPaint.getValue().getRadius(), nodeToPaint.getValue().getRadius());
					g.setColor(Color.WHITE);
					g.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
					g.drawString(nodeToPaint.getKey() + "", nodeToPaint.getValue().getxPosition() , nodeToPaint.getValue().getyPosition());
					g.setColor(color);
					for(EdgeSrcEnd<Integer> edge : linesToPaint.values()) {
						int xSource = nodesToPaint.get(edge.getSrc().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2; 
						int xEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						int ySource =  nodesToPaint.get(edge.getSrc().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						int yEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						g.drawLine(xSource, ySource, xEnd, yEnd);
						g.setColor(Color.BLACK);
						g.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
						g.drawString(edge.getWeightKey() + "", (xSource + xEnd)/2 , (yEnd + ySource) / 2 );
					}
					if(route.size() != 0) {
						for(int i = 0; i < route.size() ; i ++) {
							g.setColor(Color.GREEN);
							g.fillOval(route.get(i).getValue().getxPosition(), route.get(i).getValue().getyPosition(), route.get(i).getValue().getRadius(), route.get(i).getValue().getRadius());
						}
					}
			}
			if(algoritm.equals("DFS")) {
				g.setColor(color);
				g.fillOval(nodeToPaint.getValue().getxPosition(), nodeToPaint.getValue().getyPosition(), nodeToPaint.getValue().getRadius(), nodeToPaint.getValue().getRadius());
				g.setColor(Color.WHITE);
				g.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
				g.drawString(nodeToPaint.getKey() + "", nodeToPaint.getValue().getxPosition() , nodeToPaint.getValue().getyPosition());
				g.setColor(color);
				for(EdgeSrcEnd<Integer> edge : linesToPaint.values()) {
					int xSource = nodesToPaint.get(edge.getSrc().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2; 
					int xEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					int ySource =  nodesToPaint.get(edge.getSrc().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					int yEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					g.drawLine(xSource, ySource, xEnd, yEnd);
					g.setColor(Color.BLACK);
					g.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
					g.drawString(edge.getWeightKey() + "", (xSource + xEnd)/2 , (yEnd + ySource) / 2 );
				}
				if(route.size() != 0) {
					for(int i = 0; i < route.size() ; i ++) {
						g.setColor(Color.RED);
						g.fillOval(route.get(i).getValue().getxPosition(), route.get(i).getValue().getyPosition(), route.get(i).getValue().getRadius(), route.get(i).getValue().getRadius());
					}
				}
			}
			if(algoritm.equals("KRUSKAL")) {
				g.setColor(color);
				g.fillOval(nodeToPaint.getValue().getxPosition(), nodeToPaint.getValue().getyPosition(), nodeToPaint.getValue().getRadius(), nodeToPaint.getValue().getRadius());
				g.setColor(Color.WHITE);
				g.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
				g.drawString(nodeToPaint.getKey() + "", nodeToPaint.getValue().getxPosition() , nodeToPaint.getValue().getyPosition());
				g.setColor(color);
				for(EdgeSrcEnd<Integer> edge : linesToPaint.values()) {
					int xSource = nodesToPaint.get(edge.getSrc().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2; 
					int xEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					int ySource =  nodesToPaint.get(edge.getSrc().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					int yEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					g.drawLine(xSource, ySource, xEnd, yEnd);
					g.setColor(Color.BLACK);
					g.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
					g.drawString(edge.getWeightKey() + "", (xSource + xEnd)/2 , (yEnd + ySource) / 2 );
				}
				if(route.size() != 0) {
					for(int i = 0; i < route.size() ; i ++) {
						g.setColor(Color.GREEN);
						g.fillOval(route.get(i).getValue().getxPosition(), route.get(i).getValue().getyPosition(), route.get(i).getValue().getRadius(), route.get(i).getValue().getRadius());
					}
				}
			}
			if(algoritm.equals("PRIM")) {
				g.setColor(color);
				g.fillOval(nodeToPaint.getValue().getxPosition(), nodeToPaint.getValue().getyPosition(), nodeToPaint.getValue().getRadius(), nodeToPaint.getValue().getRadius());
				g.setColor(Color.WHITE);
				g.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
				g.drawString(nodeToPaint.getKey() + "", nodeToPaint.getValue().getxPosition() , nodeToPaint.getValue().getyPosition());
				g.setColor(color);
				for(EdgeSrcEnd<Integer> edge : linesToPaint.values()) {
					int xSource = nodesToPaint.get(edge.getSrc().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2; 
					int xEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					int ySource =  nodesToPaint.get(edge.getSrc().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					int yEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
					g.drawLine(xSource, ySource, xEnd, yEnd);
					g.setColor(Color.BLACK);
					g.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
					g.drawString(edge.getWeightKey() + "", (xSource + xEnd)/2 , (yEnd + ySource) / 2 );
				}
				if(route.size() != 0) {
					for(int i = 0; i < route.size() ; i ++) {
						g.setColor(Color.GREEN);
						g.fillOval(route.get(i).getValue().getxPosition(), route.get(i).getValue().getyPosition(), route.get(i).getValue().getRadius(), route.get(i).getValue().getRadius());
					}
				}
			}
		}

	}
	
	public ArrayList<Node<Point, Integer>> getRoute() {
		return route;
	}

	public void setRoute(ArrayList<Node<Point, Integer>> route) {
		this.route = route;
	}

	public HashMap<Integer, Node<Point, Integer>> getNodesToPaint() {
		return nodesToPaint;
	}

	public void setNodesToPaint(HashMap<Integer, Node<Point, Integer>> nodesToPaint) {
		this.nodesToPaint = nodesToPaint;
	}



		
}
