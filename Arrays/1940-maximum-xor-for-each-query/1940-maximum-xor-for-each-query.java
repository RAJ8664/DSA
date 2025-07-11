class Solution {
    public int[] getMaximumXor(int[] nums, int k) {
        int n = nums.length;
        int x = (1 << k) - 1, y = 0;
        for (int ele : nums) y ^= ele;
        int a = y;
        for(int i = nums.length - 1; i >= 0; i--){
            a = nums[i];
            nums[i] = (x ^ y);
            y ^= a;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 -  i] = temp;
        }
        return nums;
    }
}