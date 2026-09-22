package ed2026.PI_I.G103;

import java.util.EmptyStackException;

// Stack of cards (LIFO): the top of the deck is the last element stored
public class Stack {
    private Card[] cards;
    private int count; // number of cards stored, also the next free position

    public Stack(int capacity) {
        cards = new Card[capacity];
    }

    public void push(Card card) {
        if (count == cards.length) {
            throw new IllegalStateException("stack is full");
        }
        cards[count] = card;
        count++;
    }

    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        count--;
        return cards[count];
    }

    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return cards[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        if (!this.isEmpty()) {
            for (int i = 0; i < count; i++) {
                sb.append(cards[i].toString());
                if (i < count - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
