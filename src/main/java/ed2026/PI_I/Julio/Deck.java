package ed2026.PI_I.Julio;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of playing cards.
 *
 * @author Julio Tentor
 * @version 1.0.0
 * 
 */
public class Deck {

    private static final String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    private static final String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King" };
    private static final Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

    private Stack<Card> cards;

    /**
     * Constructs a Deck object with the specified number of cards.
     * 
     * Initializes the deck with a standard set of 52 playing cards, shuffles them, and stores them in a
     * stack.
     */
    public Deck() {
        initializeDeck();
    }

    /**
     * Initializes the deck with a standard set of 52 playing cards, shuffles them, and stores them in a
     * stack.
     */
    private void initializeDeck() {
        ArrayList<Card> cardsArray = new ArrayList<>(Game.maxCards);

        // Create the cards and store them in the cardsArray
        for (String suit : Deck.suits) {
            for (int i = 0; i < Deck.ranks.length; i++) {
                Card card = new Card(suit, Deck.ranks[i], Deck.values[i]);
                cardsArray.add(card);
            }
        }

        // Suffle the cardsArray to randomize the order of the cards
        Collections.shuffle(cardsArray);

        // Push the shuffled cards into the stack
        this.cards = new Stack<Card>(cardsArray);

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
