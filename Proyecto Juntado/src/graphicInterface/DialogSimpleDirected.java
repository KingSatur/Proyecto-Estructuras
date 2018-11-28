package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import model.Point;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DialogSimpleDirected extends JDialog {
	
	public final static int ANCHO = 1000;
	public final static int ALTO = 550;
	
	
	private PanelSimpleDirected panelSimpleDirected;
	private final JPanel contentPanel = new JPanel();
	private Main main;

	
	/**
	 * Create the dialog.
	 */
	public DialogSimpleDirected(Main main, HashMap<Integer, Node<Point, Integer>> nodes, EdgeSrcEnd<Integer>[][] matrix) {
		
		this.main =  main;
		panelSimpleDirected = new PanelSimpleDirected(main, nodes, matrix);
		getContentPane().add(panelSimpleDirected);
		setSize(ANCHO, ALTO);
		JLabel lblNewLabel = new JLabel("Simple Dirigido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		setResizable(false);
	

	}


	public PanelSimpleDirected getPanelSimpleDirected() {
		return panelSimpleDirected;
	}
	
	

}
