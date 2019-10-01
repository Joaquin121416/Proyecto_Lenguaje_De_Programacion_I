package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import com.starbucks.sistema.venta.logica.Hilaso.Job;
import com.starbucks.sistema.venta.logica.Hilaso.jcThread;

@SuppressWarnings("serial")
public class Carga extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblLblimagendecarga;
	private javax.swing.JProgressBar jProgressBar1;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { Carga dialog = new
	 * Carga(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); dialog.setLocationRelativeTo(null);
	 * dialog.getRootPane().setOpaque(false);
	 * dialog.setLocationRelativeTo(null);
	 * dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
	 * dialog.setBackground(new Color(0, 0, 0, 0)); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog.
	 */
	public Carga(String Cargo,String User) {
		setUndecorated(true);

		setBounds(100, 100, 499, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setOpaque(false);

		jProgressBar1 = new JProgressBar();
		jProgressBar1.setForeground(Color.ORANGE);
		jProgressBar1.setBounds(10, 406, 473, 30);
		contentPanel.add(jProgressBar1);

		lblLblimagendecarga = new JLabel("\r\n");
		lblLblimagendecarga.setIcon(new ImageIcon(Carga.class.getResource("/data/img_cargador.png")));
		lblLblimagendecarga.setBounds(0, 0, 483, 493);
		contentPanel.add(lblLblimagendecarga);

		new Thread(new Job(Integer.valueOf(10))).start();

		new Thread(new jcThread(this.jProgressBar1, Integer.valueOf(100), this, Cargo,User)).start();
	}

}
