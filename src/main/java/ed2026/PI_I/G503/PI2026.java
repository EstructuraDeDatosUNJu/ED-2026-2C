package ed2026.PI_I.G503;

import java.util.Scanner;

public class PI2026 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Jugador> colaJugadores = new Queue<>();
        Mesa mesa = new Mesa(colaJugadores);

        System.out.println("============================================================");
        System.out.println("          BIENVENIDO AL JUEGO DE CARTAS                     ");
        System.out.println("============================================================");
        System.out.println("  1. Cargar jugadores manualmente");
        System.out.println("  2. Usar jugadores predeterminados (prueba rapida)");
        System.out.println("============================================================");

        int opcion = Helper.validarEnteroEnRango(scanner, "Seleccione una opcion", "Opcion invalida.", 1, 2);

        if (opcion == 1) {
            // Carga manual de jugadores
            int cantidadJugadores = Helper.validarEnteroEnRango(scanner, "¿Cuántos jugadores participarán?",
                    "Deben ser al menos 2 jugadores.", 2, 10);

            for (int i = 1; i <= cantidadJugadores; i++) {
                System.out.println("\nIngreso de datos: Jugador " + i);
                String nombre = Helper.validarStringNoVacio(scanner, "Nombre:");
                String apellido = Helper.validarStringNoVacio(scanner, "Apellido:");
                int edad = Helper.validarEnteroNoNegativo(scanner, "Edad:");

                Jugador nuevoJugador = new Jugador(nombre, apellido, edad);
                mesa.agregarJugador(nuevoJugador);
            }
        } else {
            // Jugadores predeterminados
            cargarJugadoresPredeterminados(mesa);
        }

        if (!mesa.iniciarJuego()) {
            System.out.println("No se pudo iniciar la partida.");
            return;
        }

        boolean continuarJugando = true;
        int rondaActual = 1;
        while (continuarJugando && mesa.hayCartasSuficientes()) {
            System.out.println("INICIANDO RONDA: " + rondaActual);
            mesa.jugarRonda();
            if (mesa.hayCartasSuficientes()) {
                continuarJugando = Helper.validarSiNo(scanner, "\n¿Desea continuar y jugar la siguiente ronda?");
            } else {
                System.out
                        .println("\nEl mazo se ha quedado sin naipes suficientes para repartir a todos los jugadores.");
            }
            rondaActual++;
        }

        mesa.determinarGanador();
    }

    private static void cargarJugadoresPredeterminados(Mesa mesa) {
        mesa.agregarJugador(new Jugador("Ana", "Garcia", 22));
        mesa.agregarJugador(new Jugador("Carlos", "Lopez", 25));
        mesa.agregarJugador(new Jugador("Maria", "Martinez", 20));
        mesa.agregarJugador(new Jugador("Juan", "Rodriguez", 28));

        System.out.println("\n--- Jugadores predeterminados cargados ---");
        System.out.println("  1. Ana Garcia (Edad: 22)");
        System.out.println("  2. Carlos Lopez (Edad: 25)");
        System.out.println("  3. Maria Martinez (Edad: 20)");
        System.out.println("  4. Juan Rodriguez (Edad: 28)");
        System.out.println();
    }
}
