class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 1;
        int freq[] = new int[(int)(1e6)];
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            freq[Math.max(0, current - k)]++;
            freq[current + k + 1]--;
        }
        int sum = 0, maxi = 0;
        for (int ele : freq) {
            sum += ele;
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}