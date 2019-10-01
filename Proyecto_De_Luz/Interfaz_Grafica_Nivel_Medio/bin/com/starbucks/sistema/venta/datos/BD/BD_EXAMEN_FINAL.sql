-- Base de Datos : Base de Datos Escuela--
-- Author : Joaquin Cunorana Jimenez --
drop database  if EXISTS BD_EXAMEN;
create database BD_EXAMEN;

Use BD_EXAMEN;


 create table tb_escuela
 (codEsc int primary key,
  nomEsc varchar(45)
 );

 CREATE table tb_alumno
 (
 codAlu int primary key,
 nomAlu  varchar(60),
 apeAlu varchar(60),
 codEscFr1 int references tb_escuela(codEsc),
 codCurFr0 int references tb_curso(codCur)
 
 );
 
 
 create table tb_curso
 (codCur int primary key,
  nomCur varchar(45) UNIQUE,
  codEscFr2 int references tb_escuela(codEsc)
 );
 
 
insert into tb_alumno values(74732990,'Joaquin','Cunorana',1,1);
insert into tb_alumno values(74732991,'Nelson','Uribe',1,2);
insert into tb_alumno values(74732992,'Juan','Perez',2,7);
-- Escuela --
insert into tb_escuela values(1,'TECNOLOGIA');
insert into tb_escuela values(2,'DISEÑO');
-- Cursos --
	-- TECNOLOGIA --
insert into tb_curso values(1,'PROGRAMACION JAVA',1);
insert into tb_curso values(2,'ANGULAR 8',1);
insert into tb_curso values(3,'C# MVC',1);
insert into tb_curso values(4,'SPRING BOOT',1);
insert into tb_curso values(5,'DOCKER',1);
	-- DISEÑO --
insert into tb_curso values(6,'DIBUJO',2);
insert into tb_curso values(7,'DIBUJO 2',2);
insert into tb_curso values(8,'DIBUJO 3',2);
insert into tb_curso values(9,'DIBUJO 4',2);
insert into tb_curso values(10,'DIBUJO 5',2);

	
select * from tb_alumno;


/*
							   ......               
                            .:||||||||:.            
                           /            \           
                          (   o      o   )          
                --@@@@----------:  :----------@@@@--
					Profe mi logica fue que un
					alumno al pertenecer a una 
                    escuela tendria los cursos 
                    de esa escuela por eso profe
                    listo los alumnos por escuela 
                    y salen sus cursos
										
 */
select * from tb_alumno
select * from tb_escuela

delimiter @@
create procedure ListaEscuela(cod int)
begin
	SELECT	tb_alumno.codAlu,
			tb_alumno.nomAlu,
			tb_alumno.apeAlu,
			tb_escuela.nomEsc,
		    tb_curso.nomCur FROM 
            tb_alumno inner join tb_escuela 
            on tb_alumno.codEscFr1=tb_escuela.codEsc inner join tb_curso on tb_alumno.codCurFr0=tb_curso.codCur  WHERE tb_alumno.codEscFr1 = cod  ;
end @@
delimiter ;

call ListaEscuela(1);


delimiter @@
create procedure ListarEscuelas()
begin
	SELECT	tb_escuela.nomEsc from tb_escuela;
end @@
delimiter ;

call ListarEscuelas();


delimiter @@
create procedure BuscarCodEsc(nom varchar(50))
begin
	SELECT	tb_escuela.codEsc from tb_escuela where tb_escuela.nomEsc=nom;
end @@
delimiter ;

call BuscarCodEsc('TECNOLOGIA');
/*
 codAlu int primary key,
 nomAlu  varchar(45),
 apeAlu varchar(60),
 codEscFr1 int references tb_escuela(codEsc),
 codCurFr0 int references tb_curso(codCur)
 */
 delimiter @@
create procedure AgregarAlumno(in cod int ,in nom varchar(45),in ape varchar(60),in codEsc int,in CodCur int)
begin
	insert into tb_alumno values(cod,nom,ape,codEsc,CodCur);
end @@
delimiter ;
call AgregarAlumno(74732890,'Sergio','Estrada',2,8)

 
 delimiter @@
create procedure ListarCursos(cur int)
begin
	SELECT	tb_curso.nomCur from tb_curso where tb_curso.codEscFr2=cur;
end @@
delimiter ;

call ListarCursos(1);


delimiter @@
create procedure BuscarCodCur(nom varchar(50))
begin
	SELECT	tb_curso.codCur from tb_curso where tb_curso.nomCur=nom;
end @@
delimiter ;

call BuscarCodCur('DOCKER');