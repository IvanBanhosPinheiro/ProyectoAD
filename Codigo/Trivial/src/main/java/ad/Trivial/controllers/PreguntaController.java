package ad.Trivial.controllers;

import ad.Trivial.models.Pregunta;
import ad.Trivial.services.Preguntaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    Preguntaservice preguntaservice;

    @GetMapping
    public List<Pregunta> obtenerTodas(){
        return preguntaservice.obtenerTodas();
    }

    @PostMapping
    public Pregunta guardar(@RequestBody Pregunta pregunta){
        return preguntaservice.guardar(pregunta);
    }

    @PutMapping
    public Pregunta actualizar(@RequestBody Pregunta pregunta){
        return preguntaservice.actualizar(pregunta);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        preguntaservice.eliminar(id);
    }
}
