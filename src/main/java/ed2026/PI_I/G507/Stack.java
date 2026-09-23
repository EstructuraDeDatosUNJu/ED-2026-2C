package ed2026.PI_I.G507;

import java.util.EmptyStackException;

public class Stack<E> {
    private Object[] stack;
    private int count;

    // Constructor por defecto: crea una pila con capacidad inicial de 5
    public Stack() {
        this(5);
    }

    // Constructor con capacidad inicial indicada
    public Stack(int size) {
        this.stack = new Object[size];
        this.count = 0;
    }

    // Agrega un elemento en la cima de la pila (si no hay espacio, la agranda)
    public E push(E item) {
        if (count == stack.length)
            resize();
        stack[count] = item;
        count++;
        return item;
    }

    // Quita y devuelve el elemento de la cima. Lanza excepción si está vacía
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        count--;
        E item = (E) stack[count];
        stack[count] = null;
        return item;
    }

    // Devuelve el elemento de la cima sin quitarlo. Lanza excepción si está vacía
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return (E) stack[count - 1];
    }

    // Busca un objeto y devuelve su distancia desde la cima (1 = cima), o -1 si no está
    public int search(Object o) {
        if (isEmpty())
            throw new EmptyStackException();

        int index = lastIndexOf(o);

        if (index >= 0)
            return count - index;
        return -1;
    }

    // Busca desde la cima hacia la base y devuelve la posición (0-based) del objeto
    private int lastIndexOf(Object o) {
        return lastIndexOf(o, count - 1);
    }

    // Recorre el arreglo interno desde "index" hacia abajo buscando el objeto
    private int lastIndexOf(Object o, int index) {
        if (index >= count)
            throw new IndexOutOfBoundsException();

        if (o == null) {
            for (int i = index; i >= 0; i--)
                if (stack[i] == null)
                    return i;
        } else {
            for (int i = index; i >= 0; i--)
                if (o.equals(stack[i]))
                    return i;
        }

        return -1;
    }

    // Devuelve la cantidad de elementos actuales en la pila
    public int size() {
        return count;
    }

    // Indica si la pila no tiene elementos
    public boolean isEmpty() {
        return count == 0;
    }

    // Agranda el arreglo interno cuando se llena (crece de a 1 lugar)
    private void resize() {
        Object[] newStack = new Object[count + 1];

        for (int i = 0; i < stack.length; i++)
            newStack[i] = stack[i];
        stack = newStack;
    }

    public Object[] toArray() {
        Object[] copia = new Object[count];

        for (int i = 0; i < count; i++) {
            copia[i] = stack[i];
        }

        return copia;
    }

    // Muestra la pila de cima a base sin modificarla (solo lectura del arreglo interno)
    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = count - 1; i >= 0; i--) {
            sb.append(stack[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
