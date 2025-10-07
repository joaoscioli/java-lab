package java_ebook_200_exercices;

import java.util.HashSet;

/// # MiniSudoku
///
/// A utility class that validates whether a 3x3 grid represents a valid **mini Sudoku**.
///
/// In a valid mini Sudoku:
/// - The grid must be exactly **3x3**.
/// - Each number must be an **integer between 1 and 9**.
/// - No number can be **repeated** within the grid.
///
/// ---
/// ## Example
/// ```java
    /// int[][] validSudoku = {
    ///     {1, 3, 2},
    ///     {9, 7, 8},
    ///     {4, 5, 6}
    /// };
    ///
    /// boolean result = MiniSudoku.isMiniSudoku(validSudoku);
    /// System.out.println(result); // true
    /// ```
///
/// ---
/// @since 1.0
/// @author Great Designer Software

public class MiniSudoku {
        /// ## isMiniSudoku
        ///
        /// Validates whether a given 3x3 integer matrix represents a valid mini Sudoku grid.
        ///
        /// The method checks:
        /// 1. Whether the grid has exactly **3 rows and 3 columns**.
        /// 2. Whether **all numbers** are in the range **1–9**.
        /// 3. Whether **no duplicates** appear in the grid.
        ///
        /// ---
        /// ## Parameters
        /// - `square` — a 2D integer array representing the 3x3 Sudoku grid.
        ///
        /// ## Returns
        /// - `true` — if the grid is a valid mini Sudoku.
        /// - `false` — if the grid size is invalid, contains out-of-range numbers, or has duplicates.
        ///
        /// ## Throws
        /// This method does **not** throw checked exceptions, but it returns `false` for any invalid structure.
        ///
        /// ## Example
        /// ```java
        /// int[][] sudoku = {
        ///     {1, 2, 3},
        ///     {4, 5, 6},
        ///     {7, 8, 9}
        /// };
        ///
        /// boolean isValid = MiniSudoku.isMiniSudoku(sudoku);
        /// System.out.println(isValid); // true
        /// ```
        ///
        /// ---
        /// @param square the 3x3 grid to validate.
        /// @return true if the grid represents a valid mini Sudoku; false otherwise.
        public static boolean isMiniSudoku(int[][] square) {
            HashSet<Integer> seen = new HashSet<>();

            // Check if the grid is 3x3
            if (square.length != 3 || square[0].length != 3) {
                return false; // Invalid size
            }

            for (int[] row : square) {
                for (int num : row) {
                    // Check if the number is within the valid range (1-9)
                    if (num < 1 || num > 9) {
                        return false;
                    }

                    // Check for duplicates
                    if (!seen.add(num)) {
                        return false;
                    }
                }
            }

            // If all numbers are seen exactly once and are in range, return true
            return true;
        }

        /// ## main
        ///
        /// Demonstrates the functionality of the `isMiniSudoku` method using multiple test grids.
        ///
        /// Prints the validation results for:
        /// - Two **valid** mini Sudoku grids.
        /// - Two **invalid** grids (one with duplicates, one with out-of-range values).
        ///
        /// ---
        /// ## Example Output
        /// ```
        /// isMiniSudoku(validSudoku) = true
        /// isMiniSudoku(invalidSudoku1) = false
        /// isMiniSudoku(invalidSudoku2) = false
        /// isMiniSudoku(validSudoku2) = true
        /// ```
        ///
        /// ---
        /// @param args command-line arguments (not used).
        public static void main(String[] args) {
            int[][] validSudoku = {
                    {1, 3, 2},
                    {9, 7, 8},
                    {4, 5, 6}
            };

            int[][] invalidSudoku1 = {
                    {1, 1, 3},
                    {6, 5, 4},
                    {8, 7, 9}
            };

            int[][] invalidSudoku2 = {
                    {0, 1, 2},
                    {6, 4, 5},
                    {9, 8, 7}
            };

            int[][] validSudoku2 = {
                    {8, 9, 2},
                    {5, 6, 1},
                    {3, 7, 4}
            };

            System.out.println("isMiniSudoku(validSudoku) = " + isMiniSudoku(validSudoku)); // true
            System.out.println("isMiniSudoku(invalidSudoku1) = " + isMiniSudoku(invalidSudoku1)); // false
            System.out.println("isMiniSudoku(invalidSudoku2) = " + isMiniSudoku(invalidSudoku2)); // false
            System.out.println("isMiniSudoku(validSudoku2) = " + isMiniSudoku(validSudoku2)); // true
        }
}
