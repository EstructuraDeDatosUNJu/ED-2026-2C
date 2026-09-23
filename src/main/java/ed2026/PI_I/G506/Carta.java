package ed2026.PI_I.G506;

public class Carta {
    private String palo;
    private int valor; // 1 a 13

    public Carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}