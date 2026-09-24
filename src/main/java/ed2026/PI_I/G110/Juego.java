package ed2026.PI_I.G110;
// Orquesta el juego: reparte cartas con el Mazo (Pila), maneja el orden de
// turnos con la Cola, compara con un arreglo la carta de cada jugador en la
// ronda actual, y entrega los puntos al ganador (o conserva en caso de empate).

import java.util.Scanner;

public class Juego {
    private static final int CANTIDAD_JUGADORES = 4;
    private static final int RONDAS = 13; // segun la simplificacion del enunciado

    private Jugador[] jugadores;
    private Mazo mazo;
    private Cola colaTurnos;

    public Juego(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.mazo = new Mazo();
        this.colaTurnos = new Cola(CANTIDAD_JUGADORES);
        for (int i = 0; i < jugadores.length; i++) {
            colaTurnos.encolar(jugadores[i]);
        }
    }

    public void jugar() {
        Scanner in = new Scanner(System.in);
        for (int ronda = 1; ronda <= RONDAS; ronda++) {
            if (ronda == 4) {
                System.out.println("Si desea terminar escriba (si) sino presione Enter....");
                String opc = in.nextLine().toLowerCase();
                if (opc.equals("si")) {
                    break;
                }
            } else {
                System.out.println("--- Ronda " + ronda + " ---");
                in.nextLine();
                jugarRonda();
            }
        }
        mostrarResultados();
    }

    private void jugarRonda() {
        Naipes[] cartasRonda = new Naipes[CANTIDAD_JUGADORES];
        Jugador[] jugadoresRonda = new Jugador[CANTIDAD_JUGADORES];

        // Cada jugador saca una carta siguiendo el orden de la cola
        for (int i = 0; i < CANTIDAD_JUGADORES; i++) {
            Jugador jugadorActual = colaTurnos.desencolar();
            Naipes cartaSacada = mazo.repartirCarta();
            cartasRonda[i] = cartaSacada;
            jugadoresRonda[i] = jugadorActual;
            System.out.println(jugadorActual.getNombre() + " saco " + cartaSacada);
            colaTurnos.encolar(jugadorActual); // vuelve al final de la cola para la proxima ronda
        }

        resolverRonda(cartasRonda, jugadoresRonda);
    }

    private void resolverRonda(Naipes[] cartasRonda, Jugador[] jugadoresRonda) {
        int valorMaximo = 0;
        for (int i = 0; i < cartasRonda.length; i++) {
            if (cartasRonda[i].getValor() > valorMaximo) {
                valorMaximo = cartasRonda[i].getValor();
            }
        }

        int cantidadGanadores = 0;
        int indiceGanador = -1;
        for (int i = 0; i < cartasRonda.length; i++) {
            if (cartasRonda[i].getValor() == valorMaximo) {
                cantidadGanadores++;
                indiceGanador = i;
            }
        }

        if (cantidadGanadores == 1) {
            Jugador ganador = jugadoresRonda[indiceGanador];
            for (int i = 0; i < cartasRonda.length; i++) {
                ganador.agregarCartas(cartasRonda[i]);
            }
            System.out.println(ganador.getNombre() + " gana la ronda y se lleva todas las cartas.");
        } else {
            // Empate: cada jugador conserva su propia carta
            for (int i = 0; i < cartasRonda.length; i++) {
                jugadoresRonda[i].agregarCartas(cartasRonda[i]);
            }
            System.out.println("Empate: cada jugador conserva su carta.");
        }
    }

    private void mostrarResultados() {
        System.out.println("--- Resultados finales ---");
        Jugador ganador = jugadores[0];
        int empate = 0;
        for (int i = 0; i < jugadores.length; i++) {
            int puntaje = jugadores[i].calcularPuntajeTotal();
            System.out
                    .println(jugadores[i].getNombre() + " " + jugadores[i].getApellido() + ": " + puntaje + " puntos");
            if (puntaje > ganador.calcularPuntajeTotal()) {
                ganador = jugadores[i];
            }
        }
        for (int i = 0; i < jugadores.length; i++) {
            if (ganador.calcularPuntajeTotal() == jugadores[i].calcularPuntajeTotal()) {
                empate++;
            }
        }
        if (empate == 1) {
            System.out.println("Ganador: " + ganador.getNombre() + " " + ganador.getApellido());
        } else {
            System.out.println("Hubo un empate general, nadie gana este juego");
        }

    }

    public static void main(String[] args) {
        Jugador[] jugadores = new Jugador[CANTIDAD_JUGADORES];
        jugadores[0] = new Jugador("Ana", "Perez", 20);
        jugadores[1] = new Jugador("Luis", "Gomez", 22);
        jugadores[2] = new Jugador("Marta", "Diaz", 21);
        jugadores[3] = new Jugador("Juan", "Lopez", 23);

        Juego juego = new Juego(jugadores);
        juego.jugar();
    }
}
