class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private int dp[];
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        adj = new ArrayList<>();
        dp = new int[n + 1];
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (i == nums[i]) continue;
            adj.get(i).add(nums[i]);
        }
        int maxi = 0;
        int vis[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) dfs(i, -1, vis);
        }
        for (int i = 0; i < n; i++) maxi = Math.max(maxi, dp[i]);
        return maxi + 1;
    }
    private void dfs(int u, int par, int vis[]) {
        vis[u] = 1;
        for (int v : adj.get(u)) {
            if (vis[v] == 0) {
                dfs(v, u, vis);
                dp[u] = Math.max(dp[u], 1 + dp[v]);
            }
        }
    }
}