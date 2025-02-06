-- Inicio del script de inserción de datos

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

-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();

INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('LeBron James', FALSE, @pregunta_id),
('Kobe Bryant', FALSE, @pregunta_id),
('Kareem Abdul-Jabbar', TRUE, @pregunta_id),
('Michael Jordan', FALSE, @pregunta_id);

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué deporte se utiliza una pelota llamada "balón"?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Fútbol', TRUE, @pregunta_id),
('Tenis', FALSE, @pregunta_id),
('Golf', FALSE, @pregunta_id),
('Boxeo', FALSE, @pregunta_id);

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el torneo de tenis más antiguo del mundo?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Abierto de Australia', FALSE, LAST_INSERT_ID()),
('Roland Garros', FALSE, @pregunta_id),
('Wimbledon', TRUE, @pregunta_id),
('US Open', FALSE, @pregunta_id);

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el equipo más ganador en la historia de la Champions League?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Barcelona', FALSE, @pregunta_id),
('Bayern Múnich', FALSE, @pregunta_id),
('Real Madrid', TRUE, @pregunta_id),
('Liverpool', FALSE, @pregunta_id);

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién ganó la Copa Mundial de Fútbol en 2018?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Alemania', FALSE, @pregunta_id),
('Brasil', FALSE, @pregunta_id),
('Francia', TRUE, @pregunta_id),
('Argentina', FALSE, @pregunta_id);

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el récord mundial de los 100 metros planos?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('9.69 segundos', FALSE, @pregunta_id),
('9.58 segundos', TRUE, @pregunta_id),
('9.72 segundos', FALSE, @pregunta_id),
('9.81 segundos', FALSE, @pregunta_id);

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué equipo tiene más títulos en la Fórmula 1?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Ferrari', TRUE, @pregunta_id),
('Mercedes', FALSE, @pregunta_id),
('Red Bull', FALSE, @pregunta_id),
('McLaren', FALSE, @pregunta_id);

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es conocido como "La Bestia Negra" en el boxeo?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Muhammad Ali', FALSE, @pregunta_id),
('Mike Tyson', FALSE, @pregunta_id),
('Joe Louis', TRUE, @pregunta_id),
('George Foreman', FALSE, @pregunta_id);

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte nacional de Japón?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Sumo', TRUE, @pregunta_id),
('Karate', FALSE, @pregunta_id),
('Judo', FALSE, @pregunta_id),
('Kendo', FALSE, @pregunta_id);

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebró la primera Copa del Mundo de Fútbol?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1930', TRUE, @pregunta_id),
('1934', FALSE, @pregunta_id),
('1938', FALSE, @pregunta_id),
('1950', FALSE, @pregunta_id);

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte más practicado en India?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Fútbol', FALSE, @pregunta_id),
('Baloncesto', FALSE, @pregunta_id),
('Críquet', TRUE, @pregunta_id),
('Hockey sobre hierba', FALSE, @pregunta_id);

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién ganó el Abierto de Australia de tenis en 2023 (masculino)?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Novak Djokovic', TRUE, @pregunta_id),
('Rafael Nadal', FALSE, @pregunta_id),
('Daniil Medvedev', FALSE, @pregunta_id),
('Stefanos Tsitsipas', FALSE, @pregunta_id);

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el equipo más exitoso en la NBA?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Los Angeles Lakers', TRUE, @pregunta_id),
('Boston Celtics', FALSE, @pregunta_id),
('Chicago Bulls', FALSE, @pregunta_id),
('Golden State Warriors', FALSE, @pregunta_id);

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se fundó la FIFA?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1895', FALSE, @pregunta_id),
('1904', TRUE, @pregunta_id),
('1910', FALSE, @pregunta_id),
('1920', FALSE, @pregunta_id);

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el récord mundial de salto de longitud?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('8.79 metros', FALSE, @pregunta_id),
('8.95 metros', TRUE, @pregunta_id),
('8.85 metros', FALSE, @pregunta_id),
('8.65 metros', FALSE, @pregunta_id);

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué país ha ganado más medallas olímpicas en la historia?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Estados Unidos', TRUE, LAST_INSERT_ID()),
('Rusia', FALSE, @pregunta_id),
('China', FALSE, @pregunta_id),
('Alemania', FALSE, @pregunta_id);

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es conocido como "La Pantera Negra" en el boxeo?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Muhammad Ali', FALSE, @pregunta_id),
('Joe Frazier', FALSE, @pregunta_id),
('Emile Griffith', FALSE, @pregunta_id),
('Emmanuel Steward', TRUE, @pregunta_id);

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte nacional de Brasil?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Capoeira', TRUE, @pregunta_id),
('Fútbol', FALSE, @pregunta_id),
('Voleibol', FALSE, @pregunta_id),
('Jiu-jitsu', FALSE, @pregunta_id);

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebró la primera Olimpiada moderna?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1896', TRUE, @pregunta_id),
('1900', FALSE, @pregunta_id),
('1904', FALSE, @pregunta_id),
('1908', FALSE, @pregunta_id);

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el máximo goleador histórico de la selección brasileña de fútbol?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Pelé', TRUE, @pregunta_id),
('Ronaldo Nazário', FALSE, @pregunta_id),
('Romário', FALSE, @pregunta_id),
('Neymar', FALSE, @pregunta_id);

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte más antiguo del mundo?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Lucha libre', TRUE, @pregunta_id),
('Atletismo', FALSE, @pregunta_id),
('Natación', FALSE, @pregunta_id),
('Tiro con arco', FALSE, @pregunta_id);

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el jugador de tenis con más títulos de Grand Slam en la historia?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Roger Federer', FALSE, @pregunta_id),
('Rafael Nadal', FALSE, @pregunta_id),
('Novak Djokovic', TRUE, @pregunta_id),
('Pete Sampras', FALSE, @pregunta_id);

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebró la primera Copa América de fútbol?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1916', TRUE, @pregunta_id),
('1920', FALSE, @pregunta_id),
('1930', FALSE, @pregunta_id),
('1940', FALSE, @pregunta_id);

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Qué país ha ganado más Copas del Mundo de rugby?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Nueva Zelanda', TRUE, @pregunta_id),
('Sudáfrica', FALSE, @pregunta_id),
('Australia', FALSE, @pregunta_id),
('Inglaterra', FALSE, @pregunta_id);

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el récord mundial de los 400 metros planos?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('43.03 segundos', FALSE, @pregunta_id),
('43.18 segundos', FALSE, @pregunta_id),
('43.49 segundos', FALSE, @pregunta_id),
('43.09 segundos', TRUE, @pregunta_id);

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es conocido como "El Kaiser" en el fútbol alemán?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Franz Beckenbauer', TRUE, @pregunta_id),
('Lothar Matthäus', FALSE, @pregunta_id),
('Gerd Müller', FALSE, @pregunta_id),
('Oliver Kahn', FALSE, @pregunta_id);

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el equipo más exitoso en la Liga de Campeones de la UEFA?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Real Madrid', TRUE, @pregunta_id),
('AC Milan', FALSE, @pregunta_id),
('Bayern Múnich', FALSE, @pregunta_id),
('Liverpool', FALSE, @pregunta_id);

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿En qué año se celebraron los primeros Juegos Olímpicos de Invierno?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('1924', TRUE, @pregunta_id),
('1928', FALSE, @pregunta_id),
('1932', FALSE, @pregunta_id),
('1936', FALSE, @pregunta_id);

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Quién es el máximo goleador histórico de la selección argentina de fútbol?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Diego Maradona', FALSE, @pregunta_id),
('Gabriel Batistuta', FALSE, @pregunta_id),
('Lionel Messi', TRUE, @pregunta_id),
('Héctor Scarone', FALSE, @pregunta_id);

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES 
('¿Cuál es el deporte nacional de Canadá?', @categoria_deportes);
-- Obtener el ID de la pregunta
SET @pregunta_id = SCOPE_IDENTITY();
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES 
('Fútbol', FALSE, @pregunta_id),
('Baloncesto', FALSE, @pregunta_id),
('Hockey sobre hielo', TRUE, @pregunta_id),
('Lacrosse', FALSE, @pregunta_id);


