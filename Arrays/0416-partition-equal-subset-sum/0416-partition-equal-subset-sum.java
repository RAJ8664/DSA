class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int ele : nums) sum += ele;
        if (sum % 2 == 1) return false;
        else{
            int target = sum / 2;
            int dp[][] = new int[n + 1][target + 1];
            for(int temp[] : dp) Arrays.fill(temp , -1);
            if (solve(n - 1, nums, target, dp) == 1) return true;
            return false;
        }
    }
    public static int solve(int ind , int arr[],int target, int dp[][]){
        if(target == 0) return 1;
        if(ind == 0){
            if (arr[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target] != -1)return dp[ind][target];
        int not_take = solve(ind - 1, arr ,target, dp);
        int take = 0;
        if(arr[ind] <= target){
            take = solve(ind - 1, arr, target - arr[ind],dp);
        }
        return dp[ind][target] = (take | not_take);
    }
}