package ed2026.PI_I.G104;

import java.util.Scanner;

public class Main {
    private static final int ANCHO_CONSOLA = 80;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Juego juego = new Juego();

        Juego.limpiarPantalla();

        // PANTALLA DE BIENVENIDA Y REGISTRO
        System.out.println("==========================================================");
        System.out.println("       BIENVENIDO AL JUEGO DE CARTAS INTEGRADOR I         ");
        System.out.println("==========================================================");
        System.out.println("\n             === REGISTRO DE LOS 4 JUGADORES ===\n");

        for (int i = 1; i <= 4; i++) {
            System.out.print("Nombre del Jugador " + i + ": ");
            String nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()) {
                nombre = "Jugador " + i;
            }
            System.out.print("Apellido del Jugador " + i + ": ");
            String apellido = scanner.nextLine();
            if (apellido.trim().isEmpty()) {
                apellido = "Jugador " + i;
            }

            int edad = Helper.nextNonNegativeInteger(scanner, "Edad del Jugador " + i + ": ",
                    "Por favor, ingrese un número válido para la edad.");

            juego.agregarJugador(new Jugador(nombre, apellido, edad));
        }

        System.out.println("\n[✓] Jugadores registrados correctamente. Presione ENTER para ir al menú...");
        scanner.nextLine();

        // BUCLE PRINCIPAL DEL MENÚ
        boolean salir = false;

        while (!salir) {
            Juego.limpiarPantalla();
            dibujarMenuAscii();
            System.out.print(">> Seleccione una opción (1-4): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    juego.jugarPartida3Rondas(scanner);
                    break;
                case "2":
                    juego.mostrarHistorial();
                    presionarEnter(scanner);
                    break;
                case "3":
                    cambiarNombresJugadores(juego, scanner);
                    presionarEnter(scanner);
                    break;
                case "4":
                    salir = true;
                    Juego.limpiarPantalla();
                    imprimirCentrado("==========================================");
                    imprimirCentrado(" ¡Gracias por jugar! Saliendo del sistema ");
                    imprimirCentrado("==========================================");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    presionarEnter(scanner);
                    break;
            }
        }

        scanner.close();
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

    private static void dibujarMenuAscii() {
        System.out.println();
        imprimirCentrado("███╗   ███╗███████╗███╗   ██╗██║   ██║");
        imprimirCentrado("████╗ ████║██╔════╝████╗  ██║██║   ██║");
        imprimirCentrado("██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║");
        imprimirCentrado("██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║");
        imprimirCentrado("██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝");
        imprimirCentrado("╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ ");
        System.out.println();
        imprimirCentrado("+──────────────────────────────────────────+");
        imprimirCentrado("│  1. Jugar nueva partida (3 rondas)       │");
        imprimirCentrado("│  2. Ver historial de ganadores           │");
        imprimirCentrado("│  3. Cambiar nombre de jugadores          │");
        imprimirCentrado("│  4. Salir                                │");
        imprimirCentrado("+──────────────────────────────────────────+");
        System.out.println();
    }

    private static void cambiarNombresJugadores(Juego juego, Scanner scanner) {
        Juego.limpiarPantalla();
        imprimirCentrado("==========================================");
        imprimirCentrado("       CAMBIAR NOMBRE DE JUGADORES        ");
        imprimirCentrado("==========================================");
        System.out.println();

        Jugador[] jugadores = juego.getJugadores();
        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("Nuevo nombre para " + jugadores[i].getNombre() + " (ENTER para mantener): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.trim().isEmpty()) {
                jugadores[i].setNombre(nuevoNombre.trim());
            }
        }
        System.out.println("\n[✓] Nombres actualizados correctamente.");
    }

    private static void presionarEnter(Scanner scanner) {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}