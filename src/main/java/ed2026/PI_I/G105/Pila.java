package ed2026.PI_I.G105;

public class Pila {
    private Nodo tope;
    private int tamano;

    public Pila() {
        this.tope = null;
        this.tamano = 0;
    }

    public void apilar(Carta c) {
        Nodo nuevo = new Nodo(c);
        nuevo.setSiguiente(tope);
        tope = nuevo;
        tamano++;
    }

    public Carta desapilar() {
        if (!estaVacia()) {
            Carta carta = tope.getDato();
            tope = tope.getSiguiente();
            tamano--;
            return carta;
        }
        return null;
    }

    public Carta tope() {
        if (!estaVacia()) {
            return tope.getDato();
        }
        return null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int tamano() {
        return tamano;
    }
}