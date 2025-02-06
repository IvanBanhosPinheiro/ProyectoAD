package ad.Trivial.controllers;

import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/UsPrPa")
public class UsuarioPreguntaPartidaController {

    @Autowired
    UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

    @GetMapping
    public List<UsuarioPreguntaPartida> obtenerTodas(){
        return usuarioPreguntaPartidaService.obtenerTodas();
    }
}
