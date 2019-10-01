package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.starbucks.sistema.venta.logica.Hilaso.HiloCerrar;

@SuppressWarnings("serial")
public class LoginProvisional extends JDialog implements ActionListener {
	private JLabel lblFondo;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JLabel lblTitulo;
	private JLabel lblLogin;
	public static JLabel lblConteo;
	String usuario = "T0001";
	String contrasena = "Pedro";
	private JPasswordField pwdContrasena;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginProvisional dialog = new LoginProvisional();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.getRootPane().setOpaque(false);
			dialog.setLocationRelativeTo(null);
			dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
			dialog.setBackground(new Color(0, 0, 0, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginProvisional() {
		setUndecorated(true);
		getContentPane().setBackground(Color.GRAY);
		setBounds(100, 100, 450, 416);
		getContentPane().setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(194, 117, 118, 28);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		pwdContrasena = new JPasswordField();
		pwdContrasena.setBounds(194, 156, 118, 28);
		getContentPane().add(pwdContrasena);

		lblConteo = new JLabel("20\r\n");
		lblConteo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConteo.setBounds(233, 300, 31, 21);
		getContentPane().add(lblConteo);

		lblLogin = new JLabel("El login se cerrara en :");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 12));
		lblLogin.setBounds(76, 296, 147, 28);
		getContentPane().add(lblLogin);

		lblTitulo = new JLabel("Strarbucks");
		lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 38));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(110, 53, 202, 53);
		getContentPane().add(lblTitulo);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnIngresar.setBounds(94, 218, 100, 40);
		getContentPane().add(btnIngresar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBounds(226, 218, 100, 40);
		getContentPane().add(btnSalir);

		lblContrasena = new JLabel("Contrase\u00F1a : ");
		lblContrasena.setFont(new Font("Dialog", Font.BOLD, 12));
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(94, 156, 90, 28);
		getContentPane().add(lblContrasena);

		lblUsuario = new JLabel("Usuario : ");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(94, 117, 67, 28);
		getContentPane().add(lblUsuario);

		lblFondo = new JLabel("\r\n");
		lblFondo.setBounds(0, 0, 450, 420);
		getContentPane().add(lblFondo);
		lblFondo.setIcon(new ImageIcon(LoginProvisional.class.getResource("/data/Login.jpg")));

		HiloCerrar h = new HiloCerrar(this);
		h.IniciaTiempo();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {

		dispose();
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {

		String password = new String(pwdContrasena.getPassword());

		if (txtUsuario.getText().equals(usuario) && password.equals(contrasena)) {
			// Carga c = new Carga();
			// c.setVisible(true);
			// c.setLocationRelativeTo(null);
			// c.getRootPane().setOpaque(false);
			// c.setLocationRelativeTo(null);
			// c.getContentPane().setBackground(new Color(0, 0, 0, 0));
			// c.setBackground(new Color(0, 0, 0, 0));
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Contrase�a o Usuario incorrectas", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

}
