package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Usuario;
import ad.Trivial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador CRUD para la entidad Usuario.
 * Proporciona endpoints para realizar operaciones CRUD en los usuarios.
 */
@RestController
@RequestMapping("/crud/usuarios")
public class UsuarioCrudController {

    @Autowired
    UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios.
     *
     * @return una lista de todos los usuarios
     */
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
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario){
        return usuarioService.guardar(usuario);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param usuario el usuario a actualizar
     * @return el usuario actualizado
     */
    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario){
        return usuarioService.actualizar(usuario);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario a eliminar
     */
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        usuarioService.eliminar(id);
    }
}