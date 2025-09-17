package leetcode_challenges.challengerThree;

import java.util.HashSet;

public class ExampleThree {
    public static int maiorSubstringSemRepeticao(String s) {
        // Caso base: String vazia retorna 0
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;  // Armazena o maior comprimento encontrado

        // Loop externo: testa cada posição como inicio da substring
        for (int start = 0; start < s.length(); start++) {
            HashSet<Character> set = new HashSet<>();   // Novo set para cada inicio
            // Loop interno: expande a janela até encontrar repetição ou fim da string
            for (int end = start; end < s.length(); end++) {
                char current = s.charAt(end);   // Caractere atual
                // Se o caractere já está no set, paramos essa janela
                if (set.contains(current)) {
                    break;
                }
                // Caso contrario, adiciona ao set e atualiza o comprimento maximo
                set.add(current);
                int currentLength = end - start + 1; // Tamanho da janela atual
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;   // Retorna o maior comprimento encontrado
    }


    static void main() {
        // Testes
        System.out.println(maiorSubstringSemRepeticao("abcabcbb")); // Deve imprimir 3
        System.out.println(maiorSubstringSemRepeticao("bbbbb")); // Deve imprimir 1
        System.out.println(maiorSubstringSemRepeticao("pwwkew")); // Deve imprimir 3
    }
}
