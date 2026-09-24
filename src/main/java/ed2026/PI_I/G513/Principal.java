package ed2026.PI_I.G513;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        System.out.println("=== BIENVENIDO AL JUEGO ===");

        try (Scanner scanner = new Scanner(System.in)) {
            Juego juego = new Juego(scanner);
            juego.iniciar();
        }

        System.out.println("\nGracias por jugar, fin del juego.");
    }
}