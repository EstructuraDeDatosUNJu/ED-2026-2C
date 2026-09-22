package ed2026.PI_I.G108;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de cartas!");
        System.out.println("Iniciando el juego...");
        System.out.println("--------------------------------------------");
        System.out.println("Registro de Jugadores:04");
        System.out.println("--------------------------------------------");
        // Crear un arreglo para almacenar los jugadores
        Jugador[] jugadores = new Jugador[4];
        // Solicitar datos de los jugadores
        for (int i = 0; i < 4; i++) {
            System.out.println("\n--- Datos del Jugador " + (i + 1) + " ---");
            String nombre = Helper.nextString("Nombre: ");
            String apellido = Helper.nextString("Apellido: ");
            int edad = Helper.nextInteger("Edad: ", "Error: Ingrese un número de edad válido.");
            // Crear un nuevo jugador y agregarlo al arreglo
            jugadores[i] = new Jugador(nombre, apellido, edad);
        }
        // Iniciar el juego
        Juego juego = new Juego(jugadores);
        juego.jugar();
    }
}
