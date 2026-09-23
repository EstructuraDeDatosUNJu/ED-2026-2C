package ed2026.PI_I.G504;

public class colaCartas {
    private carta[] element;
    private int frente;
    private int fin;
    private int cantidad;

    public colaCartas(int capacidad) {
        element = new carta[capacidad];
        frente = 0;
        fin = -1;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == element.length;
    }

    public void meterCarta(carta carta) {
        if (!estaLlena()) {
            fin = (fin + 1) % element.length;
            element[fin] = carta;
            cantidad++;
        }
    }

    public carta sacarCarta() {
        if (!estaVacia()) {
            carta c = element[frente];
            element[frente] = null;
            frente = (frente + 1) % element.length;
            cantidad--;
            return c;
        }
        return null;
    }

}
