public class MiStack {
    private final int[] datos; // Arreglo donde se almacenan los elementos.
    private int cuenta; // Cantidad actual de elementos en la pila.

    public MiStack(int capacidad) { // Crea una pila
        datos = new int[capacidad];
        cuenta = 0;
    }

    public void push(int elemento) { // Agrega un elemento al tope de la pila.
        if (cuenta == datos.length) {
            throw new IllegalStateException("La pila está llena.");
        }

        datos[cuenta++] = elemento;
    }

    public int pop() { // Extrae y devuelve el elemento del tope.
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }

        return datos[--cuenta];
    }

    public boolean isEmpty() { // Verifica si la pila está vacía.
        return cuenta == 0;
    }
}
