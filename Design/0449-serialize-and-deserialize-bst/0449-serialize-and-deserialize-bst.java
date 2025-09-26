/**
    Definition for a binary tree node.
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
*/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        String res = "";
        res += root.val;
        res += ":";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                    res += q.peek().left.val;
                    res += ":";
                } else {
                    res += "-100000";
                    res += ":";
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                    res += q.peek().right.val;
                    res += ":";
                } else {
                    res += "-100000";
                    res += ":";
                }
                q.poll();
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<Integer> res = new ArrayList<>();
        String current = "";
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ':') {
                int x = Integer.parseInt(current);
                current = "";
                res.add(x);
            } else
                current += data.charAt(i);
        }
        if (res.size() == 0)
            return null;
        TreeNode root = new TreeNode(res.get(0));
        int current_ind = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            TreeNode current_node = q.poll();
            int left = -100000, right = -100000;
            if (current_ind < res.size())
                left = res.get(current_ind++);
            if (current_ind < res.size())
                right = res.get(current_ind++);
            if (left == -100000)
                current_node.left = null;
            else {
                current_node.left = new TreeNode(left);
                q.offer(current_node.left);
            }
            if (right == -100000)
                current_node.right = null;
            else {
                current_node.right = new TreeNode(right);
                q.offer(current_node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
