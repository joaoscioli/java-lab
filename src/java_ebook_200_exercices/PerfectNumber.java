package java_ebook_200_exercices;

public class PerfectNumber {
    //Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        if (number < 2) {
            return false; // 1 and below cannot be perfect numbers
        }

        // Calculate the sum of proper divisors
        int sumOfDivisors = 1; // Start with 1, as 1 is a divisor of any number
        int sqrt = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
                if (i != number / i) {
                    sumOfDivisors += number / i;
                }
            }
        }

        // Check if the sum of the divisors equals the original number
        return sumOfDivisors == number;
    }

    public static void main(String[] args) {
        int testNumber = 28;
        boolean result = isPerfectNumber(testNumber);
        System.out.println("Is " + testNumber + " a perfect number? " + result);
    }
}

// Output:
// Is 28 a perfect number? true