-- Geografia
-- Obtener el ID de la categoría "Geografía"
SET @categoria_geografia = (SELECT id FROM categoria WHERE nombre = 'Geografía');

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el río más largo del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Amazonas', FALSE, LAST_INSERT_ID()),
('Nilo', TRUE, LAST_INSERT_ID()),
('Yangtsé', FALSE, LAST_INSERT_ID()),
('Misisipi', FALSE, LAST_INSERT_ID());

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país más grande del mundo en términos de superficie?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Canadá', FALSE, LAST_INSERT_ID()),
('China', FALSE, LAST_INSERT_ID()),
('Rusia', TRUE, LAST_INSERT_ID()),
('Estados Unidos', FALSE, LAST_INSERT_ID());

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué océano separa América de Europa?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Índico', FALSE, LAST_INSERT_ID()),
('Pacífico', FALSE, LAST_INSERT_ID()),
('Atlántico', TRUE, LAST_INSERT_ID()),
('Ártico', FALSE, LAST_INSERT_ID());

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es la capital de Australia?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Sidney', FALSE, LAST_INSERT_ID()),
('Melbourne', FALSE, LAST_INSERT_ID()),
('Canberra', TRUE, LAST_INSERT_ID()),
('Brisbane', FALSE, LAST_INSERT_ID());

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el continente más grande?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('América', FALSE, LAST_INSERT_ID()),
('Asia', TRUE, LAST_INSERT_ID()),
('África', FALSE, LAST_INSERT_ID()),
('Europa', FALSE, LAST_INSERT_ID());

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el punto más bajo de la Tierra?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Mar Muerto', TRUE, LAST_INSERT_ID()),
('Lago Titicaca', FALSE, LAST_INSERT_ID()),
('Cañón del Colorado', FALSE, LAST_INSERT_ID()),
('Fosa de las Marianas', FALSE, LAST_INSERT_ID());

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el desierto más grande del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Sahara', FALSE, LAST_INSERT_ID()),
('Gobi', FALSE, LAST_INSERT_ID()),
('Desierto de Kalahari', FALSE, LAST_INSERT_ID()),
('Antártida', TRUE, LAST_INSERT_ID());

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el lago más profundo del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Lago Baikal', TRUE, LAST_INSERT_ID()),
('Lago Victoria', FALSE, LAST_INSERT_ID()),
('Lago Superior', FALSE, LAST_INSERT_ID()),
('Lago Tanganyika', FALSE, LAST_INSERT_ID());

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el monte más alto del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Monte Everest', TRUE, LAST_INSERT_ID()),
('K2', FALSE, LAST_INSERT_ID()),
('Monte Kilimanjaro', FALSE, LAST_INSERT_ID()),
('Monte McKinley', FALSE, LAST_INSERT_ID());

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país que tiene más islas?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Indonesia', FALSE, LAST_INSERT_ID()),
('Filipinas', FALSE, LAST_INSERT_ID()),
('Suecia', TRUE, LAST_INSERT_ID()),
('Japón', FALSE, LAST_INSERT_ID());

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el océano más profundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Océano Índico', FALSE, LAST_INSERT_ID()),
('Océano Atlántico', FALSE, LAST_INSERT_ID()),
('Océano Pacífico', TRUE, LAST_INSERT_ID()),
('Océano Ártico', FALSE, LAST_INSERT_ID());

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país más pequeño del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Mónaco', FALSE, LAST_INSERT_ID()),
('Maldivas', FALSE, LAST_INSERT_ID()),
('San Marino', FALSE, LAST_INSERT_ID()),
('Ciudad del Vaticano', TRUE, LAST_INSERT_ID());

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el río más caudaloso del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Amazonas', TRUE, LAST_INSERT_ID()),
('Nilo', FALSE, LAST_INSERT_ID()),
('Yangtsé', FALSE, LAST_INSERT_ID()),
('Misisipi', FALSE, LAST_INSERT_ID());

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el continente menos poblado?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Oceanía', TRUE, LAST_INSERT_ID()),
('Antártida', FALSE, LAST_INSERT_ID()),
('África', FALSE, LAST_INSERT_ID()),
('Europa', FALSE, LAST_INSERT_ID());

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más fronteras terrestres?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('China', FALSE, LAST_INSERT_ID()),
('Rusia', TRUE, LAST_INSERT_ID()),
('India', FALSE, LAST_INSERT_ID()),
('Brasil', FALSE, LAST_INSERT_ID());

