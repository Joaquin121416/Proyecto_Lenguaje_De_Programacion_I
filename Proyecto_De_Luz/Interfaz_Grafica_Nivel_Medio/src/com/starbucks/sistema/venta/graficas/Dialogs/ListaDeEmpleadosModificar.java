package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.logica.Hilaso.HiloActualizar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionEmpleado;

@SuppressWarnings("serial")
public class ListaDeEmpleadosModificar extends JDialog implements ActionListener {

	private static JTable tblEmpleados;
	private JScrollPane scrollPane;
	private JLabel lblImagen;
	private JButton btnModificar;
	private JButton btnSalir;
	private GestionEmpleado ge = new GestionEmpleado();
	private JButton btnBorrar;
	static DefaultTableModel model;

	static DefaultTableModel modelCambiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ListaDeEmpleadosModificar dialog = new ListaDeEmpleadosModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaDeEmpleadosModificar() {

		setUndecorated(true);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 600, 528);
		getContentPane().add(scrollPane);
		Cargar();
		tblEmpleados = new JTable(model);
		tblEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		// tblProductos.setModel(model);
		tblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblEmpleados.setFillsViewportHeight(true);
		tblEmpleados.getSelectionModel().setSelectionInterval(0, 0);
		tblEmpleados.getTableHeader().setReorderingAllowed(false);
		tblEmpleados.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(tblEmpleados);

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(ListaDeEmpleadosModificar.class.getResource("/data/imgpro1.jpg")));
		lblImagen.setBounds(632, 18, 158, 135);
		getContentPane().add(lblImagen);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(632, 163, 158, 49);
		getContentPane().add(btnModificar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(632, 335, 158, 49);
		getContentPane().add(btnSalir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(632, 250, 158, 49);
		getContentPane().add(btnBorrar);
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblEmpleados.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(7)); // numero
		tcm.getColumn(1).setPreferredWidth(anchoColumna(12)); // categoria
		tcm.getColumn(2).setPreferredWidth(anchoColumna(4)); // estado

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		ge.listado();

		dispose();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		try {
			int fila = tblEmpleados.getSelectedRow();
			String dato = String.valueOf(tblEmpleados.getValueAt(fila, 0));
			String codigo = dato;

			ModificarEmpleados modp = new ModificarEmpleados(codigo);
			modp.setVisible(true);
			modp.setLocationRelativeTo(null);
		} catch (Exception e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al intentar Modificar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		try {
			int fila = tblEmpleados.getSelectedRow();
			String dato = String.valueOf(tblEmpleados.getValueAt(fila, 0));
			String codigo = dato;
			ge.eliminar(codigo);

			HiloActualizar h = new HiloActualizar();
			h.run(2);
			JOptionPane.showMessageDialog(null, "Se Borro con exito");
		} catch (Exception e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al intentar Borrar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void Cambiar() {
		tblEmpleados.setModel(modelCambiante);

	}

	public static void Cargar() {
		model = new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Cargo");
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select  `id_Empleado`,`nombre`,`apellidos`,cargo from TB_Empleado";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();
			try {
				while (rs.next()) {

					Object[] fila = new Object[4];

					for (int i = 0; i < 4; i++)
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

}
