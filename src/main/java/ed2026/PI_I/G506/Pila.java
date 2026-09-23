package ed2026.PI_I.G506;

public class Pila {
    private NodoCarta cima;

    public Pila() {
        this.cima = null;
    }

    public void apilar(Carta c) {
        NodoCarta nuevo = new NodoCarta(c);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public Carta desapilar() {
        if (estaVacia())
            return null;
        Carta c = cima.carta;
        cima = cima.siguiente;
        return c;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}