package com.starbucks.sistema.venta.logica.Hilaso;

import javax.swing.JDialog;

import com.starbucks.sistema.venta.graficas.Dialogs.LoginProvisional;

public class HiloCerrar extends Thread {

	private JDialog ventana;

	public HiloCerrar(JDialog ventana) {
		this.ventana = ventana;
	}

	public void run() {
		for (int i = 20; i >= 0; i--) {
			LoginProvisional.lblConteo.setText(i + "s");

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		ventana.dispose();
	}

	public void IniciaTiempo() {
		HiloCerrar hilo = new HiloCerrar(ventana);

		hilo.start();
	}

}
