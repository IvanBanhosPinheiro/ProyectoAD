package ad.Trivial.controllers.frontend;

import ad.Trivial.models.Partida;
import ad.Trivial.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas55")
public class PartidaFrontController {
    @Autowired
    PartidaService partidaService;

    @GetMapping
    public List<Partida> obtenerTodas(){
        return partidaService.obtenerTodas();
    }

    @PostMapping
    public Partida guardar(@RequestBody Partida partida){
        return partidaService.guardar(partida);
    }
}
