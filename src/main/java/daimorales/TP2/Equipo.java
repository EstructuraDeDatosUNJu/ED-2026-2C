package daimorales.TP2;

public class Equipo {
    
    //Atributos
    private int idEquipo;
    private String nombre;
    private int puntajeAcumulado;
    private int partidosJugados;

    //Metodo constructor por defecto
    public Equipo(){
        this.idEquipo = 0;
        this.nombre = null;
        this.puntajeAcumulado = 0;
        this.partidosJugados = 0;
    }

    //Metodo constructor especializado
    public Equipo(int idEquipo, String nombre, int puntajeAcumulado, int partidosJugados){
        this.idEquipo= idEquipo;
        this.nombre= nombre;
        this.puntajeAcumulado = puntajeAcumulado;
        this.partidosJugados = partidosJugados;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntajeAcumulado() {
        return puntajeAcumulado;
    }

    public void setPuntajeAcumulado(int puntajeAcumulado) {
        this.puntajeAcumulado = puntajeAcumulado;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    
}
