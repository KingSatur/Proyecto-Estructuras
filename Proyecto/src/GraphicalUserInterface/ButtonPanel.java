package GraphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ButtonPanel extends JPanel implements ActionListener {

	public static final int MULTI_DIRIGIDO = 1;
	public static final int MULTI_NO_DIRIGIDO = 2;
	public static final int SIMPLE_DIRIGIDO = 3;
	public static final int SIMPLE_NO_DIRIGIDO = 4;

	MainWindow main;
	JLabel lblMatrixAdjacency = new JLabel("Matriz de Adyacencia");
	JLabel lblSimpleDirigido = new JLabel("Simple Dirigido");
	JComboBox comboBoxSimpleDirigido = new JComboBox();
	JLabel lblNewLabel = new JLabel("Simple No dirigido");
	JComboBox comboBoxSimpleNoDirigido = new JComboBox();
	JLabel lblLsitaDeAdyacencia = new JLabel("Lista de Adyacencia");
	JLabel lblMultigrafoDirigido = new JLabel("Multigrafo Dirigido");
	JComboBox comboBoxMultiDirigido = new JComboBox();
	JLabel lblMultigrafoNoDirigido = new JLabel("Multigrafo no Dirigido");
	JComboBox comboBoxMultiNoDirigido = new JComboBox();

	public ButtonPanel(MainWindow main) {
		super();
		this.main = main;

		lblMatrixAdjacency.setBounds(10, 11, 102, 14);

		lblSimpleDirigido.setBounds(54, 36, 95, 14);

		comboBoxSimpleDirigido.setBounds(54, 55, 95, 20);
		comboBoxSimpleDirigido
				.setModel(new DefaultComboBoxModel(new String[] { "Bfs", "Dfs", "Dijkstra", "Floyd Warshall" }));

		lblNewLabel.setBounds(54, 86, 83, 14);

		comboBoxSimpleNoDirigido.setBounds(54, 111, 95, 20);
		comboBoxSimpleNoDirigido.setModel(new DefaultComboBoxModel(
				new String[] { "Bfs", "Dfs", "Dijkstra", "Floyd Warshall", "Kruskal", "Prim" }));

		lblLsitaDeAdyacencia.setBounds(10, 142, 95, 14);

		lblMultigrafoDirigido.setBounds(50, 167, 99, 14);

		comboBoxMultiDirigido.setBounds(54, 192, 95, 20);
		comboBoxMultiDirigido.setModel(
				new DefaultComboBoxModel(new String[] { "Bfs", "Dfs", "Dijkstra", "Floyd Warshall", "", "" }));

		lblMultigrafoNoDirigido.setBounds(54, 223, 101, 14);

		comboBoxMultiNoDirigido.setBounds(54, 248, 95, 20);
		comboBoxMultiNoDirigido.setModel(new DefaultComboBoxModel(
				new String[] { "Bfs", "Dfs", "Dijkstra", "Floyd Warshall", "Kruskal", "Prim" }));
		setLayout(null);

		comboBoxMultiDirigido.addActionListener(this);
		comboBoxMultiNoDirigido.addActionListener(this);
		comboBoxSimpleDirigido.addActionListener(this);
		comboBoxSimpleNoDirigido.addActionListener(this);

		add(lblLsitaDeAdyacencia);
		add(lblMatrixAdjacency);
		add(comboBoxMultiNoDirigido);
		add(lblMultigrafoNoDirigido);
		add(comboBoxMultiDirigido);
		add(lblNewLabel);
		add(comboBoxSimpleDirigido);
		add(lblSimpleDirigido);
		add(comboBoxSimpleNoDirigido);
		add(lblMultigrafoDirigido);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource().equals(comboBoxMultiDirigido)) {
			main.cambiarVentana(comboBoxMultiDirigido.getSelectedIndex(), MULTI_DIRIGIDO);
		}
		if (event.getSource().equals(comboBoxMultiNoDirigido)) {
			main.cambiarVentana(comboBoxMultiNoDirigido.getSelectedIndex(), MULTI_NO_DIRIGIDO);
		}
		if (event.getSource().equals(comboBoxSimpleDirigido)) {
			main.cambiarVentana(comboBoxSimpleDirigido.getSelectedIndex(), SIMPLE_DIRIGIDO);
		}
		if (event.getSource().equals(comboBoxSimpleNoDirigido)) {
			main.cambiarVentana(comboBoxSimpleNoDirigido.getSelectedIndex(), SIMPLE_NO_DIRIGIDO);
		}

	}
	
}