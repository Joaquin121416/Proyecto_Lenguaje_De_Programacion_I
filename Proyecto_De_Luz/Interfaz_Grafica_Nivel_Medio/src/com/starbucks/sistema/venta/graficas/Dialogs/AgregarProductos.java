package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.starbucks.sistema.venta.entidades.Clases.Categoria;
import com.starbucks.sistema.venta.entidades.Clases.Producto;
import com.starbucks.sistema.venta.logica.Hilaso.HiloActualizar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCategoria;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionProducto;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionValidacionesSQL;
import com.starbucks.sistema.venta.logica.Patrones.Patrones;

@SuppressWarnings("serial")
public class AgregarProductos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JLabel lblPrecioCompra;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtPrecioCompra;
	private JLabel lblImagen;
	private JButton btnAgregar;
	private JButton btnSalir;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblCategoria;
	private JLabel lblPathImg;
	private JLabel lblEstado;
	private JTextField txtPrecioVenta;
	private JLabel lblPrecioVenta;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCategoria;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEstado;
	private JTextField txtPath;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarProductos dialog = new AgregarProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AgregarProductos() {
		setUndecorated(true);
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnBuscar = new JButton(">\r\n");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(200, 202, 41, 35);
		contentPanel.add(btnBuscar);

		lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setBounds(10, 18, 76, 35);
		contentPanel.add(lblCodigo);

		lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setBounds(10, 110, 76, 35);
		contentPanel.add(lblDescripcion);

		lblPrecioCompra = new JLabel("Precio Compra : ");
		lblPrecioCompra.setBounds(258, 202, 79, 35);
		contentPanel.add(lblPrecioCompra);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(96, 18, 142, 35);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(96, 110, 142, 35);
		txtDescripcion.setColumns(10);
		contentPanel.add(txtDescripcion);

		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setBounds(344, 202, 142, 35);
		txtPrecioCompra.setColumns(10);
		contentPanel.add(txtPrecioCompra);

		lblImagen = new JLabel("lblImagen");
		lblImagen.setBounds(289, 30, 158, 135);
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblImagen.setIcon(new ImageIcon(AgregarProductos.class.getResource("/data/imgpro1.jpg")));

		this.repaint();
		contentPanel.add(lblImagen);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(113, 321, 125, 55);
		btnAgregar.addActionListener(this);
		contentPanel.add(btnAgregar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(251, 321, 125, 55);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);

		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 64, 76, 35);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(96, 64, 142, 35);
		txtNombre.setColumns(10);
		contentPanel.add(txtNombre);

		lblCategoria = new JLabel("Categoria : ");
		lblCategoria.setBounds(10, 156, 76, 35);
		contentPanel.add(lblCategoria);

		lblPathImg = new JLabel("Imagen : ");
		lblPathImg.setBounds(10, 202, 76, 35);
		contentPanel.add(lblPathImg);

		lblEstado = new JLabel("Estado : ");
		lblEstado.setBounds(10, 248, 76, 35);
		contentPanel.add(lblEstado);

		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBounds(344, 248, 142, 35);
		contentPanel.add(txtPrecioVenta);

		lblPrecioVenta = new JLabel("Precio Venta : ");
		lblPrecioVenta.setBounds(258, 248, 79, 35);
		contentPanel.add(lblPrecioVenta);

		cboCategoria = new JComboBox();
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] { "Cafes", "Postres", "Batidos", "Otros" }));
		cboCategoria.setToolTipText("");
		cboCategoria.setBounds(96, 156, 142, 35);
		contentPanel.add(cboCategoria);
		cboCategoria.removeAllItems();
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/BD_Starbucks?autoReconnect=true&useSSL=false", "root", "mysql");
			Statement Sent = (Statement) con.createStatement();
			ResultSet rs = Sent.executeQuery("select nombre from TB_Categoria where Condicion =0");
			while (rs.next()) {
				this.cboCategoria.addItem(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}

		}

		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Disponible", "No Disponible" }));
		cboEstado.setToolTipText("");
		cboEstado.setBounds(96, 248, 142, 35);
		contentPanel.add(cboEstado);

		txtPath = new JTextField();
		txtPath.setEnabled(false);
		txtPath.setColumns(10);
		txtPath.setBounds(96, 202, 142, 35);
		contentPanel.add(txtPath);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
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

		// Variables

		String Codigo;
		String Descripcion, Nombre, Categoria, Path;
		int Estado;
		double PrecioCompra, PrecioVenta;
		GestionValidacionesSQL gv = new GestionValidacionesSQL();
		Patrones pa = new Patrones();
		// Entrada
		if (pa.ValidarCodigoCat(leerCodigo()) == 1) {
			if (gv.ValidarCodigoRepetido(leerCodigo(), "TB_Producto", "id_producto") == 1) {
				if (pa.ValidarNomGen(leerNombre()) == 1) {
					if (gv.ValidarCodigoRepetido(leerNombre(), "TB_Producto", "nombre") == 1) {
						if (pa.ValidarDescripcion(leerDescripcion()) == 1) {

							Codigo = leerCodigo();
							Nombre = leerNombre();
							Descripcion = leerDescripcion();
							Categoria = leerCategoria();
							if (leerPath() == "") {
								Path = leerPath();
							} else {
								Path = leerPath();
							}

							Estado = leerEstado();
							PrecioCompra = leerPrecioCompra();
							PrecioVenta = leerPrecioVenta();

							Producto p = new Producto();

							p.setCodigoProducto(Codigo);
							p.setNombre(Nombre);
							p.setDescripcion(Descripcion);
							p.setId_Categoria(Categoria);
							p.setPath(Path);
							p.setEstado(Estado);
							p.setPrecioCompra(PrecioCompra);
							p.setPrecioVenta(PrecioVenta);

							GestionProducto gp = new GestionProducto();

							int ok = gp.RegistrarProducto(p);

							if (ok == 1) {
								JOptionPane.showMessageDialog(null, "Se agrego el Producto", "Imformacion",
										JOptionPane.INFORMATION_MESSAGE);
								Limpiar();
								HiloActualizar h = new HiloActualizar();
								h.run();
							} else {
								JOptionPane.showMessageDialog(null,
										" No se agrego la Categoria error al Conectar a la base de Datos",
										"Imformacion", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Colocar un codigo que comience con la Letra P y con 12 numeros",
					"Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		// Limpiar();

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

	private String leerCategoria() {

		String Item;
		Item = (String) cboCategoria.getSelectedItem();
		System.out.println(Item);
		GestionCategoria gc = new GestionCategoria();
		Categoria c = gc.listarTodo(Item);

		return c.getIdCat();

	}

	private int leerEstado() {
		int estado = 0;
		estado = cboEstado.getSelectedIndex();
		return estado;
	}

	private String leerPath() {
		String path = null;
		path = txtPath.getText();
		return path;
	}

	private double leerPrecioCompra() {

		try {
			double precio = 0.0;
			precio = Double.parseDouble(txtPrecioCompra.getText());
			return precio;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un numero decimal en la Casilla Precio de Compra", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;

	}

	private double leerPrecioVenta() {
		try {
			double precio = 0.0;
			precio = Double.parseDouble(txtPrecioVenta.getText());
			return precio;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un numero decimal en la Casilla Precio de Venta", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return 0;

	}

	public void Limpiar() {

		txtCodigo.setText("");
		txtNombre.setText("");
		txtDescripcion.setText("");
		cboCategoria.setSelectedIndex(0);
		txtPath.setText("");
		cboEstado.setSelectedIndex(0);
		txtPrecioCompra.setText("");
		txtPrecioVenta.setText("");

	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		txtPath.setText(abrirArchivo());
	}

	private String abrirArchivo() {
		String texto = "";
		try {

			JFileChooser file = new JFileChooser();
			file.setAcceptAllFileFilterUsed(false);
			FileFilter filter = new FileNameExtensionFilter("Imagen ", "jpg");
			file.setFileFilter(filter);
			int returnVal = file.showOpenDialog(txtPath);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				texto = file.getSelectedFile().getAbsolutePath();
				ImageIcon fot = new ImageIcon(texto);
				Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
						Image.SCALE_DEFAULT));
				lblImagen.setIcon(icono);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex + "", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
		}

		return texto;

	}
}
