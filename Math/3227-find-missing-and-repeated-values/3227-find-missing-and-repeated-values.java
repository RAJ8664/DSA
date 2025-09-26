class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freq[] = new int[n * n + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                freq[grid[i][j]]++;
            }
        }
        int rep = -1, miss = -1;
        for(int i = 1; i <= n * n; i++) {
            if(freq[i] == 0) miss = i;
            if(freq[i] == 2) rep = i;
        }
        int ans[] = new int[2];
        ans[0] = rep;
        ans[1] = miss;
        return ans;
    }
}