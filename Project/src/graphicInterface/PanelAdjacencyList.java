package graphicInterface;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdjacencyList extends JPanel {

	private Main main;
	
	public PanelAdjacencyList(Main main) {
		this.main = main;
		this.setBackground(Color.WHITE);
		this.setBounds(10, 67, 95, 183);
		this.setLayout(new GridLayout(2, 2));

	}
	
	public void makeAdjacencyList(int quantityNodes) {
//		this.setLayout(new GridLayout(quantityNodes, 2));	
//		
//		for(int i = 0; i < quantityNodes; i ++ ) {
//			for(int j = 0; j < 2; j ++) {
//				add(new JButton(""));
//			}
//		}
		add(new JButton("erwr"));
	}
	
}
