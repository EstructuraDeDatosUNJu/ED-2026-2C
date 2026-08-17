// Programa que calcula el salario neto semanal de un trabajador.

// la siguiente línea de código indica el paquete al que pertenece la clase TP0_01
// El paquete es una forma de organizar las clases en Java y evitar conflictos de nombres.
package ed2026.TP0;

// Importamos la clase Scanner para leer la entrada del usuario
import java.util.Scanner;

/*
 * Enunciado del ejercicio:
 * 
 * Desarrollar un programa que calcule el salario neto de un trabajador en función de las horas trabajadas.
 * El programa debe solicitar al usuario: 
*   el nombre del empleado, 
*   la cantidad de horas trabajadas en la semana y 
*   el valor de la hora trabajada.
 * El cálculo del salario bruto se realiza multiplicando las horas trabajadas por el valor de la hora. 
 * Sin embargo, si el empleado trabajó más de 40 horas, las horas excedentes se consideran horas extras 
 * y se deben pagar con un recargo del 50% sobre el valor de la hora normal.
 * 
 * horasExtras = horasTrabajadas - 40
 * pagoExtra = horasExtras * (valorHora * 1.5)
 * 
 * Salario Bruto: Es la suma de ambos pagos.
 * salarioBruto = pagoNormal + pagoExtra
 * 
 * Una vez calculado el salario bruto, el programa debe aplicar los siguientes descuentos de ley 
 * (que se calculan sobre el salario bruto, incluyendo las horas extras):
 * 
 * ● Si el salario bruto es menor o igual a $1.000.000, aplicar un descuento del 9%.
 * ● Si el salario bruto es mayor a $1.000.000 pero menor o igual a $3.000.000, aplicar un descuento del 12%.
 * ● Si el salario bruto es mayor a $3.000.000, aplicar un descuento del 15%.
 * ● El programa debe mostrar el salario bruto, el monto total de descuento y el salario neto final a cobrar.
 */

// Clase principal del programa
// en Java, cada archivo fuente puede contener una clase pública que debe tener el mismo nombre que el archivo. 
// En este caso, la clase se llama TP0_01 y está definida en el archivo TP0_01.java. 
public class TP0_01 {
    // Método principal del programa
    // El método main es el punto de entrada de cualquier programa Java. Es donde comienza la ejecución del programa.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // declaración de variables
        String nombre;
        double horasTrabajadas = 0.0;
        double valorHora = 0.0;
        double pagoNormal = 0.0;
        double pagoExtra = 0.0;
        double salarioBruto = 0.0;
        double descuento = 0.0;
        double salarioNeto = 0.0;

        System.out.print("\nEjercicio 1: Cálculo del salario neto semanal de un trabajador\n");

        System.out.print("Ingrese el nombre del trabajador.........: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese las horas trabajadas en la semana: ");
        horasTrabajadas = scanner.nextDouble();

        System.out.print("Ingrese el valor de cada hora............: ");
        valorHora = scanner.nextDouble();

        if (horasTrabajadas > 40) {
            pagoNormal = 40 * valorHora;
            pagoExtra = (horasTrabajadas - 40) * (valorHora * 1.5);
        } else {
            pagoNormal = horasTrabajadas * valorHora;
        }

        salarioBruto = pagoNormal + pagoExtra;
        descuento = 0.0;

        if (salarioBruto <= 1000000) {
            descuento = salarioBruto * 0.09; // Descuento del 9%
        } else if (salarioBruto <= 3000000) {
            descuento = salarioBruto * 0.12; // Descuento del 12%
        } else {
            descuento = salarioBruto * 0.15; // Descuento del 15%
        }

        salarioNeto = salarioBruto - descuento;

        System.out.println("\nTrabajador..........: " + nombre);
        System.out.println("Salario bruto.......: " + salarioBruto);
        System.out.println("Salario neto semanal: " + salarioNeto);
        System.out.println("Descuento...........: " + descuento);

        scanner.close();
    }
}
