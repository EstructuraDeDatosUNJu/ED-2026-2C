package ed2026.PI_I.Julio;

/**
 * Represents a playing card.
 * 
 * @author Julio Tentor
 * @version 1.0.0
 * 
 */
public class Card {

    private final String suit;
    private final String rank;
    private final Integer value;

    /**
     * Constructs a Card object with the specified suit, rank, and value.
     *
     * @param suit  the suit of the card ("Hearts", "Diamonds", "Clubs", "Spades")
     * @param rank  the rank of the card ("Ace", "2", "3", ..., "10", "Jack", "Queen", "King")
     * @param value the numerical value of the card (1 for Ace, 2-10 for number cards, 11 for Jack, 12
     *                  for Queen, 13 for King)
     */
    public Card(String suit, String rank, Integer value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns the value of the card.
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card in the format "rank of suit".
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
