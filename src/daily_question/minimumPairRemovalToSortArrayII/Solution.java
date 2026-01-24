package daily_question.minimumPairRemovalToSortArrayII;

import java.util.PriorityQueue;

public class Solution {
    static class Node {
        long val;
        int id;
        Node prev, next;
        Node(long v, int i) {
            val = v;
            id = i;
        }
    }

    static class Pair {
        long sum;
        Node a, b;
        Pair(Node a, Node b) {
            this.a = a;
            this.b = b;
            this.sum = a.val + b.val;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // build linked list
        Node head = new Node(nums[0], 0);
        Node cur = head;
        for (int i = 1; i < n; i++) {
            Node nxt = new Node(nums[i], i);
            cur.next = nxt;
            nxt.prev = cur;
            cur = nxt;
        }

        // count initial inversions
        int inversions = 0;
        for (Node p = head; p.next != null; p = p.next)
            if (p.val > p.next.val) inversions++;

        if (inversions == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x, y) -> x.sum != y.sum
                        ? Long.compare(x.sum, y.sum)
                        : Integer.compare(x.a.id, y.a.id)
        );

        for (Node p = head; p.next != null; p = p.next)
            pq.add(new Pair(p, p.next));

        int ops = 0;

        while (inversions > 0) {

            Pair p = pq.poll();

            // validate adjacency
            if (p.a.next != p.b || p.b.prev != p.a) continue;

            Node left = p.a.prev;
            Node right = p.b.next;

            // remove old inversions
            if (left != null && left.val > p.a.val) inversions--;
            if (p.a.val > p.b.val) inversions--;
            if (right != null && p.b.val > right.val) inversions--;

            // merge
            Node merged = new Node(p.sum, p.a.id);
            merged.prev = left;
            merged.next = right;

            if (left != null) left.next = merged;
            else head = merged;

            if (right != null) right.prev = merged;

            // add new inversions
            if (left != null && left.val > merged.val) inversions++;
            if (right != null && merged.val > right.val) inversions++;

            // push new pairs
            if (left != null) pq.add(new Pair(left, merged));
            if (right != null) pq.add(new Pair(merged, right));

            ops++;
        }

        return ops;
    }
}
