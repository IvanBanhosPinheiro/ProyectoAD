package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
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
 * Controlador CRUD para la entidad UsuarioPreguntaPartida.
 * Proporciona endpoints para realizar operaciones CRUD en las relaciones entre usuarios, preguntas y partidas.
 */
@RestController
@RequestMapping("/crud/UsPrPa")
@Tag(name = "Crud - Usuario Pregunta Partida", description = "Operaciones relacionadas a Usuario Pregunta Partida")
public class UsuarioPreguntaPartidaCrudController {

    @Autowired
    UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

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
                                "partidaId": 1,
                                "preguntaId": 2,
                                "usuarioId": 3,
                                "acertada": true
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
                              "partidaId": 1,
                              "preguntaId": 2,
                              "usuarioId": 3,
                              "acertada": true
                            }
                            """)))
    @PostMapping
    public UsuarioPreguntaPartida guardar(
            @Parameter(description = "Datos de la relación UsuarioPreguntaPartida a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
                                        }
                                        """))) @RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaService.guardar(usuarioPreguntaPartida);
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
                              "partidaId": 1,
                              "preguntaId": 2,
                              "usuarioId": 3,
                              "acertada": true
                            }
                            """)))
    @PutMapping
    public UsuarioPreguntaPartida actualizar(
            @Parameter(description = "Datos de la relación UsuarioPreguntaPartida a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
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