-- Obtener el ID de la categoría "Geografía"
SET @categoria_geografia = (SELECT id FROM categoria WHERE nombre = 'Geografía');

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más habitantes del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('India', FALSE, LAST_INSERT_ID()),
('China', TRUE, LAST_INSERT_ID()),
('Estados Unidos', FALSE, LAST_INSERT_ID()),
('Indonesia', FALSE, LAST_INSERT_ID());

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el desierto más árido del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Desierto de Atacama', TRUE, LAST_INSERT_ID()),
('Sahara', FALSE, LAST_INSERT_ID()),
('Gobi', FALSE, LAST_INSERT_ID()),
('Kalahari', FALSE, LAST_INSERT_ID());

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el lago más grande del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Lago Superior', FALSE, LAST_INSERT_ID()),
('Lago Victoria', FALSE, LAST_INSERT_ID()),
('Mar Caspio', TRUE, LAST_INSERT_ID()),
('Lago Tanganyika', FALSE, LAST_INSERT_ID());

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el océano más grande del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Océano Índico', FALSE, LAST_INSERT_ID()),
('Océano Atlántico', FALSE, LAST_INSERT_ID()),
('Océano Pacífico', TRUE, LAST_INSERT_ID()),
('Océano Ártico', FALSE, LAST_INSERT_ID());

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más idiomas oficiales?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('India', TRUE, LAST_INSERT_ID()),
('Suiza', FALSE, LAST_INSERT_ID()),
('Canadá', FALSE, LAST_INSERT_ID()),
('Bélgica', FALSE, LAST_INSERT_ID());

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el continente menos extenso?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Oceanía', TRUE, LAST_INSERT_ID()),
('Antártida', FALSE, LAST_INSERT_ID()),
('Europa', FALSE, LAST_INSERT_ID()),
('África', FALSE, LAST_INSERT_ID());

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el río más largo de Europa?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Rin', FALSE, LAST_INSERT_ID()),
('Volga', TRUE, LAST_INSERT_ID()),
('Támesis', FALSE, LAST_INSERT_ID()),
('Danubio', FALSE, LAST_INSERT_ID());

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más lagos en el mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Canadá', TRUE, LAST_INSERT_ID()),
('Noruega', FALSE, LAST_INSERT_ID()),
('Finlandia', FALSE, LAST_INSERT_ID()),
('Suecia', FALSE, LAST_INSERT_ID());

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el volcán más alto del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Monte Fuji', FALSE, LAST_INSERT_ID()),
('Mauna Kea', TRUE, LAST_INSERT_ID()),
('Vesuvio', FALSE, LAST_INSERT_ID()),
('Krakatoa', FALSE, LAST_INSERT_ID());

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más montañas altas del mundo?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Nepal', TRUE, LAST_INSERT_ID()),
('Argentina', FALSE, LAST_INSERT_ID()),
('Canadá', FALSE, LAST_INSERT_ID()),
('Australia', FALSE, LAST_INSERT_ID());

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más kilómetros de costa?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Indonesia', FALSE, LAST_INSERT_ID()),
('Australia', FALSE, LAST_INSERT_ID()),
('Rusia', TRUE, LAST_INSERT_ID()),
('Canadá', FALSE, LAST_INSERT_ID());

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más selva tropical?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Brasil', TRUE, LAST_INSERT_ID()),
('Congo', FALSE, LAST_INSERT_ID()),
('Indonesia', FALSE, LAST_INSERT_ID()),
('Perú', FALSE, LAST_INSERT_ID());

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más glaciares?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Groenlandia', TRUE, LAST_INSERT_ID()),
('Antártida', FALSE, LAST_INSERT_ID()),
('Canadá', FALSE, LAST_INSERT_ID()),
('Nueva Zelanda', FALSE, LAST_INSERT_ID());

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más islas habitadas?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Filipinas', FALSE, LAST_INSERT_ID()),
('Indonesia', TRUE, LAST_INSERT_ID()),
('Japón', FALSE, LAST_INSERT_ID()),
('Suecia', FALSE, LAST_INSERT_ID());

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el país con más zonas horarias?', @categoria_geografia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Rusia', TRUE, LAST_INSERT_ID()),
('Estados Unidos', FALSE, LAST_INSERT_ID()),
('Australia', FALSE, LAST_INSERT_ID()),
('China', FALSE, LAST_INSERT_ID());



