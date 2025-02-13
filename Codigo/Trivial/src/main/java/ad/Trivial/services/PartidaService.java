package ad.Trivial.services;

import ad.Trivial.models.Partida;
import ad.Trivial.models.Usuario;
import ad.Trivial.models.modelosDTO.PartidaDTO;
import ad.Trivial.models.modelosDTO.UsuariODTO;
import ad.Trivial.repositories.PartidaRepository;
import ad.Trivial.repositories.UsuarioRepository;
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
            partidaDTOS.add(transformarPartidaADTO(partida));
        }
        return partidaDTOS;
    }

    public PartidaDTO obtenerPorIDDTO(Long id){
        return transformarPartidaADTO(partidaRepository.findById(id).orElse(null));
    }

    public ResponseEntity<?> guardarDTO(PartidaDTO partidaDTO){
        Partida partida = transformarDTOAPartida(partidaDTO);
        if (partida.getUsuario() == null){
            return ResponseEntity.status(422).body("Error: Datos inválidos, no se puede procesar");
        }else {
            return ResponseEntity.ok(transformarPartidaADTO(partidaRepository.save(partida)));
        }
    }


    //Convertir DTO a partida
    private Partida transformarDTOAPartida(PartidaDTO partidaDTO){
        Partida partida = new Partida();
        partida.setId(partidaDTO.getId());
        partida.setFechaFin(partidaDTO.getFechaFin());
        partida.setFechaInicio(partidaDTO.getFechaInicio());
        partida.setPuntuacion(partidaDTO.getPuntuacion());
        partida.setUsuario(usuarioRepository.findById(partidaDTO.getUsuario().getId()).orElse(null));
        return partida;
    }

    //Pasar una partida a DTO
    private PartidaDTO transformarPartidaADTO(Partida partida){
        if (partida != null) {
            PartidaDTO partidaDTO = new PartidaDTO();
            partidaDTO.setId(partida.getId());
            partidaDTO.setFechaFin(partida.getFechaFin());
            partidaDTO.setFechaInicio(partida.getFechaInicio());
            partidaDTO.setPuntuacion(partida.getPuntuacion());
            UsuariODTO usuariODTO = new UsuariODTO();
            usuariODTO.setEmail(partida.getUsuario().getEmail());
            usuariODTO.setNombre(partida.getUsuario().getNombre());
            usuariODTO.setId(partida.getUsuario().getId());
            partidaDTO.setUsuario(usuariODTO);
            return partidaDTO;
        }else{
            return null;
        }
    }
}
