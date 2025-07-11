import java.util.Arrays;

class Solution {
    private int mod = (int)(1e9 + 7);
    private long dp[][];
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long totalWays = 1;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalWays = (totalWays * 2) % mod;
            totalSum += nums[i];
        }

        if (totalSum < 2 * k)
            return 0;
        dp = new long[n + 1][k + 1];
        for (long current[] : dp)
            Arrays.fill(current, -1);

        long count = solve(0, 0, nums, k);
        long res = (totalWays - 2 * count % mod + mod) % mod;

        return (int)(res);
    }

    private long solve(int ind, int sum, int arr[], int k) {
        if (ind >= arr.length) {
            if (sum < k)
                return 1;
            return 0;
        }

        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        long op1 = solve(ind + 1, sum, arr, k);
        long op2 = 0;
        if (sum + arr[ind] <= k)
            op2 = solve(ind + 1, sum + arr[ind], arr, k);

        return dp[ind][sum] = (op1 + op2) % mod;
    }
}