package daily_question.BalancedBinaryTree;


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