-- Obtener el ID de la categoría "Ciencia"
SET @categoria_ciencia = (SELECT id FROM categoria WHERE nombre = 'Ciencia');

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué científico formuló la teoría de la relatividad?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Isaac Newton', FALSE, LAST_INSERT_ID()),
('Albert Einstein', TRUE, LAST_INSERT_ID()),
('Nikola Tesla', FALSE, LAST_INSERT_ID()),
('Galileo Galilei', FALSE, LAST_INSERT_ID());

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el elemento más abundante en el universo?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Oxígeno', FALSE, LAST_INSERT_ID()),
('Hidrógeno', TRUE, LAST_INSERT_ID()),
('Helio', FALSE, LAST_INSERT_ID()),
('Carbono', FALSE, LAST_INSERT_ID());

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el órgano principal del sistema nervioso?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Corazón', FALSE, LAST_INSERT_ID()),
('Pulmón', FALSE, LAST_INSERT_ID()),
('Cerebro', TRUE, LAST_INSERT_ID()),
('Hígado', FALSE, LAST_INSERT_ID());

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué gas es responsable del efecto invernadero?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Dióxido de carbono', TRUE, LAST_INSERT_ID()),
('Oxígeno', FALSE, LAST_INSERT_ID()),
('Nitrógeno', FALSE, LAST_INSERT_ID()),
('Argón', FALSE, LAST_INSERT_ID());

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es la unidad básica de la vida?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Molécula', FALSE, LAST_INSERT_ID()),
('Célula', TRUE, LAST_INSERT_ID()),
('Átomo', FALSE, LAST_INSERT_ID()),
('Proteína', FALSE, LAST_INSERT_ID());

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué planeta del sistema solar tiene el mayor número de lunas?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Tierra', FALSE, LAST_INSERT_ID()),
('Júpiter', TRUE, LAST_INSERT_ID()),
('Saturno', FALSE, LAST_INSERT_ID()),
('Urano', FALSE, LAST_INSERT_ID());

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué descubrió Marie Curie?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Electricidad', FALSE, LAST_INSERT_ID()),
('Radioactividad', TRUE, LAST_INSERT_ID()),
('Gravedad', FALSE, LAST_INSERT_ID()),
('Fotosíntesis', FALSE, LAST_INSERT_ID());

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el proceso por el cual las plantas producen su propio alimento?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Respiración', FALSE, LAST_INSERT_ID()),
('Fotosíntesis', TRUE, LAST_INSERT_ID()),
('Digestión', FALSE, LAST_INSERT_ID()),
('Absorción', FALSE, LAST_INSERT_ID());

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el ácido presente en el ADN?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Ácido cítrico', FALSE, LAST_INSERT_ID()),
('Ácido desoxirribonucleico', TRUE, LAST_INSERT_ID()),
('Ácido láctico', FALSE, LAST_INSERT_ID()),
('Ácido sulfúrico', FALSE, LAST_INSERT_ID());

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué inventó Thomas Edison?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Teléfono', FALSE, LAST_INSERT_ID()),
('Bombilla eléctrica', TRUE, LAST_INSERT_ID()),
('Avión', FALSE, LAST_INSERT_ID()),
('Automóvil', FALSE, LAST_INSERT_ID());

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué causa las mareas?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Rotación de la Tierra', FALSE, LAST_INSERT_ID()),
('Atracción gravitatoria de la Luna', TRUE, LAST_INSERT_ID()),
('Viento', FALSE, LAST_INSERT_ID()),
('Temperatura', FALSE, LAST_INSERT_ID());

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un isótopo?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Un tipo de molécula', FALSE, LAST_INSERT_ID()),
('Un átomo con diferente número de neutrones', TRUE, LAST_INSERT_ID()),
('Un compuesto químico', FALSE, LAST_INSERT_ID()),
('Una célula especializada', FALSE, LAST_INSERT_ID());

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué descubrió Isaac Newton?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Leyes de la termodinámica', FALSE, LAST_INSERT_ID()),
('Leyes del movimiento', TRUE, LAST_INSERT_ID()),
('Teoría cuántica', FALSE, LAST_INSERT_ID()),
('Energía nuclear', FALSE, LAST_INSERT_ID());

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un neutrón?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Una partícula con carga positiva', FALSE, LAST_INSERT_ID()),
('Una partícula sin carga', TRUE, LAST_INSERT_ID()),
('Una partícula con carga negativa', FALSE, LAST_INSERT_ID()),
('Una molécula', FALSE, LAST_INSERT_ID());

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un exoplaneta?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Un planeta fuera del sistema solar', TRUE, LAST_INSERT_ID()),
('Un satélite natural', FALSE, LAST_INSERT_ID()),
('Un cometa', FALSE, LAST_INSERT_ID()),
('Una estrella', FALSE, LAST_INSERT_ID());

