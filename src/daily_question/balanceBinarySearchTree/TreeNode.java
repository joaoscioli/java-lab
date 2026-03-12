package daily_question.balanceBinarySearchTree;

/// ## TreeNode
///
/// Represents a node in a **Binary Tree** or **Binary Search Tree (BST)**.
///
/// Each node contains:
///
/// - an integer value (`val`)
/// - a reference to the left child (`left`)
/// - a reference to the right child (`right`)
///
/// This structure is commonly used in problems involving:
///
/// - Binary Search Trees
/// - Tree traversals (in-order, pre-order, post-order)
/// - Tree balancing algorithms
/// - Recursive tree operations
///
/// In the context of the **Balance Binary Search Tree** problem, this node
/// structure is used to represent the input BST and to build the resulting
/// balanced tree.
///
/// ### Structure
///
/// ```text
///        val
///       /   \
///    left   right
/// ```
///
/// ### Notes
///
/// - `left` contains nodes with values smaller than `val` in a BST.
/// - `right` contains nodes with values greater than `val` in a BST.
/// - If a node has no child, the reference is `null`.
///
/// ### Time and Space
///
/// The class itself has no algorithmic complexity, but it serves as the
/// fundamental data structure used by tree-based algorithms.
///
/// ### Example
///
/// ```java
/// TreeNode root = new TreeNode(4,
///     new TreeNode(2),
///     new TreeNode(6)
/// );
/// ```
class TreeNode {

    /// The value stored in this tree node.
    int val;

    /// Reference to the left child node.
    TreeNode left;

    /// Reference to the right child node.
    TreeNode right;

    /// ### Default Constructor
    ///
    /// Creates an empty node with no value assigned.
    /// All fields remain uninitialized (default values).
    TreeNode() {}

    /// ### Value Constructor
    ///
    /// Creates a node with a specified value.
    ///
    /// **Parameters**
    /// - `val` — the integer value stored in the node.
    TreeNode(int val) {
        this.val = val;
    }

    /// ### Full Constructor
    ///
    /// Creates a node with a value and references to its children.
    ///
    /// **Parameters**
    /// - `val` — the value stored in the node
    /// - `left` — reference to the left child
    /// - `right` — reference to the right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}