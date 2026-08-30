//Crear la clase Equipo con los atributos: idEquipo, nombre, puntajeAcumulado y partidosJugados. El
//programa debe solicitar al usuario la cantidad de equipos a gestionar. Luego, permitir el ingreso de
//diferentes equipos hasta llenar un arreglo. Además, el programa debe permitir:
//a) Actualizar el puntajeAcumulado de un equipo dado su idEquipo (sumando puntos).
//b) Calcular y mostrar el total de partidos jugados entre todos los equipos del arreglo.
//c) Calcular y mostrar el promedio general de puntajes de la liga.
//d) Identificar y mostrar los datos del equipo con mayor puntajeAcumulado (el líder).
//e) Listar todos los equipos que tienen un puntaje inferior al promedio general calculado en el punto c,
//mostrando un mensaje que indique que están en "zona de descenso".



public class Equipo4 {

    private String idEquipo="";
    private String nombre="";
    private Double puntajeAcumulado=0.0;
    private int partidosJugados=0;

    public Equipo4 (){
    }

    public String getIdEquipo() {
        
        return idEquipo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPartidosJugados() {
        return partidosJugados;
    }
    public Double getPuntajeAcumulado() {
        return puntajeAcumulado;
    }
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
    public void setPuntajeAcumulado(Double puntajeAcumulado) {
        this.puntajeAcumulado = puntajeAcumulado;
    }

    public double sumarPuntos(double puntos){
        return puntajeAcumulado+=puntos;
    }

     public void mostrarDatos() {
        System.out.println("ID: " + idEquipo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Puntaje: " + puntajeAcumulado);
        System.out.println("Partidos jugados: " + partidosJugados);
    }
}
