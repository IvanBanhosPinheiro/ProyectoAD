package ad.Trivial.controllers.crudCompleto;

import ad.Trivial.models.Partida;
import ad.Trivial.services.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador CRUD para la entidad Partida.
 * Proporciona endpoints para realizar operaciones CRUD en las partidas.
 */
@RestController
@RequestMapping("/crud/partidas")
@Tag(name = "Partida", description = "Operaciones relacionadas con las partidas")
public class PartidaCrudController {

    @Autowired
    PartidaService partidaService;

    /**
     * Obtiene todas las partidas.
     *
     * @return una lista de todas las partidas
     */
    @Operation(summary = "Obtener todas las partidas", description = "Retorna una lista de todas las partidas")
    @GetMapping
    public List<Partida> obtenerTodas(){
        return partidaService.obtenerTodas();
    }

    /**
     * Guarda una nueva partida.
     *
     * @param partida la partida a guardar
     * @return la partida guardada
     */
    @Operation(summary = "Guardar una nueva partida", description = "Guarda una nueva partida en el sistema")
    @PostMapping
    public Partida guardar(
            @Parameter(description = "Datos de la partida a guardar", required = true) @RequestBody Partida partida){
        return partidaService.guardar(partida);
    }

    /**
     * Actualiza una partida existente.
     *
     * @param partida la partida a actualizar
     * @return la partida actualizada
     */
    @Operation(summary = "Actualizar una partida", description = "Actualiza una partida existente en el sistema")
    @PutMapping
    public Partida actualizar(
            @Parameter(description = "Datos de la partida a actualizar", required = true) @RequestBody Partida partida){
        return partidaService.actualizar(partida);
    }

    /**
     * Elimina una partida por su ID.
     *
     * @param id el ID de la partida a eliminar
     */
    @Operation(summary = "Eliminar una partida por ID", description = "Elimina una partida específica por su ID")
    @DeleteMapping("/{id}")
    public void borrar(
            @Parameter(description = "ID de la partida a eliminar", required = true) @PathVariable Long id){
        partidaService.eliminarPorId(id);
    }
}