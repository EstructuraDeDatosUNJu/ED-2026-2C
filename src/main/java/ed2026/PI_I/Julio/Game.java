package ed2026.PI_I.Julio;

import java.util.ArrayList;

/**
 * Represents the main game class.
 * 
 * @author Julio Tentor
 * @version 1.0.1
 * 
 */

public class Game {

    // Represents the maximum number of cards in a standard deck of playing cards.
    protected final static int maxCards = 52;
    // Represents the minimum and maximum number of players allowed in the game.
    protected final static int minPlayers = 4;
    protected final static int maxPlayers = 4;
    // Represents the minimum and maximum number of rounds allowed in the game.
    protected final static int minRounds = 3;
    protected final static int maxRounds = 13;

    // Represents the deck of playing cards used in the game.
    private Deck deck = null;
    // Represents the queue of players participating in the game.
    private Queue<Player> players = null;
    // Represents the current round number in the game.
    private int roundNumber = 0;

    /**
     * Constructs a Game object with the specified array of players.
     * 
     * @param players an array of Player objects representing the players in the game.
     * @throws IllegalArgumentException if the players array is null or empty.
     * @throws IllegalArgumentException if the number of players is not within the allowed range.
     * 
     */
    public Game(Player[] players) {

        if (players == null || players.length == 0) {
            throw new IllegalArgumentException("Players array cannot be null or empty.");
        }

        if (players.length < Game.minPlayers || players.length > Game.maxPlayers) {
            throw new IllegalArgumentException(
                    "Number of players must be between " + Game.minPlayers + " and " + Game.maxPlayers + ".");
        }

        this.deck = new Deck();
        this.players = new Queue<>(players.length);

        for (Player player : players) {
            this.players.add(player);
        }

        this.roundNumber = 0;
    }

    /**
     * Play the game.
     * 
     * @param numberOfRounds the number of rounds to play.
     * 
     */
    public void play(int numberOfRounds) {

        for (roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {
            this.playRound();
            this.players.add(players.remove());
        }
    }

    /**
     * Plays a single round of the game.
     * 
     * Each player draws a card from the deck, and the player with the highest card wins the round.
     * In case of a tie, all players keep the cards they drew and the round is considered a tie.
     * 
     */
    private void playRound() {

        // Get the players snapshot from the queue in this turn order
        Player[] playersArray = players.toArray(new Player[players.size()]);

        // Each player draws a card from the deck
        for (Player player : playersArray) {
            player.setDrawnCard(deck.getNextCard());
        }

        // Found the maximum value of the drawn cards
        int winnerValue = playersArray[0].getDrawnCard().getValue();
        for (Player player : playersArray) {
            if (player.getDrawnCard().getValue() > winnerValue) {
                winnerValue = player.getDrawnCard().getValue();
            }
        }

        // Find the players who drew the maximum card
        ArrayList<Player> winnersList = new ArrayList<>();
        for (Player player : playersArray) {
            if (player.getDrawnCard().getValue() == winnerValue) {
                winnersList.add(player);
            }
        }

        // Distribute the cards accordingly game rules.
        if (winnersList.size() > 1) {
            // Is a tie, each player keeps the card they drew.
            for (Player player : playersArray) {
                player.addToWonCards(player.getDrawnCard());
            }
        } else {
            // Is a single winner, give all the drawn cards to the winning player.
            Player winnerPlayer = winnersList.get(0);
            for (Player player : playersArray) {
                winnerPlayer.addToWonCards(player.getDrawnCard());
            }
        }

        this.displayRoundInfo(playersArray, winnersList);
    }

    /**
     * Display the round number and the cards drawn by each player in the current round.
     * 
     * @param playersArray the array of players in the current round.
     * @param winnersList  the list of winners in the current round.
     * 
     */
    private void displayRoundInfo(Player[] playersArray, ArrayList<Player> winnersList) {

        System.out.println("\n--- Round " + roundNumber + " ---");
        // Display the cards drawn by each player in the current round.
        for (Player player : playersArray) {
            System.out.printf("%-30.30s drew the card: %s\n",
                    player.toString(),
                    player.getDrawnCard().toString());
        }

        // Display the winner(s) of the current round.
        if (winnersList.size() > 1) {
            System.out.println(
                    "\tThere is a tie between " + winnersList.size() + " players.");
        } else {
            Player winnerPlayer = winnersList.get(0);
            System.out.println(
                    "\tThe winner of this round is: " +
                            winnerPlayer.getName().toString() +
                            " with the card: " +
                            winnerPlayer.getDrawnCard().toString());
        }

    }

    /**
     * Displays the final scores of all players.
     */
    public void displayScores() {

        System.out.println("\n--- Final Scores ---");

        int winnerScore = -1;
        for (Player player : players) {
            if (player.getScore() > winnerScore) {
                winnerScore = player.getScore();
            }
            // Display the player's name and score, along with the cards won if the player has any.
            System.out.printf("%-30.30s: %d points",
                    player.getName().toString(),
                    player.getScore());
            if (player.getScore() > 0) {
                System.out.print(" cards won: ");
                for (Card card : player.getWonCards()) {
                    System.out.print(card.toString() + " ");
                }
            }
            System.out.println();
        }

        // Display the winner(s) of the game based on the highest score
        for (Player player : players) {
            if (player.getScore() == winnerScore) {
                System.out.printf("\nThe winner of this game is: %s with %d points.",
                        player.getName().toUpperCase(),
                        player.getScore());
            }
        }
        System.out.println("\n--------------------");
    }

}
