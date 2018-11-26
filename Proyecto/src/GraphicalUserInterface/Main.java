package GraphicalUserInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;

public class Main implements ActionListener{

	private JFrame frame;
	private JComboBox comboBoxSimpleD;
	private JComboBox comboBoxSimpleIndirect;
	private JComboBox comboBoxMulti;
	private JComboBox comboBoxPseudo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("GRAPHS");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(371, 23, 278, 34);
		frame.getContentPane().add(lblNewLabel);
		
		comboBoxSimpleD = new JComboBox<String>();
		comboBoxSimpleD.addActionListener(this);
		comboBoxSimpleD.setBackground(Color.WHITE);
		comboBoxSimpleD.setToolTipText("Simple");
		comboBoxSimpleD.setBounds(35, 92, 138, 20);
		comboBoxSimpleD.setModel(new DefaultComboBoxModel<>(new String[] {"Adjacency Matrix", "Kruskal", "Prim", "Djikstra", "BFS", "DFS"}));
		frame.getContentPane().add(comboBoxSimpleD);
		
		comboBoxSimpleIndirect = new JComboBox();
		comboBoxSimpleIndirect.addActionListener(this);
		comboBoxSimpleIndirect.setBackground(Color.WHITE);
		comboBoxSimpleIndirect.setToolTipText("Simple");
		comboBoxSimpleIndirect.setBounds(35, 140, 138, 20);
		comboBoxSimpleIndirect.setModel(new DefaultComboBoxModel<>(new String[] {"Adjacency Matrix", "Kruskal", "Prim", "Djikstra", "BFS", "DFS"}));
		frame.getContentPane().add(comboBoxSimpleIndirect);
		
		comboBoxMulti = new JComboBox();
		comboBoxMulti.addActionListener(this);
		comboBoxMulti.setBackground(Color.WHITE);
		comboBoxMulti.setToolTipText("Simple");
		comboBoxMulti.setBounds(35, 193, 138, 20);
		comboBoxMulti.setModel(new DefaultComboBoxModel<>(new String[] {"Adjacency List", "Kruskal", "Prim", "Djikstra", "BFS", "DFS"}));
		frame.getContentPane().add(comboBoxMulti);
		
		comboBoxPseudo = new JComboBox();
		comboBoxPseudo.addActionListener(this);
		comboBoxPseudo.setBackground(Color.WHITE);
		comboBoxPseudo.setToolTipText("Simple");
		comboBoxPseudo.setBounds(35, 246, 138, 20);
		comboBoxPseudo.setModel(new DefaultComboBoxModel<>(new String[] {"Adjacency List", "Kruskal", "Prim", "Djikstra", "BFS", "DFS"}));
		frame.getContentPane().add(comboBoxPseudo);
		
		JLabel lblDirectedSimpleGraph = new JLabel("Directed Simple Graph");
		lblDirectedSimpleGraph.setBounds(35, 75, 138, 14);
		frame.getContentPane().add(lblDirectedSimpleGraph);
		
		JLabel lblIndirectedSimpleGraph = new JLabel("Indirected Simple Graph");
		lblIndirectedSimpleGraph.setBounds(35, 123, 138, 14);
		frame.getContentPane().add(lblIndirectedSimpleGraph);
		
		JLabel lblIndirectedMultigraph = new JLabel("Indirected MultiGraph");
		lblIndirectedMultigraph.setBounds(35, 178, 138, 14);
		frame.getContentPane().add(lblIndirectedMultigraph);
		
		JLabel lblIndirectedPseudograph = new JLabel("Indirected PseudoGraph");
		lblIndirectedPseudograph.setBounds(35, 232, 138, 14);
		frame.getContentPane().add(lblIndirectedPseudograph);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.LIGHT_GRAY);
		canvas.setBounds(266, 63, 478, 318);
		frame.getContentPane().add(canvas);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource().equals(comboBoxSimpleD)) {
			comboBoxSimpleIndirect.setEnabled(false);
			comboBoxMulti.setEnabled(false);
			comboBoxPseudo.setEnabled(false);
		}
		if(event.getSource().equals(comboBoxSimpleIndirect)) {
			comboBoxMulti.setEnabled(false);
			comboBoxPseudo.setEnabled(false);
			comboBoxSimpleD.setEnabled(false);
		}
		if(event.getSource().equals(comboBoxMulti)) {
			comboBoxPseudo.setEnabled(false);
			comboBoxSimpleD.setEnabled(false);
			comboBoxSimpleIndirect.setEnabled(false);
		}
		if(event.getSource().equals(comboBoxPseudo)) {
			comboBoxSimpleIndirect.setEnabled(false);
			comboBoxMulti.setEnabled(false);
			comboBoxSimpleD.setEnabled(false);
		}
		
		
		
	}
}
