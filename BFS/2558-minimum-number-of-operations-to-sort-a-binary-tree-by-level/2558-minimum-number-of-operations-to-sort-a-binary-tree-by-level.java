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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            int ans[] = new int[len];
            int k = 0;
            for(int i = 0; i < len; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                ans[k++] = q.poll().val;
            }
            res += find(ans);
        }
        return res;
    }
    public static int find(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        for(int i = 0; i < n; i++) temp[i] = arr[i];
        Arrays.sort(temp);
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(temp[i] != arr[i]) {
                count++;
                swap(arr, i, index(arr, temp[i]));
            }
        }
        return count;
    }
    private static int index(int arr[],int ele) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ele) return i;
        }
        return -1;
    } 
    private static void swap(int arr[],int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}