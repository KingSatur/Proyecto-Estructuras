package GraphicalUserInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class KruskalPanel extends JPanel{
	public KruskalPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 164, 387, 38);
		add(panel);
		
		JLabel lblColaDePrioridad = new JLabel("Cola de Prioridad");
		lblColaDePrioridad.setBounds(29, 129, 88, 14);
		add(lblColaDePrioridad);
		
		JLabel lblConjuntos = new JLabel("Conjuntos");
		lblConjuntos.setBounds(29, 213, 88, 14);
		add(lblConjuntos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 238, 387, 38);
		add(panel_1);
		
		JLabel lblKruskal = new JLabel("KRUSKAL");
		lblKruskal.setBounds(202, 11, 46, 14);
		add(lblKruskal);
	}

}
