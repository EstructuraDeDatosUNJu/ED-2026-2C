package ed2026.PI_I.G104;

import java.util.List;

public class ResultadoRonda {
    private Jugador ganador;
    private List<Naipe> pozoMesa;
    private String tipoResultado;

    public ResultadoRonda(Jugador ganador, List<Naipe> pozoMesa, String tipoResultado) {
        this.ganador = ganador;
        this.pozoMesa = pozoMesa;
        this.tipoResultado = tipoResultado;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public List<Naipe> getPozoMesa() {
        return pozoMesa;
    }

    public String getTipoResultado() {
        return tipoResultado;
    }
}