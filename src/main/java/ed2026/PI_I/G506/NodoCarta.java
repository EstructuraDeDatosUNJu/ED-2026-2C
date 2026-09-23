package ed2026.PI_I.G506;

public class NodoCarta {
    Carta carta;
    NodoCarta siguiente;

    public NodoCarta(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }
}