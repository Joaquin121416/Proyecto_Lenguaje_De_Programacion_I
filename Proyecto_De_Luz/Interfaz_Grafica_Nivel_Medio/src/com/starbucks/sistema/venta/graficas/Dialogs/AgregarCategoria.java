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

import com.starbucks.sistema.venta.entidades.Clases.Categoria;
import com.starbucks.sistema.venta.logica.Hilaso.HiloActualizar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCategoria;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionValidacionesSQL;
import com.starbucks.sistema.venta.logica.Patrones.Patrones;

public class AgregarCategoria extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JLabel lblImagen;
	private JButton btnAgregar;
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
			AgregarCategoria dialog = new AgregarCategoria();
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
	public AgregarCategoria() {
		setUndecorated(true);
		setBounds(100, 100, 470, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setBounds(10, 18, 97, 35);
		contentPanel.add(lblCodigo);

		lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setBounds(10, 110, 97, 35);
		contentPanel.add(lblDescripcion);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(117, 18, 142, 35);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(117, 110, 142, 35);
		txtDescripcion.setColumns(10);
		contentPanel.add(txtDescripcion);

		lblImagen = new JLabel("lblImagen");
		lblImagen.setBounds(289, 34, 160, 157);
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblImagen.setIcon(new ImageIcon(AgregarCategoria.class.getResource("/data/imgpro1.jpg")));
		contentPanel.add(lblImagen);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(113, 220, 125, 55);
		btnAgregar.addActionListener(this);
		contentPanel.add(btnAgregar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(248, 220, 125, 55);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 64, 97, 35);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(117, 64, 142, 35);
		txtNombre.setColumns(10);
		contentPanel.add(txtNombre);

		lblEstado = new JLabel("Estado : ");
		lblEstado.setBounds(10, 156, 97, 35);
		contentPanel.add(lblEstado);

		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Disponible", "No Disponible" }));
		cboEstado.setToolTipText("");
		cboEstado.setBounds(117, 156, 142, 35);
		contentPanel.add(cboEstado);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}

	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		GestionCategoria gc = new GestionCategoria();
		GestionValidacionesSQL gv = new GestionValidacionesSQL();
		// Variables
		Patrones pa = new Patrones();
		String Codigo;
		String Descripcion, Nombre;
		int Condicional;
		if (pa.ValidarCodigoCat(leerCodigo()) == 1) {
			if (gv.ValidarCodigoRepetido(leerCodigo(), "TB_Categoria", "idCat") == 1) {
				if (pa.ValidarNomGen(leerNombre()) == 1) {
					if (gv.ValidarCodigoRepetido(leerNombre(), "TB_Categoria", "nombre") == 1) {
						if (pa.ValidarDescripcion(leerDescripcion()) == 1) {
							Codigo = leerCodigo();
							Nombre = leerNombre();
							Descripcion = leerDescripcion();
							Condicional = leerCondicional();
							Categoria c = new Categoria();
							c.setIdCat(Codigo);
							c.setNombre(Nombre);
							c.setDescripcion(Descripcion);
							c.setCondicional(Condicional);

							int ok = gc.registrarCategoria(c);

							if (ok == 0) {
								JOptionPane.showMessageDialog(null,
										" No se agrego la Categoria error al Conectar a la base de Datos",
										"Imformacion", JOptionPane.INFORMATION_MESSAGE);
								
							} else {

								JOptionPane.showMessageDialog(null, "Se agrego la Categoria", "Imformacion",
										JOptionPane.INFORMATION_MESSAGE);
								Limpiar();
								HiloActualizar h = new HiloActualizar();
								h.run();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Colocar una descripcion de 5 a 500 caracteres",
									"Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "El nombre ya Existe digite otro", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Colocar un nombre de 5 a 100 caracteres", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El codigo ya Existe digite otro", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Colocar un codigo que comience con la Letra C y con 12 numeros",
					"Informacion", JOptionPane.INFORMATION_MESSAGE);
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

	private int leerCondicional() {
		int condicional = 0;
		condicional = cboEstado.getSelectedIndex();
		return condicional;
	}

	private void Limpiar() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtNombre.setText("");
		cboEstado.setSelectedIndex(0);
	}

}
