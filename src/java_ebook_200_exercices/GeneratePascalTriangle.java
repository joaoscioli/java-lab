package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalTriangle {

    /// ## generatePascalsTriangle
    ///
    /// Generates **Pascal’s Triangle** with the specified number of rows.
    ///
    /// Pascal’s Triangle is a triangular array of integers where:
    /// - The first and last values of each row are always **1**.
    /// - Every other value is the sum of the two values directly above it
    ///   (from the previous row).
    ///
    /// ### Parameters
    /// - `numRows` — The total number of rows to generate.
    ///
    /// ### Returns
    /// A `List<List<Integer>>` where each inner list represents one row of
    /// Pascal’s Triangle.
    ///
    /// ### Example
    /// ```java
    /// generatePascalsTriangle(5);
    /// ```
    ///
    /// Output:
    /// ```
    /// [1]
    /// [1, 1]
    /// [1, 2, 1]
    /// [1, 3, 3, 1]
    /// [1, 4, 6, 4, 1]
    /// ```
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // Initialize the first row
        triangle.add(new ArrayList<>());
        triangle.getFirst().add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element

            // Compute inner values based on previous row
            List<Integer> prevRow = triangle.get(i - 1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // Last element
            triangle.add(row);
        }

        return triangle;
    }

    /// ## main
    ///
    /// Demonstrates the usage of `generatePascalsTriangle` by generating
    /// and printing a Pascal’s Triangle with 5 rows.
    void main() {
        int numberOfRows = 5;
        List<List<Integer>> triangle = generatePascalsTriangle(numberOfRows);
        System.out.printf("Pascal's Triangle with " + numberOfRows + " rows\n");

        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
