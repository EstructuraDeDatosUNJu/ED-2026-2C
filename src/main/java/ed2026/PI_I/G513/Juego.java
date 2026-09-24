package ed2026.PI_I.G513;

import java.util.Random;
import java.util.Scanner;

public class Juego {

    private static final int CANTIDAD_JUGADORES = 4;
    private static final int MINIMO_RONDAS = 3;

    private final Scanner scanner;

    public Juego(Scanner scanner) {
        this.scanner = scanner;
    }

    public void iniciar() {
        Queue<Jugador> jugadores = cargarJugadores();
        StackGenerica<Carta> mazo = crearMazo();
        jugarPartida(mazo, jugadores);
        mostrarResultados(jugadores);
    }

    private void jugarPartida(StackGenerica<Carta> mazo, Queue<Jugador> jugadores) {
        int ronda = 1;
        boolean continuar = true;

        while (continuar && mazo.count() >= CANTIDAD_JUGADORES) {
            jugarRonda(mazo, jugadores, ronda);
            ronda++;

            if (ronda == MINIMO_RONDAS + 1) {
                continuar = leerContinuar();
            }
        }
    }

    private Queue<Jugador> cargarJugadores() {
        Queue<Jugador> jugadores = new Queue<>(CANTIDAD_JUGADORES);

        System.out.println("=== CARGA DE JUGADORES ===");

        for (int i = 1; i <= CANTIDAD_JUGADORES; i++) {
            System.out.println("\nJugador " + i);

            String nombre = leerTexto("Nombre: ");
            String apellido = leerTexto("Apellido: ");
            int edad = leerEntero("Edad: ", 1, 120);

            jugadores.add(new Jugador(nombre, apellido, edad));
        }

        return jugadores;
    }

    private StackGenerica<Carta> crearMazo() {
        String[] palos = { "corazon", "diamante", "trebol", "pica" };
        Carta[] cartas = new Carta[52];
        int posicion = 0;

        for (int valor = 1; valor <= 13; valor++) {
            for (String palo : palos) {
                cartas[posicion] = new Carta(palo, valor);
                posicion++;
            }
        }

        mezclar(cartas);

        System.out.println("\n=== CARTAS DEL MAZO CARGADO ===");
        for (int i = 0; i < cartas.length; i++) {
            System.out.println("Carta " + (i + 1) + ": " + cartas[i]);
        }

        StackGenerica<Carta> mazo = new StackGenerica<>();
        for (Carta carta : cartas) {
            mazo.push(carta);
        }

        return mazo;
    }

    private void mezclar(Carta[] cartas) {
        Random random = new Random();

        for (int i = cartas.length - 1; i > 0; i--) {
            int posicionAleatoria = random.nextInt(i + 1);

            Carta auxiliar = cartas[i];
            cartas[i] = cartas[posicionAleatoria];
            cartas[posicionAleatoria] = auxiliar;
        }
    }

    private void jugarRonda(StackGenerica<Carta> mazo, Queue<Jugador> jugadores, int numeroRonda) {
        Jugador[] jugadoresDeLaRonda = new Jugador[CANTIDAD_JUGADORES];
        Carta[] cartasDeLaRonda = new Carta[CANTIDAD_JUGADORES];

        System.out.println("\n=== RONDA " + numeroRonda + " ===");

        for (int i = 0; i < CANTIDAD_JUGADORES; i++) {
            jugadoresDeLaRonda[i] = jugadores.pool();
            cartasDeLaRonda[i] = mazo.pop();
            jugadores.add(jugadoresDeLaRonda[i]);

            System.out.println(
                    jugadoresDeLaRonda[i].getNombreCompleto()
                            + " obtiene "
                            + cartasDeLaRonda[i]);
        }

        int posicionGanador = determinarPosicionGanador(cartasDeLaRonda);

        if (hayEmpate(cartasDeLaRonda, posicionGanador)) {
            manejarEmpate(jugadoresDeLaRonda, cartasDeLaRonda);
        } else {
            manejarGanador(jugadoresDeLaRonda, cartasDeLaRonda, posicionGanador);
        }
    }

