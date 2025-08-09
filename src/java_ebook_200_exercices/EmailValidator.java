package java_ebook_200_exercices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 /// # EmailValidator
 ///
 /// Utility class for validating email addresses using regular expressions.
 ///
 /// ## Overview
 /// This class provides a static method to check if a given string
 /// follows a valid email address format.
 /// The validation is based on a simple regex pattern:
 /// - Ensures there are no spaces.
 /// - Requires an `@` symbol separating the local part from the domain.
 /// - Requires a dot (`.`) in the domain part.
 ///
 /// ## Example Output
 /// ```text
 /// Email is valid
 /// ```
 ///
 */
public class EmailValidator {

    /**
     /// ## validateEmail
     ///
     /// Validates an email address using a regular expression.
     ///
     /// ### Parameters
     /// - `email`: The email address to be validated as a `String`.
     ///
     /// ### Returns
     /// - `true` if the email matches the regex pattern.
     /// - `false` otherwise.
     ///
     /// ### Regex Used
     /// ```regex
     /// ^[^\s@]+@[^\s@]+\.[^\s@]+$
     /// ```
     /// - `^[^\s@]+` → Ensures the local part has at least one non-space character and no `@`.
     /// - `@` → Mandatory separator between local part and domain.
     /// - `[^\s@]+` → Domain name without spaces or `@`.
     /// - `\.` → Literal dot before TLD.
     /// - `[^\s@]+$` → TLD without spaces or `@`.
     ///
     /// ### Example
     /// ```java
     /// boolean isValid = EmailValidator.validateEmail("test@example.com");
     /// // Returns: true
     /// ```
     */
    public static boolean validateEmail(String email) {
        String regex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     /// ## main
     ///
     /// Demonstrates the usage of the `validateEmail` method.
     ///
     /// ### Example
     /// ```java
     /// EmailValidator validator = new EmailValidator();
     /// validator.main();
     /// // Output: Email is valid
     /// ```
     */
    void main() {
        String emailToValidate = "example@example.com";

        if (validateEmail(emailToValidate)) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email is not valid");
        }
    }
}
