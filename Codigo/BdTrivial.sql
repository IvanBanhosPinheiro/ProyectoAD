-- Crear la base de datos
drop  DATABASE if exists trivial;
CREATE DATABASE if not exists trivial;
USE trivial;

-- Crear la tabla usuario
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    email varchar(50) UNIQUE NOT NULL,
    contraseña TEXT NOT NULL,
    rol ENUM('admin', 'usuario') NOT NULL
);

-- Crear la tabla categoria
CREATE TABLE categoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50) NOT NULL
);

-- Crear la tabla pregunta
CREATE TABLE pregunta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    texto varchar(250) NOT NULL,
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Crear la tabla respuesta
CREATE TABLE respuesta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    texto varchar(250) NOT NULL,
    es_correcta BOOLEAN NOT NULL,
    pregunta_id BIGINT,
    FOREIGN KEY (pregunta_id) REFERENCES pregunta(id)
);

-- Crear la tabla partida
CREATE TABLE partida (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_inicio TIMESTAMP NOT NULL,
    fecha_fin TIMESTAMP,
    puntuación INT,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Crear la tabla usuario_pregunta
CREATE TABLE usuario_pregunta_partida (
    usuario_id BIGINT,
    pregunta_id BIGINT,
    partida_id BIGINT,
    acertada BOOLEAN NOT NULL,
    PRIMARY KEY (usuario_id, pregunta_id, partida_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (pregunta_id) REFERENCES pregunta(id),
    FOREIGN KEY (partida_id) REFERENCES partida(id)
);

