package ed2026.PI_I.G509;

public class PilaPropia<T> {
    private Object[] elementos;
    private int tope;
    private int capacidad;

    public PilaPropia(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    //push 
    public void apilar(T elemento) {
        if (estaLlena()) {
            throw new RuntimeException("Error: La pila está llena.");
        }
        elementos[++tope] = elemento;
    }

    //pop
    @SuppressWarnings("unchecked")
    public T desapilar() {
        if (estaVacia()) {
            throw new RuntimeException("Error: La pila está vacía.");
        }
        return (T) elementos[tope--];
    }

    public int cantidadElementos() {
        return tope + 1;
    }
}
