class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long pref[] = new long[n];
        for (int i = 0; i < n; i++) {
            int u = 0, v = i;
            pref[u] = (pref[u] + shifts[i]);
            if (v + 1 < n) pref[v + 1] -= shifts[i];
        }
        for (int i = 1; i < n; i++) pref[i] += pref[i - 1];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (pref[i] == 0) {
                res.append(current);
                continue;
            }
            else {
                long time_forward = pref[i] % 26;
                while (time_forward > 0) {
                    if (current == 'z') {
                        current = 'a';
                        time_forward--;
                    }
                    else {
                        current++;
                        time_forward--;
                    }
                }
                res.append(current);
            }
        }
        return res.toString();
    }
}