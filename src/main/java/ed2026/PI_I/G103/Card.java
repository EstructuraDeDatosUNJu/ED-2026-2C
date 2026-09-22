package ed2026.PI_I.G103;

import java.text.Normalizer;

public class Card {
    private String suit;
    private int value;
    private boolean available;

    //constructor
    public Card(String suit, int value) {
        // valid suits: clubs, diamonds, hearts, spades
        if (!cleanText(suit).equals("clubs") && !cleanText(suit).equals("diamonds") && !cleanText(suit).equals("hearts")
                && !cleanText(suit).equals("spades")) {
            throw new IllegalArgumentException(
                    "\nINVALID SUIT:" + suit + ".\nValid suits are:\nClubs\nDiamonds\nHearts\nSpades");
        }
        this.suit = suit;
        // valid values: 1 to 13
        if (!(value >= 1 && value <= 13)) {
            throw new IllegalArgumentException("\nINVALID CARD VALUE:" + value + ".\nOnly 1-13 range admitted.");
        }
        this.value = value;
        this.available = true;
    }

    //getter
    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isAvailable() {
        return available;
    }

    //setter
    public void setSuit(String suit) {
        if (!cleanText(suit).equals("clubs") && !cleanText(suit).equals("diamonds") && !cleanText(suit).equals("hearts")
                && !cleanText(suit).equals("spades")) {
            throw new IllegalArgumentException(
                    "\nINVALID SUIT:" + suit + ".\nValid suits are:\nClubs\nDiamonds\nHearts\nSpades");
        }
        this.suit = suit;
    }

    public void setValue(int value) {
        if (!(value >= 1 && value <= 13)) {
            throw new IllegalArgumentException("\nINVALID CARD VALUE:" + value + ".\nOnly 1-13 range admitted.");
        }
        this.value = value;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //methods
    // Removes accents and spaces and lowercases the text, so the suit check ignores formatting
    public String cleanText(String suit) {
        if (suit == null) {
            return "";
        }
        return Normalizer.normalize(suit, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .trim()
                .toLowerCase();
    }

    // Symbol used to draw the card in the console
    public String suitSymbol(String suit) {
        if (suit == null)
            return "";

        switch (suit.trim().toLowerCase()) {
            case "clubs":
                return "♣";
            case "hearts":
                return "♥";
            case "diamonds":
                return "♦";
            case "spades":
                return "♠";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "-------\n" + value + "\n" + suitSymbol(suit) + "\n-------";
    }
}
