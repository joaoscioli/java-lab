package daily_question.maximumSquareAreaRemovingFencesFromField;

import java.util.*;

/// ## Maximum Square Area by Removing Fences from a Field
///
/// Esta classe resolve o problema de encontrar a **maior área possível de um quadrado**
/// que pode ser formado em um campo retangular após a **remoção de cercas horizontais
/// e verticais**.
///
/// O campo possui dimensões `m x n`, com cercas posicionadas em coordenadas
/// discretas ao longo dos eixos horizontal e vertical.
///
/// ---
///
/// ### Ideia Central
/// Um quadrado válido só pode ser formado se existir:
/// - Uma **distância horizontal**
/// - Uma **distância vertical**
/// **iguais**
///
/// Assim, o problema se reduz a:
/// 1. Calcular **todas as distâncias possíveis** entre pares de cercas horizontais.
/// 2. Calcular **todas as distâncias possíveis** entre pares de cercas verticais.
/// 3. Encontrar a **maior distância comum** entre os dois conjuntos.
///
/// ---
///
/// ### Estratégia
/// - Adicionar implicitamente as bordas do campo (`1` e `m` / `n`) às cercas.
/// - Gerar todas as diferenças possíveis entre pares de cercas.
/// - Utilizar `Set` para evitar duplicatas e permitir busca eficiente.
/// - Selecionar o maior comprimento de lado comum.
///
/// ---
///
/// ### Complexidade
/// - **Tempo**:
///   - Geração das distâncias: `O(k² + l²)`
///     onde `k` é o número de cercas horizontais e `l` o de verticais.
/// - **Espaço**:
///   - `O(k² + l²)` para armazenar as distâncias.
///
/// ---
///
/// ### Observações
/// - Se não existir um lado comum entre as distâncias horizontais e verticais,
///   o método retorna `-1`.
/// - O cálculo da área utiliza `long` para evitar overflow.
/// - O módulo é aplicado apenas ao valor final.
public class Solution {

    /// Constante de módulo utilizada para limitar o valor final da área.
    private static final long MOD = 1_000_000_007;

    /// Retorna a maior área possível de um quadrado formado após a remoção das cercas.
    ///
    /// O método calcula todas as distâncias possíveis entre pares de cercas
    /// horizontais e verticais e identifica o maior comprimento de lado comum.
    ///
    /// @param m altura total do campo
    /// @param n largura total do campo
    /// @param hFences posições das cercas horizontais removíveis
    /// @param vFences posições das cercas verticais removíveis
    /// @return maior área possível do quadrado módulo {@link #MOD},
    ///         ou {@code -1} se nenhum quadrado puder ser formado
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        /// Conjunto de todas as distâncias possíveis entre cercas horizontais.
        Set<Integer> hDistances = computeDistances(hFences, m);

        /// Conjunto de todas as distâncias possíveis entre cercas verticais.
        Set<Integer> vDistances = computeDistances(vFences, n);

        long maxSide = -1;

        /// Busca pelo maior comprimento de lado comum entre os dois conjuntos.
        for (int d : hDistances) {
            if (vDistances.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }

    /// Calcula todas as distâncias possíveis entre pares de cercas.
    ///
    /// O método:
    /// 1. Adiciona as bordas do campo (`1` e `limit`) às cercas fornecidas.
    /// 2. Ordena as posições.
    /// 3. Calcula todas as diferenças positivas entre pares de posições.
    ///
    /// @param fences posições das cercas removíveis
    /// @param limit limite máximo do campo (altura ou largura)
    /// @return conjunto contendo todas as distâncias possíveis
    private Set<Integer> computeDistances(int[] fences, int limit) {

        /// Lista contendo as cercas e as bordas do campo.
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int f : fences) list.add(f);
        list.add(limit);

        Collections.sort(list);

        /// Conjunto de distâncias únicas.
        Set<Integer> distances = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                distances.add(list.get(j) - list.get(i));
            }
        }

        return distances;
    }
}
