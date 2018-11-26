package GraphicalUserInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class FloydPanel extends JPanel{
	public FloydPanel() {
		setLayout(null);
		
		JPanel panelMatrix = new JPanel();
		panelMatrix.setBounds(23, 89, 200, 200);
		add(panelMatrix);
		panelMatrix.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblMatrizDePesos = new JLabel("Matriz de pesos");
		lblMatrizDePesos.setBounds(23, 52, 84, 14);
		add(lblMatrizDePesos);
		
		JLabel lblFloyd = new JLabel("FLOYD");
		lblFloyd.setBounds(209, 11, 46, 14);
		add(lblFloyd);
	}

}
