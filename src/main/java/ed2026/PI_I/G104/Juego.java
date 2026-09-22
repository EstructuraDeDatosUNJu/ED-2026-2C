package ed2026.PI_I.G104;

import java.util.Scanner;

public class Juego {
    private Jugador[] jugadores;
    private int cantidadJugadores;
    private String[] historialGanadores;
    private int cantidadPartidas;
    private static final int ANCHO_CONSOLA = 80;

    public Juego() {
        this.jugadores = new Jugador[4];
        this.cantidadJugadores = 0;
        this.historialGanadores = new String[50]; // Espacio para guardar hasta 50 partidas
        this.cantidadPartidas = 0;
    }

    public static void limpiarPantalla() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void imprimirCentrado(String texto) {
        int espacios = (ANCHO_CONSOLA - texto.length()) / 2;
        if (espacios < 0)
            espacios = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espacios; i++) {
            sb.append(" ");
        }
        sb.append(texto);
        System.out.println(sb.toString());
    }

    public boolean agregarJugador(Jugador nuevoJugador) {
        if (cantidadJugadores < 4) {
            jugadores[cantidadJugadores] = nuevoJugador;
            cantidadJugadores++;
            return true;
        } else {
            System.out.println("El juego ya tiene los 4 jugadores registrados.");
            return false;
        }
    }

    public void jugarPartida3Rondas(Scanner scanner) {
        if (cantidadJugadores < 4) {
            System.out.println("No se puede iniciar el juego sin 4 jugadores.");
            return;
        }

        for (Jugador j : jugadores) {
            j.reiniciarCartas();
        }

        ArregloNaipes arreglo = new ArregloNaipes();
        Mazo mazo = new Mazo(arreglo);
        Ronda controladorRonda = new Ronda();

        for (int numeroRonda = 1; numeroRonda <= 3; numeroRonda++) {
            limpiarPantalla();

            if (!mazo.hayCartas()) {
                System.out.println("El mazo se ha quedado sin cartas.");
                break;
            }

            imprimirCentrado("-------------------------------------------------------------");
            imprimirCentrado("                         RONDA " + numeroRonda);
            imprimirCentrado("-------------------------------------------------------------\n");

            System.out.println("Presione ENTER para tirar las cartas de la ronda...");
            scanner.nextLine();

            Naipe[] cartasRonda = new Naipe[4];

            for (int i = 0; i < 4; i++) {
                if (mazo.hayCartas()) {
                    cartasRonda[i] = mazo.sacarCarta();
                    cartasRonda[i].dibujarCarta(jugadores[i].getNombre());
                }
            }

            ResultadoRonda resultado = controladorRonda.evaluarRonda(jugadores, cartasRonda);

            System.out.println();
            if ("GANADOR_UNICO".equals(resultado.getTipoResultado())) {
                System.out.println(">> ¡El ganador de la ronda es " + resultado.getGanador().getNombre() + "!");
            } else if ("EMPATE_MULTIPLE".equals(resultado.getTipoResultado())) {
                System.out.println(">> ¡EMPATE en valor máximo! Cada jugador conserva su carta.");
            } else {
                System.out.println(">> ¡EMPATE CUÁDRUPLE! Las cartas se acumulan para la siguiente ronda.");
            }

            System.out.println("\nPresione ENTER para continuar...");
            scanner.nextLine();
        }

        mostrarYGuardarGanadorFinal(scanner);
    }

    private void mostrarArteGanador() {
        imprimirCentrado("        o  o   o  o        ");
        imprimirCentrado("       |\\/ \\^/ \\/|         ");
        imprimirCentrado("       |,-------.|         ");
        imprimirCentrado("     ,-.(|)   (|),-.       ");
        imprimirCentrado("     \\_*._ ' '_.* _/       ");
        imprimirCentrado("      /`-.`--' .-'\\        ");
        imprimirCentrado(" ,--./    `---'    \\,--.   ");
        imprimirCentrado(" \\   |(  )     (  )|   /   ");
        imprimirCentrado("  \\  | ||       || |  /    ");
        imprimirCentrado("   \\ | /|\\     /|\\ | /     ");
        imprimirCentrado("   /  \\-._     _,-/  \\     ");
        imprimirCentrado("  //| \\\\  `---'  // |\\\\    ");
        imprimirCentrado(" /,-.,-.\\       /,-.,-.\\   ");
        imprimirCentrado("o   o   o       o   o    o  ");
        System.out.println();
        imprimirCentrado(" ██████╗  █████╗ ███╗   ██╗██████╗ ██████╗  ██████╗ ██████╗ ");
        imprimirCentrado("██╔════╝ ██╔══██╗████╗  ██║██╔══██╗██╔══██╗██╔═══██╗██╔══██╗");
        imprimirCentrado("██║  ███╗███████║██╔██╗ ██║██████╔╝██║  ██║██║   ██║██████╔╝");
        imprimirCentrado("██║   ██║██╔══██║██║╚██╗██║██╔══██╗██║  ██║██║   ██║██╔══██╗");
        imprimirCentrado("╚██████╔╝██║  ██║██║ ╚████║██║  ██║██████╔╝╚██████╔╝██║  ██║");
        imprimirCentrado(" ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝");
        System.out.println();
    }

    private void mostrarArteCopaHistorial() {
        imprimirCentrado("       ___________       ");
        imprimirCentrado("      '._==_==_=_.'      ");
        imprimirCentrado("      .-\\:      /-.      ");
        imprimirCentrado("     | (|:.     |) |     ");
        imprimirCentrado("      '-|:.     |-'      ");
        imprimirCentrado("        \\::.    /        ");
        imprimirCentrado("         '::. .'         ");
        imprimirCentrado("           )  (          ");
        imprimirCentrado("         _.'  '._        ");
        imprimirCentrado("        '────────'       ");
        System.out.println();
    }

    private void mostrarYGuardarGanadorFinal(Scanner scanner) {
        limpiarPantalla();
        mostrarArteGanador();

        Jugador ganador = jugadores[0];
        boolean empateGlobal = false;

        for (Jugador j : jugadores) {
            int puntaje = j.getPuntaje();
            imprimirCentrado(j.getNombre() + " - Puntaje Total: " + puntaje);

            if (j != jugadores[0]) {
                if (puntaje > ganador.getPuntaje()) {
                    ganador = j;
                    empateGlobal = false;
                } else if (puntaje == ganador.getPuntaje()) {
                    empateGlobal = true;
                }
            }
        }

        System.out.println("\n------------------------------------------------------------------");
        if (empateGlobal) {
            String resultado = "Empate General (Puntaje Máximo: " + ganador.getPuntaje() + " pts)";
            imprimirCentrado("[*] EMPATE GENERAL EN EL PRIMER PUESTO CON " + ganador.getPuntaje() + " PUNTOS");
            if (cantidadPartidas < historialGanadores.length) {
                historialGanadores[cantidadPartidas] = resultado;
                cantidadPartidas++;
            }
        } else {
            String resultado = ganador.getNombre() + " " + ganador.getApellido() + " (" + ganador.getPuntaje()
                    + " pts)";
            imprimirCentrado("[*] GANADOR(ES) CON " + ganador.getPuntaje() + " PUNTOS:");
            imprimirCentrado("    --> " + ganador.getNombre() + " " + ganador.getApellido());
            if (cantidadPartidas < historialGanadores.length) {
                historialGanadores[cantidadPartidas] = resultado;
                cantidadPartidas++;
            }
        }
        System.out.println("------------------------------------------------------------------");

        System.out.println("\nPresione ENTER para volver al menú...");
        scanner.nextLine();
    }

    public void mostrarHistorial() {
        limpiarPantalla();
        mostrarArteCopaHistorial();
        imprimirCentrado("==========================================");
        imprimirCentrado("        HISTORIAL DE GANADORES            ");
        imprimirCentrado("==========================================");
        System.out.println();

        if (cantidadPartidas == 0) {
            imprimirCentrado("Aún no se ha jugado ninguna partida.");
        } else {
            for (int i = 0; i < cantidadPartidas; i++) {
                imprimirCentrado("Partida " + (i + 1) + ": " + historialGanadores[i]);
            }
        }
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
}