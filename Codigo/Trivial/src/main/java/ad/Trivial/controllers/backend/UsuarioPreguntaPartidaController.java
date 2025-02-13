package ad.Trivial.controllers.backend;

import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/UsPrPa")
public class UsuarioPreguntaPartidaController {

    @Autowired
    UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

    @GetMapping
    public List<UsuarioPreguntaPartida> obtenerTodas(){
        return usuarioPreguntaPartidaService.obtenerTodas();
    }

    @PostMapping
    public UsuarioPreguntaPartida guardar(@RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaService.guardar(usuarioPreguntaPartida);
    }

    @PutMapping
    public UsuarioPreguntaPartida actualizar(@RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaService.actualizar(usuarioPreguntaPartida);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        usuarioPreguntaPartidaService.eliminar(id);
    }
}
