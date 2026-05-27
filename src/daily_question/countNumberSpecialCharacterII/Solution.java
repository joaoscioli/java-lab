package daily_question.countNumberSpecialCharacterII;

class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        for (int i = 0; i < 26; i++) {
            lastLower[i] = -1;
            firstUpper[i] = word.length();
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c)) {
                lastLower[c - 'a'] = i;
            } else {
                int index = c - 'A';
                firstUpper[index] = Math.min(firstUpper[index], i);
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != word.length()
                    && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }

        return count;
    }
}