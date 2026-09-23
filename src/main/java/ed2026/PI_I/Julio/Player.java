package ed2026.PI_I.Julio;

import java.util.Objects;

/**
 * Represents a player in the game.
 * 
 * I simplify the player class to only include the name and the cards won by the player.
 * In a real case, the player class could and must include more attributes.
 * The score is calculated based on the cards won.
 * 
 * @author Julio Tentor
 * @version 1.0.1
 * 
 */
public class Player {

    // Represents the name of the player.
    private String name = null;
    // Represents the card drawn by the player in the current round.
    private Card drawnCard = null;
    // Represents the cards won by the player.
    private Stack<Card> wonCards = null;
    // Represents the score of the player, which is calculated when the player wins cards.
    private int score = 0;

    /**
     * Constructs a Player object with the specified name and initializes the score to 0.
     *
     * @param name the name of the player
     * @throws IllegalArgumentException if the name is null or empty
     */
    public Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        this.name = name;
        this.wonCards = new Stack<>(Game.maxCards);
        this.score = 0;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the card drawn by the player in the current round.
     *
     * @return the card drawn by the player
     */
    public Card getDrawnCard() {
        return this.drawnCard;
    }

    /**
     * Sets the card drawn by the player in the current round.
     *
     * @param drawnCard the card drawn by the player
     * @throws IllegalArgumentException if the drawnCard is null
     */
    public Card setDrawnCard(Card drawnCard) {
        if (drawnCard == null) {
            throw new IllegalArgumentException("Drawn card cannot be null.");
        }
        this.drawnCard = drawnCard;
        return this.drawnCard;
    }

    /**
     * Returns the cards won by the player.
     *
     * @return the cards won by the player
     */
    public Card[] getWonCards() {
        return this.wonCards.toArray(new Card[this.wonCards.size()]);
    }

    /**
     * Adds a card to the player's won cards.
     *
     * @param card the card to be added
     * @throws IllegalArgumentException if the card is null
     */
    public void addToWonCards(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null.");
        }
        this.wonCards.push(card);
        this.score += card.getValue();
    }

    /**
     * Returns the score of the player.
     *
     * @return the score of the player
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Returns true if this player is equal to the specified object.
     * Two players are considered equal if they have the same name.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            // the same object reference, so they are equal
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            // not the same class, so they are not equal
            return false;
        }
        // cast the object to Player and compare their names
        Player player = (Player) o;
        return this.name.equals(player.name);
    }

    /**
     * Returns a hash code value for the player, which is based on the player's name.
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
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
