package leetcode_challenges.challengerThree;

import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // Caso base: String vazia retorna 0
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>(); // Mapeia caractere para ultima posição
        int maxLength = 0; // Maior comprimento encontrado
        int left = 0; // Inicio da janela

        // Loop único: right é o fim da janela
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right); // Caractere atual

            // Se caractere está na janela (posição >= left), ajuda left
            if (map.containsKey(current) && map.get(current) >= left) {
                left = map.get(current) + 1;  // Move left para apos a ultima ocorrencia
            }

            // Atualiza a posição do caractere atual
            map.put(current, right);

            // Calcula tamanho da janela atual e atualiza maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    static void main() {
        // Testes
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Deve imprimir 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // Deve imprimir 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // Deve imprimir 3
        System.out.println(lengthOfLongestSubstring("")); // Deve imprimir 0
        System.out.println(lengthOfLongestSubstring("dvdf")); // Deve imprimir 3
    }
}
