package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Respuesta;
import ad.Trivial.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud/respuestas")
public class RespuestaCrudController {

    @Autowired
    RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> obtenerTodas(){
        return respuestaService.obtenerTodas();
    }

    @PostMapping
    public Respuesta guardar(@RequestBody Respuesta respuesta){
        return respuestaService.guardar(respuesta);
    }

    @PutMapping
    public Respuesta actualizar(@RequestBody Respuesta respuesta){
        return respuestaService.actualizar(respuesta);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        respuestaService.eliminar(id);
    }
}
