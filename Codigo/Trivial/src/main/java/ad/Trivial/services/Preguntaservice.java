package ad.Trivial.services;

import ad.Trivial.models.Categoria;
import ad.Trivial.models.Pregunta;
import ad.Trivial.models.modelosDTO.PreguntaDTO;
import ad.Trivial.models.modelosDTO.PreguntasDTO;
import ad.Trivial.models.modelosDTO.RespuestaDTO;
import ad.Trivial.repositories.CategoriaRepository;
import ad.Trivial.repositories.PreguntaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class Preguntaservice {

    @Autowired
    PreguntaRepository preguntaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Pregunta> obtenerTodas() {
        return preguntaRepository.findAll();
    }

    public Pregunta guardar(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta actualizar(Pregunta pregunta) {
        if (pregunta.getId() == null) {
            return null;
        } else {
            return preguntaRepository.save(pregunta);
        }
    }

    public void eliminar(Long id) {
        preguntaRepository.deleteById(id);
    }

    public PreguntaDTO obtenerPreguntaDTOPorId(Long id){
        List<PreguntasDTO> preguntasDTO = obtenerTodasLasPreguntasDeTodasLasCategorias(false);
        for (PreguntasDTO preguntas : preguntasDTO){
            for (PreguntaDTO pregunta : preguntas.getPreguntas()){
                if (pregunta.getId().equals(id)){
                    PreguntaDTO preguntaDTO = new PreguntaDTO();
                    preguntaDTO.setId(pregunta.getId());
                    preguntaDTO.setPregunta(pregunta.getPregunta());
                    preguntaDTO.setRespuestas(pregunta.getRespuestas());
                    return preguntaDTO;
                }
            }
        }
        return null;
    }

    public List<Pregunta> obtenerPreguntasPorCategoria(Long id){
        return preguntaRepository.findByCategoriaId(id);
    }

    public Categoria obtenerCategoriaDeUnaPregunta(Long idPregunta){
        AtomicReference<Categoria> categoria = new AtomicReference<>(new Categoria());
        obtenerTodasLasPreguntasDeTodasLasCategorias(false).forEach(preguntasDTO -> {
            preguntasDTO.getPreguntas().forEach(preguntaDTO -> {
                if (preguntaDTO.getId().equals(idPregunta)){
                    categoria.set(preguntasDTO.getCategoria());
                }
            });
        });
        return categoria.get();
    }

    @Transactional
    public void eliminarTodasLasPreguntasDeUnaCategoria(Long id){
        preguntaRepository.deleteAllByCategoriaId(id);
    }

    public Pregunta obtenerLaUltimaPregunta(){
        return preguntaRepository.findLastPregunta();
    }

    public List<PreguntasDTO> obtenerTodasLasPreguntasDeTodasLasCategorias(boolean mezclar){
        List<Categoria> categorias = categoriaRepository.findAll();
        List<PreguntaDTO> preguntasDTO = new ArrayList<>();
        List<PreguntasDTO> preguntasDTOS = new ArrayList<>();
        for (Categoria categoria: categorias){
            preguntasDTOS.add(obtenerPreguntasDeCategoria(categoria.getId(),mezclar));
        }
        return preguntasDTOS;
    }

    //Este metodo solo devuelve preguntas con 4 respuestas solo ni 5 ni 3 solo con 4 todo mezclado
    public PreguntasDTO obtenerPreguntasDeCategoria(Long id, boolean mezclar){
        PreguntasDTO preguntasDTO = new PreguntasDTO();

        // Variables de control
        AtomicBoolean catObtenida = new AtomicBoolean(false);
        Long idPreguntaActual = null;
        int contador = 0;

        Categoria categoria = new Categoria();
        List<PreguntaDTO> listaPreguntasDTO = new ArrayList<>();
        List<RespuestaDTO> listaRespuestasDTO = new ArrayList<>();

        for (Object[] fila : preguntaRepository.preguntasDeUnaCategoria(id)) {
            // Obtener la categoría solo una vez
            if (!catObtenida.get()) {
                categoria.setId(((Number) fila[5]).longValue());
                categoria.setNombre((String) fila[6]);
                categoria.setDescripcion((String) fila[7]);
                catObtenida.set(true);
            }
            if (contador == 0) {
                idPreguntaActual = (Long) fila[3];
            }

            if (contador < 5 && idPreguntaActual.equals((Long) fila[3])) {
                // Agregar respuesta
                RespuestaDTO respuestaDTO = getRespuestaDTO(fila);
                listaRespuestasDTO.add(respuestaDTO);
                contador++;
            } else {
                listaRespuestasDTO.clear();
                idPreguntaActual = (Long) fila[3];
                contador = 0;
                RespuestaDTO respuestaDTO = getRespuestaDTO(fila);
                listaRespuestasDTO.add(respuestaDTO);
                contador++;
            }


            // Si cambiamos de pregunta, validamos la anterior y la guardamos si tiene 4 respuestas
            if (contador == 4 && idPreguntaActual.equals((Long) fila[3])) {
                PreguntaDTO preguntaDTO = new PreguntaDTO();
                preguntaDTO.setId(idPreguntaActual);
                preguntaDTO.setPregunta((String) fila[4]);
                if (mezclar) {
                    Collections.shuffle(listaRespuestasDTO);
                }
                preguntaDTO.setRespuestas(new ArrayList<>(listaRespuestasDTO));
                listaPreguntasDTO.add(preguntaDTO);// Reset para la nueva pregunta
                listaRespuestasDTO = new ArrayList<>();
                contador = 0;
            }



        }

        // Asignar datos al DTO principal
        preguntasDTO.setCategoria(categoria);
        if (mezclar) {
            Collections.shuffle(listaPreguntasDTO);
        }
        preguntasDTO.setPreguntas(listaPreguntasDTO);

        return preguntasDTO;
    }

    private static RespuestaDTO getRespuestaDTO(Object[] fila) {
        // Agregar respuesta
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setId(((Number) fila[0]).longValue());
        respuestaDTO.setRespuesta((String) fila[1]);
        respuestaDTO.setCorrecta((Boolean) fila[2]);
        return respuestaDTO;
    }


    public Pregunta obtenerPorId(Long id) {
        return preguntaRepository.findById(id).orElse(null);
    }
}
