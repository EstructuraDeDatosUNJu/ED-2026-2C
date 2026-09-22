package ed2026.PI_I.G103;

// Fixed-size table that holds the cards played in the current round
public class Array {
    private Card[] cards;

    public Array(int size) {
        cards = new Card[size];

    }

    public void setCard(int position, Card c) {
        if (position >= 0 && position < cards.length) {
            this.cards[position] = c;
        }
    }

    public Card getCard(int position) {
        if (position >= 0 && position < cards.length) {
            return cards[position];
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("--- CARDS ON TABLE ---\n");
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                sb.append("Position ").append(i).append(": ")
                        .append(cards[i].getValue()).append(" of ")
                        .append(cards[i].getSuit()).append("\n");
            } else {
                sb.append("Position ").append(i).append(": [Empty]\n");
            }
        }
        return sb.toString();
    }

    // Highest card value on the table (0 if it's empty)
    public int findMaxValue() {
        int maxValue = 0;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i].getValue() > maxValue) {
                maxValue = cards[i].getValue();
            }
        }

        return maxValue;
    }

    // Returns the table positions (0-3) of the cards with the highest value.
    // More than one position means a tie.
    public int[] findRoundWinners() {
        int maxValue = findMaxValue();
        int winnerCount = 0;

        // first pass: count the winners so we can size the result

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i].getValue() == maxValue) {
                winnerCount++;
            }
        }
        int[] winners = new int[winnerCount];
        int winnerPos = 0;

        // second pass: save their positions

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i].getValue() == maxValue) {
                winners[winnerPos] = i;
                winnerPos++;
            }
        }

        return winners;
    }

    // Empties the table for the next round
    public void clear() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = null;
        }
    }
}
