class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int mini = nums[0];
        for (int i = 1; i < n; i++) mini = Math.min(mini, nums[i]);
        int res = 0;
        for (int ele : nums) res += ele - mini;
        return res;
    }
}