package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import graph.Directed.Node;
import model.Point;
import threads.PaintThreadMultiGraph;

public class PanelPseudo extends JPanel implements ActionListener {

	private JPanel panelButton;
	private JButton bfs; 
	private JButton dfs;
	private JButton kruskal;
	private JButton prime;
	private JPanel panelContainer;
	private PanelStructures panelStructure;
	private PanelGraph panelGraph;
	private Main main;
	
	
	public PanelPseudo(Main main) {
		
		this.main = main;
		panelButton = new JPanel();
		panelContainer = new JPanel();
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout(0, 0));
		this.add(panelButton, BorderLayout.NORTH);
		
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		bfs = new JButton("BFS");
		bfs.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		bfs.setBackground(Color.WHITE);
		bfs.setForeground(Color.BLACK);
		bfs.addActionListener(this);
		panelButton.add(bfs);
	
		dfs = new JButton("DFS");
		dfs.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		dfs.setBackground(Color.WHITE);
		dfs.addActionListener(this);
		panelButton.add(dfs);
		
		kruskal = new JButton("Kruskal");
		kruskal.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		kruskal.setBackground(Color.WHITE);
		kruskal.addActionListener(this);
		panelButton.add(kruskal);
		
		prime = new JButton("Prim");
		prime.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		prime.setBackground(Color.WHITE);
		prime.addActionListener(this);
		panelButton.add(prime);
		
		add(panelContainer, BorderLayout.CENTER);
		panelContainer.setLayout(new BorderLayout());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(bfs)) {
			panelStructure = new PanelStructures("BFS", Color.blue);
			panelStructure.setNodesToPaint(main.getGraphs().getUndirectedPseudoGraph().getNodes());
			panelStructure.setLinesToPaint(main.getGraphs().getUndirectedPseudoGraph().getGeneralEdges());
			panelContainer.add(panelStructure);
			panelStructure.repaint();
			String nodeSource = JOptionPane.showInputDialog("Introduce node´s key");
			if(nodeSource != null) {
				Node<Point, Integer> nod = main.getGraphs().getUndirectedPseudoGraph().getNodes().get(Integer.parseInt(nodeSource));
				main.getGraphs().getUndirectedPseudoGraph().bfs(nod);
				PaintThreadMultiGraph thread = new PaintThreadMultiGraph(main.getGraphs(), panelStructure, "P");
				thread.start();
			}
		}
		else if(e.getSource().equals(dfs)) {
			panelStructure = new PanelStructures("BFS", Color.CYAN);
			panelStructure.setNodesToPaint(main.getGraphs().getUndirectedPseudoGraph().getNodes());
			panelStructure.setLinesToPaint(main.getGraphs().getUndirectedPseudoGraph().getGeneralEdges());
			panelContainer.add(panelStructure);
			panelStructure.repaint();
			String nodeSource = JOptionPane.showInputDialog("Introduce node´s key");
			if(nodeSource != null) {
				Node<Point, Integer> nod = main.getGraphs().getUndirectedPseudoGraph().getNodes().get(Integer.parseInt(nodeSource));
				main.getGraphs().getUndirectedPseudoGraph().dfs(nod);
				PaintThreadMultiGraph thread = new PaintThreadMultiGraph(main.getGraphs(), panelStructure, "P");
				thread.start();
			}
		}
		if(e.getSource().equals(kruskal)) {
			panelStructure = new PanelStructures("BFS", Color.orange);
			panelStructure.setNodesToPaint(main.getGraphs().getUndirectedPseudoGraph().getNodes());
			panelStructure.setLinesToPaint(main.getGraphs().getUndirectedPseudoGraph().getGeneralEdges());
			panelContainer.add(panelStructure);
			panelStructure.repaint();
			main.getGraphs().getUndirectedPseudoGraph().kruscal();
			PaintThreadMultiGraph thread = new PaintThreadMultiGraph(main.getGraphs(), panelStructure, "P");
			thread.start();
		}
		if(e.getSource().equals(prime)) {
			panelStructure = new PanelStructures("BFS", Color.pink);
			panelStructure.setNodesToPaint(main.getGraphs().getUndirectedPseudoGraph().getNodes());
			panelStructure.setLinesToPaint(main.getGraphs().getUndirectedPseudoGraph().getGeneralEdges());
			panelContainer.add(panelStructure);
			panelStructure.repaint();
			String nodeSource = JOptionPane.showInputDialog("Introduce node´s key");
			if(nodeSource != null) {
				Node<Point, Integer> nod = main.getGraphs().getUndirectedPseudoGraph().getNodes().get(Integer.parseInt(nodeSource));
				main.getGraphs().getUndirectedPseudoGraph().prim(nod);
				PaintThreadMultiGraph thread = new PaintThreadMultiGraph(main.getGraphs(), panelStructure, "P");
				thread.start();
			}
		}
		
		
	}
	
	
}
