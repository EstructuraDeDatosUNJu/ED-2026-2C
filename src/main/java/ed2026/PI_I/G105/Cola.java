package ed2026.PI_I.G105;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public void encolar(Carta c) {
        Nodo nuevo = new Nodo(c);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tamano++;
    }

    public Carta desencolar() {
        if (estaVacia()) {
            return null;
        }
        Carta carta = frente.getDato();
        frente = frente.getSiguiente();
        tamano--;
        if (frente == null) {
            fin = null;
        }
        return carta;
    }

    public Carta frente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamano() {
        return tamano;
    }
}