-- Base de Datos Starbucks --
-- Author : Joaquin Cunorana Jimenez --
 -- Base de Datos referente a la cadena de coffe shop StarBucks -- 
SHOW VARIABLES LIKE "%version%"; 
SET GLOBAL max_connections = 1500;  
drop database  if EXISTS BD_Starbucks;
create database BD_Starbucks;
use BD_Starbucks;

-- Crear Tablas

	-- Tabla Inventario
	create table TB_Inventario(
    
	id_inventario char(13)  not null,
	stock int not null,
	stock_min int  not null,
    primary key(id_inventario)
    );
    
    
      insert into TB_Inventario values('I000000000001',300,200);
	  insert into TB_Inventario values('I000000000002',400,200);
      insert into TB_Inventario values('I000000000003',500,200);
	-- Tabla Categoria

	create table TB_Categoria(
	idCat char(13) not null ,
	nombre varchar (100) not null,
	descripcion varchar (500) not null,
	condicion int not null,
    primary key(idCat));
	
    Alter table TB_Categoria
    add constraint unqnombre unique (nombre) ;
    
    -- 0 significa disponible --
    -- 1 significa no disponible --
    insert into TB_Categoria values('C000000000001','Cafes','Solo Cafes',0);
    insert into TB_Categoria values('C000000000002','Postres','Solo Postres',0);
    insert into TB_Categoria values('C000000000003','Milkshakes','Solo Milkshakes',0);
    insert into TB_Categoria values('C000000000004','Articulos','Solo Articulos',1);

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
    constraint idcat foreign key (idcat) references TB_Categoria(idcat) on delete cascade on update cascade);
    
    
    insert into TB_Producto values('P000000000001','Cafe Capuccino Mediano','Cafe hecho con leche','C000000000001','D:\\Imagenes//img1.jpg',4.30,6.00,0);
    insert into TB_Producto values('P000000000002','Cafe Americano Mediano','Cafe puro','C000000000001','D:\\Imagenes//img2.jpg',3.40,4.90,0);
    insert into TB_Producto values('P000000000003','Cafe Mocaccino Mediano','Cafe hecho con leche y chocolate','C000000000001','D:\\Imagenes//img3.jpg',4.90,6.90,0);
    insert into TB_Producto values('P000000000004','Cafe Americano Pequeño','Cafe puro','C000000000001','D:\\Imagenes//img1.jpg',2.10,3.00,0);
    insert into TB_Producto values('P000000000005','Cafe Capuccino Pequeño','Cafe hecho con leche','C000000000001','D:\\Imagenes//img2.jpg',2.30,3.50,0);
    insert into TB_Producto values('P000000000006','Cafe Mocaccino Pequeño','Cafe hecho con leche y chocolate','C000000000001','D:\\Imagenes//img3.jpg',2.10,3.40,0);
    insert into TB_Producto values('P000000000007','Tajada Torta Selva Negra','Torta de chocolate de 500gr','C000000000002','D:\\Imagenes//img4.jpg',4.5,6.40,0);
    insert into TB_Producto values('P000000000008','Tajada Torta Tres Leches','Torta de Tres Leches de 500gr','C000000000002','D:\\Imagenes//img5.jpg',4.9,6.40,0);
    insert into TB_Producto values('P000000000009','Pie de Manzana','Pie de manzana de 500gr','C000000000002','',2.5,3.40,0);
	insert into TB_Producto values('P000000000010','Pie de Limon','Pie de limon de 500gr','C000000000002','',2.5,3.40,0);
	insert into TB_Producto values('P000000000011','MilkShake Vainilla Mediano','MilkShake con sabor a Vainilla','C000000000003','',6.10,8.40,0);
    insert into TB_Producto values('P000000000012','MilkShake Fresa Mediano','MilkShake con sabor a Fresa','C000000000003','',6.40,8.40,0);
    insert into TB_Producto values('P000000000013','MilkShake Chocolate Mediano','MilkShake con sabor a Chocolate','C000000000003','',6.90,8.40,0);
    insert into TB_Producto values('P000000000014','Taza Star','Taza con el logo de la empresa','C000000000003','',4.90,7.40,0);
	insert into TB_Producto values('P000000000015','Polera Star','Polo con el logo de la empresa','C000000000003','',16.90,23.40,0);
	insert into TB_Producto values('P000000000016','Ping Star','Ping con el logo de la empresa','C000000000003','',0.90,1.40,0);
      
      
	select * from TB_Producto;
	-- Tabla Movimiento
     select TB_Categoria.nombre,TB_Producto.nombre from TB_Categoria inner join TB_Producto on TB_Categoria.idCat=TB_Producto.idCat;
     
	create table TB_Movimiento(
	id_mov      char(13) not null ,
	id_Producto char(13) not null,
	tipo_Mov  varchar(50) not null,
	cantidad  int not null,
	id_inventario char(13)  not null,
    fecha date not null,
	Primary key (id_mov) ,
	constraint id_producto foreign key (id_producto) references TB_Producto(id_producto) on delete cascade on update cascade,
	constraint id_inventario foreign key (id_inventario) references TB_Inventario(id_inventario)on delete cascade on update cascade) ;
	
	insert into TB_Movimiento values('M000000000001','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000002','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000003','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000004','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000005','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000006','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000007','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000008','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000009','P000000000001','INGRESO',300,'I000000000001',now());
    insert into TB_Movimiento values('M000000000010','P000000000001','INGRESO',300,'I000000000001',now());
	insert into TB_Movimiento values('M000000000011','P000000000001','INGRESO',300,'I000000000001',now());
	insert into TB_Movimiento values('M000000000012','P000000000001','INGRESO',300,'I000000000001',now());
	insert into TB_Movimiento values('M000000000013','P000000000001','INGRESO',300,'I000000000001',now());
	insert into TB_Movimiento values('M000000000014','P000000000001','INGRESO',300,'I000000000001',now());
	insert into TB_Movimiento values('M000000000015','P000000000001','INGRESO',300,'I000000000001',now());
	insert into TB_Movimiento values('M000000000016','P000000000001','INGRESO',300,'I000000000001',now());
    
    SELECT TB_Inventario.stock FROM TB_Inventario INNER JOIN TB_Movimiento ON TB_Inventario.id_inventario = TB_Movimiento.id_inventario INNER JOIN  TB_Producto ON TB_Movimiento.id_Producto =TB_Producto.id_Producto GROUP BY TB_Inventario.stock;
