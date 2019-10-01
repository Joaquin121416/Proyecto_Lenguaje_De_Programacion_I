package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.starbucks.sistema.venta.entidades.Clases.Cliente;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCliente;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionValidacionesSQL;
import com.starbucks.sistema.venta.logica.Patrones.Patrones;

@SuppressWarnings("serial")
public class AgregarCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblApellidos;
	private JTextField txtCodigo;
	private JTextField txtApellidos;
	private JButton btnAgregar;
	private JButton btnSalir;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDni;
	private JTextField txtNumDoc;
	private JLabel lblTipoDoc;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipoDoc;

	private JLabel lblTipoCli;
	private JLabel lblImagen;
	private JLabel lblPuntos;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipoCli;
	private JTextField txtPuntos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			AgregarCliente dialog = new AgregarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AgregarCliente() {

		setUndecorated(true);
		setBounds(100, 100, 628, 346);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setBounds(10, 18, 140, 35);
		contentPanel.add(lblCodigo);

		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 110, 140, 35);
		contentPanel.add(lblApellidos);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(162, 18, 142, 35);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(162, 110, 142, 35);
		txtApellidos.setColumns(10);
		contentPanel.add(txtApellidos);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(464, 182, 125, 55);
		btnAgregar.addActionListener(this);
		contentPanel.add(btnAgregar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(329, 182, 125, 55);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 64, 140, 35);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(162, 64, 142, 35);
		txtNombre.setColumns(10);
		contentPanel.add(txtNombre);

		lblDni = new JLabel("Num de Documento :");
		lblDni.setBounds(10, 156, 140, 35);
		contentPanel.add(lblDni);

		txtNumDoc = new JTextField();
		txtNumDoc.setText((String) null);
		txtNumDoc.setColumns(10);
		txtNumDoc.setBounds(162, 156, 142, 35);
		contentPanel.add(txtNumDoc);

		lblTipoDoc = new JLabel("Tipo de Documento  :");
		lblTipoDoc.setBounds(10, 202, 140, 35);
		contentPanel.add(lblTipoDoc);

		cboTipoDoc = new JComboBox();
		cboTipoDoc.setModel(new DefaultComboBoxModel(new String[] { "DNI", "OTRO" }));
		cboTipoDoc.setBounds(162, 202, 142, 35);
		contentPanel.add(cboTipoDoc);

		lblTipoCli = new JLabel("Tipo de Cliente :");
		lblTipoCli.setBounds(10, 248, 140, 35);
		contentPanel.add(lblTipoCli);

		lblImagen = new JLabel("lblImagen");
		lblImagen.setIcon(new ImageIcon(AgregarCliente.class.getResource("/data/imgpro1.jpg")));
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblImagen.setBounds(379, 18, 160, 157);
		contentPanel.add(lblImagen);

		lblPuntos = new JLabel("Puntos :");
		lblPuntos.setBounds(10, 296, 140, 35);
		contentPanel.add(lblPuntos);

		cboTipoCli = new JComboBox();
		cboTipoCli.setModel(new DefaultComboBoxModel(new String[] { "Regular", "Empresarial" }));
		cboTipoCli.setBounds(162, 250, 142, 35);
		contentPanel.add(cboTipoCli);

		txtPuntos = new JTextField();
		txtPuntos.setText((String) null);
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(162, 296, 142, 35);
		contentPanel.add(txtPuntos);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}

	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {

		String Codigo;
		String Apellidos, Nombre, TipoDoc;
		int TipoCli, Dni, NumPun;

		Codigo = leerCodigo();
		Nombre = leerNombre();
		Apellidos = leerApellidos();

		TipoDoc = leerTipoDoc();
		TipoCli = leerTipoCli();

		GestionValidacionesSQL va = new GestionValidacionesSQL();
		GestionCliente gc = new GestionCliente();
		Patrones pa = new Patrones();

		if (va.ValidarCodigoRepetido(leerCodigo(), "TB_Cliente", "id_cliente") == 1) {
			if (pa.ValidarCodigoCat(leerCodigo()) == 1) {
				if (pa.ValidarNombrePersona(Nombre) == 1) {
					if (pa.ValidarNombrePersona(Apellidos) == 1) {
						Dni = leerDni();
						if (pa.ValidarNumDoc("" + Dni) == 1) {

							if (va.ValidarCodigoRepetido("" + Dni, "TB_Cliente", "nmr_Documento") == 1) {
								NumPun = leerPuntos();
								if (NumPun == -1) {

								} else {

									Cliente clie = new Cliente();
									clie.setIdCliente(Codigo);
									clie.setNombre(Nombre);
									clie.setApellido(Apellidos);
									clie.setNumDocu(Dni);
									clie.setTipoDoc(TipoDoc);
									clie.setTipoCliente(TipoCli);
									clie.setNumPunt(NumPun);
									int ok = gc.registrarCliente(clie);

									if (ok == 0) {
										JOptionPane.showMessageDialog(null, "No se pudo Agregar el Empleado");
									} else {
										JOptionPane.showMessageDialog(null, "Se agrego el Empleado con exito");
										Limpiar();

										this.dispose();
									}
								}

							} else {
								JOptionPane.showMessageDialog(null, "El dni colocado ya existe", "Informacion",
										JOptionPane.INFORMATION_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null,
									"Colocar un DNI con 8 numeros o un carnet de extranjeria con 13", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Colocar una Apellido de 5 a 100 caracteres", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Colocar un Nombre de 5 a 100 caracteres", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Colocar un codigo con la letra X y 12 numeros", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El Codigo Ingresado ya existe", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private String leerCodigo() {
		String codigo = null;
		codigo = txtCodigo.getText();
		return codigo;
	}

	private String leerNombre() {
		String nombre = null;
		nombre = txtNombre.getText();
		return nombre;
	}

	private String leerApellidos() {
		String descripcion = null;
		descripcion = txtApellidos.getText();
		return descripcion;
	}

	private int leerDni() {
		try {
			int Dni = 0;
			Dni = Integer.parseInt(txtNumDoc.getText());
			return Dni;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresa Numeros en la casilla Dni", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return -1;

	}

	private String leerTipoDoc() {

		String Item;
		Item = (String) cboTipoDoc.getSelectedItem();

		return Item;
	}

	private int leerPuntos() {
		try {
			int Pun = 0;
			Pun = Integer.parseInt(txtPuntos.getText());
			return Pun;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresa Numeros en la casilla Puntos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return -1;
	}

	private int leerTipoCli() {
		return cboTipoCli.getSelectedIndex();
	}

	public void Limpiar() {

		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtNumDoc.setText("");
		cboTipoDoc.setSelectedIndex(0);

	}
}
