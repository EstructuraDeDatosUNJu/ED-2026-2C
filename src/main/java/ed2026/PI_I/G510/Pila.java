package ed2026.PI_I.G510;

// Clase auxiliar Nodo para la estructura enlazada
class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// TDA Pila (LIFO - Last In, First Out)
public class Pila<T> {
    private Nodo<T> cima;
    private int tamanio;

    // Constructor
    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    // Metodo para verificar si la pila está vacía
    public boolean esVacia() {
        return cima == null;
    }

    // Metodo para apilar (agregar un elemento arriba)
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    // Metodo para desapilar (quitar y retornar el elemento de arriba)
    public T desapilar() {
        if (esVacia()) {
            return null;
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        tamanio--;
        return dato;
    }

    // Metodo para ver el elemento de la cima sin sacarlo
    public T verCima() {
        if (esVacia()) {
            return null;
        }
        return cima.dato;
    }

    // Metodo para obtener el tamaño de la pila
    public int getTamanio() {
        return tamanio;
    }
}