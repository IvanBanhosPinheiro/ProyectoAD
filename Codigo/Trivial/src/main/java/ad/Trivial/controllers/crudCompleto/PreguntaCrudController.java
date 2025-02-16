package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Pregunta;
import ad.Trivial.models.modelosDTO.PreguntasDTO;
import ad.Trivial.services.Preguntaservice;
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
 * Controlador CRUD para la entidad Pregunta.
 * Proporciona endpoints para realizar operaciones CRUD en las preguntas.
 */
@RestController
@RequestMapping("/crud/preguntas")
@Tag(name = "Crud - Preguntas", description = "Operaciones relacionadas con las preguntas")
public class PreguntaCrudController {

    @Autowired
    private Preguntaservice preguntaservice;

    /**
     * Obtiene todas las preguntas.
     *
     * @return una lista de todas las preguntas
     */
    @Operation(summary = "Obtener todas las preguntas", description = "Retorna una lista de todas las preguntas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                                {
                                    "id": 1,
                                    "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                    "categoria": {
                                        "id": 4,
                                        "nombre": "Deportes",
                                        "descripcion": "Preguntas sobre deportes y atletas famosos."
                                    }
                                }
                            ]
                            """)))
    @GetMapping
    public List<Pregunta> obtenerTodas(){
        // Llama al servicio para obtener todas las preguntas
        return preguntaservice.obtenerTodas();
    }

    /**
     * Obtiene preguntas de una categoría específica.
     *
     * @param idcat el ID de la categoría
     * @return una lista de preguntas de la categoría especificada
     */
    @Operation(summary = "Obtener preguntas por categoría", description = "Retorna una lista de preguntas de una categoría específica")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "categoria": {
                                    "id": 1,
                                    "nombre": "Historia",
                                    "descripcion": "Preguntas relacionadas con eventos históricos y personajes importantes."
                                },
                                "preguntas": [
                                    {
                                        "id": 108,
                                        "pregunta": "¿En qué año se produjo la caída del Imperio Romano de Occidente?",
                                        "respuestas": [
                                            {
                                                "id": 432,
                                                "respuesta": "600 d.C.",
                                                "correcta": false
                                            },
                                            {
                                                "id": 431,
                                                "respuesta": "533 d.C.",
                                                "correcta": false
                                            },
                                            {
                                                "id": 430,
                                                "respuesta": "476 d.C.",
                                                "correcta": true
                                            },
                                            {
                                                "id": 429,
                                                "respuesta": "410 d.C.",
                                                "correcta": false
                                            }
                                        ]
                                    }
                            }
                            """)))
    @GetMapping("/{idcat}")
    public PreguntasDTO obtenerPreguntasCategoria(
            @Parameter(description = "ID de la categoría", required = true) @PathVariable Long idcat){
        // Llama al servicio para obtener preguntas de una categoría específica
        return preguntaservice.obtenerPreguntasDeCategoria(idcat,true);
    }

    /**
     * Guarda una nueva pregunta.
     *
     * @param pregunta la pregunta a guardar
     * @return la pregunta guardada
     */
    @Operation(summary = "Guardar una nueva pregunta", description = "Guarda una nueva pregunta en el sistema")
    @ApiResponse(responseCode = "200", description = "Pregunta guardada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 121,
                                "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                "categoria": {
                                    "id": 4,
                                    "nombre": "Deportes",
                                    "descripcion": "Preguntas sobre deportes y atletas famosos."
                                }
                            }
                            """)))
    @PostMapping
    public Pregunta guardar(
            @Parameter(description = "Datos de la pregunta a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pregunta.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                        "categoria": {
                                            "id": 4,
                                            "nombre": "Deportes",
                                            "descripcion": "Preguntas sobre deportes y atletas famosos."
                                        }
                                    }
                                        """))) @RequestBody Pregunta pregunta){
        // Llama al servicio para guardar una nueva pregunta
        return preguntaservice.guardar(pregunta);
    }

    /**
     * Actualiza una pregunta existente.
     *
     * @param pregunta la pregunta a actualizar
     * @return la pregunta actualizada
     */
    @Operation(summary = "Actualizar una pregunta", description = "Actualiza una pregunta existente en el sistema")
    @ApiResponse(responseCode = "200", description = "Pregunta actualizada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 121,
                                "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                "categoria": {
                                    "id": 4,
                                    "nombre": "Deportes",
                                    "descripcion": "Preguntas sobre deportes y atletas famosos."
                                }
                            }
                            """)))
    @PutMapping
    public Pregunta actualizar(
            @Parameter(description = "Datos de la pregunta a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pregunta.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "id": 121,
                                        "texto": "¿Quién es el máximo goleador histórico de la NBA?",
                                        "categoria": {
                                            "id": 4,
                                            "nombre": "Deportes",
                                            "descripcion": "Preguntas sobre deportes y atletas famosos."
                                        }
                                    }
                                        """))) @RequestBody Pregunta pregunta){
        // Llama al servicio para actualizar una pregunta existente
        return preguntaservice.actualizar(pregunta);
    }

    /**
     * Elimina una pregunta por su ID.
     *
     * @param id el ID de la pregunta a eliminar
     */
    @Operation(summary = "Eliminar una pregunta", description = "Elimina una pregunta por su ID")
    @ApiResponse(responseCode = "200", description = "Pregunta eliminada con éxito")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID de la pregunta a eliminar", required = true) @PathVariable Long id){
        // Llama al servicio para eliminar una pregunta por su ID
        preguntaservice.eliminar(id);
    }
}