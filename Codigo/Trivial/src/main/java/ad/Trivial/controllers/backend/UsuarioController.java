package ad.Trivial.controllers.backend;

import ad.Trivial.models.Usuario;
import ad.Trivial.services.UsuarioService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/usuarios")
@Hidden
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos(){
        return usuarioService.obtenerTodas();
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario){
        return usuarioService.guardar(usuario);
    }

    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario){
        return usuarioService.actualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        usuarioService.eliminar(id);
    }
}
