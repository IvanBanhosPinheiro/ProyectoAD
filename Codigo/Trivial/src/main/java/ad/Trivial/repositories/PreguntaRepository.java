package ad.Trivial.repositories;

import ad.Trivial.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    @Query(value = "SELECT r.id, r.texto, r.es_correcta, p.id, p.texto, c.id, c.nombre, c.descripcion\n" +
            "FROM respuesta AS r JOIN pregunta AS p ON r.pregunta_id = p.id\n" +
            "JOIN categoria AS c ON p.categoria_id = c.id\n" +
            "WHERE c.id = ?1; ", nativeQuery = true)
    List<Object[]> preguntasDeUnaCategoria(Long categoria_id);

    void deleteAllByCategoriaId(Long id);

    // Método para obtener la última pregunta
    @Query(value = "SELECT * FROM pregunta ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Pregunta findLastPregunta();

    List<Pregunta> findByCategoriaId(Long id);
}
