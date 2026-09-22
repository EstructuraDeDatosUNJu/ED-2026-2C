package ed2026.PI_I.G107;

public class StackChar {

    private final int maximoTamanio = 10;
    private char[] datos;
    private int cuenta;

    public StackChar() {
        this.datos = new char[this.maximoTamanio];
        this.cuenta = 0;
    }

    public void push(char elemento) {
        if (this.isFull()) {
            throw new RuntimeException("La pila est� llena...");
        }
        this.datos[this.cuenta] = elemento;
        ++this.cuenta;
    }

    public char pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila est� vac�a...");
        }
        --this.cuenta;
        return this.datos[this.cuenta];
    }

    public char peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila est� vac�a...");
        }
        return this.datos[this.cuenta - 1];
    }

    public boolean isEmpty() {
        return this.cuenta <= 0;
    }

    public boolean isFull() {
        return this.cuenta >= this.maximoTamanio;
    }

    public int count() {
        return this.cuenta;
    }

}
