package ed2026.PI_I.Julio;

/**
 * The main class for the game.
 * 
 * 
 * @author Julio Tentor
 * @version 1.0.0
 * 
 */

public class Main {

    public static void main(String[] args) {

        Player[] players = getPlayers();

        Helper.printOneDimensionArray(
                "\nLos jugadores seleccionados son: ",
                players,
                "\n");

        Game game = new Game(players);

        game.start();
        game.showScores();

    }

    /***
     * Generates an array of players with predefined names.
     * 
     * @return An array of players.
     */
    private static Player[] getPlayers() {

        // Define the number of players to be created
        int playersCount = Game.minPlayers;
        Player[] players = new Player[playersCount];

        // Create players with random names from the predefined list
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[Helper.random.nextInt(names.length)]);
        }

        // Shuffle the players array to randomize the order of the players
        Helper.suffleArray(players);

        return players;
    }

    private static String[] names = {
            "Agustín Juan Emanuel",
            "Aldo Daniel",
            "Angel Gabriel",
            "Ariana Nicole",
            "Daiana Del Milagro",
            "Diego Fernando",
            "Enzo Iván Ezequiel",
            "Facundo Maximiliano",
            "Fernando de Jesús",
            "Gabriel Alejandro Martin",
            "Gustavo Ezequiel",
            "Ignacio Alberto",
            "Ivone Guadalupe",
            "Joaquín Hernán",
            "Johana Antonella Marisol",
            "Jonatan Agustin",
            "José Matías",
            "Juliana",
            "Lautaro Eduardo",
            "Lucas Samuel",
            "Luciana Abril",
            "Luciano Javier",
            "Luis Eliseo",
            "Martín Eduardo",
            "Mauricio Javier",
            "Nahuel Alberto",
            "Natalia Anahi",
            "Pablo",
            "Salvador Manuel",
            "Santiago Lionel",
            "Tomás Valentino",
            "Zoe Agustina Abril"
    };

}
