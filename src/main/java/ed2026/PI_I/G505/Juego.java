
package ed2026.PI_I.G505;

// import ar.edu.unju.fi.ed.tda.Cola;
// import ar.edu.unju.fi.ed.tda.ColaDinamica;

public class Juego {

    private Jugador[] jugadores;
    private Mazo mazo;
    private Cola<Carta> cartasPorRepartir;

    public Juego(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.mazo = new Mazo();
        this.cartasPorRepartir = new ColaDinamica<>();

        Carta[] cartas = mazo.getCartas();

        for (Carta carta : cartas) {
            cartasPorRepartir.encolar(carta);
        }
    }

    public void jugarRondas(int rondas) {
        for (int r = 1; r <= rondas; r++) {

            if (cartasPorRepartir.cantidadDeElementos() < jugadores.length) {
                System.out.println("No hay cartas suficientes para otra ronda.");
                break;
            }

            System.out.println("Ronda " + r);

            Carta[] cartasRonda = new Carta[jugadores.length];
            int maxValor = 0;

            for (int i = 0; i < jugadores.length; i++) {
                cartasRonda[i] = cartasPorRepartir.desencolar();
                cartasRonda[i].setEstadoCarta(EstadoCarta.NO_DISPONIBLE);

                System.out.println(jugadores[i] + " recibe " + cartasRonda[i]);

                if (cartasRonda[i].getValor() > maxValor) {
                    maxValor = cartasRonda[i].getValor();
                }
            }

            int ganadores = 0;

            for (Carta c : cartasRonda) {
                if (c.getValor() == maxValor) {
                    ganadores++;
                }
            }

            if (ganadores > 1) {
                System.out.println("Empate, cada jugador conserva su carta.");

                for (int i = 0; i < jugadores.length; i++) {
                    if (cartasRonda[i].getValor() == maxValor) {
                        jugadores[i].ganarCarta(cartasRonda[i]);
                    }
                }
            } else {
                for (int i = 0; i < jugadores.length; i++) {
                    if (cartasRonda[i].getValor() == maxValor) {
                        System.out.println(jugadores[i] + " gana la ronda y se lleva todas las cartas.");

                        for (Carta c : cartasRonda) {
                            jugadores[i].ganarCarta(c);
                        }
                    }
                }
            }
        }
    }

    public void mostrarResultados() {
        System.out.println("Resultados Finales");

        int[] puntajes = new int[jugadores.length];
        int maxPuntaje = 0;

        for (int i = 0; i < jugadores.length; i++) {
            puntajes[i] = jugadores[i].calcularPuntaje();

            System.out.println(jugadores[i] + " puntaje: " + puntajes[i]);

            if (puntajes[i] > maxPuntaje) {
                maxPuntaje = puntajes[i];
            }
        }

        System.out.println("Ganador/es:");

        for (int i = 0; i < jugadores.length; i++) {
            if (puntajes[i] == maxPuntaje) {
                System.out.println(jugadores[i]);
            }
        }
    }
}
