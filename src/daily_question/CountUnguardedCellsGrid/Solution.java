package daily_question.CountUnguardedCellsGrid;

/**
 * /// # Solution
 * ///
 * /// This class provides an efficient solution to the problem
 * /// **"Count Unguarded Cells in the Grid"**.
 * ///
 * /// The grid contains:
 * /// - Guards, who can observe cells in four directions
 * /// - Walls, which block the line of sight
 * /// - Empty cells, which may or may not be guarded
 * ///
 * /// A cell is considered **guarded** if at least one guard can see it
 * /// horizontally or vertically without a wall blocking the view.
 */
public class Solution {

    /**
     * /// ## countUnguarded
     * ///
     * /// Counts the number of **unguarded cells** in an `m x n` grid.
     * ///
     * /// ### Cell Representation
     * /// | Value | Meaning |
     * /// |------:|---------|
     * /// | `0` | Empty cell (unguarded) |
     * /// | `1` | Guard |
     * /// | `2` | Wall |
     * /// | `3` | Guarded cell |
     * ///
     * /// ### Algorithm
     * /// 1. Initialize the grid and mark guards and walls
     * /// 2. Sweep each row:
     * ///    - Left → Right
     * ///    - Right → Left
     * /// 3. Sweep each column:
     * ///    - Top → Bottom
     * ///    - Bottom → Top
     * /// 4. Mark cells that are visible by guards
     * /// 5. Count remaining unguarded cells
     * ///
     * /// ### Why Multiple Passes?
     * /// Guards can see in all four directions. Each sweep ensures
     * /// visibility is correctly propagated until blocked by a wall.
     * ///
     * /// ### Time Complexity
     * /// - **O(m × n)**
     * ///
     * /// ### Space Complexity
     * /// - **O(m × n)** for the grid
     * ///
     * /// ### Example
     * /// ```text
     * /// m = 4, n = 6
     * /// guards = [[0,0],[1,1],[2,3]]
     * /// walls  = [[0,1],[2,2],[1,4]]
     * /// ```
     *
     * /// @param m the number of rows in the grid
     * /// @param n the number of columns in the grid
     * /// @param guards positions of guards in the grid
     * /// @param walls positions of walls in the grid
     * /// @return the number of unguarded cells
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }

        // Mark walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        // Sweep rows (left → right and right → left)
        for (int i = 0; i < m; i++) {
            boolean canSee = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    canSee = false;
                } else if (grid[i][j] == 1) {
                    canSee = true;
                } else if (canSee && grid[i][j] == 0) {
                    grid[i][j] = 3;
                }
            }

            canSee = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 2) {
                    canSee = false;
                } else if (grid[i][j] == 1) {
                    canSee = true;
                } else if (canSee && grid[i][j] == 0) {
                    grid[i][j] = 3;
                }
            }
        }

        // Sweep columns (top → bottom and bottom → top)
        for (int j = 0; j < n; j++) {
            boolean canSee = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 2) {
                    canSee = false;
                } else if (grid[i][j] == 1) {
                    canSee = true;
                } else if (canSee && grid[i][j] == 0) {
                    grid[i][j] = 3;
                }
            }

            canSee = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 2) {
                    canSee = false;
                } else if (grid[i][j] == 1) {
                    canSee = true;
                } else if (canSee && grid[i][j] == 0) {
                    grid[i][j] = 3;
                }
            }
        }

        // Count unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguarded++;
                }
            }
        }

        return unguarded;
    }
}
