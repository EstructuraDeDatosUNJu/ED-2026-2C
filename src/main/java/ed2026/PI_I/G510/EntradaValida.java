package ed2026.PI_I.G510;

import java.util.Scanner;

public class EntradaValida {

    // Lee y valida texto (no vaci­o y sin numeros) en una sola llamada
    public static String leerTexto(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                // 1. Validar que no este vacio
                if (entrada == null || entrada.trim().isEmpty()) {
                    throw new IllegalArgumentException("El texto no puede estar vacio.");
                }
                // 2. Validar que no contenga numeros
                if (entrada.matches(".*\\d.*")) { // Expresion regular para detectar digitos
                    throw new IllegalArgumentException("El texto no debe contener numeros.");
                }

                // Si todo esta bien, retorna el texto y rompe el bucle automaticamente
                return entrada.trim(); //.trim() elimina espacios al inicio y al final

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Reintente.\n");
            }
        }
    }

    // Lee y valida un numero entero en una sola llamada
    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje); // va a pasar el mensaje que le pasemos desde el menu
            String entrada = scanner.nextLine();

            try {
                if (entrada == null || entrada.trim().isEmpty()) {
                    throw new IllegalArgumentException("La entrada no puede estar vaci­a.");
                }

                // Intenta convertir la cadena a entero
                return Integer.parseInt(entrada.trim());

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero entero valido. Reintente.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Reintente con un valor correcto.\n");
            }
        }
    }

    // verificar que numeros no sean negativos
    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        while (true) {
            int numero = leerEntero(scanner, mensaje);
            if (numero < 0) {
                System.out.println("Error: El numero no puede ser negativo. Reintente.\n");
            } else {
                return numero;
            }
        }
    }
}