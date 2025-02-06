package ad.Trivial.services;

import ad.Trivial.models.Respuesta;
import ad.Trivial.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    public List<Respuesta> obtenerTodas(){
        return respuestaRepository.findAll();
    }
}
