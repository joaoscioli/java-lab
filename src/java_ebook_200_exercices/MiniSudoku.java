package java_ebook_200_exercices;

import java.util.HashSet;

public class MiniSudoku {
    // Method to check if the 3x3 grid is a valid mini Sudoku
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

// Output:
// isMiniSudoku(validSudoku) = true
// isMiniSudoku(invalidSudoku1) = false
// isMiniSudoku(invalidSudoku2) = false
// isMiniSudoku(validSudoku2) = true