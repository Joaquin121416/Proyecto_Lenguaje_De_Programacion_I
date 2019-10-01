
CREATE DATABASE BD_Partidos;

use BD_Partidos;

Create Table TB_Partido
(IdPartido int(4),
NombrePartido varchar(50),
 primary key(IdPartido)
 
);
	create table TB_Candidato(
	IdCandidato char(4) not null ,
	NombreCandidato varchar (100) not null,
	ApellidoCandidato varchar (500) not null,
    AñoDeRegistro int(4)not null,
	IdPartido int(4) not null,
    primary key(IdCandidato),
    constraint IdPartido foreign key (IdPartido) references TB_Partido(IdPartido)
    );
    
    insert into TB_Partido values(0001,'PPC');

