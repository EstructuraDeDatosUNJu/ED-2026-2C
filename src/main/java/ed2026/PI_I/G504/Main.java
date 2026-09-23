package ed2026.PI_I.G504;

public class Main {
    public static void main(String[] args) {
        // Inicializar los 4 jugadores (Arreglo)
        jugador[] jugadores = new jugador[4];
        jugadores[0] = new jugador("Lucas", "Pérez", 21);
        jugadores[1] = new jugador("María", "Gómez", 23);
        jugadores[2] = new jugador("Carlos", "López", 20);
        jugadores[3] = new jugador("Ana", "Martínez", 22);

        JuegoCartas juego = new JuegoCartas(jugadores);

        // Se pueden jugar las rondas especificadas (por ejemplo, 3 rondas según la nota del enunciado)
        juego.jugar(5);
    }
}