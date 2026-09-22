package ed2026.PI_I.G104;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private List<Naipe> pozoAcumuladoAnterior;

    public Ronda() {
        this.pozoAcumuladoAnterior = new ArrayList<>();
    }

    public ResultadoRonda evaluarRonda(Jugador[] jugadores, Naipe[] cartasMesa) {
        int valorMaximo = -1;
        for (Naipe n : cartasMesa) {
            if (n != null && n.getValor() > valorMaximo) {
                valorMaximo = n.getValor();
            }
        }

        List<Integer> indicesGanadores = new ArrayList<>();
        for (int i = 0; i < cartasMesa.length; i++) {
            if (cartasMesa[i] != null && cartasMesa[i].getValor() == valorMaximo) {
                indicesGanadores.add(i);
            }
        }

        int cantidadEmpatados = indicesGanadores.size();
        List<Naipe> pozoRondaActual = new ArrayList<>();
        for (Naipe n : cartasMesa) {
            if (n != null) {
                pozoRondaActual.add(n);
            }
        }

        // Regla 1: Ganador único de la ronda
        if (cantidadEmpatados == 1) {
            Jugador ganador = jugadores[indicesGanadores.get(0)];
            pozoRondaActual.addAll(pozoAcumuladoAnterior);
            pozoAcumuladoAnterior.clear();

            for (Naipe n : pozoRondaActual) {
                ganador.agregarCartaGanada(n);
            }

            return new ResultadoRonda(ganador, pozoRondaActual, "GANADOR_UNICO");
        }
        // Reglas 2 y 3: Empate múltiple (cada jugador conserva/recupera su naipe)
        else if (cantidadEmpatados == 2 || cantidadEmpatados == 3) {
            for (int i = 0; i < jugadores.length; i++) {
                if (cartasMesa[i] != null) {
                    jugadores[i].agregarCartaGanada(cartasMesa[i]);
                }
            }

            Jugador mejorPuntaje = jugadores[indicesGanadores.get(0)];
            for (int idx : indicesGanadores) {
                if (jugadores[idx].getPuntaje() > mejorPuntaje.getPuntaje()) {
                    mejorPuntaje = jugadores[idx];
                }
            }

            return new ResultadoRonda(mejorPuntaje, pozoRondaActual, "EMPATE_MULTIPLE");
        }
        // Regla 4: Empate cuádruple
        else {
            for (int i = 0; i < jugadores.length; i++) {
                if (cartasMesa[i] != null) {
                    jugadores[i].agregarCartaGanada(cartasMesa[i]);
                }
            }
            pozoAcumuladoAnterior.addAll(pozoRondaActual);

            return new ResultadoRonda(null, pozoRondaActual, "EMPATE_CUADRUPLE");
        }
    }
}