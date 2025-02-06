package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Representa el registro de una pregunta respondida por un usuario en una partida.
 */

@Entity
@Table(name = "usuario_pregunta_partida")
public class UsuarioPreguntaPartida {

    /**
     * Identificador compuesto: usuario, pregunta y partida.
     */
    @EmbeddedId
    private UsuarioPreguntaPartidaId id;

    /**
     * Indica si la respuesta fue acertada.
     */
    @Schema(description = "Indica si la respuesta fue acertada.", example = "true")
    private boolean acertada;

    /**
     * Clave primaria compuesta.
     */
    @Embeddable
    public static class UsuarioPreguntaPartidaId implements java.io.Serializable {

        @Schema(description = "Identificador del usuario.", example = "1")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario;

        @Schema(description = "Identificador de la pregunta.", example = "1")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "pregunta_id", nullable = false)
        private Pregunta pregunta;

        @Schema(description = "Identificador de la partida.", example = "1")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "partida_id", nullable = false)
        private Partida partida;
    }

    public UsuarioPreguntaPartida() {
    }

    public UsuarioPreguntaPartidaId getId() {
        return id;
    }

    public void setId(UsuarioPreguntaPartidaId id) {
        this.id = id;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }
}
