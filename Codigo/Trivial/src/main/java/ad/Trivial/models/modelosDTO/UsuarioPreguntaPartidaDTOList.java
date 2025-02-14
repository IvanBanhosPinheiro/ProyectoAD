package ad.Trivial.models.modelosDTO;

import java.util.List;

public class UsuarioPreguntaPartidaDTOList {
    private PartidaDTO partida;
    private List<RespuestasDTO> respuestas;

    public UsuarioPreguntaPartidaDTOList() {
    }


    public PartidaDTO getPartida() {
        return partida;
    }

    public void setPartida(PartidaDTO partida) {
        this.partida = partida;
    }

    public List<RespuestasDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestasDTO> respuestas) {
        this.respuestas = respuestas;
    }
}
