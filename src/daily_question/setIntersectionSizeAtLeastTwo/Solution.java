package daily_question.setIntersectionSizeAtLeastTwo;

import java.util.*;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // 1. Ordenar por end crescente e start decrescente quando empatar
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0]; // start desc
            }
            return a[1] - b[1];     // end asc
        });

        // Dois últimos números adicionados ao set final
        int p1 = -1_000_000_000; // último ponto
        int p2 = -1_000_000_000; // penúltimo ponto

        int count = 0; // tamanho do conjunto final

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            boolean containsP1 = (p1 >= start && p1 <= end);
            boolean containsP2 = (p2 >= start && p2 <= end);

            if (containsP1 && containsP2) {
                // já temos 2 pontos dentro deste intervalo
                continue;
            }

            if (containsP1) {
                // temos apenas 1 — adicionar mais um, o maior possível: end
                count += 1;

                // shift
                p2 = p1;
                p1 = end;
            } else {
                // temos 0 pontos — adicionar os dois maiores possíveis: end - 1 e end
                count += 2;

                p2 = end - 1;
                p1 = end;
            }
        }

        return count;
    }
}
