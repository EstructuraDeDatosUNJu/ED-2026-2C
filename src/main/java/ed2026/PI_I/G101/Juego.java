package ed2026.PI_I.G101;

/**
 * Clase que representa el juego de cartas.
 */
public class Juego {
    // codigo del juego
    Jugador[] jugadores;
    Mazo mazo;

    /**
     * Constructor de la clase Juego. Inicializa el mazo y controla el flujo del juego.
     */
    public Juego() {

        this.mazo = new Mazo();
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    this.jugadores = cargarJugadores();
                    break;
                case 2:
                    iniciarPartida();
                    break;
                case 3:
                    mostrarReglas();
                    break;
                case 4:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no contemplada. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    /**
     * Carga los datos de los jugadores solicitando al usuario que ingrese la información.
     * 
     * @return Un arreglo de objetos Jugador con los datos ingresados.
     */
    private Jugador[] cargarJugadores() {
        Jugador[] jugadores = new Jugador[4];

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("\n--- Datos del Jugador " + (i + 1) + " ---");
            String nombre = Helper.nextString("Nombre: ");
            String apellido = Helper.nextString("Apellido: ");
            int edad = Helper.nextInteger("Edad: ", "Debe ingresar un número.");

            jugadores[i] = crearJugador(nombre, apellido, edad);
        }

        return jugadores;
    }

    /**
     * Crea un nuevo jugador con los datos proporcionados.
     * 
     * @param nombre   El nombre del jugador.
     * @param apellido El apellido del jugador.
     * @param edad     La edad del jugador.
     * @return Un objeto Jugador con los datos proporcionados.
     */
    private Jugador crearJugador(String nombre, String apellido, int edad) {
        Jugador jugador = new Jugador(nombre, apellido, edad);
        return jugador;
    }

    /**
     * Compara las cartas en juego en un turno.
     * 
     * @param cartas El arreglo de cartas que representa las cartas en juego.
     * @return la carta mayor, o null si hay empate.
     */
    private Carta comparaCartas(Jugador[] jugadores) {
        Carta ganadora = jugadores[0].getCartaEnMano();
        boolean hayEmpate = false;

        for (int i = 1; i < jugadores.length; i++) {
            Carta actual = jugadores[i].getCartaEnMano();

            if (actual.getValor() > ganadora.getValor()) {
                ganadora = actual;
                hayEmpate = false;

            } else if (actual.getValor() == ganadora.getValor()) {
                hayEmpate = true;
            }
        }
        if (hayEmpate) {
            return null;
        }
        return ganadora;
    }

    /**
     * Bucle principal del juego que controla las rondas y determina el ganador final.
     */
    private void iniciarPartida() {
        if (jugadores == null) {
            System.out.println("Primero debe registrar a los jugadores (opción 1).");
            return;
        }

        final int rondas = 3;

        for (int i = 1; i <= rondas; i++) {
            System.out.println("\n--- Ronda " + i + " ---");

            if (mazo.size() < jugadores.length) {
                System.out.println("El mazo no tiene suficientes cartas. Se corta la partida.");
                break;
            }

            ejecutarRonda(jugadores, mazo);
        }

        mostrarPuntajes();
    }

    /**
     * Realiza un turno del juego, donde cada jugador toma una carta del mazo y se determina el ganador
     * de la ronda.
     * 
     * @param jugadores El arreglo de jugadores que participan en el turno.
     * @param mazo      El mazo del cual se extraen las cartas.
     */
    private void ejecutarRonda(Jugador[] jugadores, Mazo mazo) {
        if (jugadores.length > mazo.size()) {
            System.out.println("No quedan suficientes cartas en el mazo.");
            return;
        }
        repartirCartas(jugadores, mazo);
        Carta cartaGanadora = comparaCartas(jugadores);

        if (cartaGanadora == null) {
            System.out.println("Empate en esta ronda. Cada jugador conserva su carta.");
            for (Jugador jugador : jugadores) {
                jugador.acumularCarta(jugador.getCartaEnMano());
                jugador.setCartaEnMano(null);
            }
            return;
        }

        Jugador ganador = buscarJugadorPorCarta(jugadores, cartaGanadora);
        System.out.println("Ganador de la ronda: " + ganador.getNombre());
        for (Jugador actual : jugadores) {
            ganador.acumularCarta(actual.getCartaEnMano());
            actual.setCartaEnMano(null);
        }
    }

