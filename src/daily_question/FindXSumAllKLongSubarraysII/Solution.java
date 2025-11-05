package daily_question.FindXSumAllKLongSubarraysII;

import java.util.*;

public class Solution {

    /// # `Pair`
    ///
    /// A helper class representing a `(frequency, value)` pair used in the sliding window.
    ///
    /// Each `Pair` stores:
    /// - **freq** → the frequency (occurrences) of a number in the current window.
    /// - **val** → the actual number.
    ///
    /// This class is used within `TreeSet` structures to maintain ordering by frequency and value.
    ///
    static class Pair {
        int freq;
        int val;

        Pair(int f, int v) {
            freq = f;
            val = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return freq == pair.freq && val == pair.val;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(freq);
            result = 31 * result + Integer.hashCode(val);
            return result;
        }
    }

    /// # `findXSum`
    ///
    /// Computes the **X-Sum** for all contiguous subarrays of length `k` within the given array `nums`.
    ///
    /// The **X-Sum** is defined by:
    /// 1. Counting the frequency of each number in the current subarray.
    /// 2. Selecting the **top `x` most frequent** elements (if frequencies tie, the larger value wins).
    /// 3. Summing each selected number multiplied by its frequency.
    ///
    /// ## Parameters
    /// - `nums` — the input integer array.
    /// - `k` — the size of the sliding window (subarray length).
    /// - `x` — the number of most frequent elements to include in the sum.
    ///
    /// ## Returns
    /// An array of `long` values, where each element corresponds to the **X-Sum** of a `k`-length subarray.
    ///
    /// ## Algorithm Overview
    /// - Uses a **sliding window** with dynamic frequency tracking.
    /// - Maintains two balanced `TreeSet`s:
    ///   - `top` → holds the top `x` most frequent (and highest valued) pairs.
    ///   - `bot` → holds all remaining pairs.
    /// - For each step:
    ///   1. Add the new element to the frequency map and update sets.
    ///   2. Remove the outgoing element when the window slides.
    ///   3. Rebalance the sets to ensure `top` always holds the top `x` elements.
    ///   4. Update `windowSum` accordingly.
    ///
    /// ## Complexity
    /// - **Time:** `O(n log n)` — due to TreeSet operations for insertions and removals.
    /// - **Space:** `O(n)` — for the frequency map and TreeSets.
    ///
    /// ## Example
    /// ```java
    /// int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
    /// int k = 6, x = 2;
    /// long[] result = new Solution().findXSum(nums, k, x);
    ///
    /// // Output:
    /// // [6, 10, 12]
    /// ```
    ///
    /// ## Explanation
    /// - For each window of length 6:
    ///   - Count frequencies of all elements.
    ///   - Keep only the `x = 2` most frequent numbers.
    ///   - Compute the sum of (value × frequency) for those numbers.
    ///
    public long[] findXSum(int[] nums, int k, int x) {
        Comparator<Pair> topComp = (a, b) -> {
            if (a.freq != b.freq) {
                return Integer.compare(a.freq, b.freq);
            }
            return Integer.compare(a.val, b.val);
        };

        Comparator<Pair> botComp = (a, b) -> {
            if (a.freq != b.freq) {
                return Integer.compare(b.freq, a.freq);
            }
            return Integer.compare(b.val, a.val);
        };

        TreeSet<Pair> top = new TreeSet<>(topComp);
        TreeSet<Pair> bot = new TreeSet<>(botComp);
        Map<Integer, Integer> count = new HashMap<>();
        long windowSum = 0;
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            // Add the new element to the current window
            int oldFreq = count.getOrDefault(num, 0);
            Pair oldPair = new Pair(oldFreq, num);
            if (oldFreq > 0) {
                boolean removedFromTop = top.remove(oldPair);
                if (removedFromTop) {
                    windowSum -= (long) oldFreq * num;
                } else {
                    bot.remove(oldPair);
                }
            }
            int newFreq = oldFreq + 1;
            count.put(num, newFreq);
            if (newFreq > 0) {
                Pair newPair = new Pair(newFreq, num);
                bot.add(newPair);
            }

            // Remove the element that slides out of the window
            if (i >= k) {
                int leave = nums[i - k];
                oldFreq = count.getOrDefault(leave, 0);
                oldPair = new Pair(oldFreq, leave);
                if (oldFreq > 0) {
                    boolean removedFromTop = top.remove(oldPair);
                    if (removedFromTop) {
                        windowSum -= (long) oldFreq * leave;
                    } else {
                        bot.remove(oldPair);
                    }
                }
                newFreq = oldFreq - 1;
                count.put(leave, newFreq);
                if (newFreq > 0) {
                    Pair newPair = new Pair(newFreq, leave);
                    bot.add(newPair);
                }
            }

            // Compute result once the first full window is formed
            if (i >= k - 1) {
                // Fill top if needed
                while (top.size() < x && !bot.isEmpty()) {
                    Pair bestB = bot.first();
                    bot.remove(bestB);
                    top.add(bestB);
                    windowSum += (long) bestB.freq * bestB.val;
                }

                // Rebalance top and bot
                while (!top.isEmpty() && !bot.isEmpty()) {
                    Pair worstT = top.first();
                    Pair bestB = bot.first();
                    boolean shouldSwap = (bestB.freq > worstT.freq) ||
                            (bestB.freq == worstT.freq && bestB.val > worstT.val);
                    if (!shouldSwap) break;

                    top.remove(worstT);
                    bot.remove(bestB);
                    windowSum -= (long) worstT.freq * worstT.val;
                    bot.add(worstT);
                    top.add(bestB);
                    windowSum += (long) bestB.freq * bestB.val;
                }

                ans[idx++] = windowSum;
            }
        }

        return ans;
    }
}