-- Obtener el ID de la categoría "Ciencia"
SET @categoria_ciencia = (SELECT id FROM categoria WHERE nombre = 'Ciencia');

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un fotón?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Una partícula de luz', TRUE, LAST_INSERT_ID()),
('Una molécula de agua', FALSE, LAST_INSERT_ID()),
('Un tipo de célula', FALSE, LAST_INSERT_ID()),
('Un compuesto químico', FALSE, LAST_INSERT_ID());

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el proceso por el cual los minerales reemplazan los tejidos orgánicos en los fósiles?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Petrificación', TRUE, LAST_INSERT_ID()),
('Descomposición', FALSE, LAST_INSERT_ID()),
('Fosilización', FALSE, LAST_INSERT_ID()),
('Congelación', FALSE, LAST_INSERT_ID());

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué descubrió Dmitri Mendeléyev?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('La tabla periódica', TRUE, LAST_INSERT_ID()),
('La electricidad', FALSE, LAST_INSERT_ID()),
('La gravedad', FALSE, LAST_INSERT_ID()),
('El ADN', FALSE, LAST_INSERT_ID());

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un semiconductor?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Un material que conduce parcialmente la electricidad', TRUE, LAST_INSERT_ID()),
('Un material que no conduce electricidad', FALSE, LAST_INSERT_ID()),
('Un material que conduce completamente la electricidad', FALSE, LAST_INSERT_ID()),
('Un compuesto químico', FALSE, LAST_INSERT_ID());

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál es el órgano principal del sistema respiratorio?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Corazón', FALSE, LAST_INSERT_ID()),
('Pulmón', TRUE, LAST_INSERT_ID()),
('Hígado', FALSE, LAST_INSERT_ID()),
('Riñón', FALSE, LAST_INSERT_ID());

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué causa las mutaciones genéticas?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Radiación', TRUE, LAST_INSERT_ID()),
('Alimentación saludable', FALSE, LAST_INSERT_ID()),
('Ejercicio físico', FALSE, LAST_INSERT_ID()),
('Sueño adecuado', FALSE, LAST_INSERT_ID());

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un ácido?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Una sustancia que libera iones hidrógeno en solución', TRUE, LAST_INSERT_ID()),
('Una sustancia que libera iones hidroxilo en solución', FALSE, LAST_INSERT_ID()),
('Una sustancia que no reacciona químicamente', FALSE, LAST_INSERT_ID()),
('Una sustancia que conduce electricidad', FALSE, LAST_INSERT_ID());

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué inventó Alexander Graham Bell?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Teléfono', TRUE, LAST_INSERT_ID()),
('Bombilla eléctrica', FALSE, LAST_INSERT_ID()),
('Automóvil', FALSE, LAST_INSERT_ID()),
('Avión', FALSE, LAST_INSERT_ID());

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un electrón?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Una partícula con carga negativa', TRUE, LAST_INSERT_ID()),
('Una partícula con carga positiva', FALSE, LAST_INSERT_ID()),
('Una partícula sin carga', FALSE, LAST_INSERT_ID()),
('Una molécula', FALSE, LAST_INSERT_ID());

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un ecossistema?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Un grupo de organismos vivos interactuando entre sí y con su entorno', TRUE, LAST_INSERT_ID()),
('Un solo organismo viviendo en un ambiente', FALSE, LAST_INSERT_ID()),
('Una comunidad de plantas solamente', FALSE, LAST_INSERT_ID()),
('Un laboratorio científico', FALSE, LAST_INSERT_ID());

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un neutrino?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Una partícula subatómica casi sin masa', TRUE, LAST_INSERT_ID()),
('Una molécula de oxígeno', FALSE, LAST_INSERT_ID()),
('Una célula especializada', FALSE, LAST_INSERT_ID()),
('Un compuesto químico', FALSE, LAST_INSERT_ID());

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un catalizador?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Una sustancia que acelera una reacción química sin consumirse', TRUE, LAST_INSERT_ID()),
('Una sustancia que ralentiza una reacción química', FALSE, LAST_INSERT_ID()),
('Una sustancia que detiene una reacción química', FALSE, LAST_INSERT_ID()),
('Una sustancia que produce energía', FALSE, LAST_INSERT_ID());

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un gen?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Un segmento de ADN que codifica una proteína', TRUE, LAST_INSERT_ID()),
('Una molécula de glucosa', FALSE, LAST_INSERT_ID()),
('Una célula nerviosa', FALSE, LAST_INSERT_ID()),
('Un tipo de hormona', FALSE, LAST_INSERT_ID());

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué es un superconductor?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Un material que conduce electricidad sin resistencia', TRUE, LAST_INSERT_ID()),
('Un material que no conduce electricidad', FALSE, LAST_INSERT_ID()),
('Un material que conduce calor', FALSE, LAST_INSERT_ID()),
('Un compuesto químico', FALSE, LAST_INSERT_ID());

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué descubrió Louis Pasteur?', @categoria_ciencia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('La teoría de la evolución', FALSE, LAST_INSERT_ID()),
('La pasteurización', TRUE, LAST_INSERT_ID()),
('La relatividad', FALSE, LAST_INSERT_ID()),
('La gravedad', FALSE, LAST_INSERT_ID());

