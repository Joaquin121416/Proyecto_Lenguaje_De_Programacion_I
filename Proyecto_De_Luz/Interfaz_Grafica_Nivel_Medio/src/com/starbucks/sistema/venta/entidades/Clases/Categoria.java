package com.starbucks.sistema.venta.entidades.Clases;

public class Categoria {
	
	private String IdCat;
	private String Nombre;
	private String Descripcion;
	private int Condicional;

	public Categoria() {

	}

	public Categoria(String idCat, String nombre, String descripcion, int condicional) {
		super();
		IdCat = idCat;
		Nombre = nombre;
		Descripcion = descripcion;
		Condicional = condicional;
	}

	public String getIdCat() {
		return IdCat;
	}

	public void setIdCat(String idCat) {
		IdCat = idCat;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getCondicional() {
		return Condicional;
	}

	public void setCondicional(int condicional) {
		Condicional = condicional;
	}

}


