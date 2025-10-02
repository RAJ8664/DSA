class Solution {
    public TreeNode recoverFromPreorder(String S) {
        int n = S.length();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int i = 0;
        while(i < n) {
            int curLevel = 0, num = 0;
            while(i < S.length() && S.charAt(i) == '-') {
                ++curLevel;
                ++i;
            }
            while(i < n && S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                num = num * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode current = new TreeNode(num);
            map.put(curLevel, current);
            if(curLevel > 0) {
                TreeNode parent = map.get(curLevel - 1);
                if(parent.left == null) parent.left = current;
                else parent.right = current;
            }
        }
        return map.get(0);
    }
}