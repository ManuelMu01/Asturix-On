-- Creamos la BD
create database if not exists musica;

-- indicamos que vamos a trabajar con la BD musica
use musica;

create table concientos (
con_codcon int unsigned primary key,
con_fecha datetime not null,
con_direccion varchar(120) not null,
con_codpai varchar(2) not null,
con_codciu int not null
);

create table paises (
pai_codpai varchar(2) primary key,
pai_nombre varchar(75) not null
);

create table ciudades (
ciu_codciu int unsigned primary key,
ciu_nombre varchar(75),
ciu_codpai varchar(2)
);

create table generos (
gen_codgen int unsigned primary key,
gen_nombre varchar(45) not null,
gen_descripcion varchar(255) 
); 

create table actuaciones (
act_codcon int unsigned,
act_codart int unsigned,
primary key (act_codcon, act_codart)
);

create table discograficas (
dis_coddis int unsigned primary key,
dis_nombre varchar(75) not null,
dis_codpai varchar(2) not null
);

create table artistas (
art_codart int unsigned primary key,
art_nombre varchar(90) not null,
art_apellidos varchar(90),
art_nacimiento  date not null,
art_codpai varchar(2) not null
);

create table canciones (
can_codcan int unsigned primary key,
can_titulo varchar(90) not null,
can_codalb int unsigned not null,
can_codaart int unsigned not null,
can_codagen int unsigned not null
);

create table albumes (
alb_codalb int unsigned primary key,
alb_titulo varchar(90) not null,
alb_codart int unsigned not null,
alb_coddis int unsigned not null
);

-- creamos las FK
-- --------------
alter table conciertos add foreign key CON_PAI_FK (con_codpai) references paises (pai_codpais);
alter table ciudades add foreign key CIU_PAI_FK (ciu_codpai) references paises (pai_codpai);
alter table conciertos add foreign key CON_CIU_FK (con_codciu) references ciudades (ciu_codciu);
alter table discograficas add foreign key DIS_PAI_FK (dis_codciu) references paises (pai_codpai);
alter table artistas add foreign key ART_PAI_FK (art_codpai) references paises (pai_codpai);
alter table albumes add foreign key ALB_dis_FK (arb_coddis) references discograficas (dis_coddis);
alter table albumes add foreign key ALB_ART_FK (alb_codart) references artistas (art_codart);
alter table canciones add foreign key CAN_ALB_FK (can_codalb) references albumes (alb_codalb);
alter table canciones add foreign key CAN_ART_FK (can_codart) references artistas (art_codart);
alter table canciones add foreign key 	CAN_GEN_FK (can_codgen) references generos (gen_codgen);
alter table actuaciones add foreign key ACT_CON_FK (act_codcon) references conciertos (con_codcon);
alter table actuaciones add foreign key ACT_ART_FK (act_codart) references artistas (art_codart);
