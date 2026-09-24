package ed2026.PI_I.G511;

public class GestorRonda {

    private QueueTDA<Jugador> turnosCola;

    public GestorRonda() {
        this.turnosCola = new QueueTDA<>(4);
    }

    public void comenzarRounda(Jugador[] Jugadores) {
        turnosCola.removeAll();

        for (Jugador p : Jugadores) {
            turnosCola.offer(p);
        }
    }

    public Jugador obtenerSiguiente() {
        return turnosCola.pool();
    }

    public boolean hayJugadores() {
        return !turnosCola.isEmpty();
    }

    public Jugador mirarSiguiente() {
        return turnosCola.peek();
    }

    public int jugadoresRestantes() {
        return turnosCola.size();
    }

    public static int obtenerValorMax(Carta[] cartas) {

        int max = Main.convertirValorANumero(cartas[0].getValor());

        for (int i = 0; i < cartas.length; i++) {
            if (Main.convertirValorANumero(cartas[i].getValor()) > max) {
                max = Main.convertirValorANumero(cartas[i].getValor());
            }

        }
        return max;

    }

    public static int contadorMaximos(Carta[] cartas, int valorMaximo) {
        int contador = 0;

        for (Carta c : cartas) {//recorrido de las cartas
            if (Main.convertirValorANumero(c.getValor()) == valorMaximo) {
                contador++;
            }

        }
        return contador;
    }

    public static boolean empates(Carta[] cartas) {
        int max = obtenerValorMax(cartas);
        return contadorMaximos(cartas, max) > 1;
    }

    public static void resolverRonda(Carta[] cartas, Jugador[] jugadores) {
        int valorMaximo = obtenerValorMax(cartas);
        int cantidadMaximos = contadorMaximos(cartas, valorMaximo);

        System.out.println("\n--- RESOLUCIÓN DE LA RONDA ---");
        System.out.println("Valor máximo: " + valorMaximo);

        if (cantidadMaximos > 1) {
            // EMPATE
            System.out.println("¡EMPATE! " + cantidadMaximos + " jugadores con el valor máximo.");
            System.out.println("++++Cada jugador conserva su propia carta++++");

            for (int i = 0; i < cartas.length; i++) {
                if (Main.convertirValorANumero(cartas[i].getValor()) == valorMaximo) {
                    jugadores[i].ganarCarta(cartas[i]);
                }
            }
        } else {
            // GANADOR ÚNICO
            int indiceGanador = -1;
            for (int i = 0; i < cartas.length; i++) {
                if (Main.convertirValorANumero(cartas[i].getValor()) == valorMaximo) {
                    indiceGanador = i;
                    break;
                }
            }

            System.out.println("Ganador de la ronda: " + jugadores[indiceGanador].getNombre());
            System.out.println("Se lleva todas las cartas de la ronda.");

            for (int i = 0; i < cartas.length; i++) {
                jugadores[indiceGanador].ganarCarta(cartas[i]);
            }
        }
    }
}
