package daily_question.shortestDistanceTargetStringCircularArray;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int forward = (i - startIndex + n) % n;
                int backward = (startIndex - i + n) % n;

                int distance = Math.min(forward, backward);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}