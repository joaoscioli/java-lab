package daily_question.rotatingBox;

/// Provides a solution for rotating a box 90 degrees clockwise after applying gravity
/// to the stones inside it.
///
/// The box is represented as a 2D character grid where:
///
/// - `'#'` represents a stone.
/// - `'*'` represents a fixed obstacle.
/// - `'.'` represents an empty space.
///
/// Before rotating the box, each row is processed from right to left so that stones
/// fall as far as possible to the right, simulating gravity after the box is rotated.
/// Obstacles remain fixed and reset the available falling position for stones.
///
/// After gravity is applied, the box is rotated 90 degrees clockwise.
///
/// ## Example
///
/// ```java
/// char[][] boxGrid = {
///     {'#', '.', '*', '.'},
///     {'#', '#', '*', '.'}
/// };
///
/// Solution solution = new Solution();
/// char[][] result = solution.rotateTheBox(boxGrid);
/// ```
///
/// The returned matrix represents the final state of the box after rotation and gravity.
class Solution {

    /// Rotates the given box 90 degrees clockwise after applying gravity to the stones.
    ///
    /// The algorithm works in two main steps:
    ///
    /// 1. Apply gravity row by row:
    ///    - Traverse each row from right to left.
    ///    - Move each stone `'#'` to the nearest available empty position on the right.
    ///    - Reset the available position whenever an obstacle `'*'` is found.
    ///
    /// 2. Rotate the updated box:
    ///    - Convert the original `m x n` grid into an `n x m` grid.
    ///    - Map each cell from the original box to its clockwise-rotated position.
    ///
    /// ## Complexity
    ///
    /// Let `m` be the number of rows and `n` be the number of columns.
    ///
    /// - Time complexity: `O(m * n)`, because each cell is visited a constant number of times.
    /// - Space complexity: `O(m * n)`, because a new rotated matrix is created.
    ///
    /// @param boxGrid the original side-view representation of the box
    /// @return a new matrix representing the box after gravity is applied and it is rotated
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            int emptyPosition = n - 1;

            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    emptyPosition = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptyPosition] = '#';
                    emptyPosition--;
                }
            }
        }

        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotated;
    }
}