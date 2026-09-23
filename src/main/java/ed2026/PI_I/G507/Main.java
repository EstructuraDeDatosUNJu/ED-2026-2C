package ed2026.PI_I.G507;

// import main.model.*;
// import main.service.*;
// import main.util.*;

/**
 * Clase principal para el Proyecto Integrador I - Estructura de Datos.
 *
 * @author Acuña, Sergio Facundo
 * @author Andreu, Luca Maximiliano
 * @author Silva, Jael Abril Alejandra
 * @author Cruz, Kevin Brian Joel
 * @author Montaño, Lucas Antonio
 * @author Ramos, Daniel Maximiliano Efraín
 *
 *         Caso de estudio: Juego de cartas
 *
 *         Cuatro jugadores se enfrentan en un juego de cartas que consiste en
 *         varias rondas en las que cada jugador toma un naipe de un mazo de
 *         cartas francesas (trébol, pica, corazón y diamante) ordenadas al azar.
 *         Luego, los jugadores comparan sus cartas de la ronda actual y el que
 *         resulte con la carta de mayor valor numérico les quita a los demás las
 *         suyas y las conserva. Si más de un jugador tiene una carta con el mismo
 *         valor máximo (empate), cada jugador conserva su propia carta. Las rondas
 *         se repiten hasta que se acaban los naipes del mazo (a fines de simplificar,
 *         el juego puede finalizar tras jugar tres rondas).
 *
 *         Cada naipe posee palo (trébol, corazón, diamante o pica), valor (1 a 13)
 *         y estado (disponible o no disponible). Cada jugador posee nombre,
 *         apellido y edad.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("\n***** BIENVENIDO AL JUEGO DE CARTAS *****\n");

        //Inicilizacion de jugadores
        Queue<Jugador> jugadores = new CountedQueue<>(4);
        cargarJugadores(jugadores);
        mostrarJugadores(jugadores);

        //Comienzo del juego
        JuegoService juegoService = new JuegoService(jugadores);

        // Bucle que ejecuta rondas secuenciales hasta cumplir la condición de fin de juego
        int nroDeRonda = 1;

        while (!juegoService.esFinDeJuego()) {
            System.out.println("\n=== RONDA " + nroDeRonda + " ===");
            nroDeRonda++;

            juegoService.jugarRonda();
        }

        // Muestra de inventario de cartas ganadas por cada jugador
        mostrarCartasDeCadaJugador(jugadores);

        // Determinación y anuncio del o los ganadores finales de la partida
        Queue<Jugador> ganadores = juegoService.ganadorPartida();
        mostrarGanadores(ganadores);

        System.out.println("\n***** FIN DEL JUEGO *****\n");
    }

    /**
     * Crea e instanciar manualmente los 4 objetos Jugador obligatorios
     * y los inserta en la cola de participantes.
     */
    public static void cargarJugadores(Queue<Jugador> jugadores) {
        jugadores.add(new Jugador("Juan", "Pérez", 25));
        jugadores.add(new Jugador("María", "Gómez", 30));
        jugadores.add(new Jugador("Carlos", "López", 28));
        jugadores.add(new Jugador("Ana", "Martínez", 22));
    }

    /**
     * Recorre la cola de jugadores convirtiéndola temporalmente a un arreglo
     * e imprime la información de cada participante por consola.
     */
    public static void mostrarJugadores(Queue<Jugador> jugadores) {
        Object[] jugadoresArray = jugadores.toArray();

        System.out.println("-JUGADORES-");
        for (Object jugador : jugadoresArray) {
            Jugador jugadorActual = (Jugador) jugador;
            System.out.println(jugadorActual);
        }
        System.out.println("\n-------------------------------------");
    }

    /**
     * Muestra el detalle del pozo de cartas que acumuló cada jugador durante sus victorias
     * y calcula su puntaje final acumulado consultando sus cartas ganadas.
     */
    public static void mostrarCartasDeCadaJugador(Queue<Jugador> jugadores) {
        System.out.println("\n-------------------------------------\n");

        System.out.println("*** MOMENTO DE CONTAR LAS CARTAS ***\n");
        Object[] jugadoresArray = jugadores.toArray();

        for (Object jugador : jugadoresArray) {
            Jugador jugadorActual = (Jugador) jugador;
            Object[] cartas = jugadorActual.getCartasGanadas().toArray();

            System.out.println("=====================================");
            System.out.println("Cartas de " + jugadorActual.getNombreCompleto() + ": ");
            System.out.println("-------------------------------------");

            for (int i = 0; i < cartas.length; i++) {
                Carta carta = (Carta) cartas[i];
                System.out.println(carta);
            }
            System.out.println("-------------------------------------");
            System.out.println("Puntaje total" + ": " + jugadorActual.calcularPuntaje() + " pts");
            System.out.println("=====================================");
        }
    }

    /**
     * Evalúa la cola de ganadores recibida desde el servicio:
     * - Si la cola contiene 1 solo elemento, anuncia al ganador absoluto.
     * - Si contiene múltiples elementos, imprime a los jugadores que empataron en el primer puesto.
     */
    public static void mostrarGanadores(Queue<Jugador> ganadores) {
        System.out.println("\n-----------------------------------------------");
        if (ganadores.size() == 1) {
            Jugador ganador = ganadores.peek();
            System.out.println("¡¡" + ganador.getNombreCompleto() + " GANO la partida con " +
                    ganador.calcularPuntaje() + " puntos!!");
            System.out.println("¡¡FELICITACIONES!!");
        } else {
            int puntajeEmpate = ganadores.peek().calcularPuntaje();

            System.out.println("¡La paritda finalizó con un EMPATE!");
            System.out.print("Empataron ");

            while (!ganadores.isEmpty()) {
                Jugador jugador = ganadores.poll();
                System.out.print(jugador.getNombre() + " ");
            }
            System.out.println("con " + puntajeEmpate + " pts");
        }
        System.out.println("-----------------------------------------------\n");
    }
}
