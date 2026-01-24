package daily_question.deleteNodesLinkedListPresentArray;

public class ListNode {

    /// ## ListNode
    ///
    /// Represents a node in a **singly linked list**.
    ///
    /// Each node stores:
    /// - an integer value (`val`)
    /// - a reference to the next node in the list (`next`)
    ///
    /// This structure is commonly used in linked list problems,
    /// especially in coding interviews and algorithm challenges.
    int val;

    /// Reference to the next node in the linked list.
    /// If `null`, this node is the tail.
    ListNode next;

    /// ### Default Constructor
    ///
    /// Creates an empty node with default values:
    /// - `val = 0`
    /// - `next = null`
    ListNode() {
    }

    /// ### Value Constructor
    ///
    /// Creates a node with the specified value.
    /// The `next` reference is initialized as `null`.
    ///
    /// @param val the integer value stored in the node
    ListNode(int val) {
        this.val = val;
    }

    /// ### Value and Next Constructor
    ///
    /// Creates a node with both a value and a reference
    /// to the next node in the linked list.
    ///
    /// @param val  the integer value stored in the node
    /// @param next reference to the next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
