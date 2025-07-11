class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                boolean valid = true;
                for (int k = 0; k < m; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int maxKept = 0;
        for (int val : dp) maxKept = Math.max(maxKept, val);
        return n - maxKept;  
    }
}
