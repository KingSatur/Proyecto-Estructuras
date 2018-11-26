package GraphicalUserInterface;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DijkstraPanel extends JPanel{

	
	JPanel panelVisitados = new JPanel();
	JPanel panelColaPrioridad = new JPanel();
	JLabel lblNewLabel = new JLabel("Visitados");
	JLabel lblCola = new JLabel("Cola de Priotidad");
	private final JLabel lblDikstra = new JLabel("DIKSTRA");

	
	public DijkstraPanel() {
		setLayout(null);
		
		lblNewLabel.setBounds(31, 128, 46, 14);
		panelVisitados.setBounds(31, 159, 391, 37);
		add(panelVisitados);
		panelVisitados.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelColaPrioridad.setBounds(31, 233, 391, 37);
		add(panelColaPrioridad);
		
		add(lblNewLabel);
		
		lblCola.setBounds(31, 208, 46, 14);
		add(lblCola);
		lblDikstra.setBounds(205, 11, 46, 14);
		
		add(lblDikstra);
	}
}
