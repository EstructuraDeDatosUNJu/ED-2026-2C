package ed2026.PI_I.G102;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamanio;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    public Cola() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (esVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamanio++;
    }

    public T desencolar() {
        if (esVacia())
            return null;
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null)
            fin = null;
        tamanio--;
        return dato;
    }

    public boolean esVacia() {
        return frente == null;
    }

    public int getTamanio() {
        return tamanio;
    }
}
