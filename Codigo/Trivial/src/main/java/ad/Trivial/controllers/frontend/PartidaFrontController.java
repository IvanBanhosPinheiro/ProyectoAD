package ad.Trivial.controllers.frontend;

import ad.Trivial.models.modelosDTO.PartidaDTO;
import ad.Trivial.models.modelosDTO.UsuariODTO;
import ad.Trivial.services.PartidaService;
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
 * Controlador para la entidad Partida en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con las partidas.
 */
@RestController
@RequestMapping("/api/partidas")
@Tag(name = "Api - Partida", description = "Operaciones relacionadas con las partidas")
public class PartidaFrontController {

    @Autowired
    private PartidaService partidaService;
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todas las partidas.
     *
     * @return una lista de todas las partidas
     */
    @Operation(summary = "Obtener todas las partidas", description = "Retorna una lista de todas las partidas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                                {
                                    "id": 1,
                                    "fechaInicio": "2025-02-14",
                                    "fechaFin": "2025-02-14",
                                    "usuario": {
                                        "id": 2,
                                        "nombre": "Jugador 1",
                                        "email": "jugador1@ejemplo.com"
                                    },
                                    "puntuacion": 15
                                }
                            ]
                            """)))
    @GetMapping
    public List<PartidaDTO> obtenerTodas(){
        return partidaService.obtenerTodasDTO();
    }

    /**
     * Obtiene una partida por su ID.
     *
     * @param id el ID de la partida
     * @return la partida especificada por su ID
     */
    @Operation(summary = "Obtener una partida por ID", description = "Retorna una partida específica por su ID")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                                {
                                    "id": 1,
                                    "fechaInicio": "2025-02-14",
                                    "fechaFin": "2025-02-14",
                                    "usuario": {
                                        "id": 2,
                                        "nombre": "Jugador 1",
                                        "email": "jugador1@ejemplo.com"
                                    },
                                    "puntuacion": 15
                                }
                            ]
                            """)))
    @GetMapping("/{id}")
    public PartidaDTO obtenerPorId(
            @Parameter(description = "ID de la partida", required = true) @PathVariable Long id){
        return partidaService.obtenerPorIDDTO(id);
    }

    /**
     * Guarda una nueva partida.
     *
     * @param partidaDTO los datos de la partida a guardar
     * @return la respuesta de la entidad guardada
     */
    @Operation(summary = "Guardar una nueva partida", description = "Guarda una nueva partida en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 2,
                                "fechaInicio": "2025-02-14",
                                "fechaFin": "2025-02-15",
                                "usuario": {
                                    "id": 2,
                                    "nombre": "Jugador 1",
                                    "email": "jugador1@ejemplo.com"
                                },
                                "puntuacion": 20
                            }
                            """)))
    @PostMapping
    public ResponseEntity<?> guardar(
            @Parameter(description = "Datos de la partida a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PartidaDTO.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "fechaInicio": "2025-02-14",
                                        "fechaFin": "2025-02-15",
                                        "usuario": {
                                            "id": 2
                                        },
                                        "puntuacion": 20
                                    }
                                        """))) @RequestBody PartidaDTO partidaDTO){
        UsuariODTO usuario = (UsuariODTO) usuarioService.obtenerPorIdDTO(partidaDTO.getUsuario().getId()).getBody();
        if (usuario == null){
            return ResponseEntity.badRequest().body("El usuario especificado no existe.");
        }
        partidaDTO.setUsuario(usuario);
        return partidaService.guardarDTO(partidaDTO);
    }

}