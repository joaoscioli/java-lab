package daily_question.getBiggestThreeRhombusSumsGrid;

import java.util.TreeSet;

/// ## Get Biggest Three Rhombus Sums in a Grid
///
/// This class provides a solution for computing the **three largest distinct rhombus border sums**
/// within a 2D integer grid.
///
/// A **rhombus** in the grid is defined as a diamond-shaped figure whose corners are aligned
/// with grid cells and whose edges follow the grid's diagonals.
///
/// The rhombus may also have **area 0**, meaning it consists of a single cell.
///
/// ### Approach
///
/// The algorithm enumerates every possible rhombus by:
///
/// 1. Treating every grid cell as a potential **center**.
/// 2. Expanding the rhombus by increasing its **radius `k`** while it remains inside the grid.
/// 3. Computing the **border sum** of the rhombus by traversing its four diagonal edges.
/// 4. Storing each sum inside a `TreeSet` to maintain:
///    - **Distinct values**
///    - **Descending order**
///
/// Finally, the algorithm extracts the **three largest distinct sums**.
///
/// ### Rhombus Geometry
///
/// For a center `(r, c)` and radius `k`:
///
/// - Top vertex: `(r - k, c)`
/// - Right vertex: `(r, c + k)`
/// - Bottom vertex: `(r + k, c)`
/// - Left vertex: `(r, c - k)`
///
/// The border is composed of four diagonal segments:
///
/// - Top → Right
/// - Right → Bottom
/// - Bottom → Left
/// - Left → Top
///
/// ### Complexity
///
/// Let:
///
/// - `m` = number of rows
/// - `n` = number of columns
///
/// **Time Complexity**
///
/// O(m × n × min(m, n)²)
///
/// Each cell is considered as a center and expanded with increasing radius,
/// while the border is computed by traversing its edges.
///
/// **Space Complexity**
///
/// O(1) extra space aside from the set storing at most a few rhombus sums.
///
/// ### Constraints
///
/// - `1 ≤ m, n ≤ 50`
/// - `1 ≤ grid[i][j] ≤ 10⁵`
///
/// The brute-force enumeration remains efficient for these limits.
class Solution {

    /// ### getBiggestThree
    ///
    /// Computes the **three largest distinct rhombus border sums** in the given grid.
    ///
    /// The method iterates over all grid cells as potential rhombus centers and
    /// expands the rhombus radius while the shape remains inside the grid boundaries.
    ///
    /// For each valid rhombus, the border elements are summed and inserted into
    /// a descending `TreeSet` to maintain unique values and sorted order.
    ///
    /// ### Parameters
    ///
    /// - `grid` : A 2D integer matrix representing the grid.
    ///
    /// ### Returns
    ///
    /// An integer array containing up to **three distinct rhombus sums**
    /// in **descending order**. If fewer than three distinct sums exist,
    /// all available sums are returned.
    ///
    /// ### Example
    ///
    /// ```java
    /// Input:
    /// grid = [[1,2,3],
    ///         [4,5,6],
    ///         [7,8,9]]
    ///
    /// Output:
    /// [20, 9, 8]
    /// ```
    ///
    /// Explanation:
    ///
    /// - The largest rhombus border sum is `20`
    /// - The next two largest distinct sums are `9` and `8`
    ///
    /// ### Notes
    ///
    /// - A rhombus with radius `0` consists of a single grid cell.
    /// - Only the **border elements** of a rhombus contribute to its sum.
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]);

                for (int k = 1; r - k >= 0 && r + k < m && c - k >= 0 && c + k < n; k++) {

                    int sum = 0;

                    int x = r - k;
                    int y = c;

                    for (int i = 0; i < k; i++) {
                        sum += grid[x + i][y + i];
                    }

                    for (int i = 0; i < k; i++) {
                        sum += grid[r + i][c + k - i];
                    }

                    for (int i = 0; i < k; i++) {
                        sum += grid[r + k - i][c - i];
                    }

                    for (int i = 0; i < k; i++) {
                        sum += grid[r - i][c - k + i];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];

        int i = 0;
        for (int val : set) {
            res[i++] = val;
            if (i == size) break;
        }

        return res;
    }
}