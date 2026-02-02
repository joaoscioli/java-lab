package daily_question.minimumPairRemovalToSortArrayII;

import java.util.PriorityQueue;

/// ## Solution
///
/// Solves the **Minimum Pair Removal to Sort Array II** problem.
///
/// Given an integer array, the operation consists of:
/// - selecting **two adjacent elements**
/// - removing them
/// - inserting their **sum** back into the same position
///
/// The objective is to determine the **minimum number of operations**
/// required to make the array **non-decreasing**.
///
/// This solution uses:
/// - a **doubly linked list** to support efficient removals and merges
/// - a **priority queue (min-heap)** to greedily merge the pair
///   with the smallest sum at each step
public class Solution {

    /// ## Node
    ///
    /// Represents a node in a doubly linked list.
    ///
    /// #### Fields
    /// - `val`  : the current value stored in the node
    /// - `id`   : the original index of the element
    /// - `prev` : reference to the previous node
    /// - `next` : reference to the next node
    static class Node {
        long val;
        int id;
        Node prev, next;

        Node(long v, int i) {
            val = v;
            id = i;
        }
    }

    /// ## Pair
    ///
    /// Represents a pair of **adjacent nodes** that can be merged.
    ///
    /// The priority is determined by:
    /// 1. Smaller sum first
    /// 2. Smaller original index as a tie-breaker
    static class Pair {
        long sum;
        Node a, b;

        Pair(Node a, Node b) {
            this.a = a;
            this.b = b;
            this.sum = a.val + b.val;
        }
    }

    /// ### minimumPairRemoval
    ///
    /// Computes the minimum number of merge operations required
    /// to make the array non-decreasing.
    ///
    /// #### Algorithm
    /// 1. Convert the array into a doubly linked list.
    /// 2. Count the number of **inversions**
    ///    (`a[i] > a[i+1]`) in the current list.
    /// 3. Insert all adjacent pairs into a min-heap ordered by pair sum.
    /// 4. While inversions remain:
    ///    - Extract the smallest valid adjacent pair.
    ///    - Remove the pair and insert their sum.
    ///    - Update inversion count locally.
    ///    - Insert newly formed adjacent pairs into the heap.
    ///
    /// #### Key Observations
    /// - Only **local inversions** around the merged nodes need updates.
    /// - Invalid heap entries are skipped using adjacency validation.
    /// - The greedy choice of smallest sum minimizes future violations.
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(n log n)`
    /// - **Space Complexity:** `O(n)`
    ///
    /// @param nums the input array of integers
    /// @return the minimum number of operations required
    public int minimumPairRemoval(int[] nums) {

        int n = nums.length;
        if (n <= 1) return 0;

        // Build the doubly linked list
        Node head = new Node(nums[0], 0);
        Node cur = head;
        for (int i = 1; i < n; i++) {
            Node nxt = new Node(nums[i], i);
            cur.next = nxt;
            nxt.prev = cur;
            cur = nxt;
        }

        // Count initial inversions
        int inversions = 0;
        for (Node p = head; p.next != null; p = p.next) {
            if (p.val > p.next.val) inversions++;
        }

        // Already sorted
        if (inversions == 0) return 0;

        // Min-heap of adjacent pairs
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x, y) -> x.sum != y.sum
                        ? Long.compare(x.sum, y.sum)
                        : Integer.compare(x.a.id, y.a.id)
        );

        for (Node p = head; p.next != null; p = p.next) {
            pq.add(new Pair(p, p.next));
        }

        int ops = 0;

        // Perform merges until no inversions remain
        while (inversions > 0) {

            Pair p = pq.poll();

            // Skip invalid or outdated pairs
            if (p.a.next != p.b || p.b.prev != p.a) continue;

            Node left = p.a.prev;
            Node right = p.b.next;

            // Remove old inversions
            if (left != null && left.val > p.a.val) inversions--;
            if (p.a.val > p.b.val) inversions--;
            if (right != null && p.b.val > right.val) inversions--;

            // Merge nodes
            Node merged = new Node(p.sum, p.a.id);
            merged.prev = left;
            merged.next = right;

            if (left != null) left.next = merged;
            else head = merged;

            if (right != null) right.prev = merged;

            // Add new inversions
            if (left != null && left.val > merged.val) inversions++;
            if (right != null && merged.val > right.val) inversions++;

            // Push new adjacent pairs
            if (left != null) pq.add(new Pair(left, merged));
            if (right != null) pq.add(new Pair(merged, right));

            ops++;
        }

        return ops;
    }
}
