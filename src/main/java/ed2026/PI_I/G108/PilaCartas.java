package ed2026.PI_I.G108;

// Se usa TDA sobre Arreglo para implementar la pila de cartas jugadas en la mesa durante una ronda.
// La pila tiene un tamaño máximo de 4, ya que solo se permiten 4 jugadores en la partida.
public class PilaCartas {
    //Atributos
    private Carta[] elementos;
    private int tope;
    private static final int CAPACIDAD_MAXIMA = 4; // Máximo de cartas jugadas por ronda (4 jugadores)

    public PilaCartas() {
        this.elementos = new Carta[CAPACIDAD_MAXIMA];
        this.tope = -1;
    }

    public boolean esVacia() {
        return tope == -1;
    }

    public boolean esLlena() {
        return tope == CAPACIDAD_MAXIMA - 1;
    }

    public void apilar(Carta carta) {
        if (esLlena()) {
            System.out.println("Error: La mesa de la ronda está llena.");
            return;
        }
        tope++;
        elementos[tope] = carta;
    }

    public Carta desapilar() {
        if (esVacia()) {
            return null;
        }
        Carta carta = elementos[tope];
        elementos[tope] = null;
        tope--;
        return carta;
    }
}
