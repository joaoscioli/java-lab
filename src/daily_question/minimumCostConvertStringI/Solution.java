package daily_question.minimumCostConvertStringI;

/// ## Solution
///
/// Provides an algorithm to compute the **minimum total cost** required to convert
/// one string into another using a given set of character transformation rules.
///
/// Each transformation converts one character into another at a specified cost.
/// Transformations can be applied multiple times and can be chained.
///
/// ---
class Solution {

    /// ### minimumCost
    ///
    /// Calculates the minimum cost to convert the `source` string into the `target` string.
    ///
    /// Each position in the string is converted independently, but the cost of converting
    /// a character may involve **multiple intermediate transformations**.
    ///
    /// #### Approach
    /// The problem is modeled as a **directed weighted graph**:
    /// - Each node represents a lowercase letter (`'a'` to `'z'`)
    /// - Each transformation rule represents a directed edge with a weight (cost)
    ///
    /// To find the cheapest conversion between **all pairs of characters**, the
    /// **Floyd–Warshall algorithm** is used.
    ///
    /// #### Algorithm
    /// 1. Initialize a `26 x 26` distance matrix:
    ///    - `dist[i][i] = 0`
    ///    - `dist[i][j] = INF` for `i != j`
    /// 2. Populate the matrix with the direct transformation costs
    /// 3. Run the Floyd–Warshall algorithm to compute minimum costs between all pairs
    /// 4. For each index `i` in the strings:
    ///    - Convert `source[i]` to `target[i]`
    ///    - If no valid transformation exists, return `-1`
    /// 5. Accumulate and return the total cost
    ///
    /// #### Example
    /// ```
    /// source = "abc"
    /// target = "bcd"
    /// transformations:
    /// a -> b (1), b -> c (1), c -> d (1)
    /// output = 3
    /// ```
    ///
    /// #### Time Complexity
    /// - **O(26³ + n)** ≈ **O(n)**, where `n` is the length of the strings
    ///
    /// #### Space Complexity
    /// - **O(26²)** for the distance matrix
    ///
    /// #### Parameters
    /// - `source`: the original string
    /// - `target`: the desired string after conversion
    /// - `original`: array of source characters for transformations
    /// - `changed`: array of target characters for transformations
    /// - `cost`: array of costs corresponding to each transformation
    ///
    /// #### Returns
    /// - The minimum total cost to convert `source` into `target`
    /// - `-1` if at least one character conversion is impossible
    ///
    /// @param source the original string
    /// @param target the target string
    /// @param original the characters to be transformed
    /// @param changed the resulting characters after transformation
    /// @param cost the cost associated with each transformation
    /// @return the minimum total conversion cost, or -1 if impossible
    ///
    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {
        final int INF = Integer.MAX_VALUE / 2;

        int[][] dist = new int[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if (dist[from][to] == INF) {
                return -1;
            }

            totalCost += dist[from][to];
        }

        return totalCost;
    }
}
