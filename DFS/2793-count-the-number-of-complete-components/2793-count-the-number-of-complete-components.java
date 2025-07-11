class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int current[] : edges) {
            int u = current[0], v = current[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i,adj,vis,temp);
                if (temp.size() == 1) count++;
                else {
                    boolean flag = true;
                    for (int l = 0; l < temp.size(); l++) {
                        int current = temp.get(l), p = adj.get(current).size();
                        if (p != temp.size() - 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true) count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int u, ArrayList<ArrayList<Integer>> adj, int vis[], ArrayList<Integer> res) {
        vis[u] = 1;
        res.add(u);
        for (int child : adj.get(u)) {
            if (vis[child] == 0) dfs(child, adj, vis, res);
        }
    }
}