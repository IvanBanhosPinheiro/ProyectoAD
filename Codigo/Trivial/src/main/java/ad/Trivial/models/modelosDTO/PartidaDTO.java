package ad.Trivial.models.modelosDTO;

import java.util.Date;

public class PartidaDTO {
    private Long id;
    private Date fechaInicio;
    private Date fechaFin;
    private UsuariODTO usuario;
    private Integer puntuacion;

    public PartidaDTO() {
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

    public UsuariODTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariODTO usuario) {
        this.usuario = usuario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
