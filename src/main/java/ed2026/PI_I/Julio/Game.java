package ed2026.PI_I.Julio;

/**
 * Represents the main game class.
 * 
 * @author Julio Tentor
 * @version 1.0.0
 * 
 */

public class Game {

    // Represents the maximum number of cards in a standard deck of playing cards.
    protected final static int maxCards = 52;
    protected final static int minPlayers = 4;
    protected final static int maxPlayers = 4;

    // Represents the deck of playing cards used in the game.
    private Deck deck;
    // Represents the queue of players participating in the game.
    private Queue<Player> players;

    // Represents the current round number in the game.
    private int roundNumber = 0;

    /**
     * Constructs a Game object.
     * 
     * Forces the creation of a game with a predefined number of players (minPlayers).
     * 
     */
    public Game() {
        this.deck = new Deck();
        this.players = new Queue<>(Game.minPlayers);

        for (int i = 0; i < Game.minPlayers; i++) {
            this.players.add(new Player("Player " + (i + 1)));
        }

        this.roundNumber = 0;
    }

    /**
     * Constructs a Game object with the specified array of players.
     * 
     * @param players an array of Player objects representing the players in the game
     * @throws IllegalArgumentException if the players array is null or empty
     * @throws IllegalArgumentException if the number of players is not within the allowed range
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
     * Starts the game.
     */
    public void start() {

        for (int round = 1; round <= 3; round++) {
            this.roundNumber++;
            System.out.println("\n--- Round " + roundNumber + " ---");
            this.playRound();
        }

    }

    /**
     * Shows the final scores of all players.
     */
    public void showScores() {
        int winnerScore = -1;
        int score;
        Player winner = null;

        System.out.println("\n--- Final Scores ---");
        for (Player player : players) {
            score = player.getScore();
            if (score > winnerScore) {
                winnerScore = score;
                winner = player;
            }
            System.out.printf("%-30.30s: %d points\n",
                    player.getName(),
                    player.getScore());
        }
        if (winner != null) {
            System.out.println("\n\nThe winner of this game is: " +
                    winner.getName().toUpperCase() +
                    " with " +
                    winnerScore + " points.");
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

        Player[] playersArray = new Player[players.size()];
        Card[] drawnCards = new Card[players.size()];

        Player player;

        // Iterate through the players in the queue and allow each player to take their turn
        for (int turn = 0; turn < players.size(); turn++) {
            player = players.poll();
            playersArray[turn] = player;
            drawnCards[turn] = deck.getNextCard();
            players.add(player);

            System.out.printf("%-30.30s drew the card: %s\n",
                    player.getName(),
                    drawnCards[turn].toString());
        }

        // Found the maximum value of the drawn cards and remember the index of the player who drew it
        int maxIndex = 0;
        Card maxCard = drawnCards[maxIndex];
        for (int i = 1; i < drawnCards.length; i++) {
            if (drawnCards[i].getValue() > maxCard.getValue()) {
                maxCard = drawnCards[i];
                maxIndex = i;
            }
        }

        // Count how many players drew the maximum card
        int count = 0;
        for (Card card : drawnCards) {
            if (card == maxCard) {
                ++count;
            }
        }

        // Determine the winner(s) of the round based on the drawn cards and distribute the cards accordingly
        if (count > 1) {
            // Is a tie, distribute the cards among the players who drew the maximum card
            for (int i = 0; i < drawnCards.length; i++) {
                playersArray[i].addWonCard(drawnCards[i]);
            }
            System.out.println(
                    "\nThere is a tie between " + count + " players.");
        } else {
            // Is a single winner, give all the drawn cards to the winning player
            player = playersArray[maxIndex];
            player.addWonCards(drawnCards);
            System.out.println(
                    "\nThe winner of this round is: " +
                            player.getName() +
                            " with the card: " +
                            drawnCards[maxIndex].toString());
        }
    }

}
