class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int current[] : edges) {
            int u = current[0];
            int v = current[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        if(n == 1) {
            if(values[0] % k == 0) return 1;
            else return 0;
        }
        int count = 0;
        long res[] = new long[n + 1];
        dfs(1,-1, adj, values,res);
        for(int i = 0; i < n; i++) {
            if(res[i] % k == 0) count++;
        }
        return count;
    }
    public static void dfs(int u, int par, ArrayList<ArrayList<Integer>> adj, int values[], long res[]) {
        if(adj.get(u).size() == 1 && u != 1) {
            res[u] = values[u];
            return;
        }
        for(int v : adj.get(u)) {
            if(v != par) dfs(v, u , adj, values,res);
        }
        for(int v : adj.get(u)) {
            if(v != par) res[u] += res[v];
        }
        res[u] += values[u];
    }
}