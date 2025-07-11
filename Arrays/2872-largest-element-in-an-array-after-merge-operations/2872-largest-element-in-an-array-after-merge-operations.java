class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long currentMaxi = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= currentMaxi)
                currentMaxi += nums[i];
            else
                currentMaxi = nums[i];
        }
        return currentMaxi;
    }
}