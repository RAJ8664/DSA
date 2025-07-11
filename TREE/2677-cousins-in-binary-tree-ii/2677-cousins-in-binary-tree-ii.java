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
    static class Pair {
        TreeNode current;
        int level;
        int val;
        TreeNode parent;
        int child;
        public Pair (TreeNode current, int level , int val, TreeNode parent, int child) {
            this.current = current;
            this.level = level;
            this.val = val;
            this.parent = parent;
            this.child = child;
        }
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, root.val, null, -1));
        ArrayList<Integer> level_sum = new ArrayList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        while (q.size() > 0) {
            int len = q.size();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode curr = q.peek().current;
                if (q.peek().current.left != null) {
                    q.offer(new Pair(q.peek().current.left, q.peek().level + 1, q.peek().current.left.val, q.peek().current, 0));
                    if (q.peek().current.right != null) map.put(q.peek().current.left, q.peek().current.right.val);
                    else map.put(q.peek().current.left, 0);
                }
                if (q.peek().current.right != null) {
                    q.offer(new Pair(q.peek().current.right, q.peek().level + 1, q.peek().current.right.val, q.peek().current, 1));
                    if (q.peek().current.left != null) map.put(q.peek().current.right, q.peek().current.left.val);
                    else map.put(q.peek().current.right, 0);
                }
                sum += q.peek().current.val;
                q.poll();
            }
            level_sum.add(sum);
        }     
        int current_level = 0;
        Queue<TreeNode> new_q = new LinkedList<>();
        new_q.offer(root);
        while (new_q.size() > 0) {
            int len = new_q.size();
            for (int i = 0; i < len; i++) {
                if (new_q.peek().left != null) {
                    new_q.offer(new_q.peek().left);
                }
                if (new_q.peek().right != null) {
                    new_q.offer(new_q.peek().right);
                }
                if (current_level == 0) {
                    new_q.peek().val = 0;
                    new_q.poll();
                }
                if (current_level != 0) {
                    int sum = 0;
                    sum += map.get(new_q.peek());
                    sum += new_q.peek().val;
                    int current_level_sum = level_sum.get(current_level);
                    new_q.peek().val = current_level_sum - sum;
                    new_q.poll();
                }
            }
            current_level++;
        }
        return root;
    }
}