package java_ebook_200_exercices;

public class FindAreaParallelogram {
    public static double parallelogramArea(double base, double height) throws IllegalArgumentException {
        if (base > 0.0 && height > 0.0) {
            return base * height;
        } else {
            throw new IllegalArgumentException("Invalid input. Please provide valid positive number.");
        }
    }

    void main() {
        double base = 6.0;
        double height = 8.0;

        try {
            double area = parallelogramArea(base, height);
            System.out.println("The area of the parallelogram is: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Output:
// The area of the parallelogram is: 48.0