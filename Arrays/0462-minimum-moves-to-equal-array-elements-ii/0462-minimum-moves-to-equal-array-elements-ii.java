class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return solve(nums, nums[n / 2]);
    }
    private int solve(int arr[], int target) {
        int res = 0;
        for (int ele : arr) res += Math.abs(target - ele);
        return res;
    }
}