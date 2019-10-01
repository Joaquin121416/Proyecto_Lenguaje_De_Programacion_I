package com.starbucks.sistema.venta.entidades.Clases;

public class Detalle {

	private String cod_deta;
	private String cod_pro;
	private String cod_ven;
	private double precio;
	private int can;

	public Detalle() {
		super();
	}

	public Detalle(String cod_deta, String cod_pro, String cod_ven, double precio, int can) {
		super();
		this.cod_deta = cod_deta;
		this.cod_pro = cod_pro;
		this.cod_ven = cod_ven;
		this.precio = precio;
		this.can = can;
	}

	public String getCod_deta() {
		return cod_deta;
	}

	public void setCod_deta(String cod_deta) {
		this.cod_deta = cod_deta;
	}

	public String getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(String cod_pro) {
		this.cod_pro = cod_pro;
	}

	public String getCod_ven() {
		return cod_ven;
	}

	public void setCod_ven(String cod_ven) {
		this.cod_ven = cod_ven;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCan() {
		return can;
	}

	public void setCan(int can) {
		this.can = can;
	}

}

/*
 * id_detalle char(13) not null , id_producto char(13) not null, id_venta
 * char(13) not null, precio_venta float not null, fecha_venta datetime not
 * null, cantidad int not null,
 */