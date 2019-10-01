package com.starbucks.sistema.venta.logica.Interfaces;

import java.util.ArrayList;

import com.starbucks.sistema.venta.entidades.Clases.Categoria;

public interface CategoriaInterface {

	// Registrar Categoria

	public int registrarCategoria(Categoria c);

	// Eliminar Categoria

	public int Eliminar(String codigo);

	// Listar Categoriao

	public ArrayList<Categoria> listado();

	// Actulizar categoria

	public int actualizar(String idCategoria, String nombre, String descripcion, int estado);

	// Listar Todo

	public Categoria listarTodo(String nombre);

	

}
