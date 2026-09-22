package ed2026.PI_I.G104;

import java.util.Random;

public class Mazo {
    private ColaNaipe colaMazo;

    //Constructor.
    public Mazo(ArregloNaipes arregloNaipes) {
        Naipe[] cartas = arregloNaipes.getCartas();
        this.colaMazo = new ColaNaipe(cartas.length);
        armarMazo(cartas);
    }

    //Método que barajea las cartas e inserta cada una en la cola.
    private void armarMazo(Naipe[] cartas) {
        Random rand = new Random();

        for (int i = cartas.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Naipe temporal = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temporal;
        }

        for (Naipe carta : cartas) {
            colaMazo.encolar(carta);
        }
    }

    //Extrae y devuelve la carta que está al frente del mazo.
    public Naipe sacarCarta() {
        return colaMazo.desencolar();
    }

    //Verifica si aún quedan cartas disponibles.
    public boolean hayCartas() {
        return !colaMazo.estaVacia();
    }
}