class Solution {
    static class Pair {
        int row, col, distance;
        public Pair(int row, int col,int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int dir[][] = {{-1, 0} , {1, 0} , {0 , -1} , {0 , 1}};
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        int dist[][]  = new int[n + 1][m + 1];
        for(int current[] : dist) Arrays.fill(current , (int)(1e9));
        dist[0][0] = grid[0][0];
        pq.offer(new Pair(0 , 0 ,dist[0][0]));
        while(!pq.isEmpty()) {
            int cr = pq.peek().row;
            int cc = pq.peek().col;
            int cd = pq.peek().distance;
            pq.poll();
            for(int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if(nr < n && nc < m && nr >= 0 && nc >= 0) {
                    if(dist[nr][nc] > cd + grid[nr][nc]) {
                        dist[nr][nc] = cd + grid[nr][nc];
                        pq.offer(new Pair(nr, nc, dist[nr][nc]));
                    }
                }
            }

        }
        if(dist[n - 1][m - 1] == (int)(1e9)) return -1;
        return dist[n - 1][m - 1];
    }
}