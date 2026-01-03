package leetcode_challenges.challengerFourteen;

import java.io.IO;

public class Solution {
    public String longestCommomPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    void main() {
        String[] strs = {"flower","flow","flight"};
        IO.println(longestCommomPrefix(strs));
    }
}
