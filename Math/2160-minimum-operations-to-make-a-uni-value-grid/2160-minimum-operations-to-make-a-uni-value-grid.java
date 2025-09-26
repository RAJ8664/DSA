class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1) return 0;
        int mod = grid[0][0] % x;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % x != mod) return -1;
            }
        }   

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) res.add(grid[i][j]);
        }
        Collections.sort(res);
        int req = res.get(res.size() / 2);
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = grid[i][j];
                total += Math.abs(current - req) / x;
            }
        }
        return total;
    }
}