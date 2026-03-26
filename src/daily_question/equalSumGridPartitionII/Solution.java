package daily_question.equalSumGridPartitionII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// # Equal Sum Grid Partition II
///
/// Determines whether it is possible to partition a 2D grid into two non-empty
/// connected sections using a single horizontal or vertical cut such that:
///
/// - The sums of both sections are equal, or
/// - The sums can be made equal by removing at most one cell from either section
///
/// The removal must preserve connectivity within the section.
///
/// ## Approach
///
/// The solution combines prefix sums with value-to-position indexing:
///
/// - **Prefix sums**
///   - `prefRow[i]`: sum of elements from row `0` to `i`
///   - `prefCol[j]`: sum of elements from column `0` to `j`
///
/// - **Value indexing**
///   - A map from cell value → list of positions `(i, j)`
///   - Allows O(1) lookup of candidate cells to remove
///
/// - **Cut simulation**
///   - Iterate over all horizontal and vertical cuts
///   - Compute sums of both partitions in O(1)
///   - If sums differ, check if removing a single cell with value = difference
///     is valid and preserves connectivity
///
/// ## Connectivity Rule
///
/// A cell can be removed safely if:
///
/// - The section is at least 2×2 → always safe
/// - The section is 1D (single row or column):
///   - Only removable if the cell lies at the boundary
///
/// ## Time Complexity
///
/// - O(n * m) for preprocessing
/// - O(n + m + k) for cuts, where `k` is the number of matching value positions
///
/// ## Space Complexity
///
/// - O(n * m) for storing value-to-position mappings
///
class Solution {

    /// Checks whether removing a cell at `(i, j)` from the subgrid defined by
    /// `(r1, c1)` to `(r2, c2)` preserves connectivity.
    ///
    /// ### Parameters
    /// - `r1, c1`: top-left corner of the subgrid
    /// - `r2, c2`: bottom-right corner of the subgrid
    /// - `i, j`: position of the cell to remove
    ///
    /// ### Returns
    /// - `true` if the removal keeps the subgrid connected
    /// - `false` otherwise
    private boolean canRemove(int r1, int c1, int r2, int c2, int i, int j) {
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if (rows * cols == 1) return false;

        if (rows == 1) {
            return (j == c1 || j == c2);
        }

        if (cols == 1) {
            return (i == r1 || i == r2);
        }

        return true;
    }

    /// Evaluates whether a valid partition exists in the grid.
    ///
    /// ### Parameters
    /// - `grid`: a 2D matrix of positive integers
    ///
    /// ### Returns
    /// - `true` if a valid partition exists
    /// - `false` otherwise
    ///
    /// ### Strategy
    ///
    /// 1. Build prefix sums for rows and columns
    /// 2. Map each value to its list of positions
    /// 3. Try all horizontal cuts:
    ///    - Compute top and bottom sums
    ///    - If unequal, check if removing one cell fixes it
    /// 4. Try all vertical cuts:
    ///    - Compute left and right sums
    ///    - Apply the same logic
    ///
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[] prefRow = new long[n];
        long[] prefCol = new long[m];

        Map<Long, List<int[]>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long val = 0;
            for (int j = 0; j < m; j++) {
                val += grid[i][j];
                long cellVal = (long) grid[i][j];
                mp.putIfAbsent(cellVal, new ArrayList<>());
                mp.get(cellVal).add(new int[]{i, j});
            }
            prefRow[i] = val + (i > 0 ? prefRow[i - 1] : 0);
        }

        for (int j = 0; j < m; j++) {
            long val = 0;
            for (int i = 0; i < n; i++) {
                val += grid[i][j];
            }
            prefCol[j] = val + (j > 0 ? prefCol[j - 1] : 0);
        }

        long total = prefRow[n - 1];

        for (int i = 0; i < n - 1; i++) {
            long top = prefRow[i];
            long bottom = total - top;

            if (top == bottom) return true;

            long diff = Math.abs(top - bottom);

            if (!mp.containsKey(diff)) continue;

            if (top > bottom) {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (x <= i && canRemove(0, 0, i, m - 1, x, y)) {
                        return true;
                    }
                }
            } else {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (x > i && canRemove(i + 1, 0, n - 1, m - 1, x, y)) {
                        return true;
                    }
                }
            }
        }

        for (int j = 0; j < m - 1; j++) {
            long left = prefCol[j];
            long right = total - left;

            if (left == right) return true;

            long diff = Math.abs(left - right);

            if (!mp.containsKey(diff)) continue;

            if (left > right) {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (y <= j && canRemove(0, 0, n - 1, j, x, y)) {
                        return true;
                    }
                }
            } else {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (y > j && canRemove(0, j + 1, n - 1, m - 1, x, y)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}