package ed2026.TP0;

/**
 * Desarrollar un programa que solicite al usuario los siguientes datos de un estudiante: cantidad total de
preguntas en un examen y cantidad de respuestas correctas. Utilizando estos datos, el programa debe
calcular el porcentaje de rendimiento aplicando la siguiente fórmula:
Porcentaje = (Respuestas correctas / Total de preguntas) * 100.
Una vez calculado el porcentaje, el programa debe clasificar el rendimiento del estudiante y mostrar en qué
categoría se encuentra, según las siguientes pautas:
Mayor o igual a 90%: Excelente
Entre 70% y 89.99%: Muy Bueno
Entre 50% y 69.99%: Aprobado
Menor a 50%: Desaprobado
El programa debe mostrar tanto el valor del porcentaje calculado como la categoría obtenida.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
 */
import java.util.Scanner;

public class TP0_03 {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int totalPreguntas = leerEnteroPositivo(entrada, "Ingrese la cantidad total de preguntas",
      1, Integer.MAX_VALUE);
    int correctas = leerEnteroPositivo(entrada,"Ingrese la cantidad de respuestas correctas",
      0, totalPreguntas);
        entrada.close();

    double porcentaje = calcularPorcentaje(correctas, totalPreguntas);
    String categoria = clasificarRendimiento(porcentaje);
    
    System.out.printf("%n--- Resultado ---%n");
    System.out.printf("Porcentaje: %.2f%% | Categoria: %s%n",porcentaje, categoria);
    
  }


/**
* Lee y valida enteros desde teclado garantizando que se encuentren en el rango permitido.
*/
private static int leerEnteroPositivo(Scanner entrada, String mensaje, int min, int max){
  int valor;
  while (true) {
    System.out.println(mensaje);
    if (entrada.hasNextInt()) {
      valor = entrada.nextInt();
      if(valor >= min && valor <= max){
        return valor;
      }

      System.out.printf("[Error] El valor debe estar entre %d y %d. %n",min, max);
    }else {
      System.out.println("[Error] Debe ingresar un número entero válido.");
      entrada.next();
    }
    
  }
}


/**
* Calcula el porcentaje de rendimiento evitando la división entera.
*/
public static double calcularPorcentaje(int correctas, int total){
  return ((double)correctas/total)*100.0;
}

    /**
    * Clasifica el rendiento segun las especificaciones.
    * @param porcentaje
    * @return categoria
    **/
  public  static String clasificarRendimiento(double porcentaje){
     if (porcentaje >= 90){
       return "Excelente";
     }else if (porcentaje >=70){
       return "Muy Bueno";
     }else if (porcentaje>=50){
       return "Aprobado";
     }else {
       return "Desaprobado";
     }
  }
}
