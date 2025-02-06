package ad.Trivial.services;

import ad.Trivial.models.Pregunta;
import ad.Trivial.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Preguntaservice {

    @Autowired
    PreguntaRepository preguntaRepository;

    public List<Pregunta> obtenerTodas(){
        return preguntaRepository.findAll();
    }
}
