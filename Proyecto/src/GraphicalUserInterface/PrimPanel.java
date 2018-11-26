package GraphicalUserInterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class PrimPanel extends JPanel{
	public PrimPanel() {
		setLayout(null);
		
		JLabel lblColaDePrioridad = new JLabel("Cola de prioridad");
		lblColaDePrioridad.setBounds(32, 164, 101, 14);
		add(lblColaDePrioridad);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 189, 389, 36);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblVisitados = new JLabel("Visitados");
		lblVisitados.setBounds(32, 236, 46, 14);
		add(lblVisitados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 253, 389, 36);
		add(panel_1);
		
		JLabel lblPrim = new JLabel("PRIM");
		lblPrim.setBounds(211, 11, 46, 14);
		add(lblPrim);
	}

	
	
}
