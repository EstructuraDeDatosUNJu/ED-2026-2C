package ed2026.PI_I.G105;

public class Ronda {
    public static void jugarRonda(Jugador[] jugadores, Mazo mazo, int numeroRonda) {
        System.out.println("==================================================");
        System.out.println("                RONDA " + numeroRonda);
        System.out.println("==================================================");

        Cola mesa = new Cola();

        for (int i = 0; i < jugadores.length; i++) {
            Carta c = mazo.extraerCarta();
            jugadores[i].setCartaActual(c);
            mesa.encolar(c);
            System.out.println(jugadores[i].getNombreCompleto() + " juega: " + c);
        }

        int valorMaximo = -1;
        while (!mesa.estaVacia()) {
            Carta c = mesa.desencolar();
            if (c.getValor() > valorMaximo) {
                valorMaximo = c.getValor();
            }
        }

        int cantidadGanadores = 0;
        int indiceGanador = -1;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getCartaActual().getValor() == valorMaximo) {
                cantidadGanadores++;
                indiceGanador = i;
            }
        }

        System.out.println("--------------------------------------------------");
        if (cantidadGanadores == 1) {
            Jugador ganador = jugadores[indiceGanador];
            System.out.println("Ganador de la ronda: " + ganador.getNombreCompleto() + " con valor " + valorMaximo);
            System.out.println("Se lleva las cartas de todos los participantes.");
            for (int i = 0; i < jugadores.length; i++) {
                ganador.guardarCarta(jugadores[i].getCartaActual());
            }
        } else {
            System.out.println(
                    "Empate en el valor maximo (" + valorMaximo + ") entre " + cantidadGanadores + " participantes.");
            System.out.println("Regla aplicada: Cada jugador conserva su propia carta.");
            for (int i = 0; i < jugadores.length; i++) {
                jugadores[i].guardarCarta(jugadores[i].getCartaActual());
            }
        }
        System.out.println();
    }
}