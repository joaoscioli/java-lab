package java_ebook_200_exercices;

public class SumOfDigits {
    // Method to calculate the sum of digits in a number
    public static int sumOfDigits(int number) {
        int sum = 0;

        // Convert number to string and iterate over each character
        for (char digit : String.valueOf(number).toCharArray()) {

            // Convert character to digit and add to sum
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }

    public static void main(String[] args) {
        int inputNumber = 12345;
        int result = sumOfDigits(inputNumber);
        System.out.println("The sum of digits in " + inputNumber + " is: " + result);
    }
}

// Output:
// The sum of digits in 12345 is: 15
