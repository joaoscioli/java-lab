package java_ebook_200_exercices;

public class ConvertDaysToYearsMonthsDays {
    public static int[] convertDaysToYearsMonthsDays(int days) {
        // Calculate years
        int years = days / 365;

        // Calculate remaining days after years
        int remainingDaysAfterYears = days % 365;

        // Calculate months
        int months = remainingDaysAfterYears / 30;

        // Calculate remaining days after months
        int remainingDaysAfterMonths = remainingDaysAfterYears % 30;
        return new int[] { years, months, remainingDaysAfterMonths };
    }

    public static void main(String[] args) {
        int totalDays = 1000;
        int[] result = convertDaysToYearsMonthsDays(totalDays);
        System.out.printf("%d days is approximately %d years, %d months, and %d days.%n", totalDays, result[0], result[1], result[2]);
    }
}

// Output: 1000 days is approximately 2 years, 9 months, and 0 days.
