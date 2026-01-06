package jep_455;

import java.io.IO;

/**
 * /// # Solution
 * ///
 * /// This class provides a solution for calculating the **maximum wealth**
 * /// among multiple customers, where each customer has multiple bank accounts.
 * ///
 * /// The wealth of a customer is defined as the **sum of all balances**
 * /// across their accounts.
 */
public class Solution {

    /**
     * /// ## maximumWealth
     * ///
     * /// Calculates the maximum wealth among all customers.
     * ///
     * /// Each row in the `accounts` matrix represents a customer,
     * /// and each column represents the balance of one of their bank accounts.
     * ///
     * /// ### Algorithm
     * /// - Iterate through each customer
     * /// - Sum all account balances for that customer
     * /// - Track and return the highest wealth found
     * ///
     * /// ### Time Complexity
     * /// - **O(n × m)**, where:
     * ///   - `n` is the number of customers
     * ///   - `m` is the number of accounts per customer
     * ///
     * /// ### Space Complexity
     * /// - **O(1)** (constant extra space)
     * ///
     * /// ### Example
     * /// ```text
     * /// Input:  [[2,8,7],[7,1,3],[1,9,5]]
     * /// Output: 17
     * /// ```
     *
     * /// @param accounts a 2D array where each row contains account balances for a customer
     * /// @return the maximum wealth among all customers
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0; i < accounts.length; i++) {
            int currentWealth = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                currentWealth += accounts[i][j];
            }

            max = Math.max(max, currentWealth);
        }
        return max;
    }

    /**
     * /// ## main
     * ///
     * /// Demonstrates the usage of the {@link #maximumWealth(int[][])} method.
     * ///
     * /// It creates a sample matrix of customer accounts and prints
     * /// the maximum wealth to the console.
     */
    void main() {
        int[][] acccount = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        IO.println(maximumWealth(acccount));
    }
}
