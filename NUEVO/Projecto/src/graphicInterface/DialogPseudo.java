package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DialogPseudo extends JDialog {

	private PanelPseudo panelPseudo;
	private Main main;

	/**
	 * Create the dialog.
	 */
	public DialogPseudo(Main main) {
		this.main = main;
		panelPseudo = new PanelPseudo(main);
		getContentPane().add(panelPseudo);
		this.setSize(815, 521);
		JLabel lblNewLabel = new JLabel("Pseudografo no dirigido");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		this.setResizable(false);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	
	
}