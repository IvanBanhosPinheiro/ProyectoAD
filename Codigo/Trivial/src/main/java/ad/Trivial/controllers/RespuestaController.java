package ad.Trivial.controllers;

import ad.Trivial.models.Respuesta;
import ad.Trivial.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> obtenerTodas(){
        return respuestaService.obtenerTodas();
    }
}
