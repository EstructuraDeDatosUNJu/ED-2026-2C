package ed2026.PI_I.G506;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private Cola cartasGanadas;

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cartasGanadas = new Cola();
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void ganarCarta(Carta c) {
        cartasGanadas.encolar(c);
    }

    public int calcularPuntajeFinal() {
        int puntaje = 0;
        while (!cartasGanadas.estaVacia()) {
            Carta c = cartasGanadas.desencolar();
            puntaje += c.getValor();
        }
        return puntaje;
    }
}