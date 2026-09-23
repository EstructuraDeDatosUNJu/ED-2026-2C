package ed2026.PI_I.G504;

public class pilaCartas {
    private carta[] element;
    private int ultima;

    public pilaCartas(int capacidad) {
        element = new carta[capacidad];
        ultima = -1;
    }

    public boolean estaVacia() {
        return ultima == -1;
    }

    public boolean estaLlena() {
        return ultima == element.length - 1;
    }

    public void meterCarta(carta carta) {
        if (!estaLlena()) {
            ultima++;
            element[ultima] = carta;
        }
    }

    public carta sacarCarta() {
        if (!estaVacia()) {
            carta c = element[ultima];
            element[ultima] = null;
            ultima--;
            return c;
        }
        return null;
    }
}
