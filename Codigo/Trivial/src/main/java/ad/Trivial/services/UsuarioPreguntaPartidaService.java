package ad.Trivial.services;

import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.repositories.UsuarioPreguntaPartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioPreguntaPartidaService {

    @Autowired
    UsuarioPreguntaPartidaRepository usuarioPreguntaPartidaRepository;

    public List<UsuarioPreguntaPartida> obtenerTodas(){
        return usuarioPreguntaPartidaRepository.findAll();
    }

    public UsuarioPreguntaPartida guardar(UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaRepository.save(usuarioPreguntaPartida);
    }

    public UsuarioPreguntaPartida actualizar(UsuarioPreguntaPartida usuarioPreguntaPartida){
        if (usuarioPreguntaPartida.getId() == null){
            return null;
        }else {
            return usuarioPreguntaPartidaRepository.save(usuarioPreguntaPartida);
        }
    }

    public void eliminar(Long id){
        usuarioPreguntaPartidaRepository.deleteById(id);
    }
}
