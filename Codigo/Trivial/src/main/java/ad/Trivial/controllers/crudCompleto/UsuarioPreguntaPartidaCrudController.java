package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.UsuarioPreguntaPartida;
import ad.Trivial.services.UsuarioPreguntaPartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador CRUD para la entidad UsuarioPreguntaPartida.
 * Proporciona endpoints para realizar operaciones CRUD en las relaciones entre usuarios, preguntas y partidas.
 */
@RestController
@RequestMapping("/crud/UsPrPa")
public class UsuarioPreguntaPartidaCrudController {

    @Autowired
    UsuarioPreguntaPartidaService usuarioPreguntaPartidaService;

    /**
     * Obtiene todas las relaciones UsuarioPreguntaPartida.
     *
     * @return una lista de todas las relaciones UsuarioPreguntaPartida
     */
    @GetMapping
    public List<UsuarioPreguntaPartida> obtenerTodas(){
        return usuarioPreguntaPartidaService.obtenerTodas();
    }

    /**
     * Guarda una nueva relación UsuarioPreguntaPartida.
     *
     * @param usuarioPreguntaPartida la relación UsuarioPreguntaPartida a guardar
     * @return la relación UsuarioPreguntaPartida guardada
     */
    @PostMapping
    public UsuarioPreguntaPartida guardar(@RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaService.guardar(usuarioPreguntaPartida);
    }

    /**
     * Actualiza una relación UsuarioPreguntaPartida existente.
     *
     * @param usuarioPreguntaPartida la relación UsuarioPreguntaPartida a actualizar
     * @return la relación UsuarioPreguntaPartida actualizada
     */
    @PutMapping
    public UsuarioPreguntaPartida actualizar(@RequestBody UsuarioPreguntaPartida usuarioPreguntaPartida){
        return usuarioPreguntaPartidaService.actualizar(usuarioPreguntaPartida);
    }

    /**
     * Elimina una relación UsuarioPreguntaPartida por su ID.
     *
     * @param id el ID de la relación UsuarioPreguntaPartida a eliminar
     */
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        usuarioPreguntaPartidaService.eliminar(id);
    }
}