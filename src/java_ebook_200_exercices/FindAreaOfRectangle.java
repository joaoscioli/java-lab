package java_ebook_200_exercices;

public class FindAreaOfRectangle {
    public static double calculateRectangleArea(double length, double width) {
        // Check if the inputs are valid positive numbers
        if (length <= 0.0 || width <= 0.0) {
            System.out.println("Invalid inputs. Please provide valid positive numbers for length and width.");
            return 0.0;
        }
        // Calculate the area of the rectangle
        return length * width;
    }

    static void main() {
        double rectangleLength = 5.0;
        double rectangleWidth = 8.0;
        double result = calculateRectangleArea(rectangleLength, rectangleWidth);

        System.out.printf("The area of the rectangle with length %.1f and width %.1f is %.2f%n", rectangleLength, rectangleWidth, result);
    }
}

// Output: The area of the rectangle with length 5.0 and width 8.0 is 40.00