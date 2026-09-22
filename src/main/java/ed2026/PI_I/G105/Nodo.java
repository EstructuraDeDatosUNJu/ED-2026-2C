package ed2026.PI_I.G105;

public class Nodo {
    private Carta dato;
    private Nodo siguiente;

    public Nodo(Carta dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Carta getDato() {
        return dato;
    }

    public void setDato(Carta dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}