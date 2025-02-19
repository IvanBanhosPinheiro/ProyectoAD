package ad.Trivial.services;

import ad.Trivial.models.Partida;
import ad.Trivial.models.modelosDTO.PartidaDTO;
import ad.Trivial.repositories.PartidaRepository;
import ad.Trivial.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartidaService {

    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ConversionModelos conversionModelos;

    public List<Partida> obtenerTodas(){
        return partidaRepository.findAll();
    }

    public Partida obtenerPorID(Long id){
        return partidaRepository.findById(id).orElse(null);
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

    public void eliminarPorId(Long id){
        partidaRepository.deleteById(id);
    }

    public void eliminar(Partida partida){
        partidaRepository.delete(partida);
    }


    //parte de DTOs
    public List<PartidaDTO> obtenerTodasDTO(){
        List<Partida> partidas = partidaRepository.findAll();
        List<PartidaDTO> partidaDTOS =new ArrayList<>();
        for (Partida partida : partidas){
            partidaDTOS.add(conversionModelos.transformarPartidaADTO(partida));
        }
        return partidaDTOS;
    }

    @Transactional
    public void eliminarPorUsuarioID(Long id){
        partidaRepository.deleteAllByUsuarioId(id);
    }

    public PartidaDTO obtenerPorIDDTO(Long id){
        return conversionModelos.transformarPartidaADTO(partidaRepository.findById(id).orElse(null));
    }

    public ResponseEntity<?> guardarDTO(PartidaDTO partidaDTO){
        Partida partida = conversionModelos.transformarDTOAPartida(partidaDTO);
        if (partida.getUsuario() == null){
            return ResponseEntity.status(422).body("Error: Datos inválidos, no se puede procesar");
        }else {
            return ResponseEntity.ok(conversionModelos.transformarPartidaADTO(partidaRepository.save(partida)));
        }
    }


    public List<PartidaDTO> obtenerMejores() {
        List<Partida> partidas = partidaRepository.findTop3ByFechaFinNotNullOrderByPuntuacionDesc();
        List<PartidaDTO> partidaDTOS = new ArrayList<>();
        for (Partida partida : partidas){
            partidaDTOS.add(conversionModelos.transformarPartidaADTO(partida));
        }
        return partidaDTOS;
    }
}
