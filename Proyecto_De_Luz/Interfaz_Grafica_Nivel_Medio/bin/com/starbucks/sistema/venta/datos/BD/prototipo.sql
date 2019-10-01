
create database BD_Starbucks

	create table TB_Inventario(
	Id_inventario char(9) primary key not null,
	Stock int not null,
	Stock_Min int  not null)
	
	

	create table TB_Categoria(
	IdCat char(9) not null primary key,
	Nombre varchar (100) not null,
	Descripcion varchar (500) not null,
	Condicion int not null)
	

	drop table TB_Producto

	create table TB_Producto(
	`Id_Producto` char(9) not null,
	`Nombre` varchar(100) not null ,
	`Descripcion` varchar(500) not null,
	`IdCat` varchar(100) not null ,
	`path_imagen` varchar(100),
    `Estado` varchar(100) not null,
	`Precio_compra` float not null,
	`Precio_Venta` float not null,
    primary key (`Id_Producto`)
   

	)
    SELECT * FROM TB_Producto
    

    
    USE BD_Starbucks
    
    select  `Id_Producto`,`Nombre`,`Precio_Venta` from TB_Producto
    select * from TB_Producto
	Delete  from  `BD_Starbucks`.`TB_Producto` WHERE `Id_Producto` =11;
    
    
    uPDATE `BD_Starbucks`.`TB_Producto` SET `Nombre`=1,`Descripcion`=1,`IdCat`=1,`path_imagen`=1,`Estado`=1,`Precio_compra`=1,`Precio_Venta`=1   WHERE `Id_Producto` =11;
  SET SQL_SAFE_UPDATES = 0;
	Delete * from `TB_Producto`;




	create table TB_Movimiento(
		Id_mov      char(9) not null Primary key,
		Id_Producto char(9) foreign key references TB_Producto(Id_Producto),
		Tipo_Mov  varchar(50) not null,
		Cantidad  int not null,
		Id_inventario char(9) foreign key references Inventario(Id_inventario) not null)
		




	create table TB_Cliente(
	Id_Cliente char(9)  not null primary key,
	Nombre varchar(100) not null,
	Apellido varchar(100) not null,
	Nmr_Documento varchar not null,
	Tipo_Documento varchar(50) not null,
	Tipo_Cliente int check(Tipo_Cliente <=1 and Tipo_Cliente>-1) not null,
	Nmr_Puntos int not null)
	


	

	create table TB_cat_pago(
	Id_cat_pago char(9) primary key not null,
	Categoria int check(Categoria <=1 and Categoria>-1) not null)
	
	




	create table TB_Documento_Venta(
	Id_Venta char(9)not null primary key,
	Id_Cliente char(9)  not null foreign key references Cliente(Id_Cliente),
	Id_cat_pago char(9) not null foreign key references cat_pago (Id_cat_pago ),
	 Nmr_Boleta int not null,
	 Importe_Bruto float not null,
	 IGV float not null,
	 Importe_Neto float not null,
	 Estado int check(Estado <=2 and  Estado > -1) not null)

	



	create table TB_Detalle_Doc_venta(
	Id_Detalle char(9)  not null primary key,
	Id_Producto char(9) foreign key references Producto(Id_Producto),
	Id_Venta char(9) not null foreign key references Documento_Venta(Id_Venta),
	Precio_compra float not null,
	Precio_Venta float not null,
	Fecha_Venta datetime not null,
	Cantidad int not null)






SHOW FULL TABLES FROM BD_Starbucks
    