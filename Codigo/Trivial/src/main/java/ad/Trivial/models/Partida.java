package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;

/**
 * Representa una partida en el sistema.
 */

@Entity
@Table(name = "partida")
public class Partida {

    /**
     * Identificador único de la partida.
     */
    @Schema(description = "Identificador único de la partida.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha de inicio de la partida.
     */
    @Schema(description = "Fecha de inicio de la partida.", example = "2023-10-01T12:00:00Z")
    @Column(nullable = false)
    private Date fechaInicio;

    /**
     * Fecha de finalización de la partida.
     */
    @Schema(description = "Fecha de finalización de la partida.", example = "2023-10-01T12:30:00Z")
    @Column
    private Date fechaFin;

    /**
     * Puntuación obtenida en la partida.
     */
    @Schema(description = "Puntuación obtenida en la partida.", example = "85")
    private Integer puntuación;

    /**
     * Usuario que realizó la partida.
     */
    @Schema(description = "Usuario que realizó la partida.", accessMode = Schema.AccessMode.READ_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Registros de preguntas respondidas por el usuario en la partida.
     */
    /*@Schema(description = "Registros de preguntas respondidas por el usuario en la partida.", accessMode = Schema.AccessMode.READ_ONLY)
    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuarioPreguntaPartida> registros;*/

    public Partida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getPuntuación() {
        return puntuación;
    }

    public void setPuntuación(Integer puntuación) {
        this.puntuación = puntuación;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*public List<UsuarioPreguntaPartida> getRegistros() {
        return registros;
    }

    public void setRegistros(List<UsuarioPreguntaPartida> registros) {
        this.registros = registros;
    }*/
}
