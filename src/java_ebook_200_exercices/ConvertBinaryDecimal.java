package java_ebook_200_exercices;

public class ConvertBinaryDecimal {
    public static int binaryToDecimal(String binaryString) throws IllegalArgumentException {

        // Check if the input string contains only '0' and '1'
        if (!binaryString.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid input. Please provide a valid binary string.");
        }

        // Convert binary string to decimal
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        String binaryNumber = "1101";

        try {
            int decimalResult = binaryToDecimal(binaryNumber);
            System.out.printf("The decimal equivalent of binary %s is %d%n", binaryNumber, decimalResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Output: The decimal equivalent of binary 1101 is 13
