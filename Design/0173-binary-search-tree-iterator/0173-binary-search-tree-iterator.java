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
class BSTIterator {
    private ArrayList<Integer> nodes;
    private int current_pointer = 0;
    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        Inorder(root);
    }
    public int next() {
        return nodes.get(current_pointer++);
    }
    public boolean hasNext() {
        if (current_pointer >= nodes.size()) return false;
        return true;
    }
    private void Inorder(TreeNode root) {
        if (root == null) return;
        Inorder(root.left);
        nodes.add(root.val);
        Inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
