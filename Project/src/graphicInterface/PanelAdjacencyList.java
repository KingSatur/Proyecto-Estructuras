package graphicInterface;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdjacencyList extends JPanel {

	private Main main;
	private GridLayout layout;
	
	public PanelAdjacencyList(Main main) {
		this.main = main;
		this.setBackground(Color.WHITE);
		this.setBounds(10, 67, 95, 183);
		layout = new GridLayout(2,2);
		this.setLayout(layout);
		
	}

	
	public void changeColor() {
		

	}
	
}
