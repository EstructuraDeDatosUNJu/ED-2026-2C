package ed2026.PI_I.G101;

public class Queue<E> {

    // Arreglo donde guardamos los elementos
    private Object[] elementos;

    // Posición del primer elemento
    private int head;

    // Posición donde se agregará el próximo elemento
    private int tail;

    // Cantidad de elementos que tiene actualmente la cola
    private int cantidad;

    // Constructor
    public Queue(int capacidad) {

        elementos = new Object[capacidad];

        head = 0;
        tail = 0;
        cantidad = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento El elemento que se desea agregar a la cola.
     * @return true si el elemento se agregó correctamente, false si la cola está llena.
     */
    public boolean offer(E elemento) {

        if (cantidad >= elementos.length) {
            return false;
        }

        // Guardamos el elemento en la posición de tail
        elementos[tail] = elemento;

        // Avanzamos tail de forma circular
        tail = (tail + 1) % elementos.length;

        cantidad++;

        return true;
    }

    /**
     * Agrega un elemento al final de la cola.
     * 
     * @param elemento El elemento que se desea agregar a la cola.
     * @return true si el elemento se agregó correctamente.
     * @throws IllegalStateException Si la cola está llena.
     */
    public boolean add(E elemento) {

        if (cantidad >= elementos.length) {
            throw new IllegalStateException("Cola llena");
        }

        elementos[tail] = elemento;

        // Avanzamos tail de forma circular
        tail = (tail + 1) % elementos.length;

        cantidad++;

        return true;
    }

    /**
     * Saca y devuelve el primer elemento de la cola.
     * 
     * @return El primer elemento de la cola, o null si la cola está vacía.
     */
    @SuppressWarnings("unchecked")
    public E pull() {

        if (cantidad == 0) {
            return null;
        }

        // Guardamos el elemento que está en head
        E elemento = (E) elementos[head];

        // Avanzamos head de forma circular
        head = (head + 1) % elementos.length;

        cantidad--;

        return elemento;
    }

    /**
     * Saca y devuelve el primer elemento de la cola.
     * 
     * @return El primer elemento de la cola.
     * @throws IllegalStateException Si la cola está vacía.
     */
    @SuppressWarnings("unchecked")
    public E remove() {

        if (cantidad == 0) {
            throw new IllegalStateException("Cola vacía");
        }

        E elemento = (E) elementos[head];

        // Avanzamos head de forma circular
        head = (head + 1) % elementos.length;

        cantidad--;

        return elemento;
    }

    /**
     * Devuelve el primer elemento de la cola sin sacarlo.
     * 
     * @return El primer elemento de la cola, o null si la cola está vacía.
     */
    @SuppressWarnings("unchecked")
    public E peek() {

        if (cantidad == 0) {
            return null;
        }

        return (E) elementos[head];
    }

    /**
     * Devuelve el primer elemento de la cola sin sacarlo.
     * 
     * @return El primer elemento de la cola.
     * @throws IllegalStateException Si la cola está vacía.
     */
    public int head() {

        if (cantidad == 0) {
            throw new IllegalStateException("Cola vacía");
        }
        return head;
    }

    /**
     * Devuelve la posición donde se agregará el próximo elemento.
     * 
     * @return La posición de tail.
     */
    public int tail() {

        return tail;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {

        return cantidad == 0;
    }

    /**
     * Devuelve la cantidad de elementos que tiene actualmente la cola.
     * 
     * @return La cantidad de elementos en la cola.
     */
    public int size() {

        return cantidad;
    }

    /**
     * Devuelve la capacidad máxima de la cola.
     * 
     * @return La capacidad de la cola.
     */
    @Override
    public String toString() {

        if (cantidad == 0) {
            return "[]";
        }

        String resultado = "[";

        // Comenzamos a recorrer desde head
        int posicion = head;

        // Recorremos solamente la cantidad de elementos existentes
        for (int i = 0; i < cantidad; i++) {

            resultado += elementos[posicion];

            if (i < cantidad - 1) {
                resultado += ", ";
            }

            // Avanzamos de forma circular
            posicion = (posicion + 1) % elementos.length;
        }

        resultado += "]";

        return resultado;
    }
}
