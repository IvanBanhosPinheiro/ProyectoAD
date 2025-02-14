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
     * Agrega una pregunta a una partida específica.
     *
     * @param partidaId el ID de la partida
     * @param preguntaId el ID de la pregunta
     * @param usuarioId el ID del usuario
     * @param acertada indica si la pregunta fue acertada
     * @return una respuesta con el resultado de la operación
     */
    @Operation(summary = "Agregar preguntas a una partida", description = "Agrega una pregunta a una partida específica")
    @PostMapping("/partida")
    public ResponseEntity<?> agregarPreguntasAPartida(
            @Parameter(description = "ID de la partida", required = true) @RequestBody Long partidaId,
            @Parameter(description = "ID de la pregunta", required = true) @RequestBody Long preguntaId,
            @Parameter(description = "ID del usuario", required = true) @RequestParam Long usuarioId,
            @Parameter(description = "Indica si la pregunta fue acertada", required = true) @RequestParam boolean acertada) {
        return usuarioPreguntaPartidaService.agregarPreguntasAPartida(partidaId, preguntaId, usuarioId, acertada);
    }
}