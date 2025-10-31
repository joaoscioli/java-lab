package daily_question.TheTwoSneakyNumbersDigitville;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        // Count the frequency of each number
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Collect numbers that appear than once
        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) duplicates.add(entry.getKey());
        }

        // Convert the list of duplicates to an array
        return new int[]{duplicates.get(0), duplicates.get(1)};
    }
}
