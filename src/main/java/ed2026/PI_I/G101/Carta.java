package ed2026.PI_I.G101;

/**
 * Clase que representa una carta de juego.
 */
public class Carta {
    private String palo;
    private int valor;
    private boolean disponible;

    public Carta() {
        this.palo = "";
        this.valor = 0;
        this.disponible = true;
    }

    public Carta(String palo, int valor, boolean disponible) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = disponible;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "palo='" + palo + '\'' +
                ", valor=" + valor +
                ", disponible=" + disponible +
                '}';
    }

}