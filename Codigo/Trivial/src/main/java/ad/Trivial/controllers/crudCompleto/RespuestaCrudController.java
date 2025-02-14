package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Respuesta;
import ad.Trivial.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador CRUD para la entidad Respuesta.
 * Proporciona endpoints para realizar operaciones CRUD en las respuestas.
 */
@RestController
@RequestMapping("/crud/respuestas")
public class RespuestaCrudController {

    @Autowired
    RespuestaService respuestaService;

    /**
     * Obtiene todas las respuestas.
     *
     * @return una lista de todas las respuestas
     */
    @GetMapping
    public List<Respuesta> obtenerTodas(){
        return respuestaService.obtenerTodas();
    }

    /**
     * Guarda una nueva respuesta.
     *
     * @param respuesta la respuesta a guardar
     * @return la respuesta guardada
     */
    @PostMapping
    public Respuesta guardar(@RequestBody Respuesta respuesta){
        return respuestaService.guardar(respuesta);
    }

    /**
     * Actualiza una respuesta existente.
     *
     * @param respuesta la respuesta a actualizar
     * @return la respuesta actualizada
     */
    @PutMapping
    public Respuesta actualizar(@RequestBody Respuesta respuesta){
        return respuestaService.actualizar(respuesta);
    }

    /**
     * Elimina una respuesta por su ID.
     *
     * @param id el ID de la respuesta a eliminar
     */
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        respuestaService.eliminar(id);
    }
}