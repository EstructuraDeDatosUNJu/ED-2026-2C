package ed2026.PI_I.G511;

import java.util.Arrays;
import java.util.Collections;

public class Mazo {

    private StackTDA<Carta> mazo;
    private static final int TAMANO_MAZO = 52;

    public Mazo() {
        this.mazo = new StackTDA<>(TAMANO_MAZO);
        this.inicializarMazo();
    }

    private void inicializarMazo() {
        String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        Carta[] aux = new Carta[palos.length * valores.length];
        int indice = 0;

        for (String palo : palos) {
            for (String valor : valores) {
                Carta carta = new Carta(palo, valor);
                aux[indice] = carta;
                indice++;
            }
        }
        Collections.shuffle(Arrays.asList(aux));
        for (Carta carta : aux) {
            this.mazo.push(carta);
        }
        System.out.println(this.toString());
        System.out.println("Mazo inicializado y mezclado.");
    }

    public Carta robarCarta() {
        if (this.mazo.isEmpty()) {
            throw new RuntimeException("No hay más cartas en el mazo.");
        }
        return this.mazo.pop();
    }

    @Override
    public String toString() {
        Carta[] cartas = new Carta[this.mazo.count()];
        StringBuilder resultado = new StringBuilder("Mazo:\n");

        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = this.mazo.pop();
        }

        for (int i = cartas.length - 1; i >= 0; i--) {
            resultado.append(cartas[i]).append("\n");
        }

        for (int i = cartas.length - 1; i >= 0; i--) {
            this.mazo.push(cartas[i]);
        }

        return resultado.toString();
    }

}
