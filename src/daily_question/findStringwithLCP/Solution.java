package daily_question.findStringwithLCP;

/// # Find the String with LCP
///
/// This class provides a solution to reconstruct the lexicographically smallest
/// string from a given LCP (Longest Common Prefix) matrix.
///
/// ## Problem Overview
///
/// Given an `n x n` matrix `lcp`, where:
/// - `lcp[i][j]` represents the length of the longest common prefix between
///   substrings `word[i..n-1]` and `word[j..n-1]`,
///
/// The goal is to reconstruct the **lexicographically smallest string** that
/// satisfies this matrix. If no such string exists, return an empty string.
///
/// ## Approach
///
/// The solution consists of four main steps:
///
/// ### 1. Validate Input Matrix
/// - Ensure diagonal values satisfy: `lcp[i][i] == n - i`
/// - Ensure symmetry: `lcp[i][j] == lcp[j][i]`
///
/// ### 2. Group Indices (Union-Find)
/// - If `lcp[i][j] > 0`, then characters at `i` and `j` must be equal
/// - Use Disjoint Set Union (DSU) to group such indices
///
/// ### 3. Assign Characters
/// - Assign the smallest possible character (`'a'`, `'b'`, ...) to each group
/// - Ensures lexicographically smallest result
///
/// ### 4. Validate Constructed String
/// - Recompute LCP matrix from the constructed string
/// - Compare with input matrix
///
/// ## Time Complexity
/// - `O(n^2)`
///
/// ## Space Complexity
/// - `O(n^2)` for LCP reconstruction
///
class Solution {

    /// Reconstructs the lexicographically smallest string that matches the given LCP matrix.
    ///
    /// @param lcp A 2D matrix where lcp[i][j] is the longest common prefix length
    ///            between substrings starting at indices i and j.
    /// @return The smallest valid string, or an empty string if reconstruction is impossible.
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Validate diagonal and symmetry constraints
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        // Step 2: Initialize Union-Find structure
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Merge indices that must have the same character
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(parent, i, j);
                }
            }
        }

        // Step 3: Assign characters to each group
        char[] res = new char[n];
        int[] map = new int[n];
        for (int i = 0; i < n; i++) map[i] = -1;

        char cur = 'a';

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (map[root] == -1) {
                // If more than 26 groups are needed, it's impossible
                if (cur > 'z') return "";
                map[root] = cur++;
            }
            res[i] = (char) map[root];
        }

        // Step 4: Recompute LCP matrix from constructed string
        int[][] calc = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    calc[i][j] = 1;
                    if (i + 1 < n && j + 1 < n) {
                        calc[i][j] += calc[i + 1][j + 1];
                    }
                }
            }
        }

        // Validate reconstructed LCP matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (calc[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(res);
    }

    /// Finds the representative (root) of a set using path compression.
    ///
    /// @param parent The parent array of the DSU structure.
    /// @param x The element whose root is to be found.
    /// @return The root of the set containing x.
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    /// Unions two sets in the DSU structure.
    ///
    /// @param parent The parent array of the DSU structure.
    /// @param a First element.
    /// @param b Second element.
    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}