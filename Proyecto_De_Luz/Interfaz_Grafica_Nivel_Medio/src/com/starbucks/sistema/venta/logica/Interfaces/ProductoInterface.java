package com.starbucks.sistema.venta.logica.Interfaces;

import java.util.ArrayList;

import com.starbucks.sistema.venta.entidades.Clases.Producto;

public interface ProductoInterface {

	// Registrar
	public int RegistrarProducto(Producto p);

	// Eliminar
	public int Eliminar(String codigo);

	// Listar
	public ArrayList<Producto> listado();

	// Actualizar
	public int Actualizar(String codigo,String nombre,String descripcion,String Categoria,String path,int estado,double precioCompra,double precioVenta);

	// Listar Todo
	public Producto listadoTodo(String codigo);

}
