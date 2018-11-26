package GraphicalUserInterface;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DfsPanel extends JPanel{

	
	JPanel panelVisitados = new JPanel();
	JPanel panlePila = new JPanel();
	JLabel lblNewLabel = new JLabel("Visitados");
	JLabel lblPila = new JLabel("Pila");
	private final JLabel lblDfs = new JLabel("DFS");

	
	public DfsPanel() {
		setLayout(null);
		
		lblNewLabel.setBounds(31, 128, 46, 14);
		panelVisitados.setBounds(31, 159, 391, 37);
		add(panelVisitados);
		panelVisitados.setLayout(new GridLayout(1, 0, 0, 0));
		
		panlePila.setBounds(31, 233, 391, 37);
		add(panlePila);
		
		add(lblNewLabel);
		
		lblPila.setBounds(31, 208, 46, 14);
		add(lblPila);
		lblDfs.setBounds(205, 11, 46, 14);
		
		add(lblDfs);
	}
}
