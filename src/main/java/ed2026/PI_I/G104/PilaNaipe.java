package ed2026.PI_I.G104;

public class PilaNaipe {
    private Naipe[] elementos;
    private int tope;

    public PilaNaipe(int capacidad) {
        this.elementos = new Naipe[capacidad];
        this.tope = -1;
    }

    public void push(Naipe carta) {
        if (!estaLlena()) {
            tope++;
            elementos[tope] = carta;
        }
    }

    public Naipe pop() {
        if (!estaVacia()) {
            Naipe carta = elementos[tope];
            elementos[tope] = null;
            tope--;
            return carta;
        }
        return null;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == elementos.length - 1;
    }

    public void clear() {
        while (!estaVacia()) {
            pop();
        }
    }

    public int getTamanio() {
        return tope + 1;
    }

    // Permite obtener un elemento por índice para calcular puntaje sin destruir la pila
    public Naipe get(int i) {
        if (i >= 0 && i <= tope) {
            return elementos[i];
        }
        return null;
    }
}