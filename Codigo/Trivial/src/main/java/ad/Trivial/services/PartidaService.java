package ad.Trivial.services;

import ad.Trivial.models.Partida;
import ad.Trivial.repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;

    public List<Partida> obtenerTodas(){
        return partidaRepository.findAll();
    }

    public Partida guardar(Partida partida){
        return partidaRepository.save(partida);
    }

    public Partida actualizar(Partida partida){
        if (partida.getId() == null){
            return null;
        }else {
            return partidaRepository.save(partida);
        }
    }

    public void eliminar(Long id){
        partidaRepository.deleteById(id);
    }
}
