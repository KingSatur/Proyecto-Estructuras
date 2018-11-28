package 

graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGraph extends JPanel{
	
	private PanelAdjacencyList adjacencyList;
	private JLabel labelGraph;
	private Main main;
	
	
	public PanelGraph(Main main) {
		this.main = main;
		labelGraph = new JLabel("Structures");
		labelGraph.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		labelGraph.setForeground(Color.BLACK);
		labelGraph.setBounds(80, 11, 140, 27);
		add(labelGraph);
		adjacencyList = new PanelAdjacencyList(main);
		add(adjacencyList);
		this.setVisible(true);
		this.setBounds(293, 11, 502, 415);
		this.setLocation(10, 11);
		this.setBackground(Color.RED);
		this.setSize(new Dimension(273, 415));
	}


	public PanelAdjacencyList getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(PanelAdjacencyList adjacencyList) {
		this.adjacencyList = adjacencyList;
	}	
	
	
//	public void paintComponent(Graphics g) {
//		
//		
//	}
}
