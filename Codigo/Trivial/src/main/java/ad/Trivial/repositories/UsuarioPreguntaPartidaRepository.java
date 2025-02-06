package ad.Trivial.repositories;

import ad.Trivial.models.UsuarioPreguntaPartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPreguntaPartidaRepository extends JpaRepository<UsuarioPreguntaPartida,Long> {
}
