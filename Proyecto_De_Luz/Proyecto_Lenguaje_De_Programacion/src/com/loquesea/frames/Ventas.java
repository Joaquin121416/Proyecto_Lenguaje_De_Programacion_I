package com.loquesea.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/*import com.starbucks.sistema.venta.entidades.Clases.Detalle;
import com.starbucks.sistema.venta.entidades.Clases.DocumentoVenta;
import com.starbucks.sistema.venta.entidades.Clases.Producto;
import com.starbucks.sistema.venta.graficas.Dialogs.ListaDeProductos;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionVenta;
*/
@SuppressWarnings("serial")
public class Ventas extends JPanel implements ActionListener {

	private JTextField txtCliente;
	private JButton btnNewButton;
	private JButton btnVender;
	private static JTable tblProductos;
	private JScrollPane scrollPane;
	private JButton btnBorrar;
	static DefaultTableModel model;
	//public static ArrayList<Producto> lista;
	static DefaultTableModel modelCambiante;
	private static JTextField txtTotal;
	private static JTextField txtCodBol;
	static double sum = 0;
	static String numeroDeta;

	static double precio;

	public Ventas(Boolean Condicion, Boolean Condicion2) {
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		setVisible(false);
		setLayout(null);
		//lista = new ArrayList<Producto>();
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setEnabled(Condicion);
		lblCliente.setVisible(Condicion);
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCliente.setBounds(10, 22, 151, 47);
		add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setBounds(137, 22, 177, 47);
		add(txtCliente);
		txtCliente.setColumns(10);

		btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(337, 22, 103, 47);
		add(btnNewButton);

		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(452, 22, 103, 47);
		add(btnVender);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 104, 683, 365);
		add(scrollPane);
		tblProductos = new JTable();

		tblProductos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblProductos.setFillsViewportHeight(true);
		tblProductos.getSelectionModel().setSelectionInterval(0, 0);
		scrollPane.setViewportView(tblProductos);
		tblProductos.setDefaultEditor(Object.class, null);
		tblProductos.getTableHeader().setReorderingAllowed(false);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(567, 22, 103, 47);
		add(btnBorrar);

		txtTotal = new JTextField();
		txtTotal.setFocusable(false);
		txtTotal.setBounds(501, 463, 224, 47);
		add(txtTotal);
		txtTotal.setColumns(10);
		txtCliente.setText("X000000000001");

		txtCodBol = new JTextField();
		txtCodBol.setEditable(false);
		txtCodBol.setFocusable(false);
		txtCodBol.setColumns(10);
		txtCodBol.setBounds(42, 463, 224, 47);
		add(txtCodBol);
		ajustarAnchoColumnas();
		Carga();
		//tblProductos.setModel(model);
		Generar();
	}

	public Boolean SetVisible(Boolean Condicion) {
		return Condicion;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	void ajustarAnchoColumnas() {

	}

	public static void Cambiar() {
		tblProductos.setModel(modelCambiante);
		sum = 0;
		/*
		for (Producto producto : lista) {
			sum += producto.getPrecioVenta() * producto.getEstado();
			System.out.println(sum + "sum");
		}*/

		txtTotal.setText("S/ " + sum);

	}

	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		/*
		ListaDeProductos lista = new ListaDeProductos();
		lista.setVisible(true);
		lista.setLocationRelativeTo(null);
		*/
	}

	public static void Carga() {
		/*
		model = new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Sub Total");
		for (Producto producto : lista) {

			Object[] fila = new Object[5];
			fila[0] = producto.getCodigoProducto();
			fila[1] = producto.getNombre();
			fila[2] = producto.getEstado();
			fila[3] = producto.getPrecioVenta();
			fila[4] = producto.getPrecioVenta() * producto.getEstado();
			precio = producto.getPrecioVenta() * producto.getEstado();
			System.err.println(precio);
			model.addRow(fila);
		}
		modelCambiante = model;
		model.fireTableDataChanged();
		 */
	}

	protected void actionPerformedBtnVender(ActionEvent arg0) {/*
		GestionVenta gv = new GestionVenta();
		try {
			Generar();
			DocumentoVenta doc = new DocumentoVenta();
			doc.setIdVenta(txtCodBol.getText());
			doc.setIdCliente(txtCliente.getText());
			doc.setIdCatPago("Q000000000001");
			doc.setIdEmp(TheFrame.User);
			doc.setNumBoleta(0);
			doc.setImporteBruto(sum);
			doc.setIGV(0.18);
			doc.setImporteNeto(sum - (sum * 0.18));
			doc.setEstado(0);
			doc.setFecha(null);
			int rs = gv.InsertarDocVenta(doc);
			System.out.println(rs);

			if (rs == 0) {
				JOptionPane.showMessageDialog(null, "No se pudo Agregar revise bien los datos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				for (Producto producto : lista) {
					Detalle d = new Detalle();
					GenerarDeta();
					d.setCod_deta(numeroDeta);
					d.setCod_pro(producto.getCodigoProducto());
					d.setCod_ven(txtCodBol.getText());
					d.setCan(producto.getEstado());
					d.setPrecio(producto.getPrecioVenta() * producto.getEstado());
					int n = gv.insertarDettalle(d);
					GenerarDeta();
				}

				JOptionPane.showMessageDialog(null, "La Boleta se Agrego con exito", "OK",
						JOptionPane.INFORMATION_MESSAGE);

				GenerarDeta();
				model = null;
				Carga();
				Cambiar();
				Generar();
				txtTotal.setText("S/ " + 0.0);
				model=null;
				modelCambiante=null;
				tblProductos.removeAll();
				lista.removeAll(lista);
				Carga();
				Cambiar();
				

				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 */
	}
/*
	public static void anadir(Producto pro) {
		lista.add(pro);
	}
*/
	protected void actionPerformedBtnBorrar(ActionEvent arg0) throws ArrayIndexOutOfBoundsException {
/*
		try {

			lista.remove(tblProductos.getRowCount() - 1);
			if (tblProductos.getRowCount() - 1 == -1) {
				JOptionPane.showMessageDialog(null, "No hay nada en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
				txtTotal.setText("S/ " + 0.0);
			} else {

				Carga();
				Cambiar();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No hay nada en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
			txtTotal.setText("S/ " + 0.0);
		}*/
	}

	private static void Generar() {/*
		GestionVenta gv = new GestionVenta();
		String Code = gv.UltimoBol();
		String aux = Code.substring(1, 12);
		Long num = Long.parseLong(aux);
		num = num + 1;
		Code = "K01" + num;
		txtCodBol.setText(Code);
		System.out.println(Code);
		*/
	}

	private static void GenerarDeta() {/*
		GestionVenta gv = new GestionVenta();
		String Code = gv.UltimoDet();
		String aux = Code.substring(1, 12);
		Long num = Long.parseLong(aux);
		num = num + 1;
		Code = "W01" + num;
		numeroDeta = Code;
		System.out.println(Code);
		*/
	}
}
