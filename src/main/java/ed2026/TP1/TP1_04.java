package ed2026.TP1;

/*
* 4) Desarrollar una clase llamada Paciente para gestionar información de salud básica. Esta clase debe tener los
siguientes atributos: nombre, dni, peso (en kg) y altura (en metros). La clase Paciente debe incluir los
siguientes métodos:
a) Métodos para establecer y obtener el nombre, dni, peso y altura del paciente.
b) Un método que calcule y devuelva el Índice de Masa Corporal (IMC) (Fórmula: peso / (altura * altura)).
*       c) Un método que devuelva un String indicando el estado nutricional según el IMC: "Bajo peso" si el IMC
es menor a 18.5, "Normal" si está entre 18.5 y 24.9, "Sobrepeso" si está entre 25 y 29.9, y "Obesidad" si
es mayor o igual a 30.
En el programa principal (main) se debe:
d) Crear una instancia de la clase Paciente.
e) Solicitar al usuario que ingrese el nombre, el dni, el peso y la altura del paciente, validando que peso y
altura sean valores numéricos positivos.
f) Utilizar los métodos de la clase Paciente para establecer estos valores.
g) Mostrar el nombre del paciente, el dni, el valor de su IMC (formateado a dos decimales) y su estado
nutricional.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
Preguntas sobre el problema
a) Al diseñar la clase, ¿el IMC debería ser un atributo (ej. double imc;) o solo el resultado de un método de
cálculo (ej. calcularIMC())? Tenga en cuenta que inicialmente el peso puede recibir un valor, pero luego
se puede invocar al método setter para cambiarlo.
b) Encontrar valores de peso y altura tales que los cálculos de IMC correspondientes sean iguales a 24.9 y
a 25.0 (Ayuda: fijar un valor para una de las variables y despejar la otra usando la fórmula de IMC).
¿Qué estado nutricional se obtiene en cada caso? ¿Por qué es crucial probar estos límites en las
estructuras condicionales?
c) Un compañero escribe la validación de la altura de una persona en el método main de esta manera:
if (altura > 0) {
paciente.setAltura(altura);
}
Sin embargo, más tarde descubre que usando los setters de forma directa alguien pudo asignarle una
altura de -2 al objeto. ¿Qué falta en el diseño de la clase Paciente para garantizar que sus atributos
NUNCA tengan valores negativos sin importar quién use la clase? Argumente sobre cómo deberían ser
los métodos setter.
* */



import java.util.Locale;
import java.util.Scanner;

public class TP1_04 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { //try catch + iniciar el objeto del scanner
            Paciente paciente = new Paciente(); // lo mismo del paciente

            paciente.setNombre(leerTextoNoVacio(scanner, "Ingrese el nombre: "));
            paciente.setDni(leerTextoNoVacio(scanner, "Ingrese el DNI: "));
            paciente.setPeso(leerNumeroPositivo(scanner, "Ingrese el peso en kg: "));
            paciente.setAltura(leerNumeroPositivo(scanner, "Ingrese la altura en metros: "));
            // ingresar datos del paciente
            double imc = paciente.calcularImc(); // asignar imc con el metodo del paciente calcularImc()
            System.out.println("\n--- Datos del paciente ---");
            System.out.println("Nombre: " + paciente.getNombre());
            System.out.println("DNI: " + paciente.getDni());
            System.out.printf(Locale.US, "IMC: %.2f%n", imc);
            System.out.println("Estado nutricional: " + paciente.obtenerEstadoNutricional());
            // salida
        }
    }

    private static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El valor no puede estar vacío. Intente nuevamente.");
        } // funcion para que detecte texto vacio
    }

    private static double leerNumeroPositivo(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim().replace(',', '.');

            try {
                double numero = Double.parseDouble(entrada);
                if (Double.isFinite(numero) && numero > 0) {
                    return numero;
                }
                System.out.println("Ingrese un número positivo mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un valor numérico válido.");
            } // funcion que evita que el usuario coloque numeros negativos
        }
    }
}

/*
*
* Preguntas sobre el problema
a) Al diseñar la clase, ¿el IMC debería ser un atributo (ej. double imc;) o solo el resultado de un método de
cálculo (ej. calcularIMC())? Tenga en cuenta que inicialmente el peso puede recibir un valor, pero luego
se puede invocar al método setter para cambiarlo.
b) Encontrar valores de peso y altura tales que los cálculos de IMC correspondientes sean iguales a 24.9 y
a 25.0 (Ayuda: fijar un valor para una de las variables y despejar la otra usando la fórmula de IMC).
¿Qué estado nutricional se obtiene en cada caso? ¿Por qué es crucial probar estos límites en las
estructuras condicionales?
c) Un compañero escribe la validación de la altura de una persona en el método main de esta manera:
if (altura > 0) {
paciente.setAltura(altura);
}
Sin embargo, más tarde descubre que usando los setters de forma directa alguien pudo asignarle una
altura de -2 al objeto. ¿Qué falta en el diseño de la clase Paciente para garantizar que sus atributos
NUNCA tengan valores negativos sin importar quién use la clase? Argumente sobre cómo deberían ser
los métodos setter.
*
* a) El IMC es un dato derivado de peso y altura. Si fuera un atributo guardado,
* al modificar el peso con setPeso(), el IMC se desactualizaría y quedaría en un estado inconsistente.
*
* b) Para un paciente con una altura fija de 1.80 m (cuya altura al cuadrado es 1.80 x 1.80 = 3.24):
Para lograr un IMC de 24.9:
Multiplicamos el IMC deseado por la altura al cuadrado (24.9 x 3.24), lo que nos da un peso de 80.68 kg.
Estado nutricional: devuelve "Normal", ya que 24.9 es menor a 25.
Para lograr un IMC de 25.0:
Multiplicamos 25.0 x 3.24, lo que nos da un peso de 81.0 kg.
Estado nutricional:
* Retorna "Sobrepeso", porque al llegar a 25 ya no cumple la condición de ser menor a 25 y pasa a la siguiente categoría.
* c) Los setters protegen el encapsulamiento. Deben validar internamente y lanzar una excepción
* (IllegalArgumentException) si el valor es incoherente. Así se evita el ingreso de datos inválidos sin importar quién llame al método.
* */