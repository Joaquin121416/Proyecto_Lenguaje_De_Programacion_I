package com.starbucks.sistema.venta.entidades.Clases;

public class CategoriadePago {
	// Atributos
	private String IdCatPago;
	private int Categoria;

	// Constructores
	public CategoriadePago() {

	}

	public CategoriadePago(String idCatPago, int categoria) {
		super();
		IdCatPago = idCatPago;
		Categoria = categoria;
	}
	// set and Get

	public String getIdCatPago() {
		return IdCatPago;
	}

	public void setIdCatPago(String idCatPago) {
		IdCatPago = idCatPago;
	}

	public int getCategoria() {
		return Categoria;
	}

	public void setCategoria(int categoria) {
		Categoria = categoria;
	}

}
// create table cat_pago(
// Id_cat_pago char(9) not null,
// Categoria int check(Categoria <=1 and Categoria>-1),
// primary key (Id_cat_pago));