/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private int depth[];
    private ArrayList<Integer> tour;
    private int first[];
    private int last[];
    public int[] treeQueries(TreeNode root, int[] queries) {
        Build_Graph(root);
        depth = new int[(int)(1e5 + 1)];
        tour = new ArrayList<>();
        first = new int[(int)(1e5 + 1)];
        last = new int[(int)(1e5 + 1)];
        Arrays.fill(first, -1); Arrays.fill(last, -1);

        Euler_Dfs(root.val, 0);
        for (int i = 0; i < tour.size(); i++) {
            if (first[tour.get(i)] == -1) first[tour.get(i)] = i;
            else last[tour.get(i)] = i;
        }

        int maxi_pref[] = new int[tour.size() + 1];
        int maxi_suff[] = new int[tour.size() + 1];
        int maxi = 0;
        for (int i = 0; i < tour.size(); i++) {
            int current = depth[tour.get(i)];
            maxi = Math.max(maxi, current);
            maxi_pref[i] = maxi;
        }

        maxi = 0;
        for (int i = tour.size() - 1; i >= 0; i--) {
            int current = depth[tour.get(i)];
            maxi = Math.max(maxi, current);
            maxi_suff[i] = maxi;
        }

        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int left = first[node];
            int right = last[node];
            int current_maxi = 0;
            if (left - 1 >= 0) current_maxi = Math.max(current_maxi, maxi_pref[left - 1]);
            if (right + 1 < tour.size()) current_maxi = Math.max(current_maxi, maxi_suff[right + 1]);
            res[i] = current_maxi;
        }
        return res;
    }

    private void Euler_Dfs(int u , int par) {
        tour.add(u);
        for (int v : adj.get(u)) {
            if (v != par) {
                depth[v] = 1 + depth[u];
                Euler_Dfs(v, u);
            }
        }
        tour.add(u);
    }

    private void Build_Graph(TreeNode root) {
        adj = new ArrayList<>();
        for (int i = 0; i <= (int)(1e5 + 1); i++) adj.add(new ArrayList<>());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int u = q.peek().val;
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                    int v = q.peek().left.val;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                    int v = q.peek().right.val;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                q.poll();
            }
        }
    }
}