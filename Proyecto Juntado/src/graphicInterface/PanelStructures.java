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
import model.Point;

public class PanelStructures extends JPanel{

	private JLabel labelStructures;
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
		this.setBounds(293, 11, 502, 415);
		nodesToPaint = new HashMap<Integer, Node<Point, Integer>>();
		linesToPaint = new HashMap<Integer, EdgeSrcEnd<Integer>>();
		nodesPainted = new HashMap<Integer, Boolean>();
		labelStructures = new JLabel("Graph");
		labelStructures.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		this.add(labelStructures);		
	}
	
	
	public HashMap<Integer, EdgeSrcEnd<Integer>> getLinesToPaint() {
		return linesToPaint;
	}

	public void setLinesToPaint(HashMap<Integer, EdgeSrcEnd<Integer>> linesToPaint) {
		this.linesToPaint = linesToPaint;
	}
	
	public void fill() {
		for(Node<Point, Integer> node : nodesToPaint.values()) {
			nodesPainted.put(node.getKey(), false);
		}
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
					if(nodesPainted.get(edge.getSrc().getKey()) && nodesPainted.get(edge.getEnd().getKey())) {
						int xSource = nodesToPaint.get(edge.getSrc().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2; 
						int xEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						int ySource =  nodesToPaint.get(edge.getSrc().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						int yEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						g.setColor(Color.white);
						g.drawArc(xSource, ySource, xEnd - xSource, 300, 60, 2);
					}
					else {
						int xSource = nodesToPaint.get(edge.getSrc().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2; 
						int xEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getxPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						int ySource =  nodesToPaint.get(edge.getSrc().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						int yEnd = nodesToPaint.get(edge.getEnd().getKey()).getValue().getyPosition() + nodesToPaint.get(edge.getSrc().getKey()).getValue().getRadius() / 2;
						g.drawLine(xSource, ySource, xEnd, yEnd);
						g.setColor(Color.BLACK);
						g.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
						g.drawString(edge.getWeightKey() + "", (xSource + xEnd)/2 , (yEnd + ySource) / 2 );
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
			}
		}

	}



	public HashMap<Integer, Node<Point, Integer>> getNodesToPaint() {
		return nodesToPaint;
	}

	public void setNodesToPaint(HashMap<Integer, Node<Point, Integer>> nodesToPaint) {
		this.nodesToPaint = nodesToPaint;
	}



		
}
