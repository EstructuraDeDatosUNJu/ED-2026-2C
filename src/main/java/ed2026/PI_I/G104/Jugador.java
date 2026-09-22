package ed2026.PI_I.G104;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private PilaNaipe cartasGanadas; // <-- TDA Pila Propia

    //CONSTRUCTORES
    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        // Capacidad de 52 por si un jugador gana absolutamente todas las cartas
        this.cartasGanadas = new PilaNaipe(52);
    }

    public Jugador(String nombre) {
        this(nombre, "Sin Apellido", 18);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void agregarCartaGanada(Naipe carta) {
        // Agrega carta a pila de jugador ganador al final de cada ronda.
        if (carta != null) {
            this.cartasGanadas.push(carta);
        }
    }

    public void reiniciarCartas() {
        //Borra el contenido de la pila de cartas ganadas.
        this.cartasGanadas.clear();
    }

    public int getPuntaje() {
        //Obtiene el puntaje total del jugador.
        int total = 0;
        for (int i = 0; i < cartasGanadas.getTamanio(); i++) {
            Naipe n = cartasGanadas.get(i);
            if (n != null) {
                total += n.getValor();
            }
        }
        return total;
    }
}