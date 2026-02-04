package daily_question.minimumCostConvertStringII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/// ## Solution
///
/// This class provides a solution for the problem
/// **Minimum Cost to Convert String II**.
///
/// The task is to convert a `source` string into a `target` string
/// using substring replacement operations with associated costs,
/// minimizing the total cost.
///
/// Each operation allows converting one substring into another,
/// and operations can be chained.
///
/// ### High-Level Approach
///
/// The solution consists of two main phases:
///
/// 1. **Graph Shortest Paths (Floyd–Warshall)**
///    - Each unique substring is treated as a node
///    - Directed edges represent allowed transformations with costs
///    - All-pairs shortest paths compute the minimum transformation cost
///
/// 2. **Dynamic Programming on the Source String**
///    - `dp[i]` represents the minimum cost to convert
///      `source[0..i)` into `target[0..i)`
///    - Transitions consider:
///        - Keeping characters unchanged
///        - Applying valid substring transformations
///
/// ### Time Complexity
///
/// - Floyd–Warshall: `O(M³)`, where `M` is the number of unique substrings
/// - Dynamic Programming: `O(N * M * L)`
///
/// ### Space Complexity
///
/// - `O(M²)` for the distance matrix
/// - `O(N)` for the DP array
class Solution {

    /// A large sentinel value representing infinity.
    private static final long INF = (long) 1e18;

    /// ## minimumCost
    ///
    /// Computes the minimum cost to convert the `source` string
    /// into the `target` string using allowed substring transformations.
    ///
    /// ### Parameters
    /// - `source`: The original string
    /// - `target`: The desired string
    /// - `original`: Array of source substrings
    /// - `changed`: Array of target substrings
    /// - `cost`: Cost associated with each transformation
    ///
    /// ### Returns
    /// - The minimum total cost, or `-1` if conversion is impossible
    ///
    /// ### Algorithm
    ///
    /// 1. Assign a unique ID to each substring appearing in transformations
    /// 2. Build a weighted directed graph of transformations
    /// 3. Run Floyd–Warshall to compute minimum transformation costs
    /// 4. Use DP to compute the minimum cost to transform the full string
    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {

        int n = source.length();

        /// Map each unique substring to a numeric ID
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) id.put(original[i], idx++);
            if (!id.containsKey(changed[i])) id.put(changed[i], idx++);
        }

        int m = idx;

        /// Distance matrix for all-pairs shortest paths
        long[][] dist = new long[m][m];

        /// Initialize distances
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        /// Populate direct transformation costs
        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        /// Floyd–Warshall algorithm
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        /// dp[i] = minimum cost to convert first i characters
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        /// Dynamic programming over the string
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            /// Case 1: characters already match
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            /// Case 2: try all substring transformations
            for (String X : id.keySet()) {
                int len = X.length();
                if (i + len > n) continue;

                if (!matches(source, X, i)) continue;

                int yId = id.getOrDefault(
                        target.substring(i, i + len),
                        -1
                );
                if (yId == -1) continue;

                long cst = dist[id.get(X)][yId];
                if (cst < INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + cst);
                }
            }
        }

        return dp[n] >= INF ? -1 : dp[n];
    }

    /// ## matches
    ///
    /// Checks whether a pattern `p` matches string `s`
    /// starting at index `start`.
    ///
    /// ### Parameters
    /// - `s`: Source string
    /// - `p`: Pattern string
    /// - `start`: Starting index in `s`
    ///
    /// ### Returns
    /// - `true` if `p` matches `s[start..start+len)`
    private boolean matches(String s, String p, int start) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(start + i) != p.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
