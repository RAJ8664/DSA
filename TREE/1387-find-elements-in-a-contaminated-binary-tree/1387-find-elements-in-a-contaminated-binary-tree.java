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
class FindElements {
    private TreeNode new_root;
    private HashSet<Integer> set;
    public FindElements(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        new_root = new TreeNode(0);
        set = new HashSet<>();
        q.offer(new_root);
        q1.offer(root);
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode current = q.peek();
                int val = q.peek().val;
                set.add(val);
                if (q1.peek().left != null) {
                    current.left = new TreeNode(val * 2 + 1);
                    q.offer(current.left);
                    q1.offer(q1.peek().left);
                    set.add(val * 2 + 1);
                }
                if (q1.peek().right != null) {
                    current.right = new TreeNode(val * 2 + 2);
                    q.offer(current.right);
                    q1.offer(q1.peek().right);
                    set.add(val * 2 + 2);
                }
                q.poll();
                q1.poll();
            }
        }
    }
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */