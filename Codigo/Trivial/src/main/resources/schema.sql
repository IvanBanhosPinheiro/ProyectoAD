
drop table if exists usuario_pregunta_partida;
drop table if exists partida;
drop table if exists respuesta;
drop table if exists pregunta;
drop table if exists categoria;
drop table if exists usuario;

-- Crear la tabla usuario
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    email varchar(50) UNIQUE NOT NULL,
    contraseña TEXT NOT NULL,
    rol ENUM('admin', 'usuario') NOT NULL
);

-- Crear la tabla categoria con el campo 'descripcion' como VARCHAR(255)
CREATE TABLE IF NOT EXISTS categoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NULL, -- Campo para describir la categoría
    UNIQUE (nombre) -- Opcional: asegura que no haya nombres duplicados en las categorías
);

-- Crear la tabla pregunta
CREATE TABLE IF NOT EXISTS pregunta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    texto varchar(250) NOT NULL,
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Crear la tabla respuesta
CREATE TABLE IF NOT EXISTS respuesta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    texto varchar(250) NOT NULL,
    es_correcta BOOLEAN NOT NULL,
    pregunta_id BIGINT,
    FOREIGN KEY (pregunta_id) REFERENCES pregunta(id)
);

-- Crear la tabla partida
CREATE TABLE  IF NOT EXISTS partida (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    puntuacion INT,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Crear la tabla usuario_pregunta
CREATE TABLE IF NOT EXISTS usuario_pregunta_partida (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario_id BIGINT,
    pregunta_id BIGINT,
    partida_id BIGINT,
    acertada BOOLEAN NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (pregunta_id) REFERENCES pregunta(id),
    FOREIGN KEY (partida_id) REFERENCES partida(id)
);

