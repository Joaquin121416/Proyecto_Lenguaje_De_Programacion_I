package com.starbucks.sistema.venta.entidades.Clases;

public class Empleado {
	private String IdEmpleado;
	private String Nombre;
	private String Apellidos;
	private String Dni;
	private String Cargo;
	private String Password;

	public Empleado() {

	}

	public Empleado(String idEmpleado, String nombre, String apellidos, String dni, String cargo, String password) {
		super();
		IdEmpleado = idEmpleado;
		Nombre = nombre;
		Apellidos = apellidos;
		Dni = dni;
		Cargo = cargo;
		Password = password;
	}

	public String getIdEmpleado() {
		return IdEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		IdEmpleado = idEmpleado;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
