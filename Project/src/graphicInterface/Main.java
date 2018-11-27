package graphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	public Main() {

		lblGraph = new JLabel("Graph");
		btnMultiGraphUndirected = new JButton("Multigrafo no dirigido -  Lista");
		btnSimpleDirected = new JButton("Simple dirigido - Matriz");
		btnSimpleUndirected = new JButton("Simple no dirigido - Matriz");
		btnPseudoGraph = new JButton("Pseudografo - Lista");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblGraph.setBackground(Color.LIGHT_GRAY);
		lblGraph.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraph.setBounds(43, 23, 174, 34);
		contentPane.add(lblGraph);

		btnMultiGraphUndirected.setBackground(Color.WHITE);
		btnMultiGraphUndirected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMultiGraphUndirected.setBounds(43, 257, 200, 59);
		contentPane.add(btnMultiGraphUndirected);

		btnSimpleDirected.setBackground(Color.WHITE);
		btnSimpleDirected.setBounds(43, 83, 200, 59);
		contentPane.add(btnSimpleDirected);

		btnSimpleUndirected.setBackground(Color.WHITE);
		btnSimpleUndirected.setBounds(43, 172, 200, 59);
		contentPane.add(btnSimpleUndirected);

		btnPseudoGraph.setBackground(Color.WHITE);
		btnPseudoGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPseudoGraph.setBounds(43, 344, 200, 59);
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

		}
		
		if (e.getSource().equals(btnPseudoGraph)) {

		}

	}

}
