package graphicInterface;

import javax.swing.JPanel;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import model.Point;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

public class PanelSimpleDirected extends JPanel {

	
	
	private PanelCanvasMatrix panelCanvas;
	private Main main;

//	private JPanel panelButton = new JPanel();
//	private JButton btnNewButton = new JButton("BFS");
//	private JButton btnNewButton_1 = new JButton("DFS");
//	private JButton btnNewButton_2 = new JButton("Dijkstra");
//	private JButton btnNewButton_3 = new JButton("Floyd Warshall");
//	private JPanel panelBack = new JPanel();
//	private JPanel panelStructure = new JPanel();
//	private FlowLayout flowLayout = (FlowLayout) panelStructure.getLayout();
//	private JLabel lblStructure = new JLabel("Structure");

	public PanelSimpleDirected(Main main, HashMap<Integer, Node<Point, Integer>> nodes, EdgeSrcEnd<Integer>[][] matrix , ArrayList<Integer> path) {
		
		this.main = main;
		setLayout(new BorderLayout());
		panelCanvas = new PanelCanvasMatrix(main, nodes, matrix, path);
		add(panelCanvas, BorderLayout.CENTER);
//		setBackground(Color.LIGHT_GRAY);
//		setLayout(new BorderLayout(0, 0));
//		
//		add(panelButton, BorderLayout.NORTH);
//		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		
//		panelButton.add(btnNewButton);
//		
//		panelButton.add(btnNewButton_1);
//		
//		panelButton.add(btnNewButton_2);
//		
//		
//		panelButton.add(btnNewButton_3);
//		add(panelBack, BorderLayout.CENTER);
//		panelBack.setLayout(null);
//		
//		panelStructure.setBounds(10, 11, 430, 245);
//		panelBack.add(panelStructure);
//		
//		panelStructure.add(lblStructure);

	}

	public PanelCanvasMatrix getPanelCanvas() {
		return panelCanvas;
	}

	public void setPanelCanvas(PanelCanvasMatrix panelCanvas) {
		this.panelCanvas = panelCanvas;
	}
	
	

}
