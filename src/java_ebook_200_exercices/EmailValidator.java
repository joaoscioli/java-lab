package java_ebook_200_exercices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    // Method to validate the email address
    public static boolean validateEmail(String email) {
        // Regular expression to validate the email address
        String regex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        // Match the email against the regular expression
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    void main() {
        // Example usage
        String emailToValidate = "example@example.com";
        if (validateEmail(emailToValidate)) {
            // Output: Email is valid
            System.out.println("Email is valid");
        } else {
            // Output: Email is not valid
            System.out.println("Email is not valid");
        }
    }
}
