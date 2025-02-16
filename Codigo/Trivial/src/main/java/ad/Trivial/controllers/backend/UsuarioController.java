package ad.Trivial.controllers.backend;

import ad.Trivial.models.Usuario;
import ad.Trivial.services.PartidaService;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
import ad.Trivial.services.UsuarioService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/usuarios")
@Hidden
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PartidaService partidaService;
    @Autowired
    private UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

    @GetMapping
    public String obtenerTodos(Model model){
        List<Usuario> usuarios = usuarioService.obtenerTodas();
        model.addAttribute("usuarios", usuarios);
        if (!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", new Usuario());
        }
        return "admin/usuarios";
    }

    @GetMapping("/edit/{id}")
    public String editUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obtenerPorIdAdmin(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute("usuario", new Usuario());
        }
        model.addAttribute("usuarios", usuarioService.obtenerTodas());
        return "admin/usuarios";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuario usuario){
        usuarioService.guardar(usuario);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String borrar(@PathVariable Long id) {
        try {
            usuarioPreguntaPartidaService.borrarTodosPorUsuarioID(id);

            partidaService.eliminarPorUsuarioID(id);

            usuarioService.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/usuarios?error=usuario";
        }

        return "redirect:/admin/usuarios";
    }
}