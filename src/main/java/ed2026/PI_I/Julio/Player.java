package ed2026.PI_I.Julio;

/**
 * Represents a player in the game.
 * 
 * @author Julio Tentor
 * @version 1.0.0
 * 
 */
public class Player {

    // Represents the name of the player.
    private String name;
    // Represents the cards won by the player.
    private Stack<Card> wonCards;

    /**
     * Constructs a Player object with the specified name and initializes the score to 0.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.wonCards = new Stack<>(Game.maxCards);
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the cards won by the player.
     *
     * @return the cards won by the player
     */
    public Card[] getWonCards() {
        return wonCards.toArray(new Card[this.wonCards.size()]);
    }

    /**
     * Returns the score of the player.
     *
     * @return the score of the player
     */
    public int getScore() {
        int score = 0;
        for (Card card : getWonCards()) {
            score += card.getValue();
        }
        return score;
    }

    /**
     * Adds a card to the player's won cards.
     *
     * @param card the card to be added
     */
    public void addWonCard(Card card) {
        wonCards.push(card);
    }

    /**
     * Adds multiple cards to the player's won cards.
     *
     * @param cards the cards to be added
     */
    public void addWonCards(Card[] cards) {
        for (Card card : cards) {
            wonCards.push(card);
        }
    }

    /**
     * Returns a string representation of the player, which is the player's name.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
