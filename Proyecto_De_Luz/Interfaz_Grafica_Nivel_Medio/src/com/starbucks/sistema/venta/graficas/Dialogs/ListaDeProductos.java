package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.entidades.Clases.Producto;
import com.starbucks.sistema.venta.logica.Hilaso.HiloMandar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionProducto;

@SuppressWarnings("serial")
public class ListaDeProductos extends JDialog implements ActionListener, MouseListener {

	private static JTable tblProductos;
	private JScrollPane scrollPane;
	private JLabel lblImagen;
	private JButton btnNewButton;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JButton btnSalir;
	static DefaultTableModel model;

	static DefaultTableModel modelCambiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ListaDeProductos dialog = new ListaDeProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaDeProductos() {
		setUndecorated(true);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);

		Cargar();

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 600, 528);
		getContentPane().add(scrollPane);
		tblProductos = new JTable(model);
		tblProductos.addMouseListener(this);
		tblProductos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		// tblProductos.setModel(model);
		tblProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblProductos.setFillsViewportHeight(true);
		tblProductos.getSelectionModel().setSelectionInterval(0, 0);
		tblProductos.getTableHeader().setReorderingAllowed(false);
		tblProductos.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(tblProductos);

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(ListaDeProductos.class.getResource("/data/imgpro1.jpg")));
		lblImagen.setBounds(632, 18, 158, 135);
		getContentPane().add(lblImagen);

		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(632, 163, 158, 49);
		getContentPane().add(btnNewButton);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(632, 269, 158, 49);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(632, 223, 158, 29);
		getContentPane().add(lblCantidad);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(632, 360, 158, 49);
		getContentPane().add(btnSalir);
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblProductos.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(7)); // numero
		tcm.getColumn(1).setPreferredWidth(anchoColumna(12)); // categoria
		tcm.getColumn(2).setPreferredWidth(anchoColumna(4)); // estado

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {

		dispose();
	}

	public static void Cargar() {
		model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Precio Venta");
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select  `id_producto`,`nombre`,`precio_venta` from TB_Producto";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();
			try {
				while (rs.next()) {

					Object[] fila = new Object[3];

					for (int i = 0; i < 3; i++)
						try {
							fila[i] = rs.getObject(i + 1);
						} catch (SQLException e) {

							e.printStackTrace();
						}
					model.addRow(fila);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia");
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println("Error al cerrar");

			}

		}
		modelCambiante = model;
		model.fireTableDataChanged();

	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblProductos) {
			mouseClickedTblProductos(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	protected void mouseClickedTblProductos(MouseEvent arg0) {
		try {

			int fila = tblProductos.getSelectedRow();
			String dato = String.valueOf(tblProductos.getValueAt(fila, 0));
			String codigo = dato;

			GestionProducto gp = new GestionProducto();
			String path = gp.LLamarPath(codigo);
			ImageIcon fot = new ImageIcon(path);
			Icon icono = new ImageIcon(
					fot.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
			lblImagen.setIcon(icono);
		} catch (Exception e) {

		}
	}

	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		try {
			int fila = tblProductos.getSelectedRow();
			String dato = String.valueOf(tblProductos.getValueAt(fila, 0));
			String codigo = dato;

			GestionProducto gp = new GestionProducto();
			Producto pro = new Producto();
			pro = gp.listadoTodo(codigo);
			if (leerCantidad() != -1) {
				pro.setEstado(leerCantidad());

				HiloMandar h = new HiloMandar();
				h.run(pro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int leerCantidad() {
		try {
			int can = Integer.parseInt(txtCantidad.getText());
			return can;
		} catch (Exception e) {

		}
		return -1;
	}

}
