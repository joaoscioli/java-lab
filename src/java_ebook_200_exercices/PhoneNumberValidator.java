package java_ebook_200_exercices;

public class PhoneNumberValidator {
    // Method to check if the phone number is valid
    public static boolean isValidPhoneNumber(String phoneNumber) {
    // Check length
        if (phoneNumber.length() != 14) {
            return false;
        }

        // Check format
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);

            switch (i) {
                case 0:
                    if (c != '(') return false; // First character must be '('
                    break;
                case 1: case 2: case 3:
                    if (!Character.isDigit(c)) return false; // Next three characters must be digits
                    break;
                case 4:

                    if (c != ')') return false; // Fifth character must be ')'

                    break;
                case 5:
                    if (c != ' ') return false; // Sixth character must be a space
                    break;
                case 6: case 7: case 8:
                    if (!Character.isDigit(c)) return false; // Next three characters must be digits
                    break;
                case 9:
                    if (c != '-') return false; // Tenth character must be '-'
                    break;
                case 10: case 11: case 12: case 13:
                    if (!Character.isDigit(c)) return false; // Last four characters must be digits
                    break;
                default:
                    return false; // Should never reach here
            }
        }
        return true; // If all checks pass, return true
    }

    public static void main(String[] args) {
        String[] testNumbers = {
                "(123) 456-7890",
                "1111)555 2345",
                "098) 123 4567",
        };

        for (String number : testNumbers) {
            System.out.println("Is '" + number + "' a valid phone number? " + isValidPhoneNumber(number));
        }
    }
}

// Output:
// Is '(123) 456-7890' a valid phone number? true
// Is '1111)555 2345' a valid phone number? false
// Is '098) 123 4567' a valid phone number? false