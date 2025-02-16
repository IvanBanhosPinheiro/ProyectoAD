package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Partida;
import ad.Trivial.models.modelosDTO.AgregarPreguntaRequest;
import ad.Trivial.services.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador CRUD para la entidad Partida.
 * Proporciona endpoints para realizar operaciones CRUD en las partidas.
 */
@RestController
@RequestMapping("/crud/partidas")
@Tag(name = "Crud - Partida", description = "Operaciones relacionadas con las partidas")
public class PartidaCrudController {

    @Autowired
    private PartidaService partidaService;

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
                                    "fechaInicio": "2025-02-11",
                                    "fechaFin": "2025-02-11",
                                    "puntuacion": 15,
                                    "usuario": {
                                        "id": 2,
                                        "nombre": "Jugador 1",
                                        "email": "jugador1@ejemplo.com",
                                        "contraseña": "contraseña_segura",
                                        "rol": "usuario"
                                    }
                                }
                            ]
                            """)))
    @GetMapping
    public List<Partida> obtenerTodas(){
        return partidaService.obtenerTodas();
    }

    /**
     * Guarda una nueva partida.
     *
     * @param partida la partida a guardar
     * @return la partida guardada
     */
    @Operation(summary = "Guardar una nueva partida", description = "Guarda una nueva partida en el sistema")
    @ApiResponse(responseCode = "200", description = "Partida guardada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 3,
                                "fechaInicio": "2025-02-14",
                                "fechaFin": "2025-02-14",
                                "puntuacion": 16,
                                "usuario": {
                                    "id": 2,
                                    "nombre": "Jugador 1",
                                    "email": "jugador1@ejemplo.com",
                                    "contraseña": "contraseña_segura",
                                    "rol": "usuario"
                                }
                            }
                            """)))
    @PostMapping
    public Partida guardar(
            @Parameter(description = "Datos de la partida a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Partida.class),
                            examples = @ExampleObject(value = """
                                        {
                                            "fechaInicio": "2025-02-14",
                                            "fechaFin": "2025-02-14",
                                            "puntuacion": 16,
                                            "usuario": {
                                                "id": 2,
                                                "nombre": "Jugador 1",
                                                "email": "jugador1@ejemplo.com",
                                                "contraseña": "contraseña_segura",
                                                "rol": "usuario"
                                            }
                                        }
                                        """))) @RequestBody Partida partida){
        return partidaService.guardar(partida);
    }

    /**
     * Actualiza una partida existente.
     *
     * @param partida la partida a actualizar
     * @return la partida actualizada
     */
    @Operation(summary = "Actualizar una partida", description = "Actualiza una partida existente en el sistema")
    @ApiResponse(responseCode = "200", description = "Partida actualizada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 3,
                                "fechaInicio": "2025-02-14",
                                "fechaFin": "2025-02-14",
                                "puntuacion": 16,
                                "usuario": {
                                    "id": 2,
                                    "nombre": "Jugador 1",
                                    "email": "jugador1@ejemplo.com",
                                    "contraseña": "contraseña_segura",
                                    "rol": "usuario"
                                }
                            }
                            """)))
    @PutMapping
    public Partida actualizar(
            @Parameter(description = "Datos de la partida a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Partida.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id": 3,
                                        "fechaInicio": "2025-02-14",
                                        "fechaFin": "2025-02-14",
                                        "puntuacion": 18,
                                        "usuario": {
                                            "id": 2,
                                            "nombre": "Jugador 1",
                                            "email": "jugador1@ejemplo.com",
                                            "contraseña": "contraseña_segura",
                                            "rol": "usuario"
                                        }
                                    }
                                        """))) @RequestBody Partida partida){
        return partidaService.actualizar(partida);
    }

    /**
     * Elimina una partida por su ID.
     *
     * @param id el ID de la partida a eliminar
     */
    @Operation(summary = "Eliminar una partida por ID", description = "Elimina una partida específica por su ID")
    @ApiResponse(responseCode = "200", description = "Partida eliminada con éxito")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID de la partida a eliminar", required = true) @PathVariable Long id){
        partidaService.eliminarPorId(id);
    }
}