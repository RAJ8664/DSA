class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int pref[] = new int[n];
        for (int current[] : shifts) {
            int u = current[0], v = current[1], dir = current[2];
            if (dir == 1) {
                pref[u]++;
                if (v + 1 < n) pref[v + 1]--;
            }
            else {
                pref[u]--;
                if (v + 1 < n) pref[v + 1]++;
            }
        }
        for (int i = 1; i < n; i++) pref[i] += pref[i - 1];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (pref[i] == 0) {
                res.append(current);
                continue;
            }
            if (pref[i] < 0) {
                int time_back = Math.abs(pref[i]) % 26;
                while (time_back > 0) {
                    if (current == 'a') {
                        current = 'z';
                        time_back--;
                    }
                    else {
                        current--;
                        time_back--;
                    }
                }
                res.append(current);
            }
            else {
                int time_forward = pref[i] % 26;
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