package GraphicalUserInterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import threads.LoadingBar;

import java.awt.Color;

public class IntroWindow extends JFrame{
	
	private LoadingBar hiloCargado;
	
	
	private JProgressBar progreso;
	
	private double contador = 1, opacidad = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IntroWindow window = new IntroWindow();
	}

	/**
	 * Create the application.
	 */
	public IntroWindow() {
		progreso = new JProgressBar();
		hiloCargado = new LoadingBar(getProgreso());
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 498);
		setSize(600, 456);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		/*
		 * Barra de carga
		 * */
		progreso.setBounds(85, 377, 419, 41);
		getContentPane().add(progreso);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,(int) opacidad));
		panel.setBounds(0, 0, 600, 456);
		getContentPane().add(panel);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./recursos/Imagenes/logo.jpg"));
		fondo.setBounds(0, 0, 600, 456);
		getContentPane().add(fondo);
		setVisible(true);
		
		hiloCargado.start();
		progreso.setVisible(false);
		progreso.addChangeListener(new ChangeListener() { //Método anonimo
			public void stateChanged(ChangeEvent event) {
				if (progreso.getValue() == contador) {
					if (progreso.getValue() <= 51) {
						panel.setBackground(new Color(0,0,0, 260 - ((int) contador * 5)));
						repaint();
						contador++;
					}
					else if (progreso.getValue() > 51 && (progreso.getValue() < 101)) {
						panel.setBackground(new Color(0,0,0, (int) (opacidad * 5)+10));
						repaint();
						opacidad++;
						contador++;
					}
				}
				if(progreso.getValue() == 100 ) {
					LoadWindow cargado = new LoadWindow();
					dispose();
				}
			}
		});	
	}

	
	public JProgressBar getProgreso() {
		return progreso;
	}

	public void setProgreso(JProgressBar progreso) {
		this.progreso = progreso;
	}
}