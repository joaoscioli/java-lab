package leetcode_challenges.challengerTwo;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // Initialize dummy node to simplify result list construction
      ListNode dummy = new ListNode(0);
      ListNode current = dummy;
      int carry = 0;

      // Continue while there are digits in l1, l2, or carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from l1 and l2, use 0 if node is null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate sum and new carry
            int sum = x + y + carry;
            carry = sum / 10;
            int digit = sum % 10;

            // Create new node with the current digit
            current.next = new ListNode(digit);
            current = current.next;

            // Move to next nodes if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

}
