package daily_question.maximumSideLengthSquareSumLessEqualThreshold.readme;

/// ## Maximum Side Length of a Square with Sum ≤ Threshold
///
/// Esta classe resolve o problema de encontrar o **maior lado possível**
/// de um subquadrado dentro de uma matriz 2D tal que a soma de seus elementos
/// seja **menor ou igual a um valor limite (`threshold`)**.
///
/// ---
///
/// ### Abordagem
/// A solução combina duas técnicas fundamentais:
///
/// 1. **Prefix Sum 2D**
///    - Permite calcular a soma de qualquer submatriz em `O(1)`.
///
/// 2. **Busca Binária sobre o tamanho do lado**
///    - O tamanho do lado do quadrado é monotônico:
///      - Se existe um quadrado de lado `k`, então todos os lados `< k`
///        também são válidos.
///    - Isso permite buscar o maior valor possível de forma eficiente.
///
/// ---
///
/// ### Estratégia Geral
/// 1. Construir a matriz de prefixo `prefix`.
/// 2. Aplicar busca binária no intervalo `[0, min(m, n)]`.
/// 3. Para cada tamanho intermediário (`mid`), verificar se existe
///    ao menos um quadrado válido usando a soma prefixada.
///
/// ---
///
/// ### Complexidade
/// - **Tempo**:
///   - Construção do prefixo: `O(m * n)`
///   - Busca binária: `O(log(min(m, n)))`
///   - Verificação por tamanho: `O(m * n)`
///   - Total: `O(m * n * log(min(m, n)))`
///
/// - **Espaço**:
///   - `O(m * n)` para a matriz de prefixo.
///
/// ---
///
/// ### Observações
/// - O prefixo possui dimensões `(m + 1) x (n + 1)` para evitar verificações
///   de borda.
/// - A soma de submatrizes é calculada sem loops adicionais.
/// - A solução é determinística e não altera a matriz original.
class Solution {

    /// Retorna o maior tamanho possível do lado de um quadrado cuja soma
    /// de elementos seja menor ou igual ao limite informado.
    ///
    /// @param mat matriz 2D de inteiros não negativos
    /// @param threshold valor máximo permitido para a soma do quadrado
    /// @return maior comprimento do lado do quadrado válido
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        /// Matriz de prefixo onde:
        /// prefix[i][j] representa a soma da submatriz
        /// delimitada por (0,0) até (i-1,j-1).
        int[][] prefix = new int[m + 1][n + 1];

        /// Construção da matriz de prefixo 2D.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        /// Intervalo da busca binária para o tamanho do lado.
        int left = 0;
        int right = Math.min(m, n);
        int answer = 0;

        /// Busca binária para encontrar o maior tamanho possível.
        while (left <= right) {
            int mid = (left + right) / 2;

            if (existsSquare(prefix, m, n, mid, threshold)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    /// Verifica se existe ao menos um quadrado de tamanho `size`
    /// cuja soma seja menor ou igual ao limite especificado.
    ///
    /// Utiliza a matriz de prefixo para calcular a soma de cada subquadrado
    /// em tempo constante.
    ///
    /// @param prefix matriz de soma prefixada
    /// @param m número de linhas da matriz original
    /// @param n número de colunas da matriz original
    /// @param size tamanho do lado do quadrado a ser verificado
    /// @param threshold limite máximo permitido para a soma
    /// @return {@code true} se existir um quadrado válido, caso contrário {@code false}
    private boolean existsSquare(int[][] prefix, int m, int n, int size, int threshold) {

        /// Percorre todas as possíveis posições do quadrado de lado `size`.
        for (int i = 0; i + size <= m; i++) {
            for (int j = 0; j + size <= n; j++) {

                /// Soma da submatriz usando prefix sum 2D.
                int sum = prefix[i + size][j + size]
                        - prefix[i][j + size]
                        - prefix[i + size][j]
                        + prefix[i][j];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
