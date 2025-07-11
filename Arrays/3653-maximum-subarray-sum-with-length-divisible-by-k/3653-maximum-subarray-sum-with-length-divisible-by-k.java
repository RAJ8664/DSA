class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        long pre = 0, maxi = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            long current = j % k;
            if (!map.containsKey(current)) map.put(current, pre);
            else map.put(current, Math.min(map.get(current), pre));
            pre += nums[j];
            long to_check = ((j % k) + (1 % k) + k) % k;
            if (map.containsKey(to_check)) maxi = Math.max(maxi, pre - map.get(to_check));
        }
        return maxi;
    }
}