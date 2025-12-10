package leetcode_challenges.challengerEleven;

public class Solution {

    /// ### maxArea
    /// Computes the maximum amount of water that can be contained between two vertical lines.
    ///
    /// This method solves the classic **"Container With Most Water"** problem using the
    /// **two-pointer technique**, ensuring optimal time complexity.
    ///
    /// #### How it Works
    /// - Two pointers start at the extremes of the array.
    /// - At each step:
    ///   - The area is calculated as the minimum height between the two lines multiplied by the width.
    ///   - The pointer pointing to the shorter line is moved inward, since moving the taller line
    ///     cannot increase the area.
    /// - This process continues until the pointers meet.
    ///
    /// #### Complexity
    /// - **Time:** `O(n)` — each pointer moves at most once across the array.
    /// - **Space:** `O(1)` — only constant extra memory is used.
    ///
    /// #### Parameters
    /// - `height`: An array where each index represents a vertical line and its value represents height.
    ///
    /// #### Returns
    /// The maximum possible area (integer) that can be formed between any two lines.
    ///
    /// #### Examples
    /// ```java
    /// Solution s = new Solution();
    /// int result = s.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
    /// // result = 49
    /// ```
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, h * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
