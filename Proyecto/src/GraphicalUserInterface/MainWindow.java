package GraphicalUserInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



public class MainWindow extends JFrame {
	

	public static final int ALTURA = 120;
	public static final int ANCHO = 160;
	public static final int ESCALA = 5;

	
	PanelFondo panelFondo = new PanelFondo(this);
	
	public MainWindow() {

		getContentPane().add(panelFondo, BorderLayout.CENTER);
		setMinimumSize(new Dimension(ANCHO * ESCALA, ALTURA * ESCALA));
		setMaximumSize(new Dimension(ANCHO * ESCALA, ALTURA * ESCALA));
		setPreferredSize(new Dimension(ANCHO * ESCALA, ALTURA * ESCALA));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);

	}
	
	
	public void cambiarVentana(int algoritmo, int tipoGrafo) {
		panelFondo.getPanelCanvas().cambiarVentana(algoritmo, tipoGrafo);
		
	}

	public static void main(String[] args) {
		MainWindow vP = new MainWindow();
		vP.setVisible(true);
	}
}