-- Tabla Cliente

	create table TB_Cliente(
	id_cliente char(13)  not null ,
	nombre varchar(100) not null,
	apellido varchar(100) NOT NULL,
	nmr_Documento int not null,
	tipo_documento varchar(50) not null,
	tipo_cliente int check(tipo_cliente <=1 and tipo_cliente>-1),
	nmr_puntos int not null,
    primary key (id_Cliente)
    );
    
    -- 0 es Comun --
    -- y 1 es Empresarial --
    insert into TB_Cliente values('X000000000001','Cliente Principal','solo para uso general','00000000','DNI',0,1100);
    insert into TB_Cliente values('X000000000002','Sergio','Sembrera Cerdan','71289998','DNI',0,200);
    insert into TB_Cliente values('X000000000003','DEJ CONFECCIONES','','71289998','DNI',1,200);
    
	select * from TB_Cliente;

	-- Tabla Categoria de Pago  

	create table TB_Cat_Pago(
	Id_cat_pago char(13)  not null,
	Categoria int check(Categoria <=1 and Categoria>-1),
    primary key (Id_cat_pago));
    
    -- Donde 0 es Efectivo y 1 es Tarjeta --
     insert into TB_Cat_Pago values('Q000000000001',0);
     insert into TB_Cat_Pago values('Q000000000002',1);

	-- Tabla Empleado 
	create table TB_Empleado (
	id_Empleado char(13)  not null,
    nombre varchar(100) not null,
    apellidos varchar(100)not null,
    dni char (8)not null, 
	cargo varchar (50) not null,
    pasword varchar(100) not null,
    primary key (id_Empleado));
    
	insert into TB_Empleado values('V0001','Vicente Andres','Vargas Collazos','12345678','VENDEDOR','123456');
    insert into TB_Empleado values('V0002','Antonio Jesus','Castro Rojas','12345678','VENDEDOR','123456');
    insert into TB_Empleado values('V0003','Luis Alberto','Ramirez Jimenez','12345678','VENDEDOR','123456');
    insert into TB_Empleado values('V0004','Juan','Nancay Arrieta','12345678','ADMINISTRADOR','123456');
    
	-- Tabla Documento de Venta
	select * from TB_Empleado;
	create table TB_Documento_Venta(
	id_Venta char(13)not null ,
	id_Cliente char(13)  not null,
	id_cat_pago char(13) not null ,
    id_empleado char(13) not null,
	nmr_Boleta int not null,
	importe_Bruto float not null,
	iGV float not null,
	importe_Neto float not null,
	estado int check(Estado <=2 and  Estado > -1),
    fecha_venta datetime  default now() ,
	primary key (Id_Venta),
	constraint id_cliente foreign key (id_Cliente) references TB_Cliente(id_Cliente) on delete cascade on update cascade,
	constraint id_cat_pago foreign key (id_cat_pago) references TB_Cat_Pago (id_cat_pago) on delete cascade on update cascade,
    constraint id_empleado1 foreign key(id_empleado) references Tb_Empleado (id_empleado) on delete cascade on update cascade);
    
    insert into TB_Documento_Venta values('K010000000001','X000000000002','Q000000000001','V0001',0,3.0,0.1,2.7,0,default);
	    insert into TB_Documento_Venta values('K010000000002','X000000000002','Q000000000001','V0001',0,3.0,0.1,2.7,0,default);

	-- Tabla Detalle Documento de Venta

	create table TB_Detalle_Doc_venta(
	id_detalle char(13)  not null ,
	id_producto char(13) not null,
	id_venta char(13) not null,
	precio_venta float not null,	
	cantidad int not null,
    primary key (id_Detalle),
    constraint id_producto1 foreign key (id_producto) references TB_Producto(id_producto) on delete cascade on update cascade,
    constraint id_venta1 foreign key (id_venta) references TB_Documento_Venta(id_venta)on delete cascade on update cascade) ;
    
	insert into TB_Detalle_Doc_venta values('W010000000001','P000000000001','K010000000001',3.0,3);
    
    select * from TB_Documento_Venta order by id_Venta desc LIMIT 1 ;
    select * from TB_Documento_Venta;
    select * from TB_Detalle_Doc_venta;

	









