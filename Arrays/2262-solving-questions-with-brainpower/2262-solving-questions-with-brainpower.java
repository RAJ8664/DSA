class Solution {
    private long dp[];
    public long mostPoints(int[][] arr) {
        int n = arr.length;
        dp = new long[n + 1];
        Arrays.fill(dp, -1l);
        return solve(0, arr);
    }
    public long solve(int ind, int arr[][]){
        if (ind >= arr.length) return 0;
        if (dp[ind] != -1) return dp[ind];
        long take = arr[ind][0] + solve(ind + arr[ind][1] + 1, arr);
        long not_take = solve(ind + 1, arr);
        return dp[ind] = Math.max(take, not_take);
    }
}