package ed2026.PI_I.G507;

public class Carta {
    private Palo palo;
    private int valor;

    public Carta(Palo palo, int valor) {
        setPalo(palo);
        setValor(valor);
    }

    public Palo getPalo() {
        return this.palo;
    }

    public void setPalo(Palo palo) {
        this.palo = validarPalo(palo);
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = validarValor(valor);
    }

    private Palo validarPalo(Palo palo) {
        if (palo == null)
            throw new IllegalArgumentException();
        return palo;
    }

    private int validarValor(int valor) {
        if (valor < 1 || valor > 13)
            throw new IllegalArgumentException("\nERROR: El valor debe estar entre 1 y 13");
        return valor;
    }

    public String toString() {
        return +valor + " de " + palo;
    }
}
