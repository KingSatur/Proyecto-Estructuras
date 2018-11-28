package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DialogSimpleDirected extends JDialog {
	
	
	public final static int ANCHO = 1300;
	public final static int ALTO = 770;
	
	
	private PanelSimpleDirected panelSimpleDirected;
	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Create the dialog.
	 */
	public DialogSimpleDirected() {
		
		panelSimpleDirected = new PanelSimpleDirected();
		getContentPane().add(panelSimpleDirected);
		setSize(815, 521);
		JLabel lblNewLabel = new JLabel("Simple Dirigido");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		setResizable(false);
	
		
		
		
	}

}
