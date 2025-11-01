package daily_question.deleteNodesLinkedListPresentArray;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DeleteNodesLinkedListPresentArray {
    public ListNode modifierList(int[] nums, ListNode head) {

        // Step 1: Store nums in a HashSet for quick lookup
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
        while(curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        // Step 4: Return new head
        return dummy.next;
    }
}
