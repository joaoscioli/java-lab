package daily_question.findSmallestLetterGreaterThanTarget.readme;

/// # Find Smallest Letter Greater Than Target
///
/// This class provides a solution to the problem of finding the smallest
/// character in a sorted array that is lexicographically greater than
/// a given target character.
///
/// The implementation uses **Binary Search** to achieve optimal
/// performance.
///
/// ## Problem Summary
/// - You are given a sorted array of characters.
/// - You must return the smallest character strictly greater than `target`.
/// - If no such character exists, return the **first character** in the array
///   (wrap-around behavior).
///
/// ## Complexity
/// - **Time Complexity:** `O(log n)`
/// - **Space Complexity:** `O(1)`
///
/// ## Use Cases
/// - Coding interviews
/// - Algorithm practice
/// - Binary search pattern demonstrations
class Solution {

    /// ## nextGreatestLetter
    ///
    /// Finds the smallest character in the `letters` array that is
    /// lexicographically greater than the given `target`.
    ///
    /// The method applies a **binary search** approach since the input
    /// array is already sorted.
    ///
    /// ### Wrap-around Rule
    /// If all characters in the array are less than or equal to `target`,
    /// the method returns the first element of the array.
    ///
    /// ### Parameters
    /// - `letters` : a sorted array of lowercase characters
    /// - `target`  : the reference character to compare against
    ///
    /// ### Returns
    /// - The smallest character greater than `target`
    /// - Or `letters[0]` if no such character exists
    ///
    /// ### Example
    /// ```text
    /// letters = ['c', 'f', 'j']
    /// target  = 'j'
    /// result  = 'c'
    /// ```
    ///
    /// ### Algorithm
    /// 1. Initialize left and right pointers.
    /// 2. Perform binary search to locate the first character > target.
    /// 3. Track a candidate index when a valid character is found.
    /// 4. Return the candidate or apply wrap-around if none exists.
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                answer = mid;
                right = mid - 1; // attempt to find a smaller valid character
            } else {
                left = mid + 1;
            }
        }

        return answer == -1 ? letters[0] : letters[answer];
    }
}
