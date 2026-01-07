package daily_question.maximumProductSplittedBinaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private static final long MOD = 1_000_000_007L;
    private long totalSum = 0;
    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        // 1st DFS: compute total sum of the tree
        totalSum = computeTotalSum(root);

        // 2nd DFS: compute subtree sums and maximize product
        computeSubtreeSum(root);

        return (int) (maxProduct % MOD);
    }

    private long computeTotalSum(TreeNode node) {
        if (node == null) return 0;

        return node.val
                + computeTotalSum(node.left)
                + computeTotalSum(node.right);
    }

    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long subtreeSum = node.val + leftSum + rightSum;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
