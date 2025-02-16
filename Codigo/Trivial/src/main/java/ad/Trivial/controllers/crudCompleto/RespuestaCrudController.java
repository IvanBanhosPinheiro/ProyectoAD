package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Respuesta;
import ad.Trivial.services.RespuestaService;
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
 * Controlador CRUD para la entidad Respuesta.
 * Proporciona endpoints para realizar operaciones CRUD en las respuestas.
 */
@RestController
@RequestMapping("/crud/respuestas")
@Tag(name = "Crud - Respuestas", description = "Operaciones relacionadas con las respuestas")
public class RespuestaCrudController {

    @Autowired
    private RespuestaService respuestaService;

    /**
     * Obtiene todas las respuestas.
     *
     * @return una lista de todas las respuestas
     */
    @Operation(summary = "Obtener todas las respuestas", description = "Retorna una lista de todas las respuestas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                              {
                                  "id": 485,
                                  "respuesta": "LeBron James",
                                  "esCorrecta": false,
                                  "pregunta": {
                                      "id": 1,
                                      "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                      "categoria": {
                                          "id": 4,
                                          "nombre": "Deportes",
                                          "descripcion": "Preguntas sobre deportes y atletas famosos."
                                      }
                                  }
                              }
                            ]
                            """)))
    @GetMapping
    public List<Respuesta> obtenerTodas(){
        return respuestaService.obtenerTodas();
    }

    /**
     * Guarda una nueva respuesta.
     *
     * @param respuesta la respuesta a guardar
     * @return la respuesta guardada
     */
    @Operation(summary = "Guardar una nueva respuesta", description = "Guarda una nueva respuesta en el sistema")
    @ApiResponse(responseCode = "200", description = "Respuesta guardada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 485,
                                "respuesta": "LeBron James",
                                "esCorrecta": false,
                                "pregunta": {
                                    "id": 1,
                                    "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                    "categoria": {
                                        "id": 4,
                                        "nombre": "Deportes",
                                        "descripcion": "Preguntas sobre deportes y atletas famosos."
                                    }
                                }
                            }
                            """)))
    @PostMapping
    public Respuesta guardar(
            @Parameter(description = "Datos de la respuesta a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Respuesta.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "respuesta": "LeBron James",
                                        "esCorrecta": false,
                                        "pregunta": {
                                            "id": 1,
                                            "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                            "categoria": {
                                                "id": 4,
                                                "nombre": "Deportes",
                                                "descripcion": "Preguntas sobre deportes y atletas famosos."
                                            }
                                        }
                                    }
                                        """))) @RequestBody Respuesta respuesta){
        return respuestaService.guardar(respuesta);
    }

    /**
     * Actualiza una respuesta existente.
     *
     * @param respuesta la respuesta a actualizar
     * @return la respuesta actualizada
     */
    @Operation(summary = "Actualizar una respuesta", description = "Actualiza una respuesta existente en el sistema")
    @ApiResponse(responseCode = "200", description = "Respuesta actualizada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 485,
                                "respuesta": "LeBron James actualizado",
                                "esCorrecta": false,
                                "pregunta": {
                                    "id": 1,
                                    "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                    "categoria": {
                                        "id": 4,
                                        "nombre": "Deportes",
                                        "descripcion": "Preguntas sobre deportes y atletas famosos."
                                    }
                                }
                            }
                            """)))
    @PutMapping
    public Respuesta actualizar(
            @Parameter(description = "Datos de la respuesta a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Respuesta.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id": 485,
                                        "respuesta": "LeBron James actualizado",
                                        "esCorrecta": false,
                                        "pregunta": {
                                            "id": 1,
                                            "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                            "categoria": {
                                                "id": 4,
                                                "nombre": "Deportes",
                                                "descripcion": "Preguntas sobre deportes y atletas famosos."
                                            }
                                        }
                                    }
                                        """))) @RequestBody Respuesta respuesta){
        return respuestaService.actualizar(respuesta);
    }

    /**
     * Elimina una respuesta por su ID.
     *
     * @param id el ID de la respuesta a eliminar
     */
    @Operation(summary = "Eliminar una respuesta", description = "Elimina una respuesta por su ID")
    @ApiResponse(responseCode = "200", description = "Respuesta eliminada con éxito")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID de la respuesta a eliminar", required = true) @PathVariable Long id){
        respuestaService.eliminar(id);
    }
}