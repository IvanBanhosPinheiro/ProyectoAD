package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Usuario;
import ad.Trivial.services.UsuarioService;
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
 * Controlador CRUD para la entidad Usuario.
 * Proporciona endpoints para realizar operaciones CRUD en los usuarios.
 */
@RestController
@RequestMapping("/crud/usuarios")
@Tag(name = "Crud - Usuarios", description = "Operaciones relacionadas con los usuarios")
public class UsuarioCrudController {

    @Autowired
    UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios.
     *
     * @return una lista de todos los usuarios
     */
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna una lista de todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                              {
                                "id": 1,
                                "nombre": "Juan Perez",
                                "email": "juan.perez@example.com"
                              }
                            ]
                            """)))
    @GetMapping
    public List<Usuario> obtenerTodos(){
        return usuarioService.obtenerTodas();
    }

    /**
     * Guarda un nuevo usuario.
     *
     * @param usuario el usuario a guardar
     * @return el usuario guardado
     */
    @Operation(summary = "Guardar un nuevo usuario", description = "Guarda un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "200", description = "Usuario guardado con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                              "id": 1,
                              "nombre": "Juan Perez",
                              "email": "juan.perez@example.com"
                            }
                            """)))
    @PostMapping
    public Usuario guardar(
            @Parameter(description = "Datos del usuario a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
                                        }
                                        """))) @RequestBody Usuario usuario){
        return usuarioService.guardar(usuario);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param usuario el usuario a actualizar
     * @return el usuario actualizado
     */
    @Operation(summary = "Actualizar un usuario", description = "Actualiza un usuario existente en el sistema")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                              "id": 1,
                              "nombre": "Juan Perez",
                              "email": "juan.perez@example.com"
                            }
                            """)))
    @PutMapping
    public Usuario actualizar(
            @Parameter(description = "Datos del usuario a actualizar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
                                        }
                                        """))) @RequestBody Usuario usuario){
        return usuarioService.actualizar(usuario);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario a eliminar
     */
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario por su ID")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID del usuario a eliminar", required = true) @PathVariable Long id){
        usuarioService.eliminar(id);
    }
}