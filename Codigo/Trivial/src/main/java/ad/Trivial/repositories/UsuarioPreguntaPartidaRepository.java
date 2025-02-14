package ad.Trivial.repositories;

import ad.Trivial.models.UsuarioPreguntaPartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioPreguntaPartidaRepository extends JpaRepository<UsuarioPreguntaPartida,Long> {
    List<UsuarioPreguntaPartida> findByUsuarioId(Long id);
    List<UsuarioPreguntaPartida> findByPartidaId(Long id);
}
