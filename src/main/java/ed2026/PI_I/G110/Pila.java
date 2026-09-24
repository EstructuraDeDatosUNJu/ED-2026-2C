package ed2026.PI_I.G110;

// TDA Pila (LIFO) implementado con arreglo propio.
// Se usa para representar el mazo: repartir una carta = desapilar (tomar de arriba).
public class Pila {
    private Naipes[] elementos;
    private int tope; // indice del proximo lugar libre

    public Pila(int capacidad) {
        elementos = new Naipes[capacidad];
        tope = 0;
    }

    public boolean estaVacia() {
        return tope == 0;
    }

    public boolean estaLlena() {
        return tope == elementos.length;
    }

    public void apilar(Naipes naipe) {
        if (estaLlena()) {
            System.out.println("La pila esta llena, no se puede apilar.");
            return;
        }
        elementos[tope] = naipe;
        tope++;
    }

    public Naipes desapilar() {
        if (estaVacia()) {
            System.out.println("La pila esta vacia, no se puede desapilar.");
            return null;
        }
        tope--;
        Naipes naipe = elementos[tope];
        elementos[tope] = null;
        return naipe;
    }

    public Naipes verTope() {
        if (estaVacia()) {
            return null;
        }
        return elementos[tope - 1];
    }

    public int cantidad() {
        return tope;
    }
}
