package ed2026.PI_I.G110;

// Representa una carta del mazo: palo, valor (1 a 13) y estado (disponible o no)
public class Naipes {
    private String palo;
    private int valor;
    private boolean disponible;

    public Naipes(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = true; // por defecto esta disponible
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
    // palo y valor no tienen setters: la identidad de una carta no cambia una vez creada

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
