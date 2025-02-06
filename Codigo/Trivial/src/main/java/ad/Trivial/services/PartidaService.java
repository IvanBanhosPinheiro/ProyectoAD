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
}
