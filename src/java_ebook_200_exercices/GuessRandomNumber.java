package java_ebook_200_exercices;

import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Integer guess = getGuess(scanner);

            if (guess == null) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low!");
            } else if (guess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.printf("Congratulations! You guessed %d in %d attempts.%n" + randomNumber, attempts);
                break;
            }
        }
        scanner.close();
    }

    private static Integer getGuess(Scanner scanner) {
        System.out.println("Guess the random number (1-100):");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next(); // Clear invalid input
            return null;
        }
    }
}

// Guess the random number (1-100): 50
// Too low!
// Guess the random number (1-100): 75
// Too high!
// Guess the random number (1-100): 62
// Congratulations! You guessed 63 in 3 attempts.


