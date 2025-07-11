class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        HashMap<Integer,Integer> row = new HashMap<>();
        HashMap<Integer,Integer> col = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    row.put(i,row.getOrDefault(i,0) + 1);
                    col.put(j,col.getOrDefault(j,0) + 1);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    if(row.containsKey(i) && row.get(i) > 1) count++;
                    else if(col.containsKey(j) && col.get(j) > 1) count++;
                }
            }
        }
        return count;
    }
}