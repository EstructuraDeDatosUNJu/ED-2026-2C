package ed2026.PI_I.G511;

public class EvaluadorPartida {

    public void procesarResultados(Jugador[] jugadores) {
        int mayorPuntaje = jugadores[0].calcularPuntaje();

        for (int i = 1; i < jugadores.length; i++) {
            int puntosActuales = jugadores[i].calcularPuntaje();
            if (puntosActuales > mayorPuntaje) {
                mayorPuntaje = puntosActuales;
            }
        }

        System.out.println("\n--- RESULTADOS FINALES ---");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getNombre() + " " + jugadores[i].getApellido() +
                    ": " + jugadores[i].calcularPuntaje() + " puntos");
        }

        int cantidadGanadores = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].calcularPuntaje() == mayorPuntaje) {
                cantidadGanadores++;
            }
        }

        System.out.println("--------------------------");
        if (cantidadGanadores == 1) {
            for (int i = 0; i < jugadores.length; i++) {
                if (jugadores[i].calcularPuntaje() == mayorPuntaje) {
                    System.out.println("El ganador es " + jugadores[i].getNombre() +
                            " con " + mayorPuntaje + " puntos");
                }
            }
        } else {
            System.out.println("Hubo un empate de " + mayorPuntaje + " puntos entre:");
            for (int i = 0; i < jugadores.length; i++) {
                if (jugadores[i].calcularPuntaje() == mayorPuntaje) {
                    System.out.println(" - " + jugadores[i].getNombre() + " " + jugadores[i].getApellido());
                }
            }
        }
    }
}
