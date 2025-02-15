package ad.Trivial.controllers.backend;

import ad.Trivial.models.Categoria;
import ad.Trivial.models.Pregunta;
import ad.Trivial.models.Respuesta;
import ad.Trivial.models.modelosDTO.PreguntaConCategoriaDTO;
import ad.Trivial.models.modelosDTO.PreguntaDTO;
import ad.Trivial.models.modelosDTO.PreguntasDTO;
import ad.Trivial.models.modelosDTO.RespuestaDTO;
import ad.Trivial.services.CategoriaService;
import ad.Trivial.services.Preguntaservice;
import ad.Trivial.services.RespuestaService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/preguntas")
@Hidden
public class PreguntaController {

    @Autowired
    Preguntaservice preguntaservice;
    @Autowired
    RespuestaService respuestaService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public String obtenerTodas(Model model){
        List<PreguntasDTO> preguntasDTO = preguntaservice.obtenerTodasLasPreguntasDeTodasLasCategorias(false);
        model.addAttribute("preguntasDTOList", preguntasDTO);
        // Si no se ha pasado un objeto "pregunta", se crea uno vacío para el formulario
        if (!model.containsAttribute("pregunta")) {
            model.addAttribute("pregunta", preguntaVacia());
        }
        return "admin/preguntas";
    }

    @GetMapping("/edit/{id}")
    public String editPregunta(@PathVariable Long id, Model model) {
        PreguntaDTO preguntaDTO = preguntaservice.obtenerPreguntaDTOPorId(id);
        Categoria categoria = preguntaservice.obtenerCategoriaDeUnaPregunta(id);
        PreguntaConCategoriaDTO preguntaConCategoriaDTO = new PreguntaConCategoriaDTO();
        preguntaConCategoriaDTO.setCategoria(categoria);
        preguntaConCategoriaDTO.setPregunta(preguntaDTO);
        model.addAttribute("pregunta", preguntaConCategoriaDTO);
        model.addAttribute("preguntasDTOList", preguntaservice.obtenerTodasLasPreguntasDeTodasLasCategorias(false));
        return "admin/preguntas";
    }


    private  PreguntaConCategoriaDTO preguntaVacia() {
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        preguntaDTO.setRespuestas(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            preguntaDTO.getRespuestas().add(new RespuestaDTO());
        }
        PreguntaConCategoriaDTO preguntaConCategoriaDTO = new PreguntaConCategoriaDTO();
        preguntaConCategoriaDTO.setPregunta(preguntaDTO);
        preguntaConCategoriaDTO.setCategoria(new Categoria());
        return preguntaConCategoriaDTO;
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("pregunta") PreguntaConCategoriaDTO preguntaConCategoriaDTO) {
        Categoria categoria = categoriaService.obtenerPorId(preguntaConCategoriaDTO.getCategoria().getId());
        if (categoria == null) {
            return "redirect:/admin/preguntas";
        }

        int contador = 0;
        for (RespuestaDTO respuestaDTO : preguntaConCategoriaDTO.getPregunta().getRespuestas()) {
            if (respuestaDTO.getCorrecta()) {
                contador++;
            }
        }
        if (contador != 1) {
            return "redirect:/admin/preguntas";
        }

        PreguntaDTO preguntaDTO = preguntaConCategoriaDTO.getPregunta();

        Pregunta pregunta = new Pregunta();
        pregunta.setId(preguntaDTO.getId());
        pregunta.setTexto(preguntaDTO.getPregunta());
        pregunta.setCategoria(categoria);
        preguntaservice.guardar(pregunta);

        pregunta = preguntaservice.obtenerLaUltimaPregunta();

        for (RespuestaDTO respuestaDTO : preguntaDTO.getRespuestas()) {
            Respuesta respuesta = new Respuesta();
            respuesta.setRespuesta(respuestaDTO.getRespuesta());
            respuesta.setEsCorrecta(respuestaDTO.getCorrecta());
            respuesta.setPregunta(pregunta);
            respuestaService.guardar(respuesta);
        }

        return "redirect:/admin/preguntas";
    }

    @GetMapping("/delete/{id}")
    public String borrar(@PathVariable Long id){
        try {
            respuestaService.eliminarTodasLasRespuestasDeUnaPregunta(id);
            preguntaservice.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/preguntas";
        }

        return "redirect:/admin/preguntas";
    }
}