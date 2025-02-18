package ad.Trivial.controllers.backend;

import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.services.Preguntaservice;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
import ad.Trivial.services.UsuarioService;
import ad.Trivial.services.PartidaService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador para gestionar las entidades UsuarioPreguntaPartida.
 * Proporciona endpoints para operaciones CRUD.
 */
@Controller
@RequestMapping("/admin/usrprepar")
@Hidden
public class UsuarioPreguntaPartidaController {

    @Autowired
    private UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private Preguntaservice preguntaService;

    @Autowired
    private PartidaService partidaService;

    /**
     * Recupera todas las entidades UsuarioPreguntaPartida.
     *
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista para mostrar la lista de entidades UsuarioPreguntaPartida
     */
    @GetMapping
    public String obtenerTodas(Model model) {
        model.addAttribute("usuarioPreguntaPartidas", usuarioPreguntaPartidaService.obtenerTodas());
        if (!model.containsAttribute("usuarioPreguntaPartida")) {
            model.addAttribute("usuarioPreguntaPartida", new UsuarioPreguntaPartida());
        }
        return "admin/usrprepar";
    }

    @GetMapping("/edit/{id}")
    public String editUsuarioPreguntaPartida(@PathVariable Long id, Model model) {
        model.addAttribute("usuarioPreguntaPartidas", usuarioPreguntaPartidaService.obtenerTodas());
        if (!model.containsAttribute("usuarioPreguntaPartida")) {
            model.addAttribute("usuarioPreguntaPartida", new UsuarioPreguntaPartida());
        }
        UsuarioPreguntaPartida usuarioPreguntaPartida = usuarioPreguntaPartidaService.obtenerPorId(id);
        if (usuarioPreguntaPartida != null) {
            model.addAttribute("usuarioPreguntaPartida", usuarioPreguntaPartida);
        } else {
            model.addAttribute("usuarioPreguntaPartida", new UsuarioPreguntaPartida());
        }
        return "admin/usrprepar";
    }


    /**
     * Guarda o actualiza una nueva entidad UsuarioPreguntaPartida.
     *
     * @param usuarioPreguntaPartida la entidad a guardar
     * @return la URL de redirección después de guardar la entidad
     */
    @PostMapping({"/save", "/actualizar"})
    public String guardar(@ModelAttribute UsuarioPreguntaPartida usuarioPreguntaPartida) {
        if (preguntaService.obtenerPorId(usuarioPreguntaPartida.getPregunta().getId()) == null) {
            return "redirect:/admin/usrprepar";
        }
        if(usuarioService.obtenerPorId(usuarioPreguntaPartida.getUsuario().getId()) == null){
            return "redirect:/admin/usrprepar";
        }
        usuarioPreguntaPartidaService.guardar(usuarioPreguntaPartida);
        return "redirect:/admin/usrprepar";
    }


    /**
     * Elimina una entidad UsuarioPreguntaPartida por ID.
     *
     * @param id el ID de la entidad a eliminar
     * @return la URL de redirección después de eliminar la entidad
     */
    @GetMapping("/delete/{id}")
    public String borrar(@PathVariable Long id) {
        usuarioPreguntaPartidaService.eliminar(id);
        return "redirect:/admin/usrprepar";
    }
}