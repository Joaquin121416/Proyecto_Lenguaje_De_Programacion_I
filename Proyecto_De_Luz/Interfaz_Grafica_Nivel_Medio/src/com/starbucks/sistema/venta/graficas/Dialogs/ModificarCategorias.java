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

import com.starbucks.sistema.venta.entidades.Clases.Categoria;
import com.starbucks.sistema.venta.logica.Hilaso.HiloActualizar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCategoria;
import com.starbucks.sistema.venta.logica.Patrones.Patrones;

@SuppressWarnings("serial")
public class ModificarCategorias extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JButton btnModificar;
	private JButton btnSalir;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblEstado;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ModificarCategorias dialog = new ModificarCategorias("0");
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
	public ModificarCategorias(String codigo) {

		setUndecorated(true);
		setBounds(100, 100, 434, 236);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setBounds(10, 18, 76, 35);
		contentPanel.add(lblCodigo);

		lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setBounds(10, 110, 76, 35);
		contentPanel.add(lblDescripcion);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(96, 18, 142, 35);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(96, 110, 142, 35);
		txtDescripcion.setColumns(10);
		contentPanel.add(txtDescripcion);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(265, 28, 125, 55);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(265, 124, 125, 55);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 64, 76, 35);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(96, 64, 142, 35);
		txtNombre.setColumns(10);
		contentPanel.add(txtNombre);

		lblEstado = new JLabel("Estado : ");
		lblEstado.setBounds(10, 156, 76, 35);
		contentPanel.add(lblEstado);

		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Disponible", "No Disponible" }));
		cboEstado.setToolTipText("");
		cboEstado.setBounds(96, 156, 142, 35);
		contentPanel.add(cboEstado);

		Listar(codigo);
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
		String Descripcion, Nombre;
		int Estado;

		// Entrada

		Codigo = leerCodigo();
		Nombre = leerNombre();
		Descripcion = leerDescripcion();
		Estado = leerEstado();

		GestionCategoria gc = new GestionCategoria();
		Patrones pa = new Patrones();
		if (pa.ValidarCodigoCat(Codigo) == 1) {
			if (pa.ValidarNomGen(Nombre) == 1) {
				if (pa.ValidarDescripcion(Descripcion) == 1) {

					int ok = gc.actualizar(Codigo, Nombre, Descripcion, Estado);

					if (ok == 0) {

						JOptionPane.showMessageDialog(null, "No se Modifico pudo Modificar el producto");
					} else {
						JOptionPane.showMessageDialog(null, "Se Modifico el producto con exito");
						Limpiar();
						HiloActualizar h = new HiloActualizar();
						h.run(0);

						this.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Colocar una descripcion de 5 a 500 caracteres", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Colocar un nombre de 5 a 100 caracteres", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {

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

	private String leerDescripcion() {
		String descripcion = null;
		descripcion = txtDescripcion.getText();
		return descripcion;
	}

	private int leerEstado() {

		int Index;
		Index = cboEstado.getSelectedIndex();

		return Index;
	}

	public void Limpiar() {

		txtCodigo.setText("");
		txtNombre.setText("");
		txtDescripcion.setText("");
		cboEstado.setSelectedIndex(0);

	}

	public void Listar(String codigo) {

		txtCodigo.setText("" + codigo);
		GestionCategoria gc = new GestionCategoria();

		Categoria cat = gc.listarTodoPorCodigo(codigo);

		try {
			txtNombre.setText(cat.getNombre());
			txtDescripcion.setText(cat.getDescripcion());
			cboEstado.setSelectedIndex(cat.getCondicional());
		} catch (IndexOutOfBoundsException e) {

			JOptionPane.showMessageDialog(null,
					"Debiste cambair la posicion de la tabla cierra la pestaña y vuelve a abrir", "Error",
					JOptionPane.ERROR_MESSAGE);

			this.dispose();
		}

	}

}
