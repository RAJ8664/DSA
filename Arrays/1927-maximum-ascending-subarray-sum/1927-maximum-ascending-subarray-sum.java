class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) sum += nums[i];
            if (i > 0 && nums[i] > nums[i - 1]) sum += nums[i];
            else sum = nums[i];
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}