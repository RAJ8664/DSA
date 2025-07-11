class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        long current_prod = 1, total = 0;
        for (int right = 0; right < n; right++) {
            current_prod *= nums[right];
            while (left < right && current_prod >= k) current_prod /= nums[left++];
            if (current_prod < k) total += (right - left + 1);
        }
        return (int)total;
    }
}