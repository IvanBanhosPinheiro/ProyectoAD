package ad.Trivial.controllers.frontend;

import ad.Trivial.models.Usuario;
import ad.Trivial.models.modelosDTO.UsuariODTO;
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

/**
 * Controlador para la entidad Usuario en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con los usuarios.
 */
@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Api - Usuario", description = "Operaciones relacionadas con los usuarios")
public class UsuarioFrontController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id el ID del usuario
     * @return el usuario especificado por su ID
     */
    @Operation(summary = "Obtener un usuario por ID", description = "Retorna un usuario específico por su ID")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            Ejemplo a Poñer
                            """)))
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Long id){
        return usuarioService.obtenerPorId(id);
    }

    /**
     * Guarda un nuevo usuario.
     *
     * @param usuario los datos del usuario a guardar
     * @return la respuesta de la entidad guardada
     */
    @Operation(summary = "Guardar un nuevo usuario", description = "Guarda un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            Ejemplo a Poñer
                            """)))
    @PostMapping
    public ResponseEntity<?> guardar(
            @Parameter(description = "Datos del usuario a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ad.Trivial.models.dto.AgregarPreguntaRequest.class),
                            examples = @ExampleObject(value = """
                                        {
                                          Añadir
                                        }
                                        """))) @RequestBody Usuario usuario){
        return usuarioService.guardarFront(usuario);
    }

}