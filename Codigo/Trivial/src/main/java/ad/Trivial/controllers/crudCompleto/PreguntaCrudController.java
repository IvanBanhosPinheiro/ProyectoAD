package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Pregunta;
import ad.Trivial.models.modelosDTO.PreguntasDTO;
import ad.Trivial.services.Preguntaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador CRUD para la entidad Pregunta.
 * Proporciona endpoints para realizar operaciones CRUD en las preguntas.
 */
@RestController
@RequestMapping("/crud/preguntas")
public class PreguntaCrudController {

    @Autowired
    Preguntaservice preguntaservice;

    /**
     * Obtiene todas las preguntas.
     *
     * @return una lista de todas las preguntas
     */
    @GetMapping
    public List<Pregunta> obtenerTodas(){
        return preguntaservice.obtenerTodas();
    }

    /**
     * Obtiene preguntas de una categoría específica.
     *
     * @param idcat el ID de la categoría
     * @return una lista de preguntas de la categoría especificada
     */
    @GetMapping("/{idcat}")
    public PreguntasDTO obtenerPreguntasCategoria(@PathVariable Long idcat){
        return preguntaservice.obtenerPreguntasDeCategoria(idcat);
    }

    /**
     * Guarda una nueva pregunta.
     *
     * @param pregunta la pregunta a guardar
     * @return la pregunta guardada
     */
    @PostMapping
    public Pregunta guardar(@RequestBody Pregunta pregunta){
        return preguntaservice.guardar(pregunta);
    }

    /**
     * Actualiza una pregunta existente.
     *
     * @param pregunta la pregunta a actualizar
     * @return la pregunta actualizada
     */
    @PutMapping
    public Pregunta actualizar(@RequestBody Pregunta pregunta){
        return preguntaservice.actualizar(pregunta);
    }

    /**
     * Elimina una pregunta por su ID.
     *
     * @param id el ID de la pregunta a eliminar
     */
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        preguntaservice.eliminar(id);
    }
}