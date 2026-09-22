package ed2026.PI_I.G105;

import java.util.Random;

public class Mazo {
    private Pila cartas;

    public Mazo() {
        this.cartas = generarMazoMezclado();
    }

    private Pila generarMazoMezclado() {
        Carta[] arregloCartas = new Carta[52];
        String[] palos = { "Trébol", "Pica", "Corazón", "Diamante" };
        int indice = 0;

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                arregloCartas[indice] = new Carta(palo, valor);
                indice++;
            }
        }

        Random random = new Random();
        for (int i = arregloCartas.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Carta temporal = arregloCartas[i];
            arregloCartas[i] = arregloCartas[j];
            arregloCartas[j] = temporal;
        }

        Pila pilaMazo = new Pila();
        for (int i = 0; i < arregloCartas.length; i++) {
            pilaMazo.apilar(arregloCartas[i]);
        }

        return pilaMazo;
    }

    public Carta extraerCarta() {
        if (!cartas.estaVacia()) {
            Carta c = cartas.desapilar();
            c.setDisponible(false);
            return c;
        }
        return null;
    }

    public boolean estaVacio() {
        return cartas.estaVacia();
    }
}