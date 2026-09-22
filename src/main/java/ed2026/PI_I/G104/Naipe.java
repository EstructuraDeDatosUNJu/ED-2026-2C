package ed2026.PI_I.G104;

public class Naipe {
    private String palo;
    private int valor;
    private boolean disponible;

    public Naipe(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.disponible = true;
    }

    public int getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String mostrar() {
        return valor + " de " + palo;
    }

    // Convierte valores 1, 11, 12, 13 a sus iniciales correspondientes
    private String getRepresentacionValor() {
        switch (valor) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(valor);
        }
    }

    // Retorna el ícono del palo o el símbolo representativo
    private String getSimboloPalo() {
        if (palo == null)
            return "?";
        switch (palo.toLowerCase()) {
            case "trébol":
            case "trebol":
                return "♣";
            case "pica":
                return "♠";
            case "corazón":
            case "corazon":
                return "♥";
            case "diamante":
                return "♦";
            default:
                return "?";
        }
    }

    // Dibuja el naipe en consola con el formato ASCII de la captura
    public void dibujarCarta(String nombreJugador) {
        String v = getRepresentacionValor();
        String sim = getSimboloPalo();

        // Formato para alinear correctamente los valores de 2 dígitos (ej: 10)
        String valArriba = v.length() == 1 ? v + " " : v;
        String valAbajo = v.length() == 1 ? " " + v : v;

        System.out.println("+-------+   Jugador: " + nombreJugador);
        System.out.println("| " + valArriba + "    |");
        System.out.println("|   " + sim + "   |");
        System.out.println("|    " + valAbajo + " |");
        System.out.println("+-------+");
    }
}