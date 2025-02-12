package ad.Trivial.models.modelosDTO;

import ad.Trivial.models.Categoria;
import ad.Trivial.models.Pregunta;

import java.util.List;

public class PreguntasDTO {
    private Categoria categoria;
    private List<PreguntaDTO> preguntas;

    public PreguntasDTO() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<PreguntaDTO> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }
}
