package leetcode_challenges.challengerTwenty;

import java.util.Arrays;
import java.util.Stack;

/// # Valid Parentheses
///
/// Determines whether a given string containing only parentheses characters
/// is **valid**.
///
/// A string is considered valid if:
///
/// - Open brackets are closed by the same type of brackets.
/// - Open brackets are closed in the correct order.
/// - Every closing bracket has a corresponding opening bracket.
///
/// ## Algorithm
///
/// The solution uses a **stack-based approach** to track opening brackets.
///
/// Steps:
///
/// 1. Iterate through each character in the string.
/// 2. If the character is an **opening bracket** (`(`, `{`, `[`):
///    - Push it onto the stack.
/// 3. If the character is a **closing bracket** (`)`, `}`, `]`):
///    - Check if the stack is empty.
///      - If it is empty, the string is invalid.
///    - Pop the top element from the stack.
///    - Verify that it matches the corresponding opening bracket.
///      - If it does not match, the string is invalid.
/// 4. After processing all characters:
///    - If the stack is empty, the string is valid.
///    - Otherwise, unmatched opening brackets remain.
///
/// ## Time Complexity
///
/// - **O(n)** — Each character is processed exactly once.
///
/// ## Space Complexity
///
/// - **O(n)** — In the worst case, all characters may be stored in the stack.
///
/// ## Example
///
/// ```java
/// String s = "()[]{}";
/// boolean result = new Solution().isValid(s);
/// // result = true
/// ```
///
/// ```java
/// String s = "(]";
/// boolean result = new Solution().isValid(s);
/// // result = false
/// ```
///
/// ## Parameters
///
/// - `s` — A string containing only the characters `(`, `)`, `{`, `}`, `[` and `]`.
///
/// ## Returns
///
/// - `true` if the string contains **valid and properly nested parentheses**.
/// - `false` otherwise.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}