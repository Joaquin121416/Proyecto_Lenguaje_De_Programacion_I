package com.starbucks.sistema.venta.graficas.Frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.starbucks.sistema.venta.graficas.Dialogs.ListaProductos;
import com.starbucks.sistema.venta.graficas.Dialogs.ListaTrabajadores;

@SuppressWarnings("serial")
public class Consultas extends JPanel implements ActionListener {
	private JButton btnBuscarTrabajador;
	private JButton btnListaProductosxPorCodigo;

	public Consultas(Boolean Condicion, Boolean Condicion2) {
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		btnBuscarTrabajador = new JButton("Buscar Trabajador");
		btnBuscarTrabajador.addActionListener(this);
		btnBuscarTrabajador.setBounds(157, 92, 243, 204);
		add(btnBuscarTrabajador);

		btnListaProductosxPorCodigo = new JButton("Listar Productos por Categorias");
		btnListaProductosxPorCodigo.addActionListener(this);
		btnListaProductosxPorCodigo.setBounds(410, 274, 243, 204);
		add(btnListaProductosxPorCodigo);
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListaProductosxPorCodigo) {
			actionPerformedBtnListaProductosxPorCodigo(e);
		}
		if (e.getSource() == btnBuscarTrabajador) {
			actionPerformedBtnBuscarTrabajador(e);
		}
	}

	protected void actionPerformedBtnBuscarTrabajador(ActionEvent e) {
		ListaTrabajadores lt = new ListaTrabajadores();
		lt.setVisible(true);
		lt.setLocationRelativeTo(null);
	}

	protected void actionPerformedBtnListaProductosxPorCodigo(ActionEvent e) {
		ListaProductos lp = new ListaProductos();
		lp.setVisible(true);
		lp.setLocationRelativeTo(null);
	}
}
