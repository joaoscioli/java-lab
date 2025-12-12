package java_ebook_200_exercices;

public class ConvertDecimalRomanNumerals {
    public static String decimalToRoman(int num) throws IllegalArgumentException {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException("Invalid input. Please provide a valid positive integer within the range 1 to 3999.");
        }
        // Define the Roman numeral symbols and their values
        String[] romanSymbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"

        };
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        StringBuilder result = new StringBuilder();
        // Convert decimal to Roman numeral
        for (int i = 0; i<values.length; i++) {
            while (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public void main() {
        int decimalNumber = 1984;
        try {
            String romanNumeral = decimalToRoman(decimalNumber);
            System.out.printf("The Roman numeral representation of " + decimalNumber + " is: " +romanNumeral);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Output:
// The Roman numeral representation of 1984 is: MCMLXXXIV
//