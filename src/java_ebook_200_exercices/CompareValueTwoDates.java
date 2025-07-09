package java_ebook_200_exercices;

import java.time.LocalDate;

public class CompareValueTwoDates {
    public static void main(String[] args) {

        // Parse the example dates
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 1, 1);

        // Compare dates
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is earlier than " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is later than " + date2);
        } else {
            System.out.println(date1 + " is equal to " + date2);
        }
    }
}

/*
2022-01-01 is earlier than 2023-01-01
*/
