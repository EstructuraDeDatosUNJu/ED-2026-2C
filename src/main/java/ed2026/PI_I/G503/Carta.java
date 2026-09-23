package ed2026.PI_I.G503;

public class Carta {

    private String palo;
    private int valor;
    private boolean estado;

    public Carta(String palo, int valor, boolean estado) {
        this.palo = palo;
        this.valor = valor;
        this.estado = estado;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }

}
