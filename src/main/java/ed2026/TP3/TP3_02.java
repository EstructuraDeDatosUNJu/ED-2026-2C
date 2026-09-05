import java.util.Scanner;

/*

2) Dado un arreglo de números enteros, se desea invertir únicamente los números que son múltiplos de 3.
Para la inversión se debe utilizar una pila y se debe mantener el resto del arreglo sin modificaciones.
Ejemplo:Arreglo original contiene: 4, 3, 7, 9, 12, 2, 15
Múltiplos de 3 en el arreglo: 3, 9, 12, 15. Se invierten usando una pila: 15, 12, 9, 3.
Resultado final: 4, 15, 7, 12, 9, 2, 3
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.

*/

public class TP3_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // crea objeto scanner

        int cantidad = leerCantidad(scanner); // lee la cantidad de numeros a ingresar
        int[] numeros = leerArreglo(scanner, cantidad); // lee los numeros en si

        System.out.println("\nArreglo original:");
        mostrarArreglo(numeros); 

        invertirMultiplosDeTres(numeros); // invertir

        System.out.println("\nArreglo final:");
        mostrarArreglo(numeros);

        scanner.close();
    }

    public static int leerCantidad(Scanner scanner) {
        int cantidad;

        do {
            System.out.print("Ingrese la cantidad de números (1 a 100): "); // cantidad arbitraria

            while (!scanner.hasNextInt()) {
                System.out.print("Error: debe ingresar un número entero. Intente nuevamente: "); //verificar el escribir numeros N
                scanner.next();
            }

            cantidad = scanner.nextInt();

            if (cantidad < 1 || cantidad > 100) {
                System.out.println("Error: la cantidad debe estar entre 1 y 100.");
            }

        } while (cantidad < 1 || cantidad > 100);

        return cantidad;
    }

    public static int[] leerArreglo(Scanner scanner, int cantidad) {
        int[] numeros = new int[cantidad]; // se crea un arreglo una vez tomados los numeros

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");

            while (!scanner.hasNextInt()) {
                System.out.print("Error: debe ingresar un entero. Intente nuevamente: ");
                scanner.next();
            }

            numeros[i] = scanner.nextInt();
        }

        return numeros;
    }

    public static void invertirMultiplosDeTres(int[] numeros) {
        MiStack pila = new MiStack(numeros.length); // se cre la pila con MiStack

        for (int numero : numeros) { //se recorre el arreglo de numeros buscando multiplos de 3
            if (numero % 3 == 0) {
                pila.push(numero); // se cargan en la pila los multiplos de 3
            }
        }

        for (int i = 0; i < numeros.length; i++) { //Reemplaza los múltiplos de 3 en orden inverso.
            if (numeros[i] % 3 == 0) {
                numeros[i] = pila.pop();
            }
        }
    }

    public static void mostrarArreglo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) { // recorre el arreglo e imprime 
            System.out.print(numeros[i]);

            if (i < numeros.length - 1) {  // Imprime una coma entre elementos.
                System.out.print(", ");
            }
        }

        System.out.println(); // salto de linea
    }

}

/*

Preguntas sobre el problema
a) ¿Por qué la estructura pila es la ideal para invertir el orden de una secuencia de elementos, en lugar de
usar un arreglo o un ArrayList?
- Porque resulta más sencillo por las caracteristicas LIFO de la pila que automaticamente invierten los elementos al operar con la pila
b) En la pila ¿Es suficiente almacenar el valor del número múltiplo de 3, o es necesario almacenar otro
dato para luego poder reconstruir el arreglo?
- Es suficiente almacenar únicamente el valor del número. No es necesario guardar ningún dato adicional
c) Un compañero propone guardar en la pila el valor del número múltiplo de 3 y la posición donde se
encuentra este número, ¿Funciona esta alternativa?
- No deberia ya que se invierte
d) Si el arreglo no contiene ningún múltiplo de 3. ¿Qué le ocurrirá a la pila en ese escenario?
No pasa nada realmente, me vuelve a mostrar mi pila original
*/