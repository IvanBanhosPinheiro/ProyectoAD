package ad.Trivial.services;

import ad.Trivial.models.Partida;
import ad.Trivial.models.Pregunta;
import ad.Trivial.models.Usuario;
import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.models.modelosDTO.PartidaDTO;
import ad.Trivial.models.modelosDTO.PreguntaDTO;
import ad.Trivial.models.modelosDTO.UsuariODTO;
import ad.Trivial.models.modelosDTO.UsuarioPreguntaPartidaDTO;
import ad.Trivial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversionModelos {
    @Autowired
     private UsuarioRepository usuarioRepository;

    @Autowired
    private Preguntaservice preguntaservice;

    //Convertir DTO a partida
    public Partida transformarDTOAPartida(PartidaDTO partidaDTO){
        Partida partida = new Partida();
        partida.setId(partidaDTO.getId());
        partida.setFechaFin(partidaDTO.getFechaFin());
        partida.setFechaInicio(partidaDTO.getFechaInicio());
        partida.setPuntuacion(partidaDTO.getPuntuacion());
        partida.setUsuario(usuarioRepository.findById(partidaDTO.getUsuario().getId()).orElse(null));
        return partida;
    }

    //Pasar una partida a DTO
    public PartidaDTO transformarPartidaADTO(Partida partida){
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

    //Convertir usuarioPreguntaPartida a DTO
    public UsuarioPreguntaPartidaDTO transformarUsuarioPreguntaPartidaADTO(UsuarioPreguntaPartida usuarioPreguntaPartida){
        UsuarioPreguntaPartidaDTO usuarioPreguntaPartidaDTO = new UsuarioPreguntaPartidaDTO();
        UsuariODTO usuariODTO = new UsuariODTO();
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        PartidaDTO partidaDTO = new PartidaDTO();
        // guardamos el ususario
        usuariODTO.setId(usuarioPreguntaPartida.getUsuario().getId());
        usuariODTO.setEmail(usuarioPreguntaPartida.getUsuario().getEmail());
        usuariODTO.setNombre(usuarioPreguntaPartida.getUsuario().getNombre());
        // guardamos la pregunta
        preguntaDTO.setId(usuarioPreguntaPartida.getPregunta().getId());
        preguntaDTO.setPregunta(usuarioPreguntaPartida.getPregunta().getTexto());

        preguntaDTO.setRespuestas(preguntaservice.obtenerPreguntaDTOPorId(usuarioPreguntaPartida.getPregunta().getId()).getRespuestas());

        // guardamos la partida
        partidaDTO.setId(usuarioPreguntaPartida.getPartida().getId());
        partidaDTO.setFechaInicio(usuarioPreguntaPartida.getPartida().getFechaInicio());
        partidaDTO.setFechaFin(usuarioPreguntaPartida.getPartida().getFechaFin());
        partidaDTO.setPuntuacion(usuarioPreguntaPartida.getPartida().getPuntuacion());
        partidaDTO.setUsuario(usuariODTO);
        // guardamos la relacion
        usuarioPreguntaPartidaDTO.setPregunta(preguntaDTO);
        usuarioPreguntaPartidaDTO.setPartida(partidaDTO);
        usuarioPreguntaPartidaDTO.setAcertada(usuarioPreguntaPartida.isAcertada());
        return usuarioPreguntaPartidaDTO;
    }

    //Convertir lista usuarioPreguntaPartida a lista DTO
    public List<UsuarioPreguntaPartidaDTO> transformarListaUsuarioPreguntaPartidaADTO(List<UsuarioPreguntaPartida> usuarioPreguntaPartidas){
        List<UsuarioPreguntaPartidaDTO> usuarioPreguntaPartidaDTOS = new ArrayList<>();
        for (UsuarioPreguntaPartida usuarioPreguntaPartida : usuarioPreguntaPartidas){
            usuarioPreguntaPartidaDTOS.add(transformarUsuarioPreguntaPartidaADTO(usuarioPreguntaPartida));
        }
        return usuarioPreguntaPartidaDTOS;
    }

    //Convertir Usuario a DTo
    public UsuariODTO transformarUsuarioADTO(Usuario usuario){
        UsuariODTO usuariODTO = new UsuariODTO();
        usuariODTO.setId(usuario.getId());
        usuariODTO.setEmail(usuario.getEmail());
        usuariODTO.setNombre(usuario.getNombre());
        return usuariODTO;
    }

    //Convertir pregunta a DTO
    public PreguntaDTO transformarPreguntaADTO(Pregunta pregunta){
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        preguntaDTO.setId(pregunta.getId());
        preguntaDTO.setPregunta(pregunta.getTexto());
        preguntaDTO.setRespuestas(preguntaservice.obtenerPreguntaDTOPorId(pregunta.getId()).getRespuestas());
        return preguntaDTO;
    }
}
