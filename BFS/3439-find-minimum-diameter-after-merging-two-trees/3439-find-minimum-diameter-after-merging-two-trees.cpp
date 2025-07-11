class Solution {
public:
    //why the same solution in java is giving tle; ????
    int minimumDiameterAfterMerge(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        vector<vector<int>> adj1(100007);
        vector<vector<int>> adj2(100007);
        for (auto& edge : edges1) {
            int u = edge[0], v = edge[1];
            adj1[u].push_back(v);
            adj1[v].push_back(u);
        }
        for (auto& edge : edges2) {
            int u = edge[0], v = edge[1];
            adj2[u].push_back(v);
            adj2[v].push_back(u);
        }
        if (edges1.empty() && edges2.empty()) return 1;
        if (edges1.empty()) {
            int d2 = findDiameter(adj2, edges2.size() + 1);
            if (edges2.size() == 1) return d2 + 1;
            else return d2;
        }
        if (edges2.empty()) {
            int d1 = findDiameter(adj1, edges1.size() + 1);
            if (edges1.size() == 1) return d1 + 1;
            else return d1;
        }
        int d1 = findDiameter(adj1, edges1.size() + 1);
        int d2 = findDiameter(adj2, edges2.size() + 1);
        int res = (d1 / 2) + (d2 / 2) + 1;
        if (d1 % 2 == 1) res++;
        if (d2 % 2 == 1) res++;
        res = max(res, d1);
        res = max(res, d2);
        return res;
    }
    int findDiameter(vector<vector<int>>& adj, int len) {
        int n = len;
        vector<int> depth(n + 1, 0);
        dfs(0, -1, adj, depth);
        int maxi = 0, node = -1;
        for (int i = 0; i <= n; ++i) {
            if (depth[i] > maxi) {
                maxi = depth[i];
                node = i;
            }
        }
        fill(depth.begin(), depth.end(), 0);
        dfs(node, -1, adj, depth);
        maxi = 0; node = - 1;
        for (int i = 0; i <= n; ++i) {
            if (depth[i] > maxi) {
                maxi = depth[i];
                node = i;
            }
        }
        return maxi;
    }
    void dfs(int u, int par, vector<vector<int>>& adj, vector<int>& depth) {
        for (int v : adj[u]) {
            if (v != par) {
                depth[v] = 1 + depth[u];
                dfs(v, u, adj, depth);
            }
        }
    }
};