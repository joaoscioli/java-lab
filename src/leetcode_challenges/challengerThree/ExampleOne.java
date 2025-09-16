package leetcode_challenges.challengerThree;

import java.util.HashSet;

public class ExampleOne {
    public static int contarUnicos(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }

    static void main() {
        System.out.println(contarUnicos("abc"));  // Deve imprimir 3
        System.out.println(contarUnicos("aabbcc"));  // Deve imprimir 3
        System.out.println(contarUnicos("hello"));  // Deve imprimir 4 (h, e, l, o)

    }
}
