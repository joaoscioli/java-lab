package java_ebook_200_exercices;

public class CheckNumberNarcissisticNumber {
    // Method to check if a number is a narcissistic number
    public static boolean isNarcissisticNumber(int num) {
        // Convert the number to a string
        String numStr = Integer.toString(num);
        int numDigits = numStr.length();

        // Calculate the sum of each digit raised to the power of the number of digits
        int total = 0;
        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            total += Math.pow(digit, numDigits);
        }

        // Check if the total equals the original number
        return total == num;
    }

    public static void main(String[] args) {
        int testNumber = 1634;
        boolean result = isNarcissisticNumber(testNumber);
        System.out.println(testNumber + " is a Narcissistic Number: " + result);
    }
}

/*
Output:
1634 is a Narcissistic Number: true
*/
