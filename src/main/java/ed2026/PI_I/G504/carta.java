package ed2026.PI_I.G504;

public class carta {
    private String palo;
    private int valor;
    private boolean disponible;

    public carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = true;
    }

    //region setter y getters//
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
