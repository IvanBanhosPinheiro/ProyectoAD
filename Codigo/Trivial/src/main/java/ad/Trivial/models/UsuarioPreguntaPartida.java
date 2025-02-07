package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Representa el registro de una pregunta respondida por un usuario en una partida.
 */
@Schema(description = "Entidad que almacena las respuestas de un usuario en una partida")
@Entity
@Table(name = "usuario_pregunta_partida")
public class UsuarioPreguntaPartida {

    /**
     * Identificador Unico: usuario_pregunta_partida.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del registro", example = "1")
    private Long id;

    /**
     * Indica si la respuesta fue acertada.
     */
    @Schema(description = "Indica si la respuesta fue acertada.", example = "true")
    @Column(nullable = false)
    private boolean acertada;

    /**
     * Usuario que respondió la pregunta
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @Schema(description = "Usuario que respondió la pregunta")
    private Usuario usuario;

    /**
     * Pregunta que fue respondida
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pregunta_id")
    @Schema(description = "Pregunta que fue respondida")
    private Pregunta pregunta;

    /**
     * Partida en la que se respondió la pregunta
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partida_id")
    @Schema(description = "Partida en la que se respondió la pregunta")
    private Partida partida;

    public UsuarioPreguntaPartida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
