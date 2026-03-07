package daily_question.PartitioningIntoMinimumNumberOfDeciBinaryNumbers;

class Solution {

    /// # minPartitions
    ///
    /// Determines the **minimum number of deci-binary numbers**
    /// required to sum up to the given decimal string `n`.
    ///
    /// ## Deci-Binary Numbers
    ///
    /// A **deci-binary number** is a number that:
    ///
    /// - Uses only the digits `0` or `1`
    /// - Has no leading zeros (unless the number itself is `0`)
    ///
    /// Examples:
    ///
    /// ```text
    /// Valid deci-binary numbers:
    /// 0
    /// 1
    /// 10
    /// 101
    ///
    /// Invalid examples:
    /// 2
    /// 12
    /// 203
    /// ```
    ///
    /// The goal is to represent the number `n` as the **sum of the fewest
    /// possible deci-binary numbers**.
    ///
    /// ## Key Insight
    ///
    /// Each deci-binary number contributes **at most 1 per digit position**.
    ///
    /// Therefore:
    ///
    /// - If a digit in `n` is `5`, we need **at least 5 deci-binary numbers**
    ///   contributing `1` in that column to reach the value `5`.
    ///
    /// Because of this constraint, the **minimum number of deci-binary numbers**
    /// required is simply the **largest digit present in `n`**.
    ///
    /// ## Strategy
    ///
    /// 1. Iterate through each character in the string `n`.
    /// 2. Convert the character digit into its integer value.
    /// 3. Track the **maximum digit** encountered.
    /// 4. Return that maximum value.
    ///
    /// ## Time Complexity
    ///
    /// - **O(n)** where `n` is the number of digits in the string.
    ///
    /// Each digit is processed exactly once.
    ///
    /// ## Space Complexity
    ///
    /// - **O(1)** since only a single variable is used to track the maximum digit.
    ///
    /// ## Parameters
    ///
    /// - `n` — A string representing a positive decimal integer.
    ///
    /// ## Returns
    ///
    /// - The minimum number of **deci-binary numbers** needed to sum to `n`.
    ///
    /// ## Example
    ///
    /// ```text
    /// Input:
    /// n = "27346209830709182346"
    ///
    /// Digits: 2,7,3,4,6,2,0,9,8,3,0,7,0,9,1,8,2,3,4,6
    ///
    /// Maximum digit = 9
    ///
    /// Output:
    /// 9
    /// ```
    ///
    /// Explanation:
    ///
    /// At least **9 deci-binary numbers** are required because
    /// the digit `9` appears in the number.
    ///
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
        }

        return maxDigit;
    }
}