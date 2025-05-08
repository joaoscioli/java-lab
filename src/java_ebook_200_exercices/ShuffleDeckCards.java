package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleDeckCards {

    /// # ShuffleDeckCards
    ///
    /// This program demonstrates how to **create**, **print**, and **shuffle** a standard deck of playing cards using Java.
    ///
    /// ## Features:
    /// - Builds a deck of cards using all combinations of ranks and suits.
    /// - Displays the original (unshuffled) deck.
    /// - Randomly shuffles the deck using `Collections.shuffle()`.
    /// - Displays the shuffled deck.
    ///
    /// ## Deck Details:
    /// - **Suits**: Hearts, Diamonds, Clubs, Spades
    /// - **Ranks**: Ace, 2 through 10, Jack, Queen, King, Ace *(note: Ace appears twice here)*
    ///
    /// > ⚠️ **Note:** This version contains **two Aces** per suit due to duplication in the `ranks` array.
    ///
    /// ## Example Output:
    /// ```
    /// Initial Deck:
    /// Ace of Hearts
    /// 2 of Hearts
    /// ...
    /// Shuffled Deck:
    /// 10 of Spades
    /// 4 of Hearts
    /// Ace of Diamonds
    /// ...
    /// ```

    public static void main(String[] args) {
        List<String> deck = createDeck();
        System.out.println("Initial Deck:");
        printDeck(deck);

        Collections.shuffle(deck); // Shuffle the deck
        System.out.println("\nShuffled Deck:");
        printDeck(deck);
    }

    /// Creates a full deck of cards by combining all suits and ranks.
    ///
    /// @return A list of strings representing all cards in the deck.
    private static List<String> createDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    /// Prints all cards in the deck to the standard output.
    ///
    /// @param deck The list of cards to print.
    private static void printDeck(List<String> deck) {
        for (String card : deck) {
            System.out.println(card);
        }
        System.out.println();
    }
}
