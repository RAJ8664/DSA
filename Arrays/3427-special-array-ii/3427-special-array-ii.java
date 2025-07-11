class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
         int n = nums.length;
        boolean[] ans = compute(nums);
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (ans[i] ? 1 : 0);
        }

        
        boolean[] results = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) {
                results[i] = true;
            } else {
                int req = v - u;
                int current = prefix[v] - prefix[u];
                results[i] = (current == req);
            }
        }

        return results;
    
    }
    
    public static boolean[] compute(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n];
        for (int i = 1; i < n; i++) {
            res[i] = (nums[i] % 2) != (nums[i - 1] % 2);
        }
        return res;
    }
}