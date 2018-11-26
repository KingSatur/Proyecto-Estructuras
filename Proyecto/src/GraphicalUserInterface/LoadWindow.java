package GraphicalUserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;



import javax.swing.event.ChangeEvent;

import threads.LoadingBar;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoadWindow extends JFrame{
	
	private LoadingBar hilo;
	
	private JProgressBar progreso;
	
	private double mitad = 70, opacidad = 1;
	
	private JLabel cargando;
	
	private JLabel cantidadCargada;
	
	private MainWindow principal;
	
	private String mensajeCargando = "Cargando";
	
	
	/**
	 * Método constructor
	 */
	public LoadWindow() {
		progreso = new JProgressBar();
		hilo = new LoadingBar(getProgreso());
		
		/**
		 * Caracteristicas de la ventana
		 */
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(600,456);
		setUndecorated(true);

		/*
		 * Barra de carga
		 * */
		
		cantidadCargada = new JLabel("");
		cantidadCargada.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadCargada.setBounds(85, 377, 420, 41);
		getContentPane().add(cantidadCargada);
		
		cargando = new JLabel(mensajeCargando);
		cargando.setBounds(267, 355, 87, 16);
		getContentPane().add(cargando);
		progreso.setBounds(85, 377, 420, 41);
		getContentPane().add(progreso);
		
		/**
		 * Fondo
		 */
		
		JLabel fondoIntro = new JLabel("");
		fondoIntro.setBackground(Color.WHITE);
		fondoIntro.setIcon(new ImageIcon("./recursos/Imagenes/Intro.jpg"));
		fondoIntro.setBounds(0, 0, 600, 456);
		getContentPane().add(fondoIntro);
		setLocationRelativeTo(null); //La ventana saldrá centrada al momento de abrirse
		
		
		setVisible(true);
		/*
		 * Método que permite la ejecución 
		 * */
		hilo.start();
		
		progreso.addChangeListener(new ChangeListener() { //Método anonimo
			public void stateChanged(ChangeEvent event) {
				if (progreso.getValue()%5 == 0) {
					mensajeCargando += " .";
					cantidadCargada.setText(""+progreso.getValue()+"%");
					cargando.setText(mensajeCargando);
				}
				if (progreso.getValue() == mitad) {
					if (opacidad != 101) {
						setOpacity((float) (100-opacidad)/100);
						mitad++;
						opacidad +=2;
					}
				}
				if(progreso.getValue() == 100) {
					principal = new MainWindow();
					dispose();
				}
				if (mensajeCargando.equals("Cargando . . .")) {
					mensajeCargando = "Cargando";
				}
				repaint();
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
