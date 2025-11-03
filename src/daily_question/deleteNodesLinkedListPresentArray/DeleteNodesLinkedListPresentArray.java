package daily_question.deleteNodesLinkedListPresentArray;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesLinkedListPresentArray {

    /// ## `modifierList(int[] nums, ListNode head)`
    ///
    /// Removes nodes from a linked list whose values are present in the given array `nums`.
    ///
    /// This method efficiently deletes nodes by:
    /// 1. Storing the elements of `nums` in a `HashSet` for O(1) lookups.
    /// 2. Using a dummy node to simplify head modifications.
    /// 3. Traversing the linked list once, unlinking nodes whose values are contained in the set.
    ///
    /// ### Parameters
    /// - `nums`: An array of integers containing values to remove from the linked list.
    /// - `head`: The head node of the singly linked list.
    ///
    /// ### Returns
    /// - The head of the modified linked list after all matching nodes have been removed.
    ///
    /// ### Algorithm Steps
    /// 1. Insert all integers from `nums` into a `HashSet`.
    /// 2. Create a dummy node pointing to the original `head` to handle edge cases.
    /// 3. Iterate through the list:
    ///    - If the current node’s value exists in the set, unlink it.
    ///    - Otherwise, move to the next node.
    /// 4. Return `dummy.next` as the new head.
    ///
    /// ### Complexity
    /// - **Time Complexity:** O(n + m), where `n` is the length of the linked list and `m` is the length of `nums`.
    /// - **Space Complexity:** O(m), due to the `HashSet` used for lookups.
    ///
    /// ### Example
    /// ```java
    /// int[] nums = {1, 2, 3};
    /// ListNode head = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
    ///
    /// DeleteNodesLinkedListPresentArray solution = new DeleteNodesLinkedListPresentArray();
    /// ListNode result = solution.modifierList(nums, head);
    /// // Resulting list: 4 -> 5
    /// ```
    public ListNode modifierList(int[] nums, ListNode head) {

        // Step 1: Store nums in a HashSet for a quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Use a dummy node to handle removals from the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = head;

        // Step 3: Traverse and remove matching nodes
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        // Step 4: Return a new head
        return dummy.next;
    }
}
