package leetcode_challenges.challengerFour;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int[] merged = new int[total];

        // Ponteiros para os arrays
        int i = 0, j = 0, k = 0;    // k é o indice no merged

        // Mesclagem: enquanto não acabarem os arrays
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copiar o restante de nums1, se houver
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copiar o restante de nums2, se houver
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Calcular mediana
        if (total % 2 == 0) {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        } else {
            return merged[total / 2];
        }
    }


    // Metodo main para testar
    static void main() {
        // Exemplo 01
        int[] nums1_1 = {1, 3};
        int[] nums1_2 = {2};
        System.out.println("Exemplo 01: " + findMedianSortedArrays(nums1_1, nums1_2));  // Saida: 2.0

        // Exemplo 02
        int[] nums2_1 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println("Exemplo 02: " + findMedianSortedArrays(nums2_1, nums2_2));  // Saida: 2.5
    }
}
