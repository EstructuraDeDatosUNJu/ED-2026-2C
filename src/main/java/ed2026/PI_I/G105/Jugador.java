package ed2026.PI_I.G105;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private Carta cartaActual;
    private Pila cartasGanadas;

    public Jugador(String nombre, String apellido, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es requerido");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido es requerido");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor a 0");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cartaActual = null;
        this.cartasGanadas = new Pila();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Carta getCartaActual() {
        return cartaActual;
    }

    public void setCartaActual(Carta cartaActual) {
        this.cartaActual = cartaActual;
    }

    public void guardarCarta(Carta c) {
        if (c != null) {
            cartasGanadas.apilar(c);
        }
    }

    public int calcularPuntaje() {
        int puntaje = 0;
        Pila aux = new Pila();

        while (!cartasGanadas.estaVacia()) {
            Carta c = cartasGanadas.desapilar();
            puntaje += c.getValor();
            aux.apilar(c);
        }

        while (!aux.estaVacia()) {
            cartasGanadas.apilar(aux.desapilar());
        }

        return puntaje;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (" + edad + " años)";
    }
}