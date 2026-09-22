package ed2026.PI_I.G107;

import java.util.Random;

public class Mazo {

    private Carta[] Mazo = new Carta[52];

    private StackGenerica<Carta> MazoPila = new StackGenerica<>();

    public Mazo() {
    }

    public Carta[] crearMazo() {

        String[] palos = { "trebol", "corazon", "pica", "diamante" };

        int posicion = 0;

        for (String palo : palos) {

            for (int i = 1; i <= 13; i++) {

                Mazo[posicion] = new Carta(palo, true, i);

                posicion++;
            }
        }

        return Mazo;
    }

    public void mezclarMazo() {

        Random random = new Random();

        Carta[] MazoMezclado = new Carta[52];

        boolean[] usado = new boolean[52];

        for (int i = 0; i < 52; i++) {

            int posicion = random.nextInt(52);

            while (usado[posicion]) {
                posicion = random.nextInt(52);
            }

            MazoMezclado[i] = Mazo[posicion];

            usado[posicion] = true;
        }

        Mazo = MazoMezclado;
    }

    public void conversionPilaMazo() {

        for (Carta carta : Mazo) {
            MazoPila.push(carta);
        }
    }

    public Carta sacarCarta() {

        Carta carta = MazoPila.pop();

        carta.setEstado(false);

        return carta;
    }
}