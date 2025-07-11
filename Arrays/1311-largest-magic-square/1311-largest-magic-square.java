class Solution {
    private HashSet<Integer> sums;
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxi = 1;
        for (int k = n; k >= 2; k--) {
            sums = new HashSet<>();
            if (check(k, grid)) return k;
        }
        return 1;
    }
    private boolean check(int len, int grid[][]) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r1 = i, c1 = j;
                int r2 = r1 + len - 1, c2 = c1 + len - 1;
                if (r2 >= n || c2 >= m) continue;
                check_row(r1, c1, r2, c2, grid); check_col(r1, c1, r2, c2, grid); check_diagonal(r1, c1, r2, c2, grid);
                if (sums.size() == 1) return true;
                sums = new HashSet<>();
            }
        }
        return false;
    }
    private void check_row(int r1, int c1, int r2, int c2, int grid[][]) {
        int n = grid.length, m = grid[0].length;
        for (int i = r1; i <= r2; i++) {
            int sum = 0;
            for (int j = c1; j <= c2; j++) sum += grid[i][j];
            sums.add(sum);
        }
    }
    private void check_col(int r1, int c1, int r2, int c2, int grid[][]) {
        int n = grid.length, m = grid[0].length;
        for (int j = c1; j <= c2; j++) {
            int sum = 0;
            for (int i = r1; i <= r2; i++) sum += grid[i][j];
            sums.add(sum);
        }
    }
    private void check_diagonal(int r1, int c1, int r2, int c2, int grid[][]) {
        int n = grid.length, m = grid[0].length;
        int sum = 0;
        int i = r1, j = c1;
        while (i != r2 && j != c2) {
            sum += grid[i][j];
            i++;
            j++;
        }
        sum += grid[r2][c2];
        sums.add(sum);
        sum = 0;
        i = r1; j = c2;
        while (i != r2 && j != c1) {
            sum += grid[i][j];
            i++;
            j--;
        }
        sum += grid[r2][c1];
        sums.add(sum);
    }
}