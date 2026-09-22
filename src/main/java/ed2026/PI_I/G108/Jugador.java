package ed2026.PI_I.G108;

// Entidad
public class Jugador {
    //Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private int puntaje;

    //constructor
    public Jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puntaje = 0;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    //ToString
    @Override
    public String toString() {
        return nombre + " " + apellido + " (Edad: " + edad + ") - Puntaje: " + puntaje;
    }
}
