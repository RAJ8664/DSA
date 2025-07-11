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
    private int cost[];
    private int dp1[];
    private int dp2[];
    public int rob(TreeNode root) {
        build_tree(root);
        //dp1 = taking value at node i;
        //dp2 = not taking value at node i;
        dp1 = new int[(int)(1e4) + 1];
        dp2 = new int[(int)(1e4) + 1];
        dfs(1, -1);
        return Math.max(dp1[1] , dp2[1]);
    }
    private void dfs(int u , int par) {
        if (adj.get(u).size() == 1 && u != 1) {
            dp1[u] = cost[u];
            dp2[u] = 0;
            return;
        }
        for (int v : adj.get(u)) {
            if (v != par) {
                dfs(v, u);
                dp2[u] += Math.max(dp1[v] , dp2[v]);
                dp1[u] += dp2[v];
            }
        }
        dp1[u] += cost[u];
    }
    private void build_tree(TreeNode root) {
        adj = new ArrayList<>();
        cost = new int[(int)(1e5) + 1];
        HashMap<TreeNode, Integer> map1 = new HashMap<>();
        for (int i = 0; i <= (int)(1e4 + 1); i++) adj.add(new ArrayList<>());
        int id = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if (!map1.containsKey(q.peek())) {
                    map1.put(q.peek(), id);
                    id++;
                } 
                int u = map1.get(q.peek());
                cost[u] = q.peek().val;
                if (q.peek().left != null) {
                    map1.put(q.peek().left, id);
                    int v = id;
                    cost[v] = q.peek().left.val;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                    id++;
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    map1.put(q.peek().right, id);
                    int v = id;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                    cost[v] = q.peek().right.val;
                    id++;
                    q.offer(q.peek().right);
                }
                q.poll();
            }
        }
    }
}
