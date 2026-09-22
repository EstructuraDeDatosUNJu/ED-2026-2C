package ed2026.PI_I.G107;

public class Carta {

    private String palo = "";
    private boolean estado;
    private int valor;

    public Carta() {
    }

    public Carta(String palo, boolean estado, int valor) {
        this.palo = palo;
        this.estado = estado;
        this.valor = valor;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public boolean getEstado() {
        return estado;
    }
}