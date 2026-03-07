package daily_question.primeNumberSetBitsBinaryRepresentation;

import java.util.Set;

class Solution {

    /// # countPrimeSetBits
    ///
    /// Counts how many integers within the inclusive range `[left, right]`
    /// have a **prime number of set bits** in their binary representation.
    ///
    /// ## Definition
    ///
    /// A **set bit** is a bit with value `1` in the binary representation
    /// of a number.
    ///
    /// For example:
    ///
    /// ```text
    /// 10 (decimal) = 1010 (binary)
    /// set bits = 2
    /// ```
    ///
    /// A number is counted if the total number of set bits is a **prime number**.
    ///
    /// ## Strategy
    ///
    /// 1. Predefine a set of prime numbers that could realistically occur
    ///    as bit counts within a 32-bit integer.
    ///
    ///    Since integers in this context are relatively small, the maximum
    ///    number of set bits we need to consider is limited. Therefore,
    ///    a fixed set of prime values is sufficient.
    ///
    /// 2. Iterate through every integer in the range `[left, right]`.
    ///
    /// 3. For each number:
    ///
    ///    - Compute the number of set bits using `Integer.bitCount(num)`.
    ///    - Check if this value exists in the predefined set of primes.
    ///
    /// 4. If the count of set bits is prime, increment the result counter.
    ///
    /// ## Why `Integer.bitCount`
    ///
    /// `Integer.bitCount()` is a highly optimized built-in Java method that
    /// efficiently counts the number of `1` bits in an integer.
    ///
    /// ## Time Complexity
    ///
    /// - **O(n)** where `n = right - left + 1`
    ///
    /// Each number in the range is processed exactly once.
    ///
    /// ## Space Complexity
    ///
    /// - **O(1)** since the set of prime numbers is constant in size.
    ///
    /// ## Parameters
    ///
    /// - `left` — The starting integer of the inclusive range.
    /// - `right` — The ending integer of the inclusive range.
    ///
    /// ## Returns
    ///
    /// - The number of integers within the range `[left, right]`
    ///   whose binary representation contains a **prime number of set bits**.
    ///
    /// ## Example
    ///
    /// ```text
    /// Input:
    /// left = 6
    /// right = 10
    ///
    /// Numbers and their binary forms:
    ///
    /// 6  -> 110  -> 2 set bits  -> prime
    /// 7  -> 111  -> 3 set bits  -> prime
    /// 8  -> 1000 -> 1 set bit   -> not prime
    /// 9  -> 1001 -> 2 set bits  -> prime
    /// 10 -> 1010 -> 2 set bits  -> prime
    ///
    /// Output:
    /// 4
    /// ```
    ///
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = Set.of(
                2, 3, 5, 7, 11, 13, 17, 19
        );

        int count = 0;

        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);
            if (primes.contains(setBits)) {
                count++;
            }
        }

        return count;
    }
}