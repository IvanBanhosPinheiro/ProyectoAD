package ad.Trivial.controllers.frontend;

import ad.Trivial.models.modelosDTO.AgregarPreguntaRequest;
import ad.Trivial.services.PartidaService;
import ad.Trivial.services.Preguntaservice;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
import ad.Trivial.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@Tag(name = "Api - Usuario Pregunta Partida", description = "Operaciones relacionadas a Usuario Pregunta Partida")
public class UsuarioPreguntaPartidaFrontController {

    @Autowired
    private UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;
    @Autowired
    private Preguntaservice preguntaservice;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PartidaService partidaService;

    /**
     * Obtiene todas las preguntas de un usuario específico.
     *
     * @param id el ID del usuario
     * @return una respuesta con todas las preguntas asociadas al usuario
     */
    @Operation(summary = "Obtener todas las preguntas de un usuario", description = "Retorna todas las preguntas asociadas a un usuario específico")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            Ejemplo a Poñer
                            """)))
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
    @Operation(summary = "Obtener todas las preguntas de una partida", description = "Retorna todas las preguntas asociadas a una partida específica")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "partida": {
                                    "id": 1,
                                    "fechaInicio": "2025-02-11",
                                    "fechaFin": "2025-02-11",
                                    "usuario": {
                                        "id": 2,
                                        "nombre": "Jugador 1",
                                        "email": "jugador1@ejemplo.com"
                                    },
                                    "puntuacion": 15
                                },
                                "respuestas": [
                                    {
                                        "acertada": true,
                                        "pregunta": {
                                            "id": 1,
                                            "pregunta": "¿Quién es el máximo goleador histórico de la NBA?",
                                            "respuestas": [
                                                {
                                                    "id": 4,
                                                    "respuesta": "Michael Jordan",
                                                    "correcta": false
                                                },
                                                {
                                                    "id": 2,
                                                    "respuesta": "Kobe Bryant",
                                                    "correcta": false
                                                },
                                                {
                                                    "id": 3,
                                                    "respuesta": "Kareem Abdul-Jabbar",
                                                    "correcta": true
                                                },
                                                {
                                                    "id": 1,
                                                    "respuesta": "LeBron James",
                                                    "correcta": false
                                                }
                                            ]
                                        }
                                    },
                                    ...
                                   ]
                             }
                            """)))
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
    @ApiResponse(responseCode = "200", description = "Pregunta agregada a la partida",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                  "partida": {
                                      "id": 1,
                                      "fechaInicio": "2025-02-14",
                                      "fechaFin": "2025-02-14",
                                      "usuario": {
                                          "id": 2,
                                          "nombre": "Jugador 1",
                                          "email": "jugador1@ejemplo.com"
                                      },
                                      "puntuacion": 15
                                  },
                                  "acertada": true,
                                  "pregunta": {
                                      "id": 2,
                                      "pregunta": "¿En qué deporte se utiliza una pelota llamada \\"balón\\"?",
                                      "respuestas": [
                                          {
                                              "id": 5,
                                              "respuesta": "Fútbol",
                                              "correcta": true
                                          },
                                          {
                                              "id": 6,
                                              "respuesta": "Tenis",
                                              "correcta": false
                                          },
                                          {
                                              "id": 7,
                                              "respuesta": "Golf",
                                              "correcta": false
                                          },
                                          {
                                              "id": 8,
                                              "respuesta": "Boxeo",
                                              "correcta": false
                                          }
                                      ]
                                  }
                              }
                            """)))
    @PostMapping("/partida")
    public ResponseEntity<?> agregarPreguntasAPartida(
            @Parameter(description = "Datos necesarios para agregar la pregunta a la partida",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          "partidaId": 1,
                                          "preguntaId": 2,
                                          "usuarioId": 2,
                                          "acertada": true
                                        }
                                        """))) @RequestBody AgregarPreguntaRequest request) {
        return usuarioPreguntaPartidaService.agregarPreguntasAPartida(
                request.getPartidaId(), request.getPreguntaId(), request.getUsuarioId(), request.isAcertada());
    }
}