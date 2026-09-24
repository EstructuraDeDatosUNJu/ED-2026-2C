package ed2026.PI_I.G510;

public class Jugador {
    //atributos
    private String nombre;
    private String apellido;
    private int edad;
    private int puntaje;
    private Pila<Carta> cartasGanadas;

    // constructor predeterminado
    public Jugador() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.puntaje = 0;
        this.cartasGanadas = new Pila<Carta>(); // Inicializa la pila vacia
    }

    // constructor parametrizado
    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puntaje = 0;
        this.cartasGanadas = new Pila<>();
    }

    // metodos setter y getter (nombre)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    // metodo setter y getter (apellido)
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    // metodo setter y getter (edad)
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }

    //solo getter (puntaje), porque si ponemos setter el puntaje se puede modificar desde afuera de la clase
    public int getPuntaje() {
        return this.puntaje;
    }

    // solo getter(cartas ganadas)
    public Pila<Carta> getCartasGanadas() {
        return this.cartasGanadas;
    }

    //metodo turno de jugador
    public Carta jugadorTurno(Pila<Carta> mazo) {
        if (mazo.esVacia() == false) {
            // saca la carta superior del mazo
            Carta cartaObtenida = mazo.desapilar();
            System.out.println(this.nombre + " " + this.apellido + " ah sacado: " + cartaObtenida);
            return cartaObtenida;
        } else {
            System.out.println("no hay cartas disponibles en el mazo");
            return null;
        }
    }

    // metodo mostrar cartas ganadas
    public void mostrarCartasGanadas() {
        System.out.println(" cartas ganadas por " + this.nombre + " " + this.apellido + ":");
        Pila<Carta> auxiliar = new Pila<Carta>();
        while (this.cartasGanadas.esVacia() == false) {
            Carta carta = this.cartasGanadas.desapilar();
            System.out.println("..." + carta);
            auxiliar.apilar(carta);
        }
        while (auxiliar.esVacia() == false) {
            this.cartasGanadas.apilar(auxiliar.desapilar());

        }
    }

    // agregar cartas ganadas
    public void agregarCartaGanada(Carta carta) {
        this.cartasGanadas.apilar(carta);
        this.puntaje = this.puntaje + carta.getValorCarta();
    }

    // metodo para mostrar el nombre  completo
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    public void reiniciarPuntaje() {
        this.puntaje = 0;
        this.cartasGanadas = new Pila<Carta>(); // Reinicia la pila de cartas ganadas
    }

    @Override
    public String toString() {
        return getNombreCompleto() + "(Puntaje: " + this.puntaje + ")";
    }

}