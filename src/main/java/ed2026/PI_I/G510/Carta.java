package ed2026.PI_I.G510;

public class Carta {

    //atributos
    private String tipoCarta; //corazones, picas, trebol, diamante
    private int valorCarta; //desde 1 hasta 13

    //contructor por defecto
    public Carta() {
        this.tipoCarta = "";
        this.valorCarta = 0;

    }

    //contructor parametrizado
    public Carta(String tipoCarta, int valorCarta, boolean cartaDisponble) {
        this.tipoCarta = tipoCarta;
        this.valorCarta = valorCarta;

    }

    //getters y setters
    public String getTipoCarta() {
        return this.tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        // Normalizamos a minusculas para evitar problemas con mayusculas/minusculas
        String tipoMinuscula = tipoCarta == null ? "" : tipoCarta.toLowerCase().trim();

        if (!tipoMinuscula.equals("corazones") &&
                !tipoMinuscula.equals("picas") &&
                !tipoMinuscula.equals("trebol") &&
                !tipoMinuscula.equals("diamante")) {
            throw new IllegalArgumentException(
                    "Tipo de carta invalido. Debe ser: corazones, picas, trebol o diamante.");
        }

        this.tipoCarta = tipoMinuscula;
    }

    public int getValorCarta() {
        return this.valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        if (valorCarta < 1 || valorCarta > 13) {
            throw new IllegalArgumentException("Valor de carta invalido. Debe estar entre 1 y 13.");
        }
        this.valorCarta = valorCarta;
    }

    // Metodo toString con formato para As, J, Q, K
    //muestra en pantalla el 1, 11, 12, 13 como As, J, Q, K pero no se modifica
    //internamente
    @Override
    public String toString() {
        String nombreValor = switch (valorCarta) {
            case 1 -> "As";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(valorCarta);
        };

        return nombreValor + " de " + tipoCarta;
    }

}