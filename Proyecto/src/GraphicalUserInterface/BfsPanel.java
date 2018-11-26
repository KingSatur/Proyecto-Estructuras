package GraphicalUserInterface;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class BfsPanel extends JPanel{
	
	
	JPanel panelVisitados = new JPanel();
	JPanel panelCola = new JPanel();
	JLabel lblNewLabel = new JLabel("Visitados");
	JLabel lblCola = new JLabel("Cola");
	private final JLabel lblBfs = new JLabel("BFS");

	
	public BfsPanel() {
		setLayout(null);
		
		lblNewLabel.setBounds(31, 128, 46, 14);
		panelVisitados.setBounds(31, 159, 391, 37);
		add(panelVisitados);
		panelVisitados.setLayout(new GridLayout(1, 0, 0, 0));
		
		panelCola.setBounds(31, 233, 391, 37);
		add(panelCola);
		
		add(lblNewLabel);
		
		lblCola.setBounds(31, 208, 46, 14);
		add(lblCola);
		lblBfs.setBounds(217, 11, 46, 14);
		
		add(lblBfs);
	}
}
