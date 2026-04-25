package daily_question.furthestPointFromOrigin;

class Solution {

    /// ## Furthest Distance From Origin
    ///
    /// Calculates the maximum possible distance from the origin (0) on a number line
    /// after performing a sequence of moves.
    ///
    /// The input string consists of:
    /// - `'L'` → move left (-1)
    /// - `'R'` → move right (+1)
    /// - `'_'` → can be either left or right (chosen optimally)
    ///
    /// ### Strategy
    ///
    /// The method counts:
    /// - Number of `'L'` moves
    /// - Number of `'R'` moves
    /// - Number of `'_'` (flexible moves)
    ///
    /// Then it evaluates both extreme scenarios:
    ///
    /// - Assign all `'_'` moves to the right:
    ///   - Position = `R + blank - L`
    ///
    /// - Assign all `'_'` moves to the left:
    ///   - Position = `L + blank - R`
    ///
    /// The result is the maximum absolute distance from the origin.
    ///
    /// ### Parameters
    ///
    /// - `moves` — A string representing the sequence of moves.
    ///
    /// ### Returns
    ///
    /// - `int` — The maximum possible distance from the origin.
    ///
    /// ### Example
    ///
    /// ```java
    /// Input: moves = "L_RL_"
    /// Output: 3
    /// ```
    ///
    /// ### Complexity
    ///
    /// - Time: `O(n)` — Iterates through the string once.
    /// - Space: `O(1)` — Uses constant extra space.
    ///
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0, R = 0, blank = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') L++;
            else if (c == 'R') R++;
            else blank++;
        }

        int right = R + blank - L;
        int left = L + blank - R;

        return Math.max(Math.abs(right), Math.abs(left));
    }
}