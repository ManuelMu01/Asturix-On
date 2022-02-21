Hola Manu, soy Hector

-- Creamos la BD
drop database if exists parque_tematico;
create database if not exists parque_tematico;
-- Indicamos qué BD vamos a utilizar
use parque_tematico;

-- --------------------------------
-- Creamos las tablas por orden
-- Empleados
create table empleados (
	emp_codemp int primary key,
    emp_nombre varchar(45) not null,
    emp_apellidos varchar(150) not null
);
-- Turnos
create table turnos (
	tur_codatr int,
    tur_codemp int,
    tur_inicio datetime,
    tur_fin datetime not null,
    primary key (tur_codatr, tur_codemp, tur_inicio)
);
