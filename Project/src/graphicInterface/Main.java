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

public class Main extends JFrame {

	
	private DialogSimpleDirected dSimpleDirected;
	private DialogSimpleUndirected dSimpleUndirected;
	private DialogMultiGraphUndirected dMultiUndirected;
	private DialogPseudo dPseudo;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGraph = new JLabel("Graph");
		lblGraph.setBackground(Color.LIGHT_GRAY);
		lblGraph.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraph.setBounds(43, 23, 174, 34);
		contentPane.add(lblGraph);
		
		JButton btnMultiGraphUndirected = new JButton("Multigrafo no dirigido -  Lista");
		btnMultiGraphUndirected.setBackground(Color.WHITE);
		btnMultiGraphUndirected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMultiGraphUndirected.setBounds(43, 257, 200, 59);
		contentPane.add(btnMultiGraphUndirected);
		
		JButton btnSimpleDirected = new JButton("Simple dirigido - Matriz");
		btnSimpleDirected.setBackground(Color.WHITE);
		btnSimpleDirected.setBounds(43, 83, 200, 59);
		contentPane.add(btnSimpleDirected);
		
		JButton btnSimpleUndirected = new JButton("Simple no dirigido - Matriz");
		btnSimpleUndirected.setBackground(Color.WHITE);
		btnSimpleUndirected.setBounds(43, 172, 200, 59);
		contentPane.add(btnSimpleUndirected);
		
		JButton btnPseudoGraph = new JButton("Pseudografo - Lista");
		btnPseudoGraph.setBackground(Color.WHITE);
		btnPseudoGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPseudoGraph.setBounds(43, 344, 200, 59);
		contentPane.add(btnPseudoGraph);
	}
}
