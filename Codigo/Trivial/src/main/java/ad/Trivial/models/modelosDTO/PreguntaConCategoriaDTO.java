package ad.Trivial.models.modelosDTO;

import ad.Trivial.models.Categoria;


public class PreguntaConCategoriaDTO {
    private PreguntaDTO pregunta;
    private Categoria categoria;

    public PreguntaConCategoriaDTO() {
    }

    public PreguntaDTO getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaDTO pregunta) {
        this.pregunta = pregunta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
