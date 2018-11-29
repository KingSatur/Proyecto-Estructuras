package graphicInterface;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.xml.crypto.dsig.keyinfo.KeyName;

import com.sun.javafx.css.converters.PaintConverter.RepeatingImagePatternConverter;

import graph.Directed.EdgeSrcEnd;
import graph.Directed.Node;
import javafx.scene.shape.Circle;
import model.Point;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

public class PanelCanvasMatrix extends JPanel implements ActionListener {

	private Main main;
	private HashMap<Integer, Point> pointsRed;

	private HashMap<Integer, Node<Point, Integer>> nodes;
	private EdgeSrcEnd<Integer>[][] matrix;

	private JButton btnBfs;
	private JButton btnDijkstra;
	private JButton btnFloyd;
	private JButton btnPrim;
	private JButton btnKruskal;
	private JLabel lblGrafo;
	private JButton btnDfs;

	public PanelCanvasMatrix(Main main, HashMap<Integer, Node<Point, Integer>> nodes, EdgeSrcEnd<Integer>[][] matrix) {
		btnDfs = new JButton("dfs");
		btnBfs = new JButton("bfs");
		lblGrafo = new JLabel("Grafo");
		btnDijkstra = new JButton("Dijkstra");
		btnFloyd = new JButton("Floyd");
		btnPrim = new JButton("Prim");
		btnKruskal = new JButton("Kruskal");

		this.nodes = nodes;
		this.main = main;
		this.matrix = matrix;
		setLayout(null);
		pointsRed = new HashMap<>();
		lblGrafo.setBounds(499, 65, 46, 14);
		add(lblGrafo);
		btnBfs.setBounds(157, 7, 59, 23);
		add(btnBfs);

		btnDfs.setBounds(288, 7, 59, 23);
		add(btnDfs);

		btnDijkstra.setBounds(423, 7, 90, 23);
		add(btnDijkstra);

		btnFloyd.setBounds(567, 7, 69, 23);
		add(btnFloyd);

		btnKruskal.setBounds(693, 7, 90, 23);
		add(btnKruskal);

		btnPrim.setBounds(842, 7, 69, 23);
		add(btnPrim);
		
		btnBfs.addActionListener(this);
		btnDfs.addActionListener(this);
		btnDijkstra.addActionListener(this);
		btnFloyd.addActionListener(this);
		btnKruskal.addActionListener(this);
		btnPrim.addActionListener(this);
		
		

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = 0;
		for (Integer k : nodes.keySet()) {
			Node<Point, Integer> aux = nodes.get(k);
			if (aux.getValue().getColor().getColor() == Point.RED) {
				g.setColor(Color.RED);
				pointsRed.put(x, aux.getValue());
			} else {
				g.setColor(Color.BLACK);
			}
			g.fillOval(aux.getValue().getxPosition(), aux.getValue().getyPosition(), aux.getValue().getRadius() * 2,
					aux.getValue().getRadius() * 2);
			g.setColor(Color.white);
			g.drawString(aux.getKey()+"", nodes.get(k).getValue().getxPosition() + nodes.get(k).getValue().getRadius(), nodes.get(k).getValue().getyPosition() +  nodes.get(k).getValue().getRadius());
			
			x++;
		}

		int z = 0;

		if (pointsRed.size() == nodes.size()) {

			for (Integer k : pointsRed.keySet()) {

				System.out.println(pointsRed.get(k).getxPosition() +"  "+  (pointsRed.get(k).getyPosition()));
				
				if ((z + 1) < pointsRed.size()) {
					Point p1 = pointsRed.get(z);
					Point p2 = pointsRed.get(z + 1);

					int x1 = p1.getxPosition();
					int y1 = p1.getyPosition();
					int x2 = p2.getxPosition();
					int y2 = p2.getyPosition();
					int r = p2.getRadius();

					g.setColor(Color.RED);
					g.drawLine(x1 + r, y1 + r, x2 + r, y2 + r);
					
				}
				z++;
			}
		} else {

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j].getWeightKey() != Double.MAX_VALUE  &&  matrix[i][j].getWeightKey() != 0.0) {

						Point p1 = ((Point) matrix[i][j].getSrc().getValue());
						Point p2 = ((Point) matrix[i][j].getEnd().getValue());

						int x1 = p1.getxPosition();
						int y1 = p1.getyPosition();
						int x2 = p2.getxPosition();
						int y2 = p2.getyPosition();
						int r = p2.getRadius();
						g.setColor(Color.BLACK);
						g.drawLine(x1 + r, y1 + r, x2 + r, y2 + r);
						g.drawString(matrix[i][j].getWeightKey()+"", (x1+x2)/2, (y1+y2)/2);

					}
				}
			}
			
			
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j].getWeightKey() != Double.MAX_VALUE  &&  matrix[i][j].getWeightKey() != 0.0) {
					Point p1 = ((Point) matrix[i][j].getSrc().getValue());
					Point p2 = ((Point) matrix[i][j].getEnd().getValue());

					int x1 = p1.getxPosition();
					int y1 = p1.getyPosition();
					int x2 = p2.getxPosition();
					int y2 = p2.getyPosition();
					
					g.drawString(matrix[i][j].getWeightKey()+"", (x1+x2)/2, (y1+y2)/2);
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource().equals(btnBfs)) {
			
			String key = JOptionPane.showInputDialog(null, "Llave del nodo inicial");
			if (key != null && !key.isEmpty()) {
				main.bfs(Integer.parseInt(key));							
			}
		}
		if(e.getSource().equals(btnDfs)) {
			String key2 = JOptionPane.showInputDialog(null, "Llave del nodo inicial");
			if (key2 != null && !key2.isEmpty()) {
				main.dfs(Integer.parseInt(key2));							
			}
		}
		if(e.getSource().equals(btnDijkstra)) {
			String key3 = JOptionPane.showInputDialog(null, "Llave del nodo inicial");
			if (key3 != null && !key3.isEmpty()) {
				main.dijkstra(Integer.parseInt(key3));							
			}
		}
		if(e.getSource().equals(btnFloyd)) {
			main.floydWarshall();
		}
		if(e.getSource().equals(btnKruskal)) {
			main.kruskal();
		}
		if(e.getSource().equals(btnPrim)) {
			main.prim();
		}	
		
		
	}
}
