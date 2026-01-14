package daily_question.separateSquaresII;

import java.util.*;

public class Solution {

    private static class Event {
        long y, x1, x2;
        int delta;
        Event(long y, long x1, long x2, int delta) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.delta = delta;
        }
    }

    private static class Segment {
        long y1, y2;
        long width;
        Segment(long y1, long y2, long width) {
            this.y1 = y1;
            this.y2 = y2;
            this.width = width;
        }
    }

    private static class SegmentTree {
        int n;
        int[] count;
        long[] covered;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            covered = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int delta) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[node] += delta;
            } else {
                int m = (l + r) / 2;
                update(node * 2, l, m, ql, qr, delta);
                update(node * 2 + 1, m, r, ql, qr, delta);
            }
            if (count[node] > 0) {
                covered[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                covered[node] = 0;
            } else {
                covered[node] = covered[node * 2] + covered[node * 2 + 1];
            }
        }

        void update(long x1, long x2, int delta) {
            int l = Arrays.binarySearch(xs, x1);
            int r = Arrays.binarySearch(xs, x2);
            update(1, 0, n, l, r, delta);
        }

        long coveredLength() {
            return covered[1];
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        List<Long> xsList = new ArrayList<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, +1));
            events.add(new Event(y + l, x, x + l, -1));
            xsList.add(x);
            xsList.add(x + l);
        }

        Collections.sort(xsList);
        long[] xs = xsList.stream().distinct().mapToLong(Long::longValue).toArray();
        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);
        List<Segment> segments = new ArrayList<>();

        long prevY = events.get(0).y;

        for (Event e : events) {
            long currY = e.y;
            long width = st.coveredLength();
            if (width > 0 && currY > prevY) {
                segments.add(new Segment(prevY, currY, width));
            }
            st.update(e.x1, e.x2, e.delta);
            prevY = currY;
        }

        // Prefix area
        int m = segments.size();
        double[] prefix = new double[m + 1];
        for (int i = 0; i < m; i++) {
            Segment s = segments.get(i);
            prefix[i + 1] = prefix[i] + (double)(s.y2 - s.y1) * s.width;
        }

        double half = prefix[m] / 2.0;

        // Binary search on segments
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (prefix[mid + 1] >= half) hi = mid;
            else lo = mid + 1;
        }

        Segment s = segments.get(lo);
        double remain = half - prefix[lo];
        return s.y1 + remain / s.width;
    }
}
