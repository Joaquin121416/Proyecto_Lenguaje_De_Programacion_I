package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.starbucks.sistema.venta.logica.Mantenimiento.GestionIngresar;

import AppPackage.AnimationClass;

public class yFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario;
	private JTextField txtUser;
	private JPasswordField pwdContrasea;
	private Button button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yFrame frame = new yFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public yFrame() {
		getContentPane().setBackground(Color.LIGHT_GRAY);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 621);
		setUndecorated(true);
		setVisible(true);
		getContentPane().setLayout(null);

		button = new Button("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionIngresar gi = new GestionIngresar();
				try {
					String User = txtUser.getText();
					@SuppressWarnings("deprecation")
					String Contrasea = pwdContrasea.getText();
					if (gi.Ingresar(User, Contrasea) == 1) {
						String Cargo = gi.Ingresa(User);
						Carga c = new Carga(Cargo,User);
						c.setVisible(true);
						c.setLocationRelativeTo(null);
						c.getRootPane().setOpaque(false);
						c.setLocationRelativeTo(null);
						c.getContentPane().setBackground(new Color(0, 0, 0, 0));
						c.setBackground(new Color(0, 0, 0, 0));
						Cerrar();
					} else {
						JOptionPane.showMessageDialog(null, "El Usuario o Contrase�a son incorrectos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "El Usuario o Contrase�a son incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		button.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 28));
		button.setActionCommand("Ingresar");
		button.setBounds(593, 51, 201, 107);
		getContentPane().add(button);

		pwdContrasea = new JPasswordField();
		pwdContrasea.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pwdContrasea.setBounds(325, 110, 144, 48);
		getContentPane().add(pwdContrasea);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtUser.setBounds(325, 51, 144, 48);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a   : ");
		lblContrasea.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC, 16));
		lblContrasea.setBounds(161, 110, 154, 48);
		getContentPane().add(lblContrasea);

		lblUsuario = new JLabel("Usuario           : ");
		lblUsuario.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC, 16));
		lblUsuario.setBounds(161, 51, 154, 48);
		getContentPane().add(lblUsuario);

		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/NEXT.png")));
		btnAtras.setBounds(38, 566, 89, 23);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorder(null);
		btnAtras.setFocusPainted(false);
		getContentPane().add(btnAtras);

		JButton btnAdelante = new JButton("");
		btnAdelante.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/BACK.png")));
		btnAdelante.setBounds(864, 566, 78, 23);
		getContentPane().add(btnAdelante);
		btnAdelante.setContentAreaFilled(false);
		btnAdelante.setFocusPainted(false);
		btnAdelante.setBorder(null);

		JLabel lbl_Fondo1 = new JLabel("");
		lbl_Fondo1.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/fondo1.jpg")));
		lbl_Fondo1.setBounds(0, 195, 1000, 347);
		getContentPane().add(lbl_Fondo1);

		JLabel lbl_Fondo2 = new JLabel("");
		lbl_Fondo2.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/locot.png")));
		lbl_Fondo2.setBounds(1000, 195, 1000, 347);
		getContentPane().add(lbl_Fondo2);

		JLabel lbl_Linea2 = new JLabel("");
		lbl_Linea2.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/paloPublic.png")));
		lbl_Linea2.setBounds(0, 542, 1000, 4);
		getContentPane().add(lbl_Linea2);

		JLabel lbl_Linea1 = new JLabel("");
		lbl_Linea1.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/paloPublic.png")));
		lbl_Linea1.setBounds(0, 187, 1000, 14);
		getContentPane().add(lbl_Linea1);

		JLabel lbl_X = new JLabel("");
		lbl_X.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/icons8_Delete_32px.png")));
		lbl_X.setBounds(962, 11, 38, 38);
		getContentPane().add(lbl_X);

		JLabel lbl_V = new JLabel("");
		lbl_V.setBounds(914, 11, 38, 38);
		lbl_V.setForeground(Color.BLACK);
		lbl_V.setIcon(new ImageIcon(yFrame.class.getResource("/imagen/icons8_Expand_Arrow_32px.png")));
		getContentPane().add(lbl_V);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(Color.LIGHT_GRAY);
		lblFondo.setForeground(Color.LIGHT_GRAY);
		lblFondo.setBounds(0, 0, 1000, 500);
		getContentPane().add(lblFondo);

		// Botones

		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AnimationClass an = new AnimationClass();
				an.jLabelXRight(-1000, 0, 25, 5, lbl_Fondo1);

				an.jLabelXRight(0, 1000, 25, 5, lbl_Fondo2);

			}

		});
		btnAdelante.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				AnimationClass an = new AnimationClass();
				an.jLabelXLeft(0, -1000, 25, 5, lbl_Fondo1);

				an.jLabelXLeft(1000, 0, 25, 5, lbl_Fondo2);

			}

		});
		// Ventana
		addWindowListener(new WindowAdapter() {

			public void windowOpened(WindowEvent arg0) {
				AnimationClass an = new AnimationClass();
				an.jLabelXLeft(0, -1000, 25, 5, lbl_Fondo1);

				an.jLabelXLeft(1000, 0, 25, 5, lbl_Fondo2);
			}
		});
		// Boton "X"
		lbl_X.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				try {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int result = JOptionPane.showConfirmDialog(null, "Desea cerrar el Sistema", "EXIT", dialogButton);
					if (result == 0) {
						System.exit(0);
					}

				} catch (Exception e) {
					JOptionPane.showInputDialog(e, this);
				}

			}
		});
		// Boton V
		lbl_V.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Minimizar();

			}

		});

	}

	private void Minimizar() {
		this.setState(1);
	}

	private void Cerrar() {
		this.dispose();
	}
}
