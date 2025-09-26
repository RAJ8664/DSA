class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxi = nums[n - 1] , mini = nums[0], res = maxi - mini;
        for (int i = 0; i < n - 1; i++) {
            maxi = Math.max(maxi, nums[i] + 2 * k);
            mini = Math.min(nums[i + 1], nums[0] + 2 * k);
            res = Math.min(res, maxi - mini);
        }
        return res;
    }
}