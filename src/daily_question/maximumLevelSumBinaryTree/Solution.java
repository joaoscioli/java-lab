package daily_question.maximumLevelSumBinaryTree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/// # Solution
///
/// Provides an implementation to determine which level of a binary tree
/// has the maximum sum of node values.
///
/// The algorithm performs a **Breadth-First Search (BFS)** traversal,
/// processing the tree level by level and accumulating the sum of values
/// at each depth.
///
/// This implementation guarantees:
/// - Linear traversal of all nodes.
/// - Constant-time queue operations.
/// - Deterministic result even when negative values exist.
///
/// ## Problem Summary
/// Given the root of a binary tree, return the **1-based index of the level**
/// that has the maximum sum of its node values.
///
/// If multiple levels have the same maximum sum, the **smallest level index**
/// is returned.
///
/// ## Algorithm
/// 1. Initialize a queue and enqueue the root node.
/// 2. Track the current level number starting from `1`.
/// 3. For each level:
///    - Process exactly `queue.size()` nodes.
///    - Accumulate their values into `currentSum`.
///    - Enqueue left and right children if they exist.
/// 4. Compare the current level sum with the maximum recorded sum.
/// 5. Update the best level when a higher sum is found.
/// 6. Continue until the queue is empty.
///
/// ## Time Complexity
/// - **O(n)** — Each node is visited exactly once.
///
/// ## Space Complexity
/// - **O(w)** — Where `w` is the maximum width of the tree (queue size).
///
/// ## Constraints
/// - The binary tree may contain negative and positive integer values.
/// - The tree must contain at least one node.
///
/// ## Example
/// ```text
/// Input:
///       1
///      / \
///     7   0
///    / \
///   7  -8
///
/// Output: 2
/// Explanation:
/// Level 1 sum = 1
/// Level 2 sum = 7 + 0 = 7   ← maximum
/// Level 3 sum = 7 + (-8) = -1
/// ```
///
/// @author
/// Great Designer Software
class Solution {

    /// ## maxLevelSum
    ///
    /// Computes the level of a binary tree that has the maximum sum of node values.
    ///
    /// The method performs a level-order traversal using a queue and calculates
    /// the cumulative sum of each level. The level with the highest sum is returned
    /// using a **1-based index**.
    ///
    /// If multiple levels have the same maximum sum, the earliest level is selected.
    ///
    /// ### Parameters
    /// - `root` — The root node of the binary tree. Must not be `null`.
    ///
    /// ### Returns
    /// - The level number (starting at `1`) with the maximum sum.
    ///
    /// ### Throws
    /// - `NullPointerException` — If `root` is `null`.
    ///
    /// ### Example
    /// ```java
    /// TreeNode root = new TreeNode(1,
    ///     new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
    ///     new TreeNode(0)
    /// );
    ///
    /// int level = new Solution().maxLevelSum(root);
    /// // level == 2
    /// ```
    ///
    /// ### Complexity
    /// - **Time:** O(n)
    /// - **Space:** O(w), where `w` is the maximum number of nodes in any level.
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int bestLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestLevel = level;
            }

            level++;
        }

        return bestLevel;
    }
}
