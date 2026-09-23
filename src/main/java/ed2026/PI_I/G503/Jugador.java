
package ed2026.PI_I.G503;

public class Jugador {

    private String nombre;
    private String apellido;
    private int edad;
    private StackGenerica<Carta> cartasGanadas;

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cartasGanadas = new StackGenerica<Carta>();
    }

    public void ganarCarta(Carta carta) {
        this.cartasGanadas.push(carta);
    }

    // CAMBIO: usa una pila auxiliar para sumar sin vaciar la pila de cartas ganadas
    public int puntajeTotal() {
        int puntajeTotal = 0;
        StackGenerica<Carta> auxiliar = new StackGenerica<Carta>();

        while (!this.cartasGanadas.isEmpty()) {
            Carta cartaExtraida = this.cartasGanadas.pop();
            puntajeTotal += cartaExtraida.getValor();
            auxiliar.push(cartaExtraida);
        }

        while (!auxiliar.isEmpty()) {
            this.cartasGanadas.push(auxiliar.pop());
        }

        return puntajeTotal;
    }

    // CAMBIO: metodo nuevo
    public int cantidadCartasGanadas() {
        return this.cartasGanadas.count();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
}
