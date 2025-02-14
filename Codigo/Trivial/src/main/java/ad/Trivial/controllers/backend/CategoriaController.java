package ad.Trivial.controllers.backend;

import ad.Trivial.models.Categoria;
import ad.Trivial.services.CategoriaService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/h2-console

@Controller
@RequestMapping("/admin/categorias")
@Hidden
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public String obtenerTodas(Model model){
        model.addAttribute("categorias", categoriaService.obtenerTodas());
        // Si no se ha pasado un objeto "categoria", se crea uno vacío para el formulario
        if (!model.containsAttribute("categoria")) {
            model.addAttribute("categoria", new Categoria());
        }
        return "admin/categorias";
    }

    // Edita una categoría: se carga el objeto y se muestra en la misma vista
    @GetMapping("/edit/{id}")
    public String editCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("categorias", categoriaService.obtenerTodas());
        return "admin/categorias";
    }


    @PostMapping("/save")
    public String guardar(@ModelAttribute Categoria categoria){
        categoriaService.guardar(categoria);
        return "redirect:/admin/categorias";
    }


    @GetMapping("/delete/{id}")
    public String borrar(@PathVariable Long id){
        categoriaService.eliminar(id);
        return "redirect:/admin/categorias";
    }
}
