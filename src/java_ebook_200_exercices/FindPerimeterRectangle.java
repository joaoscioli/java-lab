package java_ebook_200_exercices;

public class FindPerimeterRectangle {
    public static double rectanglePerimeter(double length, double width) throws IllegalArgumentException {
        if (length <= 0.0 || width <= 0.0) {
        }

        // Calculate the perimeter of the rectangle
        return 2.0 * (length + width);
    }

        double length = 5.0;
        double width = 8.0;

        try {
            double perimeter = rectanglePerimeter(length, width);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
