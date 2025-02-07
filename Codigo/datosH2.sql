-- Inicio del script de inserción de datos
-- Crear el usuario administrador
INSERT INTO usuario (nombre, email, rol, contraseña) VALUES
('Admin Usuario', 'admin@ejemplo.com', 'admin', 'contraseña_segura');

-- Crear el usuario normal
INSERT INTO usuario (nombre, email, rol, contraseña) VALUES
('Jugador 1', 'jugador1@ejemplo.com', 'usuario', 'contraseña_segura');
-- Insertar categoríascategoria
INSERT INTO categoria (nombre, descripcion) VALUES
('Historia', 'Preguntas relacionadas con eventos históricos y personajes importantes.'),
('Ciencia', 'Preguntas sobre temas científicos como física, química y biología.'),
('Geografía', 'Preguntas sobre países, continentes, ríos y montañas.'),
('Deportes', 'Preguntas sobre deportes y atletas famosos.');

-- Obtener el ID de la categoría "Deportes"
SET @categoria_deportes = (SELECT id FROM categoria WHERE nombre = 'Deportes');

-- Insertar preguntas y respuestas para la categoría "Deportes"

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el máximo goleador histórico de la NBA?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('LeBron James', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Kobe Bryant', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Kareem Abdul-Jabbar', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Michael Jordan', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué deporte se utiliza una pelota llamada "balón"?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Fútbol', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Tenis', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Golf', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Boxeo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el torneo de tenis más antiguo del mundo?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Abierto de Australia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Roland Garros', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Wimbledon', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('US Open', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el equipo más ganador en la historia de la Champions League?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Barcelona', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bayern Múnich', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Real Madrid', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Liverpool', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién ganó la Copa Mundial de Fútbol en 2018?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Alemania', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Brasil', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Francia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Argentina', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el récord mundial de los 100 metros planos?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('9.69 segundos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('9.58 segundos', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('9.72 segundos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('9.81 segundos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué equipo tiene más títulos en la Fórmula 1?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Ferrari', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Mercedes', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Red Bull', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('McLaren', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es conocido como "La Bestia Negra" en el boxeo?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Muhammad Ali', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Mike Tyson', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Joe Louis', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('George Foreman', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte nacional de Japón?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Sumo', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Karate', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Judo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Kendo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebró la primera Copa del Mundo de Fútbol?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1930', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1934', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1938', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1950', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte más practicado en India?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Fútbol', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Baloncesto', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Críquet', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hockey sobre hierba', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién ganó el Abierto de Australia de tenis en 2023 (masculino)?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Novak Djokovic', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Rafael Nadal', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Daniil Medvedev', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Stefanos Tsitsipas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el equipo más exitoso en la NBA?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Los Angeles Lakers', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Boston Celtics', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Chicago Bulls', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Golden State Warriors', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se fundó la FIFA?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1895', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1904', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1910', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1920', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el récord mundial de salto de longitud?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('8.79 metros', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('8.95 metros', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('8.85 metros', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('8.65 metros', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué país ha ganado más medallas olímpicas en la historia?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Estados Unidos', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Rusia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('China', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Alemania', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es conocido como "La Pantera Negra" en el boxeo?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Muhammad Ali', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Joe Frazier', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Emile Griffith', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Emmanuel Steward', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte nacional de Brasil?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Capoeira', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Fútbol', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Voleibol', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Jiu-jitsu', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebró la primera Olimpiada moderna?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1896', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1900', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1904', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1908', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el máximo goleador histórico de la selección brasileña de fútbol?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Pelé', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ronaldo Nazário', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Romário', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Neymar', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte más antiguo del mundo?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Lucha libre', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Atletismo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Natación', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Tiro con arco', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el jugador de tenis con más títulos de Grand Slam en la historia?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Roger Federer', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Rafael Nadal', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Novak Djokovic', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Pete Sampras', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebró la primera Copa América de fútbol?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1916', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1920', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1930', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1940', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué país ha ganado más Copas del Mundo de rugby?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Nueva Zelanda', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Sudáfrica', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Australia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Inglaterra', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el récord mundial de los 400 metros planos?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('43.03 segundos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('43.18 segundos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('43.49 segundos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('43.09 segundos', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es conocido como "El Kaiser" en el fútbol alemán?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Franz Beckenbauer', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lothar Matthäus', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Gerd Müller', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Oliver Kahn', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el equipo más exitoso en la Liga de Campeones de la UEFA?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Real Madrid', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('AC Milan', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bayern Múnich', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Liverpool', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebraron los primeros Juegos Olímpicos de Invierno?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1924', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1928', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1932', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1936', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el máximo goleador histórico de la selección argentina de fútbol?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Diego Maradona', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Gabriel Batistuta', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lionel Messi', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Héctor Scarone', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte nacional de Canadá?', @categoria_deportes);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Fútbol', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Baloncesto', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hockey sobre hielo', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lacrosse', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));


-- Geografia
-- Obtener el ID de la categoría "Geografía"
SET @categoria_geografia = (SELECT id FROM categoria WHERE nombre = 'Geografía');

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el río más largo del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Amazonas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Nilo', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Yangtsé', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Misisipi', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país más grande del mundo en términos de superficie?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Canadá', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('China', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Rusia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Estados Unidos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué océano separa América de Europa?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Índico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Pacífico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Atlántico', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ártico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es la capital de Australia?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Sidney', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Melbourne', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Canberra', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Brisbane', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el continente más grande?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('América', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Asia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('África', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Europa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el punto más bajo de la Tierra?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Mar Muerto', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lago Titicaca', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Cañón del Colorado', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Fosa de las Marianas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el desierto más grande del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Sahara', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Gobi', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Desierto de Kalahari', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Antártida', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el lago más profundo del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Lago Baikal', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lago Victoria', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lago Superior', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lago Tanganyika', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el monte más alto del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Monte Everest', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('K2', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Monte Kilimanjaro', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Monte McKinley', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país que tiene más islas?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Indonesia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Filipinas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Suecia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Japón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el océano más profundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Océano Índico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Océano Atlántico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Océano Pacífico', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Océano Ártico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país más pequeño del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Mónaco', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Maldivas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('San Marino', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ciudad del Vaticano', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el río más caudaloso del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Amazonas', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Nilo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Yangtsé', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Misisipi', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el continente menos poblado?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Oceanía', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Antártida', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('África', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Europa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más fronteras terrestres?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('China', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Rusia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('India', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Brasil', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Obtener el ID de la categoría "Geografía"
SET @categoria_geografia = (SELECT id FROM categoria WHERE nombre = 'Geografía');

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más habitantes del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('India', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('China', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Estados Unidos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Indonesia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el desierto más árido del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Desierto de Atacama', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Sahara', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Gobi', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Kalahari', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el lago más grande del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Lago Superior', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lago Victoria', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Mar Caspio', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Lago Tanganyika', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el océano más grande del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Océano Índico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Océano Atlántico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Océano Pacífico', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Océano Ártico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más idiomas oficiales?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('India', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Suiza', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Canadá', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bélgica', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el continente menos extenso?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Oceanía', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Antártida', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Europa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('África', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el río más largo de Europa?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Rin', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Volga', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Támesis', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Danubio', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más lagos en el mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Canadá', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Noruega', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Finlandia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Suecia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el volcán más alto del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Monte Fuji', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Mauna Kea', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Vesuvio', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Krakatoa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más montañas altas del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Nepal', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Argentina', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Canadá', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Australia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más kilómetros de costa?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Indonesia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Australia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Rusia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Canadá', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más selva tropical?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Brasil', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Congo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Indonesia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Perú', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más glaciares?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Groenlandia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Antártida', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Canadá', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Nueva Zelanda', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más islas habitadas?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Filipinas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Indonesia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Japón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Suecia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el país con más zonas horarias?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Rusia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Estados Unidos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Australia', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('China', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));



-- Obtener el ID de la categoría "Ciencia"
SET @categoria_ciencia = (SELECT id FROM categoria WHERE nombre = 'Ciencia');

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué científico formuló la teoría de la relatividad?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Isaac Newton', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Albert Einstein', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Nikola Tesla', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Galileo Galilei', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el elemento más abundante en el universo?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Oxígeno', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hidrógeno', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Helio', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Carbono', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el órgano principal del sistema nervioso?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Corazón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Pulmón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Cerebro', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hígado', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué gas es responsable del efecto invernadero?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Dióxido de carbono', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Oxígeno', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Nitrógeno', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Argón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es la unidad básica de la vida?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Molécula', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Célula', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Átomo', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Proteína', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué planeta del sistema solar tiene el mayor número de lunas?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Tierra', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Júpiter', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Saturno', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Urano', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué descubrió Marie Curie?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Electricidad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Radioactividad', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Gravedad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Fotosíntesis', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el proceso por el cual las plantas producen su propio alimento?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Respiración', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Fotosíntesis', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Digestión', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Absorción', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el ácido presente en el ADN?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Ácido cítrico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ácido desoxirribonucleico', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ácido láctico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ácido sulfúrico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué inventó Thomas Edison?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Teléfono', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bombilla eléctrica', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Avión', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Automóvil', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué causa las mareas?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Rotación de la Tierra', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Atracción gravitatoria de la Luna', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Viento', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Temperatura', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un isótopo?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Un tipo de molécula', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un átomo con diferente número de neutrones', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un compuesto químico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una célula especializada', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué descubrió Isaac Newton?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Leyes de la termodinámica', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Leyes del movimiento', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Teoría cuántica', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Energía nuclear', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un neutrón?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Una partícula con carga positiva', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una partícula sin carga', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una partícula con carga negativa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una molécula', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un exoplaneta?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Un planeta fuera del sistema solar', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un satélite natural', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un cometa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una estrella', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Obtener el ID de la categoría "Ciencia"
SET @categoria_ciencia = (SELECT id FROM categoria WHERE nombre = 'Ciencia');

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un fotón?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Una partícula de luz', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una molécula de agua', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un tipo de célula', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un compuesto químico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el proceso por el cual los minerales reemplazan los tejidos orgánicos en los fósiles?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Petrificación', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Descomposición', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Fosilización', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Congelación', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué descubrió Dmitri Mendeléyev?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('La tabla periódica', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La electricidad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La gravedad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('El ADN', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un semiconductor?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Un material que conduce parcialmente la electricidad', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un material que no conduce electricidad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un material que conduce completamente la electricidad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un compuesto químico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el órgano principal del sistema respiratorio?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Corazón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Pulmón', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hígado', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Riñón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué causa las mutaciones genéticas?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Radiación', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Alimentación saludable', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Ejercicio físico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Sueño adecuado', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un ácido?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Una sustancia que libera iones hidrógeno en solución', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una sustancia que libera iones hidroxilo en solución', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una sustancia que no reacciona químicamente', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una sustancia que conduce electricidad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué inventó Alexander Graham Bell?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Teléfono', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bombilla eléctrica', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Automóvil', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Avión', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un electrón?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Una partícula con carga negativa', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una partícula con carga positiva', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una partícula sin carga', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una molécula', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un ecossistema?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Un grupo de organismos vivos interactuando entre sí y con su entorno', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un solo organismo viviendo en un ambiente', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una comunidad de plantas solamente', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un laboratorio científico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un neutrino?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Una partícula subatómica casi sin masa', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una molécula de oxígeno', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una célula especializada', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un compuesto químico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un catalizador?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Una sustancia que acelera una reacción química sin consumirse', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una sustancia que ralentiza una reacción química', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una sustancia que detiene una reacción química', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una sustancia que produce energía', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un gen?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Un segmento de ADN que codifica una proteína', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una molécula de glucosa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Una célula nerviosa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un tipo de hormona', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué es un superconductor?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Un material que conduce electricidad sin resistencia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un material que no conduce electricidad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un material que conduce calor', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Un compuesto químico', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué descubrió Louis Pasteur?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('La teoría de la evolución', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La pasteurización', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La relatividad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La gravedad', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Obtener el ID de la categoría "Historia"
SET @categoria_historia = (SELECT id FROM categoria WHERE nombre = 'Historia');

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año comenzó la Primera Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1914', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1918', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1939', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1945', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el líder soviético durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Mijaíl Gorbachov', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Vladimir Lenin', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('José Stalin', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Nikita Kruschev', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año cayó el Muro de Berlín?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1989', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1990', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1991', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1985', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál fue la causa principal de la Revolución Francesa?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Desigualdad social', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Invasión extranjera', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Guerra civil', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Peste negra', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién escribió "La Divina Comedia" en el siglo XIV?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Dante Alighieri', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('William Shakespeare', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Miguel de Cervantes', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Leonardo da Vinci', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se firmaron los Acuerdos de Paz de Westfalia?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1648', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1789', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1815', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1919', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el primer emperador romano?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Julio César', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Marco Antonio', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Augusto', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Trajano', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año comenzó la Revolución Industrial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1760', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1840', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1900', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1600', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué evento marcó el inicio de la Guerra Fría?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('La caída del Imperio Otomano', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('El fin de la Segunda Guerra Mundial', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La invasión de Normandía', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La firma del Tratado de Versalles', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el líder nazi durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Benito Mussolini', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Adolf Hitler', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Joseph Goebbels', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hermann Göring', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se produjo la Revolución Rusa?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1917', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1920', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1914', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1918', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el primer presidente de Estados Unidos?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Thomas Jefferson', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('George Washington', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Abraham Lincoln', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('John Adams', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se inauguró la Torre Eiffel?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1889', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1900', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1875', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1920', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué documento estableció los derechos fundamentales en Inglaterra en 1215?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('La Declaración de Derechos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La Constitución', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La Magna Carta', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Los Derechos Humanos', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se descubrió América por Cristóbal Colón?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1492', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1500', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1485', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1520', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Obtener el ID de la categoría "Historia"
SET @categoria_historia = (SELECT id FROM categoria WHERE nombre = 'Historia');

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se firmó el Tratado de Versalles?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1918', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1919', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1920', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1921', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el líder británico durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Winston Churchill', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Benito Mussolini', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Franklin D. Roosevelt', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Joseph Stalin', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se produjo la caída del Imperio Romano de Occidente?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('410 d.C.', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('476 d.C.', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('533 d.C.', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('600 d.C.', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué evento marcó el inicio de la Edad Moderna?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('La Caída de Constantinopla', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La Revolución Industrial', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La Reforma Protestante', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La Conquista de América', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién escribió "El Príncipe", un tratado sobre el poder político?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Miguel de Cervantes', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Maquiavelo', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('William Shakespeare', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Francisco Pizarro', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año comenzó la Guerra Civil Española?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1931', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1936', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1939', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1945', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el primer emperador chino en unificar China bajo un solo gobierno?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Confucio', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Emperador Qin Shi Huang', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Genghis Khan', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Emperador Kangxi', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se disolvió la Unión Soviética?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1989', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1990', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1991', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1992', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál fue la causa principal de la Guerra de Secesión Estadounidense?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('La independencia de los estados', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La abolición de la esclavitud', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La expansión territorial', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('La economía industrial', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se inauguró el Canal de Panamá?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1900', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1914', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1920', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1930', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el líder de la Resistencia francesa durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Charles de Gaulle', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Adolf Hitler', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Benito Mussolini', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Joseph Stalin', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se produjo la Revolución Francesa?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1776', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1789', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1848', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1871', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién fue el primer presidente de la República Argentina?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Juan Manuel de Rosas', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bartolomé Mitre', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Bernardino Rivadavia', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Domingo Faustino Sarmiento', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1945', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1950', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1960', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('1970', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién lideró la expedición que descubrió el Pacífico?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Cristóbal Colón', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Fernando de Magallanes', TRUE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Hernán Cortés', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1)),
('Vasco Núñez de Balboa', FALSE, (SELECT id FROM pregunta ORDER BY id DESC LIMIT 1));

-- Simulación de una partida para el jugador con ID 2 (Jugador 1)
SET @usuario_id = 2;
-- Establecer la fecha de inicio
SET @fecha_inicio = CURRENT_TIMESTAMP;

-- Calcular la fecha de fin añadiendo 20 minutos
SET @fecha_fin = DATEADD(MINUTE, 20, @fecha_inicio);

-- Suponiendo que el jugador respondió correctamente 15 preguntas
SET @puntuacion = 15;
-- Crear la partida
INSERT INTO partida (usuario_id, fecha_inicio, fecha_fin, puntuacion)
VALUES (@usuario_id, @fecha_inicio, @fecha_fin, @puntuacion);

-- Obtener el ID de la última partida insertada
SET @partida_id = (SELECT id FROM partida ORDER BY id DESC LIMIT 1);

-- Simular respuestas para 20 preguntas (5 de cada categoría)
-- Categoría 1 (Ejemplo: Geografía)
-- Pregunta 1
INSERT INTO usuario_pregunta_partida (usuario_id, pregunta_id, partida_id, acertada)
VALUES (@usuario_id, 1, @partida_id, TRUE),  -- Correcta
       (@usuario_id, 2, @partida_id, FALSE), -- Incorrecta
       (@usuario_id, 3, @partida_id, FALSE), -- Incorrecta
       (@usuario_id, 4, @partida_id, FALSE), -- Incorrecta
       (@usuario_id, 5, @partida_id, FALSE); -- Incorrecta

-- Categoría 2 (Ejemplo: Historia)
-- Pregunta 6
INSERT INTO usuario_pregunta_partida (usuario_id, pregunta_id, partida_id, acertada)
VALUES (@usuario_id, 6, @partida_id, TRUE),  -- Correcta
       (@usuario_id, 7, @partida_id, FALSE),
       (@usuario_id, 8, @partida_id, FALSE),
       (@usuario_id, 9, @partida_id, FALSE),
       (@usuario_id, 10, @partida_id, FALSE);

-- Categoría 3 (Ejemplo: Ciencia)
-- Pregunta 11
INSERT INTO usuario_pregunta_partida (usuario_id, pregunta_id, partida_id, acertada)
VALUES (@usuario_id, 11, @partida_id, TRUE),  -- Correcta
       (@usuario_id, 12, @partida_id, FALSE),
       (@usuario_id, 13, @partida_id, FALSE),
       (@usuario_id, 14, @partida_id, FALSE),
       (@usuario_id, 15, @partida_id, FALSE);

-- Categoría 4 (Ejemplo: Arte)
-- Pregunta 16
INSERT INTO usuario_pregunta_partida (usuario_id, pregunta_id, partida_id, acertada)
VALUES (@usuario_id, 16, @partida_id, TRUE),  -- Correcta
       (@usuario_id, 17, @partida_id, FALSE),
       (@usuario_id, 18, @partida_id, FALSE),
       (@usuario_id, 19, @partida_id, FALSE),
       (@usuario_id, 20, @partida_id, FALSE);