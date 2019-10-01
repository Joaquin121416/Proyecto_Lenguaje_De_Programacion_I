package com.starbucks.sistema.venta.entidades.Clases;

public class Cliente {
	// Atributos
	private String IdCliente;
	private String Nombre;
	private String Apellido;
	private int NumDocu;
	private String TipoDoc;
	private int TipoCliente;
	private int NumPunt;

	// Constructores

	/*
	 * id_cliente char(13) not null , nombre varchar(100) not null, apellido
	 * varchar(100) NOT NULL, nmr_Documento int not null, tipo_documento
	 * varchar(50) not null, tipo_cliente int check(tipo_cliente <=1 and
	 * tipo_cliente>-1), nmr_puntos int not null,
	 */
	public Cliente() {

	}

	public Cliente(String idCliente, String nombre, String apellido, int numDocu, String tipoDoc, int tipoCliente,
			int numPunt) {
		super();
		IdCliente = idCliente;
		Nombre = nombre;
		Apellido = apellido;
		NumDocu = numDocu;
		TipoDoc = tipoDoc;
		TipoCliente = tipoCliente;
		NumPunt = numPunt;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getNumDocu() {
		return NumDocu;
	}

	public void setNumDocu(int numDocu) {
		NumDocu = numDocu;
	}

	public String getTipoDoc() {
		return TipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		TipoDoc = tipoDoc;
	}

	public int getTipoCliente() {
		return TipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		TipoCliente = tipoCliente;
	}

	public int getNumPunt() {
		return NumPunt;
	}

	public void setNumPunt(int numPunt) {
		NumPunt = numPunt;
	}

	// Set and Get

}
// create table Cliente(
// Id_Cliente char(9) not null ,
// Nombre varchar(100) not null,
// Apellido varchar(100) not null,
// Nmr_Documento int not null,
// Tipo_Documento varchar(50) not null,
// Tipo_Cliente int check(Tipo_Cliente <=1 and Tipo_Cliente>-1),
// Nmr_Puntos int not null,
// primary key (Id_Cliente)
