package ad.Trivial.controllers.frontend;

import ad.Trivial.models.Partida;
import ad.Trivial.models.modelosDTO.PartidaDTO;
import ad.Trivial.services.PartidaService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/partidas")
public class PartidaFrontController {
    @Autowired
    PartidaService partidaService;

    @GetMapping
    public List<PartidaDTO> obtenerTodas(){
        return partidaService.obtenerTodasDTO();
    }

    @GetMapping("/{id}")
    public PartidaDTO obtenerPorId(@PathVariable Long id){
        return partidaService.obtenerPorIDDTO(id);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody PartidaDTO partidaDTO){
        return partidaService.guardarDTO(partidaDTO);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Partida partida){
        partidaService.eliminar(partida);
    }
}
