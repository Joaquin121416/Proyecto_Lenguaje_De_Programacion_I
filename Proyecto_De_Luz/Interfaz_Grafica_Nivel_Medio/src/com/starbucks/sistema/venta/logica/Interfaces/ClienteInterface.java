package com.starbucks.sistema.venta.logica.Interfaces;

import java.util.ArrayList;

import com.starbucks.sistema.venta.entidades.Clases.Cliente;

public interface ClienteInterface {

	public int registrarCliente(Cliente c);

	// Eliminar Categoria

	public int Eliminar(String codigo);

	// Listar Categoria

	public ArrayList<Cliente> listado();

	// Actulizar categoria

	public int actualizar(String IdCliente, String Nombre, String Apellido, int NumDocu,String TipoDoc,int TipoCliente,int NumPunt);

	// Listar Todo

	public Cliente listarTodo(String IdCliente);

}
