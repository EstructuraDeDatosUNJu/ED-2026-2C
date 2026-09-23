package ed2026.PI_I.G506;

public class Cola {
    private NodoCarta frente;
    private NodoCarta fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Carta c) {
        NodoCarta nuevo = new NodoCarta(c);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
    }

    public Carta desencolar() {
        if (estaVacia())
            return null;
        Carta c = frente.carta;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return c;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}