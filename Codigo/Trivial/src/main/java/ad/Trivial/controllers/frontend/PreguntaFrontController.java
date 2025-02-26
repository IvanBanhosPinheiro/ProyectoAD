package ad.Trivial.controllers.frontend;

import ad.Trivial.models.modelosDTO.PreguntasDTO;
import ad.Trivial.services.Preguntaservice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la entidad Pregunta en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con las preguntas.
 */
@RestController
@RequestMapping("/api/preguntas")
@Tag(name = "Api - Preguntas", description = "Operaciones relacionadas con las preguntas")
public class PreguntaFrontController {

    @Autowired
    private Preguntaservice preguntaservice;

    /**
     * Obtiene todas las preguntas.
     *
     * @return una lista de todas las preguntas de todas las categorías
     */
    @Operation(summary = "Obtener todas las preguntas", description = "Retorna una lista de todas las preguntas de todas las categorías")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
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
                                                    "id": 430,
                                                    "respuesta": "476 d.C.",
                                                    "correcta": true
                                                },
                                                {
                                                    "id": 432,
                                                    "respuesta": "600 d.C.",
                                                    "correcta": false
                                                },
                                                {
                                                    "id": 429,
                                                    "respuesta": "410 d.C.",
                                                    "correcta": false
                                                },
                                                {
                                                    "id": 431,
                                                    "respuesta": "533 d.C.",
                                                    "correcta": false
                                                }
                                            ]
                                        }
                                    ]
                            """)))
    @GetMapping
    public List<PreguntasDTO> obtenerTodas() {
        return preguntaservice.obtenerTodasLasPreguntasDeTodasLasCategorias(true);
    }

    /**
     * Obtiene preguntas de una categoría específica, limitada por la cantidad especificada.
     *
     * @param id el ID de la categoría
     * @param cantidad el número de preguntas a retornar
     * @return una lista de preguntas de la categoría especificada, limitada por la cantidad especificada
     */
    @Operation(summary = "Obtener preguntas limitadas por categoría", description = "Retorna una lista de preguntas de una categoría específica, limitada por la cantidad especificada")
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
                                        "id": 115,
                                        "pregunta": "¿En qué año se inauguró el Canal de Panamá?",
                                        "respuestas": [
                                            {
                                                "id": 459,
                                                "respuesta": "1920",
                                                "correcta": false
                                            },
                                            {
                                                "id": 458,
                                                "respuesta": "1914",
                                                "correcta": true
                                            },
                                            {
                                                "id": 460,
                                                "respuesta": "1930",
                                                "correcta": false
                                            },
                                            {
                                                "id": 457,
                                                "respuesta": "1900",
                                                "correcta": false
                                            }
                                        ]
                                    }
                                ]
                            }
                            """)))
    @GetMapping("/categoria/{id}")
    public ResponseEntity<?> obtenerLimitadasPorCategorias(
            @Parameter(description = "ID de la categoría", required = true) @PathVariable Long id,
            @Parameter(description = "Número de preguntas a retornar", required = false) @RequestParam(name = "numero", required = false) Integer cantidad) {
        if (cantidad != null) {
            PreguntasDTO preguntasDTO = preguntaservice.obtenerPreguntasDeCategoria(id,true);

            if (cantidad > preguntasDTO.getPreguntas().size()) {
                return ResponseEntity.status(400).body("Error: La solicitud es inválida");
            } else {
                preguntasDTO.setPreguntas(new ArrayList<>(preguntasDTO.getPreguntas().subList(0, cantidad)));
                return ResponseEntity.ok(preguntasDTO);
            }
        } else {
            return ResponseEntity.ok(preguntaservice.obtenerPreguntasDeCategoria(id,true));
        }
    }
}