package ad.Trivial.repositories;

import ad.Trivial.models.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    void deleteAllByUsuarioId(Long id);

    List<Partida> findTop3ByFechaFinNotNullOrderByPuntuacionDesc();
}
