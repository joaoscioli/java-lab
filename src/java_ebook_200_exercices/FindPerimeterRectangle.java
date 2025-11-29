public class FindPerimeterRectangle {
	public static double rectanglePerimeter(double length, double width) throws IllegalArgumentException {

	// Check if the inputs are valid numbers
	if (length <= 0.0 || width <= 0.0) {
		throw new IllegalArgumentException("Invalid input. Please provide valid positive numbers.");
	}

	// Calculate the perimeter of the rectangle
	return 2.0 * (length + width);

}

public static void main(String[] args) {
	double length = 5.0;
	double width = 8.0;

	try {
		double perimeter = rectanglePerimeter(length, width);
		System.out.println("The perimeter of the rectangle is: " + perimeter);
	} catch (IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}
	}
}

// Output:
// The perimeter of the rectangle is: 26.0