-- Obtener el ID de la categoría "Historia"
SET @categoria_historia = (SELECT id FROM categoria WHERE nombre = 'Historia');

-- Pregunta 1
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año comenzó la Primera Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1914', TRUE, LAST_INSERT_ID()),
('1918', FALSE, LAST_INSERT_ID()),
('1939', FALSE, LAST_INSERT_ID()),
('1945', FALSE, LAST_INSERT_ID());

-- Pregunta 2
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el líder soviético durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Mijaíl Gorbachov', FALSE, LAST_INSERT_ID()),
('Vladimir Lenin', FALSE, LAST_INSERT_ID()),
('José Stalin', TRUE, LAST_INSERT_ID()),
('Nikita Kruschev', FALSE, LAST_INSERT_ID());

-- Pregunta 3
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año cayó el Muro de Berlín?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1989', TRUE, LAST_INSERT_ID()),
('1990', FALSE, LAST_INSERT_ID()),
('1991', FALSE, LAST_INSERT_ID()),
('1985', FALSE, LAST_INSERT_ID());

-- Pregunta 4
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál fue la causa principal de la Revolución Francesa?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Desigualdad social', TRUE, LAST_INSERT_ID()),
('Invasión extranjera', FALSE, LAST_INSERT_ID()),
('Guerra civil', FALSE, LAST_INSERT_ID()),
('Peste negra', FALSE, LAST_INSERT_ID());

