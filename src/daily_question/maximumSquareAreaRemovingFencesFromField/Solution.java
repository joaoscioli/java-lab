package daily_question.maximumSquareAreaRemovingFencesFromField;

import java.util.*;

/// ## Maximum Square Area by Removing Fences from a Field
///
/// This class solves the problem of finding the **maximum possible square area**
/// that can be formed inside a rectangular field after **removing horizontal
/// and vertical fences**.
///
/// The field has dimensions `m x n`, and fences are placed at discrete
/// positions along both axes.
///
/// ---
///
/// ### Core Idea
/// A valid square can only be formed if there exists:
/// - A **horizontal distance**
/// - A **vertical distance**
/// that are **equal**
///
/// Therefore, the problem reduces to:
/// 1. Computing **all possible distances** between pairs of horizontal fences.
/// 2. Computing **all possible distances** between pairs of vertical fences.
/// 3. Finding the **largest common distance** between the two sets.
///
/// ---
///
/// ### Strategy
/// - Implicitly include the field boundaries (`1` and `m` / `n`) as fences.
/// - Generate all pairwise distances between fence positions.
/// - Use `Set` to remove duplicates and allow efficient lookups.
/// - Select the maximum distance that appears in both dimensions.
///
/// ---
///
/// ### Complexity
/// - **Time Complexity**:
///   - Distance generation: `O(h² + v²)`
///     where `h` is the number of horizontal fences and `v` is the number of
///     vertical fences.
/// - **Space Complexity**:
///   - `O(h² + v²)` for storing all possible distances.
///
/// ---
///
/// ### Notes
/// - If no common side length exists, the method returns `-1`.
/// - `long` is used to prevent overflow during area calculation.
/// - The modulo operation is applied only to the final result.
public class Solution {

    /// Modulo constant used to constrain the final area value.
    private static final long MOD = 1_000_000_007;

    /// Computes the maximum square area that can be formed after removing fences.
    ///
    /// The method evaluates all possible distances between horizontal and vertical
    /// fences and identifies the largest common side length.
    ///
    /// @param m height of the field
    /// @param n width of the field
    /// @param hFences positions of removable horizontal fences
    /// @param vFences positions of removable vertical fences
    /// @return maximum square area modulo {@link #MOD},
    ///         or {@code -1} if no valid square can be formed
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        /// All possible distances between horizontal fences.
        Set<Integer> hDistances = computeDistances(hFences, m);

        /// All possible distances between vertical fences.
        Set<Integer> vDistances = computeDistances(vFences, n);

        long maxSide = -1;

        /// Find the largest common side length.
        for (int d : hDistances) {
            if (vDistances.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }

    /// Computes all possible distances between pairs of fences.
    ///
    /// The method:
    /// 1. Adds the field boundaries (`1` and `limit`) to the fence list.
    /// 2. Sorts all positions.
    /// 3. Computes all positive differences between fence pairs.
    ///
    /// @param fences positions of removable fences
    /// @param limit maximum boundary of the field (height or width)
    /// @return set containing all possible distances
    private Set<Integer> computeDistances(int[] fences, int limit) {

        /// List containing fences and field boundaries.
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int f : fences) list.add(f);
        list.add(limit);

        Collections.sort(list);

        /// Set of unique distances.
        Set<Integer> distances = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                distances.add(list.get(j) - list.get(i));
            }
        }

        return distances;
    }
}
