package java_ebook_200_exercices;

public class FindLuhnAlgorithmCheckDigit {
    // Method to calculate the Luhn check digit
    public static int calculateLuhnCheckDigit(long input) {
        String inputStr = Long.toString(input);
        int totalSum = 0;
        boolean isEvenPosition = inputStr.length() % 2 == 0;

        // Iterate over the digits
        for (int i = 0; i < inputStr.length(); i++) {
            int digit = Character.getNumericValue(inputStr.charAt(i));

            // Check if we are in an even position
            if (isEvenPosition) {
                // For even position, we double the digit
                if (i % 2 == 0) {
                    digit *= 2;

                    if (digit > 9) {
                        digit -= 9; // Subtract 9 if the result is greater than 9
                    }
                }
            } else {
                // For odd position, we double the digit
                if (i % 2 != 0) {
                    digit *= 2;

                    if (digit > 9) {
                        digit -= 9; // Subtract 9 if the result is greater than 9
                    }
                }
            }
            totalSum += digit; // Add the processed digit to the total sum
        }

        // Calculate check digit
        return (10 - (totalSum % 10)) % 10;
    }

    public static void main(String[] args) {
        long partialNumber = 123456789; // Replace with the partial number
        int checkDigit = calculateLuhnCheckDigit(partialNumber);
        String fullNumber = Long.toString(partialNumber) + checkDigit;

        System.out.println("Partial Number: " + partialNumber);
        System.out.println("Check Digit: " + checkDigit);
        System.out.println("Full Number with Check Digit: " + fullNumber);
    }
}

// Partial Number: 123456789
// Check Digit: 3
// Full Number with Check Digit: 1234567893

