package ed2026.TP1;

// Importamos la clase Scanner para leer la entrada del usuario
import java.util.Scanner;

/**
 * Clase principal para el ejercicio 1 del TP1.
 * 
 * @author Julio Tentor
 * @version 1.0
 * 
 *          En el programa principal (main) se debe:
 *          Crear una única instancia de la clase Cilindro.
 *          Solicitar al usuario que ingrese el radio y la altura verificando que los valores sean
 *          estrictamente
 *          positivos (mayores a cero).
 *          Utilizar los métodos de la clase Cilindro para establecer estas dimensiones.
 *          Calcular y mostrar el volumen y el área de la superficie del cilindro creado,
 *          formateando los decimales a
 *          dos cifras.
 *
 */
public class TP1_01 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario

        Scanner scanner = new Scanner(System.in);

        System.out.println("/nEjercicio 1 - Clase Cilindro/n");

        // Crear una instancia de la clase Cilindro
        Cilindro cilindro = new Cilindro();

        double radio = 0.0;
        double altura = 0.0;

        // Validar que el radio sea mayor a cero
        while (radio <= 0) {
            System.out.print("Ingrese el radio del cilindro (mayor a cero): ");
            radio = scanner.nextDouble();
            if (radio <= 0) {
                System.out.print("Error: El radio debe ser mayor a cero. Ingrese nuevamente: ");
            }
        }

        // Validar que la altura sea mayor a cero
        while (altura <= 0) {
            System.out.print("Ingrese la altura del cilindro (mayor a cero): ");
            altura = scanner.nextDouble();
            if (altura <= 0) {
                System.out.print("Error: La altura debe ser mayor a cero. Ingrese nuevamente: ");
            }
        }

        // Establecer las dimensiones del cilindro
        cilindro.setRadio(radio);
        cilindro.setAltura(altura);

        // Calcular y mostrar el volumen y el área de la superficie del cilindro
        System.out.printf("Volumen del cilindro: %.2f%n", cilindro.getVolumen());
        System.out.printf("Área de la superficie del cilindro: %.2f%n", cilindro.getAreaSuperficie());

        System.out.println("\nValor del Radio: " + cilindro.getRadio());
        try {
            // Intentar establecer un radio negativo para probar la validación
            cilindro.setRadio(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\nValor del Radio después de la prueba: " + cilindro.getRadio());
        // Calcular y mostrar el volumen y el área de la superficie del cilindro
        System.out.printf("Volumen del cilindro: %.2f%n", cilindro.getVolumen());
        System.out.printf("Área de la superficie del cilindro: %.2f%n", cilindro.getAreaSuperficie());

        scanner.close();
    }
}
