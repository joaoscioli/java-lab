package java_ebook_200_exercices;

/// # PhoneNumberValidator
///
/// A utility class for validating U.S.-style phone numbers formatted as `(XXX) XXX-XXXX`.
///
/// This class checks if a given string follows the proper phone number format by
/// validating its length and ensuring each character is in the correct position.
///
/// ## Example
/// ```java
/// boolean valid = PhoneNumberValidator.isValidPhoneNumber("(123) 456-7890");
/// System.out.println(valid); // true
/// ```
///
/// ## Output Example
/// ```text
/// Is '(123) 456-7890' a valid phone number? true
/// Is '1111)555 2345' a valid phone number? false
/// Is '098) 123 4567' a valid phone number? false
/// ```
public class PhoneNumberValidator {

    /// ## isValidPhoneNumber
    ///
    /// Validates whether a given string is a properly formatted phone number.
    ///
    /// ### Expected Format
    /// `(XXX) XXX-XXXX`
    ///
    /// - **Length:** 14 characters  
    /// - **Positions:**
    ///   - `0`: `'('`
    ///   - `1–3`: digits  
    ///   - `4`: `')'`
    ///   - `5`: space `' '`
    ///   - `6–8`: digits  
    ///   - `9`: dash `'-'`
    ///   - `10–13`: digits  
    ///
    /// ### Parameters
    /// - `phoneNumber` — The phone number string to validate.
    ///
    /// ### Returns
    /// - `true` if the phone number matches the correct format.  
    /// - `false` otherwise.
    ///
    /// ### Example
    /// ```java
    /// PhoneNumberValidator.isValidPhoneNumber("(987) 654-3210"); // returns true
    /// PhoneNumberValidator.isValidPhoneNumber("987 654 3210");   // returns false
    /// ```
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

    /// ## main
    ///
    /// Entry point of the program used to test the `isValidPhoneNumber` method.
    ///
    /// It runs several test cases and prints whether each phone number is valid.
    ///
    /// ### Example
    /// ```text
    /// Is '(123) 456-7890' a valid phone number? true
    /// Is '1111)555 2345' a valid phone number? false
    /// Is '098) 123 4567' a valid phone number? false
    /// ```
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
