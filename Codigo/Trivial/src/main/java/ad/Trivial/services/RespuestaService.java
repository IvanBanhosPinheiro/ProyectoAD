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

    public Respuesta guardar(Respuesta respuesta){
        return respuestaRepository.save(respuesta);
    }

    public Respuesta actualizar(Respuesta respuesta){
        if (respuesta.getId() == null){
            return null;
        }else {
            return respuestaRepository.save(respuesta);
        }
    }

    public void eliminar(Long id){
        respuestaRepository.deleteById(id);
    }
}
