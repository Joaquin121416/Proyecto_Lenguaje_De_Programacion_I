package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.starbucks.sistema.venta.entidades.Clases.Cliente;
import com.starbucks.sistema.venta.logica.Hilaso.HiloActualizar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCliente;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionValidacionesSQL;
import com.starbucks.sistema.venta.logica.Patrones.Patrones;

@SuppressWarnings("serial")
public class ModificarCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnModificar;
	private JButton btnSalir;

	private JTextField txtNumPun;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipCli;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipDoc;
	private JTextField txtNumDoc;
	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField txtCodigo;
	private int numDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ModificarCliente dialog = new ModificarCliente("0");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModificarCliente(String codigo) {

		setUndecorated(true);
		setBounds(100, 100, 480, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(340, 11, 125, 55);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(340, 103, 125, 55);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);

		txtNumPun = new JTextField();
		txtNumPun.setText((String) null);
		txtNumPun.setColumns(10);
		txtNumPun.setBounds(162, 289, 142, 35);
		contentPanel.add(txtNumPun);

		cboTipCli = new JComboBox();
		cboTipCli.setBounds(162, 243, 142, 35);
		contentPanel.add(cboTipCli);

		cboTipDoc = new JComboBox();
		cboTipDoc.setModel(new DefaultComboBoxModel(new String[] { "DNI", "OTROS" }));
		cboTipDoc.setBounds(162, 195, 142, 35);
		contentPanel.add(cboTipDoc);

		txtNumDoc = new JTextField();
		txtNumDoc.setText((String) null);
		txtNumDoc.setColumns(10);
		txtNumDoc.setBounds(162, 149, 142, 35);
		contentPanel.add(txtNumDoc);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(162, 103, 142, 35);
		contentPanel.add(txtApellidos);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(162, 57, 142, 35);
		contentPanel.add(txtNombre);

		label = new JLabel("Nombre : ");
		label.setBounds(10, 57, 140, 35);
		contentPanel.add(label);

		label_1 = new JLabel("Apellidos :");
		label_1.setBounds(10, 103, 140, 35);
		contentPanel.add(label_1);

		label_2 = new JLabel("Num de Documento :");
		label_2.setBounds(10, 149, 140, 35);
		contentPanel.add(label_2);

		label_3 = new JLabel("Tipo de Documento  :");
		label_3.setBounds(10, 195, 140, 35);
		contentPanel.add(label_3);

		label_4 = new JLabel("Tipo de Cliente :");
		label_4.setBounds(10, 241, 140, 35);
		contentPanel.add(label_4);

		label_5 = new JLabel("Puntos :");
		label_5.setBounds(10, 289, 140, 35);
		contentPanel.add(label_5);

		label_6 = new JLabel("Codigo : ");
		label_6.setBounds(10, 11, 140, 35);
		contentPanel.add(label_6);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(162, 11, 142, 35);
		contentPanel.add(txtCodigo);

		Listar(codigo);
		try {
			numDni = Integer.parseInt(txtNumDoc.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
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

		if (pa.ValidarCodigoCat(leerCodigo()) == 1) {
			if (pa.ValidarNombrePersona(Nombre) == 1) {
				if (pa.ValidarNombrePersona(Apellidos) == 1) {
					Dni = leerDni();
					if (pa.ValidarNumDoc("" + Dni) == 1) {

						if (numDni == leerDni()
								|| va.ValidarCodigoRepetido("" + Dni, "TB_Cliente", "nmr_Documento") == 1) {
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
								int ok = gc.actualizar(clie.getIdCliente(), clie.getNombre(), clie.getApellido(),
										clie.getNumDocu(), clie.getTipoDoc(), clie.getTipoCliente(), clie.getNumPunt());

								if (ok == 0) {
									JOptionPane.showMessageDialog(null, "No se pudo Modificar el Cliente");
								} else {
									JOptionPane.showMessageDialog(null, "Se modifico el Cliente con exito");
									Limpiar();
									HiloActualizar h = new HiloActualizar();
									h.run(3);
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
		Item = (String) cboTipDoc.getSelectedItem();

		return Item;
	}

	private int leerPuntos() {
		try {
			int Pun = 0;
			Pun = Integer.parseInt(txtNumPun.getText());
			return Pun;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresa Numeros en la casilla Puntos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return -1;
	}

	private int leerTipoCli() {
		return cboTipCli.getSelectedIndex();
	}

	public void Limpiar() {

		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtNumDoc.setText("");
		cboTipDoc.setSelectedIndex(0);

	}

	@SuppressWarnings("unchecked")
	public void Listar(String codigo) {
		GestionCliente gc = new GestionCliente();

		Cliente cli = gc.listarTodo(codigo);

		try {
			txtCodigo.setText(codigo);
			txtNombre.setText(cli.getNombre());
			txtApellidos.setText(cli.getApellido());
			txtNumDoc.setText("" + cli.getNumDocu());
			cboTipDoc.setSelectedItem(cli.getTipoDoc());
			cboTipCli.setModel(new DefaultComboBoxModel(new String[] { "Comun", "Empresarial" }));
			cboTipCli.setSelectedIndex(cli.getTipoCliente());
			txtNumPun.setText(cli.getNumPunt() + "");

		} catch (IndexOutOfBoundsException e) {

			JOptionPane.showMessageDialog(null,
					"Debiste cambair la posicion de la tabla cierra la pestaña y vuelve a abrir", "Error",
					JOptionPane.ERROR_MESSAGE);

			this.dispose();

		}
	}
}
