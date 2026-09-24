package ed2026.PI_I.G509;

import java.util.List;
import java.util.ArrayList;

public class Jugador {

    private String nombreApellido;
    private int edad;
    private List<Carta> cartasJugador;
    private Carta cartaActual;

    public Jugador(String nombreApellido, int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad del jugador no puede ser cero o negativa.");
        }
        this.nombreApellido = nombreApellido;
        this.edad = edad;
        this.cartasJugador = new ArrayList<>();
        this.cartaActual = null;
    }

    public void agregarCarta(Carta carta) {
        cartasJugador.add(carta);
    }

    public int calcularPuntaje() {
        int puntajeTotal = 0;
        for (Carta carta : cartasJugador) {
            puntajeTotal = puntajeTotal + carta.getValor();
        }
        return puntajeTotal;
    }

    public List<Carta> getCartasJugador() {
        return cartasJugador;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setCartaActual(Carta carta) {
        this.cartaActual = carta;
    }

    public Carta getCartaActual() {
        return cartaActual;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombreApellido + " | Edad: " + edad + " | Cartas ganadas: " + cartasJugador;
    }
}
