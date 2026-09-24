package ed2026.PI_I.G110;

import java.util.Random;

// Genera las 52 cartas (4 palos x 13 valores), las mezcla y las carga en una Pila propia.
public class Mazo {
    private Pila pila;
    private static final String[] PALOS = { "Trebol", "Corazon", "Pica", "Diamante" };
    private static final int VALOR_MAXIMO = 13;

    public Mazo() {
        Naipes[] naipes = generarNaipes();
        mezclar(naipes);
        pila = new Pila(naipes.length);
        for (int i = 0; i < naipes.length; i++) {
            pila.apilar(naipes[i]);
        }
    }

    private Naipes[] generarNaipes() {
        Naipes[] naipes = new Naipes[PALOS.length * VALOR_MAXIMO];
        int indice = 0;
        for (int i = 0; i < PALOS.length; i++) {
            for (int valor = 1; valor <= VALOR_MAXIMO; valor++) {
                naipes[indice] = new Naipes(PALOS[i], valor);
                indice++;
            }
        }
        return naipes;
    }

    // Metodo de mezcla (Fisher-Yates), manual, sin usar colecciones de java.util
    private void mezclar(Naipes[] naipes) {
        Random random = new Random();
        for (int i = naipes.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Naipes temp = naipes[i];
            naipes[i] = naipes[j];
            naipes[j] = temp;
        }
    }

    public Naipes repartirCarta() {
        return pila.desapilar();
    }

    public boolean quedanCartas() {
        return !pila.estaVacia();
    }

    public int cantidadRestante() {
        return pila.cantidad();
    }
}
