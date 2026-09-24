package ed2026.PI_I.G110;

// TDA Cola (FIFO) implementado con arreglo circular propio.
// Se usa para el orden de turnos: los jugadores se encolan y desencolan
// en el mismo orden en el que van a sacar carta en cada ronda.
public class Cola {
    private Jugador[] elementos;
    private int frente;
    private int fin;
    private int cantidad;

    public Cola(int capacidad) {
        elementos = new Jugador[capacidad];
        frente = 0;
        fin = 0;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == elementos.length;
    }

    public void encolar(Jugador jugador) {
        if (estaLlena()) {
            System.out.println("La cola esta llena, no se puede encolar.");
            return;
        }
        elementos[fin] = jugador;
        fin = (fin + 1) % elementos.length;
        cantidad++;
    }

    public Jugador desencolar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia, no se puede desencolar.");
            return null;
        }
        Jugador jugador = elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % elementos.length;
        cantidad--;
        return jugador;
    }

    public int cantidad() {
        return cantidad;
    }
}
