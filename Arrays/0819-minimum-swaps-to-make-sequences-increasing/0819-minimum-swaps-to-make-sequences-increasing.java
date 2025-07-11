import java.util.Arrays;

class Solution {
    private int dp[][];
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        dp = new int[n + 1][2];
        for (int current[] : dp)
            Arrays.fill(current, -1);
        return solve(nums1, nums2, -1, -1, 0, 0);
    }
    private int solve(int arr[], int brr[], int prevA, int prevB, int ind, int swap) {
        if (ind >= arr.length)
            return 0;
        if (dp[ind][swap] != -1)
            return dp[ind][swap];

        int mini = Integer.MAX_VALUE / 10;
        if (arr[ind] > prevA && brr[ind] > prevB)
            mini = Math.min(mini, 0 + solve(arr, brr, arr[ind], brr[ind], ind + 1, 0));
        if (arr[ind] > prevB && brr[ind] > prevA)
            mini = Math.min(mini, 1 + solve(arr, brr, brr[ind], arr[ind], ind + 1, 1));

        return dp[ind][swap] = mini;
    }
}