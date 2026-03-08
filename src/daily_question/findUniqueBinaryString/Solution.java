package daily_question.findUniqueBinaryString;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char bit = nums[i].charAt(i);
            result.append(bit == '0' ? '1' : '0');
        }

        return result.toString();
    }
}
