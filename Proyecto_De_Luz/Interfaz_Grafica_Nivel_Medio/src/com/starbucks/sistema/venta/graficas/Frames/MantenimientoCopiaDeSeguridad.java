package com.starbucks.sistema.venta.graficas.Frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.starbucks.sistema.venta.entidades.Clases.Categoria;
import com.starbucks.sistema.venta.graficas.Dialogs.AgregarCategoria;
import com.starbucks.sistema.venta.graficas.Dialogs.AgregarProductos;
import com.starbucks.sistema.venta.graficas.Dialogs.ListaDeCategoriasModificar;
import com.starbucks.sistema.venta.graficas.Dialogs.ListaDeProductosModificar;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionCategoria;

@SuppressWarnings("serial")
public class MantenimientoCopiaDeSeguridad extends JPanel implements ActionListener {
	private JButton btnAgregar;
	private JLabel lblImagenAgregarProductos;
	private JButton btnModificarProductos;
	private JLabel lblImagenModificarProductos;
	private JButton btnAgregarTrabajador;
	private JLabel lblImagenAgregarTrabajador;
	private JButton btnModificarTrabajador;
	private JLabel lblImagenModificarTrabajador;
	private JButton btnAgregarCategoria;
	private JLabel lblImagenAgregarInsumo;
	private JButton btnModificarCategoria;
	private JLabel lblModificarInsumo;
	private JButton button_4;
	private JLabel label_4;
	private JButton button_5;
	private JLabel label_5;
	private JScrollPane scrollPane;

	public MantenimientoCopiaDeSeguridad(Boolean Condicion, Boolean Condicion2) {
		setOpaque(false);
		setVisible(false);
		setLayout(null);

		btnModificarProductos = new JButton("Modificar Productos");
		btnModificarProductos.addActionListener(this);
		btnModificarProductos.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconUpdate.png")));
		btnModificarProductos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificarProductos.setBounds(195, 11, 160, 60);
		add(btnModificarProductos);

		lblImagenModificarProductos = new JLabel("");
		lblImagenModificarProductos
				.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgModificarProducto.png")));
		lblImagenModificarProductos.setBounds(195, 81, 160, 165);
		add(lblImagenModificarProductos);

		btnAgregarTrabajador = new JButton("Agregar Trabajador");
		btnAgregarTrabajador.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconA\u00F1adir.png")));
		btnAgregarTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregarTrabajador.setBounds(360, 11, 160, 60);
		add(btnAgregarTrabajador);

		lblImagenAgregarTrabajador = new JLabel("");
		lblImagenAgregarTrabajador
				.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgAgregarTrabajador.png")));
		lblImagenAgregarTrabajador.setBounds(360, 81, 160, 165);
		add(lblImagenAgregarTrabajador);

		btnModificarTrabajador = new JButton("Modificar Trabajador");
		btnModificarTrabajador.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconBorrar.png")));
		btnModificarTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificarTrabajador.setBounds(526, 11, 160, 60);
		add(btnModificarTrabajador);

		lblImagenModificarTrabajador = new JLabel("");
		lblImagenModificarTrabajador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagenModificarTrabajador
				.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgModificarTrabajador.png")));
		lblImagenModificarTrabajador.setBounds(526, 81, 160, 165);
		add(lblImagenModificarTrabajador);

		btnAgregarCategoria = new JButton("Agregar Categoria");
		btnAgregarCategoria.addActionListener(this);
		btnAgregarCategoria.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconA\u00F1adir.png")));
		btnAgregarCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregarCategoria.setBounds(31, 257, 160, 60);
		add(btnAgregarCategoria);

		lblImagenAgregarInsumo = new JLabel("");
		lblImagenAgregarInsumo.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgAgregarInsumos.png")));
		lblImagenAgregarInsumo.setBounds(31, 327, 160, 165);
		add(lblImagenAgregarInsumo);

		btnModificarCategoria = new JButton("Modificar Categoria");
		btnModificarCategoria.addActionListener(this);
		btnModificarCategoria.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconUpdate.png")));
		btnModificarCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificarCategoria.setBounds(195, 257, 160, 60);
		add(btnModificarCategoria);

		lblModificarInsumo = new JLabel("");
		lblModificarInsumo.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgModificarInsumos.png")));
		lblModificarInsumo.setBounds(195, 327, 160, 165);
		add(lblModificarInsumo);

		button_4 = new JButton("Modificar Productos");
		button_4.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconA\u00F1adir.png")));
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_4.setBounds(360, 257, 160, 60);
		add(button_4);

		label_4 = new JLabel("");
		label_4.setBounds(360, 327, 160, 165);
		add(label_4);

		button_5 = new JButton("Modificar Productos");
		button_5.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconUpdate.png")));
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_5.setBounds(526, 257, 160, 60);
		add(button_5);

		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgModificarProducto.png")));
		label_5.setBounds(526, 327, 160, 165);
		add(label_5);
		btnAgregar = new JButton("Agregar Productos");
		btnAgregar.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgIconA\u00F1adir.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregar.setBounds(31, 11, 160, 60);
		add(btnAgregar);

		lblImagenAgregarProductos = new JLabel("");
		lblImagenAgregarProductos
				.setIcon(new ImageIcon(MantenimientoCopiaDeSeguridad.class.getResource("/data/imgAgregarProducto.png")));
		lblImagenAgregarProductos.setBounds(31, 81, 160, 165);
		add(lblImagenAgregarProductos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 675, 345);
		scrollPane.setViewportView(this);

	}

	public Boolean SetVisible(Boolean Condicion) {
		return Condicion;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificarCategoria) {
			actionPerformedBtnModificarCategoria(arg0);
		}
		if (arg0.getSource() == btnAgregarCategoria) {
			actionPerformedBtnAgregarCategoria(arg0);
		}
		if (arg0.getSource() == btnModificarProductos) {
			actionPerformedBtnModificarProductos(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregarProducto(arg0);
		}
	}

	protected void actionPerformedBtnAgregarProducto(ActionEvent arg0) {

		AgregarProductos agregaPro = new AgregarProductos();
		agregaPro.setVisible(true);
		agregaPro.setLocationRelativeTo(null);

		GestionCategoria gc = new GestionCategoria();
		ArrayList<Categoria> lista = gc.listado();
		if (lista.size() > 0) {
			agregaPro.dispose();
			JOptionPane.showMessageDialog(null, "Error no existe ninguna Categoria", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void actionPerformedBtnModificarProductos(ActionEvent arg0) {

		ListaDeProductosModificar lpm = new ListaDeProductosModificar();
		lpm.setVisible(true);
		lpm.setLocationRelativeTo(null);
	}

	protected void actionPerformedBtnAgregarCategoria(ActionEvent arg0) {

		AgregarCategoria agregaCat = new AgregarCategoria();
		agregaCat.setVisible(true);
		agregaCat.setLocationRelativeTo(null);

	}

	protected void actionPerformedBtnModificarCategoria(ActionEvent arg0) {
		ListaDeCategoriasModificar lcm = new ListaDeCategoriasModificar();
		lcm.setVisible(true);
		lcm.setLocationRelativeTo(null);

	}
}