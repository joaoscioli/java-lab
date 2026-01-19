package leetcode_beginners_guide.middleLinkedList;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // anda 1
            fast = fast.next.next;  // anda 2
        }

        return slow;
    }
}
