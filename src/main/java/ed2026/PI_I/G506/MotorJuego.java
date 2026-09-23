package ed2026.PI_I.G506;

public class MotorJuego {

    public static void jugarRonda(Pila mazo, Jugador[] jugadores, int numeroRonda) {
        System.out.println("\n- RONDA " + numeroRonda + " -");

        Carta[] mesa = new Carta[4];
        int valorMaximo = -1;

        // Cada jugador toma una carta
        for (int i = 0; i < 4; i++) {
            mesa[i] = mazo.desapilar();

            System.out.println(jugadores[i].getNombreCompleto() + " saca: " + mesa[i]);

            if (mesa[i].getValor() > valorMaximo) {
                valorMaximo = mesa[i].getValor();
            }
        }

        // Evaluar ganadores de la ronda
        int cantidadGanadores = 0;
        int indiceGanador = -1;

        for (int i = 0; i < 4; i++) {
            if (mesa[i].getValor() == valorMaximo) {
                cantidadGanadores++;
                indiceGanador = i;
            }
        }

        // Reparto de cartas
        if (cantidadGanadores == 1) {
            System.out.println(">> ¡" + jugadores[indiceGanador].getNombreCompleto()
                    + " gana la ronda y se lleva todas las cartas!");
            for (int i = 0; i < 4; i++) {
                jugadores[indiceGanador].ganarCarta(mesa[i]);
            }
        } else {
            System.out.println(
                    ">> ¡Empate por el valor maximo (" + valorMaximo + ")! Cada jugador conserva su propia carta.");
            for (int i = 0; i < 4; i++) {
                jugadores[i].ganarCarta(mesa[i]);
            }
        }
    }
}