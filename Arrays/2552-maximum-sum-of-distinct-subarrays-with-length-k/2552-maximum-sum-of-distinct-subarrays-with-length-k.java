class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxi_sum = 0, current_sum = 0;
        for (int i = 0; i < k; i++) {
            current_sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() == k) maxi_sum = current_sum;
        int start = 0;
        for (int i = k; i < n; i++) {
            current_sum += nums[i];
            current_sum -= nums[start];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[start], map.getOrDefault(nums[start], 0) -1);
            if (map.getOrDefault(nums[start], 0) == 0) map.remove(nums[start]);
            if (map.size() == k) maxi_sum = Math.max(maxi_sum, current_sum);
            start++;
        }
        return maxi_sum;
    }
}