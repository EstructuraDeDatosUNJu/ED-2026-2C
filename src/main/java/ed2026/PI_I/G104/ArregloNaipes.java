package ed2026.PI_I.G104;

public class ArregloNaipes {
    private Naipe[] cartas;

    public ArregloNaipes() {
        cartas = new Naipe[52];
        String[] palos = { "trébol", "pica", "corazón", "diamante" };
        int index = 0;

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas[index++] = new Naipe(palo, valor);
            }
        }
    }

    public Naipe[] getCartas() {
        return cartas;
    }
}