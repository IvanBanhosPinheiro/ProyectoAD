package ad.Trivial.models.modelosDTO;

public class RespuestasDTO {
    private boolean acertada;
    private PreguntaDTO pregunta;

    public RespuestasDTO() {
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }

    public PreguntaDTO getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaDTO pregunta) {
        this.pregunta = pregunta;
    }
}
