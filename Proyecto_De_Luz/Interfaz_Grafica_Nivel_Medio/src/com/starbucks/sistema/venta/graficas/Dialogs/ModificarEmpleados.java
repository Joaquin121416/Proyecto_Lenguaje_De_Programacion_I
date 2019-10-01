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

import com.starbucks.sistema.venta.entidades.Clases.Empleado;
import com.starbucks.sistema.venta.logica.Hilaso.HiloActualizar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionEmpleado;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionValidacionesSQL;
import com.starbucks.sistema.venta.logica.Patrones.Patrones;

@SuppressWarnings("serial")
public class ModificarEmpleados extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblApellidos;
	private JTextField txtCodigo;
	private JTextField txtApellidos;
	private JButton btnModificar;
	private JButton btnSalir;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblCargo;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCargo;
	private String dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ModificarEmpleados dialog = new ModificarEmpleados("0");
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
	public ModificarEmpleados(String codigo) {

		setUndecorated(true);
		setBounds(100, 100, 434, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setBounds(10, 18, 76, 35);
		contentPanel.add(lblCodigo);

		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 110, 76, 35);
		contentPanel.add(lblApellidos);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(96, 18, 142, 35);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(96, 110, 142, 35);
		txtApellidos.setColumns(10);
		contentPanel.add(txtApellidos);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(265, 54, 125, 55);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(265, 146, 125, 55);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 64, 76, 35);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(96, 64, 142, 35);
		txtNombre.setColumns(10);
		contentPanel.add(txtNombre);

		lblDni = new JLabel("Dni :");
		lblDni.setBounds(10, 156, 76, 35);
		contentPanel.add(lblDni);

		txtDni = new JTextField();
		txtDni.setText((String) null);
		txtDni.setColumns(10);
		txtDni.setBounds(96, 156, 142, 35);
		contentPanel.add(txtDni);

		lblCargo = new JLabel("Cargo  :");
		lblCargo.setBounds(10, 202, 76, 35);
		contentPanel.add(lblCargo);

		cboCargo = new JComboBox();
		cboCargo.setModel(new DefaultComboBoxModel(new String[] { "VENDEDOR", "ADMINISTRADOR" }));
		cboCargo.setBounds(96, 202, 142, 35);
		contentPanel.add(cboCargo);

		Listar(codigo);
		dni = txtDni.getText();
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

		// Variables

		String Codigo;
		String Apellidos, Dni, Nombre, Cargo;

		// Entrada

		Codigo = leerCodigo();
		Nombre = leerNombre();
		Apellidos = leerApellidos();
		Dni = leerDni();
		Cargo = leerCargo();
		GestionValidacionesSQL va = new GestionValidacionesSQL();
		GestionEmpleado ge = new GestionEmpleado();
		Patrones pa = new Patrones();

		if (pa.ValidarNombrePersona(Nombre) == 1) {
			if (pa.ValidarNombrePersona(Apellidos) == 1) {
				if (pa.ValidarDni(Dni) == 1) {
					if (dni.equals(leerDni()) || va.ValidarCodigoRepetido(Dni, "TB_Empleado", "dni") == 1) {
						int ok = ge.actualizar(Codigo, Nombre, Apellidos, Dni, Cargo);

						if (ok == 0) {
							JOptionPane.showMessageDialog(null, "No se Modifico pudo Modificar el Empleado");
						} else {
							JOptionPane.showMessageDialog(null, "Se Modifico el Empleado con exito");
							Limpiar();
							HiloActualizar h = new HiloActualizar();
							h.run(2);

							this.dispose();
						}

					} else {
						JOptionPane.showMessageDialog(null, "El dni colocado ya existe", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Colocar un DNI con 8 numeros", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Colocar una Apellido de 5 a 100 caracteres", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Colocar un nombre de 5 a 100 caracteres", "Informacion",
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

	private String leerDni() {
		String Dni = null;
		Dni = txtDni.getText();
		return Dni;

	}

	private String leerCargo() {

		String Item;
		Item = (String) cboCargo.getSelectedItem();

		return Item;
	}

	public void Limpiar() {

		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		cboCargo.setSelectedIndex(0);

	}

	public void Listar(String codigo) {

		txtCodigo.setText("" + codigo);
		GestionEmpleado gc = new GestionEmpleado();

		Empleado emp = gc.listarTodoporCodigo(codigo);

		try {
			txtNombre.setText(emp.getNombre());
			txtApellidos.setText(emp.getApellidos());
			txtDni.setText(emp.getDni());
			cboCargo.setSelectedItem(emp.getCargo());

		} catch (IndexOutOfBoundsException e) {

			JOptionPane.showMessageDialog(null,
					"Debiste cambair la posicion de la tabla cierra la pestaña y vuelve a abrir", "Error",
					JOptionPane.ERROR_MESSAGE);

			this.dispose();
		}

	}
}
