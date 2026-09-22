package ed2026.PI_I.G109;

public class Partida {
    private Queue<Jugador> turnoJugadores;
    private Mazo mazo;
    private Jugador[] jugadores; // Arreglo para manejar a los jugadores al final

    public Partida(Jugador j1, Jugador j2, Jugador j3, Jugador j4, Mazo mazo) {
        this.mazo = mazo;
        this.jugadores = new Jugador[] { j1, j2, j3, j4 };
        this.turnoJugadores = new Queue<>(4);

        for (int i = 0; i < 4; i++) {
            this.turnoJugadores.offer(this.jugadores[i]);
        }
    }

    public void iniciarJuego() {
        int numeroRonda = 1;
        // Se repiten las rondas hasta que el mazo se quede sin cartas
        while (mazo.tieneCartas() && numeroRonda <= 3) {
            System.out.println("\n--- Ronda " + numeroRonda + " ---");
            jugarRonda();
            numeroRonda++;
        }
        determinarGanadorFinal();
    }

    private void jugarRonda() {
        // ARREGLOS obligatorios para controlar las cartas tiradas y quién las tiró
        Carta[] mesaCartas = new Carta[4];
        Jugador[] mesaJugadores = new Jugador[4];
        int valorMaximo = -1;
        boolean hayEmpate = false;
        Jugador ganadorRonda = null;
        // 1. Cada jugador saca una carta
        for (int i = 0; i < 4; i++) {
            Jugador jugadorActual = turnoJugadores.pool();
            Carta cartaSacada = mazo.agarrarCarta();
            mesaCartas[i] = cartaSacada;
            mesaJugadores[i] = jugadorActual;
            System.out.println(
                    jugadorActual.getNombre() + " saca: " + cartaSacada.getValor() + " de " + cartaSacada.getPalo());
            //  Comparar valores para ver quién gana la ronda
            if (cartaSacada.getValor() > valorMaximo) {
                valorMaximo = cartaSacada.getValor();
                ganadorRonda = jugadorActual;
                hayEmpate = false;
            } else if (cartaSacada.getValor() == valorMaximo) {
                hayEmpate = true;
            }
            // El jugador vuelve al final de la cola
            turnoJugadores.offer(jugadorActual);
        }
        // Resolución de la ronda
        if (hayEmpate) {
            System.out.println("-> ¡Empate! Cada jugador conserva su carta.");
            for (int i = 0; i < 4; i++) {
                mesaJugadores[i].agregarCartaGanada(mesaCartas[i]);
            }
        } else {
            System.out.println("-> " + ganadorRonda.getNombre() + " gana la ronda con un " + valorMaximo + ".");
            for (int i = 0; i < 4; i++) {
                ganadorRonda.agregarCartaGanada(mesaCartas[i]);
            }
        }
    }

    private void determinarGanadorFinal() {
        System.out.println("\n=== FIN DEL JUEGO ===");
        int puntajeMaximo = -1;
        int[] puntajesFinales = new int[4];
        for (int i = 0; i < 4; i++) {
            puntajesFinales[i] = jugadores[i].calcularPuntaje();
            System.out.println("Puntaje de " + jugadores[i].getNombreCompleto() + ": " + puntajesFinales[i]);
            if (puntajesFinales[i] > puntajeMaximo) {
                puntajeMaximo = puntajesFinales[i];
            }
        }
        System.out.print("\n🏆 Ganador(es): ");
        for (int i = 0; i < 4; i++) {
            if (puntajesFinales[i] == puntajeMaximo) {
                System.out.print(jugadores[i].getNombreCompleto() + "  ");
            }
        }
        System.out.println("\n");
    }
}