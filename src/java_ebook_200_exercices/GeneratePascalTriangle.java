package java_ebook_200_exercices;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalTriangle {
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
            row.add(1); // First element of each row is 1

            // Compute the values based on the previous row
            List<Integer> prevRow = triangle.get(i-1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1); // Last element of each row is 1
            triangle.add(row);
        }
        return triangle;
    }
    void main() {
        int numberOfRows = 5;
        List<List<Integer>> triangle = generatePascalsTriangle(numberOfRows);
        System.out.printf("Pascal's Triangle with " + numberOfRows + " rows");

        for(List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}

// Output:
// Pascal's Triangle with 5 rows:
// [1]
// [1,1]
// [1,2,1]
// [1,3,3,1]
// [1,4,6,4,1]

