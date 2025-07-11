class Solution {
    private int dp[][];
    public int calculateMinimumHP(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        dp = new int[n + 1][m + 1];
        for (int current[] : dp) 
            Arrays.fill(current, (int)(1e9));
        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int current = Math.min(dp[i + 1][j], dp[i][j + 1]) - arr[i][j];
                dp[i][j] = Math.max(1, current);
            }
        }
        return dp[0][0];
    }
}