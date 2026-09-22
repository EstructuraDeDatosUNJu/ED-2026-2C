package ed2026.PI_I.G101;

public class MiStack {
    private final Carta[] datos;
    private int cuenta;

    public MiStack(int capacidad) {
        datos = new Carta[capacidad];
        cuenta = 0;
    }

    public void push(Carta elemento) { // Agrega una Carta al tope de la pila
        if (cuenta == datos.length) {
            throw new IllegalStateException("La pila está llena.");
        }
        datos[cuenta++] = elemento;
    }

    public Carta pop() { // Extrae y devuelve la Carta del tope
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        Carta cartaAux = datos[--cuenta];
        datos[cuenta] = null;
        return cartaAux;
    }

    public Carta peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return datos[cuenta - 1];
    }

    public boolean isEmpty() { // Verifica si la pila está vacía
        return cuenta == 0;
    }

    public int size() { // Devuelve cuántas cartas quedan en la pila
        return cuenta;
    }
}
