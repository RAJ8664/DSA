class Solution {
    private int dp[];
    public int minimumOperationsToMakeEqual(int x, int y) {
        dp = new int[100000];
        Arrays.fill(dp, -1);
        return solve(x, y);
    }
    private int solve(int x, int y) {
        if (x <= y) return y - x;
        if (dp[x] != -1) return dp[x];
        int res = Math.abs(x - y);
        res = Math.min(res, 1 + x % 5 + solve(x / 5, y));
        res = Math.min(res, 1 + x % 11 + solve(x / 11, y));
        res = Math.min(res, 1 + (5 - x % 5) + solve(x / 5 + 1, y));
        res = Math.min(res, 1 + (11 - x % 11) + solve(x / 11 + 1, y));
        return dp[x] = res;
    }
}