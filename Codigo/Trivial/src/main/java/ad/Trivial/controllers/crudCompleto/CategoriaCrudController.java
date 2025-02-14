package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Categoria;
import ad.Trivial.services.CategoriaService;
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
 * Controlador CRUD para la entidad Categoria.
 * Proporciona endpoints para realizar operaciones CRUD en las categorías.
 */
@RestController
@RequestMapping("/crud/categorias")
@Tag(name = "Crud - Categoria", description = "Operaciones relacionadas con las categorías")
public class CategoriaCrudController {
    @Autowired
    CategoriaService categoriaService;

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
        return  categoriaService.obtenerTodas();
    }

    /**
     * Guarda una nueva categoría.
     *
     * @param categoria la categoría a guardar
     * @return la categoría guardada
     */
    @Operation(summary = "Guardar una nueva categoría", description = "Guarda una nueva categoría en el sistema")
    @ApiResponse(responseCode = "200", description = "Categoría guardada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                               "id": 1,
                               "nombre": "Historia",
                               "descripcion": "Preguntas relacionadas con eventos históricos y personajes importantes."
                            }
                            """)))
    @PostMapping
    public Categoria guardar(
            @Parameter(description = "Datos de la categoría a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
                                        }
                                        """))) @RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }

    /**
     * Actualiza una categoría existente.
     *
     * @param categoria la categoría a actualizar
     * @return la categoría actualizada
     */
    @Operation(summary = "Actualizar una categoría", description = "Actualiza una categoría existente en el sistema")
    @ApiResponse(responseCode = "200", description = "Categoría actualizada con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                               "id": 1,
                               "nombre": "Historia",
                               "descripcion": "Preguntas relacionadas con eventos históricos y personajes importantes."
                            }
                            """)))
    @PutMapping
    public Categoria actualizar(
            @Parameter(description = "Datos de la categoría a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
                                        }
                                        """))) @RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }

    /**
     * Elimina una categoría por su ID.
     *
     * @param id el ID de la categoría a eliminar
     */
    @Operation(summary = "Eliminar una categoría por ID", description = "Elimina una categoría específica por su ID")
    @ApiResponse(responseCode = "200", description = "Categoría eliminada con éxito")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID de la categoría a eliminar", required = true) @PathVariable Long id){
        categoriaService.eliminar(id);
    }
}