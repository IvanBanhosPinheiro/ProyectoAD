package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Categoria;
import ad.Trivial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/h2-console
//http://localhost:8080/swagger-ui.html
@RestController
@RequestMapping("/crud/categorias")
public class CategoriaCrudController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerTodas(){
        return  categoriaService.obtenerTodas();
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }

    @PutMapping
    public Categoria actualizar(@RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }


    @DeleteMapping
    public void borrar(@PathVariable Long id){
        categoriaService.eliminar(id);
    }
}
