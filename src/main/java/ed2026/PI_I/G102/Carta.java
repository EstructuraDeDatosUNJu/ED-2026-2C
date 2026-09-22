package ed2026.PI_I.G102;

public class Carta {
    private String palo; // "Trebol", "Corazón", "Diamante", "Pica"
    private int valor; // 1 a 13
    private boolean disponible;

    public Carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = true;
    }

    // Getters y Setters
    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
