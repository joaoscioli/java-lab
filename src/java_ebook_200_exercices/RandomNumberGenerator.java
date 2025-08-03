package java_ebook_200_exercices;

import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int minVal = 1;
        int maxVal = 100;
        int randomNum = getRandomNumber(minVal, maxVal); // Generate a random number between 1 and 100
        System.out.println("Random Number: " + randomNum);
    }

    public static int getRandomNumber(int minVal, int maxVal) {
        Random rand = new Random(); // Create a Random object
        return rand.nextInt(maxVal - minVal + 1) + minVal; // Generate a random number in the range [minVal, maxVal]
    }
}
// Random Number: 48
