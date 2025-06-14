package java_ebook_200_exercices;

import java.text.DecimalFormat;

/// # FormatNumbersCurrencyString
/// Demonstrates how to format a numeric value as a currency string with thousands separators using `DecimalFormat`.
///
/// ## Description
/// This program:
/// - Takes a numeric value (`double`)
/// - Uses `DecimalFormat` to convert it into a formatted string with thousands separators and two decimal places
/// - Displays the formatted result as a currency string (e.g., `$1,234,567.89`)
///
/// ## Output Example
/// ```text
/// Formatted Amount: $1,234,567.89
/// ```
public class FormatNumbersCurrencyString {

    /// Program entry point.
    ///
    /// Defines a numeric amount and prints it formatted as a currency string using the `formatCurrency()` method.
    public static void main(String[] args) {
        // Example number
        double amount = 1234567.89;

        // Format as currency string with thousands separators
        String formattedAmount = formatCurrency(amount);

        // Display the formatted currency string
        System.out.println("Formatted Amount: " + formattedAmount);
    }

    /// Formats a `double` value as a currency string using U.S. style formatting.
    ///
    /// @param amount the numeric value to format
    /// @return the formatted string (e.g., `$1,234.56`)
    ///
    /// Uses the pattern `$#,###.00` to ensure:
    /// - Dollar sign prefix
    /// - Commas for thousands
    /// - Two decimal places
    public static String formatCurrency(double amount) {
        // Create a DecimalFormat instance for currency formatting
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        return formatter.format(amount);
    }
}
