package com.starbucks.sistema.venta.entidades.Clases;

public class DocumentoVenta {
	// Atributos

	private String IdVenta;
	private String IdCliente;
	private String IdCatPago;
	private String IdEmp;
	private int NumBoleta;
	private double ImporteBruto;
	private double IGV;
	private double ImporteNeto;
	private int Estado;
	private String fecha;

	// Constructores
	public DocumentoVenta() {

	}

	public DocumentoVenta(String idVenta, String idCliente, String idCatPago, String idEmp, int numBoleta,
			double importeBruto, double iGV, double importeNeto, int estado, String fecha) {
		super();
		IdVenta = idVenta;
		IdCliente = idCliente;
		IdCatPago = idCatPago;
		IdEmp = idEmp;
		NumBoleta = numBoleta;
		ImporteBruto = importeBruto;
		IGV = iGV;
		ImporteNeto = importeNeto;
		Estado = estado;
		this.fecha = fecha;
	}

	public String getIdVenta() {
		return IdVenta;
	}

	public String getIdEmp() {
		return IdEmp;
	}

	public void setIdEmp(String idEmp) {
		IdEmp = idEmp;
	}

	public void setIdVenta(String idVenta) {
		IdVenta = idVenta;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getIdCatPago() {
		return IdCatPago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdCatPago(String idCatPago) {
		IdCatPago = idCatPago;
	}

	public int getNumBoleta() {
		return NumBoleta;
	}

	public void setNumBoleta(int numBoleta) {
		NumBoleta = numBoleta;
	}

	public double getImporteBruto() {
		return ImporteBruto;
	}

	public void setImporteBruto(double importeBruto) {
		ImporteBruto = importeBruto;
	}

	public double getIGV() {
		return IGV;
	}

	public void setIGV(double iGV) {
		IGV = iGV;
	}

	public double getImporteNeto() {
		return ImporteNeto;
	}

	public void setImporteNeto(double importeNeto) {
		ImporteNeto = importeNeto;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

}

/*
 * create table Documento_Venta( Id_Venta char(9)not null , Id_Cliente char(9)
 * not null, Id_cat_pago char(9) not null , Nmr_Boleta int not null,
 * Importe_Bruto float not null, IGV float not null, Importe_Neto float not
 * null, Estado int check(Estado <=2 and Estado > -1), primary key (Id_Venta),
 * constraint Id_Cliente foreign key (Id_Cliente) references
 * Cliente(Id_Cliente), constraint Id_cat_pago foreign key (Id_cat_pago)
 * references cat_pago (Id_cat_pago ));
 */