class Solution {
    private int pref[][];
    private int suff[][];
    public int takeCharacters(String s, int k) {
        int n = s.length();
        if (k == 0) return 0;
        pref = new int[n][3];
        suff = new int[n][3];
        int counta = 0, countb = 0, countc = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') counta++;
            else if (s.charAt(i) == 'b') countb++;
            else countc++;
            pref[i][0] = counta; pref[i][1] = countb; pref[i][2] = countc;
        }
        counta = 0; countb = 0; countc = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') counta++;
            else if (s.charAt(i) == 'b') countb++;
            else countc++;
            suff[i][0] = counta; suff[i][1] = countb; suff[i][2] = countc;
        }
        if (pref[n - 1][0] < k || pref[n - 1][1] < k || pref[n - 1][2] < k) return -1; 
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curr_counta = pref[i][0], curr_countb = pref[i][1], curr_countc = pref[i][2];
            if (curr_counta >= k && curr_countb >= k && curr_countc >= k) {
                mini = Math.min(mini, i + 1);
                continue;
            }
            int ind = binary_search(i + 1, n - 1, n, k);
            if (ind == -1) continue;
            mini = Math.min(mini, (i + 1 + (n  - ind)));
        }

        for (int i = n - 1; i >= 0; i--) {
            int curr_counta = suff[i][0], curr_countb = suff[i][1], curr_countc = suff[i][2];
            if (curr_counta >= k && curr_countb >= k && curr_countc >= k) {
                mini = Math.min(mini, (n - i));
                continue;
            }
            if (i - 1 >= 0) {
                int ind = binary_search1(0, i - 1, n , k);
                if (ind != -1) mini = Math.min(mini, (n - i + 1 + ind + 1)); 
            }
        }
        return mini;
    }
    private int binary_search(int low, int high, int n, int k) {
        int counta = 0, countb = 0, countc = 0;
        counta = pref[low - 1][0]; countb = pref[low - 1][1]; countc = pref[low - 1][2];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int curr_counta = suff[mid][0], curr_countb = suff[mid][1], curr_countc = suff[mid][2];
            if (counta + curr_counta >= k && countb + curr_countb >= k && countc + curr_countc >= k) {
                ans = mid;
                low = mid + 1;
            } 
            else high = mid - 1;
        }
        return ans;
    }

    private int binary_search1(int low, int high, int n, int k) {
        int counta = suff[high + 1][0], countb = suff[high + 1][1], countc = suff[high + 1][2];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int curr_counta = pref[mid][0], curr_countb = pref[mid][1], curr_countc = pref[mid][2];
            if (counta + curr_counta >= k && countb + curr_countb >= k && countc + curr_countc >= k) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}