    /**
     * Muestra los puntajes finales de los jugadores y determina el ganador.
     */
    private void mostrarPuntajes() {
        System.out.println("\n=== PUNTAJES FINALES ===");
        Jugador ganador = jugadores[0];

        for (Jugador j : jugadores) {
            j.sumarPuntaje();
            System.out.println(j);
            if (j.getPuntaje() > ganador.getPuntaje()) {
                ganador = j;
            }
        }

        boolean hayEmpate = false;
        for (Jugador j : jugadores) {
            if (j != ganador && j.getPuntaje() == ganador.getPuntaje()) {
                hayEmpate = true;
            }
        }
        if (hayEmpate) {
            System.out.println("¡Hay empate en el primer puesto!");
        } else {
            System.out.println("Ganador: " + ganador.getNombre() + " " + ganador.getApellido());
        }
    }

    /**
     * Busca el jugador que tiene la carta ganadora en su mano.
     * 
     * @param jugadores El arreglo de jugadores.
     * @param carta     La carta ganadora.
     * @return El jugador que tiene la carta ganadora, o null si no se encuentra.
     */
    private Jugador buscarJugadorPorCarta(Jugador[] jugadores, Carta carta) {
        for (Jugador j : jugadores) {
            if (j.getCartaEnMano() == carta) {
                return j;
            }
        }
        return null;
    }

    /**
     * Reparte una carta a cada jugador desde el mazo.
     * 
     * @param jugadores El arreglo de jugadores que recibirán las cartas.
     * @param mazo      El mazo del cual se extraerán las cartas.
     */
    private void repartirCartas(Jugador[] jugadores, Mazo mazo) {
        for (Jugador actual : jugadores) {
            actual.setCartaEnMano(mazo.extraerCarta());
        }
    }

    /**
     * Muestra el menú principal del juego y solicita al usuario que ingrese una opción.
     * 
     * @return la opción seleccionada por el usuario.
     */
    private int mostrarMenu() {

        System.out.println("\n=====================================");
        System.out.println("  PROYECTO INTEGRADOR I - JUEGO DE CARTAS");
        System.out.println("=====================================");
        System.out.println("1. Registrar / Configurar Jugadores (4)");
        System.out.println("2. Iniciar Partida (Jugar Rondas)");
        System.out.println("3. Ver Reglas del Juego");
        System.out.println("4. Salir");
        return Helper.nextInteger("Ingrese una opción: ", "Debe ingresar un número.");
    }

    /**
     * Muestra las reglas del juego en la consola.
     */
    private void mostrarReglas() {
        System.out.println("\n=====================================");
        System.out.println("           REGLAS DEL JUEGO");
        System.out.println("=====================================");
        System.out.println("- Participan 4 jugadores.");
        System.out.println("- Se juega con un mazo de 52 cartas francesas");
        System.out.println("  (trébol, pica, corazones y diamantes), valores del 1 al 13.");
        System.out.println("- En cada ronda, cada jugador toma una carta del mazo.");
        System.out.println("- Se comparan las cartas de la ronda: quien tenga el valor");
        System.out.println("  más alto se lleva las cartas de todos los jugadores.");
        System.out.println("- Si hay empate en el valor máximo, cada jugador conserva");
        System.out.println("  su propia carta.");
        System.out.println("- El juego finaliza al jugar 3 rondas (o cuando se acaba");
        System.out.println("  el mazo, lo que ocurra primero).");
        System.out.println("- Al finalizar, cada jugador suma el valor de las cartas");
        System.out.println("  acumuladas. Gana quien tenga el puntaje más alto");
        System.out.println("  (pueden existir empates).");
        System.out.println("=====================================\n");
    }

}
