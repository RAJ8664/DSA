class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        if (sum - target < 0) return 0;
        else if ((sum - target) % 2 != 0) return 0;
        else{
            int target1 = (sum - target)  /  2;
            int dp[][] = new int[n + 1][target1 + 1];
            for (int temp[] : dp) Arrays.fill(temp, -1);
            return solve(n - 1, nums, target1, dp);
        }
    }
    private int solve(int ind, int arr[], int target, int dp[][]){
        if(ind == 0){
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int not_take = solve(ind - 1, arr, target, dp);
        int take = 0;
        if(arr[ind] <= target) take = solve(ind - 1, arr, target - arr[ind], dp);
        return dp[ind][target] = (take + not_take);
    }
}