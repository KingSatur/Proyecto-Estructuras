package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Graphs;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import threads.*;

public class Main extends JFrame implements ActionListener {

	private DialogSimpleDirected dSimpleDirected;
	private DialogSimpleUndirected dSimpleUndirected;
	private DialogMultiGraphUndirected dMultiUndirected;
	private DialogPseudo dPseudo;
	private JPanel contentPane;
	private JLabel lblGraph;
	private JButton btnMultiGraphUndirected;
	private JButton btnSimpleDirected;
	private JButton btnSimpleUndirected;
	private JButton btnPseudoGraph;
	private Graphs modelGraphs;
	private boolean simplreDirected;
	private boolean simpleUndirected;
	private boolean MultiGraph;
	private boolean Pseudo;
	
	
	public Main() {
		modelGraphs = new Graphs();
		lblGraph = new JLabel("Graph");
		lblGraph.setForeground(Color.RED);
		lblGraph.setFont(new Font("Tw Cen MT", Font.PLAIN, 45));
		btnMultiGraphUndirected = new JButton("Multigrafo no dirigido -  Lista");
		btnMultiGraphUndirected.setForeground(Color.BLUE);
		btnMultiGraphUndirected.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnSimpleDirected = new JButton("Simple dirigido - Matriz");
		btnSimpleDirected.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnSimpleDirected.setForeground(Color.BLUE);
		btnSimpleUndirected = new JButton("Simple no dirigido - Matriz");
		btnSimpleUndirected.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnPseudoGraph = new JButton("Pseudografo - Lista");
		btnPseudoGraph.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 453);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblGraph.setBackground(Color.LIGHT_GRAY);
		lblGraph.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraph.setBounds(107, 22, 174, 34);
		contentPane.add(lblGraph);

		btnMultiGraphUndirected.setBackground(Color.WHITE);
		btnMultiGraphUndirected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMultiGraphUndirected.setBounds(91, 256, 200, 59);
		contentPane.add(btnMultiGraphUndirected);

		btnSimpleDirected.setBackground(Color.WHITE);
		btnSimpleDirected.setBounds(91, 83, 200, 59);
		contentPane.add(btnSimpleDirected);

		btnSimpleUndirected.setBackground(Color.WHITE);
		btnSimpleUndirected.setBounds(91, 171, 200, 59);
		contentPane.add(btnSimpleUndirected);

