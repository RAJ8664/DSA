class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int ans[] = new int[2];
        adj = new ArrayList<>();
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        int vis[] = new int[n + 1];
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            Arrays.fill(vis,0);
            if(cycle(edges[i][0], -1, vis) == true) return new int[]{edges[i][0], edges[i][1]};
         }
         return new int[]{0, 0};
    }
    private boolean cycle(int u, int par, int vis[]) {
        vis[u] = 1;
        boolean temp = false;
        for (int child : adj.get(u)) {
            if (vis[child] == 1 && child == par) continue;
            if (vis[child] == 1) return true;
            temp |= cycle(child, u, vis);
        }
        return temp;
    }
}