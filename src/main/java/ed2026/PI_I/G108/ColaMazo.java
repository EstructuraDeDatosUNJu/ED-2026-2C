package ed2026.PI_I.G108;

// se utiliza TDA sobre Arreglo para implementar la cola del mazo de cartas. La cola tiene un tamaño
// máximo de 52, ya que es el tamaño total del mazo.
public class ColaMazo {
    //Atributos
    private Carta[] elementos;
    private int frente;
    private int fin;
    private int cantidad;
    private static final int CAPACIDAD_MAXIMA = 52; // Tamaño total del mazo
    //Constructor

    public ColaMazo() {
        this.elementos = new Carta[CAPACIDAD_MAXIMA];
        this.frente = 0;
        this.fin = 0;
        this.cantidad = 0;
    }

    //Metodos
    public boolean esVacia() {
        return cantidad == 0;
    }

    public boolean esLlena() {
        return cantidad == CAPACIDAD_MAXIMA;
    }

    public void encolar(Carta carta) {
        if (esLlena()) {
            System.out.println("Error: La cola del mazo está llena.");
            return;
        }
        elementos[fin] = carta;
        fin = (fin + 1) % CAPACIDAD_MAXIMA; // Avance circular
        cantidad++;
    }

    public Carta desencolar() {
        if (esVacia()) {
            return null;
        }
        Carta carta = elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % CAPACIDAD_MAXIMA; // Avance circular
        cantidad--;
        return carta;
    }

    public int getCantidad() {
        return cantidad;
    }
}
