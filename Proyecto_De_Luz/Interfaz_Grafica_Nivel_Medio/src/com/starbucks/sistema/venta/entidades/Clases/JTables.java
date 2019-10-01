package com.starbucks.sistema.venta.entidades.Clases;

import javax.swing.table.DefaultTableModel;

public class JTables {
	
	public DefaultTableModel CrearDataTableModel(int NColumnas, String[] NombreDeColumnas) {

		DefaultTableModel model = new DefaultTableModel();

		for (int i = 0; i < NombreDeColumnas.length ; i++) {
			model.addColumn(NombreDeColumnas[i]);
		}
		return model;

	}

}
