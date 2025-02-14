package ad.Trivial.controllers.frontend;

import ad.Trivial.services.UsuarioPreguntaPartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la entidad UsuarioPreguntaPartida en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con las relaciones entre usuarios, preguntas y partidas.
 */
@RestController
@RequestMapping("/api/usprpa")
@Tag(name = "Usuario Pregunta Partida", description = "Operaciones relacionadas a Usuario Pregunta Partida")
public class UsuarioPreguntaPartidaFrontController {

    @Autowired
    private UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

    /**
     * Obtiene todas las preguntas de un usuario específico.
     *
     * @param id el ID del usuario
     * @return una respuesta con todas las preguntas asociadas al usuario
     */
    @Operation(summary = "Obtener todas las preguntas de un usuario", description = "Retorna todas las preguntas asociadas a un usuario específico")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerDeUnUsuario(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Long id) {
        return usuarioPreguntaPartidaService.obtenerTodasPorUsuario(id);
    }

    /**
     * Obtiene todas las preguntas de una partida específica.
     *
     * @param id el ID de la partida
     * @return una respuesta con todas las preguntas asociadas a la partida
     */
    @GetMapping("/partida/{id}")
    public ResponseEntity<?> obtenerDeUnaPartida(
            @Parameter(description = "ID de la partida", required = true) @PathVariable Long id) {
        return usuarioPreguntaPartidaService.obtenerTodasPorPartida(id);
    }

    /**
     * Agrega una pregunta a una partida específica.
     *
     * @param request objeto que contiene los datos necesarios para agregar la pregunta a la partida
     * @return una respuesta con el resultado de la operación
     */
    @Operation(summary = "Agregar preguntas a una partida", description = "Agrega una pregunta a una partida específica")
    @PostMapping("/partida")
    public ResponseEntity<?> agregarPreguntasAPartida(
            @RequestBody ad.Trivial.models.dto.AgregarPreguntaRequest request) {
        return usuarioPreguntaPartidaService.agregarPreguntasAPartida(
                request.getPartidaId(), request.getPreguntaId(), request.getUsuarioId(), request.isAcertada());
    }
}