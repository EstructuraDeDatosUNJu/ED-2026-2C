package ed2026.PI_I.G511;

public class StackTDA<ELEMENT> {

    private int porDefecto = 10;
    private ELEMENT[] datos;
    private int cuenta;

    @SuppressWarnings("unchecked")
    public StackTDA() {
        this.datos = (ELEMENT[]) new Object[this.porDefecto];
        this.cuenta = 0;
    }

    @SuppressWarnings("unchecked")
    public StackTDA(int tamano) {
        if (tamano <= 0) {
            throw new IllegalArgumentException(
                    "El tamaño de la pila debe ser mayor que cero.");
        }

        this.porDefecto = tamano;
        this.datos = (ELEMENT[]) new Object[tamano];
        this.cuenta = 0;
    }

    public void push(ELEMENT elemento) {
        if (this.isFull()) {
            throw new RuntimeException("La pila esta llena...");
        }
        this.datos[this.cuenta] = elemento;
        ++this.cuenta;
    }

    public ELEMENT pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila esta vacia...");
        }
        --this.cuenta;
        return this.datos[this.cuenta];
    }

    public ELEMENT peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila esta vacia...");
        }
        return this.datos[this.cuenta - 1];
    }

    public boolean isEmpty() {
        return this.cuenta <= 0;
    }

    public boolean isFull() {
        return this.cuenta >= this.porDefecto;
    }

    public int count() {
        return this.cuenta;
    }

}