    private int determinarPosicionGanador(Carta[] cartasDeLaRonda) {
        int mayorValor = cartasDeLaRonda[0].getValor();
        int posicionGanador = 0;

        for (int i = 1; i < CANTIDAD_JUGADORES; i++) {
            if (cartasDeLaRonda[i].getValor() > mayorValor) {
                mayorValor = cartasDeLaRonda[i].getValor();
                posicionGanador = i;
            }
        }

        return posicionGanador;
    }

    private boolean hayEmpate(Carta[] cartasDeLaRonda, int posicionGanador) {
        int valorGanador = cartasDeLaRonda[posicionGanador].getValor();

        for (int i = 0; i < CANTIDAD_JUGADORES; i++) {
            if (i != posicionGanador && cartasDeLaRonda[i].getValor() == valorGanador) {
                return true;
            }
        }

        return false;
    }

    private void manejarEmpate(Jugador[] jugadoresDeLaRonda, Carta[] cartasDeLaRonda) {
        System.out.println("Hay empate. Cada jugador conserva su carta.");

        for (int i = 0; i < CANTIDAD_JUGADORES; i++) {
            jugadoresDeLaRonda[i].agregarCarta(cartasDeLaRonda[i]);
            System.out.println(
                    jugadoresDeLaRonda[i].getNombreCompleto()
                            + " conserva "
                            + cartasDeLaRonda[i]);
        }
    }

    private void manejarGanador(Jugador[] jugadoresDeLaRonda, Carta[] cartasDeLaRonda, int posicionGanador) {
        for (Carta carta : cartasDeLaRonda) {
            jugadoresDeLaRonda[posicionGanador].agregarCarta(carta);
        }

        Jugador ganador = jugadoresDeLaRonda[posicionGanador];

        System.out.println(
                "Gana la ronda "
                        + ganador.getNombreCompleto()
                        + " con "
                        + cartasDeLaRonda[posicionGanador]);
        System.out.println("Cartas con las que se queda:");
        for (Carta carta : cartasDeLaRonda) {
            System.out.println("- " + carta);
        }
    }

    private boolean leerContinuar() {
        while (true) {
            char respuesta = Character.toLowerCase(Helper.nextCharacter(scanner, "¿Desea continuar jugando? (s/n): "));

            if (respuesta == 's') {
                return true;
            }

            if (respuesta == 'n') {
                return false;
            }

            System.out.println("Respuesta inválida. Ingrese s o n.");
        }
    }

    private void mostrarResultados(Queue<Jugador> jugadores) {
        System.out.println("\n=== RESULTADOS FINALES ===");

        Object[] elementos = jugadores.toArray();
        int mayorPuntaje = 0;

        for (Object elemento : elementos) {
            Jugador jugador = (Jugador) elemento;
            System.out.println(
                    jugador.getNombreCompleto()
                            + ": "
                            + jugador.getPuntaje()
                            + " puntos");
            System.out.println("Cartas obtenidas: " + jugador.getCartasObtenidas());

            if (jugador.getPuntaje() > mayorPuntaje) {
                mayorPuntaje = jugador.getPuntaje();
            }
        }

        System.out.println("\nGanador o ganadores:");
        for (Object elemento : elementos) {
            Jugador jugador = (Jugador) elemento;
            if (jugador.getPuntaje() == mayorPuntaje) {
                System.out.println(jugador.getNombreCompleto());
            }
        }
    }

    private String leerTexto(String mensaje) {
        return Helper.nextString(scanner, mensaje);
    }

    private int leerEntero(String mensaje, int minimo, int maximo) {
        return Helper.nextInteger(scanner, mensaje, minimo, maximo);
    }
}
