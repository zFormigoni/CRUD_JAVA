CREATE database projeto;

CREATE TABLE cadusuarios (

idcadusuario SERIAL PRIMARY KEY,
dcr_usuario varchar(45) NOT NULL,
dcr_login varchar(45) NOT NULL,
dcr_senha varchar(255) NOT NULL,
dat_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
dat_desativacao TIMESTAMP DEFAULT NULL);