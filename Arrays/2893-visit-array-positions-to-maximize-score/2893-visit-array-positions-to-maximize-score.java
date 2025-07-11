import java.util.Arrays;

class Solution {
    private long dp[][];
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        dp = new long[n][2];
        for (long current[] : dp)
            Arrays.fill(current, -1);
        return nums[0] + solve(1, nums[0] % 2, nums, x);
    }
    private long solve(int ind, int parity, int arr[], int x) {
        if (ind >= arr.length)
            return 0;
        if (dp[ind][parity] != -1)
            return dp[ind][parity];

        long op1 = 0, op2 = 0;
        op1 = solve(ind + 1, parity, arr, x);
        if (arr[ind] % 2 == parity)
            op2 = arr[ind] + solve(ind + 1, parity, arr, x);
        else
            op2 = arr[ind] - x + solve(ind + 1, 1 - parity, arr, x);

        return dp[ind][parity] = Math.max(op1, op2);
    }
}