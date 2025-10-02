class Solution {
    public int findMaxForm(String[] strs, int zero, int one) {
        int n = strs.length;
        int dp[][][] = new int[n + 1][zero + 1][one + 1];
        for (int current[][] : dp) for (int current1[] : current) Arrays.fill(current1, -1);
        int res = solve(0, strs, 0, 0, dp, zero, one);
        return res;
    }
    static int solve(int ind, String arr[] , int zero, int one, int dp[][][], int max_zero, int max_one) {
        if (ind >= arr.length) return 0;
        if (dp[ind][zero][one] != -1) return dp[ind][zero][one];
        int count0 = 0, count1 = 0, op1 = 0, op2 = 0;
        String current = arr[ind];
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == '0') count0++;
            else count1++;
        }
        if (zero + count0 <= max_zero && one + count1 <= max_one) op1 = 1 + solve(ind + 1, arr, zero + count0 , one + count1 , dp, max_zero, max_one);
        op2 = solve(ind + 1, arr, zero, one, dp, max_zero, max_one);
        return dp[ind][zero][one] = Math.max(op1, op2);
    }
}
