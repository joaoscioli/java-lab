package daily_question.CheckArraysIsSortedRotated;

class Solution {

    /// Verifica se o array está ordenado em ordem não decrescente e foi rotacionado.
    ///
    /// Um array é considerado válido se ele puder ser visto como uma versão
    /// rotacionada de um array originalmente ordenado.
    ///
    /// Exemplo válido:
    ///
    /// ```text
    /// nums = [3, 4, 5, 1, 2]
    /// ```
    ///
    /// Esse array veio de:
    ///
    /// ```text
    /// [1, 2, 3, 4, 5]
    /// ```
    ///
    /// rotacionado.
    ///
    /// A ideia é contar quantas vezes existe uma "queda", ou seja,
    /// quando um elemento atual é maior que o próximo.
    ///
    /// Exemplo:
    ///
    /// ```text
    /// [3, 4, 5, 1, 2]
    ///          ^
    /// queda: 5 > 1
    /// ```
    ///
    /// Um array ordenado e rotacionado pode ter no máximo uma queda.
    ///
    /// Também comparamos o último elemento com o primeiro usando módulo:
    ///
    /// ```java
    /// nums[(i + 1) % n]
    /// ```
    ///
    /// Isso permite verificar a ligação circular entre o fim e o começo do array.
    ///
    /// @param nums array de inteiros a ser verificado
    /// @return `true` se o array estiver ordenado e rotacionado; caso contrário, `false`
    ///
    /// Complexidade:
    ///
    /// ```text
    /// Tempo: O(n)
    /// Memória: O(1)
    /// ```
    public boolean check(int[] nums) {
        int drops = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                drops++;
            }

            if (drops > 1) {
                return false;
            }
        }

        return true;
    }
}