class Solution {
    private int pref[][];
    public int maxRepOpt1(String text) {
        int n = text.length();
        pref = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            int current = text.charAt(i) - 'a';
            pref[i][current]++;
            for (int j = 0; j < 26; j++) {
                if (i - 1 >= 0) pref[i][j] += pref[i - 1][j]; 
            }
        }
        int low = 1, high = n, ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            if (check(text, mid, n)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    private boolean check(String s, int mid, int n) {
        int freq[] = new int[26];
        for (int i = 0; i < mid; i++) freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > mid - 1) return true;
            if (freq[i] == mid - 1) {
                int total = pref[n - 1][i];
                total -= pref[mid - 1][i];
                if (total > 0) return true;
            }
        }
        int start = 0;
        for (int i = mid; i < s.length(); i++) {
            freq[s.charAt(start++) - 'a']--;
            freq[s.charAt(i) - 'a']++;
            for (int j = 0; j < 26; j++) {
                if (freq[j] == mid - 1) {
                    int total = pref[n - 1][j];
                    int current_total = pref[i][j];
                    if (start - 1 >= 0) current_total -= pref[start - 1][j];
                    if (total - current_total > 0) return true;
                }
            }
        }
        return false;
    }
}