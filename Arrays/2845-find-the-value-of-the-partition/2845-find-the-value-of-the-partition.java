import java.util.Arrays;

class Solution {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++)
            mini = Math.min(mini, Math.max(nums[i], nums[i + 1]) - Math.min(nums[i], nums[i + 1]));
        return mini;
    }
}