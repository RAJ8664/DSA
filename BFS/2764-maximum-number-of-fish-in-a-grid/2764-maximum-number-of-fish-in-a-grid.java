class Solution {
    static class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "(" + row + " " + col + ")";
        }
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) maxi = Math.max(maxi, dfs(i, j, grid));
            }
        }
        return maxi;
    }
    private int dfs(int row, int col, int grid[][]) {
        int n = grid.length, m = grid[0].length;
        int fish = 0;
        int vis[][] = new int[n + 1][m + 1];
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = 1;
        while (q.size() > 0) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            fish += grid[cr][cc];
            q.poll();
            for (int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] > 0 && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
        return fish;
    }
}