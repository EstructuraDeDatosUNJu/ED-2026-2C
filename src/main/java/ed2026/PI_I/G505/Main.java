package ed2026.PI_I.G505;

// import ar.edu.unju.fi.ed.model.*;
public class Main {

    public static void main(String[] args) {

        Jugador j1 = new Jugador("Matias", "Lopez", 20);
        Jugador j2 = new Jugador("Lucas", "Gomez", 21);
        Jugador j3 = new Jugador("Sofia", "Perez", 19);
        Jugador j4 = new Jugador("Camila", "Diaz", 22);

        Jugador[] jugadores = { j1, j2, j3, j4 };

        Juego juego = new Juego(jugadores);

        juego.jugarRondas(3);

        juego.mostrarResultados();
    }
}