package ed2026.PI_I.G109;

public class Principal {
    public static void main(String[] args) {

        Jugador j1 = new Jugador("Lucas", "Velazquez", 21);
        Jugador j2 = new Jugador("Ludmila", "Gomez", 22);
        Jugador j3 = new Jugador("Zoe", "Contreras", 20);
        Jugador j4 = new Jugador("Ivan", "Zumbay", 23);

        Mazo mazo = new Mazo();
        Partida partida = new Partida(j1, j2, j3, j4, mazo);
        partida.iniciarJuego();
    }
}
