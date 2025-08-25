package java_ebook_200_exercices;

public class NumberTypeChecker {
    // Method to check if a number is an integer or a float
    public static void checkNumberType(Object number) {
        if (number instanceof Integer) {
            System.out.println(number + " is an integer.");
        } else if (number instanceof Double) {
            System.out.println(number + " is a float.");
        } else if (number instanceof String) {
            try {
                // Try parsing the string as an integer first
                Integer.parseInt((String) number);
                System.out.println(number + " is an integer.");
            } catch (NumberFormatException e1) {
                try {
                    // Try parsing the string as a double
                    Double.parseDouble((String) number);
                    System.out.println(number + " is a float.");
                } catch (NumberFormatException e2) {
                    System.out.println(number + " is not a valid number.");
                }
            }
        } else {
            System.out.println(number + " is not a valid number.");
        }
    }

    public static void main(String[] args) {
        checkNumberType(5);         // Outputs: 5 is an integer.
        checkNumberType(3.14);      // Outputs: 3.14 is a float.
        checkNumberType(7.0);       // Outputs: 7.0 is a float.
        checkNumberType(-2.5);      // Outputs: -2.5 is a float.
        checkNumberType("abc");     // Outputs: abc is not a valid number.
    }
}