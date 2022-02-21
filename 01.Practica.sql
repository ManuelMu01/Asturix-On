Hola Manu, soy Hector

-- Creamos la BD
drop database if exists tienda_libros;
create database if not exists tienda_libros;
-- Indicamos que BD vamos a usar
use tienda_libros;
-- ----------------------------
-- Cración de tablas

-- Creacion de tabla estanterias
create table estanterias  (
	est_codest int,
	est_ubicacion varchar(90) not null,
    primary key EST_PK (est_codest)
);

-- Creación de tabla libros
create table libros (
	lib_isbn varchar(20),
    lib_titulo varchar(45) not null,
    lib_autor varchar(90) not null,
    lib_edicion varchar(45) not null,
    lib_categoria varchar(45) not null,
    lib_codest int not null, 
	primary key LIB_PK (lib_isbn)
    -- foreign key LIB_EST_FK (lib_codest) references estanterias (est_codest) 
);

-- Tabla capitulos
create table capitulos (
	cap_codcap int,
    cap_numero int not null,
    cap_titulo varchar(45) not null,
    cap_contenido varchar(12000) not null,
    cap_isbn varchar (20) not null,
    primary key CAP_PK (cap_isbn)
    -- foreign key CAP_LIB_FK (cap_isbn) references libros (lib_isbn)
);

-- Renombrar la tabla capitulos a chapters
alter table capitulos rename to chapters;
-- Añadir columna
alter table estanterias add column est_color varchar(20);
-- Eliminar columna
alter table estanterias drop column est_color;
-- Modificar tipo columna
alter table estanterias modify column est_ubicacion varchar(110) not null;
-- Renombrar una tabla
alter table estanterias change est_ubicacion est_lugar varchar(110) not null;

-- Creamos las FKs
alter table libros add foreign key LIB_ESC_FK (lib_codest) references estanterias (est_codest);
alter table capitulos add foreign key CAP_LIB_FK (cap_isbn) references libros (lib_isbn);

