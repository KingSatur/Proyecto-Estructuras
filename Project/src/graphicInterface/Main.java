package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.Font;

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
	private Graphs graphs;

	public Main() {
		graphs = new Graphs();
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

	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnSimpleDirected)) {
			dSimpleDirected = new DialogSimpleDirected();
			dSimpleDirected.setVisible(true);
			dSimpleDirected.setLocationRelativeTo(this);
		}
		
		if (e.getSource().equals(btnSimpleUndirected)) {
			
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

}
