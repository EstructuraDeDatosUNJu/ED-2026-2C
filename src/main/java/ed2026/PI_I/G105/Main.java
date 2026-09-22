package ed2026.PI_I.G105;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println("   BIENVENIDOS AL JUEGO DE CARTAS - PROYECTO I       ");
        System.out.println("=====================================================");

        System.out.println("\nPor favor, registre a los 4 participantes de la mesa:");
        Jugador[] jugadores = new Jugador[4];

        for (int i = 0; i < 4; i++) {
            System.out.println("\n--- Jugador N° " + (i + 1) + " ---");
            System.out.print("Ingrese el nombre: ");
            String nom = scanner.nextLine();

            System.out.print("Ingrese el apellido: ");
            String ap = scanner.nextLine();

            System.out.print("Ingrese la edad: ");
            int ed = scanner.nextInt();
            scanner.nextLine();

            jugadores[i] = new Jugador(nom, ap, ed);
        }

        System.out.println("\n¡Mesa lista! Los jugadores sentados son:");
        for (Jugador j : jugadores) {
            System.out.println("  -> " + j.getNombreCompleto() + " (" + j.getEdad() + " años)");
        }

        Mazo miMazo = new Mazo();
        int rondasTotales = 3;

        for (int r = 1; r <= rondasTotales; r++) {
            Ronda.jugarRonda(jugadores, miMazo, r);
        }

        System.out.println("\n=====================================================");
        System.out.println("              TABLA DE RESULTADOS FINALES            ");
        System.out.println("=====================================================");

        int maxPts = -1;

        for (Jugador j : jugadores) {
            int puntaje = j.calcularPuntaje();
            System.out.println(" - Jugador: " + j.getNombreCompleto() + " --> Puntaje Total: " + puntaje + " pts");
            if (puntaje > maxPts) {
                maxPts = puntaje;
            }
        }

        System.out.println("\n-----------------------------------------------------");
        System.out.print(" ¡FELICIDADES AL GANADOR(ES): ");
        boolean primerImpreso = true;

        for (Jugador j : jugadores) {
            if (j.calcularPuntaje() == maxPts) {
                if (!primerImpreso)
                    System.out.print(", ");
                System.out.print(j.getNombreCompleto() + " (" + maxPts + " puntos)");
                primerImpreso = false;
            }
        }
        System.out.println("\n=====================================================");

        scanner.close();
    }
}