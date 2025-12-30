package daily_question.PyramidTransitionMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String pattern : allowed) {
            String key = pattern.substring(0,2);
            char value = pattern.charAt(2);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
        return dfs(bottom);
    }

    private boolean dfs(String row) {
        if (row.length() == 1) {
            return true;
        }
        return buildNextRow(row, 0, new StringBuilder());
    }

    private boolean buildNextRow(String row, int index, StringBuilder nextRow) {

        // Quando a próxima linha estiver completa
        if (index == row.length() - 1) {
            // Tenta continuar a pirâmide
            return dfs(nextRow.toString());
        }

        String key = row.substring(index, index + 2);

        // Se não existe padrão permitido, esse caminho morre
        if (!map.containsKey(key)) {
            return false;
        }

        // Tenta todas as possibilidades para esse par
        for (char c : map.get(key)) {
            nextRow.append(c);

            if (buildNextRow(row, index + 1, nextRow)) {
                return true; // achou um caminho válido
            }

            // Backtracking
            nextRow.deleteCharAt(nextRow.length() - 1);
        }

        return false;
    }
}
