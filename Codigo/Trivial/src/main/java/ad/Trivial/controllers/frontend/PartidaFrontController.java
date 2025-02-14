package ad.Trivial.controllers.frontend;

import ad.Trivial.models.modelosDTO.PartidaDTO;
import ad.Trivial.services.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la entidad Partida en el frontend.
 * Proporciona endpoints para realizar operaciones relacionadas con las partidas.
 */
@RestController
@RequestMapping("/api/partidas")
@Tag(name = "Partida", description = "Operaciones relacionadas con las partidas")
public class PartidaFrontController {

    @Autowired
    PartidaService partidaService;

    /**
     * Obtiene todas las partidas.
     *
     * @return una lista de todas las partidas
     */
    @Operation(summary = "Obtener todas las partidas", description = "Retorna una lista de todas las partidas")
    @GetMapping
    public List<PartidaDTO> obtenerTodas(){
        return partidaService.obtenerTodasDTO();
    }

    /**
     * Obtiene una partida por su ID.
     *
     * @param id el ID de la partida
     * @return la partida especificada por su ID
     */
    @Operation(summary = "Obtener una partida por ID", description = "Retorna una partida específica por su ID")
    @GetMapping("/{id}")
    public PartidaDTO obtenerPorId(
            @Parameter(description = "ID de la partida", required = true) @PathVariable Long id){
        return partidaService.obtenerPorIDDTO(id);
    }

    /**
     * Guarda una nueva partida.
     *
     * @param partidaDTO los datos de la partida a guardar
     * @return la respuesta de la entidad guardada
     */
    @Operation(summary = "Guardar una nueva partida", description = "Guarda una nueva partida en el sistema")
    @PostMapping
    public ResponseEntity<?> guardar(
            @Parameter(description = "Datos de la partida a guardar", required = true) @RequestBody PartidaDTO partidaDTO){
        return partidaService.guardarDTO(partidaDTO);
    }

    /**
     * Elimina una partida por su ID.
     *
     * @param id el ID de la partida a eliminar
     */
    @Operation(summary = "Eliminar una partida por ID", description = "Elimina una partida específica por su ID")
    @DeleteMapping("/{id}")
    public void eliminar(
            @Parameter(description = "ID de la partida a eliminar", required = true) @PathVariable Long id){
        partidaService.eliminarPorId(id);
    }
}