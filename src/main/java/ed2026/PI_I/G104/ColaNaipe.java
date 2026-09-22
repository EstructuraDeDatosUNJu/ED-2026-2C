package ed2026.PI_I.G104;

public class ColaNaipe {
    private final Naipe[] elementos;
    private int frente;
    private int fin;
    private int tamanio;

    //Constructor.
    public ColaNaipe(int capacidad) {
        this.elementos = new Naipe[capacidad];
        this.frente = 0;
        this.fin = 0;
        this.tamanio = 0;
    }

    //Agrega un nuevo naipe al final de la cola.
    public void encolar(Naipe carta) {
        if (tamanio == elementos.length) {
            throw new IllegalStateException("La cola está llena.");
        }

        elementos[fin] = carta;
        fin = (fin + 1) % elementos.length;
        tamanio++;
    }

    //Extrae y devuelve la carta que se encuentra al frente de la cola.
    public Naipe desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía.");
        }

        Naipe carta = elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % elementos.length;
        tamanio--;

        return carta;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public int getTamanio() {
        return tamanio;
    }
}