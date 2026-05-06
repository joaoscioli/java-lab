package daily_question.rotateList;

class Solution {
    /// Rotates a singly linked list to the right by `k` positions.
    ///
    /// The method first handles edge cases where the list is empty, contains only
    /// one node, or does not need to be rotated. It then calculates the length of
    /// the list while also finding the current tail node.
    ///
    /// Since rotating a list by its own length results in the same list, `k` is
    /// reduced using modulo `length`. If the reduced value of `k` is zero, the
    /// original list is returned.
    ///
    /// The algorithm temporarily connects the tail node to the head, forming a
    /// circular linked list. It then finds the new tail after `length - k` steps,
    /// sets the node after it as the new head, and breaks the circle to restore
    /// the list structure.
    ///
    /// ## Example
    ///
    /// ```java
    /// Input:  head = [1, 2, 3, 4, 5], k = 2
    /// Output: [4, 5, 1, 2, 3]
    /// ```
    ///
    /// ## Complexity
    ///
    /// - Time Complexity: `O(n)`, where `n` is the number of nodes in the list.
    /// - Space Complexity: `O(1)`, since the rotation is performed in-place.
    ///
    /// @param head the head node of the singly linked list
    /// @param k the number of positions to rotate the list to the right
    /// @return the new head of the rotated linked list
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;

        if (k == 0) {
            return head;
        }

        tail.next = head;

        int stepsToNewTail = length - k;
        ListNode newTail = tail;

        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}