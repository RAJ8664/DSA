class Solution {
    static class Pair {
        int value, row, col;
        public Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "(" + value + " " + row + " " + col + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(first.value, second.value);
        }
    }
    public int trapRainWater(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new custom_sort());
        int vis[][] = new int[n][m];
        for (int j = 0; j < m; j++) {
            vis[0][j] = 1;
            pq.offer(new Pair(arr[0][j], 0, j));
        }
        for (int i = 0; i < n; i++) {
            vis[i][m - 1] = 1;
            pq.offer(new Pair(arr[i][m - 1], i, m - 1));
        }
        for (int i = 0; i < n; i++) {
            vis[i][0] = 1;
            pq.offer(new Pair(arr[i][0], i, 0));
        }
        for (int j = 0; j < m; j++) {
            vis[n - 1][j] = 1;
            pq.offer(new Pair(arr[n - 1][j], n - 1, j));
        }
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (pq.size() > 0) {
            int cr = pq.peek().row;
            int cc = pq.peek().col;
            int cval = pq.peek().value;
            pq.poll();
            for (int dire[] : dir) {
                int nr = cr + dire[0];
                int nc = cc + dire[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    res += Math.max(0, cval - arr[nr][nc]);
                    pq.offer(new Pair(Math.max(cval, arr[nr][nc]), nr, nc));
                }
            }
        }
        return res;
    }
}