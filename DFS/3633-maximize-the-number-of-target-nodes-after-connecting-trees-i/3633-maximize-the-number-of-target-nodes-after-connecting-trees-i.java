import java.util.ArrayList;

class Solution {
    private ArrayList<ArrayList<Integer>> adj1;
    private ArrayList<ArrayList<Integer>> adj2;
    private int depth[];
    private int res[];

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length, m = edges2.length;
        adj1 = new ArrayList<>();
        adj2 = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++)
            adj1.add(new ArrayList<>());
        for (int i = 0; i <= m + 1; i++)
            adj2.add(new ArrayList<>());
        for (int i = 0; i < edges1.length; i++) {
            int u = edges1[i][0], v = edges1[i][1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }
        for (int i = 0; i < edges2.length; i++) {
            int u = edges2[i][0], v = edges2[i][1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }
        depth = new int[m + 2];
        res = new int[n + 1];
        int find2 = 0;
        for (int i = 0; i <= m; i++) {
            depth = new int[m + 2];
            find2 = Math.max(find2, find2(i, k - 1, -1));
        }
        for (int i = 0; i <= n; i++) {
            depth = new int[n + 2];
            res[i] = find1(i, k, -1) + find2;
        }
        return res;
    }

    private int find1(int u, int k, int par) {
        if (depth[u] > k)
            return 0;
        int res = 1;
        for (int v : adj1.get(u)) {
            if (v != par) {
                depth[v] = 1 + depth[u];
                res += find1(v, k, u);
            }
        }
        return res;
    }

    private int find2(int u, int k, int par) {
        if (depth[u] > k)
            return 0;
        int res = 1;
        for (int v : adj2.get(u)) {
            if (v != par) {
                depth[v] = 1 + depth[u];
                res += find2(v, k, u);
            }
        }
        return res;
    }
}