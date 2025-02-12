package ad.Trivial.controllers.backend;

import ad.Trivial.models.Categoria;
import ad.Trivial.models.Partida;
import ad.Trivial.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/partidas")
public class PartidaController {

    @Autowired
    PartidaService partidaService;

    @GetMapping
    public String  obtenerTodas(Model model){
        model.addAttribute("partidas", partidaService.obtenerTodas());
        // Si no se ha pasado un objeto "categoria", se crea uno vacío para el formulario
        if (!model.containsAttribute("partida")) {
            model.addAttribute("partida", new Partida());
        }
        return "admin/partidas";
    }

    // Edita una categoría: se carga el objeto y se muestra en la misma vista
    @GetMapping("/edit/{id}")
    public String editCategoria(@PathVariable Long id, Model model) {
        Partida partida = partidaService.obtenerPorID(id);
        System.out.println(partida.getId());
        model.addAttribute("partida", partida);
        model.addAttribute("partidas", partidaService.obtenerTodas());
        return "admin/partidas";
    }


    @PostMapping("/save")
    public String guardar(@ModelAttribute Partida partida){
        partidaService.guardar(partida);
        return "redirect:/admin/partidas";
    }


    @GetMapping("/delete/{id}")
    public String borrar(@PathVariable Long id){
        partidaService.eliminar(id);
        return "redirect:/admin/partidas";
    }
}
