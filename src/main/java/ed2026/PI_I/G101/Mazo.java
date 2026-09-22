package ed2026.PI_I.G101;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que representa un mazo de cartas de juego.
 */
public class Mazo {
    private Queue<Carta> mazoCartas;

    /**
     * Constructor de la clase Mazo. Inicializa el mazo de cartas generando un
     * mazo aleatorio.
     */
    public Mazo() {
        this.mazoCartas = new Queue<>(52);
        this.mazoCartas = generarMazo();
    }

    /**
     * Genera un arreglo de cartas de juego con todos los palos y valores posibles.
     * 
     * @return Un arreglo de objetos Carta que representa un mazo completo de
     *         cartas.
     */
    private Carta[] generarCartas() {
        Carta[] cartas = new Carta[52];

        String[] palos = { "Trebol", "Corazon", "Diamante", "Pica" };
        int index = 0;

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; ++valor) {
                cartas[index] = new Carta(palo, valor, true);
                index++;
            }
        }
        return cartas;
    }

    /**
     * Genera un mazo de cartas aleatorio sin repeticiones.
     * 
     * @return Un arreglo de objetos Carta que representa un mazo de cartas
     *         aleatorio.
     */
    private Carta[] generarMazoAleatorio() {
        Carta[] cartas = generarCartas();
        Carta[] mazoCartas = new Carta[cartas.length];
        int posicion = 0;

        while (posicion < mazoCartas.length) {
            Carta cartaGenerada = cartas[generarIndiceAleatorio()];

            if (!cartaRepetida(mazoCartas, cartaGenerada)) {
                mazoCartas[posicion] = cartaGenerada;
                posicion++;
            }
        }

        return mazoCartas;
    }

    /**
     * Genera un índice aleatorio para seleccionar una carta del mazo.
     * 
     * @return Un número entero aleatorio entre 0 y 51 (inclusive).
     */
    private int generarIndiceAleatorio() {
        return ThreadLocalRandom.current().nextInt(52);
    }

    /**
     * Verifica si una carta generada ya está presente en el mazo.
     * 
     * @param mazo          El arreglo de cartas que representa el mazo.
     * @param cartaGenerada La carta que se desea verificar.
     * @return true si la carta ya está en el mazo, false en caso contrario.
     */
    private boolean cartaRepetida(Carta[] mazo, Carta cartaGenerada) {
        if (mazo.length == 0) {
            return false;
        } else {
            for (Carta carta : mazo) {
                if (carta != null && carta.getPalo().equals(cartaGenerada.getPalo())
                        && carta.getValor() == cartaGenerada.getValor()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Genera un mazo de cartas aleatorio y lo almacena en una cola.
     * 
     * @return Una cola que contiene las cartas del mazo en orden aleatorio.
     */
    private Queue<Carta> generarMazo() {
        Carta[] mazoAleatorio = generarMazoAleatorio();
        Queue<Carta> mazo = new Queue<>(mazoAleatorio.length);

        for (Carta carta : mazoAleatorio) {
            mazo.offer(carta);
        }

        return mazo;
    }

    /**
     * Extrae una carta del mazo, marcándola como no disponible.
     * 
     * @return La carta extraída del mazo.
     * @throws IllegalStateException Si no hay más cartas en el mazo.
     */
    public Carta extraerCarta() {
        if (this.mazoCartas.isEmpty()) {
            throw new IllegalStateException("No hay más cartas en el mazo.");
        }
        Carta cartaExtraida = this.mazoCartas.remove();
        cartaExtraida.setDisponible(false);
        return cartaExtraida;
    }

    public int size() {
        return mazoCartas.size();
    }

}