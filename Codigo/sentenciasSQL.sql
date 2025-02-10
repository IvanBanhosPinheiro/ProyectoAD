-- obtener preguntas de una categoria
SELECT r.id, r.texto, r.es_correcta, p.id, p.texto, c.id, c.nombre, c.descripcion
FROM respuesta AS r JOIN pregunta AS p ON r.pregunta_id = p.id
JOIN categoria AS c ON p.categoria_id = c.id
WHERE c.id = 1; 