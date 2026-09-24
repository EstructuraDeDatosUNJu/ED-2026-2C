package ed2026.PI_I.G509;

import java.util.Arrays;
import java.util.Scanner;

public class Partida {

    static Jugador[] jugadores = new Jugador[4];
    static int cantidadJugadores = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean seguir = true;

        while (seguir) {

            System.out.println();
            System.out.println("       JUEGO DE CARTAS");
            System.out.println("1. Agregar Jugadores");
            System.out.println("2. Jugar a 3 rondas");
            System.out.println("3. Jugar Partida Completa de 13 rondas");
            System.out.println("4. Salir");
            System.out.println();

            int opcion = Helper.validarEntero(input, "Elija una opción: ");

            switch (opcion) {

                case 1:
                    agregarJugador();
                    break;

                case 2:
                    if (cantidadJugadores == 4) {
                        partida(3);
                    } else {
                        System.out.println("Debe haber 4 jugadores para comenzar la partida.");
                    }
                    break;

                case 3:
                    if (cantidadJugadores == 4) {
                        partida(13);
                    } else {
                        System.out.println("Debe haber 4 jugadores para comenzar la partida.");
                    }
                    break;

                case 4:
                    seguir = false;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        input.close();
    }

    public static void agregarJugador() {

        if (cantidadJugadores >= 4) {
            System.out.println("Ya se agregaron los 4 jugadores.");
            return;
        }

        System.out.println();
        System.out.println("----- AGREGAR JUGADOR -----");
        String nombreApellido = Helper.leerCadena(input, "Ingrese nombre y apellido: ");
        int edad = Helper.validarEntero(input, "Ingrese edad: ");

        try {
            Jugador jugador = new Jugador(nombreApellido, edad);
            agregarJugador(jugador);
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo agregar el jugador: " + e.getMessage());
            agregarJugador();
        }
    }

    public static void agregarJugador(Jugador jugador) {

        // Evitar jugadores con el mismo nombre
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getNombreApellido().equalsIgnoreCase(jugador.getNombreApellido())) {
                System.out.println("Ya existe un jugador con ese nombre.");
                return;
            }
        }

        jugadores[cantidadJugadores] = jugador;
        cantidadJugadores++;

        System.out.println();
        System.out.println("Jugador agregado: " + jugador.getNombreApellido());
        System.out.println("Jugadores registrados: " + cantidadJugadores + "/" + 4);
    }

    public static void partida(int cantidadRondas) {

        System.out.println();
        System.out.println("       INICIO DE LA PARTIDA");
        System.out.println("Cantidad de rondas: " + cantidadRondas);

        for (int i = 0; i < cantidadJugadores; i++) {
            jugadores[i].getCartasJugador().clear();
            jugadores[i].setCartaActual(null);
        }

        Queue<Jugador> ordenTurno = new Queue<>(4);
        for (int i = 0; i < cantidadJugadores; i++) {
            ordenTurno.enqueue(jugadores[i]);
        }
        Turno turno = new Turno(ordenTurno);

        Mazo mazo = new Mazo();

        int ronda = 1;
        while (ronda <= cantidadRondas && mazo.tieneCartas()) {

            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("          RONDA " + ronda);
            System.out.println("-----------------------------");

            jugarRonda(mazo, turno);
            ronda++;
        }

        finalizarPartida();
    }

    // JUGAR RONDA
    public static void jugarRonda(Mazo mazo, Turno turno) {

        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugador = turno.pasarTurno();
            Carta carta = mazo.levantarCarta();
            jugador.setCartaActual(carta);
            System.out.println(jugador.getNombreApellido() + " sacó: " + carta);
            System.out.println();
        }

        Jugador ganadorRonda = turno.compararCartas(Arrays.asList(jugadores));

        if (ganadorRonda == null) {
            System.out.println("Empate en la ronda: cada jugador conserva su carta.");
        } else {
            System.out.println("Ganador de la ronda: " + ganadorRonda.getNombreApellido());
        }

        int cartasRestantes = mazo.getMazoAzar().cantidadElementos();
        System.out.println("Cartas en el mazo: " + cartasRestantes + "/52");
    }

    public static void finalizarPartida() {

        System.out.println();
        System.out.println("       FIN DE LA PARTIDA");
        System.out.println();

        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println(jugadores[i].getNombreApellido() + ": " + jugadores[i].calcularPuntaje() + " puntos");
        }

        jugadorGanador();
        System.out.println("=================================");
    }

    public static void jugadorGanador() {

        int mayorPuntaje = -1;
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].calcularPuntaje() > mayorPuntaje) {
                mayorPuntaje = jugadores[i].calcularPuntaje();
            }
        }

        int cantidadGanadores = 0;
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].calcularPuntaje() == mayorPuntaje) {
                cantidadGanadores++;
            }
        }

        System.out.println();
        if (cantidadGanadores > 1) {
            System.out.println("       EMPATE ENTRE LOS GANADORES");
        } else {
            System.out.println("       GANADOR");
        }
        System.out.println();

        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].calcularPuntaje() == mayorPuntaje) {
                System.out.println(jugadores[i].getNombreApellido() + " - " + mayorPuntaje + " puntos");
            }
        }
    }
}