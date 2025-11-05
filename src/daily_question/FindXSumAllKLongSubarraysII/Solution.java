package daily_question.FindXSumAllKLongSubarraysII;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import java.util.*;

public class Solution {
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
            // Add
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

            // Remove if needed
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

            // Rebalance if window is full
            if (i >= k - 1) {
                // Fill top
                while (top.size() < x && !bot.isEmpty()) {
                    Pair bestB = bot.first();
                    bot.remove(bestB);
                    top.add(bestB);
                    windowSum += (long) bestB.freq * bestB.val;
                }

                // Swap if needed
                while (!top.isEmpty() && !bot.isEmpty()) {
                    Pair worstT = top.first();
                    Pair bestB = bot.first();
                    boolean shouldSwap = (bestB.freq > worstT.freq) ||
                            (bestB.freq == worstT.freq && bestB.val > worstT.val);
                    if (!shouldSwap) {
                        break;
                    }
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