		btnPseudoGraph.setBackground(Color.WHITE);
		btnPseudoGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPseudoGraph.setBounds(91, 344, 200, 59);
		contentPane.add(btnPseudoGraph);
		
		
		btnSimpleDirected.addActionListener(this);
		btnSimpleUndirected.addActionListener(this);
		btnMultiGraphUndirected.addActionListener(this);
		btnPseudoGraph.addActionListener(this);

	}

	public Graphs getGraphs() {
		return modelGraphs;
	}
	
	public DialogSimpleDirected getdSimpleDirected() {
		return dSimpleDirected;
	}

	public void setdSimpleDirected(DialogSimpleDirected dSimpleDirected) {
		this.dSimpleDirected = dSimpleDirected;
	}

	public DialogSimpleUndirected getdSimpleUndirected() {
		return dSimpleUndirected;
	}

	public void setdSimpleUndirected(DialogSimpleUndirected dSimpleUndirected) {
		this.dSimpleUndirected = dSimpleUndirected;
	}

	public DialogMultiGraphUndirected getdMultiUndirected() {
		return dMultiUndirected;
	}

	public void setdMultiUndirected(DialogMultiGraphUndirected dMultiUndirected) {
		this.dMultiUndirected = dMultiUndirected;
	}

	public DialogPseudo getdPseudo() {
		return dPseudo;
	}

	public void setdPseudo(DialogPseudo dPseudo) {
		this.dPseudo = dPseudo;
	}
	
	public JLabel getLblGraph() {
		return lblGraph;
	}

	public void setLblGraph(JLabel lblGraph) {
		this.lblGraph = lblGraph;
	}

	public JButton getBtnMultiGraphUndirected() {
		return btnMultiGraphUndirected;
	}

	public void setBtnMultiGraphUndirected(JButton btnMultiGraphUndirected) {
		this.btnMultiGraphUndirected = btnMultiGraphUndirected;
	}

	public JButton getBtnSimpleDirected() {
		return btnSimpleDirected;
	}

	public void setBtnSimpleDirected(JButton btnSimpleDirected) {
		this.btnSimpleDirected = btnSimpleDirected;
	}

	public JButton getBtnSimpleUndirected() {
		return btnSimpleUndirected;
	}

	public void setBtnSimpleUndirected(JButton btnSimpleUndirected) {
		this.btnSimpleUndirected = btnSimpleUndirected;
	}

	public JButton getBtnPseudoGraph() {
		return btnPseudoGraph;
	}

	public void setBtnPseudoGraph(JButton btnPseudoGraph) {
		this.btnPseudoGraph = btnPseudoGraph;
	}

	public boolean isSimplreDirected() {
		return simplreDirected;
	}

	public void setSimplreDirected(boolean simplreDirected) {
		this.simplreDirected = simplreDirected;
	}

	public boolean isSimpleUndirected() {
		return simpleUndirected;
	}

	public void setSimpleUndirected(boolean simpleUndirected) {
		this.simpleUndirected = simpleUndirected;
	}

	public boolean isMultiGraph() {
		return MultiGraph;
	}

	public void setMultiGraph(boolean multiGraph) {
		MultiGraph = multiGraph;
	}

	public boolean isPseudo() {
		return Pseudo;
	}

	public void setPseudo(boolean pseudo) {
		Pseudo = pseudo;
	}

	public void setModelGraphs(Graphs modelGraphs) {
		this.modelGraphs = modelGraphs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnSimpleDirected)) {
			modelGraphs.createSimpleGraph();
			dSimpleDirected = new DialogSimpleDirected(this, modelGraphs.getSimpleDirectedGraph().getNodes(),
			modelGraphs.getSimpleDirectedGraph().getMatrix(),  modelGraphs.getSimpleDirectedGraph().getPath());
			dSimpleDirected.setVisible(true);
			dSimpleDirected.setLocationRelativeTo(this);
			simplreDirected = true;
			simpleUndirected = false;
			MultiGraph = false;
			Pseudo = false;
		}
		if (e.getSource().equals(btnSimpleUndirected)) {
			modelGraphs.createSimpleUndirectedGraph();
			dSimpleUndirected = new DialogSimpleUndirected(this, modelGraphs.getSimpleUndirectedGraph().getNodes(),
			modelGraphs.getSimpleUndirectedGraph().getMatrix(), modelGraphs.getSimpleUndirectedGraph().getPath() );
			dSimpleUndirected.setVisible(true);
			dSimpleUndirected.setLocationRelativeTo(null);
			simplreDirected = false;
			simpleUndirected = true;
			MultiGraph = false;
			Pseudo = false;
		}
		if (e.getSource().equals(btnMultiGraphUndirected)) {
			dMultiUndirected = new DialogMultiGraphUndirected(this);
			dMultiUndirected.setVisible(true);
		}
		if (e.getSource().equals(btnPseudoGraph)) {
			dPseudo = new DialogPseudo(this);
			dPseudo.setVisible(true);
		}

	}

	public void bfs(Integer k) {

		if (simplreDirected) {
			modelGraphs.getSimpleDirectedGraph().bfs(k);
			paintNodes paint = new paintNodes(dSimpleDirected.getPanelSimpleDirected().getPanelCanvas(),
					modelGraphs.getSimpleDirectedGraph().getPath(), modelGraphs.getSimpleDirectedGraph().getNodes(),
					modelGraphs.getSimpleDirectedGraph().getFathers());
			paint.start();
		}
		if(simpleUndirected) {
			modelGraphs.getSimpleUndirectedGraph().bfs(k);
			paintNodes paint2 = new paintNodes(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), modelGraphs.getSimpleUndirectedGraph().getNodes(),
					modelGraphs.getSimpleUndirectedGraph().getFathers());
			paint2.start();
			
			paintEdges paintEdges = new paintEdges(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(), modelGraphs.getSimpleUndirectedGraph().getFathers(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), simplreDirected, false);
			paintEdges.start();
			
		}
		if(MultiGraph) {
//			modelGraphs.getUndirectedMultigraph().bfs(k);
//			paint paint3 = new paint(dMultiUndirected.getPanelMultiUndirected().getPanelCanvas(),
//					modelGraphs.getUndirectedMultigraph().getPath(), modelGraphs.getUndirectedMultigraph().getNodes(),
//					modelGraphs.getUndirectedMultigraph()..getFathers());
//			paint3.start();	
		}
		if(Pseudo) {
//			modelGraphs.getUndirectedPseudoGraph().bfs(k);
//			paint paint4 = new paint(dPseudo.getPanelPseudo().getPanelCanvas(),
//			modelGraphs.getUndirectedPseudoGraph().getPath(), modelGraphs.getUndirectedPseudoGraph().getNodes(),
//			modelGraphs.getUndirectedPseudoGraph().getFathers());
//	paint4.start();
			
		}
	

	}

	public void dfs(Integer k) {
			if (simplreDirected) {
			modelGraphs.getSimpleDirectedGraph().dfs(k);
			paintNodes paint = new paintNodes(dSimpleDirected.getPanelSimpleDirected().getPanelCanvas(),
					modelGraphs.getSimpleDirectedGraph().getPath(), modelGraphs.getSimpleDirectedGraph().getNodes(),
					modelGraphs.getSimpleDirectedGraph().getFathers());
			paint.start();
		}
		if(simpleUndirected) {
			modelGraphs.getSimpleUndirectedGraph().dfs(k);
			paintNodes paint2 = new paintNodes(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), modelGraphs.getSimpleUndirectedGraph().getNodes(),
					modelGraphs.getSimpleUndirectedGraph().getFathers());
			paint2.start();
			
			paintEdges paintEdges = new paintEdges(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(), modelGraphs.getSimpleUndirectedGraph().getFathers(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), simplreDirected, false);
			paintEdges.start();
			
			
		}
