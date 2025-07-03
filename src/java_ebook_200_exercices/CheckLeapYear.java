package java_ebook_200_exercices;

public class CheckLeapYear {
    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {

        // Example year to check
        int yearToCheck = 2024;

        // Check if the year is a leap year
        if (isLeapYear(yearToCheck)) {
            System.out.println(yearToCheck + " is a leap year.");
        } else {
            System.out.println(yearToCheck + " is not a leap year.");
        }
    }
}

/*
2024 is a leap year.
*/