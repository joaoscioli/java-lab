package leetcode_challenges.challengerSix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /// # Zigzag Conversion
    ///
    /// Given a string `s` and an integer `numRows`, the goal is to write the characters
    /// of the string in a zigzag pattern across multiple rows, and then read the result
    /// line by line.
    ///
    /// This problem corresponds to **LeetCode #6 - Zigzag Conversion**.
    ///
    /// ---
    ///
    /// ## Example
    /// ```java
    /// Input: s = "PAYPALISHIRING", numRows = 3
    /// Output: "PAHNAPLSIIGYIR"
    /// Explanation:
    /// P   A   H   N
    /// A P L S I I G
    /// Y   I   R
    /// ```
    ///
    /// ---
    ///
    /// ## Algorithm
    /// 1. If `numRows` is 1, return the original string, since no zigzag can be formed.
    /// 2. Create a list of `StringBuilder` objects, one for each row.
    /// 3. Traverse each character of the string, appending it to the corresponding row:
    ///     - Move **down** the rows until reaching the last row.
    ///     - Then move **up** until reaching the first row.
    /// 4. Concatenate all rows into a single result string.
    ///
    /// ---
    ///
    /// ## Complexity
    /// - **Time complexity:** `O(n)`, where `n` is the length of the input string.
    /// - **Space complexity:** `O(n)`, since each character is stored once in the list of rows.
    ///
    /// ---
    ///
    /// ## Parameters
    /// - `s` — The input string to be converted.
    /// - `numRows` — The number of rows to use in the zigzag pattern.
    ///
    /// ## Returns
    /// - A string representing the zigzag conversion of the input.
    ///
    /// ---
    ///
    /// ## See Also
    /// - [LeetCode Problem #6: Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/)
    ///
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
