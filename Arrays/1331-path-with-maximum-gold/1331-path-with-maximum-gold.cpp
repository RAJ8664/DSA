class Solution {
public:
    int find(vector<vector<int>>& grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() || grid[i][j] == 0) {
            return 0;
        }
        
        int gold = grid[i][j];
        grid[i][j] = 0;  
        
        int a = find(grid, i + 1, j);
        int b = find(grid, i - 1, j);
        int c = find(grid, i, j + 1);
        int d = find(grid, i, j - 1);
        
        grid[i][j] = gold;  
        return gold + max({a, b, c, d});
    }

    int getMaximumGold(vector<vector<int>>& grid) {
        int maxgold = 0;
        
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] != 0) {
                    maxgold = max(maxgold, find(grid, i, j));
                }
            }
        }
        
        return maxgold;
    }
};