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
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCategoria;

@SuppressWarnings("serial")
public class ListaDeCategoriasModificar extends JDialog implements ActionListener {

	private static JTable tblCategorias;
	private JScrollPane scrollPane;
	private JLabel lblImagen;
	private JButton btnModificar;
	private JButton btnSalir;
	private GestionCategoria gc = new GestionCategoria();
	private JButton btnBorrar;
	static DefaultTableModel model;
	private static ResultSet rs = null;
	private static Connection con = null;
	private static PreparedStatement pst = null;
	static DefaultTableModel modelCambiante;
	Thread hilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ListaDeCategoriasModificar dialog = new ListaDeCategoriasModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaDeCategoriasModificar() {

		setUndecorated(true);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
		Cargar();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 600, 528);
		getContentPane().add(scrollPane);
		tblCategorias = new JTable(model);
		tblCategorias.getTableHeader().setReorderingAllowed(false);
		tblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 11));

		// tblProductos.setModel(model);
		tblCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblCategorias.setFillsViewportHeight(true);
		tblCategorias.getSelectionModel().setSelectionInterval(0, 0);
		// TheFrame.ap.fireTableDataChanged();
		tblCategorias.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(tblCategorias);

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(ListaDeCategoriasModificar.class.getResource("/data/imgpro1.jpg")));
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
		TableColumnModel tcm = tblCategorias.getColumnModel();
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
		dispose();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		int fila = tblCategorias.getSelectedRow();
		try {
			String dato = String.valueOf(tblCategorias.getValueAt(fila, 0));
			String codigo = dato;
			ModificarCategorias modc = new ModificarCategorias(codigo);
			modc.setVisible(true);
			modc.setLocationRelativeTo(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecciona una Categoria", "Imformacion",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		try {
			int fila = tblCategorias.getSelectedRow();
			String dato = String.valueOf(tblCategorias.getValueAt(fila, 0));
			String codigo = dato;
			gc.Eliminar(codigo);
			model.fireTableDataChanged();

			Cargar();
			Cambiar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " Selecciona una Categoria", "Imformacion",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void Cambiar() {
		tblCategorias.setModel(modelCambiante);

	}

	public static void Cargar() {

		try {
			model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("Nombre");
			model.addColumn("Estado");
			con = MySQLConexion.getConexion();
			String sql = "select  `idCat`,`nombre`,`condicion` from TB_Categoria";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();
			try {
				while (rs.next()) {

					Object[] fila = new Object[3];

					for (int i = 0; i < 3; i++)
						try {
							if (i == 2) {
								int Condicion = rs.getInt(i + 1);

								if (Condicion == 0) {
									fila[i] = "Disponible";

								} else {
									fila[i] = "No Disponible";
								}
							} else {
								fila[i] = rs.getObject(i + 1);
							}
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
