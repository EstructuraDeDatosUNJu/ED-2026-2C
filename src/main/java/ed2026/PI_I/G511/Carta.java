package ed2026.PI_I.G511;

public class Carta {
    private String palo;
    private String valor;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public String getPalo() {
        return this.palo;
    }

    public String getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return this.valor + " de " + this.palo;
    }

}
