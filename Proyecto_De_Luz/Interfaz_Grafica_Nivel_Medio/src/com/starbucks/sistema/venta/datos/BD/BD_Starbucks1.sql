create database BD_Starbucks;
use BD_Starbucks;


show full tables from BD_Starbucks
-- Crear Tablas

	-- Tabla Inventario
	create table TB_Inventario(
    
	id_inventario char(13)  not null,
	stock int not null,
	stock_min int  not null,
    primary key(id_inventario)
    );
	-- Tabla Categoria

	create table TB_Categoria(
	idCat char(13) not null ,
	nombre varchar (100) not null,
	descripcion varchar (500) not null,
	condicion int not null,
    primary key(idCat));
	
    Alter table TB_Categoria
    add constraint unqnombre unique (nombre);
    
	-- Tabla Producto

	create table TB_Producto(
	id_producto char(13) not null,
	nombre varchar(100) not null ,
	descripcion varchar(500) not null,
    idCat char(13) not null,
	path_imagen varchar (100) not null,
	precio_compra float not null,
	precio_venta float not null,
	estado int check(estado <=2 and estado >-1),
    primary key (id_producto),
    constraint idCat foreign key (idCat) references categoria(idCat));

	-- Tabla Movimiento

	create table TB_Movimiento(
	id_mov      char(13) not null ,
	id_Producto char(13) not null,
	tipo_Mov  varchar(50) not null,
	cantidad  int not null,
	id_inventario char(13)  not null,
	Primary key (id_mov) ,
	constraint id_producto foreign key (id_producto) references TB_Producto(id_producto),
	constraint id_inventario foreign key (id_inventario) references TB_Inventario(id_inventario));


-- Tabla Cliente

	create table TB_Cliente(
	id_cliente char(13)  not null ,
	nombre varchar(100) not null,
	apellido varchar(100) not null,
	nmr_Documento int not null,
	tipo_documento varchar(50) not null,
	tipo_cliente int check(tipo_cliente <=1 and tipo_cliente>-1),
	nmr_puntos int not null,
    primary key (id_Cliente)
    );



	-- Tabla Categoria de Pago  

	create table TB_Cat_Pago(
	Id_cat_pago char(13)  not null,
	Categoria int check(Categoria <=1 and Categoria>-1),
    primary key (Id_cat_pago));
	

	-- Tabla Documento de Venta


	create table TB_Documento_Venta(
	Id_Venta char(13)not null ,
	Id_Cliente char(13)  not null,
	Id_cat_pago char(13) not null ,
	 Nmr_Boleta int not null,
	 Importe_Bruto float not null,
	 IGV float not null,
	 Importe_Neto float not null,
	 Estado int check(Estado <=2 and  Estado > -1),
     primary key (Id_Venta),
     constraint id_Cliente foreign key (id_Cliente) references Cliente(id_Cliente),
     constraint id_cat_pago foreign key (id_cat_pago) references cat_pago (id_cat_pago ));
	

	-- Tabla Detalle Documento de Venta

	create table TB_Detalle_Doc_venta(
	id_detalle char(13)  not null ,
	id_producto char(13) not null,
	id_venta char(13) not null,
	precio_compra float not null,
	precio_centa float not null,
	fecha_centa datetime not null,
	cantidad int not null,
    primary key (id_Detalle),
    constraint id_producto1 foreign key (id_producto) references producto(id_producto),
    constraint id_venta1 foreign key (id_venta) references documento_venta(id_venta));
    


	-- Tabla Empleado 
	
	create table TB_Empleado (
	id_Empleado char(13)  not null,
    nombre varchar(70) not null,
    apellidos varchar(100)not null,
    dni char (8)not null,
	cargo varchar (50) not null,
    usuario varchar(100) not null,
    pasword varchar(100) not null,
    primary key (id_Empleado));
	






