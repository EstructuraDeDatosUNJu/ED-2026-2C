package ed2026.PI_I.G511;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private StackTDA<Carta> cartasGanadas;

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cartasGanadas = new StackTDA<Carta>(52);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public StackTDA<Carta> getCartasGanadas() {
        return cartasGanadas;
    }

    public void agregarCarta(Carta carta) {
        this.cartasGanadas.push(carta);
    }

    public void ganarCarta(Carta carta) {
        this.agregarCarta(carta);
    }

    public int calcularPuntaje() {
        int total = 0;
        StackTDA<Carta> aux = new StackTDA<Carta>(52);

        while (!this.cartasGanadas.isEmpty()) {
            Carta c = this.cartasGanadas.pop();
            total += Main.convertirValorANumero(c.getValor());
            aux.push(c);
        }

        while (!aux.isEmpty()) {
            this.cartasGanadas.push(aux.pop());
        }

        return total;
    }

}