-- Pregunta 5
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién escribió "La Divina Comedia" en el siglo XIV?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Dante Alighieri', TRUE, LAST_INSERT_ID()),
('William Shakespeare', FALSE, LAST_INSERT_ID()),
('Miguel de Cervantes', FALSE, LAST_INSERT_ID()),
('Leonardo da Vinci', FALSE, LAST_INSERT_ID());

-- Pregunta 6
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se firmaron los Acuerdos de Paz de Westfalia?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1648', TRUE, LAST_INSERT_ID()),
('1789', FALSE, LAST_INSERT_ID()),
('1815', FALSE, LAST_INSERT_ID()),
('1919', FALSE, LAST_INSERT_ID());

-- Pregunta 7
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el primer emperador romano?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Julio César', FALSE, LAST_INSERT_ID()),
('Marco Antonio', FALSE, LAST_INSERT_ID()),
('Augusto', TRUE, LAST_INSERT_ID()),
('Trajano', FALSE, LAST_INSERT_ID());

-- Pregunta 8
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año comenzó la Revolución Industrial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1760', TRUE, LAST_INSERT_ID()),
('1840', FALSE, LAST_INSERT_ID()),
('1900', FALSE, LAST_INSERT_ID()),
('1600', FALSE, LAST_INSERT_ID());

-- Pregunta 9
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué evento marcó el inicio de la Guerra Fría?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('La caída del Imperio Otomano', FALSE, LAST_INSERT_ID()),
('El fin de la Segunda Guerra Mundial', TRUE, LAST_INSERT_ID()),
('La invasión de Normandía', FALSE, LAST_INSERT_ID()),
('La firma del Tratado de Versalles', FALSE, LAST_INSERT_ID());

-- Pregunta 10
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el líder nazi durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Benito Mussolini', FALSE, LAST_INSERT_ID()),
('Adolf Hitler', TRUE, LAST_INSERT_ID()),
('Joseph Goebbels', FALSE, LAST_INSERT_ID()),
('Hermann Göring', FALSE, LAST_INSERT_ID());

-- Pregunta 11
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se produjo la Revolución Rusa?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1917', TRUE, LAST_INSERT_ID()),
('1920', FALSE, LAST_INSERT_ID()),
('1914', FALSE, LAST_INSERT_ID()),
('1918', FALSE, LAST_INSERT_ID());

-- Pregunta 12
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el primer presidente de Estados Unidos?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Thomas Jefferson', FALSE, LAST_INSERT_ID()),
('George Washington', TRUE, LAST_INSERT_ID()),
('Abraham Lincoln', FALSE, LAST_INSERT_ID()),
('John Adams', FALSE, LAST_INSERT_ID());

-- Pregunta 13
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se inauguró la Torre Eiffel?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1889', TRUE, LAST_INSERT_ID()),
('1900', FALSE, LAST_INSERT_ID()),
('1875', FALSE, LAST_INSERT_ID()),
('1920', FALSE, LAST_INSERT_ID());

-- Pregunta 14
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué documento estableció los derechos fundamentales en Inglaterra en 1215?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('La Declaración de Derechos', FALSE, LAST_INSERT_ID()),
('La Constitución', FALSE, LAST_INSERT_ID()),
('La Magna Carta', TRUE, LAST_INSERT_ID()),
('Los Derechos Humanos', FALSE, LAST_INSERT_ID());

-- Pregunta 15
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se descubrió América por Cristóbal Colón?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1492', TRUE, LAST_INSERT_ID()),
('1500', FALSE, LAST_INSERT_ID()),
('1485', FALSE, LAST_INSERT_ID()),
('1520', FALSE, LAST_INSERT_ID());

-- Obtener el ID de la categoría "Historia"
SET @categoria_historia = (SELECT id FROM categoria WHERE nombre = 'Historia');

-- Pregunta 16
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se firmó el Tratado de Versalles?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1918', FALSE, LAST_INSERT_ID()),
('1919', TRUE, LAST_INSERT_ID()),
('1920', FALSE, LAST_INSERT_ID()),
('1921', FALSE, LAST_INSERT_ID());

-- Pregunta 17
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el líder británico durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Winston Churchill', TRUE, LAST_INSERT_ID()),
('Benito Mussolini', FALSE, LAST_INSERT_ID()),
('Franklin D. Roosevelt', FALSE, LAST_INSERT_ID()),
('Joseph Stalin', FALSE, LAST_INSERT_ID());

