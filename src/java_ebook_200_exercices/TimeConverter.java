package java_ebook_200_exercices;

public class TimeConverter {
    // Method to convert total minutes to hours and minutes
    public static String convertMinutesToHoursAndMinutes(int totalMinutes) {
        // Calculate hours and remaining minutes
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        // Construct the result string
        return hours + " hours and " + minutes + " minutes";
    }

    public static void main(String[] args) {
        int totalMinutes = 135;
        String convertedTime = convertMinutesToHoursAndMinutes(totalMinutes);
        System.out.println(totalMinutes + " minutes is equivalent to: " + convertedTime);
    }
}

// Output:
// 135 minutes is equivalent to: 2 hours and 15 minutes
