class Solution {
    private int dp[][];
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n + 1][m + 1];
        for (int current[] : dp) Arrays.fill(current, -1);
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, solve(i, 0, grid));
        }
        return maxi;
    }

    private int solve(int row, int col, int grid[][]) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        
        int op1 = 0, op2 = 0, op3 = 0;
        if (row - 1 >= 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] > grid[row][col]) {
            op1 = 1 + solve(row - 1, col + 1, grid);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] > grid[row][col]) {
            op2 = 1 + solve(row, col + 1, grid);
        }
        if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row + 1][col + 1] > grid[row][col]) {
            op3 = 1 + solve(row + 1, col + 1, grid);
        }
        return dp[row][col] = Math.max(op1, Math.max(op3, op2));
    }
}