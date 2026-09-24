package ed2026.PI_I.G508;

/**
 * Representa un naipe individual del mazo francés.
 */
public class Carta {
    private String palo; // Trébol, Pica, Corazones, Diamantes
    private int valor; // 1 a 13
    private boolean disponible; // true = disponible en mazo, false = entregada

    public Carta(String palo, int valor, boolean disponible) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = disponible;
    }

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
        return valor + " de " + palo + " (" + (disponible ? "Disponible" : "No disponible") + ")";
    }
}
