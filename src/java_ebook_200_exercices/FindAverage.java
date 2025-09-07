package java_ebook_200_exercices;

public class FindAverage {
    public static double findAverage(double num1, double num2) {

        // Calculate the sum of the two numbers
        double total = num1 + num2;

        // Calculate the average by dividing the sum by 2
        return total / 2.0;
    }

    public static void main(String[] args) {
        double number1 = 10.0;
        double number2 = 20.0;
        double result = findAverage(number1, number2);
        System.out.println("The average of " + number1 + " and " + number2 + " is: " + result);
    }
}

// Output:
// The average of 10.0 and 20.0 is: 15.0