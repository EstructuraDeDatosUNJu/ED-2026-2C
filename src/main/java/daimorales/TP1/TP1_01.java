package daimorales.TP1;


import java.util.Scanner;

/*1) Diseñar una clase llamada Cilindro que representa una figura geométrica tridimensional. Esta clase debe
tener los atributos radio (de la base) y altura. La clase Cilindro debe incluir:
    a) Constructor predeterminado que inicialice ambos valores en 1.0.
    b) Un constructor con argumentos para establecer el radio y la altura del cilindro.
    c) Un método que devuelva el volumen del cilindro (Fórmula: π * radio2 * altura).
    d) Un método que devuelva el área de la superficie total (Fórmula: 2 * π * radio * (radio + altura)).
En el programa principal (main) se debe:
    e) Crear una única instancia de la clase Cilindro.
    f) Solicitar al usuario que ingrese el radio y la altura verificando que los valores sean estrictamente
    positivos (mayores a cero).
    g) Utilizar los métodos de la clase Cilindro para establecer estas dimensiones.
    h) Calcular y mostrar el volumen y el área de la superficie del cilindro creado, formateando los decimales a
dos cifras.

Indicaciones:
    Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.

Preguntas sobre el problema
    a) ¿Cuáles son las entradas y salidas del programa? ¿Qué información debe mantenerse almacenada en el
    objeto durante toda la ejecución y qué información es sólo temporal?
    b) ¿Qué ocurre si el usuario intenta ingresar un radio o altura igual a cero o a un valor negativo? ¿Cómo
    garantiza su código que el objeto Cilindro nunca contenga dimensiones inválidas?
    c) Compruebe el comportamiento de un objeto cilindro cuando se usan: valores positivos, valores que
    intenten vulnerar la validación (por ej. valor negativo) y cuando el radio y la altura son iguales.
    d) ¿Qué ventajas tiene implementar los cálculos de volumen y área como métodos en la clase Cilindro en
    lugar de hacer las operaciones matemáticas directamente en el método main?
*/

public class TP1_01 {
    public static void  main (String[]args) {

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner (System.in);
    
        System.out.println("---------Volumen y área de un cilindro---------------");
        
        //Crear una instancia de la clase cilindro
        Cilindro cilindro = new Cilindro();
        double radio = 0.0;
        double altura = 0.0;

        while(radio<=0){
            System.out.print("Ingrese el radio del cilindro:  ");
            radio = scanner.nextDouble();
            if (radio<=0){
                System.out.print("ERROR... Ingrese nuevamente el radio debe ser mayor a 0");

            }
        }

        while(altura<=0){
            System.out.print("Ingrese la altura del cilindro: ");
            altura = scanner.nextDouble();
            if (altura<=0){
                System.out.print("ERROR... Ingrese nuevamente la altura debe ser mayor a 0");

            }
            
        }
        //double radio = validacionHelper.leerDoublePositivo(scanner, "Ingrese el radio: ");
        //double altura = validacionHelper.leerDoublePositivo(scanner, "Ingrese la altura: ");

        // Establecer las dimensiones del cilindro
        cilindro.setRadio(radio);
        cilindro.setAltura(altura);

        //Mostrar volumen y area del cilindro
        System.out.printf ("El volumen del cilindro es de:  %.2f%n" , cilindro.calcularVolumen());
        System.out.printf("El area del cilindro es de:  %.2f%n" ,  cilindro.calcularArea());
    scanner.close();
    } 
}
