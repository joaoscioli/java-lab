package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleDeckCards {
    public static void main(String[] args) {
        List<String> deck = createDeck();
        System.out.println("Initial Deck:");
        printDeck(deck);

        Collections.shuffle(deck);
        System.out.println("Shuffled Deck:");   // Shuffle the deck
        System.out.println("\nShuffled Deck:");
        printDeck(deck);
    }

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

    private static void printDeck(List<String> deck) {
        for (String card : deck) {
            System.out.println(card);
        }
        System.out.println();
    }
}

// Initial Deck:
// 2 of Hearts
// 3 of Hearts
// 4 of Hearts
// 5 of Hearts
// ...
// Shuffled Deck:
// 10 of Spades
// 4 of Hearts
// Ace of Diamonds
// ...