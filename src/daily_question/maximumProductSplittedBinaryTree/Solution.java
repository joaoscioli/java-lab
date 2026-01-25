package daily_question.maximumProductSplittedBinaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/// ## Maximum Product of Splitted Binary Tree
///
/// Esta classe resolve o problema de encontrar o **máximo produto possível**
/// ao dividir uma árvore binária em duas subárvores, removendo **exatamente uma aresta**.
///
/// A ideia central é:
/// 1. Calcular a **soma total** de todos os nós da árvore.
/// 2. Para cada subárvore, calcular:
///    - `subtreeSum`
///    - `totalSum - subtreeSum`
/// 3. Maximizar o produto:
///
/// ```text
/// subtreeSum * (totalSum - subtreeSum)
/// ```
///
/// O resultado final é retornado módulo **1_000_000_007**, conforme exigido pelo problema.
///
/// ---
///
/// ### Estratégia
/// - **DFS 1**: calcula a soma total da árvore.
/// - **DFS 2**: calcula a soma de cada subárvore e avalia o produto máximo.
///
/// ---
///
/// ### Complexidade
/// - **Tempo**: `O(n)`
/// - **Espaço**: `O(h)` (pilha de recursão), onde `h` é a altura da árvore.
///
/// ---
///
/// ### Observações
/// - Usa `long` para evitar overflow durante os cálculos.
/// - O módulo é aplicado **apenas no retorno final**, preservando a precisão intermediária.
class Solution {

    /// Constante de módulo utilizada para limitar o resultado final.
    private static final long MOD = 1_000_000_007L;

    /// Soma total de todos os valores da árvore.
    ///
    /// Esta variável é calculada na primeira DFS e reutilizada
    /// durante o cálculo dos produtos das subárvores.
    private long totalSum = 0;

    /// Maior produto encontrado ao dividir a árvore.
    ///
    /// Atualizado durante a segunda DFS.
    private long maxProduct = 0;

    /// Calcula o maior produto possível ao dividir a árvore binária.
    ///
    /// ### Passos:
    /// 1. Executa uma DFS para calcular a soma total da árvore.
    /// 2. Executa uma segunda DFS para:
    ///    - Calcular a soma de cada subárvore
    ///    - Avaliar o produto entre a subárvore e o restante da árvore
    ///
    /// @param root nó raiz da árvore binária
    /// @return maior produto possível, módulo {@link #MOD}
    public int maxProduct(TreeNode root) {
        // Primeira DFS: soma total da árvore
        totalSum = computeTotalSum(root);

        // Segunda DFS: soma das subárvores + maximização do produto
        computeSubtreeSum(root);

        return (int) (maxProduct % MOD);
    }

    /// Calcula a soma total dos valores da árvore.
    ///
    /// Esta função percorre todos os nós da árvore em profundidade,
    /// somando o valor do nó atual com as somas das subárvores esquerda e direita.
    ///
    /// @param node nó atual da árvore
    /// @return soma total da subárvore enraizada em {@code node}
    private long computeTotalSum(TreeNode node) {
        if (node == null) return 0;

        return node.val
                + computeTotalSum(node.left)
                + computeTotalSum(node.right);
    }

    /// Calcula a soma de cada subárvore e atualiza o maior produto encontrado.
    ///
    /// Para cada nó, considera a divisão da árvore removendo a aresta
    /// que o conecta ao seu pai. O produto avaliado é:
    ///
    /// ```text
    /// subtreeSum * (totalSum - subtreeSum)
    /// ```
    ///
    /// @param node nó atual da árvore
    /// @return soma da subárvore enraizada em {@code node}
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long subtreeSum = node.val + leftSum + rightSum;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
