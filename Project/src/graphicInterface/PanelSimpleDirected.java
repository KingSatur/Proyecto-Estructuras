package graphicInterface;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelSimpleDirected extends JPanel {


	private JPanel panelButton = new JPanel();
	private JButton btnNewButton = new JButton("BFS");
	private JButton btnNewButton_1 = new JButton("DFS");
	JButton btnNewButton_2 = new JButton("Dijkstra");
	JButton btnNewButton_3 = new JButton("Floyd Warshall");
	JPanel panelBack = new JPanel();
	JPanel panelStructure = new JPanel();
	FlowLayout flowLayout = (FlowLayout) panelStructure.getLayout();
	JLabel lblStructure = new JLabel("Structure");
	JPanel panelGraph = new JPanel();
	JLabel lblNewLabel = new JLabel("Graph");

	public PanelSimpleDirected() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		add(panelButton, BorderLayout.NORTH);
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		
		panelButton.add(btnNewButton);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		
		panelButton.add(btnNewButton_1);
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		btnNewButton_2.setBackground(Color.WHITE);
		
		panelButton.add(btnNewButton_2);
		btnNewButton_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		btnNewButton_3.setBackground(Color.WHITE);
		
		
		panelButton.add(btnNewButton_3);
		add(panelBack, BorderLayout.CENTER);
		panelBack.setLayout(null);
		panelStructure.setBackground(Color.GRAY);
		
		panelStructure.setBounds(293, 11, 502, 415);
		panelBack.add(panelStructure);
		lblStructure.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		
		panelStructure.add(lblStructure);
		
		panelGraph.setLocation(10, 11);
		panelBack.add(panelGraph);
		panelGraph.setSize(new Dimension(273, 415));
		panelGraph.setBackground(Color.RED);
		panelGraph.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		
		panelGraph.add(lblNewLabel);

	}
}
