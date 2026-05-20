package daily_question.minimumCommonValue;

/// Provides a solution for finding the minimum common value between two sorted integer arrays.
class Solution {

    /// Returns the smallest integer that appears in both sorted arrays.
    ///
    /// This method uses a two-pointer approach:
    ///
    /// - One pointer iterates over `nums1`.
    /// - One pointer iterates over `nums2`.
    /// - If both current values are equal, that value is the minimum common value.
    /// - Otherwise, the pointer referencing the smaller value is advanced.
    ///
    /// Because both arrays are expected to be sorted in non-decreasing order, the first
    /// common value found is guaranteed to be the minimum common value.
    ///
    /// @param nums1 the first array of integers, sorted in non-decreasing order
    /// @param nums2 the second array of integers, sorted in non-decreasing order
    /// @return the minimum value that appears in both arrays, or `-1` if no common value exists
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }

            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}