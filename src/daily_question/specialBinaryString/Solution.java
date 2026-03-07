package daily_question.specialBinaryString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    /// # makeLargestSpecial
    ///
    /// Returns the lexicographically largest **special binary string**
    /// that can be obtained from the given string `s`.
    ///
    /// ## Special Binary String
    ///
    /// A string is considered **special** when:
    ///
    /// - It contains the same number of `1`s and `0`s.
    /// - At any prefix of the string, the number of `1`s is **greater than or equal to** the number of `0`s.
    ///
    /// This definition is analogous to **balanced parentheses**, where:
    ///
    /// - `1` represents an opening parenthesis `(`
    /// - `0` represents a closing parenthesis `)`
    ///
    /// ## Strategy
    ///
    /// The algorithm works using a **divide-and-conquer recursive approach**:
    ///
    /// 1. Iterate through the string while tracking a balance counter.
    /// 2. Whenever the counter returns to `0`, a valid **special substring** is identified.
    /// 3. Extract the inner portion of that substring.
    /// 4. Recursively optimize the inner substring.
    /// 5. Wrap the optimized result again with `1` and `0`.
    /// 6. Store all generated substrings.
    /// 7. Sort the substrings in **reverse lexicographical order**.
    /// 8. Concatenate them to form the largest possible special string.
    ///
    /// ## Why Sorting Works
    ///
    /// Since each substring is itself a valid special binary string,
    /// arranging them in descending lexicographical order guarantees
    /// the final string is the largest possible configuration.
    ///
    /// ## Time Complexity
    ///
    /// - Worst case: **O(n²)** due to recursion and substring operations.
    ///
    /// ## Space Complexity
    ///
    /// - **O(n)** for recursion stack and substring storage.
    ///
    /// ## Parameters
    ///
    /// - `s` — A valid special binary string.
    ///
    /// ## Returns
    ///
    /// - The lexicographically largest special binary string obtainable
    ///   by rearranging its special substrings.
    ///
    /// ## Example
    ///
    /// ```text
    /// Input:  "11011000"
    /// Output: "11100100"
    /// ```
    ///
    /// Explanation:
    ///
    /// The string can be decomposed into special substrings,
    /// optimized recursively, and then rearranged in descending order
    /// to produce the largest possible result.
    ///
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;

            if (count == 0) {
                String inner = s.substring(start + 1, i);
                String optimizedInner = makeLargestSpecial(inner);
                parts.add("1" + optimizedInner + "0");
                start = i + 1;
            }
        }

        parts.sort(Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}