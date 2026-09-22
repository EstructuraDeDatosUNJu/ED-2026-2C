package ed2026.PI_I.G102;

public class Pila<T> {
    private Nodo<T> cima;
    private int tamanio;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    public T desapilar() {
        if (esVacia())
            return null;
        T dato = cima.dato;
        cima = cima.siguiente;
        tamanio--;
        return dato;
    }

    public T cima() {
        return esVacia() ? null : cima.dato;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public int getTamanio() {
        return tamanio;
    }
}
