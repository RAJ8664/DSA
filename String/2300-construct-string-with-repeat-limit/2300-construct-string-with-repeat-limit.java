class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int ind = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) continue;
            if (ind > 0) {
                sb.append((char) ('a' + i));
                freq[i]--;
                i = ind;
                ind = -1;

            }
            else {
                for (int j = 0; j < repeatLimit && freq[i] > 0; j++, freq[i]--) sb.append((char) ('a' + i));
                if (freq[i] > 0) ind = i + 1;
            }
        }
        return sb.toString();
    }
}