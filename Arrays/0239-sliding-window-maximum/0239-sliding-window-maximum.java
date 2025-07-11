class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        int p = 0, left = 0;;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            set.add(nums[i]);
        }
        res[p++] = set.last();
        for (int i = k; i < n; i++) {
            map.put(nums[left] , map.getOrDefault(nums[left], 0) - 1);
            if (map.getOrDefault(nums[left], 0) == 0) set.remove(nums[left]);
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            set.add(nums[i]);
            res[p++] = set.last();
            left++;
        }
        return res;
    }
}