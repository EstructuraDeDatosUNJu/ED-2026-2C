package ed2026.TP0;

/**
 * Desarrollar un programa que simule el registro de temperaturas de un sensor durante un día. El usuario
debe ingresar la cantidad de mediciones que desea simular. Por cada medición, el programa debe:
a) Generar y mostrar un número aleatorio (entre -10 y 40), simulando la temperatura en grados
Celsius.
b) Al finalizar las mediciones, el programa debe calcular y mostrar la temperatura promedio del día, y
contar cuántas mediciones fueron consideradas "Heladas" (menores a 0°C) y cuántas fueron
"Calidas" (mayores o iguales a 30°C).
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio. También necesita del objeto random para
generar valores de manera aleatoria.
 */


import java.util.Random;
import java.util.Scanner;

public class TP0_02 {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int cantidadMediciones;

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Ingrese la cantidad de mediciones a simular: ");
            cantidadMediciones = entrada.nextInt();
        }

        // Validación de cantidad positiva
        if (cantidadMediciones <= 0) {
            System.out.println("Error: Debe ingresar al menos una medición (> 0).");
            return;
        }

        int heladas = 0;
        int calidas = 0;
        int sumaTemperatura = 0;

        System.out.println("\n--- Registro de Mediciones ---");
        for (int i = 1; i <= cantidadMediciones; i++) {
            int temperatura = generarNumeroAleatorio(-10, 40);
            System.out.println("Medición #" + i + ": " + temperatura + " °C");

            sumaTemperatura += temperatura;

            if (temperatura < 0) {
                heladas++;
            } else if (temperatura >= 30) {
                calidas++;
            }
        }

        // Cálculo con decimales precisos
        float temperaturaPromedio = (float) sumaTemperatura / cantidadMediciones;

        System.out.println("\n==========================================");
        System.out.printf("Temperatura promedio del día: %.2f °C%n", temperaturaPromedio);
        System.out.println("Cantidad de mediciones Heladas (< 0 °C): " + heladas);
        System.out.println("Cantidad de mediciones Cálidas (>= 30 °C): " + calidas);
        System.out.println("==========================================");
    }

    /**
     * Genera un número entero aleatorio en el rango [min, max] inclusive.
     */
    public static int generarNumeroAleatorio(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
