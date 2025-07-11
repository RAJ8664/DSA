class Solution {
    static class Pair {
        int val, ind;
        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
        @Override
        public String toString() {
            return "(" + val + " " + ind + ")";
        }
    }
    static class Tuple {
        int row, col, val;
        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public String toString() {
            return "(" + row + " " + col + " " + val + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(first.val, second.val);
        }
    }
    static class custom_sort1 implements Comparator<Tuple> {
        @Override
        public int compare(Tuple first, Tuple second) {
            return Integer.compare(first.val, second.val);
        }
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        ArrayList<Pair> sorted_queries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) sorted_queries.add(new Pair(queries[i], i));
        Collections.sort(sorted_queries, new custom_sort());
        int res[] = new int[queries.length];
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new custom_sort1());
        int vis[][] = new int[n + 1][m + 1];
        vis[0][0] = 1;
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.offer(new Tuple(0, 0, grid[0][0]));
        int count = 0, current_ind = 0;
        while (current_ind < queries.length) {
            while (pq.size() > 0 && pq.peek().val < sorted_queries.get(current_ind).val) {
                count++;
                int cr = pq.peek().row;
                int cc = pq.peek().col;
                int cval = pq.peek().val;
                pq.poll();
                for (int dire[] : dir) {
                    int nr = cr + dire[0];
                    int nc = cc + dire[1];
                    if (nr < n && nr >= 0 && nc < m && nc >= 0 && vis[nr][nc] == 0) {
                        vis[nr][nc] = 1;
                        pq.offer(new Tuple(nr, nc, grid[nr][nc]));
                    }
                }
            }
            res[sorted_queries.get(current_ind).ind] = count;
            current_ind++;
        }
        return res;
    }
}