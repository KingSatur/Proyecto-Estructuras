package graphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelStructures extends JPanel{

	private JLabel labelStructures;
	
	public PanelStructures() {
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBounds(293, 11, 502, 415);
		labelStructures = new JLabel("Graph");
		labelStructures.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		this.add(labelStructures);		
	}
	
//	public void paintComponent(Graphics g) {
//		
//	}
	
	
	
}
