package ed2026.TP2;

/**
 * Desarrollar un programa que solicite al usuario un valor entero N.
 * Generar N números aleatorios (entre -50 y 50) y cargarlos en un arreglo.
 * Luego el programa debe implementar:
 * 
 * a) Un método que reciba el arreglo inicial y devuelva otro arreglo que contenga los elementos
 * desplazados una posición hacia la izquierda (el primer elemento debe pasar a la última posición).
 * 
 * b) Un método que calcule y muestre la suma de los números positivos y la suma de los números
 * negativos por separado.
 * 
 * c) Un método que invierta el orden de los elementos del arreglo original modificándolo
 * directamente (sin crear un arreglo nuevo) y luego lo muestre.
 * 
 */

public class TP2_01 {
    public static void main(String[] args) {

        int N = 0;

        while (N <= 0) {
            N = Helper.nextInteger("Ingrese un valor entero N: ",
                    "Error: Ingrese un número entero válido.");
        }

        Integer[] randomArray = new Integer[N];

        for (int i = 0; i < N; i++) {
            // Genera un número aleatorio entre -50 y 50
            randomArray[i] = (int) (Math.random() * 101) - 50;
        }

        Helper.printOneDimensionArray("\nArreglo original de números aleatorios: ", randomArray, "\n");

        // Desplaza los elementos del arreglo una posición hacia la izquierda
        Integer[] shiftedArray = shiftLeft(randomArray);
        Helper.printOneDimensionArray("\nArreglo desplazado a la izquierda: ", shiftedArray, "\n");

        // Muestra el arreglo original
        Helper.printOneDimensionArray("\nArreglo original de números aleatorios: ", randomArray, "\n");
        shiftedArray = shiftLeftClone(randomArray);
        Helper.printOneDimensionArray("\nArreglo desplazado a la izquierda (copia): ", shiftedArray, "\n");
        Helper.printOneDimensionArray("\nArreglo original de números aleatorios: ", randomArray, "\n");

        // Calcula la suma de los números positivos y negativos
        calculateSums(randomArray);

        // Invierte el orden de los elementos del arreglo original
        reverseArray(randomArray);
    }

    /**
     * Método que desplaza los elementos de un arreglo una posición hacia la izquierda.
     * El primer elemento pasa a la última posición.
     * 
     * @param array el arreglo a desplazar
     * @return el arreglo con los elementos desplazados
     */
    private static Integer[] shiftLeft(Integer[] array) {
        if (array.length == 0) {
            return array;
        }

        Integer firstElement = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = firstElement;

        return array;
    }

    /**
     * Método que crea una copia del arreglo y desplaza sus elementos una posición hacia la izquierda.
     * El primer elemento pasa a la última posición.
     * 
     * @param array el arreglo a desplazar
     * @return el arreglo con los elementos desplazados
     */
    private static Integer[] shiftLeftClone(Integer[] array) {
        if (array.length == 0) {
            return array;
        }
        Integer[] newArray = array.clone();
        Integer firstElement = newArray[0];
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i] = newArray[i + 1];
        }
        newArray[newArray.length - 1] = firstElement;

        return newArray;
    }

    /**
     * Método que calcula y muestra la suma de los números positivos y negativos de un arreglo.
     * 
     * @param array el arreglo de números enteros
     */
    private static void calculateSums(Integer[] array) {
        int positiveSum = 0;
        int negativeSum = 0;

        for (Integer number : array) {
            if (number > 0) {
                positiveSum += number;
            } else if (number < 0) {
                negativeSum += number;
            }
        }

        System.out.println("\nSuma de números positivos: " + positiveSum);
        System.out.println("Suma de números negativos: " + negativeSum);
    }

    /**
     * Método que invierte el orden de los elementos de un arreglo modificándolo directamente.
     * 
     * @param array el arreglo a invertir
     */
    private static void reverseArray(Integer[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Intercambia los elementos en las posiciones left y right
            Integer temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        Helper.printOneDimensionArray("\nArreglo invertido: ", array, "\n");
    }
}
