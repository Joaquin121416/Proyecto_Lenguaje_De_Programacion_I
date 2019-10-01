package com.loquesea.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
import com.starbucks.sistema.venta.entidades.bean.Producto;
import com.starbucks.sistema.venta.logica.Mantenimiento.GestionProducto;
*/

@SuppressWarnings("serial")
public class Reportes extends JPanel implements ActionListener {
	private JButton btnReporte;

	public Reportes(Boolean Condicion, Boolean Condicion2) {
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(170, 84, 252, 188);
		add(btnReporte);
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {/*

		GestionProducto g = new GestionProducto();
		List<com.starbucks.sistema.venta.entidades.Clases.Producto> listado = g.listado();
		List<Producto> productos = new ArrayList<Producto>();

		for (com.starbucks.sistema.venta.entidades.Clases.Producto prod : listado) {
			Producto producto = new Producto();
			producto.setCodigo(prod.getCodigoProducto());
			producto.setNombre(prod.getNombre());
			producto.setPrecio(Double.toString(prod.getPrecioVenta()));
			productos.add(producto);
		}

		Reportes2 re = new Reportes2();
		re.ReportesProducto(productos);
	*/
	}
}
