package daily_question.BalancedBinaryTree;

/// ## Balanced Binary Tree
///
/// This solution determines whether a binary tree is **height-balanced**.
///
/// A binary tree is considered height-balanced if, for every node:
/// - The height difference between its left and right subtrees is **at most 1**.
///
/// ### Key Idea
/// The algorithm performs a **post-order DFS traversal**, computing subtree heights
/// bottom-up. If an imbalance is detected at any point, the recursion immediately
/// propagates a sentinel value (`-1`) to indicate failure.
///
/// This avoids redundant height calculations and ensures optimal performance.
///
/// ### Time Complexity
/// - `O(n)` — each node is visited once.
///
/// ### Space Complexity
/// - `O(h)` — recursion stack, where `h` is the height of the tree
///   (worst case `O(n)`, best case `O(log n)`).
///
/// ### Examples
/// ```text
/// Input:  [3,9,20,null,null,15,7]
/// Output: true
///
/// Input:  [1,2,2,3,3,null,null,4,4]
/// Output: false
///
/// Input:  []
/// Output: true
/// ```
public class Solution {

    /// Determines whether the given binary tree is height-balanced.
    ///
    /// @param root the root node of the binary tree
    /// @return {@code true} if the tree is balanced; {@code false} otherwise
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /// Computes the height of the subtree rooted at the given node.
    ///
    /// If the subtree is not balanced, this method returns `-1` as a sentinel value.
    ///
    /// @param node the current tree node
    /// @return the height of the subtree, or `-1` if it is unbalanced
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /// Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
