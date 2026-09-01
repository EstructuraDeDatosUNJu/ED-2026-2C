package ed2026.TP3;

/**
 * Escribir un programa que genere 15 números enteros aleatorios (entre -20 y 20) y los guarde en
 * una pila. Luego, quitar los elementos de la pila y guardar los números positivos (incluyendo el
 * 0) en una nueva pila llamada positivos y los negativos en otra llamada negativos. Calcular y
 * mostrar el valor máximo y el valor mínimo de cada una de las pilas creadas. Al finalizar el
 * proceso, la pila original debe mantenerse sin modificaciones (con sus elementos en el orden
 * original).
 */
public class TP3_01_2 {

    public static void main(String[] args) {

        Stack<Integer> pilaOriginal = new Stack<>(15);
        Stack<Integer> positivos = new Stack<>();
        Stack<Integer> negativos = new Stack<>();

        while (pilaOriginal.size() < 15) {
            int numeroAleatorio = (int) (Math.random() * 41) - 20; // Genera un número aleatorio entre -20 y 20
            pilaOriginal.push(numeroAleatorio);
        }

        System.out.println("Pila original (antes de procesar)..: " + pilaOriginal.toString());

        Integer[] numeros = pilaOriginal.toArray(new Integer[0]);
        for (Integer number : numeros) {
            if (number >= 0) {
                positivos.push(number);
            } else {
                negativos.push(number);
            }
        }

        System.out.println("Pila original (después de procesar): " + pilaOriginal.toString());
        System.out.println("Pila de números positivos..........: " + positivos.toString());
        System.out.println("Pila de números negativos..........: " + negativos.toString());

        System.out.println("Valor máximo de la pila de positivos: " + max(positivos));
        System.out.println("Valor mínimo de la pila de positivos: " + min(positivos));
        System.out.println("Valor máximo de la pila de negativos: " + max(negativos));
        System.out.println("Valor mínimo de la pila de negativos: " + min(negativos));

        System.out.println("Pila de números positivos..........: " + positivos.toString());
        System.out.println("Pila de números negativos..........: " + negativos.toString());
    }

    /**
     * Devuelve el valor máximo de una pila de enteros.
     * 
     * @param pila La pila de enteros.
     * @return El valor máximo de la pila.
     */
    private static Integer max(Stack<Integer> pila) {
        if (pila.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        Integer maximo = pila.peek();
        Integer[] numeros = pila.toArray(new Integer[0]);
        for (Integer numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }
        return maximo;
    }

    /**
     * Devuelve el valor mínimo de una pila de enteros.
     * 
     * @param pila La pila de enteros.
     * @return El valor mínimo de la pila.
     */
    private static Integer min(Stack<Integer> pila) {
        if (pila.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        Integer minimo = pila.peek();
        Integer[] numeros = pila.toArray(new Integer[0]);
        for (Integer numero : numeros) {
            if (numero < minimo) {
                minimo = numero;
            }
        }
        return minimo;
    }

}
