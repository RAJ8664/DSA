import java.util.Arrays;

class Solution {
    private int dp[][];
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for (int current[] : dp)
            Arrays.fill(current, -1);
        return solve(n - 1, 0, 0, k, s);
    }

    private int solve(int ind, long val, int pos, int k, String s) {
        if (ind < 0)
            return 0;
        if (dp[ind][pos] != -1)
            return dp[ind][pos];

        int op1 = 0, op2 = 0;
        op1 = solve(ind - 1, val, pos, k, s);
        if (s.charAt(ind) == '0')
            op2 = 1 + solve(ind - 1, val, pos + 1, k, s);
        else if (s.charAt(ind) == '1') {
            if (pos < 33 && (val + (1L << pos)) <= k)
                op2 = 1 + solve(ind - 1, val + (1L << pos), pos + 1, k, s);
        }
        return dp[ind][pos] = Math.max(op2, op1);
    }
}