-- Pregunta 18
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se produjo la caída del Imperio Romano de Occidente?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('410 d.C.', FALSE, LAST_INSERT_ID()),
('476 d.C.', TRUE, LAST_INSERT_ID()),
('533 d.C.', FALSE, LAST_INSERT_ID()),
('600 d.C.', FALSE, LAST_INSERT_ID());

-- Pregunta 19
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Qué evento marcó el inicio de la Edad Moderna?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('La Caída de Constantinopla', TRUE, LAST_INSERT_ID()),
('La Revolución Industrial', FALSE, LAST_INSERT_ID()),
('La Reforma Protestante', FALSE, LAST_INSERT_ID()),
('La Conquista de América', FALSE, LAST_INSERT_ID());

-- Pregunta 20
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién escribió "El Príncipe", un tratado sobre el poder político?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Miguel de Cervantes', FALSE, LAST_INSERT_ID()),
('Maquiavelo', TRUE, LAST_INSERT_ID()),
('William Shakespeare', FALSE, LAST_INSERT_ID()),
('Francisco Pizarro', FALSE, LAST_INSERT_ID());

-- Pregunta 21
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año comenzó la Guerra Civil Española?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1931', FALSE, LAST_INSERT_ID()),
('1936', TRUE, LAST_INSERT_ID()),
('1939', FALSE, LAST_INSERT_ID()),
('1945', FALSE, LAST_INSERT_ID());

-- Pregunta 22
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el primer emperador chino en unificar China bajo un solo gobierno?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Confucio', FALSE, LAST_INSERT_ID()),
('Emperador Qin Shi Huang', TRUE, LAST_INSERT_ID()),
('Genghis Khan', FALSE, LAST_INSERT_ID()),
('Emperador Kangxi', FALSE, LAST_INSERT_ID());

-- Pregunta 23
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se disolvió la Unión Soviética?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1989', FALSE, LAST_INSERT_ID()),
('1990', FALSE, LAST_INSERT_ID()),
('1991', TRUE, LAST_INSERT_ID()),
('1992', FALSE, LAST_INSERT_ID());

-- Pregunta 24
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Cuál fue la causa principal de la Guerra de Secesión Estadounidense?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('La independencia de los estados', FALSE, LAST_INSERT_ID()),
('La abolición de la esclavitud', TRUE, LAST_INSERT_ID()),
('La expansión territorial', FALSE, LAST_INSERT_ID()),
('La economía industrial', FALSE, LAST_INSERT_ID());

-- Pregunta 25
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se inauguró el Canal de Panamá?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1900', FALSE, LAST_INSERT_ID()),
('1914', TRUE, LAST_INSERT_ID()),
('1920', FALSE, LAST_INSERT_ID()),
('1930', FALSE, LAST_INSERT_ID());

-- Pregunta 26
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el líder de la Resistencia francesa durante la Segunda Guerra Mundial?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Charles de Gaulle', TRUE, LAST_INSERT_ID()),
('Adolf Hitler', FALSE, LAST_INSERT_ID()),
('Benito Mussolini', FALSE, LAST_INSERT_ID()),
('Joseph Stalin', FALSE, LAST_INSERT_ID());

-- Pregunta 27
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se produjo la Revolución Francesa?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1776', FALSE, LAST_INSERT_ID()),
('1789', TRUE, LAST_INSERT_ID()),
('1848', FALSE, LAST_INSERT_ID()),
('1871', FALSE, LAST_INSERT_ID());

-- Pregunta 28
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién fue el primer presidente de la República Argentina?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Juan Manuel de Rosas', FALSE, LAST_INSERT_ID()),
('Bartolomé Mitre', FALSE, LAST_INSERT_ID()),
('Bernardino Rivadavia', TRUE, LAST_INSERT_ID()),
('Domingo Faustino Sarmiento', FALSE, LAST_INSERT_ID());

-- Pregunta 29
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('1945', TRUE, LAST_INSERT_ID()),
('1950', FALSE, LAST_INSERT_ID()),
('1960', FALSE, LAST_INSERT_ID()),
('1970', FALSE, LAST_INSERT_ID());

-- Pregunta 30
INSERT INTO pregunta (texto, categoria_id) VALUES
('¿Quién lideró la expedición que descubrió el Pacífico?', @categoria_historia);
INSERT INTO respuesta (texto, es_correcta, pregunta_id) VALUES
('Cristóbal Colón', FALSE, LAST_INSERT_ID()),
('Fernando de Magallanes', TRUE, LAST_INSERT_ID()),
('Hernán Cortés', FALSE, LAST_INSERT_ID()),
('Vasco Núñez de Balboa', FALSE, LAST_INSERT_ID());