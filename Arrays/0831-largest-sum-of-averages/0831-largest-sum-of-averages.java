class Solution {
    private double dp[][];
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        dp = new double[n + 1][k + 1];
        for (double current[] : dp) Arrays.fill(current, Double.MIN_VALUE / 10.0);
        return solve(0, k, nums);
    }
    private double solve(int ind, int k, int arr[]) {
        if (ind == arr.length) return 0;
        if (dp[ind][k] != Double.MIN_VALUE / 10.0) return dp[ind][k];
        double sum = 0;
        if (k == 1) {
            for (int i = ind; i < arr.length; i++) sum += arr[i];
            return dp[ind][k] = sum / (arr.length - ind);
        }
        double maxi = 0.0, count = 0.0;
        for (int i = ind; i < arr.length; i++) {
            sum += arr[i];
            count++;
            double current = sum / count;
            maxi = Math.max(maxi, current + solve(i + 1, k - 1, arr));
        }
        return dp[ind][k] = maxi;
    }
}