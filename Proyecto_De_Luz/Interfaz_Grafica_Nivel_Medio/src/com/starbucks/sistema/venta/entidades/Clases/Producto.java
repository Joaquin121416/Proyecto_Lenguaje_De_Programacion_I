package com.starbucks.sistema.venta.entidades.Clases;

public class Producto {
	// Atributos
	private String CodigoProducto;
	private String Descripcion;
	private String Nombre;
	private String Id_Categoria;
	private String Path;
	private double PrecioCompra;
	private double PrecioVenta;
	private int Estado;

	// Constructores

	public Producto() {

	}

	public Producto(String codigoProducto, String descripcion, String nombre, String id_Categoria, String path,
			int estado, double precioCompra, double precioVenta) {
		super();
		CodigoProducto = codigoProducto;
		Nombre = nombre;
		Descripcion = descripcion;
		Id_Categoria = id_Categoria;
		Path = path;
		Estado = estado;
		PrecioCompra = precioCompra;
		PrecioVenta = precioVenta;
	}

	// Getters y Setters

	public String getCodigoProducto() {
		return CodigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		CodigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getId_Categoria() {
		return Id_Categoria;
	}

	public void setId_Categoria(String id_Categoria) {
		Id_Categoria = id_Categoria;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public double getPrecioCompra() {
		return PrecioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		PrecioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		PrecioVenta = precioVenta;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

}
