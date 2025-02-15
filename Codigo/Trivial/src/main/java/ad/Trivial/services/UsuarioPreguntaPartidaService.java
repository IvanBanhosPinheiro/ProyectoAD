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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void eliminarTodoPorPartidaID(Long id){
        usuarioPreguntaPartidaRepository.deleteAllByPartidaId(id);
    }

    @Transactional
    public void eliminarTodosPorUsuarioID(Long id){
        usuarioPreguntaPartidaRepository.deleteAllByUsuarioId(id);
    }

    // Método público para obtener todas las preguntas de un usuario específico
    public ResponseEntity<?> obtenerTodasPorUsuario(Long id) {
        return obtenerTodasPor(id, true);
    }

    // Método público para obtener todas las preguntas de una partida específica
    public ResponseEntity<?> obtenerTodasPorPartida(Long id) {
        return obtenerTodasPor(id, false);
    }

    @Transactional
    public void eliminarTodasLasPreguntasDeUnaPregunta(Long id){
        usuarioPreguntaPartidaRepository.deleteAllByPreguntaId(id);
    }
    // Método privado que contiene la lógica común
    private ResponseEntity<?> obtenerTodasPor(Long id, boolean esPorUsuario) {
        try {
            List<UsuarioPreguntaPartida> usuarioPreguntaPartida = esPorUsuario
                    ? usuarioPreguntaPartidaRepository.findByUsuarioId(id)
                    : usuarioPreguntaPartidaRepository.findByPartidaId(id);

            if (usuarioPreguntaPartida.isEmpty()) {
                return ResponseEntity.status(404).body("No se encontraron registros");
            }

            UsuarioPreguntaPartidaDTOList usuarioPreguntaPartidaDTOList = new UsuarioPreguntaPartidaDTOList();
            usuarioPreguntaPartidaDTOList.setPartida(conversionModelos.transformarPartidaADTO(usuarioPreguntaPartida.get(0).getPartida()));

            List<RespuestasDTO> respuestas = new ArrayList<>();
            for (UsuarioPreguntaPartida upp : usuarioPreguntaPartida) {
                RespuestasDTO respuestasDTO = new RespuestasDTO();
                respuestasDTO.setAcertada(upp.isAcertada());
                respuestasDTO.setPregunta(conversionModelos.transformarPreguntaADTO(upp.getPregunta()));
                respuestas.add(respuestasDTO);
            }
            usuarioPreguntaPartidaDTOList.setRespuestas(respuestas);
            return ResponseEntity.ok(usuarioPreguntaPartidaDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }


}


