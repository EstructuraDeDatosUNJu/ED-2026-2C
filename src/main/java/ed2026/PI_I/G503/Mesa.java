package ed2026.PI_I.G503;

public class Mesa {

    private Mazo mazo;
    private Queue<Jugador> turnoJugadores;
    private int cantidadJugadores;
    private Carta[] cartasEnMesa;

    public Mesa(Queue<Jugador> turnoJugadores) {
        this.turnoJugadores = turnoJugadores;
        this.cantidadJugadores = 0;
    }

    public void agregarJugador(Jugador jugador) {
        this.turnoJugadores.add(jugador);
        this.cantidadJugadores++;
    }

    public boolean iniciarJuego() {
        if (this.cantidadJugadores < 2) {
            System.out.println("Faltan jugadores para iniciar");
            return false;
        }

        this.mazo = new Mazo();
        this.cartasEnMesa = new Carta[this.cantidadJugadores];
        return true;
    }

    public void jugarRonda() {
        Jugador[] jugadoresRonda = this.repartirCartas();
        int valorMaximo = this.encontrarValorMaximo();
        this.resolverGanadores(jugadoresRonda, valorMaximo);
    }

    public boolean hayCartasSuficientes() {
        return this.mazo.cantidadCartasRestantes() >= this.cantidadJugadores;
    }

    private Jugador[] repartirCartas() {
        Jugador[] jugadoresRonda = new Jugador[this.cantidadJugadores];
        System.out.println("\nRepartiendo cartas");

        for (int i = 0; i < this.cantidadJugadores; i++) {
            Jugador jugadorActual = this.turnoJugadores.remove();
            Carta cartaRobada = this.mazo.robarCarta();
            jugadoresRonda[i] = jugadorActual;
            this.cartasEnMesa[i] = cartaRobada;
            System.out.println(jugadorActual.getNombre() + " juega: " + cartaRobada.toString());
            this.turnoJugadores.add(jugadorActual);
        }
        return jugadoresRonda;
    }

    private int encontrarValorMaximo() {
        int maximo = 0;
        for (int i = 0; i < this.cantidadJugadores; i++) {
            if (this.cartasEnMesa[i].getValor() > maximo) {
                maximo = this.cartasEnMesa[i].getValor();
            }
        }
        return maximo;
    }

    private void resolverGanadores(Jugador[] jugadoresRonda, int valorMaximo) {
        int cantidadGanadores = 0;
        int indiceGanador = -1;
        for (int i = 0; i < this.cantidadJugadores; i++) {
            if (this.cartasEnMesa[i].getValor() == valorMaximo) {
                cantidadGanadores++;
                indiceGanador = i;
            }
        }

        System.out.println("\nResultado de la ronda");

        if (cantidadGanadores == 1) {
            Jugador ganador = jugadoresRonda[indiceGanador];
            System.out.println("¡" + ganador.getNombre() + " gana la ronda con un: " + valorMaximo);
            // CAMBIO: se saco el setEstado, ahora se hace en Mazo.robarCarta()
            for (int i = 0; i < this.cantidadJugadores; i++) {
                ganador.ganarCarta(this.cartasEnMesa[i]);
            }

        } else {
            System.out.println("Empate cada jugador conserva su carta");
            // CAMBIO: se saco el setEstado, ahora se hace en Mazo.robarCarta()
            for (int i = 0; i < this.cantidadJugadores; i++) {
                jugadoresRonda[i].ganarCarta(this.cartasEnMesa[i]);
            }
        }
    }

    public void determinarGanador() {
        System.out.println("       RESULTADOS FINAL        ");
        int puntajeMaximo = -1;
        int[] puntajesFinales = new int[this.cantidadJugadores];
        Jugador[] registroJugadores = new Jugador[this.cantidadJugadores];

        for (int i = 0; i < this.cantidadJugadores; i++) {
            Jugador jugadorActual = this.turnoJugadores.remove();
            registroJugadores[i] = jugadorActual;
            puntajesFinales[i] = jugadorActual.puntajeTotal();

            System.out.println("Jugador: " + jugadorActual.getNombre() + " " + jugadorActual.getApellido()
                    + " | Puntaje Total: " + puntajesFinales[i]);

            if (puntajesFinales[i] > puntajeMaximo) {
                puntajeMaximo = puntajesFinales[i];
            }

            this.turnoJugadores.add(jugadorActual);
        }

        for (int i = 0; i < this.cantidadJugadores; i++) {
            if (puntajesFinales[i] == puntajeMaximo) {
                System.out.println(
                        "\nEl ganador es " + registroJugadores[i].getNombre() + " con: " + puntajeMaximo + " puntos");
            }
        }
    }
}
