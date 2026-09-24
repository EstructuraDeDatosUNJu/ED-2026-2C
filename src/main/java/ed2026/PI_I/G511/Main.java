package ed2026.PI_I.G511;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jugador[] jugadores = new Jugador[4];

        // 1. Carga de Jugadores
        System.out.println("   REGISTRO DE JUGADORES PARA EL JUEGO    ");
        System.out.println("==========================================");

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("\nDatos del Jugador " + (i + 1) + ":");
            String nombre = leerTexto(scanner, "Nombre: ");
            String apellido = leerTexto(scanner, "Apellido: ");
            int edad = leerEntero(scanner, "Edad: ");

            jugadores[i] = new Jugador(nombre, apellido, edad);
        }

        Mazo mazo = new Mazo();
        GestorRonda turnos = new GestorRonda();
        EvaluadorPartida evaluador = new EvaluadorPartida();

        for (int ronda = 1; ronda <= 4; ronda++) {
            System.out.println("             RONDA " + ronda);
            System.out.println("==========================================");

            turnos.comenzarRounda(jugadores);

            Carta[] cartasRonda = new Carta[jugadores.length];
            Jugador[] ordenJugadores = new Jugador[jugadores.length];
            int i = 0;

            while (turnos.hayJugadores()) {
                Jugador actual = turnos.obtenerSiguiente();
                Carta cartaRobada = mazo.robarCarta();

                ordenJugadores[i] = actual;
                cartasRonda[i] = cartaRobada;
                i++;

                System.out.println("-> " + actual.getNombre() + " " + actual.getApellido()
                        + " robó: " + cartaRobada);
            }

            GestorRonda.resolverRonda(cartasRonda, ordenJugadores);
        }

        evaluador.procesarResultados(jugadores);

        scanner.close();
    }

    private static String leerTexto(Scanner sc, String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = sc.nextLine().trim();
            if (!input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("Error: Ingrese solo letras.");
            }
        } while (!input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
        return input;
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine());
                if (valor > 0)
                    return valor;
                System.out.println("Error: Ingrese un número mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        }
    }

    public static int convertirValorANumero(String valor) {
        switch (valor) {
            case "A":
                return 1;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(valor);
        }
    }
}
