package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import model.Point;

public class DialogSimpleUndirected extends JDialog {

	public final static int ANCHO = 1000;
	public final static int ALTO = 550;
	
	
	private PanelSimpleUndirected panelSimpleUndirectedDirected;
	private Main main;
	
	public DialogSimpleUndirected(Main main, HashMap<Integer, Node<Point, Integer>> nodes, EdgeSrcEnd<Integer>[][] matrix) {
		panelSimpleUndirectedDirected = new PanelSimpleUndirected(main, nodes, matrix);
		this.main = main;
		
		setSize(ANCHO, ALTO);
		setLayout(new BorderLayout());
		JLabel lblNewLabel = new JLabel("Simple no Dirigido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		add(panelSimpleUndirectedDirected, BorderLayout.CENTER);
		
		setResizable(false);
	}

	public PanelSimpleUndirected getPanelSimpleUndirectedDirected() {
		return panelSimpleUndirectedDirected;
	}

	
	
	

}
