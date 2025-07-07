package java_ebook_200_exercices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DisplayCurrentDate {
    public static void main(String[] args) {

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);

        // Display the result
        System.out.println("Current Date: " + formattedDate);
    }
}

/*
Current Date: 09/20/2024
*/
