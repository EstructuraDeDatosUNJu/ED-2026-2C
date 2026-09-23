package ed2026.PI_I.G507;
// import main.util.Stack;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private Stack<Carta> cartasGanadas;

    public Jugador(String nombre, String apellido, int edad) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        this.cartasGanadas = new Stack<Carta>();
    }

    //getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarNombreYApellido(nombre);
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = validarNombreYApellido(apellido);
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = validarEdad(edad);
    }

    public int getCantCartasGanadas() {
        return cartasGanadas.size();
    }

    public Stack<Carta> getCartasGanadas() {
        return cartasGanadas;
    }

    public String getNombreCompleto() {
        return String.format("%s %s",
                this.nombre, this.apellido);
    }

    public Carta cartaEnMano() {
        if (cartasGanadas.isEmpty())
            throw new RuntimeException("\n" + getNombreCompleto() + " no tiene cartas");
        return cartasGanadas.peek();
    }

    public Carta darCartaEnMano() {
        if (cartasGanadas.isEmpty())
            throw new RuntimeException("\n" + getNombreCompleto() + " no tiene cartas");
        return cartasGanadas.pop();
    }

    public void agregarCarta(Carta carta) {
        if (carta == null)
            throw new NullPointerException();
        cartasGanadas.push(carta);
    }

    public int calcularPuntaje() {
        int puntajeTotal = 0;
        Object[] cartas = cartasGanadas.toArray();

        for (Object objeto : cartas) {
            Carta carta = (Carta) objeto;
            puntajeTotal += carta.getValor();
        }

        return puntajeTotal;
    }

    private String validarNombreYApellido(String cadena) {
        if (cadena.trim().equals("") || cadena == null)
            throw new IllegalArgumentException();
        return cadena;
    }

    private int validarEdad(int edad) {
        if (edad < 5 || edad > 100)
            throw new IllegalArgumentException("ERROR: La edad debe estar entre 5 y 100");
        return edad;
    }

    public String toString() {
        return nombre + " " + apellido + " - " + edad + " años";
    }

}
