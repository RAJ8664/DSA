class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) count++;
        }
        if (nums[n - 1] > nums[0]) count++;
        return count <= 1;
    }
}