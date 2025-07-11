class Solution {
    public long gridGame(int[][] grid) {
        int m = grid[0].length;
        long[] pref1 = new long[m];
        long[] pref2 = new long[m];
        pref1[0] = grid[0][0];
        pref2[0] = grid[1][0];
        for (int i = 1; i < m; i++) {
            pref1[i] = pref1[i - 1] + grid[0][i];
            pref2[i] = pref2[i - 1] + grid[1][i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long first = 0, second = 0;
            if (i != m - 1) first = pref1[m - 1] - pref1[i];
            if (i != 0) second = pref2[i - 1];
            res = Math.min(res, Math.max(first, second));
        }
        return res;
    }
}