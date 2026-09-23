package ed2026.PI_I.G507;

import java.util.Arrays;
import java.util.Collections;

// import main.model.*;
// import main.util.*;

/**
 * Clase de servicio que contiene la lógica del juego de cartas.
 *
 * Se encarga de gestionar las estructuras de datos del juego: la cola
 * de turnos de los jugadores, la pila que representa el mazo y el
 * arreglo con las cartas jugadas en la ronda actual (mesa).
 *
 * Entre sus responsabilidades se encuentran:
 * Preparar el juego, cargando la cola de jugadores y generando y
 * mezclando el mazo de 52 cartas.
 * Jugar una ronda, haciendo que cada jugador tome una carta del
 * mazo según el orden de la cola de turnos.
 * Determinar el ganador de cada ronda según el mayor valor
 * numérico entre las cartas jugadas, contemplando la posibilidad
 * de empate.
 * Repartir las cartas de la ronda al jugador ganador, o a cada
 * jugador su propia carta en caso de empate.
 * Determinar el/los ganador(es) de la partida una vez que el
 * mazo se agota, comparando el puntaje total de cada jugador.
 */

public class JuegoService {
    Queue<Jugador> jugadores;
    Stack<Carta> mazo;

    /**
     * Constructor de la clase Servicio.
     * Valida que exista una cola de jugadores válida (mínimo 2 participantes)
     * e inicializa y mezcla el mazo de cartas para dar inicio al juego.
     */
    public JuegoService(Queue<Jugador> jugadores) {
        if (jugadores.size() < 2 || jugadores == null) {
            throw new IllegalArgumentException(
                    "\nERROR: La cola de jugadores esta vacia o tiene menos de dos jugadores");
        }
        this.jugadores = jugadores;
        mazo = crearYMezclarMazo();
    }

    /**
     * Ejecuta el flujo completo de una ronda del juego:
     * Reparte una carta del mazo a cada jugador, determina si hay un único ganador
     * o empate, y asigna las cartas correspondientes según el resultado.
     */
    public void jugarRonda() {
        if (esFinDeJuego()) {
            System.out.println("\nFin del Juego");
            return;
        }

        repartirCartas();
        Jugador ganadorDeLaRonda = ganadorRonda();
        if (ganadorDeLaRonda != null)
            entregarCartasAlGanador(ganadorDeLaRonda);
    }

    /**
     * Desencola secuencialmente a cada jugador de la cola, desapila una carta del mazo
     * y se la asigna temporalmente en mano al jugador actual. Luego, vuelve a encolarlo.
     */
    private void repartirCartas() {
        int cantidadJugadores = jugadores.size();

        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugadorActaul = jugadores.poll();
            Carta carta = mazo.pop();

            System.out.println(" - " + jugadorActaul.getNombre() + " sacó la carta " + carta);

            jugadorActaul.agregarCarta(carta);
            jugadores.add(jugadorActaul);
        }
    }

    /**
     * Compara las cartas que tienen en mano los jugadores para esta ronda.
     * Devuelve la referencia del jugador con la carta de mayor valor numérico,
     * o devuelve 'null' en caso de que exista un empate entre los valores máximos.
     */
    private Jugador ganadorRonda() {
        Object[] jugadoresArray = jugadores.toArray();
        Jugador ganador = (Jugador) jugadoresArray[0];
        int contador = 1;

        for (int i = 1; i < jugadoresArray.length; i++) {
            Jugador jugadorActual = (Jugador) jugadoresArray[i];
            if (jugadorActual.cartaEnMano().getValor() == ganador.cartaEnMano().getValor()) {
                contador++;
            } else if (jugadorActual.cartaEnMano().getValor() > ganador.cartaEnMano().getValor()) {
                ganador = jugadorActual;
                contador = 1;
            }
        }

        if (contador > 1) {
            System.out.println("\n¡Más de un jugador tiene la carta con mayor valor numerico," +
                    " por lo tanto, esta ronda queda en EMPATE!");
            return null;
        }
        System.out.println("\n¡¡" + ganador.getNombreCompleto() + " ganó la ronda!!");
        return ganador;
    }

    /**
     * Transfiere la carta en mano que jugo cada contrincante hacia la pila/pozo
     * de cartas acumuladas del jugador ganador de la ronda.
     */
    private void entregarCartasAlGanador(Jugador ganador) {
        Object[] jugadoresArray = jugadores.toArray();

        for (Object jugador : jugadoresArray) {
            Jugador jugadorActual = (Jugador) jugador;
            if (jugadorActual != ganador)
                ganador.agregarCarta(jugadorActual.darCartaEnMano());
        }
    }

    /**
     * Recorre la cola de jugadores, calcula el puntaje total acumulado de cada uno
     * y retorna una Cola (Queue) que contiene al o los jugadores ganadores de la partida.
     */
    public Queue<Jugador> ganadorPartida() {
        Object[] jugadores = this.jugadores.toArray();
        Queue<Jugador> ganadores = new CountedQueue<>(this.jugadores.size());

        Jugador primerJugador = ((Jugador) jugadores[0]);
        ganadores.add(primerJugador);
        int puntajeMaximo = primerJugador.calcularPuntaje();

        for (int i = 1; i < jugadores.length; i++) {
            Jugador jugadorActual = (Jugador) jugadores[i];
            int puntajeActual = jugadorActual.calcularPuntaje();

            if (puntajeActual == puntajeMaximo) {
                ganadores.add(jugadorActual);
            } else if (puntajeActual > puntajeMaximo) {
                puntajeMaximo = puntajeActual;
                ganadores = new CountedQueue<>(this.jugadores.size());
                ganadores.add(jugadorActual);
            }
        }
        return ganadores;
    }

    /**
     * Genera las 52 cartas del mazo francés, las desordena aleatoriamente
     * y las apila dentro de la estructura TDA Stack para ser usada como mazo.
     */
    public Stack<Carta> crearYMezclarMazo() {
        Carta[] cartas = generarMazo();
        Collections.shuffle(Arrays.asList(cartas));

        Stack<Carta> mazo = new Stack<Carta>(52);

        for (int i = 0; i < cartas.length; i++) {
            mazo.push(cartas[i]);
        }
        return mazo;
    }

    /**
     * Instancia un arreglo de 52 objetos de tipo Carta abarcando todos los palos
     * (Trébol, Pica, Corazón, Diamante) con valores numéricos del 1 al 13.
     */
    private Carta[] generarMazo() {
        Carta[] cartas = new Carta[52];
        Palo[] palos = Palo.values();
        int indice = 0;

        for (Palo palo : palos) {
            for (int i = 1; i <= 13; i++) {
                cartas[indice] = new Carta(palo, i);
                indice++;
            }
        }
        return cartas;
    }

    /**
     * Evalúa la condición de término de la partida, verificando si la cantidad
     * de cartas restantes en la pila mazo es insuficiente para repartir a todos los jugadores.
     */
    public boolean esFinDeJuego() {
        return !(mazo.size() >= jugadores.size());
    }
}
