package daily_question.nrepeatedElementSize2NArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num; // achamos o repetido!
            }
            seen.add(num);
        }

        return -1; // nunca acontece, por causa das garantias do problema
    }
}
