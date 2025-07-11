class Solution {
    static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "(" + row + " " + col + ")";
        }
    }
    static class DSU {
        private int parent[];
        private int size[];
        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int Leader(int u) {
            if (parent[u] == u) return parent[u];
            return parent[u] = Leader(parent[u]);
        }
        public void unite(int u , int v) {
            u = Leader(u);
            v = Leader(v);
            if (u == v) return;
            if (size[v] > size[u]) {
                int temp = u;
                u = v;
                v = temp;
            }
            parent[v] = u;
            size[u] += size[v];
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DSU dsu = new DSU(n * m + 1);
        int vis[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    BFS(i , j , vis, grid, dsu);
                }
            }
        }
        int maxi = 0;
        for (int i = 0; i <= n * m; i++) maxi = Math.max(maxi, dsu.size[dsu.Leader(i)]);
        int dir[][] = {{-1, 0} , {1, 0} , {0, -1} , {0 , 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> ids = new HashSet<>();
                    for (int dire[] : dir) {
                        int nr = i + dire[0];
                        int nc = j + dire[1];
                        if (nr < n && nc < m && nr >= 0 && nc >= 0 && grid[nr][nc] == 1) {
                            int id = nr * m + nc;
                            ids.add(dsu.Leader(id));
                        }
                    }
                    int sum = 0;
                    for (int ele : ids) sum += dsu.size[ele];
                    sum++;
                    maxi = Math.max(maxi, sum);
                }
            }
        }
        return maxi;
    }
    private void BFS(int row, int col, int vis[][], int grid[][], DSU dsu) {
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {{-1, 0} , {1, 0} , {0, 1} , {0, -1}};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = 1;
        while (q.size() > 0) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int current_id = cr * m + cc;
            q.poll();
            for (int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                int new_id = nr * m + nc;
                if (nr < n && nc < m && nr >= 0 && nc >= 0 && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    vis[nr][nc] = 1;
                    q.offer(new Pair(nr, nc));
                    dsu.unite(current_id, new_id);
                }
            }
        }
    }
}