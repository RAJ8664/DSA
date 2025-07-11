class Solution {
    public int minOperations(int[] nums) {
        /*
            1 0 0 1 0 0
            1 1 1 0 0 0
            1 1 1 1 1 1
        
        */
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) continue;
            if (i + 2 < n) {
                count++;
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) return -1;
        }
        return count;
    }
}