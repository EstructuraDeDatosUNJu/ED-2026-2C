package ed2026.PI_I.G110;

// Datos del jugador y las cartas que fue ganando a lo largo del juego.
public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private Naipes[] cartasGanadas; // arreglo para guardar las cartas ganadas
    private int contador; // controla la cantidad real de cartas guardadas

    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cartasGanadas = new Naipes[12];
        this.contador = 0;
    }

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

    public Naipes[] getCartasGanadas() {
        return cartasGanadas;
    }

    public int getContador() {
        return contador;
    }

    // Agrega una carta ganada; si el arreglo se queda chico, lo agranda
    public void agregarCartas(Naipes naipe) {
        if (contador == cartasGanadas.length) {
            Naipes[] nuevoArreglo = new Naipes[cartasGanadas.length * 2];
            for (int i = 0; i < cartasGanadas.length; i++) {
                nuevoArreglo[i] = cartasGanadas[i];
            }
            cartasGanadas = nuevoArreglo;
        }
        cartasGanadas[contador] = naipe;
        contador++;
    }

    public int calcularPuntajeTotal() {
        int suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += cartasGanadas[i].getValor();
        }

        return suma;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", cartasGanadas=" + contador + " cartas" +
                '}';
    }
}
