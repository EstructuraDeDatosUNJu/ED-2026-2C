package ed2026.PI_I.G509;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> mazoOrdenado;
    private PilaPropia<Carta> mazoAzar;

    public Mazo() {
        this.mazoOrdenado = new ArrayList<>();
        this.mazoAzar = new PilaPropia<>(52);
        cargarMazo();
        ordenarAzar();
    }

    public List<Carta> getMazoOrdenado() {
        return mazoOrdenado;
    }

    public PilaPropia<Carta> getMazoAzar() {
        return mazoAzar;
    }

    public void cargarMazo() {

        String[] palos = { "trebol", "pica", "corazon", "diamante" };
        mazoOrdenado.clear();

        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j <= 13; j++) {
                Carta c = new Carta(palos[i], j);
                mazoOrdenado.add(c);
            }
        }
    }

    public void ordenarAzar() {

        Collections.shuffle(mazoOrdenado);

        for (int i = 0; i < mazoOrdenado.size(); i++) {
            mazoAzar.apilar(mazoOrdenado.get(i));
        }
    }

    public Carta levantarCarta() {
        if (mazoAzar.estaVacia()) {
            throw new RuntimeException("El mazo ya no tiene cartas");
        }
        return mazoAzar.desapilar();
    }

    public boolean tieneCartas() {
        return !mazoAzar.estaVacia();
    }
}
