drop database if exists bd_taller_monolithic;

create database bd_taller_monolithic;

use bd_taller_monolithic;

drop table if exists Instructor;

Create table Instructor(
	id_instructor int not null auto_increment,
    apellido_paterno varchar(60) not null,
    apellido_materno varchar(60) not null,
    nombre varchar(60) not null,
    numero_documento varchar(20) not null,
    correo varchar(60) not null,
    telefono varchar(20) not null,
	resumen text not null,
    fecha_registro datetime default now(),
    
    estado char(1) default 1,
    
    CONSTRAINT pk_instructor PRIMARY KEY(id_instructor)
);

insert into instructor (apellido_materno, apellido_paterno,nombre, numero_documento,correo, telefono, resumen) 
 values ('Salvador', 'Paucar', 'Miguel', '40567845', 'msalvador@galaxy.edu.pe', '+51949947687','Especialista en NET y AWS'),
('Hijar', 'Santa Maria', 'Cesar', '40567899','chijar@galaxy.edu.pe', '+51949944422', 'Especialista en Oracle Database y Business Intelligence'),
( 'Arostedgui', 'Agunza', 'Erick', '78417845', 'earostegui@galaxy.edu.pe', '+51978457687','Especialista en NET y DevOps');
 
 select * from instructor;
 