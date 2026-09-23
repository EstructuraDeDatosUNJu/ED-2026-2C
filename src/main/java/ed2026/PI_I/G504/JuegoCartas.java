package ed2026.PI_I.G504;

import java.util.Random;

public class JuegoCartas {
    private jugador[] jugadores;
    private pilaCartas mazo;

    public JuegoCartas(jugador[] jugadores) {
        this.jugadores = jugadores;
        this.mazo = new pilaCartas(52);
        inicializarYMezclarMazo();
    }

    private void inicializarYMezclarMazo() {
        String[] palos = { "Trébol", "Pica", "Corazón", "Diamante" };
        carta[] temp = new carta[52];
        int index = 0;

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                temp[index++] = new carta(palo, valor);
            }
        }

        // Mezclar cartas 
        Random rand = new Random();
        for (int i = 0; i < temp.length; i++) {
            int r = rand.nextInt(temp.length);
            carta swap = temp[i];
            temp[i] = temp[r];
            temp[r] = swap;
        }

        // Apilar en el mazo
        for (carta c : temp) {
            mazo.meterCarta(c);
        }
    }

    public void jugar(int numRondas) {
        System.out.println("=== INICIO DEL JUEGO ===\n");

        for (int r = 1; r <= numRondas; r++) {
            if (mazo.estaVacia()) {
                System.out.println("El mazo se ha quedado sin cartas.");
                break;
            }

            System.out.println("--- Ronda " + r + " ---");
            carta[] cartasRonda = new carta[jugadores.length];

            // Cada jugador saca una carta
            for (int i = 0; i < jugadores.length; i++) {
                if (!mazo.estaVacia()) {
                    cartasRonda[i] = mazo.sacarCarta();
                    cartasRonda[i].setDisponible(false);
                    System.out.println(jugadores[i].getNombre() + " sacó: " + cartasRonda[i]);
                }
            }

            // Determinar la carta con valor máximo
            int maxValor = -1;
            for (carta c : cartasRonda) {
                if (c != null && c.getValor() > maxValor) {
                    maxValor = c.getValor();
                }
            }

            // Contar cuántos jugadores obtuvieron ese valor máximo
            int ganadoresCount = 0;
            int indiceGanador = -1;
            for (int i = 0; i < cartasRonda.length; i++) {
                if (cartasRonda[i] != null && cartasRonda[i].getValor() == maxValor) {
                    ganadoresCount++;
                    indiceGanador = i;
                }
            }

            // Resolver resultado de la ronda
            if (ganadoresCount == 1) {
                // Hay un único ganador de la ronda: se lleva todas las cartas
                System.out.println("\n- El ganador es: " + jugadores[indiceGanador].getNombre() + "!");
                for (carta c : cartasRonda) {
                    if (c != null) {
                        jugadores[indiceGanador].agregarPunto(c);
                    }
                }
            } else {
                // Hay empate: cada jugador conserva la suya
                System.out.println("- Empate Cada jugador conserva su carta.");
                for (int i = 0; i < jugadores.length; i++) {
                    if (cartasRonda[i] != null) {
                        jugadores[i].agregarPunto(cartasRonda[i]);
                    }
                }
            }
            System.out.println();
        }

        mostrarResultadosFinales();
    }

    private void mostrarResultadosFinales() {
        System.out.println("=== RESULTADOS DE RONDA ===\n");
        int maxPuntaje = -1;

        for (jugador j : jugadores) {
            System.out.println(j);
            if (j.getpuntos() > maxPuntaje) {
                maxPuntaje = j.getpuntos();
            }
        }

        System.out.println("\n--- Ganador ---\n");
        for (jugador j : jugadores) {
            if (j.getpuntos() == maxPuntaje) {
                System.out.println("¡" + j.getNombre() + " " + j.getApellido() + " gana el juego con " + maxPuntaje
                        + " puntos! \n");
            }
        }
    }
}