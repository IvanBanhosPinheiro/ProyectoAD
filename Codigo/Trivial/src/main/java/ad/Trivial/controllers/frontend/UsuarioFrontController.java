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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la entidad Usuario en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con los usuarios.
 */
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Api - Usuario", description = "Operaciones relacionadas con los usuarios")
public class UsuarioFrontController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios menos los administradores.
     *
     * @return lista de usuarios
     */
    @Operation(summary = "Obtener todos los usuarios que no son administradores", description = "Retorna una lista de usuarios que no son administradores")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            [
                                {
                                    "id": 1,
                                    "nombre": "Admin Usuario",
                                    "email": "admin@ejemplo.com"
                                }
                            ]
                            """)))
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        return usuarioService.obtenerTodosSinAdministradoresDTO();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param email el ID del usuario
     * @return el usuario especificado por su ID
     */
    @Operation(summary = "Obtener un usuario por email", description = "Retorna un usuario específico por su email")
    @ApiResponse(responseCode = "200", description = "Objeto obtenido con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 1,
                                "nombre": "Admin Usuario",
                                "email": "admin@ejemplo.com"
                            }
                            """)))
    @GetMapping("/{email}")
    public ResponseEntity<UsuariODTO> obtenerPorId(
            @Parameter(description = "Email del usuario", required = true) @PathVariable String email){
        return usuarioService.obtenerPorEmail(email);
    }

    /**
     * Guarda un nuevo usuario.
     *
     * @param usuario los datos del usuario a guardar
     * @return la respuesta de la entidad guardada
     */
    @Operation(summary = "Guardar un nuevo usuario", description = "Guarda un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "200", description = "Guardado con éxito",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                            {
                                "id": 5,
                                "nombre": "Jugador 3",
                                "email": "jugador3@ejemplo.com"
                            }
                            """)))
    @PostMapping
    public ResponseEntity<?> guardar(
            @Parameter(description = "Datos del usuario a guardar", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class),
                            examples = @ExampleObject(value = """
                                    {
                                        "nombre": "Jugador 3",
                                        "email": "jugador3@ejemplo.com",
                                        "contraseña": "contraseña_segura"
                                    }
                                        """))) @RequestBody Usuario usuario){
        usuario.setContraseña(new BCryptPasswordEncoder().encode(usuario.getContraseña()));
        usuario.setRol(Usuario.Rol.usuario);
        return usuarioService.guardarFront(usuario);
    }

}