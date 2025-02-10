package ad.Trivial.controllers.backend;

import ad.Trivial.models.Categoria;
import ad.Trivial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/h2-console

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerTodas(){
        return categoriaService.obtenerTodas();
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }

    @PutMapping
    public Categoria actualizar(@RequestBody Categoria categoria){
        return categoriaService.actualizar(categoria);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        categoriaService.eliminar(id);
    }
}
