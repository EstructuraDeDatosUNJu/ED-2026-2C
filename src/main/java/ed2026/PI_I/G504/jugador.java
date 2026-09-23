package ed2026.PI_I.G504;

public class jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private colaCartas cartasObtenidas;
    private int puntos;

    public jugador(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cartasObtenidas = new colaCartas(52);
        this.puntos = 0;
    }

    //region setter y getters//

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getpuntos() {
        return puntos;
    }

    public void agregarPunto(carta carta) {
        cartasObtenidas.meterCarta(carta);
        puntos += carta.getValor();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + "(" + edad + " años) Puntuacion: " + puntos;
    }
}
