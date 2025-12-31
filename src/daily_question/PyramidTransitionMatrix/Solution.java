package daily_question.PyramidTransitionMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// # Pyramid Transition Matrix Solver
///
/// Implements a solution to the *Pyramid Transition Matrix* problem.
/// Given a bottom row of blocks and a list of allowed patterns,
/// determines whether it is possible to build a pyramid up to a single block.
///
/// The algorithm works by:
/// - Mapping each valid pair of characters to all possible upper characters.
/// - Recursively attempting to build each next row using DFS + backtracking.
///
/// ## Example
/// ```java
/// Solution s = new Solution();
/// boolean possible = s.pyramidTransition("BCD", List.of("BCG", "CDE", "GEA", "FFF"));
/// ```
///
/// ## Time Complexity
/// Worst case exponential, due to backtracking exploration.
///
/// ## Space Complexity
/// Also exponential in the worst case, depending on the branching factor.
public class Solution {

    /// Stores allowed transitions in the form:
    /// - Key: two-character base string (e.g., `"AB"`)
    /// - Value: list of possible top characters (e.g., `['C','D']`)
    private Map<String, List<Character>> map = new HashMap<>();

    /// Determines whether a pyramid can be built from the given bottom
    /// using the allowed transition patterns.
    ///
    /// ## Parameters
    /// - `bottom`: the string representing the bottom row.
    /// - `allowed`: list of 3-character strings where:
    ///   - first 2 chars form the base pair,
    ///   - last char is the block that goes above.
    ///
    /// ## Returns
    /// `true` if the pyramid can be built up to height 1; otherwise `false`.
    ///
    /// ## Example
    /// ```java
    /// solution.pyramidTransition("ABC", List.of("ABD", "BCE", "DEF"));
    /// ```
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String pattern : allowed) {
            String key = pattern.substring(0, 2);
            char value = pattern.charAt(2);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
        return dfs(bottom);
    }

    /// Executes a depth-first search attempting to build the pyramid
    /// until reaching a row of length 1.
    ///
    /// ## Parameters
    /// - `row`: the current row being processed.
    ///
    /// ## Returns
    /// `true` if a complete pyramid can be formed from this row.
    private boolean dfs(String row) {
        if (row.length() == 1) {
            return true;
        }
        return buildNextRow(row, 0, new StringBuilder());
    }

    /// Attempts to build the next row above the current one by exploring
    /// all valid transitions for each adjacent pair of characters.
    ///
    /// Uses DFS + backtracking to try all combinations.
    ///
    /// ## Parameters
    /// - `row`: the current row of the pyramid.
    /// - `index`: the current position inside the row.
    /// - `nextRow`: a StringBuilder accumulating the next row's characters.
    ///
    /// ## Returns
    /// `true` if a valid continuation of the pyramid is possible.
    private boolean buildNextRow(String row, int index, StringBuilder nextRow) {

        /// When the next row is complete, recursively try to continue the pyramid.
        if (index == row.length() - 1) {
            return dfs(nextRow.toString());
        }

        String key = row.substring(index, index + 2);

        /// If no allowed pattern exists for this pair, the path is invalid.
        if (!map.containsKey(key)) {
            return false;
        }

        /// Try each possible character for this base pair.
        for (char c : map.get(key)) {
            nextRow.append(c);

            if (buildNextRow(row, index + 1, nextRow)) {
                return true; // Found a valid pyramid path
            }

            /// Backtracking step
            nextRow.deleteCharAt(nextRow.length() - 1);
        }

        return false;
    }
}
