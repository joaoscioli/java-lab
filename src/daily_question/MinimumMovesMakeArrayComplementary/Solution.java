package daily_question.MinimumMovesMakeArrayComplementary;

package daily_question.MinimumMovesMakeArrayComplementary;

/// Provides a solution for finding the minimum number of moves required to make
/// an array complementary.
///
/// A complementary array is one where every symmetric pair has the same sum.
/// For each pair `nums[i]` and `nums[n - 1 - i]`, one move can replace either
/// value with any integer in the range `[1, limit]`.
class Solution {

    /// Returns the minimum number of moves needed to make `nums` complementary.
    ///
    /// The method evaluates every possible target pair sum from `2` to
    /// `2 * limit`. Instead of checking each target sum directly for every pair,
    /// it uses a difference array to record how many moves are required over
    /// ranges of possible sums.
    ///
    /// For each symmetric pair `(a, b)`:
    ///
    /// - `0` moves are needed when the target sum is exactly `a + b`.
    /// - `1` move is needed when the target sum can be reached by changing one
    ///   of the two values.
    /// - `2` moves are needed otherwise.
    ///
    /// The difference array stores these cost changes efficiently, allowing the
    /// final minimum to be found with a prefix sum scan.
    ///
    /// @param nums the input array whose symmetric pairs should become
    /// complementary
    /// @param limit the maximum allowed value for any array element after a move
    /// @return the minimum number of moves required to make the array
    /// complementary
    class Solution {
        public int minMoves(int[] nums, int limit) {
            int n = nums.length;
            int[] diff = new int[2 * limit + 2];

            for (int i = 0; i < n / 2; i++) {
                int a = nums[i];
                int b = nums[n - 1 - i];

                int min = Math.min(a, b);
                int max = Math.max(a, b);
                int sum = a + b;

                diff[2] += 2;
                diff[2 * limit + 1] -= 2;

                diff[min + 1] -= 1;
                diff[max + limit + 1] += 1;

                diff[sum] -= 1;
                diff[sum + 1] += 1;
            }

            int answer = Integer.MAX_VALUE;
            int moves = 0;

            for (int target = 2; target <= 2 * limit; target++) {
                moves += diff[target];
                answer = Math.min(answer, moves);
            }

            return answer;
        }
    }