package ed2026.PI_I.G509;

public class Carta {

    private String palo;
    private int valor;

    public Carta(String palo, int valor) {
        if (!palo.equalsIgnoreCase("trebol") && !palo.equalsIgnoreCase("pica") && !palo.equalsIgnoreCase("corazon")
                && !palo.equalsIgnoreCase("diamante")) { // Validación del palo
            throw new IllegalArgumentException("El palo de la carta no es valido");
        }
        if (valor < 1 || valor > 13) {
            throw new IllegalArgumentException("El valor de la carta debe estar entre 1 y 13.");
        }
        this.palo = palo;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return palo + " - " + valor;
    }
}