//		if(MultiGraph) {
////			modelGraphs.getUndirectedMultigraph().dfs(k);
////			paint paint3 = new paint(dMultiUndirected.getPanelMultiUndirected().getPanelCanvas(),
////					modelGraphs.getUndirectedMultigraph().getPath(), modelGraphs.getUndirectedMultigraph().getNodes(),
////					modelGraphs.getUndirectedMultigraph()..getFathers());
////			paint3.start();	
//		}
//		if(Pseudo) {
////			modelGraphs.getUndirectedPseudoGraph().dfs(k);
////			paint paint4 = new paint(dPseudo.getPanelPseudo().getPanelCanvas(),
////			modelGraphs.getUndirectedPseudoGraph().getPath(), modelGraphs.getUndirectedPseudoGraph().getNodes(),
////			modelGraphs.getUndirectedPseudoGraph().getFathers());
////	paint4.start();
			

	}

	public void dijkstra(Integer k) {
		
		if (simplreDirected) {
			modelGraphs.getSimpleDirectedGraph().dijsktra(k);
			paintNodes paint = new paintNodes(dSimpleDirected.getPanelSimpleDirected().getPanelCanvas(),
					modelGraphs.getSimpleDirectedGraph().getPath(), modelGraphs.getSimpleDirectedGraph().getNodes(),
					modelGraphs.getSimpleDirectedGraph().getFathers());
			paint.start();
		}
			

		if(simpleUndirected) {
			modelGraphs.getSimpleUndirectedGraph().dijsktra(k);
			paintNodes paint2 = new paintNodes(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), modelGraphs.getSimpleUndirectedGraph().getNodes(),
					modelGraphs.getSimpleUndirectedGraph().getFathers());
			paint2.start();
			
			paintEdges paintEdges = new paintEdges(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(), modelGraphs.getSimpleUndirectedGraph().getFathers(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), simplreDirected, false);
			paintEdges.start();
			
		}
			

		if(MultiGraph) {
//			modelGraphs.getUndirectedMultigraph().dijsktra(k);
//			paint paint3 = new paint(dMultiUndirected.getPanelMultiUndirected().getPanelCanvas(),
//					modelGraphs.getUndirectedMultigraph().getPath(), modelGraphs.getUndirectedMultigraph().getNodes(),
//					modelGraphs.getUndirectedMultigraph()..getFathers());
//			paint3.start();	
		}


		if(Pseudo) {
//			modelGraphs.getUndirectedPseudoGraph().dijsktra(k);
//			paint paint4 = new paint(dPseudo.getPanelPseudo().getPanelCanvas(),
//			modelGraphs.getUndirectedPseudoGraph().getPath(), modelGraphs.getUndirectedPseudoGraph().getNodes(),
//			modelGraphs.getUndirectedPseudoGraph().getFathers());
//	paint4.start();
			
		}
			

		

	}

	public void floydWarshall() {
		if (simplreDirected) {
			modelGraphs.getSimpleDirectedGraph().floydWarshall();
			
			JDialog dialogMatrix = new JDialog(dSimpleUndirected, "Matriz de pesos");
			dialogMatrix.getContentPane().setLayout(new GridLayout(modelGraphs.getSimpleDirectedGraph().getMatrix().length, modelGraphs.getSimpleDirectedGraph().getMatrix().length));
			dialogMatrix.setSize(400, 400);
			
			JPanel panel = new JPanel();
			
			panel.setLayout(new GridLayout(modelGraphs.getSimpleDirectedGraph().getMatrix().length, modelGraphs.getSimpleDirectedGraph().getMatrix().length));
			
			for (int i = 0; i < modelGraphs.getSimpleDirectedGraph().getMatrix().length; i++) {
				for (int j = 0; j < modelGraphs.getSimpleDirectedGraph().getMatrix().length; j++) {
					
					JLabel label = new JLabel(  (int)modelGraphs.getSimpleDirectedGraph().getMatrix()[i][j].getWeightKey()  + "");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					if(modelGraphs.getSimpleDirectedGraph().getMatrix()[i][j].getWeightKey() != Double.MAX_VALUE) {
						panel.add( label);
					}else {
						
						JLabel label2 = new JLabel(" - ");
						label2.setHorizontalAlignment(SwingConstants.CENTER);
						panel.add(label2);
					}
				}
			}
			
			dialogMatrix.getContentPane().setLayout(new BorderLayout());
			dialogMatrix.getContentPane().add(panel, BorderLayout.CENTER);
			dialogMatrix.setVisible(true);
			dialogMatrix.setLocationRelativeTo(this);
			
			
		
		}
			
		if(simpleUndirected) {
			modelGraphs.getSimpleUndirectedGraph().floydWarshall();
		
			JDialog dialogMatrix = new JDialog(dSimpleUndirected, "Matriz de pesos");
			dialogMatrix.getContentPane().setLayout(new GridLayout(modelGraphs.getSimpleUndirectedGraph().getMatrix().length, modelGraphs.getSimpleUndirectedGraph().getMatrix().length));
			dialogMatrix.setSize(400, 400);
			
			JPanel panel = new JPanel();
			
			panel.setLayout(new GridLayout(modelGraphs.getSimpleUndirectedGraph().getMatrix().length, modelGraphs.getSimpleUndirectedGraph().getMatrix().length));
			
			for (int i = 0; i < modelGraphs.getSimpleUndirectedGraph().getMatrix().length; i++) {
				for (int j = 0; j < modelGraphs.getSimpleUndirectedGraph().getMatrix().length; j++) {
					
					JLabel label = new JLabel(  (int)modelGraphs.getSimpleUndirectedGraph().getMatrix()[i][j].getWeightKey()  + "");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					if(modelGraphs.getSimpleUndirectedGraph().getMatrix()[i][j].getWeightKey() != Double.MAX_VALUE) {
						panel.add( label);
					}else {
						
						JLabel label2 = new JLabel(" - ");
						label2.setHorizontalAlignment(SwingConstants.CENTER);
						panel.add(label2);
					}
				}
			}
			
			dialogMatrix.getContentPane().setLayout(new BorderLayout());
			dialogMatrix.getContentPane().add(panel, BorderLayout.CENTER);
			dialogMatrix.setVisible(true);
			dialogMatrix.setLocationRelativeTo(this);
			
			
			
		}
			
			
	}
	
	public void kruskal() {
	if (simplreDirected) {
			modelGraphs.getSimpleDirectedGraph().kruscal();
			paintNodes paint = new paintNodes(dSimpleDirected.getPanelSimpleDirected().getPanelCanvas(),
					modelGraphs.getSimpleDirectedGraph().getPath(), modelGraphs.getSimpleDirectedGraph().getNodes(),
					modelGraphs.getSimpleDirectedGraph().getFathers());
			paint.start();
			
			
			paintEdges paintEdges = new paintEdges(dSimpleDirected.getPanelSimpleDirected().getPanelCanvas(), modelGraphs.getSimpleDirectedGraph().getFathers(),
					modelGraphs.getSimpleDirectedGraph().getPath(), simplreDirected, true);
			paintEdges.start();
		}
			

		if(simpleUndirected) {
			modelGraphs.getSimpleUndirectedGraph().kruscal();
			paintNodes paint2 = new paintNodes(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), modelGraphs.getSimpleUndirectedGraph().getNodes(),
					modelGraphs.getSimpleUndirectedGraph().getFathers());
			paint2.start();
			
			paintEdges paintEdges = new paintEdges(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(), modelGraphs.getSimpleUndirectedGraph().getFathers(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), simplreDirected, true);
			paintEdges.start();
			
		}
			

		if(MultiGraph) {
//			modelGraphs.getUndirectedMultigraph().kruscal();
//			paint paint3 = new paint(dMultiUndirected.getPanelMultiUndirected().getPanelCanvas(),
//					modelGraphs.getUndirectedMultigraph().getPath(), modelGraphs.getUndirectedMultigraph().getNodes(),
//					modelGraphs.getUndirectedMultigraph()..getFathers());
//			paint3.start();	
		}


		if(Pseudo) {
//			modelGraphs.getUndirectedPseudoGraph().kruscal();
//			paint paint4 = new paint(dPseudo.getPanelPseudo().getPanelCanvas(),
//			modelGraphs.getUndirectedPseudoGraph().getPath(), modelGraphs.getUndirectedPseudoGraph().getNodes(),
//			modelGraphs.getUndirectedPseudoGraph().getFathers());
//	paint4.start();
			
		}
	}

	public void prim() {
	if (simplreDirected) {
			modelGraphs.getSimpleDirectedGraph().prim();
			paintNodes paint = new paintNodes(dSimpleDirected.getPanelSimpleDirected().getPanelCanvas(),
					modelGraphs.getSimpleDirectedGraph().getPath(), modelGraphs.getSimpleDirectedGraph().getNodes(),
					modelGraphs.getSimpleDirectedGraph().getFathers());
			paint.start();
		}
			

		if(simpleUndirected) {
			modelGraphs.getSimpleUndirectedGraph().prim();
			paintNodes paint2 = new paintNodes(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), modelGraphs.getSimpleUndirectedGraph().getNodes(),
					modelGraphs.getSimpleUndirectedGraph().getFathers());
			paint2.start();
			
			paintEdges paintEdges = new paintEdges(dSimpleUndirected.getPanelSimpleUndirectedDirected().getPanelCanvas(), modelGraphs.getSimpleUndirectedGraph().getFathers(),
					modelGraphs.getSimpleUndirectedGraph().getPath(), simplreDirected, false);
			paintEdges.start();
			
		}
			

		if(MultiGraph) {
//			modelGraphs.getUndirectedMultigraph().prim();
//			paint paint3 = new paint(dMultiUndirected.getPanelMultiUndirected().getPanelCanvas(),
//					modelGraphs.getUndirectedMultigraph().getPath(), modelGraphs.getUndirectedMultigraph().getNodes(),
//					modelGraphs.getUndirectedMultigraph()..getFathers());
//			paint3.start();	
		}


		if(Pseudo) {
//			modelGraphs.getUndirectedPseudoGraph().prim();
//			paint paint4 = new paint(dPseudo.getPanelPseudo().getPanelCanvas(),
//			modelGraphs.getUndirectedPseudoGraph().getPath(), modelGraphs.getUndirectedPseudoGraph().getNodes(),
//			modelGraphs.getUndirectedPseudoGraph().getFathers());
//	paint4.start();
			
		}

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
	}

}
