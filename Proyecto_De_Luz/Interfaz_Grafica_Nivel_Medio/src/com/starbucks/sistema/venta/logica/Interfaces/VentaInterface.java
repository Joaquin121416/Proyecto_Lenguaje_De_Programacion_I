package com.starbucks.sistema.venta.logica.Interfaces;

import com.starbucks.sistema.venta.entidades.Clases.Detalle;
import com.starbucks.sistema.venta.entidades.Clases.DocumentoVenta;

public interface VentaInterface {

	public int InsertarDocVenta(DocumentoVenta doc);
	
	public int insertarDettalle(Detalle det);
}
