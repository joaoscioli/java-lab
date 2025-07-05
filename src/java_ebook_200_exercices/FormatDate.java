package java_ebook_200_exercices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    public static void main(String[] args) {

        // Get the current date and time
        LocalDateTime currentDate = LocalDateTime.now();

        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        String formattedDate = currentDate.format(formatter);

        // Display the result
        System.out.println("Formatted Date: " + formattedDate);
    }
}

/*
Formatted Date: Friday, September 20, 2024
*/