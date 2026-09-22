package ed2026.PI_I.G101;

/**
 * Clase que representa a un jugador en el juego de cartas.
 */
public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private int puntaje;
    private Carta cartaEnMano;
    private MiStack cartasAcumuladas;

    // Constructor vacío
    public Jugador() {
        this.puntaje = 0;
    }

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puntaje = 0;
        this.cartasAcumuladas = new MiStack(52);
    }

    // --- GETTERS Y SETTERS (para manipular la info desde el Main u otras clases) ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    public Carta getCartaEnMano() {
        return cartaEnMano;
    }

    public void setCartaEnMano(Carta cartaEnMano) {
        this.cartaEnMano = cartaEnMano;
    }

    public MiStack getCartasAcumuladas() {
        return cartasAcumuladas;
    }

    public void setCartasAcumuladas(MiStack cartasAcumuladas) {
        this.cartasAcumuladas = cartasAcumuladas;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " " + apellido + " (Edad: " + edad + " años) - Puntaje actual: " + puntaje;
    }

    /**
     * Suma el puntaje del jugador basado en las cartas acumuladas y actualiza su puntaje total.
     * 
     * @return El puntaje total del jugador después de sumar las cartas acumuladas.
     */
    public int sumarPuntaje() {
        int total = 0;
        while (!this.cartasAcumuladas.isEmpty()) {
            Carta carta = this.cartasAcumuladas.pop();
            total += carta.getValor();
        }
        this.puntaje = total;
        return total;
    }

    /**
     * Acumula una carta en la pila de cartas acumuladas del jugador.
     * 
     * @param carta La carta que se desea acumular.
     */
    public void acumularCarta(Carta carta) {
        this.cartasAcumuladas.push(carta);
    }
}
