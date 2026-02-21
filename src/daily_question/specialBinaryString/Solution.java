package daily_question.specialBinaryString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;

            if (count == 0) {
                String inner = s.substring(start + 1, i);
                String optimizedInner = makeLargestSpecial(inner);
                parts.add("1" + optimizedInner + "0");
                start = i + 1;
            }
        }

        parts.sort(Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}
