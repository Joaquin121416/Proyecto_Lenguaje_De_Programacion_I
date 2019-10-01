package com.starbucks.sistema.venta.graficas.Dialogs;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;

public class ListaTrabajadores extends JDialog implements KeyListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tblTrabajadores;
	private JTextField txtNombre;
	private JLabel lblNombre;
	DefaultTableModel model;
	DefaultTableModel modelCambiante;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaTrabajadores dialog = new ListaTrabajadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaTrabajadores() {
		setUndecorated(true);
		setBounds(100, 100, 534, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Cargar();
		tblTrabajadores = new JTable(model);
		tblTrabajadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblTrabajadores.setFillsViewportHeight(true);
		tblTrabajadores.setBounds(32, 94, 457, 330);
		tblTrabajadores.getTableHeader().setReorderingAllowed(false);
		tblTrabajadores.setDefaultEditor(Object.class, null);
		contentPanel.add(tblTrabajadores);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(126, 22, 135, 45);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(32, 22, 105, 42);
		contentPanel.add(lblNombre);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(302, 22, 166, 45);
		contentPanel.add(btnSalir);
	}

	private void Cargar() {

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

	private void CargarWhere(String cad) {

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
			String sql = "select  `id_Empleado`,`nombre`,`apellidos`,cargo from TB_Empleado where nombre LIKE '%" + cad
					+ "%';";

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

	private void Cambiar() {
		tblTrabajadores.setModel(modelCambiante);
	}

	public void keyPressed(KeyEvent arg0) {
		try {
			CargarWhere(txtNombre.getText());
			Cambiar();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
	}

	protected void keyTypedTxtNombre(KeyEvent e) {
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
	}

	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}
