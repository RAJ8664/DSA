class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sumAdd = 0, current_ans = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1) sumAdd += nums[i];
            current_ans += nums[i] * i;
        }
        int maxi = current_ans;
        for (int i = n - 1; i >= 0; i--) {
            current_ans -= nums[i] * (n - 1);
            current_ans += sumAdd;
            sumAdd += nums[i];
            if (i - 1 >= 0) sumAdd -= nums[i - 1];
            maxi = Math.max(maxi, current_ans);
        }
        return maxi;
    }
}