package com.starbucks.sistema.venta.entidades.Clases;

public class Movimiento {
  //atributos
	 private String IdMov;
	 private String IdProducto;
	 private String TipoMov;
	 private int Cantidad;
	 private String IdInventario;
	
	 
  //Constructores
	 
	 public Movimiento() {

		}


public Movimiento(String idMov, String idProducto, String tipoMov, int cantidad, String idInventario) {
	super();
	IdMov = idMov;
	IdProducto = idProducto;
	TipoMov = tipoMov;
	Cantidad = cantidad;
	IdInventario = idInventario;
}


public String getIdMov() {
	return IdMov;
}


public void setIdMov(String idMov) {
	IdMov = idMov;
}


public String getIdProducto() {
	return IdProducto;
}


public void setIdProducto(String idProducto) {
	IdProducto = idProducto;
}


public String getTipoMov() {
	return TipoMov;
}


public void setTipoMov(String tipoMov) {
	TipoMov = tipoMov;
}


public int getCantidad() {
	return Cantidad;
}


public void setCantidad(int cantidad) {
	Cantidad = cantidad;
}


public String getIdInventario() {
	return IdInventario;
}


public void setIdInventario(String idInventario) {
	IdInventario = idInventario;
}
	 
	 //get an Set

	  
}


//create table Movimiento(
//Id_mov      char(9) not null ,
//Id_Producto char(9) not null,
//Tipo_Mov  varchar(50) not null,
//Cantidad  int not null,
//Id_inventario char(9)  not null,
//Primary key (Id_mov),
//constraint Id_Producto foreign key (Id_Producto) references Producto(Id_Producto),
//constraint Id_inventario foreign key (Id_inventario) references Inventario(Id_inventario));
