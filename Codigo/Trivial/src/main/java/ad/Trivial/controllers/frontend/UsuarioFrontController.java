package ad.Trivial.controllers.frontend;

import ad.Trivial.models.Usuario;
import ad.Trivial.models.modelosDTO.UsuariODTO;
import ad.Trivial.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Tag(name = "Usuario", description = "Operaciones relacionadas con los usuarios")
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
    @PostMapping
    public ResponseEntity<?> guardar(
            @Parameter(description = "Datos del usuario a guardar", required = true) @RequestBody Usuario usuario){
        return usuarioService.guardarFront(usuario);
    }

}