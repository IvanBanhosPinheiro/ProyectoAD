package ad.Trivial.services;

import ad.Trivial.models.Partida;
import ad.Trivial.models.Pregunta;
import ad.Trivial.models.Usuario;
import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.models.modelosDTO.*;
import ad.Trivial.repositories.PartidaRepository;
import ad.Trivial.repositories.PreguntaRepository;
import ad.Trivial.repositories.UsuarioPreguntaPartidaRepository;
import ad.Trivial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioPreguntaPartidaService {

    @Autowired
    private UsuarioPreguntaPartidaRepository usuarioPreguntaPartidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private Preguntaservice preguntaservice;

    @Autowired
    private ConversionModelos conversionModelos;

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

    public ResponseEntity<?> agregarPreguntasAPartida(Long partidaId, Long preguntaID, Long usuarioID, boolean acertada) {
        try {
            Partida partida = partidaRepository.findById(partidaId).orElse(null);
            Pregunta pregunta = preguntaRepository.findById(preguntaID).orElse(null);
            Usuario usuario = usuarioRepository.findById(usuarioID).orElse(null);
            PreguntaDTO preguntaD = preguntaservice.obtenerPreguntaDTOPorId(preguntaID);

            if (partida == null) {
                return ResponseEntity.status(404).body("Partida no encontrada");
            }
            if (preguntaD == null) {
                return ResponseEntity.status(404).body("Pregunta no encontrada");
            }
            if (usuario == null) {
                return ResponseEntity.status(404).body("Usuario no encontrado");
            }

            UsuarioPreguntaPartida usuarioPreguntaPartida = new UsuarioPreguntaPartida();
            usuarioPreguntaPartida.setAcertada(acertada);
            usuarioPreguntaPartida.setUsuario(usuario);
            usuarioPreguntaPartida.setPregunta(pregunta);
            usuarioPreguntaPartida.setPartida(partida);
            return ResponseEntity.ok(conversionModelos.transformarUsuarioPreguntaPartidaADTO(usuarioPreguntaPartida));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    public ResponseEntity<?> obtenerTodasPorUsuario(Long id){
        try {
            List<UsuarioPreguntaPartida> usuarioPreguntaPartida = usuarioPreguntaPartidaRepository.finfByUsuarioId(id);
            if (usuarioPreguntaPartida.isEmpty()) {
                return ResponseEntity.status(404).body("No se encontraron registros");
            }
            return ResponseEntity.ok(conversionModelos.transformarListaUsuarioPreguntaPartidaADTO(usuarioPreguntaPartida));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
}


