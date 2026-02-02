package daily_question.separateSquaresII;

import java.util.*;

/// ## Solution
///
/// Computes the horizontal line (`y`) that **splits the total covered area
/// of multiple axis-aligned squares into two equal halves**.
///
/// Each square is defined by its bottom-left corner `(x, y)` and side length `l`.
/// Overlapping areas are counted **only once**.
///
/// The solution uses a **sweep line algorithm combined with a segment tree**
/// to efficiently calculate the union area and locate the exact split position.
public class Solution {

    /// ## Event
    ///
    /// Represents a vertical sweep-line event.
    ///
    /// Each square contributes:
    /// - a **start event** at `y`
    /// - an **end event** at `y + l`
    ///
    /// The interval `[x1, x2)` is added or removed depending on `delta`.
    private static class Event {
        long y;
        long x1, x2;
        int delta;

        Event(long y, long x1, long x2, int delta) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.delta = delta;
        }
    }

    /// ## Segment
    ///
    /// Represents a vertical strip between two consecutive sweep-line positions.
    ///
    /// - `[y1, y2)` defines the vertical interval
    /// - `width` is the total horizontal coverage within this strip
    ///
    /// Each segment contributes:
    /// `(y2 - y1) * width` to the total area.
    private static class Segment {
        long y1, y2;
        long width;

        Segment(long y1, long y2, long width) {
            this.y1 = y1;
            this.y2 = y2;
            this.width = width;
        }
    }

    /// ## SegmentTree
    ///
    /// A segment tree used to maintain the **total covered x-length**
    /// across active intervals during the sweep.
    ///
    /// #### Responsibilities
    /// - Tracks how many intervals cover each x-segment (`count`)
    /// - Computes the union length of all active x-intervals (`covered`)
    ///
    /// The tree operates on **compressed x-coordinates**.
    private static class SegmentTree {
        int n;
        int[] count;
        long[] covered;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            this.count = new int[4 * n];
            this.covered = new long[4 * n];
        }

        /// Updates coverage in range `[ql, qr)` with `delta`.
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

        /// Updates coverage for the real x-interval `[x1, x2)`.
        void update(long x1, long x2, int delta) {
            int l = Arrays.binarySearch(xs, x1);
            int r = Arrays.binarySearch(xs, x2);
            update(1, 0, n, l, r, delta);
        }

        /// Returns the total covered x-length.
        long coveredLength() {
            return covered[1];
        }
    }

    /// ### separateSquares
    ///
    /// Finds the `y` coordinate of a horizontal line that divides the
    /// **union area of all squares into two equal parts**.
    ///
    /// #### Algorithm
    /// 1. Convert each square into two sweep-line events (enter / exit).
    /// 2. Compress all x-coordinates.
    /// 3. Sweep upward along the y-axis:
    ///    - Maintain active x-coverage using a segment tree.
    ///    - Record vertical segments with constant covered width.
    /// 4. Build a prefix sum of areas.
    /// 5. Binary search the segment containing half the total area.
    /// 6. Interpolate inside the segment to compute the exact `y`.
    ///
    /// #### Key Properties
    /// - Overlapping square regions are counted once.
    /// - The returned value may be fractional.
    ///
    /// #### Complexity
    /// - **Time Complexity:** `O(n log n)`
    /// - **Space Complexity:** `O(n)`
    ///
    /// @param squares an array where each entry is `[x, y, sideLength]`
    /// @return the y-coordinate that splits the total covered area in half
    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();
        List<Long> xsList = new ArrayList<>();

        // Build sweep events and collect x-coordinates
        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, +1));
            events.add(new Event(y + l, x, x + l, -1));
            xsList.add(x);
            xsList.add(x + l);
        }

        // Coordinate compression
        Collections.sort(xsList);
        long[] xs = xsList.stream().distinct().mapToLong(Long::longValue).toArray();

        // Sort events by y-coordinate
        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);
        List<Segment> segments = new ArrayList<>();

        long prevY = events.get(0).y;

        // Sweep line processing
        for (Event e : events) {
            long currY = e.y;
            long width = st.coveredLength();

            if (width > 0 && currY > prevY) {
                segments.add(new Segment(prevY, currY, width));
            }

            st.update(e.x1, e.x2, e.delta);
            prevY = currY;
        }

        // Prefix sum of areas
        int m = segments.size();
        double[] prefix = new double[m + 1];
        for (int i = 0; i < m; i++) {
            Segment s = segments.get(i);
            prefix[i + 1] = prefix[i] + (double) (s.y2 - s.y1) * s.width;
        }

        double half = prefix[m] / 2.0;

        // Binary search for segment containing half the area
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (prefix[mid + 1] >= half) hi = mid;
            else lo = mid + 1;
        }

        // Interpolate inside the segment
        Segment s = segments.get(lo);
        double remain = half - prefix[lo];
        return s.y1 + remain / s.width;
    }
}
