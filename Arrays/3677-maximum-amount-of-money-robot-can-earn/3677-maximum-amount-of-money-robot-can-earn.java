class Solution {
    private int dp[][][];
    public int maximumAmount(int[][] coins) {
        int n = coins.length, m = coins[0].length;
        dp = new int[n + 1][m + 1][3];
        for (int current[][] : dp) for (int current1[] : current) Arrays.fill(current1, (int)(-1e9));
        return solve(0, 0, 2, coins);
    }
    private int solve(int row, int col, int power, int grid[][]) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return Integer.MIN_VALUE / 10;
        if (dp[row][col][power] != (int)(-1e9)) return dp[row][col][power];
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (grid[row][col] > 0) return grid[row][col];
            else if (power > 0) return 0;
            else return grid[row][col];
        }
        if (grid[row][col] >= 0) {
            int op1 = Integer.MIN_VALUE / 10, op2 = Integer.MIN_VALUE / 10;
            op1 = grid[row][col] + Math.max(solve(row, col + 1, power, grid), solve(row + 1, col, power, grid));
            return dp[row][col][power] = op1;
        }
        else {
            int op1 = Integer.MIN_VALUE / 10, op2 = Integer.MIN_VALUE / 10;
            if (power > 0) {
                op1 = grid[row][col] + Math.max(solve(row, col + 1, power, grid), solve(row + 1, col, power, grid));
                op2 = 0 + Math.max(solve(row, col + 1, power - 1, grid), solve(row + 1, col, power - 1, grid));
                return dp[row][col][power] = Math.max(op1, op2);
            }
            return dp[row][col][power] = grid[row][col] + Math.max(solve(row, col + 1, power, grid), solve(row + 1, col, power, grid));
        }
    }
}