package com.starbucks.sistema.venta.logica.Interfaces;

import java.util.ArrayList;

import com.starbucks.sistema.venta.entidades.Clases.Empleado;

public interface EmpleadoInterface {
	public int registrarEmpleado(Empleado e);

	// Eliminar Categoria

	public int eliminar(String codigo);

	// Listar Categoria

	public ArrayList<Empleado> listado();

	// Actulizar categoria

	public int actualizar(String idEm, String nom, String ape, String dni, String car);

	public Empleado listarTodoporCodigo(String cod);

}
