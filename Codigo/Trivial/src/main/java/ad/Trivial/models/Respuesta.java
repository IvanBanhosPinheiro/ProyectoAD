package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Representa una respuesta a una pregunta.
 */
@Schema(description = "Entidad que representa una posible respuesta a una pregunta")
@Entity
@Table(name = "respuesta")
public class Respuesta {

    /**
     * Identificador único de la respuesta.
     */
    @Schema(description = "Identificador único de la respuesta.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Texto de la respuesta.
     */
    @Schema(description = "Texto de la respuesta.", example = "El Nilo", maxLength = 250)
    @Column(name = "texto", nullable = false, length = 250)
    private String respuesta;

    /**
     * Indica si la respuesta es correcta.
     */
    @Schema(description = "Indica si la respuesta es correcta.", example = "true")
    @Column(nullable = false)
    private boolean esCorrecta;

    /**
     * Pregunta a la que pertenece la respuesta.
     */
    @Schema(description = "Pregunta a la que pertenece la respuesta.")
    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    public Respuesta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}