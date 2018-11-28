package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DialogMultiGraphUndirected extends JDialog {

	private PanelMultiUndirected panelMultiUndirected;
	private Main main;

	/**
	 * Create the dialog.
	 */
	public DialogMultiGraphUndirected(Main main) {
		this.main = main;
		panelMultiUndirected = new PanelMultiUndirected(main);
		getContentPane().add(panelMultiUndirected);
		setSize(815, 521);
		JLabel lblNewLabel = new JLabel("Multigrafo no dirigido");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		setResizable(false);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	
	
	

}
