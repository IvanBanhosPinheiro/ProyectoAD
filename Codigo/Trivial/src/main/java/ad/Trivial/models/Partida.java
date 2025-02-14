package ad.Trivial.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Representa una partida en el sistema.
 */
@Schema(description = "Entidad que representa una partida de trivial")
@Entity
@Table(name = "partida")
public class Partida {

    /**
     * Identificador único de la partida.
     */
    @Schema(description = "Identificador único de la partida.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha de inicio de la partida.
     */
    @Schema(description = "Fecha de inicio de la partida.", example = "2023-10-01")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    /**
     * Fecha de finalización de la partida.
     */
    @Schema(description = "Fecha de finalización de la partida.", example = "2023-10-01")
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaFin;

    /**
     * Puntuación obtenida en la partida.
     */
    @Schema(description = "Puntuación obtenida en la partida.", example = "85")
    private Integer puntuacion;

    /**
     * Usuario que realizó la partida.
     */
    @Schema(description = "Usuario que realizó la partida.")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

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

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}