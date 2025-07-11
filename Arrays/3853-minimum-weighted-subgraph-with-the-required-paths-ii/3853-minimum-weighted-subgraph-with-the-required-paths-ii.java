class Solution {
    static class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "(" + node + " " + weight + ")";
        }
    }
    private ArrayList<ArrayList<Pair>> adj;
    private int dp[][];
    private int depth[];
    private int vis[];
    private int pref[];
    private int res[];
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0] + 1, v = edge[1] + 1, wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        dp = new int[n + 1][19];
        depth = new int[n + 1];
        vis = new int[n + 1];
        dfs(1, 0);
        pref = new int[n + 1];
        build_pref(n);
        res = new int[queries.length];
        System.out.println(Arrays.toString(pref));
        for (int i = 0; i < queries.length; i++) {
            int src1 = queries[i][0] + 1, src2 = queries[i][1] + 1, dest = queries[i][2] + 1;
            int lca1 = lca(src1, dest), lca2 = lca(src2, dest), lca3 = lca(src1, src2);
            int dist1 = pref[src1] + pref[dest] - 2 * pref[lca1];
            int dist2 = pref[src2] + pref[dest] - 2 * pref[lca2];
            int dist3 = pref[src1] + pref[src2] - 2 * pref[lca3];
            res[i] = (dist1 + dist2 + dist3) / 2;
        }
        return res;
    }
    private void build_pref(int n) {
        pref[1] = 0;
        vis = new int[n + 1];
        vis[1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (q.size() > 0) {
            int curr_node = q.peek();
            int curr_dist = pref[curr_node];
            q.poll();
            for (int i = 0; i < adj.get(curr_node).size(); i++) {
                int child_node = adj.get(curr_node).get(i).node;
                int child_weight = adj.get(curr_node).get(i).weight;
                if (vis[child_node] == 0) {
                    vis[child_node] = 1;
                    pref[child_node] = child_weight + curr_dist;
                    q.offer(child_node);
                } 
            }
        }
    }
    private int find_kth_parent(int u, int k) {
        int count = 0;
        while (k > 0) {
            if (k % 2 == 1) u = dp[u][count];
            count++;
            k >>= 1;
        }
        return u;
    }
    private int lca(int u, int v) {
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[v] - depth[u];
        v = find_kth_parent(v, diff);
        if (u == v) return u;
        for (int i = 18; i >= 0; i--) {
            if (dp[u][i] != dp[v][i]) {
                u = dp[u][i];
                v = dp[v][i];
            }
        }
        return dp[u][0];
    }
    private void dfs(int u, int par) {
        vis[u] = 1;
        dp[u][0] = par;
        for (int i = 1; i < 19; i++) dp[u][i] = dp[dp[u][i - 1]][i - 1];
        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i).node;
            if (vis[v] == 0) {
                depth[v] = 1 + depth[u];
                dfs(v, u);                
            }
        }
    }
}