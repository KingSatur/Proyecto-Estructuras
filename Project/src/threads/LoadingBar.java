/**
 * 
 */
package threads;

import javax.swing.JProgressBar;

/**
 * 
 */
public class LoadingBar extends Thread {

	private JProgressBar progreso;

	public LoadingBar(JProgressBar progreso) {
		super();
		this.progreso = progreso;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			progreso.setValue(i);
			pausa(30);
		}
	}

	public void pausa(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (Exception e) {

		}
	}
}
