package ad.Trivial.controllers.frontend;



import ad.Trivial.models.modelosDTO.PreguntasDTO;
import ad.Trivial.services.Preguntaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/preguntas")
public class PreguntaFrontController {

    @Autowired
    private Preguntaservice preguntaservice;

    @GetMapping
    public List<PreguntasDTO> obtenerTodas(){
        return preguntaservice.obtenerTodasLasPreguntasDeTodasLasCategorias();
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<?> obtenerLimitadasPorCategorias(@PathVariable Long id, @RequestParam(name = "numero", required = false) Integer cantidad){
        if (cantidad != null) {
            PreguntasDTO preguntasDTO = preguntaservice.obtenerPreguntasDeCategoria(id);

            if (cantidad > preguntasDTO.getPreguntas().size()) {
                return ResponseEntity.status(400).body("Error: La solicitud es inválida");
            } else {
                preguntasDTO.setPreguntas(new ArrayList<>(preguntasDTO.getPreguntas().subList(0,cantidad)));
                return ResponseEntity.ok(preguntasDTO);
            }
        }else {
            return ResponseEntity.ok(preguntaservice.obtenerPreguntasDeCategoria(id));
        }
    }
}
