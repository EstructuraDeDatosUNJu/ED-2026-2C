package ed2026.PI_I.Julio;

import java.util.ArrayList;

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

        Player[] players = getPlayers(Game.minPlayers);

        Helper.printOneDimensionArray(
                "\nLos jugadores seleccionados son: ",
                players,
                "\n");

        Game game = new Game(players);

        game.play(Game.minRounds);
        game.displayScores();

    }

    /***
     * Generates an array of players with predefined names.
     * 
     * @param playersCount the number of players to generate.
     * @return An array of players.
     * @throws IllegalArgumentException if the number of players is not within the valid range.
     * 
     */
    private static Player[] getPlayers(int playersCount) {

        if (playersCount < Game.minPlayers || playersCount > Game.maxPlayers) {
            throw new IllegalArgumentException(
                    "Number of players must be between " + Game.minPlayers + " and " + Game.maxPlayers + ".");
        }

        // Create players list with random names from the predefined list
        ArrayList<Player> playersList = new ArrayList<>(playersCount);
        Player player = null;
        while (playersList.size() < playersCount) {
            player = new Player(names[Helper.random.nextInt(names.length)]);
            if (!playersList.contains(player)) {
                playersList.add(player);
            }
        }

        // Convert the ArrayList to an array
        Player[] players = playersList.toArray(new Player[0]);

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
