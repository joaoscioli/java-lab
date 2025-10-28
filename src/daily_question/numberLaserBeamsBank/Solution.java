package daily_question.numberLaserBeamsBank;

import java.util.Arrays;

/// # Solution — Number of Laser Beams in a Bank
///
/// This class solves the **"Number of Laser Beams in a Bank"** problem,
/// inspired by the [LeetCode 2125](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/) challenge.
///
/// A bank is represented by a 2D matrix in the form of a string array,
/// where each element (`bank[i]`) is a row composed of binary characters:
/// - `'1'` represents a **security device**.
/// - `'0'` represents an **empty space**.
///
/// Each security device in one row can form laser beams with devices in another row,
/// provided that there are **no rows containing only zeros** between them.
///
/// ## Problem Explanation
/// The goal is to count the **total number of beams** connecting devices between rows.
///
/// ### Example
/// ```java
/// String[] bank = {"011001", "000000", "010100", "001000"};
/// int result = Solution.numberOfBeams(bank);
/// System.out.println("Total beams: " + result);
/// ```
///
/// **Output:**
/// ```text
/// Total beams: 8
/// ```
///
/// ### Visual Representation
/// ```text
/// Row 0: 0 1 1 0 0 1   → 3 devices
/// Row 1: 0 0 0 0 0 0   → 0 devices
/// Row 2: 0 1 0 1 0 0   → 2 devices
/// Row 3: 0 0 1 0 0 0   → 1 device
///
/// Beams:
/// (Row 0 → Row 2): 3 × 2 = 6
/// (Row 2 → Row 3): 2 × 1 = 2
/// Total = 8 beams
/// ```
///
/// ## Algorithm Overview
/// 1. **Count devices per row:**
///    Iterate through each row and count the number of `'1'`s.
/// 2. **Compute total beams:**
///    Multiply the number of devices in consecutive *non-empty* rows.
/// 3. **Skip rows with no devices.**
///
/// ## Time Complexity
/// - **O(m × n)**, where `m` is the number of rows and `n` is the number of columns.
/// - **O(m)** extra space for the device count array.
///
/// @since 1.0
public class Solution {

    /// Computes the total number of laser beams in the given bank layout.
    ///
    /// ## Parameters
    /// - `bank`: A 0-indexed binary string array representing the floor plan of the bank.
    ///
    /// ## Returns
    /// - The total number of **laser beams** formed between security devices.
    ///
    /// ## Example
    /// ```java
    /// String[] bank = {"011001", "000000", "010100", "001000"};
    /// int beams = Solution.numberOfBeams(bank);
    /// System.out.println(beams); // 8
    /// ```
    public static int numberOfBeams(String[] bank) {

        // Step 1: Count the number of '1's (devices) in each row
        int[] devicesPerRow = new int[bank.length];

        for (int i = 0; i < bank.length; i++) {
            String row = bank[i];
            int count = 0;

            for (char c : row.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }

            devicesPerRow[i] = count;
        }

        // Step 2: Calculate total beams
        int totalBeams = 0;
        int previousDevices = 0;

        for (int devices : devicesPerRow) {
            if (devices > 0) {
                totalBeams += previousDevices * devices;
                previousDevices = devices;
            }
        }

        return totalBeams;
    }

    /// Demonstrates the usage of the `numberOfBeams` method.
    ///
    /// Runs a sample input and prints the total number of beams to the console.
    ///
    /// **Output:**
    /// ```text
    /// Total beams: 8
    /// ```
    public static void main(String[] args) {
        String[] bank = {"011001", "000000", "010100", "001000"};
        System.out.println("Total beams: " + numberOfBeams(bank));
    }
}
