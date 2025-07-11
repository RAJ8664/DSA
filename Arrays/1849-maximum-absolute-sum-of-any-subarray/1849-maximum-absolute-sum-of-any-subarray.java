class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                maxi = Math.max(maxi, sum);
                if (sum + nums[i] < 0) sum = 0;
                else {
                    sum += nums[i];
                    maxi = Math.max(maxi, sum);
                }
            }
            else sum += nums[i];
        }
        if (sum > 0) maxi = Math.max(maxi, sum);
        sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                maxi = Math.max(maxi, sum);
                if (sum - nums[i] < 0) sum = 0; 
                else {
                    sum -= nums[i];
                    maxi = Math.max(maxi, sum);
                }
            }
            else sum += Math.abs(nums[i]);
        }
        if (sum > 0) maxi = Math.max(maxi, sum);
        return maxi;
    }
}