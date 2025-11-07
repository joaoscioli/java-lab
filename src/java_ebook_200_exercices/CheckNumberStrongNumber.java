package java_ebook_200_exercices;

public class CheckNumberStrongNumber {
    // Method to calculate factorial of a number
    public static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int num) {
        int originalNumber = num;
        int digitFactorialSum = 0;

        // Calculate the sum of the factorial of each digit
        while (num > 0) {
            int digit = num % 10; // Get the last digit
            digitFactorialSum += calculateFactorial(digit);
            num /= 10; // Remove the last digit
        }

        // Check if the sum equals the original number
        return digitFactorialSum == originalNumber;
    }

    public static void main(String[] args) {
        int testNumber = 145;
        boolean result = isStrongNumber(testNumber);
        System.out.println(testNumber + " is a strong number: " + result);
    }
}

/*
Output:
145 is a strong number: true
*/
