package java_ebook_200_exercices;

import java.text.DecimalFormat;

public class FormatNumbersCurrencyString {
    public static void main(String[] args) {
        // Example number
        double amount = 1234567.89;

        // Format as currency string with thousands separators
        String formattedAmount = formatCurrency(amount);

        // Display the formatted currency string
        System.out.println("Formatted Amount: " + formattedAmount);

    }

    // Function to format the number as a currency string
    public static String formatCurrency(double amount) {
        // Create a DecimalFormat instance for currency formatting
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        return formatter.format(amount);
    }
}

/*
Formatted Amount: $1,234,567.89
*/
