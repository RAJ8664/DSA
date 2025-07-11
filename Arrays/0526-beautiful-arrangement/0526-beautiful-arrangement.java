class Solution {
    private int ans;
    public int countArrangement(int n) {
        ans = 0;
        int vis[] = new int[n + 1];
        solve(vis, n, 1);
        return ans;
    }
    private void solve(int vis[], int n, int curr_num) {
        if (curr_num == n + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (curr_num % i == 0 || i % curr_num == 0) {
                    vis[i] = 1;
                    solve(vis, n, curr_num + 1);
                    vis[i] = 0;
                }
            }
        }
    }
}
