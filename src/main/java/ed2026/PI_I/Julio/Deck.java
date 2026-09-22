package ed2026.PI_I.Julio;

/**
 * Represents a deck of playing cards.
 *
 * @author Julio Tentor
 * @version 1.0.0
 * 
 */
public class Deck {

    private Stack<Card> cards;

    /**
     * Constructs a Deck object with the specified number of cards.
     * 
     * Initializes the deck with a standard set of 52 playing cards, shuffles them, and stores them in a
     * stack.
     */
    public Deck() {
        this.cards = new Stack<>(Game.maxCards);
        initializeDeck();
    }

    /**
     * Initializes the deck with a standard set of 52 playing cards, shuffles them, and stores them in a
     * stack.
     */
    private void initializeDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        Card[] cardsArray = new Card[Game.maxCards];

        // Create the cards and store them in the cardsArray
        int index = 0;
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                Card card = new Card(suit, ranks[i], values[i]);
                cardsArray[index++] = card;
            }
        }

        // Suffle the cardsArray to randomize the order of the cards
        Helper.suffleArray(cardsArray);

        // Push the shuffled cards into the stack
        for (Card card : cardsArray) {
            cards.push(card);
        }
    }

    /**
     * Tests if the deck is empty.
     *
     * @return true if the deck is empty, false otherwise
     */
    public Boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Gets the next card from the deck.
     *
     * @return the next card from the deck
     * @throws IllegalStateException if the deck is empty
     */
    public Card getNextCard() {
        if (isEmpty()) {
            throw new IllegalStateException("Deck is empty. Cannot draw a card.");
        }
        return cards.pop();
    }
}
