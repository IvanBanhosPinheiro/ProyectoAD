package ad.Trivial.models.modelosDTO;

public class UsuarioPreguntaPartidaDTO {
    private UsuariODTO usuario;
    private PartidaDTO partida;
    private boolean acertada;
    private PreguntaDTO pregunta;

    public UsuarioPreguntaPartidaDTO() {
    }

    public UsuariODTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariODTO usuario) {
        this.usuario = usuario;
    }

    public PartidaDTO getPartida() {
        return partida;
    }

    public void setPartida(PartidaDTO partida) {
        this.partida = partida;
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
