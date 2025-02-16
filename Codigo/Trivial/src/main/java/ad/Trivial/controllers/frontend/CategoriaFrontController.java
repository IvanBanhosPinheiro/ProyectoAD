package ad.Trivial.controllers.frontend;

import ad.Trivial.models.Categoria;
import ad.Trivial.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador para la entidad Categoria en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con las categorías.
 */
@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Api - Categoria", description = "Operaciones relacionadas con las categorías")
public class CategoriaFrontController {

    @Autowired
    private CategoriaService categoriaService;

    /**
     * Obtiene todas las categorías.
     *
     * @return una lista de todas las categorías
     */
    @Operation(summary = "Obtener todas las categorías", description = "Retorna una lista de todas las categorías")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                                {
                                    "id": 1,
                                    "nombre": "Historia",
                                    "descripcion": "Preguntas relacionadas con eventos históricos y personajes importantes."
                                }
                            ]
                            """)))
    @GetMapping
    public List<Categoria> obtenerTodas(){
        return categoriaService.obtenerTodas();
    }
}