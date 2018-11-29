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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

public class PanelCanvasList extends JPanel implements ActionListener {

	private Main main;
	private HashMap<Integer, Point> pointsRed;
	
	private HashMap<Integer, Node<Point, Integer>> nodes;
	//private EdgeSrcEnd<Integer>[][] matrix;  Estructura donde estan tus adjacencias

	
	private JButton btnBfs;
	private JButton btnDijkstra;
	private JButton btnFloyd ;
	private JButton btnPrim;
	private JButton btnKruskal;
	private JLabel lblGrafo;
	private JButton btnDfs;

	public PanelCanvasList(Main main, HashMap<Integer, Node<Point, Integer>> nodes /**, estructura donde estan las adj **/) {

		btnBfs = new JButton("bfs");
		btnDfs = new JButton("dfs");
		lblGrafo = new JLabel("Grafo");
		btnDijkstra = new JButton("Dijkstra");
		btnFloyd = new JButton("Floyd");
		btnPrim = new JButton("Prim");
		btnKruskal = new JButton("Kruskal");
		
		this.nodes = nodes;
		this.main = main;
//		this.matrix =  matrix;
		setLayout(null);
		pointsRed = new HashMap<>();
		lblGrafo.setBounds(201, 43, 46, 14);
		add(lblGrafo);
		btnBfs.setBounds(10, 7, 59, 23);
		add(btnBfs);
		btnBfs.addActionListener(this);
		
		btnDfs.setBounds(79, 7, 59, 23);
		add(btnDfs);
		
		
		btnDijkstra.setBounds(148, 7, 69, 23);
		add(btnDijkstra);
		
		btnFloyd.addActionListener(this);
		btnFloyd.setBounds(227, 7, 69, 23);
		add(btnFloyd);
		
		btnKruskal.setBounds(306, 7, 69, 23);
		add(btnKruskal);
		
		btnPrim.setBounds(385, 7, 55, 23);
		add(btnPrim);

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
				x++;
			}
			
			int z = 0;
		
			if(pointsRed.size() == nodes.size()) {
				
				for(Integer k : pointsRed.keySet()) {
					
					if((z+1) < pointsRed.size()) {
						Point p1 = pointsRed.get(z);
						Point p2 = pointsRed.get(z+1);
						
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
			}else {
				
				/**
				 * Recorrido para sacar los puntos donde pintar las aristas
				 */
				
//				for (int i = 0; i < main.getModelGraphs().getSimpleUndirectedGraph().getMatrix().length; i++) {
//					for (int j = 0; j < main.getModelGraphs().getSimpleUndirectedGraph().getMatrix().length; j++) {
//						if(main.getModelGraphs().getSimpleUndirectedGraph().getMatrix()[i][j].getWeightKey() != Double.MAX_VALUE) {
//							
//							Point p1 = ((Point)main.getModelGraphs().getSimpleUndirectedGraph().getMatrix()[i][j].getSrc().getValue());
//							Point p2 = ((Point)main.getModelGraphs().getSimpleUndirectedGraph().getMatrix()[i][j].getEnd().getValue());
//							
//							
//							int x1 = p1.getxPosition();
//							int y1 = p1.getyPosition();
//							int x2 = p2.getxPosition();
//							int y2 = p2.getyPosition();
//							int r = p2.getRadius(); 
//							g.setColor(Color.BLACK);
//							g.drawLine(x1 + r, y1 + r, x2 + r, y2 + r);
//							
//						}
//					}
//				}
			}
			

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.bfs(1);
		
	}
}
