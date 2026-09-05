
import java.util.Random;
/*

Escribir un programa que genere 15 números enteros aleatorios (entre -20 y 20) y los guarde en una pila.
Luego, quitar los elementos de la pila y guardar los números positivos (incluyendo el 0) en una nueva pila
llamada positivos y los negativos en otra llamada negativos. 

Calcular y mostrar el valor máximo y el valor
mínimo de cada una de las pilas creadas. Al finalizar el proceso, la pila original debe mantenerse sin
modificaciones (con sus elementos en el orden original).
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio. También necesita del objeto random para
generar valores de manera aleatoria.

*/

public class TP3_01 {

    public static void main(String[] args) {

        Random random = new Random();

        MiStack pilaGeneral = new MiStack(15);
        MiStack pilaPositivos = new MiStack(15);
        MiStack pilaNegativos = new MiStack(15);
        MiStack auxiliar = new MiStack(15);

        System.out.println("Números generados:");

        for (int i = 0; i < 15; i++) {

            int numero = random.nextInt(41) - 20;

            System.out.print(numero + " ");

            pilaGeneral.push(numero);
        }

        System.out.println();

        while (!pilaGeneral.isEmpty()) {

            int numero = pilaGeneral.pop(); //quedaria al reves

            if (numero >= 0) {
                pilaPositivos.push(numero);
            } else {
                pilaNegativos.push(numero);
            }

            auxiliar.push(numero);
        }

        while (!auxiliar.isEmpty()) {
            pilaGeneral.push(auxiliar.pop());
        }

        mostrarMaxMin("Positivos", pilaPositivos);
        mostrarMaxMin("Negativos", pilaNegativos);
        mostrarPilaOriginal("General",pilaGeneral);
        mostrarPilaOriginal("Pila de positivos",pilaPositivos);
        mostrarPilaOriginal("Pila de negativos",pilaNegativos);
    }

   public static void mostrarPilaOriginal(String nombre, MiStack pila) {

        MiStack aux1 = new MiStack(15);
        MiStack aux2 = new MiStack(15);

         while (!pila.isEmpty()) {
            aux1.push(pila.pop());
         }

         System.out.println("\nPila " + nombre + ":");

        while (!aux1.isEmpty()) {
          int valor = aux1.pop();
         System.out.print(valor + " ");
         aux2.push(valor);
         }

        while (!aux2.isEmpty()) {
         pila.push(aux2.pop());
       }

         System.out.println();
         }

    public static void mostrarMaxMin(String nombre, MiStack pila) {

        if(pila.isEmpty()){
            System.out.println("\nLa pila esta vacia amiguito.\\n");
            return;
        }

        MiStack auxiliar = new MiStack(15);

        int valor = pila.pop();
        int max = valor;
        int min = valor;

        auxiliar.push(valor);

        while (!pila.isEmpty()) {

            valor = pila.pop();

            if (valor > max) {
                max = valor;
            }

            if (valor < min) {
                min = valor;
            }

            auxiliar.push(valor);
        }

        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }

        System.out.println("\nPila " + nombre);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
    }
}


/*

Preguntas sobre el problema
a) ¿Cuántas pilas auxiliares son necesarias para lograr separar los elementos y además garantizar que la
pila original quede sin modificaciones?
- En mi aplicacion he usado "3" pilas auxiliares, una para + otra para - y otra auxialar, Si se refiere a mostrar por consola la pila original
He necesitado dos auxiliares, porque la pila me invierte los valores por sus caracteristicas LIFO.
b) ¿Qué ocurre si todos los números generados son negativos? ¿Cómo se comporta el cálculo del máximo
y mínimo en la pila positivos? ¿Cómo debe manejar el programa una pila vacía para que no lance un
error al calcular el máximo?
- Si todos los numeros generados por la pila son negativos en el caso de este codigo devolveria un msj al usuario y terminaria el programa.
El calculo de maximo es simple, a medida que vamos sacando (.pop()) valores de la pila los guardamos en una variable y luego lo comparamos con el siguiente
En mi caso desde antes si sabe que la pila esta vacia ya termina el programa avisando al usuario.
c) Si la pila original (de cima a base) queda cargada con los valores -30, 10, -5 y 3, ¿El programa se ejecutó
correctamente? ¿Cuál será el contenido de la pila positivos y la pila negativos una vez terminado el
proceso?
- Si se ejecuta normalmente. El contenido de la pila de positivos seria 3,10. de los negativos -5,-30 se invierten las subpilas porque al reutilizar el metodo un vez haber sido descargadas
para el filtrado quedan invertidas de antes.
d) ¿Por qué es fundamental utilizar pilas auxiliares y no simplemente un bucle for o un ArrayList para
recuperar los elementos? Justifique.
- Porque trabajo con la cima del elemento sin alterar los datos más profundos




*/