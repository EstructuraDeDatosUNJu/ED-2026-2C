package ed2026.PI_I.G102;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private int puntaje;
    private Cola<Carta> cartasGanadas; // Cola propia

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puntaje = 0;
        this.cartasGanadas = new Cola<>();
    }

    public void agregarCartaGanada(Carta c) {
        cartasGanadas.encolar(c);
        puntaje += c.getValor();
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (Edad: " + edad + ") - Puntaje: " + puntaje;
    }
}
