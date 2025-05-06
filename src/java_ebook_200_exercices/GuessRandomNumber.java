package java_ebook_200_exercices;

import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {

    /// # GuessRandomNumber
    ///
    /// This program implements a **number guessing game** where the user attempts to guess a randomly generated number between **1 and 100**.
    ///
    /// ## How It Works:
    /// 1. A random integer from 1 to 100 is generated.
    /// 2. The user is repeatedly prompted to guess the number.
    /// 3. After each guess:
    ///    - If the guess is too low, the user is informed it's **"Too low!"**.
    ///    - If too high, the user sees **"Too high!"**.
    ///    - If correct, a congratulatory message is shown with the number of attempts.
    ///
    /// ## Input Validation:
    /// - Only valid integers are accepted.
    /// - Invalid input (e.g., letters) is ignored and a prompt is shown again.
    ///
    /// ## Example:
    /// ```
    /// Guess the random number (1-100): 50
    /// Too low!
    /// Guess the random number (1-100): 75
    /// Too high!
    /// Guess the random number (1-100): 62
    /// Congratulations! You guessed 63 in 3 attempts.
    /// ```
    ///
    /// ## Notes:
    /// - The game runs until the correct number is guessed.
    /// - Randomness is provided by `java.util.Random`.

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

    /// Prompts the user to enter a number and returns it if valid.
    ///
    /// @param scanner The `Scanner` object used to read user input.
    /// @return The guessed number as `Integer`, or `null` if the input is invalid.
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
