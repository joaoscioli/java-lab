package leetcode_challenges.challengerTwentySix;

/// # Remove Duplicates from Sorted Array
///
/// Removes duplicate values **in-place** from a **sorted integer array**
/// and returns the number of **unique elements**.
///
/// The relative order of the elements must remain the same, and the
/// first `k` elements of the array should contain the unique values.
/// The remaining elements beyond `k` are not relevant.
///
/// ## Algorithm
///
/// This solution uses the **two-pointer technique**:
///
/// - Pointer `i` tracks the position of the **last unique element found**.
/// - Pointer `j` scans through the array looking for new unique values.
///
/// Steps:
///
/// 1. If the array is empty, return `0`.
/// 2. Initialize pointer `i` at index `0`.
/// 3. Iterate `j` from index `1` to the end of the array:
///    - If `nums[j]` is different from `nums[i]`,
///      a new unique element has been found.
///    - Increment `i` and copy `nums[j]` into `nums[i]`.
/// 4. After finishing the iteration, the first `i + 1` elements
///    of the array contain the unique values.
///
/// ## Time Complexity
///
/// - **O(n)** — Each element is visited exactly once.
///
/// ## Space Complexity
///
/// - **O(1)** — The operation is performed **in-place** without extra memory.
///
/// ## Example
///
/// ```java
/// int[] nums = {1, 1, 2};
///
/// int k = new Solution().removeDuplicates(nums);
///
/// // k = 2
/// // nums = [1, 2, ...]
/// ```
///
/// ```java
/// int[] nums = {0,0,1,1,1,2,2,3,3,4};
///
/// int k = new Solution().removeDuplicates(nums);
///
/// // k = 5
/// // nums = [0,1,2,3,4,...]
/// ```
///
/// ## Parameters
///
/// - `nums` — A **sorted integer array** that may contain duplicate values.
///
/// ## Returns
///
/// Returns the number `k` representing the **count of unique elements**.
/// The first `k` positions of the array will contain those unique values.
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}