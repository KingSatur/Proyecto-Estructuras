package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;

public class PanelFondo extends JPanel {

	JLabel lblBanner = new JLabel("New label");

	ButtonPanel panelBotones;
	CanvasPanel panelCanvas ;
	MainWindow main;
	
	
	
	public PanelFondo(MainWindow main) {
		
		this.main = main;
		panelCanvas = new CanvasPanel();
		panelCanvas.setBounds(192, 77, 385, 287);
		setLayout(null);
		panelBotones = new ButtonPanel(main);
		panelBotones.setBounds(10, 77, 172, 287);

		
		this.add(panelBotones);
		this.add(panelCanvas);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 537, 66);
		add(lblNewLabel);
		
//		panelBotones.setLayout(gl_panelBotones);
//		this.setLayout(gl_panelFondo);
	}
	
	

	public ButtonPanel getPanelBotones() {
		return panelBotones;
	}



	public CanvasPanel getPanelCanvas() {
		return panelCanvas;
	}



	/**
	 * Metodo : paintComponent
	 * 
	 * @param grafico
	 *            : Graphics
	 */
	public void paintComponent(Graphics grafico) {

		Dimension height = getSize();
		super.paintComponent(grafico);
		ImageIcon Img = new ImageIcon("./recursos/Imagenes/Intro destroyer 2.png");// Pintar el fondo del inicio.
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
	}
}
