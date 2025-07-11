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
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int vis1[][] = new int[n + 1][m + 1];
        int vis2[][] = new int[n + 1][m + 1];

        for (int j = 0; j < m; j++) if (vis1[0][j] == 0) bfs(0, j, heights, vis1);
        for (int i = 0; i < n; i++) if (vis1[i][0] == 0) bfs(i, 0, heights, vis1);
        for (int i = 0; i < n; i++) if (vis2[i][m - 1] == 0) bfs(i, m - 1, heights, vis2);
        for (int j = 0; j < m; j++) if (vis2[n - 1][j] == 0) bfs(n - 1, j, heights, vis2);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis1[i][j] == 1 && vis2[i][j] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i); temp.add(j);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }
    private void bfs(int row, int col, int heights[][], int vis[][]) {
        int n = heights.length;
        int m = heights[0].length;
        vis[row][col] = 1;
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        while (q.size() > 0) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            q.poll();
            for (int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if (nr < n && nc < m && nr >= 0 && nc >= 0 && vis[nr][nc] == 0 && heights[nr][nc] >= heights[cr][cc]) {
                    q.offer(new Pair(nr, nc));
                    vis[nr][nc] = 1;
                }
            }
        }
    }
}
