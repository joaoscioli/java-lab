package leetcode_challenges.challengerTwo;

/// ## Solution
///
/// Provides an implementation for the **Add Two Numbers** problem.
///
/// Two non-negative integers are represented as linked lists,
/// where each node contains a single digit and the digits are stored
/// in **reverse order**.
///
/// The method adds the two numbers and returns the sum
/// as a linked list, also in reverse order.
public class Solution {

    /// ### addTwoNumbers
    ///
    /// Adds two numbers represented by linked lists.
    ///
    /// Each linked list stores digits in reverse order,
    /// meaning the least significant digit comes first.
    ///
    /// #### Algorithm
    /// 1. Use a **dummy head node** to simplify list construction.
    /// 2. Traverse both linked lists simultaneously.
    /// 3. Add corresponding digits along with a carry value.
    /// 4. Create a new node for each resulting digit.
    /// 5. Continue until both lists and the carry are fully processed.
    ///
    /// #### Key Points
    /// - Handles lists of different lengths.
    /// - Properly propagates carry values.
    /// - Does not modify the input lists.
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(max(n, m))`
    /// - **Space Complexity:** `O(max(n, m))`
    ///
    /// #### Example
    /// ```text
    /// Input:
    /// l1 = [2 -> 4 -> 3]
    /// l2 = [5 -> 6 -> 4]
    ///
    /// Output:
    /// [7 -> 0 -> 8]
    ///
    /// Explanation:
    /// 342 + 465 = 807
    /// ```
    ///
    /// @param l1 the first number represented as a linked list
    /// @param l2 the second number represented as a linked list
    /// @return the sum of the two numbers as a linked list
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy head node simplifies result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Continue while there are remaining digits or a carry value
        while (l1 != null || l2 != null || carry != 0) {

            // Extract values from current nodes (or 0 if null)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Compute sum and update carry
            int sum = x + y + carry;
            carry = sum / 10;
            int digit = sum % 10;

            // Append the resulting digit as a new node
            current.next = new ListNode(digit);
            current = current.next;

            // Advance input list pointers if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the head of the resulting linked list
        return dummy.next;
    }
}
