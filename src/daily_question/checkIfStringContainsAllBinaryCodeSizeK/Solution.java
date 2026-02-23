package daily_question.checkIfStringContainsAllBinaryCodeSizeK;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalNeeded = 1 << k;

        if (s.length() < k + totalNeeded - 1) {
            return false;
        }

        boolean[] seen = new boolean[totalNeeded];
        int count = 0;
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = ((hash << 1) & (totalNeeded - 1)) | (s.charAt(i) - '0');
            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;
                    if (count == totalNeeded) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
