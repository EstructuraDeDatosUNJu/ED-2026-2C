package ed2026.PI_I.G505;

import java.util.Random;

public class Mazo {

    private Carta[] cartas;
    private static final int CANTIDAD_CARTAS = 52;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 13;

    public Mazo() {
        cartas = new Carta[CANTIDAD_CARTAS];
        construir();
        barajar();
    }

    private void construir() {
        PaloCarta[] palos = PaloCarta.values();
        int indice = 0;
        for (PaloCarta palo : palos) {
            for (int valor = VALOR_MINIMO; valor <= VALOR_MAXIMO; valor++) {
                cartas[indice] = new Carta(palo, valor, EstadoCarta.DISPONIBLE);
                indice++;
            }
        }
    }

    private void barajar() {
        Random rnd = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public int getCantidadCartas() {
        return cartas.length;
    }

    public void imprimir() {
        for (Carta c : cartas) {
            System.out.println(c.getValor() + " de " + c.getPalo() + " - " + c.getEstadoCarta());
        }
    }
}