package ad.Trivial.controllers;

import ad.Trivial.models.Categoria;
import ad.Trivial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
