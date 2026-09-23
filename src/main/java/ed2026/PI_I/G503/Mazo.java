package ed2026.PI_I.G503;

import java.util.Random;

public class Mazo {
    private StackGenerica<Carta> naipes;

    public Mazo() {
        this.naipes = new StackGenerica<Carta>();
        this.crearCartas();
        this.barajar();
    }

    private void crearCartas() {
        String[] palos = { "trébol", "pica", "corazones", "diamantes" };
        Carta[] mazoAuxiliar = new Carta[52];
        int indice = 0;

        for (int i = 0; i < palos.length; i++) {
            for (int valor = 1; valor <= 13; valor++) {
                mazoAuxiliar[indice] = new Carta(palos[i], valor, true);
                indice++;
            }
        }

        for (int i = 0; i < mazoAuxiliar.length; i++) {
            this.naipes.push(mazoAuxiliar[i]);
        }
    }

    private void barajar() {
        int cantidad = this.naipes.count();
        Carta[] temp = new Carta[cantidad];
        for (int i = 0; i < cantidad; i++) {
            temp[i] = this.naipes.pop();
        }

        // CAMBIO: ahora sortea solo entre las posiciones que todavia no se mezclaron
        Random rand = new Random();
        for (int i = temp.length - 1; i > 0; i--) {
            int posicionAzar = rand.nextInt(i + 1);
            Carta auxiliar = temp[i];
            temp[i] = temp[posicionAzar];
            temp[posicionAzar] = auxiliar;
        }
        for (int i = 0; i < temp.length; i++) {
            this.naipes.push(temp[i]);
        }
    }

    // CAMBIO: la carta deja de estar disponible cuando sale del mazo
    public Carta robarCarta() {
        Carta cartaRobada = this.naipes.pop();
        cartaRobada.setEstado(false);
        return cartaRobada;
    }

    // CAMBIO: metodo nuevo
    public boolean hayCartas() {
        return !this.naipes.isEmpty();
    }

    public int cantidadCartasRestantes() {
        return this.naipes.count();
    }
}