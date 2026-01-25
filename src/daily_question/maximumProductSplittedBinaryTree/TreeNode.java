package daily_question.maximumProductSplittedBinaryTree;

/// ## TreeNode
///
/// Representa um **nó de uma árvore binária**.
///
/// Cada nó armazena:
/// - Um valor inteiro (`val`)
/// - Uma referência para o filho esquerdo (`left`)
/// - Uma referência para o filho direito (`right`)
///
/// ---
///
/// ### Uso
/// Esta estrutura é utilizada como base para algoritmos de travessia,
/// soma de subárvores e divisão lógica da árvore binária.
///
/// ---
///
/// ### Invariantes
/// - Um nó pode ter zero, um ou dois filhos.
/// - `left` e `right` podem ser `null`, indicando ausência de subárvore.
/// - O valor armazenado em `val` representa o peso do nó nos cálculos.
///
/// ---
///
/// ### Observações
/// - A classe não impõe regras de ordenação (não é uma BST).
/// - Mutável por design, permitindo construção dinâmica da árvore.
public class TreeNode {

    /// Valor armazenado no nó.
    ///
    /// Representa a contribuição numérica deste nó em operações
    /// como soma total da árvore ou soma de subárvores.
    int val;

    /// Referência para o filho esquerdo.
    ///
    /// Pode ser `null` caso o nó não possua subárvore à esquerda.
    TreeNode left;

    /// Referência para o filho direito.
    ///
    /// Pode ser `null` caso o nó não possua subárvore à direita.
    TreeNode right;

    /// Cria um nó vazio.
    ///
    /// Útil em cenários de desserialização ou construção incremental
    /// da árvore.
    TreeNode() {}

    /// Cria um nó folha com o valor especificado.
    ///
    /// @param val valor inteiro a ser armazenado no nó
    TreeNode(int val) {
        this.val = val;
    }

    /// Cria um nó com valor e filhos definidos.
    ///
    /// @param val   valor inteiro do nó
    /// @param left  referência para o filho esquerdo
    /// @param right referência para o filho direito
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
