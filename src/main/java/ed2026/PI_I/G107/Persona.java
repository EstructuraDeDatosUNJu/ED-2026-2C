package ed2026.PI_I.G107;

public class Persona {

    private String Nombre = "";
    private String Apellido = "";
    private int Edad;
    private Carta Carta;

    private Carta[] cartasGanadas = new Carta[52];
    private int cantidadCartasGanadas = 0;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, Carta carta) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Edad = edad;
        this.Carta = carta;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public Carta getCarta() {
        return Carta;
    }

    public void setCarta(Carta carta) {
        this.Carta = carta;
    }

    public void agregarCartaGanada(Carta carta) {
        cartasGanadas[cantidadCartasGanadas] = carta;
        cantidadCartasGanadas++;
    }

    public int calcularPuntaje() {
        int puntaje = 0;

        for (int i = 0; i < cantidadCartasGanadas; i++) {
            puntaje = puntaje + cartasGanadas[i].getValor();
        }
        return puntaje;
    }
}
