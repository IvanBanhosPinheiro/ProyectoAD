package ad.Trivial.repositories;

import ad.Trivial.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    void deleteAllByPreguntaId(Long id);
}
