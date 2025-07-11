class Solution {
    static class Pair {
        int row, col, val,cost;
        public Pair(int row, int col,int val,int cost) {
            this.row = row;
            this.col = col;
            this.val = val;
            this.cost = cost;
        }
    }
    public int minCost(int[][] grid) {
        return bfs(0, 0, grid);
    }
    public static int bfs(int row, int col, int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {{-1, 0} , {1, 0} , {0, -1} , {0 , 1}};
        Queue<Pair> q = new LinkedList<>();
        int dist[][] = new int[n + 1][m + 1];
        for(int current[] : dist) Arrays.fill(current, (int)(1e9));
        dist[0][0] = 0;
        q.offer(new Pair(0,0,grid[0][0],0));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int cr = q.peek().row;
            int cc = q.peek().col;
            int cv = q.peek().val;
            int ccost = q.peek().cost;
            System.out.println(cr + " " + cc + " " + ccost);
            if(cr == n - 1 && cc == m - 1) min = Math.min(min, ccost);
            q.poll();
            if(cv == 1) {
                int nr = cr;
                int nc = cc + 1;
                if(nc < m) {
                    if(dist[nr][nc] > ccost) {
                        q.offer(new Pair(nr, nc, grid[nr][nc] , ccost));
                        dist[nr][nc] = ccost;
                    }
                }
            }
            if(cv == 2) {
                int nr = cr;
                int nc = cc - 1;
                if(nc >= 0) {
                    if(dist[nr][nc] > ccost) {
                        q.offer(new Pair(nr, nc, grid[nr][nc] , ccost));
                        dist[nr][nc] = ccost;
                    }
                }
            }
            if(cv == 3) {
                int nr = cr + 1;
                int nc = cc;
                if(nr < n) {
                    if(dist[nr][nc] > ccost) {
                        q.offer(new Pair(nr, nc, grid[nr][nc] , ccost));
                        dist[nr][nc] = ccost;
                    }
                }
            }
            if(cv == 4) {
                int nr = cr - 1;
                int nc = cc;
                if(nr >= 0) {
                    if(dist[nr][nc] > ccost) {
                        q.offer(new Pair(nr, nc, grid[nr][nc] , ccost));
                        dist[nr][nc] = ccost;
                    }
                }
            }
            for(int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(dist[nr][nc] > ccost + 1) {
                        q.offer(new Pair(nr, nc, grid[nr][nc] , ccost + 1));
                        dist[nr][nc] = ccost + 1;
                    }
                }
            }
        }
        return Math.min(min, dist[n - 1][m - 1]);
    }
}