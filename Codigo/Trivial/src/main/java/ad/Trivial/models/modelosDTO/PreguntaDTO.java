package ad.Trivial.models.modelosDTO;

import java.util.List;

public class PreguntaDTO {
    private  Long id;
    private String pregunta;
    private List<RespuestaDTO> respuestas;

    public PreguntaDTO(Long id, String pregunta, List<RespuestaDTO> respuestas) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public PreguntaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<RespuestaDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaDTO> respuestas) {
        this.respuestas = respuestas;
    }
}
