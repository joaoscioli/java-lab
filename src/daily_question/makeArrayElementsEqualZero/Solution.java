package daily_question.makeArrayElementsEqualZero;

import java.util.*;

import java.util.Arrays;

public class Solution {

    public static int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;

        // Percorrer todos os índices que são 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Testar direção para a direita (+1)
                if (simulate(Arrays.copyOf(nums, n), i, 1)) {
                    validCount++;
                }
                // Testar direção para a esquerda (-1)
                if (simulate(Arrays.copyOf(nums, n), i, -1)) {
                    validCount++;
                }
            }
        }

        return validCount;
    }

    private static boolean simulate(int[] arr, int start, int direction) {
        int n = arr.length;
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += direction;
            } else {
                arr[curr]--;
                direction = -direction;
                curr += direction;
            }
        }

        // Verifica se todos os elementos foram zerados
        for (int num : arr) {
            if (num != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 0, 3};
        System.out.println("Output: " + countValidSelections(nums1)); // Output: 2

        int[] nums2 = {2, 3, 4, 0, 4, 1, 0};
        System.out.println("Output: " + countValidSelections(nums2)); // Output: 0
    }
}
