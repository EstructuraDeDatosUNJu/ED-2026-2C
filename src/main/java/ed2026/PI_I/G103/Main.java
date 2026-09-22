package ed2026.PI_I.G103;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        showRules();

        Card[] temporalDeck = createTemporalDeck();

        temporalDeck = shuffleDeckCards(random, temporalDeck);

        Stack cardStack = createCardStack(temporalDeck);

        Queue<Player> playerQueue = createPlayerQueue(scanner);

        int currentRound = 1;
        System.out.println("");
        int roundsPerGame = validateInt(scanner, "How many rounds are we playing: ", 1, 13);

        Array cardsTable = new Array(4);

        while (!cardStack.isEmpty() && currentRound <= roundsPerGame) {
            playRound(cardsTable, playerQueue, cardStack, currentRound);
            currentRound++;
        }

        getFinalResults(playerQueue);

    }

    // Builds the full 52-card deck, in order
    public static Card[] createTemporalDeck() {
        Card[] temporalDeck = new Card[52];
        int index = 0;

        for (int cardNumber = 1; cardNumber < 14; cardNumber++) {
            Card cardsClubs = new Card("Clubs", cardNumber);
            temporalDeck[index] = cardsClubs;
            index++;

            Card cardsSpades = new Card("Spades", cardNumber);
            temporalDeck[index] = cardsSpades;
            index++;

            Card cardsHearts = new Card("Hearts", cardNumber);
            temporalDeck[index] = cardsHearts;
            index++;

            Card cardDiamonds = new Card("Diamonds", cardNumber);
            temporalDeck[index] = cardDiamonds;
            index++;
        }

        return temporalDeck;
    }

    // Shuffles the deck by swapping every card with a random one
    public static Card[] shuffleDeckCards(Random random, Card[] temporalDeck) {
        for (int card = 0; card < 52; card++) {

            int randomCardPosition = random.nextInt(52);

            Card currentCardAuxiliar = temporalDeck[card];

            temporalDeck[card] = temporalDeck[randomCardPosition];
            temporalDeck[randomCardPosition] = currentCardAuxiliar;
        }

        return temporalDeck;
    }

    // Pushes the shuffled cards onto the stack
    public static Stack createCardStack(Card[] shuffledDeckCards) {
        Stack cardStack = new Stack(52);

        for (int card = 0; card < 52; card++) {
            cardStack.push(shuffledDeckCards[card]);
        }

        return cardStack;
    }

    // Keeps asking for a number until it is inside the range [bottom, top]
    public static int validateInt(Scanner scanner, String message, int bottom, int top) {
        while (true) {
            System.out.print(message);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number < bottom || number > top) {
                    System.out.println("Add a number between " + bottom + " and " + top);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, the input must be an integer number.");
            }
        }
    }

    // Reads the data of the 4 players and adds them to the queue
    public static Queue<Player> createPlayerQueue(Scanner scanner) {
        Queue<Player> playerQueue = new Queue<>(4);

        System.out.println("\n=== A NEW GAME HAS STARTED ===");
        System.out.println("Each player must enter their data:\n");

        for (int i = 0; i < 4; i++) {
            System.out.print("Write your name: ");
            String name = scanner.nextLine();

            System.out.print("Write your surname: ");
            String surname = scanner.nextLine();

            int age = validateInt(scanner, "Write your age: ", 1, 122);

            Player player = new Player(name, surname, age);

            playerQueue.enqueue(player);

            if (i == 3) {
                break;
            }

            System.out.println("\n--- NEXT PLAYER ---");
        }

        return playerQueue;
    }

    public static void playRound(Array cardsTable, Queue<Player> playerQueue, Stack cardStack, int currentRound) {
        System.out.println("\n====== ROUND " + currentRound + " ======");
        cardsTable.clear();

        // Table position i belongs to the i-th player of the queue
        for (int position = 0; position < 4; position++) {
            Player currentPlayer = playerQueue.dequeue(); // next player in line

            cardsTable.setCard(position, cardStack.pop()); // draw from the stack and put the card on the table

            Card currentPlayerCard = cardsTable.getCard(position);

            currentPlayerCard.setAvailable(false); // once it's on the table it's no longer available

            System.out.println("- " + currentPlayer.getName() + " played: " + currentPlayerCard.getValue() + " of "
                    + currentPlayerCard.getSuit());

            System.out.println(currentPlayerCard.toString() + "\n");

            playerQueue.enqueue(currentPlayer); // back to the end, so the queue keeps the playing order
        }

        // the queue is in the same order as the table, so we can match players with cards
        showRoundWinnersAndUpdateScore(playerQueue, cardsTable);

        // rotate turns: the first player goes to the back, so the second one starts the next round
        playerQueue.enqueue(playerQueue.dequeue());
    }

    // Linear search: checks if a table position is one of the winning positions
    public static boolean searchInArray(int[] array, int elementWeAreSearching) {
        for (int arrayElement : array) {
            if (arrayElement == elementWeAreSearching) {
                return true;
            }
        }
        return false;
    }

    public static void showRoundWinnersAndUpdateScore(Queue<Player> playerQueue, Array cardsTable) {
        // positions of the highest cards on the table (more than one means a tie)
        int[] winnersPosition = cardsTable.findRoundWinners();

        // sum of the 4 cards, it goes to the winner when there is no tie
        int totalScoreOnTable = 0;
        for (int i = 0; i < 4; i++) {
            totalScoreOnTable += cardsTable.getCard(i).getValue();
        }

        if (winnersPosition.length > 1) {
            System.out.println("\nTHERE'S A DRAW! THE WINNERS ARE: ");
        } else {
            System.out.println("\nWINNER OF THIS ROUND: ");
        }

        // Go through the queue in playing order: playerPosition is the same as the position of their card.
        // Tie: each winner scores only their own card. Single winner: takes the whole table.
        for (int playerPosition = 0; playerPosition < 4; playerPosition++) {
            Player player = playerQueue.dequeue();
            if (searchInArray(winnersPosition, playerPosition)) {
                if (winnersPosition.length > 1) {
                    player.addScore(cardsTable.getCard(playerPosition).getValue());
                } else {
                    player.addScore(totalScoreOnTable);
                }
            }
            playerQueue.enqueue(player);
        }
    }

    public static void getFinalResults(Queue<Player> playersQueue) {
        // First pass: find the highest score (the final result can also be a tie)
        int highestScore = 0;

        System.out.println("\n\n====== FINAL RESULTS ======");

        for (int playerPosition = 0; playerPosition < 4; playerPosition++) {
            Player player = playersQueue.dequeue();
            int currentPlayerScore = player.getCompetitionScore();

            if (highestScore < currentPlayerScore) {
                highestScore = currentPlayerScore;
            }
            playersQueue.enqueue(player);
        }

        // Second pass: show every player and mark the winner(s)
        for (int playerPosition = 0; playerPosition < 4; playerPosition++) {
            Player player = playersQueue.dequeue();
            if (player.getCompetitionScore() == highestScore) {

                System.out.println("\n - WINNER -\n" + player.toString());
            } else {
                System.out.println("\n" + player.toString());
            }
            playersQueue.enqueue(player);
        }
    }

    public static void showRules() {
        System.out.println("\n=========================================================");
        System.out.println("                      GAME RULES                         ");
        System.out.println("=========================================================");
        System.out.println("1. Four players face off in a series of rounds.");
        System.out.println("2. In each round, every player draws one random card from the deck.");
        System.out.println(
                "3. The player with the highest numeric value wins the round and takes the points of all cards on the table.");
        System.out.println(
                "4. TIE-BREAKER: If there is a tie for the highest value, the tied players keep only the points of their own card.");
        System.out.println("5. At the end of the game, the player with the highest accumulated score wins!");
        System.out.println("=========================================================\n");
    }
}
