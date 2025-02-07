package ad.Trivial.controllers;

import ad.Trivial.models.Partida;
import ad.Trivial.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
public class PartidaController {

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

    @PutMapping
    public Partida actualizar(@RequestBody Partida partida){
        return partidaService.actualizar(partida);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        partidaService.eliminar(id);
    }
}
