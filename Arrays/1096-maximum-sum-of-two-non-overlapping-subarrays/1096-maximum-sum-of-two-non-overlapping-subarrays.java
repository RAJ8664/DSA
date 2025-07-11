class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int current_maxi = 0, current_sum = 0, start = 0;
        for (int i = 0; i < firstLen; i++) current_sum += nums[i];
        if (firstLen + secondLen < n) current_maxi = Math.max(current_maxi, current_sum + solve(nums, firstLen + 1, n - 1, secondLen));
        for (int i = firstLen; i < n; i++) {
            current_sum += nums[i];
            current_sum -= nums[start++];
            if (start >= secondLen) current_maxi = Math.max(current_maxi, current_sum + solve(nums, 0, start - 1, secondLen));
            if (i + 1 + secondLen < n) current_maxi = Math.max(current_maxi, current_sum + solve(nums, i + 1, n - 1, secondLen));
        }
        return current_maxi;
    }
    private int solve(int arr[] , int low, int high, int len) {
        int maxi_sum = 0, current_sum = 0, start = low;
        for (int i = low; i < low + len; i++) current_sum += arr[i];
        maxi_sum = Math.max(maxi_sum , current_sum);
        for (int i = low + len; i <= high; i++) {
            current_sum += arr[i];
            current_sum -= arr[start++];
            maxi_sum = Math.max(maxi_sum, current_sum);
        }
        return maxi_sum;
    }
}
