package leetcode_challenges.challengerFour;

public class Solution {

    /// # findMedianSortedArrays
    ///
    /// ## Descrição
    /// Este método recebe **dois arrays ordenados** de inteiros (`nums1` e `nums2`) e retorna a **mediana** dos elementos combinados.
    ///
    /// A abordagem é **baseada em mesclagem** (similar ao processo do *merge sort*), criando um novo array ordenado que contém todos os elementos dos dois arrays originais.
    ///
    /// Após a mesclagem, o método calcula e retorna a mediana:
    /// - Se o número total de elementos for **ímpar**, retorna o elemento central.
    /// - Se for **par**, retorna a média dos dois elementos centrais.
    ///
    /// ## Parâmetros
    /// - `nums1` — Primeiro array de inteiros ordenados.
    /// - `nums2` — Segundo array de inteiros ordenados.
    ///
    /// ## Retorno
    /// - `double` — Valor da mediana dos elementos combinados dos dois arrays.
    ///
    /// ## Complexidade
    /// - **Tempo:** O(m + n), onde `m` e `n` são os tamanhos de `nums1` e `nums2`.
    /// - **Espaço:** O(m + n), devido à criação do array `merged`.
    ///
    /// ## Exemplo
    /// ```java
    /// int[] nums1 = {1, 3};
    /// int[] nums2 = {2};
    /// double resultado = Solution.findMedianSortedArrays(nums1, nums2);
    /// // resultado = 2.0
    /// ```
    ///
    /// ```java
    /// int[] nums1 = {1, 2};
    /// int[] nums2 = {3, 4};
    /// double resultado = Solution.findMedianSortedArrays(nums1, nums2);
    /// // resultado = 2.5
    /// ```
    ///
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int[] merged = new int[total];

        // Ponteiros para os arrays
        int i = 0, j = 0, k = 0;    // k é o índice no merged

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

    /// # main
    ///
    /// ## Descrição
    /// Método de teste para verificar o funcionamento de `findMedianSortedArrays`.
    ///
    /// Executa dois exemplos de entrada e imprime os resultados esperados:
    /// - Exemplo 01: `[1,3]` e `[2]` → **2.0**
    /// - Exemplo 02: `[1,2]` e `[3,4]` → **2.5**
    ///
    /// ## Uso
    /// ```java
    /// Solution.main();
    /// ```
    ///
    static void main() {
        int[] nums1_1 = {1, 3};
        int[] nums1_2 = {2};
        System.out.println("Exemplo 01: " + findMedianSortedArrays(nums1_1, nums1_2));  // Saída: 2.0

        int[] nums2_1 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println("Exemplo 02: " + findMedianSortedArrays(nums2_1, nums2_2));  // Saída: 2.5
    }
}
