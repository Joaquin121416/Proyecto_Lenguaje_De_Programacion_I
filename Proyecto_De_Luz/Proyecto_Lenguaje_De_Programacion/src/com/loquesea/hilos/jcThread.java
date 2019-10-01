package com.loquesea.hilos;

import javax.swing.JDialog;
import javax.swing.JProgressBar;

import com.loquesea.frames.Main;

/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class jcThread implements Runnable {

	private JProgressBar jProgressBar;
	private int i = 1;
	private int value = 50;// retardo en milisegundos
	private JDialog frame;
	private String Cargo;
	Thread h1;
	private String User;

	/**
	 * Constructor de clase
	 */
	public jcThread(JProgressBar jProgressBar, int value, JDialog frame, String Cargo,String User) {
		this.jProgressBar = jProgressBar;
		this.value = value;
		this.frame = frame;
		this.Cargo = Cargo;
		this.User=User;
	}

	@Override
	public void run() {

		i = 1;
		// mientra el trabajo en paralelo no finalice el jProgressBar continuara
		// su animacion una y otra vez
		while (!Job.band) {
			// si llega al limite 100 comienza otra vez desde 1, sino incrementa
			// i en +1
			i = (i > 100) ? 1 : i + 1;
			jProgressBar.setValue(i);
			jProgressBar.repaint();
			// retardo en milisegundos
			try {
				Thread.sleep(this.value);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			// si el trabajo en paralelo a terminado
			if (Job.band) {

				Main m = new Main();
				m.Abrir(Cargo,User);
				jProgressBar.setValue(100);
				System.out.println("Trabajo finalizado...");
				frame.dispose();

				break;// rompe ciclo
			}
		}
	}

}
