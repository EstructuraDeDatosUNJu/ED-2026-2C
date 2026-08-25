// la siguiente línea de código indica el paquete al que pertenece la clase TP0_01
// El paquete es una forma de organizar las clases en Java y evitar conflictos de nombres.
package daimorales.TP0;

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

        // declaramos las variables
        String nombreEmpleado = null;
        int cantHorasTrabajadas = 0 ;
        double valorPorHora = 0.0;
        
        double salarioBruto = 0.0;
        double pagoNormal =0.0;
        double pagoExtra =0.0;
        double horasExtras =0.0;

        double montoDelDescuento =0.0;
        double salarioNeto =0.0;


        System.out.println("   Calcular el salario ento de un trabajador por horas trabajadas      ");

        System.out.println(" Ingrese el nombre del empleado:  ");
        nombreEmpleado = scanner.nextLine();

        System.out.println("Ingrese el valor de las horas trabajadas por semana:  ");
        cantHorasTrabajadas = scanner.nextInt();

        System.out.println("Ingrese el valor por horas trabajadas:  ");
        valorPorHora = scanner.nextDouble();


        if (cantHorasTrabajadas > 40){
            pagoNormal = 40 * valorPorHora;

            horasExtras = cantHorasTrabajadas - 40;
            pagoExtra = horasExtras * (valorPorHora *1.5);  // 1.5 es xq 1.00 es del 100% del pago mas el 0.5 del recargo 
            salarioBruto = pagoNormal + pagoExtra;

        } else if (cantHorasTrabajadas<=40 && cantHorasTrabajadas >= 0){
            salarioBruto =cantHorasTrabajadas * valorPorHora;
        } else{
            System.out.println (" La cantidad de horas trabajadas es inferior a 0 ");

        }

        if (salarioBruto<= 1000000){
            montoDelDescuento= salarioBruto * 0.09 ;
        } if (salarioBruto> 1000000 && salarioBruto<= 3000000){
            montoDelDescuento= salarioBruto * 0.12 ;
        } if (salarioBruto> 3000000){
            montoDelDescuento= salarioBruto * 0.15 ;
        } else {
            System.out.println (" El salario Bruto es 0 pesos por lo que no existe descuento ");
            }
        salarioNeto = salarioBruto - montoDelDescuento;

        System.out.println("El nombre del empleado es : " + nombreEmpleado);
        System.out.println ("El monto total del descuento es de :  $" + montoDelDescuento );
        System.out.println (" El salario neto a cobrar es de:  $" + salarioNeto );



    scanner.close();


    }
}
