package leetcode_challenges.challengerThree;

import java.util.HashMap;
import java.util.HashSet;

public class ExampleTwo {
    public static int maiorPrefixoSemRepeticao(String s) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return set.size();
            }
            set.add(c);
        }
        // se não houver repetição, o prefixo é a string toda
        return set.size();
    }

    public void main() {
        System.out.println(maiorPrefixoSemRepeticao("abcabcbb"));   // Deve imprimir 3
        System.out.println(maiorPrefixoSemRepeticao("abcd"));     // Deve imprimir 4
        System.out.println(maiorPrefixoSemRepeticao("aabbcc"));   // Deve imprimir 1
    }
}
