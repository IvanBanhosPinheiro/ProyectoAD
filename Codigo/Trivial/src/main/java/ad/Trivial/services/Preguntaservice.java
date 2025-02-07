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
    public Pregunta guardar(Pregunta pregunta){
        return preguntaRepository.save(pregunta);
    }

    public Pregunta actualizar(Pregunta pregunta){
        if (pregunta.getId() == null){
            return null;
        }else {
            return preguntaRepository.save(pregunta);
        }
    }

    public void eliminar(Long id){
        preguntaRepository.deleteById(id);
    }

}
