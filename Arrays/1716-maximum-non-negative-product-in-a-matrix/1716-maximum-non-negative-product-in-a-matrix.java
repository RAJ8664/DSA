
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Tuple {
        int row, col;
        long val;
        public Tuple(int row, int col, long val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public String toString() {
            return "Tuple{" +
                   "row=" + row +
                   ", col=" + col +
                   ", val=" + val +
                   '}';
        }
    }

    private int mod = (int)(1e9 + 7);
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        int dir[][] = {{0, 1}, {1, 0}};

        long dp[][][] = new long[n + 1][m + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = Long.MIN_VALUE / 10;
                dp[i][j][1] = Long.MAX_VALUE / 10;
            }
        }
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        q.offer(new Tuple(0, 0, grid[0][0]));
        while (q.size() > 0) {
            int currRow = q.peek().row, currCol = q.peek().col;
            long currVal = q.peek().val;
            q.poll();
            for (int dire[] : dir) {
                int newRow = currRow + dire[0], newCol = currCol + dire[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    long newVal = (currVal * 1L * grid[newRow][newCol]);
                    if (newVal < 0) {
                        if (dp[newRow][newCol][1] > newVal) {
                            dp[newRow][newCol][1] = newVal;
                            q.offer(new Tuple(newRow, newCol, newVal));
                        }
                    } else {
                        if (dp[newRow][newCol][0] < newVal) {
                            dp[newRow][newCol][0] = newVal;
                            q.offer(new Tuple(newRow, newCol, newVal));
                        }
                    }
                }
            }
        }
        int ans = (int)(dp[n - 1][m - 1][0] % mod);
        if (ans < 0)
            ans = -1;
        if (ans == -1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0)
                        return 0;
                }
            }
        }
        return ans;
    }
}