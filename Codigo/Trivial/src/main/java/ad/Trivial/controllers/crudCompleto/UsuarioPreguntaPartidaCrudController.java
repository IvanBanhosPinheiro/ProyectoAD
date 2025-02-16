package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Pregunta;
import ad.Trivial.models.Usuario;
import ad.Trivial.models.UsuarioPreguntaPartida;
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

import java.util.List;

/**
 * Controlador CRUD para la entidad UsuarioPreguntaPartida.
 * Proporciona endpoints para realizar operaciones CRUD en las relaciones entre usuarios, preguntas y partidas.
 */
@RestController
@RequestMapping("/crud/UsPrPa")
@Tag(name = "Crud - Usuario Pregunta Partida", description = "Operaciones relacionadas a Usuario Pregunta Partida")
public class UsuarioPreguntaPartidaCrudController {

    @Autowired
    private UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;
    @Autowired
    private Preguntaservice preguntaservice;
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todas las relaciones UsuarioPreguntaPartida.
     *
     * @return una lista de todas las relaciones UsuarioPreguntaPartida
     */
    @Operation(summary = "Obtener todas las relaciones UsuarioPreguntaPartida", description = "Retorna una lista de todas las relaciones UsuarioPreguntaPartida")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                              {
                                  "id": 1,
                                  "acertada": true,
                                  "usuario": {
                                      "id": 2,
                                      "nombre": "Jugador 1",
                                      "email": "jugador1@ejemplo.com",
                                      "contraseña": "contraseña_segura",
                                      "rol": "usuario"
                                  },
                                  "pregunta": {
                                      "id": 1,
                                      "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                      "categoria": {
                                          "id": 4,
                                          "nombre": "Deportes",
                                          "descripcion": "Preguntas sobre deportes y atletas famosos."
                                      }
                                  },
                                  "partida": {
                                      "id": 1,
                                      "fechaInicio": "2025-02-14",
                                      "fechaFin": "2025-02-14",
                                      "puntuacion": 15,
                                      "usuario": {
                                          "id": 2,
                                          "nombre": "Jugador 1",
                                          "email": "jugador1@ejemplo.com",
                                          "contraseña": "contraseña_segura",
                                          "rol": "usuario"
                                      }
                                  }
                              }
                            ]
                            """)))
    @GetMapping
    public List<UsuarioPreguntaPartida> obtenerTodas(){
        return usuarioPreguntaPartidaService.obtenerTodas();
    }

    /**
     * Guarda una nueva relación UsuarioPreguntaPartida.
     *
     * @param usuarioPreguntaPartida la relación UsuarioPreguntaPartida a guardar
     * @return la relación UsuarioPreguntaPartida guardada
     */
    @Operation(summary = "Guardar una nueva relación UsuarioPreguntaPartida", description = "Guarda una nueva relación UsuarioPreguntaPartida en el sistema")
    @ApiResponse(responseCode = "200", description = "Relación guardada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 23,
                                "acertada": true,
                                "usuario": {
                                    "id": 2,
                                    "nombre": "Jugador 1",
                                    "email": "jugador1@ejemplo.com",
                                    "contraseña": "contraseña_segura",
                                    "rol": "usuario"
                                },
                                "pregunta": {
                                    "id": 1,
                                    "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                    "categoria": {
                                        "id": 4,
                                        "nombre": "Deportes",
                                        "descripcion": "Preguntas sobre deportes y atletas famosos."
                                    }
                                },
                                "partida": {
                                    "id": 1,
                                    "fechaInicio": "2025-02-14",
                                    "fechaFin": "2025-02-14",
                                    "puntuacion": null,
                                    "usuario": null
                                }
                            }
                            """)))
    @PostMapping
    public ResponseEntity<UsuarioPreguntaPartida> guardar(
            @Parameter(description = "Datos de la relación UsuarioPreguntaPartida a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioPreguntaPartida.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "acertada": true,
                                        "usuario": {
                                            "id": 2
                                        },
                                        "pregunta": {
                                            "id": 1
                                        },
                                        "partida": {
                                            "id": 1,
                                            "fechaInicio": "2025-02-14",
                                            "fechaFin": "2025-02-14"
                                        }
                                    }
                                        """))) @RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        Pregunta pregunta = preguntaservice.obtenerPorId(usuarioPreguntaPartida.getPregunta().getId());
        if (pregunta == null) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = usuarioService.obtenerPorId(usuarioPreguntaPartida.getUsuario().getId());
        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }
        if (usuarioPreguntaPartida.getPartida().getFechaInicio() ==null){
            return ResponseEntity.badRequest().build();
        }
        usuarioPreguntaPartida.setPregunta(pregunta);
        usuarioPreguntaPartida.setUsuario(usuario);
        return ResponseEntity.ok(usuarioPreguntaPartidaService.guardar(usuarioPreguntaPartida));
    }

    /**
     * Actualiza una relación UsuarioPreguntaPartida existente.
     *
     * @param usuarioPreguntaPartida la relación UsuarioPreguntaPartida a actualizar
     * @return la relación UsuarioPreguntaPartida actualizada
     */
    @Operation(summary = "Actualizar una relación UsuarioPreguntaPartida", description = "Actualiza una relación UsuarioPreguntaPartida existente en el sistema")
    @ApiResponse(responseCode = "200", description = "Relación actualizada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 23,
                                "acertada": false,
                                "usuario": {
                                    "id": 2,
                                    "nombre": "Jugador 1",
                                    "email": "jugador1@ejemplo.com",
                                    "contraseña": "contraseña_segura",
                                    "rol": "usuario"
                                },
                                "pregunta": {
                                    "id": 1,
                                    "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                    "categoria": {
                                        "id": 4,
                                        "nombre": "Deportes",
                                        "descripcion": "Preguntas sobre deportes y atletas famosos."
                                    }
                                },
                                "partida": {
                                    "id": 1,
                                    "fechaInicio": "2025-02-14",
                                    "fechaFin": "2025-02-14",
                                    "puntuacion": 15,
                                    "usuario": {
                                        "id": 2,
                                        "nombre": "Jugador 1",
                                        "email": "jugador1@ejemplo.com",
                                        "contraseña": "contraseña_segura",
                                        "rol": "usuario"
                                    }
                                }
                            }
                            """)))
    @PutMapping
    public UsuarioPreguntaPartida actualizar(
            @Parameter(description = "Datos de la relación UsuarioPreguntaPartida a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioPreguntaPartida.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id":23,
                                        "acertada": false,
                                        "usuario": {
                                            "id": 2
                                        },
                                        "pregunta": {
                                            "id": 1
                                        },
                                        "partida": {
                                            "id": 1,
                                            "fechaInicio": "2025-02-14",
                                            "fechaFin": "2025-02-15"
                                        }
                                    }
                                        """))) @RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaService.actualizar(usuarioPreguntaPartida);
    }

    /**
     * Elimina una relación UsuarioPreguntaPartida por su ID.
     *
     * @param id el ID de la relación UsuarioPreguntaPartida a eliminar
     */
    @Operation(summary = "Eliminar una relación UsuarioPreguntaPartida", description = "Elimina una relación UsuarioPreguntaPartida por su ID")
    @ApiResponse(responseCode = "200", description = "Relación eliminada con éxito")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID de la relación UsuarioPreguntaPartida a eliminar", required = true) @PathVariable Long id){
        usuarioPreguntaPartidaService.eliminar(id);
    }
}