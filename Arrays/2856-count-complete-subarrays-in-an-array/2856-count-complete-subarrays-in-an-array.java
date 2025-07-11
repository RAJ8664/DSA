class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> req = new HashSet<>();
        for (int ele : nums) req.add(ele);
        int unique = req.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                int x = nums[j];
                set.add(x);
                if (set.size() == unique) count++;
            }
        }
        return count;
    }
}