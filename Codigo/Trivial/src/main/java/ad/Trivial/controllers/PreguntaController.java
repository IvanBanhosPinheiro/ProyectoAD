package ad.Trivial.controllers;

import ad.Trivial.models.Pregunta;
import ad.Trivial.services.Preguntaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
