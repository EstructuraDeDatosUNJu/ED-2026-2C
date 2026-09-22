package ed2026.PI_I.G108;

// Entidad
public class Carta {
    //Atributos
    private String palo;
    private int valor;
    private boolean disponible;

    //Constructor
    public Carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = true;
    }

    //Getters y Setters
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

    //ToString
    @Override
    public String toString() {
        String[] nombresValores = { "", "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String nombreValor = (valor >= 1 && valor <= 13) ? nombresValores[valor] : String.valueOf(valor);
        return nombreValor + " de " + palo;
    }
}
