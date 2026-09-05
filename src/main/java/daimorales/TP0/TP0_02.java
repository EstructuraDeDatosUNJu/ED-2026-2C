// la siguiente línea de código indica el paquete al que pertenece la clase TP0_01
// El paquete es una forma de organizar las clases en Java y evitar conflictos de nombres.
package daimorales.TP0;

// Importamos la clase Scanner para leer la entrada del usuario
import java.util.Scanner;
import java.util.Random;
/* 
Desarrollar un programa que simule el registro de temperaturas de un sensor durante un día. El usuario
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

Preguntas sobre el problema
    a) Si se necesitara guardar el historial de todas las temperaturas para analizarlas nuevamente al final del
programa, ¿alcanzaría con usar una única variable simple? Justifique.
    b) ¿Qué ocurriría si la cantidad de mediciones ingresada fuera igual a 0? ¿Cómo se calcula el promedio en
ese caso y cómo debería reaccionar el programa?
    c) Si las mediciones aleatorias simuladas fueran: -5, 0, 15 y 35, sin ejecutar el programa, ¿cuál será el
promedio? ¿Cuántas son "Heladas" y cuántas "Calidas"?
    d) Ahora se desea conocer también la temperatura máxima y mínima registrada. ¿Qué variables
necesitarías agregar y cómo afectaría esto a la lógica dentro del ciclo?
*/

public class TP0_02 {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //declarar variables
        int cantMediciones = 0;
        int numAleatorioTemperatura =0;
        double promedioMediciones =0;
        int medicionesHeladas =0;
        int medicionesCalidas =0;

        System.out.println("---------Registro de temperaturas de un sensor durnate el dia---------");

        cantMediciones = validacionHelper.leerEnteroNoNegativo(scanner,"Ingrese la cantidad de mediciones que desea simular (mayor o igual a 0): ");

        for (int i =1 ;i <= cantMediciones; i++){
            numAleatorioTemperatura = random.nextInt(40 -(-10) +1) + (-10);
            System.out.print(" Medicion: "+ numAleatorioTemperatura);
            System.out.println();
        
            promedioMediciones += numAleatorioTemperatura;
            if (numAleatorioTemperatura< 0){
                medicionesHeladas += 1; 
            }else if (numAleatorioTemperatura>= 30){
                medicionesCalidas += 1;
            }
        }
        System.out.println ("El promedio total de todas las mediciones es de : "+ promedioMediciones);
        System.out.println ("La cantidad de mediicones heladas es de: "+ medicionesHeladas);
        System.out.println ("La cantidad de mediicones heladas es de: "+ medicionesCalidas);
    
    scanner.close();
    }


}
