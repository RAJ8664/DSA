class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long pref[] = new long[n];
        long suff[] = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pref[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            suff[i] = sum;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (pref[i] >= suff[i + 1]) count++;
        }
        return count;
    }
}