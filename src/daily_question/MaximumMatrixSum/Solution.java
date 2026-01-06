package daily_question.MaximumMatrixSum;

import java.io.IO;

/**
 * /// # Solution
 * ///
 * /// This class provides a solution to the problem
 * /// **"Maximum Matrix Sum"**.
 * ///
 * /// The goal is to maximize the sum of all elements in a matrix after
 * /// performing any number of operations that allow changing the sign
 * /// of elements according to the problem rules.
 */
public class Solution {

    /**
     * /// ## maxMatrixSum
     * ///
     * /// Computes the **maximum possible sum** of all elements in the matrix.
     * ///
     * /// ### Key Insight
     * /// - The sum is maximized when all values are positive.
     * /// - If the number of negative elements is **even**, all values can
     * ///   effectively be made positive.
     * /// - If the number of negative elements is **odd**, exactly one value
     * ///   must remain negative, so we subtract twice the smallest absolute
     * ///   value from the total.
     * ///
     * /// ### Algorithm
     * /// 1. Sum the absolute values of all elements
     * /// 2. Count how many values are negative
     * /// 3. Track the minimum absolute value
     * /// 4. Adjust the result if the number of negatives is odd
     * ///
     * /// ### Time Complexity
     * /// - **O(m × n)** where `m` is the number of rows and `n` is the number of columns
     * ///
     * /// ### Space Complexity
     * /// - **O(1)** (constant extra space)
     * ///
     * /// ### Example
     * /// ```text
     * /// Input:  [[1, -1], [-1, 1]]
     * /// Output: 4
     * /// ```
     *
     * /// @param matrix a 2D integer array representing the matrix
     * /// @return the maximum achievable sum of the matrix elements
     */
    public long maxMatrixSum(int[][] matrix) {
        long totalAbs = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                totalAbs += Math.abs(val);
                if (val < 0) {
                    negativeCount++;
                }
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        if (negativeCount % 2 == 0) {
            return totalAbs;
        }

        return totalAbs - 2L * minAbs;
    }

    /**
     * /// ## main
     * ///
     * /// Demonstrates the usage of the {@link #maxMatrixSum(int[][])} method.
     * ///
     * /// It initializes a sample matrix and prints the maximum
     * /// matrix sum to the console.
     */
    void main() {
        int[][] matrix = {{1, -1}, {-1, 1}};
        IO.println(maxMatrixSum(matrix));
    }
}
