import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;

        ArrayList<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k)
                validCharacters.add((char)(i + 'a'));
        }

        String ans = "";
        Queue<String> q = new LinkedList<>();
        q.offer("");
        while (q.size() > 0) {
            String curr = q.poll();
            for (char c : validCharacters) {
                String child = curr + c;
                if (isValid(s, child, k)) {
                    ans = child;
                    q.offer(child);
                }
            }
        }
        return ans;
    }
    private boolean isValid(String s, String temp, int k) {
        int n = s.length();
        String t = "";
        for (int i = 0; i < k; i++)
            t += temp;
        int m = t.length();

        if (m > n)
            return false;

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else
                i++;
        }
        return j == m;
    }
}